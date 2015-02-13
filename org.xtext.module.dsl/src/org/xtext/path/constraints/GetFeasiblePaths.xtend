package org.xtext.path.constraints

import java.util.HashMap
import java.util.List
import org.xtext.helper.BinaryTree
import org.xtext.helper.Couple
import org.xtext.moduleDsl.LSET
import org.xtext.moduleDsl.MODULE_DECL
import org.xtext.moduleDsl.VAR_DECL
import org.xtext.solver.ProblemCoral
import java.util.ArrayList
import org.xtext.helper.Triplet
import org.xtext.mcdc.MCDC_Statement

import static extension org.xtext.solver.SoverUtils.*
import static extension org.xtext.utils.DslUtils.*
import static extension org.xtext.path.constraints.pathConstraintsUtils.*
import java.util.Map

class GetFeasiblePaths {
	
	val private static intPathVars = new HashMap<String, Object> //integer symbolic vars
	val private static doublePathVars = new HashMap<String, Object> //double symbolic vars
	val private static dslPathVars = new HashMap<String, Object> //dsl symbolic vars
	val private static final symbNameIndex = "_0" //symbolic variable names index
	
	/**
	 * Return a set of feasible paths among the module ones
	 */
	def static getFeasiblePaths(List<List<Triplet<List<String>,List<String>,List<String>>>> pathSet, MODULE_DECL module, MCDC_Statement mcdcStatement){
		
		val feasiblePaths = new ArrayList<List<Triplet<List<String>, List<String>, List<String>>>> //feasible paths list
		
		module.dslVariablesWithSymbNames(dslPathVars) //fill dslPathVars map
		
		pathSet.forEach[ //remove infeasible paths
			
			path | 
			
			ProblemCoral.configure
			val pb = new ProblemCoral
			
			val pc = pathToPathCondition(module, path, mcdcStatement) //get Path Condition list

			System.out.println
			pc.forEach [ 
				bt,i | System.out.println("cond: "+ i) bt.printPathCondition System.out.println
			]
			
			val solve = pc.solvePathCondition(module , pb) //solve Path Condition
			
			if(solve==1){ feasiblePaths.add(path) } //solve = 1 => the current path is feasible
			
			pb.cleanup //reset the solver id generator
			intPathVars.clear //clear intPathVars map
			doublePathVars.clear //clear doublePathVars
		
		]//forEach
		
		return feasiblePaths
	
	}//getFeasiblePaths
	
	
	/**
	 * Put dsl interface variables in a map. The key of the map is the symbolic name of the variable, and
	 * the map's value dsl variable (VAR_DECL)
	 */
	 def static dslVariablesWithSymbNames(MODULE_DECL module, Map<String, Object> variablesMap){
	 	
	 	val listOfVariables = module.interface.declaration.filter(VAR_DECL)
		
		if( variablesMap.size > 0 ) { variablesMap.clear }

		listOfVariables.forEach[ 
			variable | val symbName = variable.name + symbNameIndex
			variablesMap.put(symbName , variable)
		]//forEach
	 
	 }//setDslVariables
	
	
	/**
	 * Solve the Path Condition with Coral
	 */
	def static int solvePathCondition(List<BinaryTree<Couple<String,String>>> PC, MODULE_DECL module, ProblemCoral pb){
		
		//create symbolic variables		
		pb.createSymbVariables(dslPathVars)
				
		//PC to Coral 
		PC.forEach[
			subPathCondition | val invert = false 
			val ctr = translateSubPathCondition(subPathCondition, pb , invert)
			pb.post(ctr)
		]//forEach
		
		setRangeConstraints(pb, dslPathVars, intPathVars, doublePathVars)
		
		return pb.solve
	
	}
	
	def static createSymbVariables(ProblemCoral pb, HashMap<String, Object> dslVarsWithSymbNames) {
		val keySet = dslVarsWithSymbNames.keySet
		for(key: keySet){
			val dslVariable = (dslVarsWithSymbNames.get(key) as VAR_DECL)
			val flow = dslVariable.flow.flow
			if(flow == "in" || flow == "inout"){
				val type = dslVariable.type.type
				dealWithVarsAndConst(pb, key, type, false)
			}
		}
	}
	
