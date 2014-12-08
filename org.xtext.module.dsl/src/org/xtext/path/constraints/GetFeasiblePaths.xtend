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

class GetFeasiblePaths {
	
	val private static intPathVars = new HashMap<String, Object> //integer symbolic vars
	val private static doublePathVars = new HashMap<String, Object>
	val private static dslPathVars = new HashMap<String, Object>
	
	def static getFeasiblePaths(List<List<Triplet<List<String>,List<String>,List<String>>>> pathSet, MODULE_DECL module, MCDC_Statement mcdcStatement){
		val feasiblePaths = new ArrayList<List<Triplet<List<String>, List<String>, List<String>>>> 
		
		//set dslVars
		val listOfVariables = module.interface.declaration.filter(VAR_DECL)
		listOfVariables.forEach[ 
			variable | val symbName = variable.name.symbolicName
			dslPathVars.put(symbName , variable)
		]//forEach
		
		pathSet.forEach[ //remove infeasible paths
			path | 
			ProblemCoral.configure
			val pb = new ProblemCoral
			val pc = pathToPathCondition(module, path, mcdcStatement)
//			System.out.println
//			pc.forEach[ 
//				bt,i | System.out.println("cond: "+ i) bt.printPathCondition System.out.println
//			]
			val solve = pc.solvePathCondition(module , pb)
			if(solve==1){ feasiblePaths.add(path)}
//			System.out.println("Solving result: " + solve)
			pb.cleanup
			intPathVars.clear
			doublePathVars.clear
		]
		return feasiblePaths
	}//getFeasiblePaths
	
	def static int solvePathCondition(List<BinaryTree<Couple<String,String>>> PC, MODULE_DECL module, ProblemCoral pb){
				
		//PC to Coral 
		PC.forEach[
			elem | val invert = false 
			val ctr = translatePathElem(elem , pb , invert)
			pb.post(ctr)
		]
		
		setRangeConstraints(pb, dslPathVars, intPathVars, doublePathVars)
		
		return pb.solve
	}
	
	def private static symbolicName(String name){
		return name + "_0"
	}
	
	def static Object translatePathElem(BinaryTree<Couple<String,String>> pathElem , ProblemCoral pb , boolean invert ) {		
			
			val value = pathElem.value
			val operator = value.first
			
			switch (operator) {
				
				case "OR": {
					if(invert == true)//invert the or operator
						pb.and( pathElem.left.translatePathElem(pb, invert) , pathElem.right.translatePathElem(pb, invert))
					else
						pb.or( pathElem.left.translatePathElem(pb , invert) , pathElem.right.translatePathElem(pb, invert))
				}
				
				case "AND": {
					if(invert == true)//invert the and operator
						pb.or( pathElem.left.translatePathElem(pb, invert) , pathElem.right.translatePathElem(pb, invert))
					else
						pb.and( pathElem.left.translatePathElem(pb , invert) , pathElem.right.translatePathElem(pb, invert))
				}
				
				case "XOR": {///////////Not properly implemented
					if(invert == true)//invert the xor operator
						pb.xor( pathElem.left.translatePathElem(pb, invert) , pathElem.right.translatePathElem(pb, invert))
					else
						pb.xor( pathElem.left.translatePathElem(pb , invert) , pathElem.right.translatePathElem(pb, invert))
				}
				
				case "NOT": {
					if(invert == true){
						var new_invert = false
						pathElem.right.translatePathElem(pb , new_invert)
					}
					else{
						var new_invert = true
						pathElem.right.translatePathElem(pb, new_invert)
					}
				}
	
				case "==": {
					
//					val leftTree =  pathElem.left
//					val rightTree =  pathElem.right
//					val childType = leftTree.value.second
					
//					if(childType == "enum" || childType == "c_enum"){//Enumeration comparison => handle enumeration case
//						handleEnum(leftTree, rightTree, operator, invert, pb)
//					}
//					else{
						if(invert == true)//invert the == operator
							pb.neq( pathElem.left.translatePathElem(pb, invert) , pathElem.right.translatePathElem(pb, invert))
						else
							pb.eq( pathElem.left.translatePathElem(pb , invert) , pathElem.right.translatePathElem(pb, invert))
//					}
					
				}
				
				case "!=": {
					
//					val leftTree =  pathElem.left
//					val rightTree =  pathElem.right
//					val childType = leftTree.value.second
					
//					if(childType == "enum" || childType == "c_enum") {//Enumeration comparison => handle enumeration case
//						handleEnum(leftTree, rightTree, operator, invert, pb)
//					}
//					else{
						if(invert == true)//invert the != operator
							pb.eq( pathElem.left.translatePathElem(pb, invert) , pathElem.right.translatePathElem(pb, invert))
						else
							pb.neq( pathElem.left.translatePathElem(pb , invert) , pathElem.right.translatePathElem(pb, invert))
//					}	
				}
				
				case "<=": {
					if(invert == true)//invert the <= operator
						pb.gt( pathElem.left.translatePathElem(pb, invert) , pathElem.right.translatePathElem(pb, invert))
					else
						pb.leq( pathElem.left.translatePathElem(pb , invert) , pathElem.right.translatePathElem(pb, invert))
				}
				
				case ">=": {
					if(invert == true)//invert the or operator
						pb.lt( pathElem.left.translatePathElem(pb, invert) , pathElem.right.translatePathElem(pb, invert))
					else
						pb.geq( pathElem.left.translatePathElem(pb , invert) , pathElem.right.translatePathElem(pb, invert))
				}
			
				case "<": {
					if(invert == true)//invert the < operator
						pb.geq( pathElem.left.translatePathElem(pb, invert) , pathElem.right.translatePathElem(pb, invert))
					else
						pb.lt( pathElem.left.translatePathElem(pb , invert) , pathElem.right.translatePathElem(pb, invert))
				}
			
				case ">": {
					if(invert == true)//invert the < operator
						pb.leq( pathElem.left.translatePathElem(pb, invert) , pathElem.right.translatePathElem(pb, invert))
					else
						pb.gt( pathElem.left.translatePathElem(pb , invert) , pathElem.right.translatePathElem(pb, invert))
				}
			
				case "+": {
					pb.plus( pathElem.left.translatePathElem(pb, invert) , pathElem.right.translatePathElem(pb, invert))
				}
				
				case "-": {
					pb.minus( pathElem.left.translatePathElem(pb, invert) , pathElem.right.translatePathElem(pb, invert))
				}
				
				case "*": {
					pb.mult( pathElem.left.translatePathElem(pb, invert) , pathElem.right.translatePathElem(pb, invert))
				}
			
				case "/": {
					pb.div( pathElem.left.translatePathElem(pb, invert) , pathElem.right.translatePathElem(pb, invert))
				}
			
				default:{
					val type = value.second
					if(operator != ""){ dealWithVarsAndConst(pb, operator, type , invert) }
					else{ throw new RuntimeException(" #### Unknown expression #### ") }
				}//default		
				
			}	
	}
	
	
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
			
