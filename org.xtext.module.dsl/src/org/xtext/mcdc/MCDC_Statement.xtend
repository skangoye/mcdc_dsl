package org.xtext.mcdc

import java.util.ArrayList
import java.util.List
import java.util.Set
import java.util.TreeSet
import org.xtext.helper.Couple
import org.xtext.helper.Triplet
import org.xtext.moduleDsl.ASSIGN_STATEMENT
import org.xtext.moduleDsl.AbstractVAR_DECL
import org.xtext.moduleDsl.ERROR_STATEMENT
import org.xtext.moduleDsl.EXPRESSION
import org.xtext.moduleDsl.IF_STATEMENT
import org.xtext.moduleDsl.STATEMENT
import org.xtext.moduleDsl.TmpVAR_DECL

import static extension org.xtext.utils.DslUtils.*

class MCDC_Statement {
	
	/**##########################################################################################################################
	* 																															#
	*											Attributes  and theirs getters                                                  #
	* 																															#
	############################################################################################################################*/
	
	val mcdcOfDecision= new MCDC_Of_Decision()
	
	val static final separator = "#"
	
	var boolIdentifier = -1 //Used for boolean expressions identification
	var notBoolIdentifier = -1 //Used for non-boolean expressions identification
	
	val listOfMcdcValues = new ArrayList<List<String>> //list that records the MCDC values of the different Boolean expressions
	
	val listOfBooleanExpression = new ArrayList<EXPRESSION> //list that records the different boolean expressions
	val listOfNonBooleanExpression = new ArrayList<EXPRESSION> //list that records the different non-boolean expressions
	val listOfVarInBoolExpression = new ArrayList<List<String>> //list that records the variables involved in all boolean expressions 
	val listOfVarInNonBoolExpression = new ArrayList<List<String>> //list that records the variables involved in all non-boolean expressions
	
	/** boolIdentifier incrementing
	 */
	def incrBooldentifier(int identifier){
		boolIdentifier = boolIdentifier + 1
	}
	
	/**notBoolIdentifier incrementing
	 */
	def incrNonBoolIdentifier(int identifier){
		notBoolIdentifier = notBoolIdentifier + 1
	}
	
	/**return all the expressions' 
	 */
	def getAllExpressionsMcdcValues(){
		return listOfMcdcValues
	}
	
	/**return all boolean expressions' 
	 */
	def getAllBooleanExpressions(){
		return listOfBooleanExpression
	}
	
	def getNonBooleanExpressions(){
		return listOfNonBooleanExpression
	}
	/** return the MCDC values of the expression stored at the index identifier of the list listOfMcdcValues
	 */
	def getMcdcValues(int identifier) {
		return listOfMcdcValues.get(identifier)
	}
	
	/**return the boolean expression stored at the index identifier of the list listOfBooleanExpression
	 */ 
	def getBoolExpression(int identifier){
		return listOfBooleanExpression.get(identifier)
	}
	
	/**return the non-boolean expression stored at the index identifier of the list listOfNonBooleanExpression
	 */ 
	def getNonBoolExpression(int identifier){
		return listOfNonBooleanExpression.get(identifier)
	}
	
	/**return the variables involved in the boolean expression stored at the index identifier of the list listOfVarInBoolExpression
	 */
	def getVarInBoolExpression(int identifier){
		return listOfVarInBoolExpression.get(identifier)
	}
	
	/**return the variables involved in the non-boolean expression stored at the index identifier of the list listOfVarInNonBoolExpression
	 */
	def getVarInNonBoolExpression(int identifier){
		return listOfVarInNonBoolExpression.get(identifier)
	}
	
	
	/**##########################################################################################################################
	* 																															#
	*											MCDC of the different instructions                                              #
	* 																															#
	############################################################################################################################*/
	
