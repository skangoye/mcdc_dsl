package org.xtext.coverage

import org.xtext.helper.Triplet
import java.util.List
import java.util.ArrayList
import java.util.Set

import static extension org.xtext.utils.DslUtils.*
import org.xtext.helper.Couple
import java.util.TreeSet
import org.xtext.moduleDsl.EXPRESSION
import java.util.HashMap

class Module_Coverage {
	
	val private static final nextLine = "\n" // String 'go to next line' pattern 
	
	var private static fullCoverage = 0 //used to 
	
/********************************************************************************************************************************
 * 
 * Module Coverage implementation
 * 
 *********************************************************************************************************************************/	
	
	/**
	 * Provide a full MC/DC coverage report for the module being considered
	 * @params: CoveredSequence:
	 */
	def moduleCoverageReport(List<List<Couple<String,String>>> CoveredSequence, List<EXPRESSION> boolExps, List<List<String>> listOfMcdcValues) {
		val coverageAttributes = CoveredSequence.coverageAttributes(listOfMcdcValues)
		
		val covered =  coverageAttributes.first
//		val notCovered = coverageAttributes.second
		
//		val notCoverageReport = notCovered.notCoverageReport(boolExps)
		val coverageReport = covered.coverageReport(boolExps)
		
		return (coverageMessage(fullCoverage) + (nextLine + nextLine) + coverageReport) + nextLine
	}
	
	
	/**
	 * Provide a coverage report of MC/DC values that have been covered by tests
	 */
	def private coverageReport(List<Couple<String, Set<String>>> covered, List<EXPRESSION> boolExps){
		
		var result = ""
		 
		for(couple:covered) {
			
			val boolExpIdentifier = couple.first
			val boolExp = boolExps.get(boolExpIdentifier.parseInt)
			val set = couple.second //set of the current decision's MCDC values
			val decisionConditions = boolExp.booleanConditions //list of the current decision's conditions

			//form MCDC pairs of the decision's conditions
			val setF = set.filter[ it.charAt(0).toString == "F"] //MCDC values whose outcome is False
			val setT = set.filter[ it.charAt(0).toString == "T"] //MCDC values whose outcome is True
			val map = new HashMap<String, Couple<String,String>> //map condition index with its MCDC pair
			
			setT.forEach[ strT |
				setF.forEach[
					strF | 
					val strTwithoutOutcome = strT.substring(1, strT.length) //The first char of strT is the outcome of the boolExp
					val strFwithoutOutcome = strF.substring(1, strF.length) //The first char of strF is the outcome of the boolExp
					val independanceCouple = independantPairs(strTwithoutOutcome, strFwithoutOutcome)
					val isIndependentPair = independanceCouple.first.booleanValue
					if(isIndependentPair){
						//strT and strF form a MC/DC pair for the condition number "conditionIndex"
						val conditionIndex = independanceCouple.second
						val put = map.put(conditionIndex.toString, new Couple(strTwithoutOutcome + "|" + "T", strFwithoutOutcome + "|" + "F"))
					}
				]//forEach
			]//forEach
		
			//print conditions coverage information
			result = result + nextLine + ("##### Decision " + boolExpIdentifier+ ": " + "=>" + boolExp.stringReprOfExpression) + nextLine
			var index = 0
			
			for(condition: decisionConditions){ //for each condition
				
				val mcdcPair = map.get(index.toString)
				val conditionWithBrackets = "("+ condition +")"
				
				if(mcdcPair != null){
					result =  result +  nextLine + ("		Condition " + index + ": " +  conditionWithBrackets + "=>" + "( " + mcdcPair.first + " , " +  mcdcPair.second + " )") + nextLine
				}
				else{
					result = result + nextLine + ("		Condition " + index + ": " + conditionWithBrackets + "=>" + "( - , - )") + nextLine
					fullCoverage = fullCoverage + 1 //at least one condition is not covered => fullCoverage > 0
				}
				
			 	index = index + 1
			
			}//for
		
		}//for
		
		return result
	
	}//coverageReport
	
	
	def private String coverageMessage(int fullCoverage){
		
		var result = ""
		
		if(fullCoverage == 0){
			result =  ("##### All Conditions have been covered ##### ") + nextLine
		}
		else{
			result =  ("##### " + fullCoverage+  " Conditions have not been covered ##### ") + nextLine
		}
		
		return result
	
	}//coverageMessage
	
