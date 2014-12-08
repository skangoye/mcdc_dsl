/*
 * generated by Xtext
 */
package org.xtext.validation

import org.eclipse.xtext.validation.Check
import org.xtext.moduleDsl.MODULE_DECL
import org.xtext.moduleDsl.LANGUAGE
//import static extension org.eclipse.emf.ecore.util.EcoreUtil.*
import org.xtext.moduleDsl.ModuleDslPackage
import org.xtext.moduleDsl.CRITERION_DECL
import org.xtext.moduleDsl.STRATEGY
import org.xtext.moduleDsl.DATASEL_DECL
import org.xtext.moduleDsl.DATASEL
import org.xtext.moduleDsl.VAR_DECL
import org.xtext.moduleDsl.RANGE
import org.xtext.moduleDsl.INTERVAL
import org.xtext.moduleDsl.intLITERAL
import org.xtext.moduleDsl.realLITERAL
import org.xtext.moduleDsl.boolLITERAL
import org.xtext.moduleDsl.strLITERAL
import org.xtext.moduleDsl.enumLITERAL
import org.xtext.moduleDsl.hexLITERAL
import org.xtext.moduleDsl.bitLITERAL
import org.xtext.moduleDsl.unknowLITERAL
import org.xtext.moduleDsl.Literal
import org.xtext.moduleDsl.LSET
import org.xtext.moduleDsl.INTERFACE
import org.xtext.moduleDsl.BODY
import org.xtext.moduleDsl.CST_DECL
import org.xtext.moduleDsl.TmpVAR_DECL
import com.google.inject.Inject
import org.xtext.moduleDsl.EXPRESSION
import org.eclipse.emf.ecore.EReference
import org.xtext.moduleDsl.ADD
import org.xtext.moduleDsl.EQUAL_DIFF
import org.xtext.moduleDsl.COMPARISON
import org.xtext.moduleDsl.SUB
import org.xtext.moduleDsl.DIV
import org.xtext.moduleDsl.MULT
import org.xtext.moduleDsl.OR
import org.xtext.moduleDsl.NOT
import org.xtext.moduleDsl.AND
import org.xtext.moduleDsl.ERROR_STATEMENT
import org.xtext.moduleDsl.IF_STATEMENT
import org.xtext.moduleDsl.LOOP_STATEMENT
import org.xtext.moduleDsl.ASSIGN_STATEMENT
import org.xtext.moduleDsl.VarExpRef
import org.xtext.moduleDsl.STATEMENT
import org.xtext.moduleDsl.enumConstant
import org.xtext.moduleDsl.AbstractVAR_DECL
import java.util.ArrayList
import java.util.List
import org.xtext.moduleDsl.VAR_REF

import static extension org.xtext.type.provider.ExpressionsTypeProvider.*
import static extension org.eclipse.xtext.EcoreUtil2.*
import org.xtext.type.provider.ExpressionsTypeProvider

//import org.eclipse.xtext.validation.Check

/**
 * Custom validation rules. 
 *
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
class ModuleDslValidator extends AbstractModuleDslValidator {

/**#####################################################################################################
 * Module name validation rule:																		   #
  ######################################################################################################*/
 
 //module name must be unique
 public static val INVALID_NAME = 'invalidName'
 public static val INVALID_INPUT = 'invalidInput'  
 
 	@Check
	def checkModuleNameIsUnique (MODULE_DECL module) {
		val lang = module.getContainerOfType(LANGUAGE)
		val dup = lang.modules.findFirst[it != module && it.name == module.name]
			if (dup != null) {	
				error("Duplicate module name " + module.name + "!", 
					ModuleDslPackage.Literals.MODULE_DECL__NAME, INVALID_NAME )
			}	
	}
	

 /**#####################################################################################################
 * Strategy part validation rules																	   #
  ######################################################################################################*/
  
 	//Check criterion declaration within the strategy field
 	@Check
	def checkCriterionDeclaration(CRITERION_DECL decl){
		
		val criterion = decl.crit
			
		if (criterion == null ){
			error("coverage criterion must be defined", null)
		}
	}
	
	//Check that data selection criterion is defined
	@Check
	def checkDataSelDecl(DATASEL_DECL decl){
		
		val strategy = decl.getContainerOfType(STRATEGY)
		val criterion = strategy.critdecl
		val data1 = decl.data1
		val data2 = decl.data2
		
		if(criterion == null){
			error("coverage criterion must be defined before", null)
		}
		else{
			if (data1 == null && data2 == null ){
				error("data selection criterion must be defined", null)
			}
		}
	}
	
	//Check that data selection criteria are distinct
	@Check
	def checkDataSelectElementsAreDif(DATASEL data) {
		val strat = data.getContainerOfType(STRATEGY)
		val data1 = strat.dataseldecl.data1
		val data2 = strat.dataseldecl.data2
			 if  (data1.sel == data2?.sel)  {
				error("data selection criteria must be distinct!", 
					ModuleDslPackage.Literals.DATASEL__SEL, INVALID_INPUT )
			 }		
	}
	