	//solvePathCondition
	
	
	/**
	 * Translate into solver constraint a subPathCondition. A subPathCondition is an element of the Path Condition list
	 */
	def static Object translateSubPathCondition(BinaryTree<Couple<String,String>> subPathCondition , ProblemCoral pb , boolean invert ) {		
			
			val value = subPathCondition.value
			val operator = value.first
			
			switch (operator) {
				
				case "OR": {
					if(invert == true)//invert the or operator
						pb.and( subPathCondition.left.translateSubPathCondition(pb, invert) , subPathCondition.right.translateSubPathCondition(pb, invert))
					else
						pb.or( subPathCondition.left.translateSubPathCondition(pb , invert) , subPathCondition.right.translateSubPathCondition(pb, invert))
				}
				
				case "AND": {
					if(invert == true)//invert the and operator
						pb.or( subPathCondition.left.translateSubPathCondition(pb, invert) , subPathCondition.right.translateSubPathCondition(pb, invert))
					else
						pb.and( subPathCondition.left.translateSubPathCondition(pb , invert) , subPathCondition.right.translateSubPathCondition(pb, invert))
				}
				
				case "XOR": {///////////Not properly implemented
					if(invert == true)//invert the xor operator
						pb.xor( subPathCondition.left.translateSubPathCondition(pb, invert) , subPathCondition.right.translateSubPathCondition(pb, invert))
					else
						pb.xor( subPathCondition.left.translateSubPathCondition(pb , invert) , subPathCondition.right.translateSubPathCondition(pb, invert))
				}
				
				case "NOT": {//invert 'invert' value
					if(invert == true){ 
						var new_invert = false
						subPathCondition.right.translateSubPathCondition(pb , new_invert)
					}
					else{
						var new_invert = true
						subPathCondition.right.translateSubPathCondition(pb, new_invert)
					}
				}
	
				case "==": {				
					if(invert == true) //invert the == operator
						pb.neq( subPathCondition.left.translateSubPathCondition(pb, invert) , subPathCondition.right.translateSubPathCondition(pb, invert))
					else
						pb.eq( subPathCondition.left.translateSubPathCondition(pb , invert) , subPathCondition.right.translateSubPathCondition(pb, invert))
					
				}
				
				case "!=": {
					if(invert == true) //invert the != operator
						pb.eq( subPathCondition.left.translateSubPathCondition(pb, invert) , subPathCondition.right.translateSubPathCondition(pb, invert))
					else
						pb.neq( subPathCondition.left.translateSubPathCondition(pb , invert) , subPathCondition.right.translateSubPathCondition(pb, invert))
				}
				
				case "<=": {
					if(invert == true) //invert the <= operator
						pb.gt( subPathCondition.left.translateSubPathCondition(pb, invert) , subPathCondition.right.translateSubPathCondition(pb, invert))
					else
						pb.leq( subPathCondition.left.translateSubPathCondition(pb , invert) , subPathCondition.right.translateSubPathCondition(pb, invert))
				}
				
				case ">=": {
					if(invert == true) //invert the or operator
						pb.lt( subPathCondition.left.translateSubPathCondition(pb, invert) , subPathCondition.right.translateSubPathCondition(pb, invert))
					else
						pb.geq( subPathCondition.left.translateSubPathCondition(pb , invert) , subPathCondition.right.translateSubPathCondition(pb, invert))
				}
			
				case "<": {
					if(invert == true)//invert the < operator
						pb.geq( subPathCondition.left.translateSubPathCondition(pb, invert) , subPathCondition.right.translateSubPathCondition(pb, invert))
					else
						pb.lt( subPathCondition.left.translateSubPathCondition(pb , invert) , subPathCondition.right.translateSubPathCondition(pb, invert))
				}
			
				case ">": {
					if(invert == true)//invert the < operator
						pb.leq( subPathCondition.left.translateSubPathCondition(pb, invert) , subPathCondition.right.translateSubPathCondition(pb, invert))
					else
						pb.gt( subPathCondition.left.translateSubPathCondition(pb , invert) , subPathCondition.right.translateSubPathCondition(pb, invert))
				}
			
				case "+": {
					pb.plus( subPathCondition.left.translateSubPathCondition(pb, invert) , subPathCondition.right.translateSubPathCondition(pb, invert))
				}
				
				case "-": {
					pb.minus( subPathCondition.left.translateSubPathCondition(pb, invert) , subPathCondition.right.translateSubPathCondition(pb, invert))
				}
				
				case "*": {
					pb.mult( subPathCondition.left.translateSubPathCondition(pb, invert) , subPathCondition.right.translateSubPathCondition(pb, invert))
				}
			
				case "/": {
					pb.div( subPathCondition.left.translateSubPathCondition(pb, invert) , subPathCondition.right.translateSubPathCondition(pb, invert))
				}
				
				case "%": {
					pb.mod( subPathCondition.left.translateSubPathCondition(pb, invert) , subPathCondition.right.translateSubPathCondition(pb, invert))
				}
				
				default:{
					val type = value.second
					if(operator != ""){ dealWithVarsAndConst(pb, operator, type , invert) }
					else{ throw new RuntimeException(" #### Unknown expression #### ") }
				}//default		
				
			}	
	}//translateSubPathCondition
	
	
	/**
	 * Translate into solver variables or constants
	 */
	def static Object dealWithVarsAndConst(ProblemCoral pb, String varName , String type, boolean invert) {
		
		switch (type) {
			case "int" : {
				if (intPathVars.containsKey(varName)){
					return intPathVars.get(varName)
				}
				else{
					val value = pb.makeIntVar(varName, -100 , 100)
					val putValue = intPathVars.put(varName, value)
					return value
				}
			}
			
			case "real" : {
				if (doublePathVars.containsKey(varName)){
					return doublePathVars.get(varName)
				}
				else{
					val value = pb.makeRealVar(varName, -100.0 , 100.0)
					val putValue = doublePathVars.put(varName, value)
					return value
				}
			}//case real
			
			case "enum" : { //enum variables are considered as integer variables
				if (intPathVars.containsKey(varName)){
					return intPathVars.get(varName)
				}
				else{
					val enumVar = pb.makeIntVar(varName, -100 , 100)
					val putValue = intPathVars.put(varName, enumVar)
					return enumVar
				}		
			}
					
			case "bool" : {
				throw new RuntimeException(" #### Coral does not handle boolean constraint #### ")
			}
					
			case "str" : {
				throw new RuntimeException(" #### Coral does not handle string constraint #### ")
			}
			
			case "hex" : {
				throw new RuntimeException(" #### Coral does not handle hexadecimal constraint #### ")
			}
			
			case "bit" : {
				throw new RuntimeException(" #### Coral does not handle bit constraint #### ")
			}
			
			case "c_int": new Integer(varName.parseInt)
			
			case "c_real": new Double(varName.parseDouble)
			
			case "c_enum": {//c_enum value are actually equals to: enumVarName + "@" + enumValue  (cf.toBTExpression in pathConstraintsUtils) 
				val split = varName.split("@")
				val enumVarName = split.get(0) //enumeration variable name
				val enumValue = split.get(1) //enumeration value		
				return new Integer( getIndexOfEnumValue(enumVarName, enumValue) ) //return the right integer value
			}
			
			case "c_bool": {
				val myBool = varName.parseBoolean
				if(invert == true)
					return pb.makeBoolConstant(!myBool)
				else
					return pb.makeBoolConstant(myBool)
			}//c_bool
			
			default: throw new RuntimeException(" #### Unknown operation type #### ")
		}
	
	} //dealWithVarsAndConst
	
	
	/**
	 * Return the position of an enumeration value listed in the enumeration variable list 
	 */
	def private static int getIndexOfEnumValue(String enumVarName, String enumValue) {
	
		var index = -1		 
		val enumVarSymbName = enumVarName + symbNameIndex //add symbolic value symbol
		val variable = dslPathVars.get(enumVarSymbName) //Actually, variables' names stored in dslVars are symbolic ones
		
		val list = ((variable as VAR_DECL).range as LSET).value //TODO: review this part
		
		for(e : list){
			index = index + 1
			if (e.literalValue == enumValue) 
				return index 
		}//for
		
		throw new Exception("#### Index not found ####")
	
	}//getIndexOfEnumValue
	

}//class