			case "enum" : {
				if (intPathVars.containsKey(varName)){
					return intPathVars.get(varName)
				}
				else{
					val enumVar = pb.makeIntVar(varName, -100 , 100)
					val putValue = intPathVars.put(varName, enumVar)
//					System.out.println
//					System.out.println("Map" + intPathVars.keySet.toString)
//					System.out.println("TOTO == " + varName)
//					System.out.println
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
			
			case "c_enum": { 
				val split = varName.split("@")
				val enumVar = split.get(0)
				val enumValue = split.get(1)		
//				System.out.println("enum value: " + enumValue)
//				System.out.println("enum var: " + enumVar)
				return new Integer( getIndexOfEnumValue(enumVar, enumValue))
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
	}//solvePath

/* 	def static handleEnum(BinaryTree<Couple<String,String>> left, BinaryTree<Couple<String,String>> right, String operator, boolean invert, ProblemCoral pb){
		
		val leftType = left.value.second
		val rightType = right.value.second
		val leftValue = left.value.first
		val rightValue = right.value.first
		
		switch(leftType){
			
			case "enum": {
				if(rightType=="c_enum"){
					if (intVars.containsKey(leftValue)){
						val enumVar = intVars.get(leftValue)
						val enumValue = getIndexOfliteral(leftValue, rightValue)
						return returnRightExpression(pb, enumVar, enumValue, operator, invert)
					}
					else{
						val enumVar = pb.makeIntVar(leftValue, -100 , 100)
						val putValue = intVars.put(leftValue, enumVar)
						val enumValue = getIndexOfliteral(leftValue, rightValue)
						return returnRightExpression(pb, enumVar, enumValue, operator, invert)
					}		
				}
				else{
					throw new UnsupportedOperationException(" #### Incorrect operation type #### ")
				}
			}//case enum
			
			case "c_enum": {
				if(rightType=="enum"){
					if (intVars.containsKey(rightValue)){
						val enumVar = intVars.get(rightValue)
						val enumValue = getIndexOfliteral(rightValue, leftValue)
						return returnRightExpression(pb, enumVar, enumValue, operator, invert)
					}
					else{
						val enumVar = pb.makeIntVar(rightValue, -100 , 100)
						val putValue = intVars.put(rightValue, enumVar)
						val enumValue = getIndexOfliteral(rightValue, leftValue)
						return returnRightExpression(pb, enumVar, enumValue, operator, invert)
					}		
				}
				else{
					if(rightType=="c_enum"){
						if(operator == "=="){
							if(invert == true)
								return pb.makeBoolConstant(leftValue != rightValue)
							else
								return pb.makeBoolConstant(leftValue == rightValue)
						}//if
						else{
							if(operator == "!="){
								if(invert == true)
									return pb.makeBoolConstant(leftValue == rightValue)
								else
									return pb.makeBoolConstant(leftValue != rightValue)
							}
						}//else								
					}//if c_enum
					else{
						throw new RuntimeException(" #### Incorrect type #### ")
					}
				}//else
			} 
		
		}//switch
									
	}//handleEnum*/
	
	def private static int getIndexOfEnumValue(String enumVar, String enumValue) {
	
		var index = -1		 
		val enumVarSymbName = enumVar.symbolicName
		val variable = dslPathVars.get(enumVarSymbName) //Actually, variables' names stored in dslVars are symbolic ones
		
		val list = ((variable as VAR_DECL).range as LSET).value //TODO: review this part
		
		for(e : list){
			index = index + 1
			if (e.literalValue == enumValue) 
				return index 
		}//for
		throw new Exception("#### Index not found ####")
	}//getIndexOfEnumValue
	
/* 	
	def static private Integer getIndexOfliteral(String varName,String value){
		var index = -1		
		val list = ((dslVars.get(varName) as VAR_DECL).range as LSET).value
		for(e : list){
			index = index + 1
			if (e.literalValue == value) 
				return new Integer(index) 
		}
		throw new Exception("Index not found")
	}
	
	def static private Object returnRightExpression( ProblemCoral pb , Object exp1, Object exp2, String operator, boolean invert){
		if (operator == "=="){
			if (invert == true)
				return pb.neq(exp1,exp2)
			else
				return pb.eq(exp1,exp2)
		}
		else{
			if (operator == "!="){
				if (invert == true)
					return pb.eq(exp1,exp2)
				else
					return pb.neq(exp1,exp2)
			}
			else{
				throw new RuntimeException(" #### Unknown operator type #### ")
			}
		}
	}
*/
}//class