	/**
	 * We mainly rely on a triplet representation to store all needed information that will allow us to 
	 * compute the MCDC of a given program. 
	 * A triplet has three parameters: The first parameter represents the list of variables involved in the MCDC computation.
	 * Theirs corresponding values are listed in the second parameter. Finally the third parameter holds a value that in fact is
	 * the identifier (see above) of the expression that produces the values of the second parameter
	 * 
	 */
	
	
	/**
	 * return an MCDC triplet of an "error statement"
	 */
	def mcdcErrorStatement(ERROR_STATEMENT statement){
		return null
	}
	
	/**
	 * return a MCDC triplet of the variable
	 */
	def mcdcVarStatement(AbstractVAR_DECL statement){
		
		val tempVariable = (statement as TmpVAR_DECL) //temporary variable
		val expression = tempVariable.value //expression defined by the variable
		val variableType = statement.type.type //variable type
		
		val List<String> varInExpression = new ArrayList<String> //variables involved in the statement	
		varInExpression.add(tempVariable.name)
		
		val List<String> subIdentifier = new ArrayList<String> //subIdentifer is used to track expressions (bool or not; bool branches or not)
			
		if(variableType != "bool"){
			
			//increment non-boolean expression identifier and store the expression in "listOfNonBooleanExpression" list 
			notBoolIdentifier.incrNonBoolIdentifier()
			listOfNonBooleanExpression.add(notBoolIdentifier, expression)
			
			//Store the variables of the expression in listOfVarInNonBoolExpression list
			val set = new TreeSet<String>
			expression.allVarInExpression(set)
			listOfVarInNonBoolExpression.add(notBoolIdentifier, set.toList)
		
			//value of the expression
			val List<String> expressionValueToList = new ArrayList<String>
			expressionValueToList.add(stringReprOfExpression(expression))
			
			//compute the sub-identifier
			subIdentifier.add(notBoolIdentifier + "N")

			return new Triplet(varInExpression, expressionValueToList, subIdentifier)
		}
		else{//the expression of the statement is of "boolean"
		
			//increment boolean expression identifier and store the expression in "listOfBooleanExpression list" 
			boolIdentifier.incrBooldentifier()
			listOfBooleanExpression.add(boolIdentifier, expression)
			
			//Store the variables of the expression in listOfVarInBoolExpression list
			val set = new TreeSet<String>
			expression.allVarInExpression(set)
			listOfVarInBoolExpression.add(boolIdentifier, set.toList)
			
			//boolean variables involved in the expression
			booleanVarInExpression(expression, varInExpression)
			
			//get the MCDC values corresponding to the expression and add them to "listOfMcdcValues" list
			val mcdcValues = mcdcOfDecision.mcdcOfBooleanExpression(expression).reduceList
			listOfMcdcValues.add(boolIdentifier, mcdcValues)
			
			//compute the sub-identifier
			subIdentifier.add(boolIdentifier + "X")
			
			return new Triplet(varInExpression, mcdcValues, subIdentifier)
		}
	}//mcdcVarStatement
	
	/**
	 * return a MCDC triplet of the assignment statement
	 */
	def mcdcAssignStatement(ASSIGN_STATEMENT statement){
		
		val assign = (statement as ASSIGN_STATEMENT) 
		val expression = assign.right //expression defined by the statement
		val assignVariable = assign.left.variable //assignment variable
		val variableType = assignVariable.type.type
		
		val List<String> varInExpression = new ArrayList<String>
		varInExpression.add(assignVariable.name)
			
		val List<String> subIdentifier = new ArrayList<String>
		
		if(variableType != "bool"){
			
			//increment non-boolean expression identifier and store the expression in "listOfNonBooleanExpression list" 
			notBoolIdentifier.incrNonBoolIdentifier()
			listOfNonBooleanExpression.add(notBoolIdentifier, expression)
			
			//Store the variables of the expression in "listOfVarInNonBoolExpression" list
			val set = new TreeSet<String>
			expression.allVarInExpression(set)
			listOfVarInNonBoolExpression.add(notBoolIdentifier, set.toList)
			
			//value of the expression
			val List<String> expressionValueToList = new ArrayList<String>
			expressionValueToList.add(stringReprOfExpression(expression))
			
			//compute the sub-identifier
			subIdentifier.add(notBoolIdentifier + "N")
			
			return new Triplet(varInExpression, expressionValueToList, subIdentifier)
		}
		else{
			
			//increment boolean expression identifier and store the expression in "listOfBooleanExpression list" 
			boolIdentifier.incrBooldentifier()
			listOfBooleanExpression.add(boolIdentifier, expression)
		
			//Store the variables of the expression in "listOfVarInBoolExpression" list
			val set = new TreeSet<String>
			expression.allVarInExpression(set)
			listOfVarInBoolExpression.add(boolIdentifier, set.toList)
			
			//boolean variables involved in the expression
			booleanVarInExpression(expression, varInExpression)
			
			//get the MCDC values corresponding to the expression and add them to "listOfMcdcValues" list
			val mcdcValues = mcdcOfDecision.mcdcOfBooleanExpression(expression).reduceList
			listOfMcdcValues.add(boolIdentifier, mcdcValues)
			
			//compute the sub-identifier
			subIdentifier.add(boolIdentifier + "X")
			
			return new Triplet(varInExpression, mcdcValues, subIdentifier)
		}
	}//mcdcAssignStatement
	
