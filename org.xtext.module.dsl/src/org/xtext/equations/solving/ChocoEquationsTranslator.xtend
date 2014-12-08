package org.xtext.equations.solving

import choco.kernel.model.variables.integer.IntegerVariable
import java.util.ArrayList
import java.util.List
import org.xtext.helper.Triplet
import org.xtext.mcdc.MCDC_Statement
import org.xtext.moduleDsl.ADD
import org.xtext.moduleDsl.AND
import org.xtext.moduleDsl.COMPARISON
import org.xtext.moduleDsl.CST_DECL
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
import org.xtext.solver.ProblemChoco

import static extension org.xtext.SSA.StaticSingleAssignment.*
import static extension org.xtext.utils.DslUtils.*

class ChocoEquationsTranslator {
	
	/**
	 * Translate and solve the equations provided by the buildEquations method over the Choco constraint solver
	 */
	def static void chocoEquationSolving(MCDC_Statement statement, List<Triplet<List<String>, List<String>, List<String> >> listOfEquations,
									List<Triplet<List<String>, List<String>, List<String>>> testPool){
		
		val chocoModel = new ProblemChoco() //choco model
		val integerVarOveralList = new ArrayList< List<IntegerVariable>>
		val listOfSubIdentifiers = new ArrayList<String> //
		var starIdent = 1 //
		
		for(equations: listOfEquations){
			
			/*rebuild the series of identifiers, separated by "#"*/
			listOfSubIdentifiers.addAll(equations.third)
			if(equations != listOfEquations.last){
				listOfSubIdentifiers.add("#")
			}
			
			val integerVarList = new ArrayList<IntegerVariable>
			
			val variables = equations.first //variables in the triplet
			val values = equations.second //corresponding values of the variables 
			val subIdentifier =  equations.third //boolean expression identifier (contained in a list)
			
			/*create variables with choco*/
			
			var cpt = 0
			val size = variables.size //variable list size
			
			do{
				var currentVar = variables.get(cpt) //variable to be declared as choco integer variable
				val correpondantValue = values.get(cpt) //corresponding value of the current variable 
	
				if((cpt == 0) && (currentVar == "*")){ 
					//assignment variable, in our approach '*' is considered as an assignment variable
					//of IF-THEN conditional expression. We need to make them name unique									
					currentVar = currentVar + starIdent.addnameIndex
					variables.set(0, currentVar) //replace the star '*' with another star with identifier
					starIdent = starIdent + 1 //
				
					if(correpondantValue == "*"){
						throw new RuntimeException("##### incorrect value #####")
					}
				}
				
				if(correpondantValue == "*"){//unknown variable value in the equation
					//define a boolean variable
					integerVarList.add(chocoModel.makeIntVar(currentVar, 0, 1 ) as IntegerVariable)
				}
				else{
					if(correpondantValue == "F"){
						//define a boolean variable with low bound == upper bound == 0
						integerVarList.add(chocoModel.makeIntVar(currentVar, 0, 0 ) as IntegerVariable)
					}
					else{
						if(correpondantValue == "T"){
							//define a boolean variable with low bound == upper bound == 1
							integerVarList.add(chocoModel.makeIntVar(currentVar, 1, 1 ) as IntegerVariable)
						}
						else{
							throw new RuntimeException("##### unknown value #####")
						}
					}
				}
			} while( (cpt=cpt+1) < size )
		
			//gather all choco integer variables in a list
			integerVarOveralList.add(integerVarList)
			
			/*create expressions with choco*/
			
			val condExpression = statement.getBoolExpression(subIdentifier.extractIdentifier.parseInt)
			val chocoExpression = chocoIntegerExpression(condExpression, chocoModel, integerVarList)
			
			val equationResult = values.get(0) //the first element of the values' list is the result of the boolean expression
			val chocoResultVariable = variables.get(0).getChocoIntegerVar(integerVarList)
			
			/*create constraints with choco*/
			
		 	if(equationResult == "T"){
				if (size == 1){ 
					//Here the size of the variable list is 1. 
					//That means that the variable is assigned with a boolean constant value ('true' or 'false')
					val constraint = chocoModel.eq(chocoExpression , chocoResultVariable) //
					chocoModel.addConstraint(constraint)//Add constraint
				}
				else{
					//The constraints must be >= chocoExpression and <= 1*(Nb of variables involved in expression except the first one) 
					val constraint1 = chocoModel.geq(chocoExpression , chocoResultVariable)
					val constraint2 = chocoModel.leq(chocoExpression , size-1) //
					chocoModel.addConstraint(constraint1)//Add constraint 1
					chocoModel.addConstraint(constraint2) ////Add constraints 2
				}
			}//if
			else{
				if(equationResult == "F"){
					val constraint = chocoModel.eq(chocoExpression , chocoResultVariable)
					//Add constraint
					chocoModel.addConstraint(constraint)
				}
				else{
					if(equationResult == "*"){
						////////////////To Do: re-implement this part
						val constraint = chocoModel.eq(chocoExpression , chocoResultVariable)
						//Add constraints
						chocoModel.addConstraint(constraint)
					}
					else{
						throw new RuntimeException("##### error: unknown value #####")	
					}
				}
			}//else
			
		}//for equations
	
		val solve = chocoModel.solve
		
	 	if(solve){
			addToTestPool(chocoModel, testPool, integerVarOveralList, listOfSubIdentifiers)
		}
		else{
			//System.out.println("Infeasible")
		}
		
	}//translateAndSolveEquationsWithChoco
	
