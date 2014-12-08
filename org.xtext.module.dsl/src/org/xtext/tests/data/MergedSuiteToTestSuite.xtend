package org.xtext.tests.data

import java.util.List
import org.xtext.helper.Triplet
import java.util.HashMap
import org.xtext.helper.Couple
import java.util.ArrayList

import static extension org.xtext.utils.DslUtils.*

class MergedSuiteToTestSuite {
	
	def static mergedSuiteToTestSuite(List<Triplet<List<String>, List<String>, List<String>>> mergedSuite){
		
		val testsReprMap = new HashMap<List<Couple<String, String>>, String> 
		
		mergedSuite.forEach[
			mergedTriplet, pathID | val values = mergedTriplet.second
					  val identSequence = mergedTriplet.third
			values.forEach[ 
				test | val decompositionOfTest = new ArrayList<Couple<String,String>>
					   val indexOfIdents = identSequence.indexesBeforeSeparator
					   val testToArray = test.toStringArray
					   val indexOfTest = testToArray.indexesBeforeSeparator
					   
					   val size = indexOfTest.size
					   
					   if(size != indexOfIdents.size){
					   	 	throw new Exception(" ##### Size mismatch ##### ")
					   }
					   
					   var i = 0
					   do{
					   	 	val testLeftIndex = indexOfTest.get(i).first
							val testRigthIndex = indexOfTest.get(i).second
				
							val identLeftIndex = indexOfIdents.get(i).first
							val identRightIndex = indexOfIdents.get(i).second
							
							val ident = identSequence.subList(identLeftIndex, identRightIndex + 1).extractIdentifier
							val subTest = testToArray.subList(testLeftIndex, testRigthIndex + 1)
							
							decompositionOfTest.add( new Couple(subTest.arrayToString, ident))
				
					   }while( (i=i+1) < size )
			
				testsReprMap.put(decompositionOfTest, pathID.toString)
			]//forEach
		]//forEach
		
		return testsReprMap
	
	} //mergedSuiteToTestSuite
	
}