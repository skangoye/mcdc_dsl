package org.xtext.path.constraints

import java.util.ArrayList
import java.util.List
import org.xtext.helper.BinaryTree
import org.xtext.helper.Couple
import org.xtext.helper.Triplet
import org.xtext.moduleDsl.ADD
import org.xtext.moduleDsl.AND
import org.xtext.moduleDsl.COMPARISON
import org.xtext.moduleDsl.CST_DECL
import org.xtext.moduleDsl.DIV
import org.xtext.moduleDsl.EQUAL_DIFF
import org.xtext.moduleDsl.EXPRESSION
import org.xtext.moduleDsl.MODULE_DECL
import org.xtext.moduleDsl.MULT
import org.xtext.moduleDsl.NOT
import org.xtext.moduleDsl.OR
import org.xtext.moduleDsl.SUB
import org.xtext.moduleDsl.TmpVAR_DECL
import org.xtext.moduleDsl.VAR_DECL
import org.xtext.moduleDsl.VarExpRef
import org.xtext.moduleDsl.bitConstant
import org.xtext.moduleDsl.boolConstant
import org.xtext.moduleDsl.enumConstant
import org.xtext.moduleDsl.hexConstant
import org.xtext.moduleDsl.intConstant
import org.xtext.moduleDsl.realConstant
import org.xtext.moduleDsl.strConstant
import org.xtext.mcdc.MCDC_Statement

import static extension org.xtext.utils.DslUtils.*
import static extension org.eclipse.xtext.EcoreUtil2.*
import static extension org.xtext.type.provider.ExpressionsTypeProvider.*
import org.xtext.moduleDsl.ASSIGN_STATEMENT
import org.xtext.moduleDsl.MODULO

class pathConstraintsUtils {
	
	val private static final constTypePred = "c_" //Must precede constant types
	val private static final symbNameIndex = "_0" //symbolic variable names index
	