/**#####################################################################################################
 * Interface part validation rules																	   #
  ######################################################################################################*/
	 
	 
	 /**
	 * check constant variable declaration
	 */
	 
	 //Check variable declaration
	@Check
	def checkVarDecl(VAR_DECL v){
		
		val inInterface = v.getContainerOfType(INTERFACE)
		val inBody = v.getContainerOfType(BODY)
		
		if(inBody != null || inInterface== null){
			error("interface variables are not allowed in this area", null)
		}
		else{
			val flow = v.flow?.flow
			if (flow != null){
				val name = v.name
				if (name == null){
					error("variable name expected", null)
				}
				else{ 
					if (v.type == null){ ///////////////
						error("variable type declaration missing", ModuleDslPackage.Literals.ABSTRACT_VAR_DECL__NAME)
					}
					else {
						val type = v.type.type
						if (v.range == null) {
							if (type == 'enum'){
								error("An enumeration variable must declare a set of values!", ModuleDslPackage.Literals.ABSTRACT_VAR_DECL__TYPE)
							}
						}
						else{
							return
						}
						
					}
				}
			}
		}
	}
	
	//Check type consistency with range type
	@Check
	def checkTypeWithRange(RANGE range) {
		if (range instanceof INTERVAL)
			checkTypeWithIntervalConsistency((range as INTERVAL))
		else
			checkTypeWithSetConsistency((range as LSET))
	}
	
	//check interval's type consistency
	def private checkTypeWithIntervalConsistency(INTERVAL interval) {
		val type = interval.getContainerOfType(VAR_DECL).type.type
		
		if (type == null){
			return
		}
			
		if (type == 'bool') {
			error("Interval is not allowed for Boolean types", null)
		}
		else {
			if (type == 'str') {
				error("Interval is not allowed for String types", null)
			}
			else {
				if (type == 'enum') {
					error("Interval is not allowed for Enumeration types", null)
				}
				else{
					val minType = interval.min?.typeProvider
					val maxType = interval.max?.typeProvider
					
					if(minType == null || maxType==null){
						error("Incorrect interval type declaration",null)
					}
					else{
						if (minType != type && minType != 'neutral'){
							error("The value must be of type: " + type, ModuleDslPackage.Literals.INTERVAL__MIN)
						}
						if (maxType != type && maxType != 'neutral'){
							error("The value must be of type: " + type, ModuleDslPackage.Literals.INTERVAL__MAX)
						}
					}
							
				}
			} 
		}
		//check that min < max
		checkIntervalValuesConsistency(interval)
	}
	
	//check set's type consistency
	def private checkTypeWithSetConsistency(LSET set){
		val type = set.getContainerOfType(VAR_DECL).type
		
		if(type == null){
			return //no check
		}
		else{
			if (type == 'bool'){
				error("Set is not allowed for Boolean types", null)
			}
			else{//set supported by variable type
				if(set.value.size == 0){
					error("Incorrect set type declaration",null)
				}
			}
		}
	}
	
	//check the consistency of values within an interval
	def private checkIntervalValuesConsistency(INTERVAL interval) {
		val mintype = interval.min?.typeProvider
		val maxtype = interval.max?.typeProvider
		
		if ( mintype == maxtype && mintype !=null){
			val commonType = mintype
			
			if (commonType == 'int'){
				val minval = interval.min as intLITERAL
				val maxval = interval.max as intLITERAL
				if (minval.value >= maxval.value) {
					error("Incorrect interval type declaration: lower bound value must be less than upper bound value",
						 ModuleDslPackage.Literals.INTERVAL__MIN)
				}
			}
			else{
				if (commonType == 'real'){
					val minval = interval?.min as realLITERAL
					val maxval = interval?.max as realLITERAL
					if (minval.value >= maxval.value) {
						error("Incorrect interval type declaration: lower bound value must be less than upper bound value",
						 ModuleDslPackage.Literals.INTERVAL__MIN)
					}
				}
			}
			
			////TODO Add other variables that allow Intervals: bit, hex	
		}
	}
	
	//check set consitency between its values and its type
	@Check
	def checkValuesConsistencyInSET(Literal literal){
		val variable = literal.getContainerOfType(VAR_DECL)
		val literalSet = literal.getContainerOfType(LSET)
		
		if(variable != null && literalSet != null){
			//literal is contained in a variable and a set
			val vartype = variable.type?.type
			val literaltype = literal.typeProvider
			if(vartype != null && vartype != 'bool' && vartype != literaltype){
				//case literaltype == 'unknow is also handled here
				error("The value must be of type " + vartype, null)
			}
			else{
				//No error i.e literal type is conform to the variable type
				//literal is contained in a set
				if( (vartype != null) && (vartype==literaltype) && (vartype != 'bool') ){
					//call this method only if litreal type is conform i.e w.r.t to variable type
					checkNoDupValuesInSet(literal, literalSet)
				}
			}
			
		}
	}
	
	//check that values defined in set are distinct
	def private checkNoDupValuesInSet(Literal literal, LSET set) {
		val listLiteral = set.value
		val dup = listLiteral.findFirst[ (it != literal) && (it.valueProvider == literal.valueProvider) 
														 && (it.typeProvider == literal.typeProvider) ]
		//the add of condition (it.typeProvider == literal.typeProvider) ensures that 
		//two literals are equal if they "toString" methods on theirs values match as well as they types
		if (dup != null) {	
			error("set's elements must be distinct", null)
		}	
	}
	
	def private String valueProvider(Literal literal) {
		switch (literal){
			intLITERAL    : literal.value.toString
			realLITERAL   : literal.value.toString
			boolLITERAL   : literal.value.toString
			strLITERAL    : literal.value.toString
			enumLITERAL   : literal.value.toString
			bitLITERAL    : literal.value.toString
			hexLITERAL    : literal.value.toString
			unknowLITERAL : literal.value.toString
		}
	}
	
	/**
	 * check constant declaration
	 */
	 
	//check constant declaration	
	@Check
	 def checkConstDecl(CST_DECL const){
	 	
	 	val inInterface = const.getContainerOfType(INTERFACE)
		val inBody = const.getContainerOfType(BODY)
		
		if(inBody != null || inInterface== null){
			error("interface constants are not allowed in this area", null)
		}
		else{
			val flow = const.flow
		 	if (flow != null){
				if (const.type == null){
					error("constant type must be declared", ModuleDslPackage.Literals.CST_DECL__FLOW)
				}
				else{
					val type = const.type.type
					if(type=="enum"){
						error("A constant variable cannot be of type 'enumeration'", ModuleDslPackage.Literals.ABSTRACT_VAR_DECL__TYPE)
					}
					else{
						val name = const.name
						if (name == null){ 
							error("constant name is expected", ModuleDslPackage.Literals.CST_DECL__FLOW)
						}
						else {
							if ( const.value == null) {
								error("Value must be defined for the constant", ModuleDslPackage.Literals.ABSTRACT_VAR_DECL__TYPE)
							}
							else {
								if (type != const.value.typeProvider){
									error("The value must be of type " + type, ModuleDslPackage.Literals.CST_DECL__VALUE)
								}
							}
						}
					}  
				}
			}
		}
	 }	
	
		
	/**
	 * check temporary variables declaration
	 */
	 
	 //check temporary variables declaration
	@Check
	def checkTmpVarDecl(TmpVAR_DECL tmp){
	 	val inInterface = tmp.getContainerOfType(INTERFACE)
		val inBody = tmp.getContainerOfType(BODY)
		
		if(inBody == null || inInterface != null){
			error("temporary variables are not allowed in this area", null)
		}
		else{
			val type = tmp.type.type
			if(type != null && type != "enum"){
				val name = tmp.name
				if (name == null) { 
					error("variable name is expected", ModuleDslPackage.Literals.ABSTRACT_VAR_DECL__TYPE)
				}
				else{
					val value = tmp.value
					if(value == null){
						error("initialization value must be set for the variable", ModuleDslPackage.Literals.ABSTRACT_VAR_DECL__TYPE)
					}
					else{
						//check that the value is consistent with the type
						val valtype = value.typeFor
						val normalizedType = tmp.varTypeProvider //tranform type (e.g. int => intType)
						if(normalizedType != valtype){
							error("initialization value must be of type " + type, ModuleDslPackage.Literals.TMP_VAR_DECL__VALUE)
						}
					}
				}
			}
			else{
				if(type == "enum"){
					error("A temporary variable cannot be of type 'enumeration' ", ModuleDslPackage.Literals.ABSTRACT_VAR_DECL__TYPE)
				}
			}
		}
		
	}
	
	//Check that variables' names are unique
	@Check
	def CheckVarNamesAreUnique(AbstractVAR_DECL abstrVar){
		val varInInterface = abstrVar.getContainerOfType(MODULE_DECL).interface.declaration
		val stmtInBody = abstrVar.getContainerOfType(MODULE_DECL).body.statements
		
		val varInModule = new ArrayList<AbstractVAR_DECL>
		varInStatements(stmtInBody, varInModule)
		
		varInModule.addAll(varInInterface)
		
		val dup = varInModule.findFirst[ (it != abstrVar && it.name == abstrVar.name) ]
		if (dup != null){
			error("Variable/constant name should be unique", ModuleDslPackage.Literals.ABSTRACT_VAR_DECL__NAME, INVALID_NAME )
		}
	}
	
	//Check forward references
	@Check
	def checkForwardReference(VarExpRef vref){ 
		val variable = vref.vref
		if( (variable!=null) && (variable instanceof TmpVAR_DECL) && !(vref.variablesDefinedBefore.contains(variable) )) {
			error("variable forward reference not allowed",ModuleDslPackage.Literals.VAR_EXP_REF__VREF)
		}
	}
	
	//Check forward references
	@Check
	def checkForwardReference(VAR_REF vref){ 
		val variable = vref.variable
		if( (variable!=null) && (variable instanceof TmpVAR_DECL) && !(vref.variablesDefinedBefore.contains(variable) )) {
			error("variable forward reference not allowed",ModuleDslPackage.Literals.VAR_REF__VARIABLE)
		}
	}
	
	//provide the list of variables defined before the variable vref
	def private variablesDefinedBefore(VAR_REF vref){
		val Stmt = vref.getContainerOfType(MODULE_DECL).body.statements
		val allStmt = new ArrayList<STATEMENT>
		allStatements(Stmt, allStmt)
		
		val containingVariable = allStmt.findFirst[isAncestor(it,vref)]
		
		val occ = allStmt.indexOf(containingVariable)
		return (allStmt.subList(0, occ)).typeSelect(typeof(TmpVAR_DECL))
	} 
	
	//provide the list of variables defined before the variable vref
	def private variablesDefinedBefore(VarExpRef vref){
		val Stmt = vref.getContainerOfType(MODULE_DECL).body.statements
		val allStmt = new ArrayList<STATEMENT>
		allStatements(Stmt, allStmt)
		
		val containingVariable = allStmt.findFirst[isAncestor(it,vref)]
		
		val occ = allStmt.indexOf(containingVariable)
		if(occ !=-1){
			return (allStmt.subList(0, occ)).typeSelect(typeof(TmpVAR_DECL))	
		}
	} 
	
	//lists all statements defined within module body
	def private void allStatements(List<STATEMENT> listOfStmt, List<STATEMENT> allStmt){
		for(stmt:listOfStmt){
			if(stmt instanceof AbstractVAR_DECL){
				allStmt.add(stmt)
			}
			else{
				if (stmt instanceof IF_STATEMENT){
					val ifst = (stmt as IF_STATEMENT).ifst
					val elst = (stmt as IF_STATEMENT).elst
					allStatements(ifst, allStmt)
					allStatements(elst, allStmt)
				}
				else{
					if(stmt instanceof LOOP_STATEMENT){
						//TODO: Implement this case
						allStmt.add(stmt)
					}
					else{
						allStmt.add(stmt)//nothing to do
					}
				}
			}
		}
	}//
	
	//lists all variables defined within module body
	def private void varInStatements(List<STATEMENT> listOfStmt, List<AbstractVAR_DECL> listOfVar){
		for(stmt:listOfStmt){
			if(stmt instanceof AbstractVAR_DECL){
				listOfVar.add(stmt as AbstractVAR_DECL)
			}
			else{
				if (stmt instanceof IF_STATEMENT){
					val ifst = (stmt as IF_STATEMENT).ifst
					val elst = (stmt as IF_STATEMENT).elst
					varInStatements(ifst, listOfVar)
					varInStatements(elst, listOfVar)
				}
				else{
					if(stmt instanceof LOOP_STATEMENT){
						//TODO: Implement this case
					}
					else{
						//nothing to do
					}
				}
			}
		}
	}
	 
	def private String typeProvider(Literal literal) {
		switch (literal){
			intLITERAL    : 'int'
			realLITERAL   : 'real'
			boolLITERAL   : 'bool'
			strLITERAL    : 'str'
			enumLITERAL   : 'enum'
			bitLITERAL    : 'bit'
			hexLITERAL    : 'hex'
			unknowLITERAL : 'neutral'
			default: null
		}
	}
	