	/**
	 * return a MCDC triplet of a IF-THEN-ELSE statement
	 */
	def mcdcIfStatement(IF_STATEMENT statement){
		
		val ifBooleanExpression = (statement as IF_STATEMENT).ifCond
		val mcdcValues = mcdcOfDecision.mcdcOfBooleanExpression(ifBooleanExpression)
		
		boolIdentifier.incrBooldentifier()
		listOfBooleanExpression.add(boolIdentifier, ifBooleanExpression)
		listOfMcdcValues.add(boolIdentifier, mcdcValues.reduceList)
		
		val set = new TreeSet<String>
		ifBooleanExpression.allVarInExpression(set)
		listOfVarInBoolExpression.add(boolIdentifier, set.toList)
			
		//boolean variables involved in the expression
		val List<String> varInExpression = new ArrayList<String>
		varInExpression.add("*") //extra "variable" used to designate the outcome of the IF-THEN boolean expression
		booleanVarInExpression(ifBooleanExpression, varInExpression)
				
		//split MCDC values into 2 disjoint parts: True for MCDC values that evaluate the expression to True
		//False otherwise
		val mcdcTrueValues =  (mcdcValues.filter[ it.second == "T"].toList).reduceList
		val mcdcFalseValues = (mcdcValues.filter[ it.second == "F"].toList).reduceList
		
		//create 2 types of sub-identifier
		val List<String> subIdentifierT = new ArrayList<String>
		val List<String> subIdentifierF = new ArrayList<String>
		subIdentifierT.add(boolIdentifier + "T")
		subIdentifierF.add(boolIdentifier + "F")

		
		val listT = new ArrayList<Triplet<List<String>, List<String>, List<String>>>
	 	val listF = new ArrayList<Triplet< List<String>, List<String>, List<String>>>
		listT.add(new Triplet(varInExpression, mcdcTrueValues, subIdentifierT)) 
		listF.add(new Triplet(varInExpression, mcdcFalseValues, subIdentifierF)) 
		
		val result = new ArrayList<List<Triplet<List<String>, List<String>, List<String>>>>
		
		//compute MCDC on the if-branch and on the else-branch
		mcdcOfConditional(statement.ifst, listT, result)
		mcdcOfConditional(statement.elst, listF, result)
		
		return result

	}//mcdcIfStatement
		
