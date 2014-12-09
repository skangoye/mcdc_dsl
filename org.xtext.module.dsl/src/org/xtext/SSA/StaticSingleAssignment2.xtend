package org.xtext.SSA

import java.util.ArrayList
import java.util.HashMap
import java.util.List
import org.xtext.helper.BinaryTree
import org.xtext.helper.Couple
import org.xtext.helper.Triplet
import org.xtext.mcdc.MCDC_Statement
import org.xtext.moduleDsl.ADD
import org.xtext.moduleDsl.AND
import org.xtext.moduleDsl.COMPARISON
import org.xtext.moduleDsl.DIV
import org.xtext.moduleDsl.EQUAL_DIFF
import org.xtext.moduleDsl.EXPRESSION
import org.xtext.moduleDsl.MULT
import org.xtext.moduleDsl.NOT
import org.xtext.moduleDsl.OR
import org.xtext.moduleDsl.SUB
import org.xtext.moduleDsl.VarExpRef
import org.xtext.moduleDsl.bitConstant
import org.xtext.moduleDsl.boolConstant
import org.xtext.moduleDsl.enumConstant
import org.xtext.moduleDsl.hexConstant
import org.xtext.moduleDsl.intConstant
import org.xtext.moduleDsl.realConstant
import org.xtext.moduleDsl.strConstant

import static extension org.xtext.utils.DslUtils.*
import static extension org.eclipse.xtext.EcoreUtil2.*
import static extension org.xtext.type.provider.ExpressionsTypeProvider.*
import org.xtext.moduleDsl.ASSIGN_STATEMENT
import org.xtext.moduleDsl.CST_DECL


class StaticSingleAssignment2 {
	
