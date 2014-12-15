package org.xtext.tests.data

import java.util.ArrayList
import java.util.HashMap
import java.util.List
import java.util.Map
import java.util.Set
import org.xtext.helper.BinaryTree
import org.xtext.helper.Couple
import org.xtext.helper.Triplet
import org.xtext.moduleDsl.LSET
import org.xtext.moduleDsl.MODULE_DECL
import org.xtext.moduleDsl.VAR_DECL
import org.xtext.solver.ProblemCoral

import static org.xtext.solver.SoverUtils.*

import static extension org.xtext.utils.DslUtils.*

class TestDataGeneration {
	
	val private static intVars = new HashMap<String, Object> 		//solver integer vars
	val private static doubleVars = new HashMap<String, Object> 	//solver double vars
	val private static dslInVars = new HashMap<String, Object> 		//dsl interface in vars
	val private static dslOutVars = new HashMap<String, Object> 	//dsl interface out vars
	
	val private static final splitPattern = "\\|" 					//split pattern
	val private static final IMIN = -100 							//minimum int variable
	val private static final IMAX = 100 							//maximum int variable
	val private static final DMIN = -100.0 							//minimum double variable
	val private static final DMAX = 100.0 							//maximum int variable
	
	
	/**
	 * 
	 */
	def static testDataGen(MODULE_DECL module, Map<List<Couple<String,String>>, String> mapTestSequencesAndIdents, Map<String,List<String>> pathIdentsSequences,
		Map<String, Couple<String, BinaryTree<Triplet<String, String, String>>>> expression)
	{
		val solutions = new HashMap< List<Couple<String,String>>, List<Triplet<String,String,String>>>
		
		//put dsl input vars in dslInVars and dsl output vars in dslOutVars
		module.recordDslVariables(dslInVars, dslOutVars)
		
		mapTestSequencesAndIdents.keySet.forEach[ 
			
			testSequences | val pathID = mapTestSequencesAndIdents.get(testSequences)
//			System.out.println("pathID:" + pathID)
			val pathIdentSeq = pathIdentsSequences.get(pathID) //idents sequences along the path #pathID
//			System.out.println("pathIdentsSequences:" + pathIdentSeq.toString)
			
			ProblemCoral.configure	//create the solver
			val pb = new ProblemCoral()
			
			pb.toSolverTranslator(pathIdentSeq, testSequences, expression, pathID)
			
			val new_dslInVars = dslInVars.ssaVarsNamesWithDslVars(intVars, doubleVars)
			val new_dslOutVars = dslOutVars.ssaVarsNamesWithDslVars(intVars, doubleVars)
			
			setRangeConstraints(pb, new_dslInVars, intVars, doubleVars)
			setRangeConstraints(pb, new_dslOutVars, intVars, doubleVars)
			
			val solve = pb.solve
			
			if(solve == 1){//
							
				val inSolutions = pb.recordSolutions(new_dslInVars, intVars, doubleVars)
				val outSolutions = pb.recordSolutions(new_dslOutVars, intVars, doubleVars)
				
				inSolutions.addAll(outSolutions)
				
				solutions.put(testSequences, inSolutions)
			//	solutions.add(outSolutions)

			}//solve
			else{
				//
			}
			
			pb.cleanup
			intVars.clear
			doubleVars.clear
			
		]//forEach
		
		return solutions
	}
	
	
	/**
	 * Translate a SSA expression into the Coral Solver expression
	 */
	def static toSolverTranslator(ProblemCoral pb, List<String> pathIdentSeq, List<Couple<String, String>> testSequences, Map<String, Couple<String, BinaryTree<Triplet<String, String, String>>>> ssaExprMap, String pathID) {
		
		pathIdentSeq.forEach[
			
			pathCondID | val condLastChar = pathCondID.getLastChar
							
			if(condLastChar == "N"){//NonBoolean expression	
				
				val identAtPathID = pathCondID.addPathID(pathID) //'pathCondID + @ + pathID' is a key of SSA expressions map	
				val expCouple = ssaExprMap.get(identAtPathID) //SSA form of the expression having the ident 'pathCondID' in the path #pathID
				val ssaName = expCouple.first  //SSA assignment variable of the expression having the ident 'pathCondID'
				val btExp = expCouple.second //SSA form of the expression having the ident 'pathCondID'
				val type = btExp.value.third //Since btExp is not a bool expression => assignment variable type = btExp.type 
				
				val solverVar = makeSolverVar(pb, ssaName, type) //make new solver variable sith 
				val solverBtExp = pb.toSolverExpression(btExp, true) //make new solver expression
				val constraint = pb.eq(solverVar, solverBtExp) //assignment constraint: solverVar == solverBtExp
				pb.post(constraint) //add new constraint to the solver
			
			}
			else{// T or F or X => Boolean expression
				
				val pathCondIDwithoutLast = pathCondID.deleteLastChar 
				val identAtPathID = pathCondIDwithoutLast.addPathID(pathID)
				val expCouple = ssaExprMap.get(identAtPathID)
				val btExp = expCouple.second
				val ssaName = expCouple.first 
				
				val results = testSequences.getSequence(pathCondIDwithoutLast)
				val btBooleanConditions = btExp.booleanConditions //get all Boolean conditions involved in btExp
						
				btBooleanConditions.forEach[
					
					boolCondition, i | val outcome =  results.get(i + 1) //results.get(0) is the outcome of the Boolean expression 'boolCondition'
					
					if (boolCondition.isRelationalCondition){ //relational condition: (a<3), (c==4), ...
						val constraint = pb.toSolverExpression(boolCondition, outcome.boolValue)
						pb.post(constraint)
					}
					else{//boolean variable, WARNING: could be a boolean constant TODO:review this section
						val varName = boolCondition.value.first
						val ssaIndex = boolCondition.value.second
						val newName = varName.addSSAIndex(ssaIndex)
//						System.out.println(" Boolean condition " + newName)
					}					
				
				]//forEach
				
				if(ssaName != "*") {
					val outcome = results.get(0).boolValue
//					System.out.println(" Boolean condition " + ssaName + "=>" + outcome)
				} ///TODO: boolean variables must be handled
			}
		
		]//forEach
	
	}//toSolverTranslator
	
	
	/**
	 *
	 */
	def private static getSequence(List<Couple<String, String>> testSeq, String id){
		
		for(test: testSeq){
			val testId = test.second
			if (testId == id) {
				return test.first.toStringArray
			}
		}
		
		throw new Exception("#### Associated sequence not found ####")
	
	}//getSequence
	
	
	/**
	 * Return a coral solver variable
	 */
	def private static Object makeSolverVar(ProblemCoral pb, String ssaName, String type) {
		
		if(type == "int" || type == "enum" || type == "c_int" || type == "c_enum"){
			if (intVars.containsKey(ssaName)){
				return intVars.get(ssaName)
			}
			else{
				val value = pb.makeIntVar(ssaName, IMIN , IMAX)
				val putValue = intVars.put(ssaName, value)
				return value
			}
		}
		else{
			if(type == "real" || type == "c_real"){
				if (doubleVars.containsKey(ssaName)){
					return doubleVars.get(ssaName)
				}
				else{
					val value = pb.makeRealVar(ssaName, DMIN , DMAX)
					val putValue = doubleVars.put(ssaName, value)
					return value
				}
			}
			else{ throw new UnsupportedOperationException(" #### Unsupported operation #### ") }
		}//else
	
	}//makeSolverVar
	
	
	/**
	 * Transform a relational condition into a Coral solver constraint 
	 */
	def static Object toSolverExpression(ProblemCoral pb, BinaryTree<Triplet<String,String,String>> bt, boolean outcome){
		
		val btValue = bt.value
		val operator = btValue.first
		
		switch (operator) {
				
			case "OR": {
				if(outcome == false)//invert the or operator
					pb.and(pb.toSolverExpression(bt.left, outcome) , pb.toSolverExpression(bt.right, outcome))
				else
					pb.or(pb.toSolverExpression(bt.left, outcome) , pb.toSolverExpression(bt.right, outcome) )
			}
			
			case "AND": {
				if(outcome == false)//invert the and operator
					pb.or(pb.toSolverExpression(bt.left, outcome) , pb.toSolverExpression(bt.right, outcome))
				else
					pb.and(pb.toSolverExpression(bt.left, outcome) , pb.toSolverExpression(bt.right, outcome))
			}
			
			case "XOR": {///////////Not properly implemented
				if(outcome == false)//invert the xor operator
					pb.xor(pb.toSolverExpression(bt.left, outcome) , pb.toSolverExpression(bt.right, outcome))
				else
					pb.xor(pb.toSolverExpression(bt.left, outcome) , pb.toSolverExpression(bt.right, outcome)) ///
			}
			
			case "NOT": {
				if(outcome == false){
					var new_invert = true
					pb.toSolverExpression(bt.right , new_invert)
				}
				else{
					var new_invert = false
					pb.toSolverExpression(bt.right , new_invert)
				}
			}

			case "==": {
				if(outcome == false)//invert the == operator
					pb.neq(pb.toSolverExpression(bt.left, outcome) , pb.toSolverExpression(bt.right, outcome))
				else
					pb.eq(pb.toSolverExpression(bt.left , outcome) , pb.toSolverExpression(bt.right, outcome))			
			}
			
			case "!=": {
				if(outcome == false)//invert the != operator
					pb.eq(pb.toSolverExpression(bt.left, outcome) , pb.toSolverExpression(bt.right, outcome))
				else
					pb.neq(pb.toSolverExpression(bt.left, outcome) , pb.toSolverExpression(bt.right, outcome))
			}
			
			case "<=": {
				if(outcome == false)//invert the <= operator
					pb.gt(pb.toSolverExpression(bt.left, outcome) , pb.toSolverExpression(bt.right, outcome))
				else
					pb.leq(pb.toSolverExpression(bt.left, outcome) , pb.toSolverExpression(bt.right, outcome))
			}
			
			case ">=": {
				if(outcome == false)//invert the or operator
					pb.lt(pb.toSolverExpression(bt.left, outcome) , pb.toSolverExpression(bt.right, outcome))
				else
					pb.geq(pb.toSolverExpression(bt.left, outcome) , pb.toSolverExpression(bt.right, outcome))
			}
		
			case "<": {
				if(outcome == false)//invert the < operator
					pb.geq(pb.toSolverExpression(bt.left, outcome) , pb.toSolverExpression(bt.right, outcome))
				else
					pb.lt(pb.toSolverExpression(bt.left, outcome) , pb.toSolverExpression(bt.right, outcome))
			}
		
			case ">": {
				if(outcome == false)//invert the < operator
					pb.leq(pb.toSolverExpression(bt.left, outcome) , pb.toSolverExpression(bt.right, outcome))
				else
					pb.gt(pb.toSolverExpression(bt.left, outcome) , pb.toSolverExpression(bt.right, outcome))
			}
		
			case "+": {
				pb.plus(pb.toSolverExpression(bt.left, outcome) , pb.toSolverExpression(bt.right, outcome))
			}
			
			case "-": {
				pb.minus(pb.toSolverExpression(bt.left, outcome) , pb.toSolverExpression(bt.right, outcome))
			}
			
			case "*": {
				pb.mult(pb.toSolverExpression(bt.left, outcome) , pb.toSolverExpression(bt.right, outcome))
			}
		
			case "/": {
				pb.div(pb.toSolverExpression(bt.left, outcome) , pb.toSolverExpression(bt.right, outcome))
			}
		
			default:{ //variable or constant
				
				val nameOrValue = operator
				val ident = btValue.second
				val type = btValue.third
	
				if(nameOrValue != ""){ 
					if(ident != "") {//variable 
						val ssaName = nameOrValue.addSSAIndex(ident) 
						dealWithVariables(pb, ssaName, type , outcome) 
					}
					else{ /*constant*/ dealWithConstants(pb, nameOrValue, type, outcome) } 
				}
				
				else{ throw new Exception(" #### Incorrect expression type #### ") }
			
			}//default		
				
		}	
	}//toSolverExpression
	
	
	/**
	 * Deal with variable creation in the solver
	 */
	def static private dealWithVariables(ProblemCoral pb, String ssaVarName, String varType, boolean outcome) {
		
		switch(varType){
			
			case "int" : {
				if (intVars.containsKey(ssaVarName)){
					return intVars.get(ssaVarName)
				}
				else{
					val value = pb.makeIntVar(ssaVarName, IMIN , IMAX)
					val putValue = intVars.put(ssaVarName, value)
					return value
				}
			}//case int
			
			case "real" : {
				if (doubleVars.containsKey(ssaVarName)){
					return doubleVars.get(ssaVarName)
				}
				else{
					val value = pb.makeRealVar(ssaVarName, DMIN , DMAX)
					val putValue = doubleVars.put(ssaVarName, value)
					return value
				}
			}//case real
			
			case "bool" : {
				throw new RuntimeException(" #### Coral does not handle boolean constraint #### ")
			}
			
			case "enum" : {
				if (intVars.containsKey(ssaVarName)){
					return intVars.get(ssaVarName)
				}
				else{
					val enumVar = pb.makeIntVar(ssaVarName, IMIN , IMAX)
					val putValue = intVars.put(ssaVarName, enumVar)
					return enumVar
				}		
			}
			
			case "str" : {
				throw new UnsupportedOperationException(" #### Coral does not handle string constraint #### ")
			}
			
			case "hex" : {
				throw new UnsupportedOperationException(" #### Coral does not handle hexadecimal constraint #### ")
			}
			
			case "bit" : {
				throw new UnsupportedOperationException(" #### Coral does not handle bit constraint #### ")
			}
			
			default: throw new RuntimeException(" #### Incorrect operation type #### ")
		}
	
	}//dealWithVariables
	
	
	/**
	 * Deal with constants creation in the solver
	 */
	def static private dealWithConstants(ProblemCoral pb, String value, String type, boolean outcome) {
		
		switch(type){
			
			case "c_int": { new Integer(value.parseInt) } 
			
			case "c_real": { new Double(value.parseDouble) } 
			
			case "c_enum": { //value = enumeration variableName + "@" +  enumerationValue: see toBTExpression method ins SSA package  
				val split = value.split("@")
				val enumVar = split.get(0)
				val enumValue = split.get(1)		
				return new Integer( getIndexOfEnumValue(enumVar, enumValue))
			}
			
			case "c_bool": {//in case of constant boolean, its value is stored in the first parameter of the triplet
				val myBool = value.parseBoolean //
				if(outcome == false)
					return pb.makeBoolConstant(!myBool)
				else
					return pb.makeBoolConstant(myBool)
			}
			
			case "c_bit": { throw new UnsupportedOperationException(" #### bit not supported yet #### ") }
			
			case "c_hex": { throw new UnsupportedOperationException(" #### hexadecimal not supported yet  #### ") }
			
			case "c_str": { throw new UnsupportedOperationException(" #### string not supported yet  #### ") }
		
		}
	
	}//dealWithConstants
	
	
	/**
	 * Put dsl interface variables in maps as follows: dsl input variables are stored into the inVarsMap map and
	 * the output variables are stored into the outVarsMap map. 
	 */
	def static recordDslVariables(MODULE_DECL module, Map<String,Object> inVarsMap, Map<String,Object> outVarsMap){
		
		val listOfVariables = module.interface.declaration.filter(VAR_DECL) //module interface variables
		
		inVarsMap.clear //clear the map
		outVarsMap.clear //clear the map
		
		listOfVariables.forEach[ 
			
			variable | val name = variable.name
			val flow = variable.flow.flow
			
			if (flow == "in"){
				inVarsMap.put(name, variable)
			}
			else{
				if (flow == "out"){
					outVarsMap.put(name, variable)
				}
				else{
					if (flow == "inout"){
						inVarsMap.put(name, variable)
//						dslOutVars.put(name, variable)				
					}
				}
			}			
		
		]//forEach
	
	}//dslVariables
	
	
	/**
	 * 
	 */
	def private static addSSAIndex(String varName, String index){
		return varName + "|" + index + "|"
	}
	
	
	/**
	 * Return the position of an enumeration value listed in the enumeration variable list 
	 */
	def private static int getIndexOfEnumValue(String enumVar, String enumValue) {
		
		var index = -1		
		
		var variable = dslInVars.get(enumVar) 
		if(variable == null){
			variable = dslOutVars.get(enumVar)
		}
		
		val list = ((variable as VAR_DECL).range as LSET).value //TODO: review this part
		for(e : list){
			index = index + 1
			if (e.literalValue == enumValue) 
				return index 
		}//for
		
		throw new Exception("#### Index not found ####")
	
	}//getIndexOfEnumValue
	
	
	/**
	 * Return a set of Boolean conditions that get involved in the Boolean expression represented by the Binary tree
	 */
	def static booleanConditions(BinaryTree<Triplet<String,String,String>> bt){
		
		val boolVarsList = new ArrayList<BinaryTree<Triplet<String,String,String>>>
		booleanConditions(bt, boolVarsList)
		return boolVarsList
	
	}//booleanConditions
	
	
	/**
	 * 
	 */
	def static private void booleanConditions(BinaryTree<Triplet<String,String,String>> bt, List<BinaryTree<Triplet<String, String, String>>> boolVars){
		
		val btValue = bt.value
		val operator = btValue.first
		
		switch(operator){
			case "OR":{ bt.left.booleanConditions(boolVars) bt.right.booleanConditions(boolVars) }
			case "AND":{ bt.left.booleanConditions(boolVars) bt.right.booleanConditions(boolVars) }
			case "NOT":{ bt.right.booleanConditions(boolVars) }
			case "==":{ boolVars.add(bt) }
			case "!=":{ boolVars.add(bt) }
			case "<":{ boolVars.add(bt) }
			case "<=":{ boolVars.add(bt) }
			case ">":{ boolVars.add(bt) }
			case ">=":{ boolVars.add(bt) }
			default:{
				val ssaIdent = btValue.second
				val varType = btValue.third
				if( (ssaIdent != "") && (varType =="bool") ){//boolean variable
					boolVars.add(bt)
				}
				else{ /*nothing*/ }
			}//default
		}//switch
	
	}//booleanConditions	
	
	
	/**
	 * Return a string representation of the Binary tree
	 */
	def static String stringRepr(BinaryTree<Triplet<String,String,String>> bt){
		if(!bt.isEmpty()){
			if(!bt.isLeaf()){
				"(" + bt.left.stringRepr + bt.value.first + bt.right.stringRepr +")"
			}
			else{ //leaf
				val btValue = bt.value
				return (btValue.first + btValue.second)
			}//leaf
		}
	}//stringRepr
	
	
	/**
	 * Check whether or not, a Boolean condition is relational 
	 */
	def static boolean isRelationalCondition(BinaryTree<Triplet<String, String,String>> bt){
		
		val btValue = bt.value
		val type = btValue.third
		
		if (type == "bool" || type == "c_bool"){
			if (bt.left.isEmpty && bt.right.isEmpty){
				if(btValue.second != ""){ //ssa ident not null => variable
					return false
				}
				else{
					throw new Exception("#### incorrect boolean condition ####")
				}
			}
			else{
				if (!bt.left.isEmpty && !bt.right.isEmpty){ // bt.left not empty and bt.right not empty
					return true
				}
				else{
					throw new Exception("#### incorrect boolean condition ####")
				}
			}
		}
		else{
			throw new Exception("#### Not a boolean condition ####")
		}
	
	}//isRelationalCondition
	
	
	/**
	 * 
	 */
	def static private String addPathID(String ident, String pathID){
		return ident+ "@" + pathID
	}	
	
	
	/**
	 * 
	 */
	def static private ssaVarsNamesWithDslVars(Map<String, Object> dlsVars, Map<String, Object> intVars, Map<String, Object> doubleVars){
		val intKeys = intVars.keySet
		val doubleKeys = doubleVars.keySet
		val dslVarsKeys = dlsVars.keySet		
		
		val map = new HashMap<String, Object>
		
		dslVarsKeys.forEach[ 
			
			dslVarName | val dslVar = (dlsVars.get(dslVarName) as VAR_DECL)
			
			val dslVarType = dslVar.type.type
			val dslVarFlow = dslVar.flow.flow
			
			switch (dslVarFlow){
				
				case "in":{
					if(dslVarType == "int" || dslVarType == "enum"){
						val ssaName = dslVarName.inVarSsaName(intKeys)
						if(ssaName != "") { map.put(ssaName, dlsVars.get(dslVarName))}
					}
					else{	
						if(dslVarType == "real"){
							val ssaName = dslVarName.inVarSsaName(doubleKeys)
							if(ssaName != "") { map.put(ssaName, dlsVars.get(dslVarName))}
						}
						else{
							//nothing yet
						}
					}
				}//in
				
				case "out":{
					if(dslVarType == "int" || dslVarType == "enum"){
						val ssaName = dslVarName.outVarSsaName(intKeys)
						if(ssaName != "") { map.put(ssaName, dlsVars.get(dslVarName))}
					}
					else{	
						if(dslVarType == "real"){
							val ssaName = dslVarName.outVarSsaName(doubleKeys)
							if(ssaName != "") { map.put(ssaName, dlsVars.get(dslVarName))}
						}
						else{
							//nothing yet
						}
					}
				}//out
				
				case "inout":{
					if(dslVarType == "int" || dslVarType == "enum"){
						val ssaNameIn = dslVarName.inVarSsaName(intKeys)
//						val ssaNameOut = dslVarName.outVarSsaName(intKeys)
						if(ssaNameIn != "") { map.put(ssaNameIn, dlsVars.get(dslVarName))}
					//	val put2 = map.put(ssaNameOut, dlsVars.get(dslVarName))
					}
					else{	
						if(dslVarType == "real"){
							val ssaNameIn = dslVarName.inVarSsaName(doubleKeys)
//							val ssaNameOut = dslVarName.outVarSsaName(doubleKeys)
							if(ssaNameIn != "") { map.put(ssaNameIn, dlsVars.get(dslVarName))}
							//val put2 = map.put(ssaNameOut, dlsVars.get(dslVarName))
						}
						else{
							//nothing yet
						}
					}
				}//out
			
			}//switch	
			
		]//forEach
		
		return map
	}
	
	
	/**
	 * 
	 */
	def static private String inVarSsaName(String dslInVarName , Set<String> ssaVarsNames){

		for(ssaName: ssaVarsNames){
			val split = ssaName.split(splitPattern)
			val name = split.get(0) //variable name without SSA ident
			val index = split.get(1) // ssa variable name index
			if( (dslInVarName == name) && (index == "0")){ return ssaName } //dsl input variables names are those whose ssaNames get index "0"
		}//for	
		//throw new Exception(" #### Variable "+ dslInVarName +" not found #### ")
		return ""
	}//inVarSsaName
	
	
	/**
	 * 
	 */
	def static private removeSSAindex(String ssaName){
		val split = ssaName.split(splitPattern)
		return split.get(0) //name is the first element of the list
	}
	
	
	/**
	 * 
	 */
	def static private String outVarSsaName(String dslOutVarName , Set<String> ssaVarsNames) {	
		var highestIndexVar = ""
		var tmpIndex = -1
		
		for(ssaName: ssaVarsNames){
			val split = ssaName.split(splitPattern)
			val name = split.get(0) //variable name without SSA ident
			val index = split.get(1) // ssa variable name index
			if((dslOutVarName == name)){ 
				val indexValue = index.parseInt
				if( indexValue > tmpIndex){
					highestIndexVar = ssaName
					tmpIndex = indexValue
				} 
			} 
		}//for
		
//		if(highestIndexVar == ""){
//			throw new Exception(" #### Variable not found #### ")
//		}	
		
		return highestIndexVar
	
	}//outVarSsaName
	
	
	/**
	 * 
	 */
	def static private recordSolutions(ProblemCoral pb, Map<String, Object> dslVars, Map<String, Object> intVars, Map<String, Object> doubleVars){
		
		val solutionsList = new ArrayList<Triplet<String, String, String>>
		val dslKeys = dslVars.keySet
		
		dslKeys.forEach[ 
			
			key | val dslVariable = (dslVars.get(key) as VAR_DECL)
			val dslVarType = dslVariable.type.type
			val dslFlow = dslVariable.flow.flow
			
			switch(dslVarType){
				case "int": {
					val solverIntVar = intVars.get(key)
					val solution = pb.getIntValue(solverIntVar)
					solutionsList.add( new Triplet( dslFlow, key.removeSSAindex , solution.toString))
				}
				
				case "real": {
					val solverDoubleVar = doubleVars.get(key)
					val solution = pb.getRealValue(solverDoubleVar)
					solutionsList.add( new Triplet( dslFlow, key.removeSSAindex , solution.toString))
				}
				
				case "enum": {
					val solverEnumVar = intVars.get(key)
					val solution = pb.getIntValue(solverEnumVar)
					val enumSolution = (dslVariable.range as LSET).value.get(solution)
					solutionsList.add( new Triplet(dslFlow , key.removeSSAindex , enumSolution.literalValue))
				}
				
				default:{ /*To be handled later */}

			}//switch
		]//forEach
	
		return solutionsList
	
	}//recordSolutions

}//class