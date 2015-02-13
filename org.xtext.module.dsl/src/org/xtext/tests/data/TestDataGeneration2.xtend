package org.xtext.tests.data

import java.util.ArrayList
import java.util.HashMap
import java.util.List
import java.util.Map
import java.util.Set
import org.jacop.core.IntVar
import org.jacop.floats.core.FloatVar
import org.xtext.helper.BinaryTree
import org.xtext.helper.Couple
import org.xtext.helper.Triplet
import org.xtext.moduleDsl.INTERVAL
import org.xtext.moduleDsl.LSET
import org.xtext.moduleDsl.MODULE_DECL
import org.xtext.moduleDsl.VAR_DECL
import org.xtext.solver.ProblemJacop

import static extension org.xtext.solver.JacopUtils.*
import static extension org.xtext.utils.DslUtils.*

class TestDataGeneration2 {
	
	val private static intVars = new HashMap<String, Object> 		//solver integer vars
	val private static doubleVars = new HashMap<String, Object> 	//solver double vars
	val private static dslInVars = new HashMap<String, Object> 		//dsl interface in vars
	val private static dslOutVars = new HashMap<String, Object> 	//dsl interface out vars
	
	val private static final splitPattern = "\\|" 					//split pattern
		
	/**
	 * 
	 */
	def static testDataGeneration(
		MODULE_DECL module, 
		Map<List<Couple<String,String>>, String> mapTestSequencesAndIdents,
		Map<String,List<String>> pathIdentsSequences,
		Map<String, Couple<String, BinaryTree<Triplet<String, String, String>>>> expression
	){
			
		val solutions = new HashMap<List<Couple<String,String>>, List<Triplet<String,String,String>>>
		
		//collect dsl input vars in dslInVars and dsl output vars in dslOutVars
		module.collectDslVariables(dslInVars, dslOutVars)
		
		mapTestSequencesAndIdents.keySet.forEach[ 
			
			testSequences | val pathID = mapTestSequencesAndIdents.get(testSequences)
			val pathIdentSeq = pathIdentsSequences.get(pathID) //idents sequences along the path #pathID
			
			//create the solver
			val pb = new ProblemJacop()
			
			//list of couple<dslInputVarSSAname, varType> 
			val solverInVarsMap = pb.createInputVariables(dslInVars)
			
			pb.toSolverTranslator(pathIdentSeq, testSequences, expression, pathID)
			
			//list of couple<dslOutVarSSAname, varType> 
			val solverOutVarsMap = dslOutVars.dslOutVarsWithSSAindexes(intVars, doubleVars)
				
			val solverVars = new ArrayList<Object>
			solverVars.addAll(solverInVarsMap.values) //add solver's input values to the list 'solverVars'
			solverVars.addAll(solverOutVarsMap.values) //add solver's output values to the list 'solverVars'
			
			val solve = pb.solve(solverVars)
			
			if (solve) {// Solutions
				
//				pb.printStore;
										
				val inSolutions = pb.recordSolutions(solverInVarsMap, dslInVars, "input")
				val outSolutions = pb.recordSolutions(solverOutVarsMap, dslOutVars, "output")
				
				inSolutions.addAll(outSolutions)
				
				solutions.put(testSequences, inSolutions)

			}//solve
			
			intVars.clear
			doubleVars.clear
			
		]//forEach
		
		return solutions
	}
	
	
	def static createInputVariables( ProblemJacop pb, HashMap<String, Object> dslInVarsMap) {
		
		val map = new HashMap<String, Object>
		val inputVarsNames = dslInVarsMap.keySet
		
		for(inputVarName : inputVarsNames){
			
			val ssaInputVarName = inputVarName.addSSAIndex("0")
			val dslInputVar = (dslInVarsMap.get(inputVarName) as VAR_DECL)
			val range = dslInputVar.range
			val type = dslInputVar.type.type
			
			val solverVar = pb.manageVariables(ssaInputVarName, type)
			
			if(range instanceof INTERVAL){
				pb.setIntervalConstraints(solverVar, dslInputVar)
			}
			else{
				if(range instanceof LSET){
					pb.setSetconstraints(solverVar, dslInputVar)
				}
			}
			
			map.put(ssaInputVarName, solverVar)		
			
		}//for
	
		return map
	
	}//createInputVariables
	
	
	/**
	 * Translate a SSA expression into the Solver expression
	 */
	def static toSolverTranslator(ProblemJacop pb, List<String> pathIdentSeq, List<Couple<String, String>> testSequences, Map<String, Couple<String, BinaryTree<Triplet<String, String, String>>>> ssaExprMap, String pathID) {
		
		pathIdentSeq.forEach[
			
			pathCondID | val condLastChar = pathCondID.getLastChar
							
			if(condLastChar == "N"){//NonBoolean expression	
				
				val identAtPathID = pathCondID.addPathID(pathID) //'pathCondID + @ + pathID' is a key of SSA expressions map	
				val expCouple = ssaExprMap.get(identAtPathID) //SSA form of the expression having the ident 'pathCondID' in the path #pathID
				val ssaName = expCouple.first  //SSA assignment variable of the expression having the ident 'pathCondID'
				val btExp = expCouple.second //SSA form of the expression having the ident 'pathCondID'
				var type = btExp.value.third //Since btExp is not a bool expression => assignment variable type = btExp.type 				
				
				//Since bTExp type is infered from its assignment's value, type could be a constant type 
				//In that case, we just remove the prefix "c_" 
				if(type == "c_int" || type == "c_real" || type=="c_enum"){
					type = type.substring(2, type.length)
				}
				
				val solverVar = pb.manageVariables(ssaName, type) //make new solver variable sith 
				val solverBtExp = pb.toSolverExpression(btExp, true) //make new solver expression
				val constraint = pb.eq(solverVar, solverBtExp) //assignment constraint: solverVar == solverBtExp
				pb.post(constraint) //add new constraint to the solver
//				pb.printConstraint(constraint)//
			}
			else{// T or F or X => Boolean expression
				
				val pathCondIDwithoutLast = pathCondID.deleteLastChar 
				val identAtPathID = pathCondIDwithoutLast.addPathID(pathID)
				val expCouple = ssaExprMap.get(identAtPathID)
				val btExp = expCouple.second
				val ssaName = expCouple.first 
				
				val results = testSequences.getIdSequence(pathCondIDwithoutLast)
				val btBooleanConditions = btExp.booleanConditions //get all Boolean conditions involved in btExp
						
				btBooleanConditions.forEach[
					
					boolCondition, i | val outcome =  results.get(i + 1) //results.get(0) is the outcome of the Boolean expression 'boolCondition'
					
					if (boolCondition.isRelationalCondition){ //relational condition: (a<3), (c==4), ...
						val constraint = pb.toSolverExpression(boolCondition, outcome.boolValue)
						pb.post(constraint)
//						pb.printConstraint(constraint)//
					}
					else{//boolean variable, WARNING: could be a boolean constant TODO:review this section
						val varName = boolCondition.value.first
						val ssaIndex = boolCondition.value.second
						val ssaVarName = varName.addSSAIndex(ssaIndex)
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
	 * Transform a relational condition into a Coral solver constraint 
	 */
	def static Object toSolverExpression(ProblemJacop pb, BinaryTree<Triplet<String,String,String>> bt, boolean outcome){
		
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
//				if(outcome == false)//invert the xor operator
//					pb.xor(pb.toSolverExpression(bt.left, outcome) , pb.toSolverExpression(bt.right, outcome))
//				else
//					pb.xor(pb.toSolverExpression(bt.left, outcome) , pb.toSolverExpression(bt.right, outcome)) ///
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
		
			case "%": {
				pb.mod(pb.toSolverExpression(bt.left, outcome) , pb.toSolverExpression(bt.right, outcome))
			}
		
			default:{ //variable or constant
				
				val nameOrValue = operator
				val ident = btValue.second
				val type = btValue.third
	
				if(nameOrValue != ""){ 
					if(ident != "") {//variable 
						val ssaName = nameOrValue.addSSAIndex(ident) 
						pb.manageVariables(ssaName, type) 
					}
					else{ /*constant*/ pb.manageConstants(nameOrValue, type) } 
				}
				
				else{ throw new Exception(" #### Incorrect expression type #### ") }
			
			}//default		
				
		}	
	}//toSolverExpression
	
	
	/**
	 * Deal with variable creation in the solver
	 */
	def static private manageVariables(ProblemJacop pb, String ssaVarName, String varType) {
		
		switch(varType){
			
			case "int" : {
				if (intVars.containsKey(ssaVarName)){
					return intVars.get(ssaVarName)
				}
				else{
					val value = pb.makeIntVar(ssaVarName)
					val putValue = intVars.put(ssaVarName, value)
					return value
				}
			}//case int
			
			case "real" : {
				if (doubleVars.containsKey(ssaVarName)){
					return doubleVars.get(ssaVarName)
				}
				else{
					val value = pb.makeRealVar(ssaVarName)
					val putValue = doubleVars.put(ssaVarName, value)
					return value
				}
			}//case real
						
			case "enum" : {
				if (intVars.containsKey(ssaVarName)){
					return intVars.get(ssaVarName)
				}
				else{
					val enumVar = pb.makeIntVar(ssaVarName)
					val putValue = intVars.put(ssaVarName, enumVar)
					return enumVar
				}		
			}
			
			case "bool" : {
				throw new RuntimeException(" #### Jacop does not handle boolean constraint #### ")
			}
		
			case "str" : {
				throw new UnsupportedOperationException(" #### Jacop does not handle string constraint #### ")
			}
			
			case "hex" : {
				throw new UnsupportedOperationException(" #### Jacop does not handle hexadecimal constraint #### ")
			}
			
			case "bit" : {
				throw new UnsupportedOperationException(" #### Jacop does not handle bit constraint #### ")
			}
			
			default: throw new RuntimeException(" #### Incorrect operation type #### " + 
												"variable name: " + ssaVarName + " " + "variable type: " + varType)
		}
	
	}//manageVariables
	
	
	/**
	 * Deal with constants creation in the solver
	 */
	def static private manageConstants(ProblemJacop pb, String value, String type) {
		
		switch(type){
			
			case "c_int": { value.parseInt } 
			
			case "c_real": { value.parseDouble } 
			
			case "c_enum": { 
			//value = enumeration variableName + "@" +  enumerationValue: see toBTExpression method ins SSA package  
				val split = value.split("@")
				val enumVar = split.get(0)
				val enumValue = split.get(1)		
				return getIndexOfEnumValue(enumVar, enumValue)
			}
			
			case "c_bool": { throw new UnsupportedOperationException(" #### bool not supported #### ") }
			
			case "c_bit": { throw new UnsupportedOperationException(" #### bit not supported yet #### ") }
			
			case "c_hex": { throw new UnsupportedOperationException(" #### hexadecimal not supported yet  #### ") }
			
			case "c_str": { throw new UnsupportedOperationException(" #### string not supported yet  #### ") }
		
		}
	
	}//dealWithConstants
	
	
	/**
	 * Put dsl interface variables in maps as follows: dsl input variables are stored into the inVarsMap map and
	 * the output variables are stored into the outVarsMap map. 
	 */
	def static collectDslVariables(MODULE_DECL module, Map<String,Object> inVarsMap, Map<String,Object> outVarsMap){
		
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
						outVarsMap.put(name, variable)				
					}
				}
			}			
		
		]//forEach
	
	}//dslVariables
	
	
	/**
	 * 
	 */
	def static private recordSolutions(ProblemJacop pb, Map<String, Object> solverVarsMap, Map<String, Object> dslVarsMap, String flow){
		
		val solutionsList = new ArrayList<Triplet<String, String, String>>
		
		solverVarsMap.keySet.forEach[ 
			
			varSSAname | 
			val varName = varSSAname.removeSSAindex 
			val dslVariable = dslVarsMap.get(varName) as VAR_DECL
			val varType = dslVariable.type.type
				
			switch(varType){
				case "int": {
					val solverVar = (solverVarsMap.get(varSSAname) as IntVar)					
					solutionsList.add( new Triplet(flow, varName, solverVar.value.toString))
				}
				
				case "real": {
					val solverVar = (solverVarsMap.get(varSSAname) as FloatVar)					
					solutionsList.add( new Triplet(flow, varName, solverVar.value.toString))
				}
				
				case "enum": {
					val solverEnumVar = (solverVarsMap.get(varSSAname) as IntVar)	
					val enumSolution = (dslVariable.range as LSET).value.get(solverEnumVar.value)
					solutionsList.add( new Triplet(flow, varName, enumSolution.literalValue))
				}
				
				default:{ /*To be handled later */}

			}//switch
			
		]//forEach
	
		return solutionsList
	
	}//recordSolutions

	
	/**
	 *
	 */
	def private static getIdSequence(List<Couple<String, String>> testSeq, String id){
		
		for(test: testSeq){
			val testId = test.second
			if (testId == id) {
				return test.first.toStringArray
			}
		}
		
		throw new Exception("#### Associated sequence not found ####")
	
	}//getSequence
	
	
	/**
	 * 
	 */
	def private static addSSAIndex(String varName, String index){
		return varName + "|" + index + "|"
	}
	
