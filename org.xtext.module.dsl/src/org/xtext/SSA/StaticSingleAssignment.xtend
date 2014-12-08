package org.xtext.SSA

import java.util.List
import org.xtext.helper.Triplet
import java.util.ArrayList
import org.xtext.helper.Couple
import org.xtext.moduleDsl.VarExpRef
import org.xtext.moduleDsl.EXPRESSION
import org.xtext.moduleDsl.ADD
import org.xtext.moduleDsl.SUB
import org.xtext.moduleDsl.MULT
import org.xtext.moduleDsl.DIV
import org.xtext.moduleDsl.bitConstant
import org.xtext.moduleDsl.boolConstant
import org.xtext.moduleDsl.enumConstant
import org.xtext.moduleDsl.hexConstant
import org.xtext.moduleDsl.intConstant
import org.xtext.moduleDsl.realConstant
import org.xtext.moduleDsl.strConstant
import org.xtext.moduleDsl.AND
import org.xtext.moduleDsl.OR
import org.xtext.moduleDsl.EQUAL_DIFF
import org.xtext.moduleDsl.NOT
import org.xtext.moduleDsl.COMPARISON
import org.xtext.mcdc.MCDC_Statement

import static extension org.xtext.utils.DslUtils.*


class StaticSingleAssignment {
	/**
	 * SSA algorithm for module paths 
	 */
	def static staticSingleAssignment(List<List<Triplet <List<String>, List<String>, List<String>>>> listOfList, MCDC_Statement mcdcStatement){
		
		for(list : listOfList){
					
			val defList = new ArrayList<Couple<String, Integer>>	
			
			for(triplet : list){ 
				val useList = new ArrayList<Couple<String, Integer>>
				//compute useList
				
				val identifier = triplet.third.extractIdentifier
				val identifierIndex = triplet.third.extractIdentIndex
				
				if(identifierIndex == "N"){//non boolean expression
					val varInExpression = mcdcStatement.getVarInNonBoolExpression(identifier.parseInt)
					useList.initUseList(varInExpression) //
					useList.updateUseList(defList)
					
					//replace use variables by theirs new names
					if(useList.size != 0){
						val expression = mcdcStatement.getNonBoolExpression(identifier.parseInt)
						val renamedList = new ArrayList<String>
						renameVarInExpression(expression, useList, renamedList)
						
						triplet.setSecond(renamedList)//
						
						defList.update(useList)///////////////
						useList.forEach[ use | if (use.second.intValue != -1) {defList.add(use)}]
					}
					
					val assignVar = triplet.first.get(0)
					if(assignVar != "*"){
						val defCouple = defList.updateDefList(assignVar)
						//replace the assignVar by a new name (i.e 'assignVar + index')
						triplet.first.set(0, defCouple.first + defCouple.second.addnameIndex)
					}
					
				}
				else{//identifierIndex == "F" or "T" or "X"
					val varInExpression = mcdcStatement.getVarInBoolExpression(identifier.parseInt)
					useList.initUseList(varInExpression) //varInExpression may be null
					useList.updateUseList(defList)
					
					val assignVar = triplet.first.get(0)
					
					//replace use variables by theirs new names
					if(useList.size != 0){
						val expression = mcdcStatement.getBoolExpression(identifier.parseInt)
						val renamedList = new ArrayList<String>
						renameVarInBoolExpression(expression, useList, renamedList)
						
						triplet.setFirst(renamedList)//
						triplet.first.add(0, assignVar)//replace the assignment variable in its position
						
						defList.update(useList)///////////////
						useList.forEach[ use | if (use.second.intValue != -1) {defList.add(use)}]
					}
					
					//val assignVar = triplet.first.get(0)
					if(assignVar != "*"){
						val defCouple = defList.updateDefList(assignVar)
						//replace the assignVar by a new name (i.e 'assignVar + index')
						triplet.first.set(0, defCouple.first + defCouple.second.addnameIndex)
					}
				}
			}
		}
	}
	
	def static private update(ArrayList<Couple<String, Integer>> defList, ArrayList<Couple<String, Integer>> useList) {
		defList.forEach[ 
			dv | useList.forEach[ uv | if (dv.first == uv.first) {uv.setSecond(-1)}]
		]
	}
	
	/**
	 * StaticSingleAssignment private method. It initializes a 'use list'.
	 * From a given expression, the set of variables that it uses is stored in the list 'list'.
	 * Then the init process consists to create for each variable 'var' an associated value that represents
	 * the index of the last redefined variable 'var'. 
	 * By default all variables values are '-1'
	 */
	def static private initUseList(List<Couple<String,Integer>> useList, List<String> list) {
		list.forEach[ 
			elem | useList.add( new Couple(elem, 0))
		]
	}
	
	/**
	 * StaticSingleAssignment private method. It updates the indexes of 'use list'.
	 */
	def static private updateUseList(List<Couple<String,Integer>> useList, List<Couple<String,Integer>> previousDefList){
		useList.forEach[ 
			use | previousDefList.forEach[ 
				previousDef | if(use.first == previousDef.first){ /*replace the second*/use.setSecond(previousDef.second) }
			]
		]
	}
	
	/**
	 * StaticSingleAssignment private method. It updates the indexes of a 'definition list'.
	 */
	def static private updateDefList(List<Couple<String,Integer>> defList, String assignVar) {
		
		for(defCouple: defList) { 
			if (defCouple.first == assignVar){ 
				val value = defCouple.second 
				defCouple.setSecond(value.intValue + 1)
				return defCouple
			}
		}
		val newCouple = new Couple(assignVar, 0)
		defList.add(newCouple)
		return newCouple
	}
	