	/**
	 * Computes the MCDC of the IF-THEN-ELSE sub-instructions
	 */	
	def private void mcdcOfConditional(List<STATEMENT> statements, ArrayList<Triplet<List<String>, List<String>, List<String>>> triplets,
		List<List<Triplet<List<String>, List<String>, List<String>>>> result) {
		
		//Copy all the elements of the list "triplets" in listT and ListF
		val list = triplets.copyListOfTriplet
	 	
	 	var count = 0	
		for(st: statements){
			if(st instanceof ASSIGN_STATEMENT){
				val triplet = mcdcAssignStatement(st as ASSIGN_STATEMENT)
				if(triplet != null){
					list.add(triplet)
				}
			}
			else{
				if(st instanceof AbstractVAR_DECL){
					val triplet = mcdcVarStatement(st as AbstractVAR_DECL)
					if(triplet != null){
						list.add(triplet)
					}
				}
				else{
					if(st instanceof IF_STATEMENT){ //TODO: same as in mcdcIfStatement method
						
						count = count + 1
						
						val ifBooleanExpression = (st as IF_STATEMENT).ifCond
						val mcdcValues = mcdcOfDecision.mcdcOfBooleanExpression(ifBooleanExpression)
		
						boolIdentifier.incrBooldentifier()
						listOfBooleanExpression.add(boolIdentifier, ifBooleanExpression)
						listOfMcdcValues.add(boolIdentifier, mcdcValues.reduceList)
						
						val set = new TreeSet<String>
						ifBooleanExpression.allVarInExpression(set)
						listOfVarInBoolExpression.add(boolIdentifier, set.toList)
						
						val List<String> varInExpression = new ArrayList<String>
						varInExpression.add("*")
						booleanVarInExpression(ifBooleanExpression, varInExpression)
						
						val mcdcTrueValues = (mcdcValues.filter[ it.second == "T"].toList).reduceList
						val mcdcFalseValues = (mcdcValues.filter[ it.second == "F"].toList).reduceList
						
						val List<String> subIdentifierT = new ArrayList<String>
						val List<String> subIdentifierF = new ArrayList<String>
						subIdentifierT.add(boolIdentifier + "T")
						subIdentifierF.add(boolIdentifier + "F")

						
						val listT = new ArrayList< Triplet < List<String>, List<String>, List<String>>>
	 					val listF = new ArrayList< Triplet< List<String>, List<String>, List<String>>>
	 					listT.addAll(list)
	 					listF.addAll(list)
	 					listT.add(new Triplet(varInExpression, mcdcTrueValues, subIdentifierT))
	 					listF.add(new Triplet(varInExpression, mcdcFalseValues, subIdentifierF)) 
	 					
	 					//recursive call on mcdcOfConditional for the IF-THEN branch and for the ELSE branch
	 					mcdcOfConditional((st as IF_STATEMENT).ifst, listT, result)
						mcdcOfConditional((st as IF_STATEMENT).elst, listF, result)
					}
				}
			}
		}//for
		
		if(count == 0){ //test whether the last (before the next iteration) crossed statement is IF-THEN-ELSE or not
						//if not, add the list to the result list
			result.add(list)
		}
	}//mcdcOfConditional
	