	/**
	 * Transforms a module_dsl expression into a new Binary tree expression. A tree value is represented here 
	 * by a couple where the first parameter is either the operator or variable name or constant value. 
	 * The second parameter is the type of the first parameter. Constants values types are preceded with the "c_" pattern 
	 */
	def static BinaryTree< Couple<String,String> > toBTExpression(EXPRESSION expression){
		val tmpTree = new BinaryTree< Couple<String,String> >() //new empty tree
		toBTExpression(expression, tmpTree)
		return tmpTree
	}//toBTExpression
	
	
	/**
	 * toBTExpression's private method
	 */
	def private static void toBTExpression(EXPRESSION expression, BinaryTree<Couple<String,String>> bt){
		switch(expression){
		
			OR: {	
				bt.setTree(new BinaryTree< Couple<String,String> >( new Couple("OR","bool")))
				expression.left.toBTExpression(bt.left)
				expression.right.toBTExpression(bt.right)
			}
			
			AND:{
				bt.setTree(new BinaryTree< Couple<String,String> >(new Couple("AND","bool")))
				expression.left.toBTExpression(bt.left)
				expression.right.toBTExpression(bt.right)
			}
			
			NOT:{
				bt.setTree(new BinaryTree< Couple<String,String> >(new Couple("NOT","bool")))
				bt.setLeft(new BinaryTree())
				expression.exp.toBTExpression(bt.right)
			}
			
			COMPARISON:{
				bt.setTree(new BinaryTree< Couple<String,String> >(new Couple(expression.op,"bool")))
				expression.left.toBTExpression(bt.left)
				expression.right.toBTExpression(bt.right)
			}
			
			EQUAL_DIFF:{
				bt.setTree(new BinaryTree< Couple<String,String> >(new Couple(expression.op,"bool")))
				expression.left.toBTExpression(bt.left)
				expression.right.toBTExpression(bt.right)
			}
			
			ADD:{
				bt.setTree(new BinaryTree< Couple<String,String> >(new Couple("+" , expression.left.typeFor)))
				expression.left.toBTExpression(bt.left)
				expression.right.toBTExpression(bt.right)
			}
			
			SUB:{
				bt.setTree(new BinaryTree< Couple<String,String> >(new Couple("-" , expression.left.typeFor)))
				expression.left.toBTExpression(bt.left)
				expression.right.toBTExpression(bt.right)
			}
			
			MULT:{
				bt.setTree(new BinaryTree< Couple<String,String> >(new Couple("*" , expression.left.typeFor)))
				expression.left.toBTExpression(bt.left)
				expression.right.toBTExpression(bt.right)
			}
			
			DIV:{
				bt.setTree(new BinaryTree< Couple<String,String> >(new Couple( "/" , expression.left.typeFor)))
				expression.left.toBTExpression(bt.left)
				expression.right.toBTExpression(bt.right)
			}
			
			MODULO:{
				bt.setTree(new BinaryTree< Couple<String,String> >(new Couple( "%" , expression.left.typeFor)))
				expression.left.toBTExpression(bt.left)
				expression.right.toBTExpression(bt.right)
			}
			
			VarExpRef:{
				bt.setTree(new BinaryTree< Couple<String,String> >(new Couple(expression.vref.name, expression.typeFor)))
			}
			
			enumConstant: { //find enum variable name
				val comparator = expression.getContainerOfType(EQUAL_DIFF)
	  			val assignment = expression.getContainerOfType(ASSIGN_STATEMENT)
	  			
	  			var enumVarName = ""
	  			
	  			if(comparator != null){//enumConstant's parent is either "==" or "!="
	  				var enumVariable = comparator.left	  			
	  				if(enumVariable != expression){	enumVarName = (enumVariable as VarExpRef).vref.name }
	  				else{ enumVarName = (comparator.right as VarExpRef).vref.name  }
	  			}
	  			else{ 
	  				if(assignment != null){ //enumConstant's parent is either an assignment
	  					var enumVariable = assignment.left.variable
	  					enumVarName = enumVariable.name
	  				}
	  			}
	  			
	  			//that way, we could track the enum variable name that concerns enum value 
	  			val enumVarName_Plus_EnumValue = enumVarName + "@" + expression.value.toString
	  			bt.setTree(new BinaryTree<Couple<String,String>>(new Couple(enumVarName_Plus_EnumValue, constTypePred + expression.typeFor)))
	  		}			
			
			intConstant: bt.setTree(new BinaryTree< Couple<String,String> >(new Couple(expression.value.toString, constTypePred + expression.typeFor)))
	  		
	  		realConstant: bt.setTree(new BinaryTree< Couple<String,String> >(new Couple(expression.value.toString, constTypePred + expression.typeFor)))
	  		
	  		strConstant: bt.setTree(new BinaryTree< Couple<String,String> >(new Couple(expression.value.toString, constTypePred + expression.typeFor)))
	  		
	  		boolConstant: bt.setTree(new BinaryTree< Couple<String,String> >(new Couple(expression.value.toString, constTypePred + expression.typeFor)))
	  		
	  		bitConstant: bt.setTree(new BinaryTree< Couple<String,String> >(new Couple(expression.value.toString, constTypePred + expression.typeFor)))
	  		
	  		hexConstant: bt.setTree(new BinaryTree< Couple<String,String> >(new Couple(expression.value.toString, constTypePred + expression.typeFor)))
		
		}
	
	}//toBTExpression
	
	
	/**
	 * Search in the Binary Tree Expression, a variable with name 'varName' and replace it with its corresponding value holding in assign couple
	 * 'varName is the first parameter of the couple assignCouple', the second parameter of the couple is the expression value (expressed over the symbolic values) of varName 
	 */
	def private static void findAndUpdateBTExpression(BinaryTree<Couple<String,String>> bt, Couple<String, BinaryTree<Couple<String,String>>> assignCouple){
		
		val varName = assignCouple.first 
		val expWithSymbValues = assignCouple.second //current value (expression with symbolic values) of the variable 'varName' 
		
		if(!bt.isEmpty()){ //search in the list of assigned variables, a variable that 
			if(bt.isLeaf){
				if(bt.value.first == varName){
					//set varName with its corresponding expression with symbolic values
					bt.setTree(expWithSymbValues)
				}
			}
			else{//recursive call on its siblings
				bt.left.findAndUpdateBTExpression(assignCouple)
				bt.right.findAndUpdateBTExpression(assignCouple)
			}	
		}//not empty
	
	}//findAndUpdateBTExpression
	
	
	/**
	 * Update the expression represented by Binary tree with the symbolic variables names
	 */
	def private static void findAndUpdateBTExpression(BinaryTree<Couple<String,String>> bt, List<Couple<String, BinaryTree<Couple<String,String>>>> assignList){	
		
		if(!bt.isEmpty()){ 
			if(bt.isLeaf){
				for(assignCouple: assignList){
					if (bt.value.first == assignCouple.first) {
						//set varName with its corresponding expression with symbolic values
						bt.setTree(assignCouple.second)
						return
					}
				}	
			}
			else{//recursive call on its siblings
				bt.left.findAndUpdateBTExpression(assignList)
				bt.right.findAndUpdateBTExpression(assignList)
			}		
	   }//not empty
	
	}//findAndUpdateBTExpression
	
	
	/**
	 * Update the assignment variables list. When a variable is assigned with a new expression (with symbolic values), we check whether or not this variable is in the 
	 * assignment list. If not a new couple is added in the assignment list. Otherwise, we update the value of the variable in the assignment list.
	 */
	def private static void updateAssignList(Couple<String, BinaryTree<Couple<String,String>>> assignCouple, List<Couple<String, BinaryTree<Couple<String,String>>>> assignList){
		for(assign: assignList){
			if(assign.first == assignCouple.first){//update the value of the variable and return
				assign.setSecond(assignCouple.second)
				return
			}
		}
		
		//variable is not in the list => add the new assignCouple in assignList
		assignList.add(assignCouple) 
	}//updateAssignList
	
	
	/**
	 * Return a Path Condition list from a given path sequence of instructions
	 */
	def static pathToPathCondition(MODULE_DECL module, List<Triplet<List<String>, List<String>, List<String>>> pathSequence, MCDC_Statement mcdcStatement){
		
		val pathConditionList = new ArrayList<BinaryTree<Couple<String,String>>> //path condition list
		val assignmentList = new ArrayList<Couple<String, BinaryTree<Couple<String,String>>>> //list<var_name, its_symbolic_expression>
		
		val listOfVariables = module.interface.declaration //module interface variables 
		
		//initialization of input variables with symbolic values
		//If a variable name is 'name', its corresponding symbolic name is 'name_0'
		listOfVariables.forEach[ 
			variable | switch (variable){
							
							VAR_DECL: {
								val varName = variable.name
								val symbName = varName + symbNameIndex
								val varType = variable.type.type
								val symbCouple = new Couple(varName, new BinaryTree<Couple<String,String>>(new Couple(symbName,varType)))
								assignmentList.add(symbCouple)//add to assignment list
							}
							
							CST_DECL:{ //constant  
								val cstName = variable.name
								val symbValue = variable.value.literalValue 
								val cstType = constTypePred + variable.type.type
								val symbCouple = new Couple(cstName, new BinaryTree<Couple<String,String>>(new Couple(symbValue,cstType)))
								assignmentList.add(symbCouple) //add to assignment list
							}
							
							TmpVAR_DECL:{
								val varName = variable.name
								val initExp = variable.value
								val bt = toBTExpression(initExp)
								
								//update bt expression with the symbolic values
								bt.findAndUpdateBTExpression(assignmentList)
								
								val symbCouple = new Couple(varName,bt)
								symbCouple.updateAssignList(assignmentList)
							}
							
					   }//switch
		]//listOfVariables
		
		//transform a path to a list of conditions
		pathSequence.forEach[ 
			sequence | val subIdentifier = sequence.third.extractIdentIndex 
					   val identifier = sequence.third.extractIdentifier
					 
					  if (subIdentifier == "N"){ //non boolean assignment statement
							
							val assignVar = sequence.first.get(0) //The list must hold one element
							val assignExp = mcdcStatement.getNonBoolExpression(identifier.parseInt) //retrieve the expression assigned to assignVar
							val bt = assignExp.toBTExpression //convert the expression to Binary Tree expression
							
							//update bt expression with the symbolic values
							bt.findAndUpdateBTExpression(assignmentList)
							
							val newAssignCouple = new Couple(assignVar, bt) //update the assignment var expression with bt(expressed over symbolic variables)
							newAssignCouple.updateAssignList(assignmentList) //update assignList with the above assignCouple
							
					  }//sequence index == N
					  else{ 
					  	  if(subIdentifier == "X"){ //boolean assignment 
					  		   
					  		   val assignVar = sequence.first.get(0) //The first element of the list is the assignment variable name
							   val assignExp = mcdcStatement.getBoolExpression(identifier.parseInt)//retrieve the expression assigned to assignVar
							   val bt = assignExp.toBTExpression //convert the expression to Binary Tree expression
							   
							   //update bt expression with the symbolic values
							   bt.findAndUpdateBTExpression(assignmentList)
							  
							   val newAssignCouple = new Couple(assignVar, bt)
							   newAssignCouple.updateAssignList(assignmentList)	
					  	 
					  	  }
					  	  else{
					  	  	  if(subIdentifier == "T" || subIdentifier == "F"){ //branch statement => update the PC list
					  	  	  		
					  	  	  		val branchExp = mcdcStatement.getBoolExpression(identifier.parseInt)
					  	  	  		val bt = branchExp.toBTExpression
					  	  	  		
					  	  	  		//update bt expression with the symbolic values
							   		bt.findAndUpdateBTExpression(assignmentList)
									
									if(subIdentifier == "T"){
										pathConditionList.add(bt)
									}
									else{ //invert the boolean expression and add it to pathConditionList
										val notBt = new BinaryTree(new Couple("NOT","bool")) 
										notBt.setRight(bt)
										pathConditionList.add(notBt)
									}
											  	  	  
					  	  	  }
					  	  	  else{
					  	  	  		throw new RuntimeException("Unknown subIdentifier: " + subIdentifier)
					  	  	  }
					  	  } 
					  }
		]//forEach
	
		return pathConditionList
	
	}//pathToPathCondition

	
	/**
	 * Print a path Condition
	 */
	def static void printPathCondition(BinaryTree<Couple<String,String>> pathCondition){
		if(!pathCondition.isEmpty()){
			if(!pathCondition.isLeaf()){
				System.out.print("(");
				pathCondition.left.printPathCondition();			
				System.out.print(" " + pathCondition.value.first  + "[" + pathCondition.value.second+"]");
				pathCondition.right.printPathCondition();
				System.out.print(")");
			}
			else{ //leaf
				System.out.print(" " + pathCondition.value.first +  "[" + pathCondition.value.second + "]");
			}
		}
	}//printPathCondition
	
	
}//class