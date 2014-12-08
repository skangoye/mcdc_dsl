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
	
	def static staticSingleAssignmentOnPaths(List<List<Triplet<List<String>, List<String>, List<String>>>> modulePaths, MCDC_Statement mcdcStatement){
		
		//this map records the SSA expressions along the different paths.
		//the key of the map is an unique 'identifier' computed as follows: 'key = conditionIdent + @ + pathIdent'
		//the associated object is a couple where the first element is tha assignment variable with SSA ident, and the second
		//the expression in SSA that is assigned to the assignement variable
		val ssaExpressionsMap = new HashMap<String, Couple<String, BinaryTree<Triplet<String, String, String>>>>
		
		modulePaths.forEach[ 
			path, pathID | 
			val defList = new ArrayList<Couple<String, String>>
			path.forEach[ 
				
				subPath | 
				
				val identifier = subPath.third.extractIdentifier
				val identifierIndex = subPath.third.extractIdentIndex
				val expression = mcdcStatement.getExpression(identifier, identifierIndex)
				
				val assignVar = subPath.first.get(0) //first element of the list
				val assignCouple = new Couple(assignVar, "0")  ////////////////
				if(assignVar == "*") {assignCouple.setSecond("")}//handling "*" case
				
				val bt = expression.toBTExpression() 
				defList.updateBT(bt)
				defList.addBtVariables(bt)

				defList.updateAssignCouple(assignCouple)
				defList.updateDefList(assignCouple)
				
				subPath.updateSubPath(assignCouple, bt, identifierIndex)
				
				val ssaName = nameWithIndex(assignCouple)				
//				val assignType = assignTriplet.third
				
				//add to the map only expressions that are not present yet 
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
	}
	
	
	def static private void updateBT(List<Couple<String, String>> previousDefList, BinaryTree<Triplet<String, String, String>> bt){
		if(!bt.isEmpty()){ 
			if(bt.isLeaf){
				for(defCouple: previousDefList){
					if (bt.value.first == defCouple.first) {
						//set bt value with the assign couple value
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
	}


	def static private void addBtVariables(List<Couple<String, String>> defList, BinaryTree<Triplet<String, String,String>> bt){
		if(!bt.isEmpty()){ 
			if(bt.isLeaf){
				val index = bt.value.second
				if ( index != "") {//variable
					val variable = bt.value.first
					if(!defList.hasElement(variable)){ //defList doesn't contain variable 'variable'
						defList.add( new Couple(variable, index) )
					}
				}
			}
			else{//recursive call on its siblings
				defList.addBtVariables(bt.left)
				defList.addBtVariables(bt.right)
			}
		}		
	}
	
	
	def static private void updateAssignCouple(List<Couple<String, String>> previousDefList, Couple<String,String> assignCouple)
	{
		val assignVar = assignCouple.first
		
		if(assignVar != "*"){
			previousDefList.forEach[ 
				value | if (value.first == assignVar){ 
					val newIndex = (value.second.parseInt + 1)
					assignCouple.setSecond(newIndex.toString)
					return
				}
			]//forEach
			
			//here, that means that assignVar is not in DefList	
//			val btValue = assignVar.getValueInBT(bt)
//			
//			if(btValue != null){//there is a value in bt that is redifined by assignVar
//				val newIndex = (btValue.second.parseInt + 1)
//				assignCouple.setSecond(newIndex.toString)
//			}
//			else{
				//keep assigvar values
//			}
		}
		else{// "*"
			//nothing to do
		}
		
	}
	
	
	def static private void updateDefList(List<Couple<String, String>> defList, Couple<String,String> assignCouple){
		
		val assignVar = assignCouple.first
		if(assignVar != "*"){
			defList.forEach[ 
				defCouple | if (defCouple.first == assignVar){ 
				defCouple.setSecond(assignCouple.second)
				return
				}
			]//forEach
			defList.add( new Couple(assignCouple.first, assignCouple.second))
		}
	}
	
	
	def static void updateSubPath(Triplet<List<String>, List<String>, List<String>> subPath, Couple<String,String> assignCouple, BinaryTree<Triplet<String,String,String>> bt, String identifierIndex ) {
		
		if(identifierIndex == "N"){ //bt represents a non boolean expression 
			subPath.first.set(0, nameWithIndex(assignCouple)) //replace assign var with its ssa var name
			subPath.second.set(0, bt.stringRepr)
		}
		else{//bt represents a non boolean expression 
			val boolVarInBt =bt.boolVarsInBT
			if(identifierIndex == "X"){
				boolVarInBt.add(0, nameWithIndex(assignCouple))// 
				subPath.setFirst(boolVarInBt) //
			}
			else{ // T or F
				if(identifierIndex == "T" || identifierIndex == "F"){
					boolVarInBt.add(0, "*")// first element is a star
					subPath.setFirst(boolVarInBt) //
				}
				else{
					throw new Exception("Unknown identifier index")
				}
			}
		}
		
		
		
		
	}
	
//	def static private Couple<String, String> getValueInBT(String assignVar, BinaryTree<Couple<String, String>> bt){
//		if(!bt.isEmpty()){ 
//			if(bt.isLeaf){
//				if (bt.value.first == assignVar) {
//					return bt.value
//				}
//			}
//			else{//recursive call on its siblings
//				assignVar.getValueInBT(bt.left)
//				assignVar.getValueInBT(bt.right)
//			}
//		}		
//	}
	
	
	
	def static private EXPRESSION getExpression( MCDC_Statement mcdcStatement, String identifier, String identifierIndex){
		if(identifierIndex == "N"){
			return mcdcStatement.getNonBoolExpression(identifier.parseInt)
		}
		else{
			if(identifierIndex == "T" || identifierIndex == "F" || identifierIndex == "X"){
				return mcdcStatement.getBoolExpression(identifier.parseInt)
			}
			else{
				throw new UnsupportedOperationException("unknown identifier index")
			}
		}
	}
	
	/**
	 * Transforms a module_dsl expression into a new binary tree expression
	 */
	def static private BinaryTree< Triplet<String,String,String> > toBTExpression(EXPRESSION expression){
		val tmpTree = new BinaryTree<Triplet<String,String,String>>() //new empty tree
		toBTExpression(expression, tmpTree)
//		System.out.println()
		return tmpTree
	}
	
	/**
	 * toBTExpression's private method
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
				//only variables are initialized with 0
				val abstractVar = expression.vref
				if(abstractVar instanceof CST_DECL){//constant
					val const = (abstractVar as CST_DECL)
					val type = "c_" + expression.typeFor //to be considered as constant
					bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet(const.value.literalValue, "", type)))
				}
				else{//variable
					bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet(abstractVar.name, "0", expression.typeFor)))
				}			
			}
			
			intConstant: bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet(expression.value.toString, "", "c_int")))
	  		
	  		realConstant: bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet(expression.value.toString, "", "c_real")))
	  		
	  		strConstant: bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet(expression.value.toString, "", "c_str")))
	  		
	  		enumConstant: {
	  			val comparator = expression.getContainerOfType(EQUAL_DIFF)
	  			val assignment = expression.getContainerOfType(ASSIGN_STATEMENT)
	  			
	  			var enumVarName = ""
	  			
	  			if(comparator != null){
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
	  			bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet(enumVarName_Plus_EnumValue, "", "c_enum")))
	  		}
	  		
	  		boolConstant: bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet(expression.value.toString, "", "c_bool")))
	  		
	  		bitConstant: bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet(expression.value.toString, "", "c_bit")))
	  		
	  		hexConstant: bt.setTree(new BinaryTree< Triplet<String,String,String> >(new Triplet(expression.value.toString, "", "c_hex")))
		}
	}//toBTExpression
	
	def static private boolVarsInBT(BinaryTree<Triplet<String,String,String>> bt){
		val listOfBoolVars = new ArrayList<String>
		boolVarsInBT(bt, listOfBoolVars)
		return listOfBoolVars
	}
	
	def static private  void boolVarsInBT(BinaryTree<Triplet<String,String,String>> bt, List<String> list){
		val btvalue = bt.value
		val operator = btvalue.first
		val index = btvalue.second
		
		switch(operator){
			case "OR": {
				bt.left.boolVarsInBT(list)
				bt.right.boolVarsInBT(list)
			}
				
			case "AND": {
				bt.left.boolVarsInBT(list)
				bt.right.boolVarsInBT(list)
			}
			
			case "XOR": {
				bt.left.boolVarsInBT(list)
				bt.right.boolVarsInBT(list)
			}
			
			case "NOT": {
				bt.right.boolVarsInBT(list)
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
	}
	
	
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
	}
	
	def static private boolean hasElement(List<Couple<String, String>> list, String variable){
		for(elem: list){
			val elemVar = elem.first
			if(elemVar == variable){ return true}
		}
		return false
	}
	
	def static private String nameWithIndex( Couple<String,String> value){
		val ident = value.second
		if(ident != ""){
			return value.first + "|" + value.second + "|"
		}
		else{
			return value.first
		}
	}
	
	def static private String addPathID(String ident, String pathID){
		return ident+ "@" + pathID
	}
	
	
}