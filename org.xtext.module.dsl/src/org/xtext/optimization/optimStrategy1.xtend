package org.xtext.optimization

import java.util.List
import org.xtext.helper.Triplet
import org.xtext.helper.Couple
import java.util.ArrayList
import static extension org.xtext.utils.DslUtils.*
import static extension org.xtext.coverage.Module_Coverage.*
import java.util.Set
import java.util.HashMap
import java.util.Map

class optimStrategy1 {
	
	/**
	 * Given a set of MC/DC tests data, this method returns a subset of these MC/DC tests data with the same amount of MC/DC
	 * coverage of the module.
	 */
	def optimize(List<List<String>> listOfMcdcValues, Map<List<Couple<String, String>>, List<Triplet<String, String, String>>> coveredSequencesTestsDataMap){	
		
		val coveredSequences = coveredSequencesTestsDataMap.keySet.toList //sequence of covered values for each condition number
		
		val coverageMatrix = listOfMcdcValues.makeCoverageMatrix(coveredSequences) //get the coverage matrix
		
		val mapVectTests = getVectorRepresentationOfTests(coverageMatrix, coveredSequences)// <vector, test> map
		val vectorsList = mapVectTests.keySet.toList //list of tests vectors
				
		vectorsList.checkVectorsConsistency

		val reducedVectors = vectorsList.testSuiteReduction //reduced vectors suite
		
//		System.out.println("Remained vector list: " + vectorsList.toString)
//		System.out.println("Reduced suite: " + reducedVectors.toString)
		
//		System.out.println("Reduced tests sequences: ")
		val selectedTestData = new ArrayList<List<Triplet<String,String,String>>>// Tests data selected by the optimization
		
		reducedVectors.forEach [ 
			vect, i | val associatedCoveredSequence = mapVectTests.get(vect)
			val associatedTestData = coveredSequencesTestsDataMap.get(associatedCoveredSequence)
			selectedTestData.add(associatedTestData)
//			System.out.println
//			System.out.println( "Test sequence " + i )
//			associatedCoveredSequence.printListOfCouple
		]//forEach
		
		return selectedTestData
	
	}//optimize
	