	/**
	 * Renames the variables involved in the expression with theirs corresponding names 
	 * in the SSA form
	 */
	def static private renameVarInExpression(EXPRESSION expression, List<Couple<String,Integer>> useList, List<String> renamedList){
	  if( expression instanceof VarExpRef){
	  		renamedList.add(getNewName(useList, (expression as VarExpRef).vref.name)) //
	  }
	  else{
	  	renameVarInExpressionSubMethod(expression, useList, renamedList)
	  }
	  
	 }
	  
	 def static private Object renameVarInExpressionSubMethod(EXPRESSION expression, List<Couple<String,Integer>> useList, List<String> renamedList){
  		switch(expression){
  		
  		ADD: {
  			val toAdd =	"(" + renameVarInExpressionSubMethod(expression.left, useList, renamedList)+ "+" 
  			+  renameVarInExpressionSubMethod(expression.right, useList, renamedList) +")"
  			renamedList.add(toAdd)
  		}
  		
  		SUB: {
  			val toAdd =	"(" + renameVarInExpressionSubMethod(expression.left, useList, renamedList)+ "-" 
  			+  renameVarInExpressionSubMethod(expression.right, useList, renamedList) +")"
  			renamedList.add(toAdd)
  		}
  		
  		MULT: {
  			val toAdd =	"(" + renameVarInExpressionSubMethod(expression.left, useList, renamedList)+ "*" +  
  			renameVarInExpressionSubMethod(expression.right, useList, renamedList) +")"	
  			renamedList.add(toAdd)
  		}
  		
  		DIV: {
  			val toAdd =	"(" + renameVarInExpressionSubMethod(expression.left, useList, renamedList)+ "/" +  
  			renameVarInExpressionSubMethod(expression.right, useList, renamedList) +")"
  			renamedList.add(toAdd)
  		}
  		
	  		intConstant: expression.value.toString
	  		realConstant:expression.value.toString
	  		strConstant: expression.value.toString
	  		enumConstant: expression.value.toString
	  		boolConstant: expression.value.toString
	  		bitConstant: expression.value.toString
	  		hexConstant: expression.value.toString
	  		VarExpRef:  getNewName(useList, expression.vref.name)
	  		//default:""
  		}
	 }
	  
	 def static private Object renameVarInBoolExpression(EXPRESSION expression, List<Couple<String,Integer>> useList, List<String> renamedList){
	 	switch(expression){
	 		
	 		AND: {
	 			renameVarInBoolExpression(expression.left, useList, renamedList) 
	 			renameVarInBoolExpression(expression.right, useList, renamedList)
	 		}
	 		
	 		OR: {
	 			renameVarInBoolExpression(expression.left, useList, renamedList) 
	 			renameVarInBoolExpression(expression.right, useList, renamedList)
	 		}
	 		
	 		EQUAL_DIFF: { 
	 			val toAdd = renameVarInBoolExpression(expression.left, useList, renamedList) + expression.op + 
	 			renameVarInBoolExpression(expression.right, useList, renamedList)
	 			renamedList.add(toAdd)
	 		} 
	 		
	 		NOT: {
	 				renameVarInBoolExpression(expression.exp, useList, renamedList)
	 		}
	 		
	 		COMPARISON: {
	 			val toAdd = renameVarInBoolExpression(expression.left, useList, renamedList) + expression.op + 
	 			renameVarInBoolExpression(expression.right, useList, renamedList)
	 			renamedList.add(toAdd)
	 		}
	 		
	 		ADD: {
	 			"(" + renameVarInBoolExpression(expression.left, useList, renamedList) + "+" + 
	 			renameVarInBoolExpression(expression.right, useList, renamedList) + ")"
	 		}
	 		
	 		SUB: {
	 			 "(" + renameVarInBoolExpression(expression.left, useList, renamedList) + "-" + 
	 			renameVarInBoolExpression(expression.right, useList, renamedList) + ")"
	 		}
	 		
	 		MULT: {
	 			"(" + renameVarInBoolExpression(expression.left, useList, renamedList) + "*" + 
	 			renameVarInBoolExpression(expression.right, useList, renamedList) + ")"
	 		}
	 		
	 		DIV: {
	 			"(" + renameVarInBoolExpression(expression.left, useList, renamedList) + "/" + 
	 			renameVarInBoolExpression(expression.right, useList, renamedList) + ")"
	 		}
	 		
	 		VarExpRef: {
	 			val type = expression.vref.type.type
	 			if(type == "bool"){
	 				renamedList.add(getNewName(useList, expression.vref.name))
	 			}
	 			else{
	 				getNewName(useList, expression.vref.name)
	 			}	
	 		}
	 		
	 		intConstant: expression.value.toString
	  		realConstant:expression.value.toString
	  		strConstant: expression.value.toString
	  		enumConstant: expression.value.toString
	  		boolConstant: expression.value.toString
	  		bitConstant: expression.value.toString
	  		hexConstant: expression.value.toString
	 	}
	
	}
	 
	 def static getNewName(List<Couple<String,Integer>> useList, String name){
	 	for (use : useList) { 
			if(use.first == name){
				 val value = use.second.intValue
				 //if(value != -1){
				 	  return (name + value.addnameIndex)
				// }
				 //else{
				 	//return name
				 //}
			 }
	 	}
	 }
	 
	 /**
	  * Returns a new index value from an integer value.
	  * e.g: if value is 3 the returned value will be '|3|'
	  */
	 def static addnameIndex(int value){
	 	return ("|" + value + "|")
	 }
}