	/**
	 * 
	 */
	def static private removeSSAindex(String ssaName){
		val split = ssaName.split(splitPattern)
		return split.get(0) //name is the first element of the list
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
	 * 
	 */
	def static private String addPathID(String ident, String pathID){
		return ident+ "@" + pathID
	}	
	
	
	/**
	 * 
	 */
	def static private dslOutVarsWithSSAindexes(Map<String, Object> dlsOutVars, Map<String, Object> intVars, Map<String, Object> doubleVars){
		
		val intKeys = intVars.keySet
		val doubleKeys = doubleVars.keySet
		val dslVarsKeys = dlsOutVars.keySet		
		
		val map = new HashMap<String,Object>
		
		dslVarsKeys.forEach[ 
			
			dslVarName | val dslVar = (dlsOutVars.get(dslVarName) as VAR_DECL)
			
			val dslVarType = dslVar.type.type
			val dslVarFlow = dslVar.flow.flow
			
			if (dslVarFlow == "out" || dslVarFlow == "inout"){

				if(dslVarType == "int" || dslVarType == "enum"){
					val ssaName = dslVarName.dslOutVarWithHighestIndex(intKeys)
					if(ssaName != "") { map.put(ssaName, intVars.get(ssaName)) }
				}
				else{	
					if(dslVarType == "real"){
						val ssaName = dslVarName.dslOutVarWithHighestIndex(doubleKeys)
						if(ssaName != "") { map.put(ssaName, doubleVars.get(ssaName)) }
					}
					else{
						throw new UnsupportedOperationException(" #### Type " + dslVarType+ " not supported #### ")
					}
				}
			
			}//if
			
			else{ throw new Exception(" #### Incorrect or Unsupported variable's flow #### ") }	
			
		]//forEach
		
		return map
	}
	
	
	/**
	 * 
	 */
	def static private String dslOutVarWithHighestIndex(String dslOutVarName , Set<String> ssaVarsNames) {	
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
	
}//class	