	val private static final constTypePred = "c_" //Must precede constant types
	
	
	/**
	 * Perform a SSA notation form, on module paths variables names, and returns a map that maps an expression identifier( and its path ID)
	 * with the SSA informations associated to that identifier.
	 */
	def static staticSingleAssignmentOnPaths(List<List<Triplet<List<String>, List<String>, List<String>>>> modulePaths, MCDC_Statement mcdcStatement){
		
		//this map records the SSA expressions along the different paths.
		//the key of the map is an unique 'identifier' computed as follows: 'key = conditionIdent + @ + pathIdent'
		//the associated object is a couple where the first element is that assignment variable with SSA ident, and the second,
		//the expression in SSA that is assigned to the assignment variable
		val ssaExpressionsMap = new HashMap<String, Couple<String, BinaryTree<Triplet<String, String, String>>>>
		
		modulePaths.forEach[ 
			
			path, pathID | val defList = new ArrayList<Couple<String, String>> //definition list
			
			path.forEach[ 
				
				subPath | //Triplet < var_names, MCDC_values, identifiers>
				
				val identifier = subPath.third.extractIdentifier 
				val identifierIndex = subPath.third.extractIdentIndex // X, N, T or F
				val expression = mcdcStatement.getExpression(identifier, identifierIndex) //get the right expression
				
				val assignVar = subPath.first.get(0) //first element of the list represents assignment variable
				val assignCouple = new Couple(assignVar, "0")  //assignment var with SSA index '0' 
				
				if(assignVar == "*") { assignCouple.setSecond("") } //case where there is no assignment
				
				val bt = expression.toBTExpression() //transform to Binary Tree structure
				defList.updateBT(bt) //update Binary Tree SSA indexes
				defList.addBtVariables(bt) //add new variables defined in bt and not in defList

				defList.updateAssignCouple(assignCouple) //update SSA index of the assignment variable
				defList.updateDefList(assignCouple) //update defList with the above new assigned variable
				
				subPath.updateSubPath(assignCouple, bt, identifierIndex)//
				
				val ssaName = nameWithIndex(assignCouple) //get variable name in SSA form: (var_name + SSA_index)				
				
				//in fact, given an expression identifier, its SSA variables names may be different according to the path they come from
				// => so we add path ID to the expression identifier
				if(identifierIndex == "N"){
					val identwithIndex = (identifier + identifierIndex)
					val identAtPathID = identwithIndex.addPathID(pathID.toString) 
					if(!ssaExpressionsMap.containsKey(identAtPathID)){ val put = ssaExpressionsMap.put(identAtPathID, new Couple(ssaName, bt)) }
				}
				else{
					val identAtPathID = identifier.addPathID(pathID.toString)
					if(!ssaExpressionsMap.containsKey(identAtPathID)){ val put = ssaExpressionsMap.put(identAtPathID, new Couple(ssaName, bt)) }
				}
				
			]//forEach
		]//forEach

		return ssaExpressionsMap
	
	}//staticSingleAssignmentOnPaths
	
	
	/**
	 * Update Binary tree SSA indexes with the list that contains updated variable SSA indexes
	 */
	def static private void updateBT(List<Couple<String, String>> previousDefList, BinaryTree<Triplet<String,String, String>> bt){
		
		if(!bt.isEmpty()){ //bt is not empty
			if(bt.isLeaf){//leaf => variables or constant
				for(defCouple: previousDefList){ //couple< var_name, SSA_index> 
					if (bt.value.first == defCouple.first) {//var names match each other
						//set leaf variable SSA index with the one in the definition list
						bt.value.setSecond(defCouple.second)
						return
					}
				}	
			}
			else{//recursive call on its siblings
				previousDefList.updateBT(bt.left)
				previousDefList.updateBT(bt.right)
			}		
	   }//not empty
	
	}//updateBT

	
	/**
	 * Add in the definition list (DefList), all variables that are present in the Binary tree, and not in the definition list. 
	 */
	def static private void addBtVariables(List<Couple<String, String>> defList, BinaryTree<Triplet<String,String,String>> bt){
		
		if(!bt.isEmpty()){ //bt is not empty
			if(bt.isLeaf){ //leaf => variables or constant
				val index = bt.value.second //SSA index
				if ( index != "") {//variable
					val variable = bt.value.first
					if(!defList.hasElement(variable)){ //defList doesn't contain the variable
						defList.add( new Couple(variable, index) )
					}
				}
			}
			else{//recursive call on its siblings
				defList.addBtVariables(bt.left)
				defList.addBtVariables(bt.right)
			}
		}		
	
	}//addBtVariables
	
	
	/**
	 * Update the SSA index of an assignment variable. Typically, if a variable is assigned its SSA index is incremented 
	 */
	def static private void updateAssignCouple(List<Couple<String, String>> previousDefList, Couple<String,String> assignCouple){
		
		val assignVar = assignCouple.first
		
		if(assignVar != "*"){//new assignment
			previousDefList.forEach[ 
				defCouple | if (defCouple.first == assignVar){ //the variable being assigned is already in defList
					val newIndex = (defCouple.second.parseInt + 1) //increment its SSA index
					assignCouple.setSecond(newIndex.toString)
					return
				}
			]//forEach
		}
		else{// assignVar == "*"
			//nothing to do
		}
		
	}//updateAssignCouple
	
	
	/**
	 * Update the definition list with the new assigned variable SSA index
	 */
	def static private void updateDefList(List<Couple<String, String>> defList, Couple<String,String> assignCouple){
		
		val assignVar = assignCouple.first
		
		if(assignVar != "*"){//
			defList.forEach[ 
				defCouple | 
				if (defCouple.first == assignVar){ //variable name is already in defList
					// => update its SSA index in the defList 
					defCouple.setSecond(assignCouple.second)
					return
				}
			]//forEach
			
			//variable name is not in defList => Add new var name and its SSA index
			defList.add( new Couple(assignCouple.first, assignCouple.second))
		}
	
	}//updateDefList
	
	
	/**
	 * Substitute subPath variable names with theirs corresponding SSA names 
	 */
	def static void updateSubPath(Triplet<List<String>, List<String>, List<String>> subPath, Couple<String,String> assignCouple, BinaryTree<Triplet<String,String,String>> bt, String identifierIndex ) {
		
		if(identifierIndex == "N"){ //bt represents a non boolean expression 
			subPath.first.set(0, nameWithIndex(assignCouple)) //replace assignment var with its SSA var name
			subPath.second.set(0, bt.stringRepr) //replace assignment expression variables names with theirs corresponding SSA names
		}
		else{//bt represents a boolean expression 
			val boolCondsInBt =bt.boolConditionsInBT //Boolean conditions in the Binary tree bt
			if(identifierIndex == "X"){
				boolCondsInBt.add(0, nameWithIndex(assignCouple))// add assignment SSA var name to Boolean Conditions list
				subPath.setFirst(boolCondsInBt) //replace variables names with the SSA ones
			}
			else{ // T or F
				if(identifierIndex == "T" || identifierIndex == "F"){
					boolCondsInBt.add(0, "*")// first element is a star i.e no assignment variable
					subPath.setFirst(boolCondsInBt) //replace variables names with the SSA ones
				}
				else{
					throw new Exception("Unknown identifier index")
				}
			}
		}			
		
	} //updateSubPath
		
	
	/**
	 * Return the DSL expression associated with (identifier + identifier index) 
	 */
	def static private EXPRESSION getExpression( MCDC_Statement mcdcStatement, String identifier, String identifierIndex){
		
		if(identifierIndex == "N"){
			return mcdcStatement.getNonBoolExpression(identifier.parseInt)
		}
		else{
			if(identifierIndex == "T" || identifierIndex == "F" || identifierIndex == "X"){
				return mcdcStatement.getBoolExpression(identifier.parseInt)
			}
			else{
				throw new UnsupportedOperationException(" ##### unknown identifier index ##### ")
			}
		}
	
	}//getExpression
	