/**#####################################################################################################
 * Expressions (boolean, arithmetic, string, enumeration) type checking 							   #									   
######################################################################################################*/
	
	//Check type for not operator
	 @Check
	 def checkType(NOT not){
	 	checkExpectedBoolean(not.exp, ModuleDslPackage.Literals.NOT__EXP)
	 }
	 
	 //Check type for AND operator
	 @Check
	 def checkType(AND and){
	 	checkExpectedBoolean(and.left, ModuleDslPackage.Literals.AND__LEFT)
	 	checkExpectedBoolean(and.right, ModuleDslPackage.Literals.AND__RIGHT)
	 }
	 
	 //Check type for OR operator
	 @Check
	 def checkType(OR or){
	 	checkExpectedBoolean(or.left, ModuleDslPackage.Literals.OR__LEFT)
	 	checkExpectedBoolean(or.right, ModuleDslPackage.Literals.OR__RIGHT)
	 }
	 
	 //Check type for MULT operator
	 @Check
	 def checkType(MULT mult){
	 	val leftType = getNonNullType(mult.left, ModuleDslPackage.Literals.MULT__LEFT)
	 	val rightType = getNonNullType(mult.right, ModuleDslPackage.Literals.MULT__RIGHT)
	 	
	 	checkNotIntandNotReal(leftType, ModuleDslPackage.Literals.MULT__LEFT)
	 	checkNotIntandNotReal(rightType, ModuleDslPackage.Literals.MULT__RIGHT)
	 }
	 
	 //Check type for DIV operator
	 @Check
	 def checkType(DIV div){
	 	val leftType = getNonNullType(div.left, ModuleDslPackage.Literals.DIV__LEFT)
	 	val rightType = getNonNullType(div.right, ModuleDslPackage.Literals.DIV__RIGHT)
	 	
	 	checkNotIntandNotReal(leftType, ModuleDslPackage.Literals.DIV__LEFT)
	 	checkNotIntandNotReal(rightType, ModuleDslPackage.Literals.DIV__RIGHT)
	 }
	 
	 //Check type for SUB operator
	 @Check
	 def checkType(SUB sub){
	 	val leftType = getNonNullType(sub.left, ModuleDslPackage.Literals.SUB__LEFT)
	 	val rightType = getNonNullType(sub.right, ModuleDslPackage.Literals.SUB__RIGHT)
	 	
 		checkNotIntandNotReal(leftType, ModuleDslPackage.Literals.SUB__LEFT)
	 	checkNotIntandNotReal(rightType, ModuleDslPackage.Literals.SUB__RIGHT)
	 }
	 
	 //Check type for Comparison operator
	 @Check
	 def checkType(COMPARISON comp){
	 	val leftType = getNonNullType(comp.left, ModuleDslPackage.Literals.COMPARISON__LEFT)
	 	val rightType = getNonNullType(comp.right, ModuleDslPackage.Literals.COMPARISON__RIGHT)
	 	
	 	checkExpectedSame(leftType, rightType)
	 	
	 	checkNotBoolean(leftType, ModuleDslPackage.Literals.COMPARISON__LEFT)
	 	checkNotBoolean(rightType, ModuleDslPackage.Literals.COMPARISON__RIGHT)
	 	
	 	checkNotString(leftType, ModuleDslPackage.Literals.COMPARISON__LEFT)
	 	checkNotString(rightType, ModuleDslPackage.Literals.COMPARISON__RIGHT)
	 	
	 	checkNotEnum(leftType, ModuleDslPackage.Literals.COMPARISON__LEFT)
	 	checkNotEnum(rightType, ModuleDslPackage.Literals.COMPARISON__RIGHT)
	 }
	 
	 //Check type for Equa-Diff operator
	 @Check
	 def checkType(EQUAL_DIFF eqdif){
	 	val leftType = getNonNullType(eqdif.left, ModuleDslPackage.Literals.EQUAL_DIFF__LEFT)
	 	val rightType = getNonNullType(eqdif.right, ModuleDslPackage.Literals.EQUAL_DIFF__RIGHT)
	 	
	 	checkExpectedSame(leftType, rightType)
	 	checkEnumBoolExpression(eqdif, leftType, rightType)
	 } 
	 
	 //Check type for ADD operator
	 @Check
	 def checkType(ADD add){
	 	val leftType = getNonNullType(add.left, ModuleDslPackage.Literals.ADD__LEFT)
	 	val rightType = getNonNullType(add.right, ModuleDslPackage.Literals.ADD__RIGHT)
	 	
	 	if ( (leftType == ExpressionsTypeProvider::intType || leftType == ExpressionsTypeProvider::realType)
	 		&& (rightType == ExpressionsTypeProvider::intType || rightType == ExpressionsTypeProvider::realType) ) {
	 		return
	 	}
	 	else {
	 		checkNotBoolean(leftType, ModuleDslPackage.Literals.ADD__LEFT)
	 		checkNotBoolean(rightType, ModuleDslPackage.Literals.ADD__RIGHT)
	 		
	 		checkNotEnum(leftType, ModuleDslPackage.Literals.ADD__LEFT)
	 		checkNotEnum(rightType, ModuleDslPackage.Literals.ADD__RIGHT)
	 		
	 		checkExpectedSame(leftType, rightType)
	 	}
	 	
	 }
	 
	 def private checkEnumBoolExpression(EQUAL_DIFF eqdif, String leftType, String rightType){
	 	if((leftType==ExpressionsTypeProvider::enumType) && (rightType==ExpressionsTypeProvider::enumType)){
	 		if( (eqdif.left instanceof VarExpRef) && (eqdif.right instanceof enumConstant) ){
	 			val enumVal = (eqdif.right as enumConstant).value
	 			val enumVar = (eqdif.left as VarExpRef).vref
	 			
	 			if(enumVar instanceof AbstractVAR_DECL){
	 				val enumRange = (enumVar as VAR_DECL).range
		 			if(enumRange instanceof LSET){
		 				val enumValues = (enumRange as LSET).value
		 				val existValInRange = enumValues.filter[ it instanceof enumLITERAL].exists[(it as enumLITERAL).value == enumVal]
		 				if(!existValInRange){
		 					error("This value is not an element of the enumeration "+ "'"+ enumVar.name+"'" , ModuleDslPackage.Literals.EQUAL_DIFF__RIGHT)
		 				}
		 			}
		 			else{
		 				return //will be handled by the VAR_DECL check rules
		 			}
	 			}
	 			else{
		 			return //will be handled by the VAR_DECL check rules
		 		}
	 			
	 		}
	 		else{
	 			if( (eqdif.left instanceof enumConstant) && (eqdif.right instanceof enumConstant) ){
	 				error("Cannot compare two enumeration's values", null)
	 			}
	 			else{
	 				if( (eqdif.left instanceof enumConstant) && (eqdif.right instanceof VarExpRef) ){
	 					error("This kind of comparison is not allowed; comparison must be of the form 'enumVariable ==/!= enumValue' ", null)
	 				}
	 				else{
	 					//eqdif.left is VarExpRef and eqdif.right is VarExpRef
	 					error("Cannot compare two enumeration variables", null)
	 				}
	 			}
	 		}
	 	}
	 }
	 
	def private String getNonNullType(EXPRESSION exp, EReference ref){
	 	var type = exp?.typeFor
	 	if(type == null){
	 		error("unknown type", ref)
	 	}
	 	return type
	 }
	 
	 def private checkExpectedBoolean(EXPRESSION exp, EReference ref){
	 	checkExpectedType(exp, ExpressionsTypeProvider::boolType,ref)
	 }
	 
	 def private checkNotBoolean(String type, EReference ref){
	 	if (type == ExpressionsTypeProvider::boolType){
	 		error("cannot be boolean", ref)
	 	}
	 }
	 
	 def private checkNotString(String type, EReference ref){
	 	if (type == ExpressionsTypeProvider::strType){
	 		error("cannot be string", ref)
	 	}
	 }
	 
	 def private checkNotEnum(String type, EReference ref){
	 	if (type == ExpressionsTypeProvider::enumType){
	 		error("cannot be enumeration", ref)
	 	}
	 }
	 
	 def private checkNotIntandNotReal(String type, EReference ref){
	 	if (type != ExpressionsTypeProvider::intType && type != ExpressionsTypeProvider::realType ){
	 		error("expected intType or realType, but was "+ type, ref)
	 	}
	 }
	 
	 def private checkExpectedType(EXPRESSION exp, String expectedType,EReference ref){
	 	val actualType = getNonNullType(exp,ref)
	 	if(actualType != expectedType){
	 		error("expected " + expectedType + " type, but was "+ actualType, ref)
	 	}
	 }
	 
	 def private checkExpectedSame(String leftType, String rightType){
	 	if(leftType != null && rightType!= null && leftType != rightType){
	 		error("expected the same type, but was " + leftType+ ", " + rightType, null)
	 	}
	 }
	 