	/**
	 * Merge the different statements' MCDC values together, according to different constraints: execution paths, variables names
	 * NB: listOfList represents an execution path in the program
	 */
	def mergeMcdcValues(List<List<Triplet< List<String>, List<String>, List<String> >>> listOfList) {
		
		val resultOfConcat = new ArrayList<Triplet<List<String>, List<String>, List<String>>>
		
		for(currentList: listOfList){
			val size = currentList.size
			if(size == 0){
				throw new RuntimeException("##### List size error #####")
			}
			else{
				if(size == 1){ //return the current triplet
					resultOfConcat.add(currentList.get(0))
				}
				else{//size > 1
					//copy in a new list the currentList's elements
					var  copyList = currentList.copyListOfTriplet.reverse
					if(copyList.noVarInCommon){ //All the triplets in copyList have no common variables 
						
						var triplet1 = copyList.get(1)
						var triplet2 = copyList.get(0)
						
						while(copyList.size != 1){
							//set the first element with the concatenated value
							copyList.set(0, mergeWithoutConstraints(triplet1,triplet2))
							copyList.remove(1)
							
							if(copyList.size != 1){
								triplet1 = copyList.get(1) //assign the second element of copyList to triplet1
								triplet2 = copyList.get(0) //assign the second element of copyList to triplet1
							}
						}
					
					}
					else{//some variables are propagated along the path
						var triplet1 = copyList.get(1)
						var triplet2 = copyList.get(0)
						while(copyList.size != 1){
							//set the first element with the concatenated value
							copyList.set(0, mergeWithConstraints(triplet1,triplet2))
							copyList.remove(1)
							
							if(copyList.size != 1){
								triplet1 = copyList.get(1) //assign the second element of copyList to triplet1
								triplet2 = copyList.get(0) //assign the second element of copyList to triplet1
							}
						}
					}
					
					resultOfConcat.add(copyList.get(0)) 
				
				}//else
			}
			
		}//for
		
		return resultOfConcat
	
	}//concatMcdcValues
	
	
	/**
	 * Same goal like concatMcdcValues but with a different approach 
	 */
	 def mergeMcdcValues2(List<List<Triplet< List<String>, List<String>, List<String> >>> listOfList) {
		
		val resultOfConcat = new ArrayList<Triplet<List<String>, List<String>, List<String> >>
		
		for(currentList: listOfList){
			val size = currentList.size
			if(size == 0){
				throw new RuntimeException("##### List size error #####")
			}
			else{
				if(size == 1){
					resultOfConcat.add(currentList.get(0))
				}
				else{//size > 1
					//copy in a new list the currentList's elements
					var  copyList = currentList.copyListOfTriplet.reverse
		
					var triplet1 = copyList.get(1)
					var triplet2 = copyList.get(0)
					
					while(copyList.size != 1){
						
						if( (triplet1.first.intersectionOfLists(triplet2.first)).size > 0 ) {
							//set the first element with the concatenated value
							copyList.set(0, mergeWithConstraints(triplet1,triplet2))
						}
						else{
							//set the first element with the concatenated value
							copyList.set(0, mergeWithoutConstraints(triplet1,triplet2))	
						}
						
						copyList.remove(1)
						
						if(copyList.size != 1){
							triplet1 = copyList.get(1) //assign the second element of copyList to triplet1
							triplet2 = copyList.get(0) //assign the second element of copyList to triplet1
						}
					}//while
					
					resultOfConcat.add(copyList.get(0)) 
					
				}//else
			}
			
		}//for
		
		return resultOfConcat
	
	}//concatMcdcValues
	
	/**
	 * Merge two triplets together without any variables constraints (i.e no data dependencies)
	 * N.B: the character "#" is used as a separator between two triplets values
	 */
	def private mergeWithoutConstraints(Triplet<List<String>,List<String>, List<String>> t1,Triplet<List<String>,List<String>, List<String>> t2) {
		
		val List<String> concatValues = new ArrayList<String> //concatenation list of the 'list1' and 'list2'
		val List<String> concatVariables = new ArrayList<String> //concatenation list of the list of Variables in t1 and t2 
		val List<String> concatIdents = new ArrayList<String> //concatenation list of the t1 and t2 identifiers
		
		concatVariables.addAll(t1.first)
		concatVariables.add("#")
		concatVariables.addAll(t2.first)
		
		concatIdents.addAll(t1.third)
		concatIdents.add("#")
		concatIdents.addAll(t2.third)
		
		val list1 = t1.second //list of MCDC values in t1
		val list2 = t2.second //list of MCDC values in t2
		
		val size1 = list1.size //size of list1
		val size2 = list2.size //size of list2
		
		if (size1 == 0 || size2 == 0){
			return new Triplet (concatVariables, concatValues, concatIdents)
		}
		
		val minSize = Math.min(size1, size2)
		val maxSize = Math.max(size1, size2)
		
		//concatenate the first 'minSize' elements of the two lists
		var i=0
		do{
			val v1 = list1.get(i)
			val v2 = list2.get(i)
			
			//merge v1 with w2, separated by "#"
			concatValues.add( v1 + "#" + v2) 
			
		} while ((i=i+1) < minSize)
		
		if (size1 < size2){//list2 is bigger than list1
			var j = minSize
			do{
				val index= (Math.random()*minSize).intValue //randomly choose an index in [0..minSize-1]
				
				val v1 = list1.get(index)
				val v2 = list2.get(j)
				
				concatValues.add( v1 + "#" + v2)
				
			} while ((j=j+1) < maxSize)
		}
		else{
			
			if (size1 > size2){//list1 is bigger than list2
				var k = minSize
				do{
					val index= (Math.random()*minSize).intValue //randomly choose an index in [0..minSize-1]
					
					val v1 = list1.get(k)
					val v2 = list2.get(index)
					
					concatValues.add( v1 + "#" + v2)
					
				} while ((k=k+1) < maxSize)
			}
		}//else
		
		return new Triplet (concatVariables, concatValues, concatIdents)
	}//concatWithoutConstraints
	