	/**
	 * This method returns a map that maps a test sequence with its vector representation according to the coverage matrix.
	 * In fact, given a test, the coverage matrix MC/DC values will be crossed and the coverage attributes of values covered
	 * by the test will be set to "1". The corresponding vector of the test is built by concatenating in the order, the 
	 * coverage attributes ("-" attributes are ignored) of MC/DC values in the coverage matrix. 
	 */
	def private getVectorRepresentationOfTests(List<List<Triplet<String,String, String>>> coverageMatrix, List<List<Couple<String,String>>> coveredSequences){
		
		val mapVectTests = new HashMap<String, List<Couple<String, String>>> 
		
		coveredSequences.forEach[
			test | test.forEach[
					couple | val identifier = couple.second.parseInt
							 val value      = couple.first
							 coverageMatrix.get(identifier).forEach[
							 	pair | if (pair.first == value){
							 				pair.setSecond("1")
							 		   }
							 ]
			]
			val vector = coverageMatrix.getVector
			val put = mapVectTests.put(vector, test)
			coverageMatrix.init
		]
		
		return mapVectTests	
	
	}//getVectorRepresentationOfTests	
	
	
	/**
	 * returns the vector representation of a test. the test coverage attributes are already set in the
	 * coverage matrix. 
	 */
	def private getVector(List<List<Triplet<String,String,String>>> coverageMatrix){
		
		var vector = ""
		
		for (listOfTriplets : coverageMatrix){
			 for (triplet : listOfTriplets){ 
				val vectorElem = triplet.second
				if(vectorElem != "-"){
					vector = vector + vectorElem
				}
			}
		}
		
		return vector
	
	}//getVector
	
	
	/**
	 * Check that all vectors have the same size
	 */
	def private void checkVectorsConsistency(List<String> vectorList){
		
		val vectorSize = vectorList.get(0).length
		for(vector: vectorList){
			if(vector.length != vectorSize){
				throw new Exception(" ##### Vector size mismatch ##### ")
			}
		}
		
	}//checkVectorsConsistency
	
	
	/**
	 * Initialize the coverage matrix by resetting all coverage attributes set to 1 
	 */
	def private void init(List<List<Triplet<String,String,String>>> coverageMatrix){
		for (listOfTriplets : coverageMatrix){
			 for (triplet : listOfTriplets){ 
				val vectorElem = triplet.second
				if(vectorElem == "1"){
					triplet.setSecond("0")
				}
			}
		}
	}//init
	
	
	/**
	 * Return the reduced vector suite of the vector list. The reduced vector list is the minimum vector suite in
	 * vectorList whose the logical OR of all vectors gives the full vector as result.
	 */
	def private testSuiteReduction(List<String> vectorsList){
		
		val reducedTestsSuite = new ArrayList<String>
		val vectorSize = vectorsList.get(0).length
		val nullVector = nullVector(vectorSize) // "00..00"
		val fullVector = fullVector(vectorSize) //"11..11"
		
		//initialize contribution values
		val size = vectorsList.size
		var contribution = 0
		var index = -1
		
		var cpt = 0
		do{//compute the first most contributed vector to null vector
			val currVector = vectorsList.get(cpt) //get the current vector
			val tmpContrib = contribution(nullVector, currVector) 
			
			if(tmpContrib > contribution){
				contribution = tmpContrib
				index = cpt 
			}
		
		} while( (cpt=cpt+1) < size )
		
		//At this point, the higher contribution value is 'contribution' and the index of the vector is 'index'
		
		val firstVector = vectorsList.get(index) //first most contributed vector
		reducedTestsSuite.add(firstVector) //add it to the reduced Tests Suite list
		vectorsList.remove(index) //remove it from the vector list 
		
		var referenceVector = firstVector //reference vector init with the first most contributed vector

		while (referenceVector != fullVector) {//stop if reference vector is equals to the full vector. It means that no others
			//vector can contribute to it
			
			var mostContribVectorSoFar = vectorsList.get(0) 
			contribution = 0
			
			for(currVector : vectorsList){
				
				val tmpContrib = contribution(referenceVector, currVector)//current vector contribution to reference vector 
				
				if(tmpContrib == 0){
					//TODO: remove this vector, as it's useless w.r.t to the chosen one
				}
				else{
					if(tmpContrib > contribution){ //current contribution is the highest so far
						contribution = tmpContrib
						mostContribVectorSoFar = currVector 
					}
					else{//in case case the current contribution is the same with the contribution
						//choose the one that has the less contribution to the null vector. That is, to reduce the testing cost
						if((tmpContrib == contribution) && (contribution(nullVector, currVector) < contribution(nullVector, mostContribVectorSoFar)) ){
							contribution = tmpContrib
							mostContribVectorSoFar = currVector
						}
					}
				}
				
			}//for
			
			//add the most contributed vector to the reduced test suite pool
			reducedTestsSuite.add(mostContribVectorSoFar)
			
			//
			referenceVector = referenceVector.strOR(mostContribVectorSoFar)
			
			//remove mostContribVectorSoFar as it can no longer contribute
			vectorsList.remove(mostContribVectorSoFar)
		
		}//while
	
		return reducedTestsSuite
	
	}//testSuiteReduction
	
	
	/**
	 * Return the logical OR operation between two vectors. For instance "0" + "0" => 0; "1" + "1" => 1; "0" + "1" => 1;
	 * "1" + "0" => 1.
	 */
	def private strOR(String vector1, String vector2) {
		
		val result = new ArrayList<String>
		
		val array1 = vector1.toStringArray
		val array2 = vector2.toStringArray
		
		if(array1.size != array2.size){
			throw new Exception(" ##### Vector size mismatch ##### ")
		}
		
		var size = array1.size
		
		var i = 0
		do{
			if( (array1.get(i).parseInt + array2.get(i).parseInt) > 0 ){
				result.add("1")
			}
			else{
				result.add("0")
			}
		} while( (i=i+1) < size)
		
		return result.arrayToString
	
	}//strOR
	
	
	/**
	 * Vector of size "size" composed only with "0" 
	 */
	def private nullVector(int size) {
		
		var vector = ""
		var cpt = 0
		
		do{
			vector = vector + "0"
		} while( (cpt=cpt+1) < size)
		
		return vector
	
	}//nullVector
	
	
	/**
	 * Vector of size "size" composed only with "1"
	 */
	def private fullVector(int size) {
		
		var vector = ""
		var cpt = 0
		
		do{
			vector = vector + "1"
		} while( (cpt=cpt+1) < size)
		
		return vector
	
	}//fullVector
	
	
	/**
	 * Return the contribution of the vector2 to the vector1.
	 * The contribution is the number of "1" values in the vector2 that fill the "0" values in the vector "1".
	 * For instance: vector1 is "1010" and vector2 is "1100", the contribution of the vector2 to the vector1 is 1. 
	 */
	def private contribution(String vector1, String vector2){
		
		var contribution = 0 //init with 0
		
		if(vector1.length != vector2.length){
			throw new Exception("The two vectors must have the same length")
		}
		
		val vectorArray1 = vector1.toStringArray
		val vectorArray2 = vector2.toStringArray
		
		var size = vectorArray1.size
		
		var i = 0
		do{
			if( (vectorArray1.get(i).parseInt - vectorArray2.get(i).parseInt) < 0 ){
				contribution = contribution + 1
			}
		} while( (i=i+1) < size)
		
		return contribution
	
	}//contribution
	
	
/***************************************************************************************************************************
 * Not used implementations
 **************************************************************************************************************************/	