	/**
	 * After the resolution of the equations with Choco solver, this method collects the solutions (if any)
	 * and add them to the test pool provided by concatMcdcValues  
	 */
	def static private void addToTestPool(ProblemChoco pb, List<Triplet<List<String>, List<String>, List<String>>> testPool, 
									List<List<IntegerVariable>> listOfIntegerVars, List<String> listOfsubIdentifiers){
		
		val listOfVariables = new ArrayList<String>
		var valueToAdd = "" //new ArrayList<String>
		
		for(list: listOfIntegerVars){
			
			for(intVar: list){
				val intVarName = intVar.getName()
				if(intVarName.charAt(0).toString == "*"){
					listOfVariables.add("*")
				}
				else{
					listOfVariables.add(intVarName)
				}
				
				valueToAdd = valueToAdd + pb.getIntValue(intVar).convertToBooleanChar
			}//for
			
			if(list != listOfIntegerVars.last){//Add the separator '#'
				listOfVariables.add("#")
				valueToAdd = valueToAdd + "#"
			}
		
		}//for
	
		//add
		val target = testPool.findFirst[it.first.equals(listOfVariables) && it.third.equals(listOfsubIdentifiers)]
		
		if(target != null){
			val values = target.second //.add(valueToAdd)
			if( !values.contains(valueToAdd) ){
				values.add(valueToAdd)
			}
		}
		else{
			throw new RuntimeException("##### Cannot find a target where to add a test case #####")
		}
	
	}//addToTestPool
	
	
	/**
	 * 
	 */
	def static Object chocoIntegerExpression(EXPRESSION exp, ProblemChoco pb, List<IntegerVariable> list){
 		switch(exp){
 			OR: pb.plus(exp.left.chocoIntegerExpression(pb,list), exp.right.chocoIntegerExpression(pb,list))
 			AND: pb.mult(exp.left.chocoIntegerExpression(pb,list), exp.right.chocoIntegerExpression(pb,list))
 			NOT: pb.minus(1, exp.exp.chocoIntegerExpression(pb,list))
 			COMPARISON:getIntegerVar( arithReprWithoutConstNames(exp.left) + exp.op + arithReprWithoutConstNames(exp.right), list)
 			EQUAL_DIFF: getIntegerVar(arithReprWithoutConstNames(exp.left) + exp.op + arithReprWithoutConstNames(exp.right), list)
 			VarExpRef: { 
 				val abstractVar = exp.vref
 				if(abstractVar instanceof CST_DECL)//boolean constant
 					return getBooleanConstantVar( (abstractVar as CST_DECL).value.literalValue.parseBoolean, pb)
 				else
 					return getIntegerVar(exp.vref.name, list)
 			}
 			boolConstant:getBooleanConstantVar(exp.value, pb)
 			//default:
 		}
	 }
	
	def static String arithReprWithoutConstNames(EXPRESSION expression){
	  	switch(expression){
	  		ADD: return "(" + arithReprWithoutConstNames(expression.left)+ "+" +  arithReprWithoutConstNames(expression.right) +")"
	  		SUB: return "(" + arithReprWithoutConstNames(expression.left)+ "-" +  arithReprWithoutConstNames(expression.right) +")"
	  		MULT: return "(" + arithReprWithoutConstNames(expression.left)+ "*" +  arithReprWithoutConstNames(expression.right) +")"
	  		DIV: return "(" + arithReprWithoutConstNames(expression.left)+ "/" +  arithReprWithoutConstNames(expression.right) +")"
	  		intConstant: return expression.value.toString
	  		realConstant: return expression.value.toString
	  		strConstant: return expression.value.toString
	  		enumConstant:return expression.value.toString
	  		boolConstant:return expression.value.toString
	  		bitConstant: return expression.value.toString
	  		hexConstant: return expression.value.toString
	  		VarExpRef:  {
	  			val abstractVar = expression.vref
	  			if(abstractVar instanceof CST_DECL)
	  				return (abstractVar as CST_DECL).value.literalValue
				else
					return abstractVar.name
	  		}
	  		default:""
	  	}
	  }
	  
	/**
	 * 
	 */
	 def static Object getBooleanConstantVar(boolean value, ProblemChoco pb){
	 	if(value){
	 		return pb.makeIntConst(1)
	 	}
	 	else{
	 		return pb.makeIntConst(0)
	 	}
	 }
	
	/**
	 * 
	 */
	def static private Object getIntegerVar(String varName , List<IntegerVariable> list){
	 	val listWithoutFirstElem = list.subList(1, list.size)//the first element is the assignment variable
	 	for(e: listWithoutFirstElem){
//	 		System.out.println(" name: " + e.name)
//	 		System.out.println(" norm name: " + e.name.normalizedName)
	 		if(varName == e.name.normalizedName){
	 			return e
	 		}
	 	}
	 	throw new Exception("Error choco: variable with name " + "'" + varName + "'" + " not found" )
	}
	 
	/**
	* Return name without The SSA identifiers
	*/
	def static normalizedName(String variable){ //name without SSA form
	 	val stringPattern = "((\\|)(\\d+)(\\|))"
	 	val tmp =  variable.split(stringPattern) 
	 	return tmp.arrayToString	
	}
	
	/**
	 * Return the choco IntegerVariable that has "str" as name  
	 */
	def static private Object getChocoIntegerVar(String str, List<IntegerVariable> list){
	 	for(e: list){
	 		if(e.name == str){
	 			return e
	 		}
	 	}
	 	throw new RuntimeException("##### Error choco: cannot find an IntegerVariable with name " + "'" +  str  + "'" + " #####")
	 }//getChocoIntegerVar
	
}//class