/**#####################################################################################################
 * Check Statements' declarations						   											   #									   
######################################################################################################*/

 	//Check that no error statement have been used outside an IF/Loop statements
 	@Check
	 def checkNoErrorStatementOutOfIFandLoop (ERROR_STATEMENT err){
	 	val outif = err.getContainerOfType(IF_STATEMENT)
	 	val outloop = err.getContainerOfType(LOOP_STATEMENT)
	 	if(outif==null && outloop==null){
	 		error("error statement is only allowed within If/Loop declaration", null)
	 	} 	
	 }
	 
	 //Check that the conditional expression of IF_STATEMENT is of type Boolean
	 @Check
	 def checkIfExpressionIsBoolean(IF_STATEMENT ifinstr){
	 	val type = ifinstr.ifCond?.typeFor
	 	if(type != ExpressionsTypeProvider::boolType){
			error("expected boolean type, but was "+ type,  ModuleDslPackage.Literals.IF_STATEMENT__IF_COND)
	 	} 	
	 }

	 //Check that the loop conditional expression is of type Boolean
	 @Check
	 def checkLoopExpressionIsBoolean(LOOP_STATEMENT loop){
	 	val type = loop.loopCond?.typeFor
	 	if(type != ExpressionsTypeProvider::boolType){
			error("expected boolean type, but was "+ type,  ModuleDslPackage.Literals.LOOP_STATEMENT__LOOP_COND)
	 	} 	
	 }
	 
	//Check the consistency of an assignment statement
	 @Check
	 def checkAssignmentConsistency(ASSIGN_STATEMENT assign){
	 	checkSameTypeLeftRight(assign)
	 	checkLeftSideAssignmaentConsistency(assign, ModuleDslPackage.Literals.ASSIGN_STATEMENT__LEFT)
	 	checkEnumAssignConsistency(assign)
	 }
	 
	 //Check that every referenced variable at the right side of an assignment is not an output variable