	/**
	 * Provide a not coverage report of MC/DC values that have not been covered by tests
	 */
//	def private notCoverageReport(List<Couple<String, Set<String>>> notCovered, List<EXPRESSION> boolExps){
//		
//		var result = ""
//		
//		if(notCovered.size == 0){
//			result = result +  ("##### All values have been covered ##### ") + nextLine
//		}
//		else{
//			result = result +  nextLine + ("##### Not covered decisions ##### ") + nextLine
//			for(couple: notCovered) {
//				val ident = couple.first 
//				val set = couple.second
//				result = result +  nextLine + ("	##### decision " + ident + ":" + boolExps.get(ident.parseInt).stringReprOfExpression + " => " + set.toString ) + nextLine
//			}
//		}
//		
//		return result
//	
//	}//notCoverageReport
	
	
	/**
	 * Provide a couple of sets, where the first set represent MC/DC covered values, and the second, MC/DC not covered values
	 */
	def coverageAttributes(List<List<Couple<String,String>>> CoveredSequence, List<List<String>> listOfMcdcValues){
		
		val notCovered = new ArrayList<Couple<String, Set<String>>> //set to record MC/DC not covered values
		val covered = new ArrayList<Couple<String, Set<String>>> // set to record MC/DC covered values
		val coverageMatrix = listOfMcdcValues.makeCoverageMatrix(CoveredSequence) //coverage matrix
		
		coverageMatrix.forEach[
			list, condNumber | val notCoveredSet = new TreeSet<String> 
			val coveredSet = new TreeSet<String>
			list.forEach[
				elem | val coverageAttribute = elem.second
				if(coverageAttribute == "-"){ //this value (elem.first) is not covered 
					if(elem.third != condNumber.toString){throw new Exception("identifier mismatch")}
					notCoveredSet.add(elem.first)
				}
				else{
					if(coverageAttribute == "0"){ //this value (elem.first) is covered
						if(elem.third != condNumber.toString){throw new Exception("identifier mismatch")}
						coveredSet.add(elem.first)
					}
				}
			]
			
			if(notCoveredSet.size > 0)
				notCovered.add( new Couple(condNumber.toString, notCoveredSet))
			if(coveredSet.size > 0)
				covered.add( new Couple(condNumber.toString, coveredSet))	
		]//forEach
	
		return new Couple(covered, notCovered)
	}//coverageAttributes
	
	
	/**
	 * Provide a coverage matrix of the module, with respect to the tests generated. Typically, given a sequence of MC/DC values covered
	 * by the tests, this methods builds a matrix with all MC/DC values to be covered. Then it marks all MC/DC values covered by the tests
	 * with the attribute "0", "-" otherwise.
	 */
	def static makeCoverageMatrix(List<List<String>> listOfMcdcValues, List<List<Couple<String,String>>> CoveredSequence){
		
		//List of List of Triplet. The first parameter of the triplet is an MC/DC value to be covered
		//The second parameter is the coverage attribute: "0" if the value is covered, "-" otherwise  
		val matrixOfcoverage =  new ArrayList < List<Triplet<String, String, String>> >
		
		//init matrixOfcoverage
		listOfMcdcValues.forEach[ e , i | 
			val listOfTriplets = new ArrayList<Triplet<String, String, String>> 
			e.forEach[ v | listOfTriplets.add(new Triplet(v ,"-", i.toString))]
			matrixOfcoverage.add(listOfTriplets)
		]//forEach
		
		
		//set coverage attribute
		CoveredSequence.forEach[ 
			listCouple | listCouple.forEach[ 
				couple | val identifier = couple.second.parseInt
				val targetValues = matrixOfcoverage.get(identifier)
				val coveredValue = couple.first
				val find = targetValues.findFirst[(it.first == coveredValue) && (it.second == "-")]
				if(find != null){
					find.setSecond("0")
				}
			]//forEach
		]//forEach	
			
		return matrixOfcoverage
	
	}//coverageMatrix
	
	
	/**
	 * Given a boolean expression, this method stores in a list, the different atomic conditions
	 * that get involved in the expression 
	 */
	def static private booleanConditions(EXPRESSION expression){
		val listOfConditions = new ArrayList<String>
		expression.booleanVarInExpression(listOfConditions)
		return listOfConditions
	}
	
}//class