	/**
	 * Merge two triplets together by taking into account the variables constraints (data dependencies)
	 * N.B: the character "#" is used as a separator between two triplets values
	 */
	def private mergeWithConstraints(Triplet<List<String>,List<String>, List<String>> t1, Triplet<List<String>, List<String>, List<String>> t2){
		
		val List<String> concatValues = new ArrayList<String> //will hold the concatenation result of the 'listOfvariables1' and 'listOfvariables2'
		
		val listOfvariables1 = t1.first 
		val listOfvariables2 = t2.first
		
		val List<String> concatVariables = new ArrayList<String> //will hold the concatenation result of the list of Variables in t1 and t2 
		concatVariables.addAll(listOfvariables1)
		concatVariables.add("#")
		concatVariables.addAll(listOfvariables2)
		
		val List<String> concatIdents = new ArrayList<String>
		concatIdents.addAll(t1.third)
		concatIdents.add("#")
		concatIdents.addAll(t2.third)
		
		val indexes = indexOfCommonVars(listOfvariables1, listOfvariables2)
		
		val listOfValues1 = t1.second
		val listOfValues2 = t2.second
	
		//Cartesian composition between t1 and t2 lists of MCDC values
		for(v1:listOfValues1){
			for(v2:listOfValues2){
				if (meetConstraints(v1, v2, indexes)){ //merge if the values meet the constraint
					concatValues.add(v1 + "#" + v2)
				}
			}//for
		}//for
		
		return new Triplet (concatVariables, concatValues, concatIdents)
	}//concatWithConstraints
	
	/**
	 * Verify the coherence of variables. For instance, a variable should keep its value unchanged, unless it is modified
	 */
	def private boolean  meetConstraints(String str1, String str2, List<Couple<Integer,Integer>> indexes) {
		val str1ToArray = str1.toStringArray
		val str2ToArray = str2.toStringArray
		
		for(ic: indexes){
			if (str1ToArray.get(ic.first.intValue)!= str2ToArray.get(ic.second.intValue)){
				return false
			}
		}
		return true
	}//meetConstraints
	