//	 @Check
//	 def checkVarUsedInRightSide(VarExpRef vref){
//	 	val inAssignmentDecl = vref.getContainerOfType(ASSIGN_STATEMENT)
//	 	val abstrVar = vref.vref
//	 	if(inAssignmentDecl != null){
//	 		if (abstrVar instanceof VAR_DECL){
//	 			val flow = (abstrVar as VAR_DECL).flow.flow
//	 			if(flow == "out"){
//	 				error("An output variable cannot be used in an assignment's right-hand", null)
//	 			}
//	 		}
//	 	}
//	 }
	 
	 def private checkLeftSideAssignmaentConsistency(ASSIGN_STATEMENT assign, EReference ref){
	 	val leftSide = assign.left.variable
	 	if( leftSide instanceof CST_DECL){
	 		error("The left-hand side of an assignment must be a variable", ref)
	 	}
	 	else{
	 		if( leftSide instanceof VAR_DECL){
	 			if ((leftSide as VAR_DECL).flow?.flow == "in" ){
	 				error("The left-hand side of an assignment cannot be an input variable",ref)
	 			}
	 		}
	 	}
	 }
	 
	 def private checkSameTypeLeftRight(ASSIGN_STATEMENT assign){
	 	val leftType = assign.left?.variable?.varTypeProvider
	 	val rightType = assign.right?.typeFor
	 	if(leftType != rightType){
	 		if (leftType == null){
	 			return
	 		}
	 		else{
	 			if(rightType == null){
	 				error("connot assign unknown type to " + leftType + ", expected " + leftType, ModuleDslPackage.Literals.ASSIGN_STATEMENT__RIGHT)
	 			}
	 			else{
	 				error("connot assign "+ rightType + " to " + leftType + ", expected " + leftType, ModuleDslPackage.Literals.ASSIGN_STATEMENT__RIGHT)
	 			}
	 		}	
	 	}
	 }
	 
	 def private checkEnumAssignConsistency(ASSIGN_STATEMENT assign){
	 	val leftType =assign.left?.variable?.varTypeProvider
	 	val rightType = assign.right?.typeFor
	 	if((leftType==ExpressionsTypeProvider::enumType) && (rightType==ExpressionsTypeProvider::enumType)){
	 		if(assign.right instanceof enumConstant){
	 			val enumVal = (assign.right as enumConstant).value
	 			val enumVar = (assign.left.variable as VAR_DECL)
	 			val enumRange = enumVar.range
	 			if(enumRange instanceof LSET){
	 				val enumValues = (enumRange as LSET).value
	 				val existValInRange = enumValues.filter[ it instanceof enumLITERAL].exists[(it as enumLITERAL).value == enumVal]
	 				if(!existValInRange){
	 					error("This value is not an element of the enumeration "+ "'"+ assign.left.variable.name+"'" , ModuleDslPackage.Literals.ASSIGN_STATEMENT__RIGHT)
	 				}
	 			}
	 			else{
	 				return //will be handled by the VAR_DECL check rules
	 			}
	 		}
	 		else{
	 			error("An enumeration variable cannot be used as enumeration's value", ModuleDslPackage.Literals.ASSIGN_STATEMENT__RIGHT)
	 		}
	 	}
	 }
	 
	/*  def private checkNoConstantBooleanExpression(EXPRESSION expression){
	 	if(expression instanceof OR){
	 		val left = (expression as OR).left
	 		val right = (expression as OR).right
	 		
	 		if(left instanceof boolConstant || right instanceof boolConstant){
	 			error("", null)
	 		}
	 		else{
	 			checkNoConstantBooleanExpression(left)
	 			checkNoConstantBooleanExpression(right)
	 		}
	 		
	 	}
	 	else{
	 		if(expression instanceof AND){
	 			val left = (expression as AND).left
	 			val right = (expression as AND).right
	 			
	 			if(left instanceof boolConstant || right instanceof boolConstant){
	 				error("", null)
	 			}
	 			else{
	 				checkNoConstantBooleanExpression(left)
	 				checkNoConstantBooleanExpression(right)
	 			}
	 		}
	 		else{
	 			if(expression instanceof NOT){
	 				val exp = (expression as NOT).exp
	 				if(exp instanceof boolConstant){
	 					error("", null)
	 				}
	 				else{
	 					checkNoConstantBooleanExpression(exp)
	 				}
	 			}
	 			else{
	 				if(expression instanceof EQUAL_DIFF){
	 					val left = (expression as EQUAL_DIFF).left
	 					val right = (expression as EQUAL_DIFF).right
	 					if( (left instanceof intConstant) && (right instanceof intConstant)
	 					 || (left instanceof realConstant) && (right instanceof realConstant)
	 					 || (left instanceof strConstant) && (right instanceof strConstant)
	 					 || (left instanceof boolConstant) && (right instanceof boolConstant)	
	 					 || (left instanceof bitConstant) && (right instanceof bitConstant)
	 					 || (left instanceof hexConstant) && (right instanceof hexConstant)
	 					){
	 						error("",null)
	 					}
	 				}
	 				else{
	 					if(expression instanceof COMPARISON){
		 					val left = (expression as COMPARISON).left
		 					val right = (expression as COMPARISON).right
		 					if( (left instanceof intConstant) && (right instanceof intConstant)
		 					 || (left instanceof realConstant) && (right instanceof realConstant)
		 					 || (left instanceof strConstant) && (right instanceof strConstant)
		 					 || (left instanceof bitConstant) && (right instanceof bitConstant)
		 					 || (left instanceof hexConstant) && (right instanceof hexConstant)
	 					){
	 						error("",null)
	 					 }
	 					}
	 					else{
	 						return
	 					}
	 				}
	 			}
	 		}
	 	}
	 }*/
}//End Validation
