package org.xtext.mcdc

import org.xtext.solver.ProblemCoral
import org.xtext.moduleDsl.EXPRESSION
import org.xtext.moduleDsl.AND
import org.xtext.moduleDsl.OR
import org.xtext.moduleDsl.NOT
import org.xtext.moduleDsl.EQUAL_DIFF
import org.xtext.moduleDsl.COMPARISON
import org.xtext.moduleDsl.ADD
import org.xtext.moduleDsl.SUB
import org.xtext.moduleDsl.MULT
import org.xtext.moduleDsl.DIV
import org.xtext.moduleDsl.VarExpRef
import org.xtext.moduleDsl.intConstant
import org.xtext.moduleDsl.realConstant
import org.xtext.moduleDsl.strConstant
import org.xtext.moduleDsl.enumConstant
import org.xtext.moduleDsl.boolConstant
import org.xtext.moduleDsl.bitConstant
import org.xtext.moduleDsl.hexConstant
import java.util.HashMap

import static extension org.eclipse.xtext.EcoreUtil2.*
import static extension org.xtext.utils.DslUtils.*
import static org.xtext.solver.SoverUtils.*
import static extension org.xtext.type.provider.ExpressionsTypeProvider.*

import org.xtext.moduleDsl.VAR_DECL
import org.xtext.moduleDsl.LSET
import java.util.List
import org.xtext.helper.Couple
import org.xtext.moduleDsl.MODULE_DECL
import java.util.Map
import java.util.ArrayList

class McdcDecisionUtils {
	
	val private static intVars = new HashMap<String, Object> 		//solver integer vars
	val private static doubleVars = new HashMap<String, Object> 	//solver double vars
	val private static dslVars = new HashMap<String, Object> 		//solver dsl vars