	//////////////////////////////////////////////////////
	/**
	 * This method break the concatenated MCDC results down, in order to measure the MCDC coverage amount of each boolean expression
	 */
	def splitMergedValues(List<Triplet<List<String>, List<String>, List<String>>> concatValues){
		
		val splitMergedValuesResults = new ArrayList<Triplet<List<String>, Set<String>, List<String>>>
		
		for(triplet: concatValues){
			
			val variables = triplet.first
			val values = triplet.second
			val identSequence = triplet.third
			
			//The separator '#' is used to merge values and variables of different expressions.
			// we will use these separators indexes to break down the concatenated results
			val indexOfvariables = variables.indexesBeforeSeparator
			val indexOfIdents = identSequence.indexesBeforeSeparator
			
			var i = 0
			val size = indexOfvariables.size
			do{
				
				//identSequence[varLeftIndex TO varRigthIndex] represents a series of variables
				//delimited by the separator #
				//NB: variables sequences and values sequences are in the same order. That is, the variables indexes 
				//can be used as values indexes
				val varLeftIndex = indexOfvariables.get(i).first //variable left index 
				val varRigthIndex = indexOfvariables.get(i).second //variable right index
				
				//variables[identLeftIndex TO identRightIndex] represents a sub-identifier of identSequence
				//delimited by the separator #
				val identLeftIndex = indexOfIdents.get(i).first //identifier left index
				val identRightIndex = indexOfIdents.get(i).second //identifier right index
				
				//sub-lists of variables
				val varSubList = variables.subList(varLeftIndex, varRigthIndex + 1)
				val ident = identSequence.subList(identLeftIndex, identRightIndex + 1)
				val Set<String> splitValues = new TreeSet<String>
				values.forEach[v | splitValues.add(v.substring(varLeftIndex, varRigthIndex + 1))]
				
				splitMergedValuesResults.add(new Triplet(varSubList, splitValues, ident))
				
			}while ( (i=i+1) < size )
		
		}//for
		
		//map triplets having same idents
		var j = 0
		do{
			val tmp = splitMergedValuesResults.get(j)
			val subIdentifier = tmp.third
			
			//seek a triplet with a same ident as tmp
			val dup = splitMergedValuesResults.findFirst[(it != tmp) && (it.third.equals(subIdentifier))]
			
			if (dup != null){ //merge dup MCDC values to the current triplet "tmp"
				tmp.second.addAll(dup.second)
				splitMergedValuesResults.remove(dup) //remove dup element 
				j = j - 1
			}
			
			//filter 'values that are not part of the mcdc values'
			val newValues = tmp.second.keepOnlyMcdcValues(subIdentifier.extractIdentifier.parseInt)
			tmp.setSecond(newValues)
		
		}while ( (j=j+1) < splitMergedValuesResults.size )
		
		return splitMergedValuesResults
	}//splitConcatenatedValues
	