	/**
	 * 
	 */
//	def private vectorsBasis(List<List<Triplet<String, String, String>>> coverageMatrix){
//		val vectorBasis = new ArrayList<Couple<String, String>>
//		coverageMatrix.forEach[
//			list | list.forEach[
//				triplet | val value = triplet.first
//						 val vectorAttr = triplet.second
//				if(vectorAttr != "-"){
//					vectorBasis.add(new Couple(value, triplet.third))
//				}
//			]
//		]
		
//		return vectorBasis
//	}
		
//	def testsSequences(List<Couple<String,String>> basis, List<String> reducedVectors){
//		val testsSequences = new ArrayList<List<Couple<String,String>>>
//		reducedVectors.forEach[ 
//			vector | val vectorArray = vector.toStringArray 
//			val tests = new ArrayList<Couple<String,String>>
//				vectorArray.forEach[ 
//					bit, i | if (bit == "1") { tests.add(basis.get(i)) }
//				]//forEach
//			testsSequences.add(tests)
//		]//forEach
//		return testsSequences
//	}
	
	//vectorReprOfTests
	
	/* 	def private decompositionOfTests(List<Triplet<List<String>, List<String>, List<String>>> testsPool){
		val testsReprMap = new HashMap<List<Couple<String, String>>, String> 
		testsPool.forEach[
			triplet, pathID | val values = triplet.second
					  val identSequence = triplet.third
			values.forEach[ 
				test | val decompositionOfTest = new ArrayList<Couple<String,String>>
					   val indexOfIdents = identSequence.indexesBeforeSeparator
					   val testToArray = test.toStringArray
					   val indexOfTest = testToArray.indexesBeforeSeparator
					   
					   val size = indexOfTest.size
					   
					   if(size != indexOfIdents.size){
					   	 	throw new Exception("Size mismatch")
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
//				testsRepr.add(decompositionOfTest)
			]
		]
		return testsReprMap
	}//decompositionOfTests
	
	*/
	
	//	def optimize(List<Triplet<List<String>, List<String>, List<String>>> testsPool, List<List<String>> listOfMcdcValues, List<Triplet<List<String>,Set<String>, List<String>>> listOfCoveredValues){
		
//		val coverageMatrix = listOfMcdcValues.makeCoverageMatrix(listOfCoveredValues)
//		val vectorBasis = vectorsBasis(coverageMatrix)
//		val testsReprMap  = decompositionOfTests(testsPool) //peut sortir de cette class. Peut etre la mettre dans test generator
//		val testsRepr = testsReprMap.keySet.toList //to be set with
//		val mapVectTests = vectorReprOfTests(coverageMatrix, testsRepr)
//		val vectorsList = mapVectTests.keySet.toList
		
//		System.out.println("Vector list size is :" + vectorsList.size)
//		System.out.println("Vector list  :" + vectorsList.toString)
		
//		vectorsList.checkVectorsConsistency
		
//		System.out.print("Basis: " )	
//		vectorBasis.printListOfCouple
		
//		System.out.print("tests: " )	
//		testsRepr.forEach[ test , i|
//			System.out.println( "test " + i )
//			test.printListOfCouple
//		]

//		val reducedVectors = vectorsList.testSuiteReduction
		
//		System.out.println("Here, I am: " + vectorsList.toString)
//		System.out.println("Reduced suite: " + reducedVectors.toString)
		
//		System.out.println("Reduced tests sequences: ")
//		val testsSequences = new ArrayList<Couple<String,List<Couple<String,String>>>>
		
//		reducedVectors.forEach[ 
//			vect, i | val testSeq = mapVectTests.get(vect)
//			val pathID = testsReprMap.get(testSeq)
//			testsSequences.add( new Couple(pathID,testSeq) )
//			System.out.println
//			System.out.println( "test sequence " + i + ", Path ID is :" + pathID)
//			testSeq.printListOfCouple
//		]


//		val testsSequences = testsSequences(vectorBasis,reducedVectors)
//		testsSequences.forEach[ 
//			tests, i | System.out.println( "test sequence " + i )
//			tests.printListOfCouple
//		]
//		return testsSequences
//	}//optimize

}