	/**
	 * Transform a module_dsl expression into a new binary tree structure (BinaryTree implementation)
	 * The value of the Binary tree is a triplet where the first parameter 
	 * represents either the operator name or a value (in the case that the expression being translated is a constant).
	 * The second parameter represents the SSA index and the third, the type of the operator, variable or constants. 
	 * constants' type are preceded with "c_" pattern
	 */
	def static private BinaryTree< Triplet<String,String,String> > toBTExpression(EXPRESSION expression){	
		val tmpTree = new BinaryTree<Triplet<String,String,String>>() //new empty tree
		toBTExpression(expression, tmpTree)
		
		return tmpTree
	}
	
	
	/**
	 * toBTExpression's private method. 
	 */
	def private static void toBTExpression(EXPRESSION expression, BinaryTree<Triplet<String,String,String>> bt){
		switch(expression){
			OR: {	
				bt.setTree(new BinaryTree< Triplet<String,String,String> >( new Triplet("OR", "", "bool")))
				expression.left.toBTExpression(bt.left)
				expression.right.toBTExpression(bt.right)
			}
			
			AND:{
				bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet("AND", "", "bool")))
				expression.left.toBTExpression(bt.left)
				expression.right.toBTExpression(bt.right)
			}
			
			NOT:{
				bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet("NOT", "", "bool")))
				bt.setLeft(new BinaryTree())
				expression.exp.toBTExpression(bt.right)
			}
			
			COMPARISON:{
				bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet(expression.op, "", "bool")))
				expression.left.toBTExpression(bt.left)
				expression.right.toBTExpression(bt.right)
			}
			
			EQUAL_DIFF:{
				bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet(expression.op, "", "bool")))
				expression.left.toBTExpression(bt.left)
				expression.right.toBTExpression(bt.right)
			}
			
			ADD:{
				bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet("+" , "", expression.left.typeFor)))
				expression.left.toBTExpression(bt.left)
				expression.right.toBTExpression(bt.right)
			}
			
			SUB:{
				bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet("-" , "", expression.left.typeFor)))
				expression.left.toBTExpression(bt.left)
				expression.right.toBTExpression(bt.right)
			}
			
			MULT:{
				bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet("*" , "", expression.left.typeFor)))
				expression.left.toBTExpression(bt.left)
				expression.right.toBTExpression(bt.right)
			}
			
			DIV:{
				bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet( "/" , "", expression.left.typeFor)))
				expression.left.toBTExpression(bt.left)
				expression.right.toBTExpression(bt.right)
			}
			
			VarExpRef:{
				val abstractVar = expression.vref
				if(abstractVar instanceof CST_DECL) {//constant
					val const = (abstractVar as CST_DECL)
					val type = constTypePred + expression.typeFor //must conform to constants type rule
					bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet(const.value.literalValue, "", type)))
				}
				else{//variable
					//set the SSA index to 0
					bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet(abstractVar.name, "0", expression.typeFor)))
				}			
			}
			
			intConstant: bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet(expression.value.toString, "", constTypePred + expression.typeFor)))
	  		
	  		realConstant: bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet(expression.value.toString, "", constTypePred + expression.typeFor)))
	  		
	  		strConstant: bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet(expression.value.toString, "", constTypePred + expression.typeFor)))
	  		
	  		enumConstant: {//check enumConstant's parent
	  			
	  			val comparator = expression.getContainerOfType(EQUAL_DIFF)
	  			val assignment = expression.getContainerOfType(ASSIGN_STATEMENT)
	  			
	  			var enumVarName = ""
	  			
	  			if(comparator != null){ //parent is a comparator, either "==" or "!="
	  				var enumVariable = comparator.left	  			
	  				if(enumVariable != expression){	enumVarName = (enumVariable as VarExpRef).vref.name }
	  				else{ enumVarName = (comparator.right as VarExpRef).vref.name  }
	  			}
	  			else{
	  				if(assignment != null){
	  					var enumVariable = assignment.left.variable
	  					enumVarName = enumVariable.name
	  				}
	  			}
	  			
	  			val enumVarName_Plus_EnumValue = enumVarName + "@" + expression.value.toString
	  			
	  			bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet(enumVarName_Plus_EnumValue, "", constTypePred + expression.typeFor)))
	  		}
	  		
	  		boolConstant: bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet(expression.value.toString, "", constTypePred + expression.typeFor)))
	  		
	  		bitConstant: bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet(expression.value.toString, "", constTypePred + expression.typeFor)))
	  		
	  		hexConstant: bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet(expression.value.toString, "", constTypePred + expression.typeFor)))
		}
	}//toBTExpression
	
	
	/**
	 * Return a list containing all conditions that get involved in the boolean expression,
	 * represented by the Binary tree
	 */
	def static private boolConditionsInBT(BinaryTree<Triplet<String,String,String>> bt){
		val listOfBoolVars = new ArrayList<String>
		boolConditionsInBT(bt, listOfBoolVars)
		return listOfBoolVars
	}//boolConditionsInBT
	
	def static private  void boolConditionsInBT(BinaryTree<Triplet<String,String,String>> bt, List<String> list){
		val btvalue = bt.value
		val operator = btvalue.first
		val index = btvalue.second
		
		switch(operator){
			case "OR": {
				bt.left.boolConditionsInBT(list)
				bt.right.boolConditionsInBT(list)
			}
				
			case "AND": {
				bt.left.boolConditionsInBT(list)
				bt.right.boolConditionsInBT(list)
			}
			
			case "XOR": {
				bt.left.boolConditionsInBT(list)
				bt.right.boolConditionsInBT(list)
			}
			
			case "NOT": {
				bt.right.boolConditionsInBT(list)
			}
			
			case "==": {
				list.add( bt.left.stringRepr + "==" + bt.right.stringRepr)
			}
			
			case "!=": {
				list.add( bt.left.stringRepr + "!=" + bt.right.stringRepr)
			}
			
			case "<": {
				list.add( bt.left.stringRepr + "<" + bt.right.stringRepr)
			}
			
			case ">": {
				list.add( bt.left.stringRepr + ">" + bt.right.stringRepr)
			}
			
			case "<=": {
				list.add( bt.left.stringRepr + "<=" + bt.right.stringRepr)
			}
			
			case ">=": {
				list.add( bt.left.stringRepr + ">=" + bt.right.stringRepr)
			}
			default:{ 
				if (index != ""){//variable
					val varName = operator
					list.add(nameWithIndex(new Couple(varName,index)))
				}
			}
		}
	}//boolConditionsInBT
	
	
	/**
	 * Return a string representation of the expression represented over the Binary tree
	 */
	def static String stringRepr(BinaryTree<Triplet<String,String,String>> bt){
		if(!bt.isEmpty()){
			if(!bt.isLeaf()){
				"(" + bt.left.stringRepr + bt.value.first + bt.right.stringRepr +")"
			}
			else{ //leaf
				val btValue = bt.value
				return nameWithIndex(new Couple(btValue.first, btValue.second))
			}//leaf
		}
	}//stringRepr
	
	
	/**
	 * Check whether or not, a given variable name is in the list.
	 */
	def static private boolean hasElement(List<Couple<String, String>> list, String variableName){
		for(elem: list){//the first parameter of a list element is a variable name
			val elemVarName = elem.first
			if(elemVarName == variableName){ return true }
		}
		return false
	}//hasElement
	
	
	/**
	 * Return a variable SSA name form: (var_name + "separator" + SSA_index + "separator"). The separator is represented
	 * by the pipe symbol "|" 
	 */
	def static private String nameWithIndex( Couple<String,String> value){
		val ident = value.second
		if(ident != ""){
			return value.first + "|" + value.second + "|"
		}
		else{
			return value.first
		}
	}//nameWithIndex
	
	
	/**
	 * Add for each identifier the path ID where it comes from
	 */
	def static private String addPathID(String ident, String pathID){
		return ident + "@" + pathID
	}//addPathID
	
	//	def static private void printModuleSSA(List<List< Triplet< Couple<String,String>, BinaryTree<Couple<String,String>>, String> >> moduleSsa){
//		moduleSsa.forEach[ 
//			list | System.out.println
//			System.out.println("{")
//			
//			list.forEach[ triplet | val assignTriplet = triplet.first val bt = triplet.second
//				System.out.print("[" + assignTriplet.first + "_" + assignTriplet.second + "]" + " := ") 
//				System.out.print("[" + bt.stringRepr + "] ")
//				System.out.print("=> [" + triplet.third ) System.out.println("] ")
//			]
//			
//			System.out.println("}")
//			
//		]
//	}

}//class