	/**
	 * Provides a MCDC not coverage verdict of each boolean expression. Typically, for each boolean expression it relies on 
	 * the 'splitConcatenatedValues' method to track the MCDC values that have not been covered    
	 */
	def notMergedValues(List<Triplet<List<String>, Set<String>, List<String>>> splitList){
		
		val notMergedValues = new ArrayList<Triplet<List<String>, List<String>, List<String> >>
		
		for(triplet:splitList){
			
			val subIdentifier = triplet.third
			val identNature = subIdentifier.get(0).getLastChar //either 'T' or 'F' or 'X'
			
			val intIdent = subIdentifier.extractIdentifier.parseInt
			val actualValues = triplet.second.toList
			
			val mcdcValues = new ArrayList<String>
			
			if( identNature == "F" || identNature == "T" ){
				//retrieve the MCDC (False or True) values of the expression with identifier "intIdent"
				 mcdcValues.addAll(getMcdcValues(intIdent).filter[ it.charAt(0).toString ==  identNature])
			}
			else{
				if(identNature == "X"){
					 mcdcValues.addAll(getMcdcValues(intIdent)) //retrieve the MCDC values of the expression with ident nature "N"
				}
				else{
					throw new RuntimeException("##### Unknown identifier #####" )
				}
			}
			
			//seek values that are in mcdcValues and not in actual values
			val valuesDiff = listDiff(mcdcValues, actualValues)
			if (valuesDiff.size != 0){
				notMergedValues.add(new Triplet(triplet.first, valuesDiff, triplet.third))
			}	
		}//for
		return notMergedValues
	}//notCoveredList
	
	
	/**
	 * According to the not-coverage results, this method builds a series of equation with the goal to find some
	 * extra values of the others expressions that can be merged with the not-covered MCDC values.
	 */
	def buildEquations( List<Triplet< List<String>, List<String> , List<String> >> notCoveredList, 
					  List<List<Triplet< List<String>, List<String>, List<String> >>> listOfList){
		
		val listOfEquations =  new ArrayList<List<Triplet<List<String>,List<String>, List<String>>>>
		
		for(triplet: notCoveredList){
			
			val listOfVariable = triplet.first
			val listOfUncoveredValues = triplet.second
			val subIdentifier = triplet.third
			
			for(uncoveredVal: listOfUncoveredValues){
				listOfList.forEach[ //find the execution path 'list' that contains the equation triplet 
					list |  val match = list.findFirst[ 
							(it.third.equals(subIdentifier)) && (it.first.equals(listOfVariable)) && (it.second.contains(uncoveredVal))
						]//find first
					if (match != null){
						val targetIndex = list.indexOf(match)
						val matchList = list.copyListOfTriplet
						
						//set the second param of the target triplet with the uncovered value
						matchList.get(targetIndex).setSecond(uncoveredVal.toStringArray)
						
						var cpt = 0
						val size = matchList.size
						
						val targetTriplet = matchList.get(targetIndex)
						val targetListOfVariables = targetTriplet.first
						val listOfIndexes = new ArrayList<String> //records the indexes of triplets which have one variable in the variable list	  
						
						do{
							
							val currentTriplet = matchList.get(cpt)
							
							if((cpt != targetIndex) && (currentTriplet.first.size > 1)){// the current triplet is not the target triplet
							//nor a triplet whose the variables values are imposed
								
								val currentListOfVariables = currentTriplet.first
								
								if(currentTriplet.first.get(0) == "*"){
									//retrieve the outcome value of the condition
									val outcome = currentTriplet.second.get(0).charAt(0)
									//set all the values of the current
									currentTriplet.setSecond((outcome + (currentListOfVariables.size-1).unknownStringVector).toStringArray)
								}
								else{
									//set all the values of the current
									currentTriplet.setSecond(currentListOfVariables.size.unknownStringVector.toStringArray)
								}
								
								if(currentListOfVariables.intersectionOfLists(targetListOfVariables).size > 0){
									//the two lists have some variables in common
									//retrieve theirs indexes
									val indexesOfcommonVars = indexOfCommonVars(targetListOfVariables, currentListOfVariables) 
									
									for(i: indexesOfcommonVars){
										currentTriplet.second.set(i.second, targetTriplet.second.get(i.first))
									}//for i
								
								}//if currentListOfVariables
							}
							else{
								if(currentTriplet.first.size == 1){
									//the cuurrent triplet's list of variable holds an imposed value
									// => Store the index of the triplet
									listOfIndexes.add(cpt.toString)
								}
							}
						
						} while( (cpt=cpt+1) < size )
						
						//new loop to propagate imposed variables' values ()
						var addToList = true
						
						for(i: listOfIndexes){
						 
						  val myTriplet = matchList.get(i.parseInt)
						  val myTripletVarList = myTriplet.first
					
						  for(t: matchList){
						  	if(t!=myTriplet){
						  		val currentTripletVarList = t.first
						  		if( currentTripletVarList.intersectionOfLists(myTripletVarList).size > 0){
						  			val indexesOfcommonVars = indexOfCommonVars(currentTripletVarList, myTripletVarList)
						  			
						  			for(indexesCouple: indexesOfcommonVars){
										val myTripletValuesList = myTriplet.second
										val currentTripletValuesList = t.second
										if(currentTripletValuesList.get(indexesCouple.first) =="*"){
											t.second.set(indexesCouple.first, myTripletValuesList.get(indexesCouple.second))
										}
										else{
											if(currentTripletValuesList.get(indexesCouple.first) != myTripletValuesList.get(indexesCouple.second)){
												//equations with no solution
												addToList = false
											}
										}									
									
									}//for indexesCouple
									
						  		}
						  	}
						  }//for
						}				
					
					if(addToList) {
						listOfEquations.add(matchList)
					}
					
					}//if match
				]//for each
			}//for
		}
	return listOfEquations
	
	}//buildEquations
	
	 /**
	  * Filter the values that takes part in the MCDC values of the boolean expression at index 'identifier'
	  * in the list 'listOfMcdcValues'
	  */
	  def private keepOnlyMcdcValues(Set<String> values, int identifier){
	  	val myMcdcValues = getMcdcValues(identifier)
	  	val newValues = values.filter[myMcdcValues.contains(it)]
	  	return newValues.toSet
	  }
	 
}//class