	val private static final IMIN = -100 							//minimum int variable
	val private static final IMAX = 100 							//maximum int variable
	val private static final DMIN = -100.0 							//minimum double variable
	val private static final DMAX = 100.0 							//maximum int variable
	
	
	/**
	 * 
	 */
	def static discardInfeasibleTests(EXPRESSION expression, List<Couple<String,Integer>> testValues){
		
		val newfeasibleTests = new ArrayList<Couple<String,Integer>>
		val booleanConditions = expression.booleanConditions //conditions involved in the expression
		expression.getContainerOfType(MODULE_DECL).recordDslVariables(dslVars) //set dslVars Map
		
		testValues.forEach[ 
			
			couple | val testValue = couple.first //expression test value
			val conditionsValues = testValue.toStringArray //expression's conditions values (in the same order as boolean conditions)
			
			ProblemCoral.configure //create the solver
			val pb = new ProblemCoral //create the solver
			
			booleanConditions.forEach[
				boolCondition, i | if (boolCondition.isRelationalondition) { //the condition is a relational one
					val condValue = conditionsValues.get(i) //value of the condition
					val constraint = pb.toSolverExpression(boolCondition, condValue.boolValue) //translate the constraint 
					pb.post(constraint)
				}
				else{//boolean variable
					val constraint = pb.makeBoolConstant(true)
					pb.post(constraint)
				}
			]//booleanConditions
		
			setRangeConstraints(pb, dslVars, intVars, doubleVars)
			
			val solve = pb.solve //call the solver
			
			if(solve == 1){//feasible
				newfeasibleTests.add(couple)
			}
			
			pb.cleanup
			intVars.clear
			doubleVars.clear
			
		]//forEach
	
		return newfeasibleTests
	
	}//discardInfeasibleTests
	
	
	/**
	 * 
	 */
	def static private isRelationalondition(EXPRESSION expression){
		
		if( expression.typeFor == "bool"){
			if( expression instanceof EQUAL_DIFF || expression instanceof COMPARISON ){
				return true
			}
		}		
		return false
	
	}//isRelationnalondition
	
	
	/**
	 * Transform a relational condition into a Coral solver constraint 
	 */
	def static private Object toSolverExpression(ProblemCoral pb, EXPRESSION expression, boolean outcome){	
		
		switch (expression) {
				
			OR: {
				if(outcome == false)//invert the or operator
					pb.and(pb.toSolverExpression(expression.left, outcome) , pb.toSolverExpression(expression.right, outcome))
				else
					pb.or(pb.toSolverExpression(expression.left, outcome) , pb.toSolverExpression(expression.right, outcome) )
			}
			
			AND: {
				if(outcome == false)//invert the and operator
					pb.or(pb.toSolverExpression(expression.left, outcome) , pb.toSolverExpression(expression.right, outcome))
				else
					pb.and(pb.toSolverExpression(expression.left, outcome) , pb.toSolverExpression(expression.right, outcome))
			}			
			
			NOT: {
				if(outcome == false){
					var new_invert = true
					pb.toSolverExpression(expression.exp , new_invert)
				}
				else{
					var new_invert = false
					pb.toSolverExpression(expression.exp , new_invert)
				}
			}

			EQUAL_DIFF: {
				if (expression.op == "=="){
					if(outcome == false)//invert the == operator
						pb.neq(pb.toSolverExpression(expression.left, outcome) , pb.toSolverExpression(expression.right, outcome))
					else
						pb.eq(pb.toSolverExpression(expression.left , outcome) , pb.toSolverExpression(expression.right, outcome))
				}//Equality	
				else{
					if(outcome == false)//invert the != operator
						pb.eq(pb.toSolverExpression(expression.left, outcome) , pb.toSolverExpression(expression.right, outcome))
					else
						pb.neq(pb.toSolverExpression(expression.left, outcome) , pb.toSolverExpression(expression.right, outcome))
				}//Not Equality				
			}						
			
			COMPARISON: {
				val operator = expression.op
				
				switch(operator){
					
					case "<=": {
						if(outcome == false)//invert the <= operator
							pb.gt(pb.toSolverExpression(expression.left, outcome) , pb.toSolverExpression(expression.right, outcome))
						else
							pb.leq(pb.toSolverExpression(expression.left, outcome) , pb.toSolverExpression(expression.right, outcome))
					}//<=
					
					case ">=": {
						if(outcome == false)//invert the or operator
							pb.lt(pb.toSolverExpression(expression.left, outcome) , pb.toSolverExpression(expression.right, outcome))
						else
							pb.geq(pb.toSolverExpression(expression.left, outcome) , pb.toSolverExpression(expression.right, outcome))
					}//>=
					
					case "<": {
						if(outcome == false)//invert the < operator
							pb.geq(pb.toSolverExpression(expression.left, outcome) , pb.toSolverExpression(expression.right, outcome))
						else
							pb.lt(pb.toSolverExpression(expression.left, outcome) , pb.toSolverExpression(expression.right, outcome))
					}//<
					
					case ">": {
						if(outcome == false)//invert the < operator
							pb.leq(pb.toSolverExpression(expression.left, outcome) , pb.toSolverExpression(expression.right, outcome))
						else
							pb.gt(pb.toSolverExpression(expression.left, outcome) , pb.toSolverExpression(expression.right, outcome))
					}
				
				}//switch
				
			}//Comparison		
			
			ADD:{
				pb.plus(pb.toSolverExpression(expression.left, outcome) , pb.toSolverExpression(expression.right, outcome))
			}//add
			
			SUB:{
				pb.minus(pb.toSolverExpression(expression.left, outcome) , pb.toSolverExpression(expression.right, outcome))
			}//sub
			
			MULT: {
				pb.mult(pb.toSolverExpression(expression.left, outcome) , pb.toSolverExpression(expression.right, outcome))
			}//mult
		
			DIV: {
				pb.div(pb.toSolverExpression(expression.left, outcome) , pb.toSolverExpression(expression.right, outcome))
			}
			
			VarExpRef:{
				val type = expression.typeFor
				val name = expression.vref.name
				createVariable(pb, name, type)
			}
			
			intConstant:{
				val value = expression.value
				return new Integer(value)
			}
			
			realConstant:{
				val value = expression.value
				return new Double(value)
			}
			
			enumConstant:{				
				val actualValue = expression.value
				val parent = expression.getContainerOfType(EQUAL_DIFF)
				var exp = parent.left
				
				if(exp == expression){ exp = parent.right } //in case the variable is at the right hand of the comparison
				
				val enumVariable = ((exp as VarExpRef).vref as VAR_DECL)
				val enumSet =  (enumVariable.range as LSET).value 
				
				var index = 0
				
				for(enumValue : enumSet){
					index = index + 1
					if (enumValue.literalValue == actualValue) { return new Integer(index) }
				}//for
			}//enumConstant
			
			boolConstant:{
				throw new UnsupportedOperationException(" #### Boolean Constants are not allowed here #### ")
			}
			
			strConstant:{
			
			}
			
			hexConstant:{
				throw new UnsupportedOperationException(" #### hexadecimal not supported yet #### ")
			}
			
			bitConstant:{
				throw new UnsupportedOperationException(" #### bit not supported yet #### ")
			}
			
			default:{
				throw new RuntimeException(" #### unknown expression #### ")
			}//default		
				
		}	
	}//toSolverExpression
	
	
	/**
	 * Deal with variable creation in the solver
	 */
	def static private createVariable(ProblemCoral pb, String varName, String varType) {
		
		switch(varType){
			
			case "int" : {
				if (intVars.containsKey(varName)){
					return intVars.get(varName)
				}
				else{
					val value = pb.makeIntVar(varName, IMIN , IMAX)
					val putValue = intVars.put(varName, value)
					return value
				}
			}//case int
			
			case "real" : {
				if (doubleVars.containsKey(varName)){
					return doubleVars.get(varName)
				}
				else{
					val value = pb.makeRealVar(varName, DMIN , DMAX)
					val putValue = doubleVars.put(varName, value)
					return value
				}
			}//case real
			
			case "bool" : {
				throw new RuntimeException(" #### Boolean are not allowed here #### ")
			}
			
			case "enum" : {
				if (intVars.containsKey(varName)){
					return intVars.get(varName)
				}
				else{
					val enumVar = pb.makeIntVar(varName, IMIN , IMAX)
					val putValue = intVars.put(varName, enumVar)
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
	 * Put dsl interface variables in the  map  
	 */
	def static private recordDslVariables(MODULE_DECL module, Map<String,Object> dslVarsMap){
		
		val listOfVariables = module.interface.declaration.filter(VAR_DECL) //module interface variables
		
		dslVarsMap.clear //clear the map
		
		listOfVariables.forEach[ 			
			variable | val name = variable.name
			dslVarsMap.put(name, variable)	
		]//forEach
	
	}//dslVariables
	

}//class