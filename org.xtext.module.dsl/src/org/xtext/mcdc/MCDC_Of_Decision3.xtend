package org.xtext.mcdc

import org.xtext.helper.Triplet
import java.util.List
import org.xtext.moduleDsl.EXPRESSION
import org.xtext.moduleDsl.AND
import java.util.ArrayList
import org.xtext.moduleDsl.OR
import org.xtext.moduleDsl.NOT
import org.xtext.moduleDsl.COMPARISON
import org.xtext.moduleDsl.EQUAL_DIFF
import org.xtext.moduleDsl.VarExpRef
import org.xtext.helper.Couple

import static extension org.xtext.utils.DslUtils.*

class MCDC_Of_Decision3 {
	
	/**
	 * Compute the MC/DC of a boolean expression
	 * @param booleanExpression 
	 * 							The boolean expression to be used
	 * @return A list of booleanExpression's MC/DC tests and theirs corresponding outcomes
	 */
	 def void mcdcOfBooleanExpression(EXPRESSION booleanExpression){
	 	
	 	System.out.println("MCDC of " + booleanExpression.stringReprOfExpression)
	 	System.out.println
	 	
	 	val dfsValues = new ArrayList<List<Triplet<String, String, String>>>
//	 	val mcdcResults = new ArrayList<Couple<String, String>>
	 	
	 	mcdcDepthFirstSearch(booleanExpression, dfsValues)
	 	val linkResult = mcdcBottomUp(dfsValues)
	 	
	 	val falseValueWithWeight = new ArrayList<Couple<String, Integer>>
	 	val trueValueWithWeight = new ArrayList<Couple<String, Integer>>
	 	
	 	for(triplet: linkResult){
	 			 		
	 		val outcome = triplet.evalOperation
	 		val mcdcCandidate = triplet.first
	 		
	 		if( outcome != "T" && outcome != "F" ){ throw new Exception("Incorrect outcome result: " + outcome) }
	 		
	 		if(outcome == "T"){
	 			trueValueWithWeight.add( new Couple(mcdcCandidate, 0))
	 		}
	 		else{//outcome == "F"
	 			falseValueWithWeight.add( new Couple(mcdcCandidate, 0))
	 		}
	 		
	 	}
	 	
	 	// falseValueWithWeight and trueValueWithWeight are set with the right values
	 	
	 	val size = falseValueWithWeight.get(0).first.length //size of the decision == mcdcCanditate.length
	 	val  listOfIndepVectors = new ArrayList<List<Couple<Couple<String,Integer>, Couple<String,Integer>>>>
	 	
	 	listOfIndepVectors.fillWithEmptyElements(size)
	 	
	 	for(fc : falseValueWithWeight){
	 		for(tc : trueValueWithWeight){
	 			addIndepVector(fc, tc, listOfIndepVectors)
	 		}
	 	}
	 	
	 	System.out.println(" Total number of Values: " + (falseValueWithWeight.size + trueValueWithWeight.size))	 		 	
	 	System.out.println
	 	
	 	listOfIndepVectors.forEach[ list |
	 		list.forEach[ couple | 
	 			val couple1 = couple.first
	 			val couple2 = couple.second
	 			System.out.println("[ " + "(" + couple1.first + "_" + couple1.second + "," +  couple2.first + "_" + couple2.second + ")" + " ]" )
	 		]
	 		System.out.println("###############################################################")
	 		System.out.println
	 	]
	 	
	 	notCount = 0 //reset notCountValue
	 	firstOperator = "" //reset first operator
	 	
	 	//return mcdcResults
	 
	 }//mcdcOfBooleanExpression
	
	var notCount = 0
	var firstOperator = ""
	
	/**
	 *Counts the the number of 'not' operators crossed from the root to the first operator of type 'and/or', in the parse tree
	 * e.g.: The expression 'not (a and b)' returns notCount = 1 while 'not a and not b' returns 0
	 */
	def int notCount(){
		return notCount
	}
	
	/**
	 * @return The first crossed operator of type 'and/or' in the parse tree
	 */
	def String firstOperator(){
		return firstOperator
	}
	
	
	/**
	 * Performs a DFS (Depth-First-Search) upon the expression parse tree, to reach its leaf-nodes and store.
	 * @param expression
	 * 					Boolean expression parse tree
	 * @param resultList
	 * 					list of all leaf-nodes' with theirs values.
	 * A leaf-node value is composed of trivial values 'True' and 'False', its index and its position in the tree
	 */
	def private void mcdcDepthFirstSearch(EXPRESSION exp, List<List<Triplet<String, String, String>>> resultList){
		
		if(exp instanceof AND){
			
			firstOperator = "and"
			
			var leftList = new ArrayList<Triplet<String, String, String>>
		    var rightList = new ArrayList<Triplet<String, String, String>>
			
			//Add T1, T2 and F3 to lesftList
			leftList.add(new Triplet('T', "11", "1"))
			leftList.add(new Triplet('T', "21", "1"))
			leftList.add(new Triplet('F', "22", "1"))
			leftList.add(new Triplet('F', "23", "1"))
			
			//Add T1, F2 and T3 to righttList
			rightList.add(new Triplet('T', "11", "0"))
			rightList.add(new Triplet('F', "21", "0"))
			rightList.add(new Triplet('T', "22", "0"))
			rightList.add(new Triplet('F', "23", "0"))
			
			val andExp = (exp as AND)
			
			//call recursively on enumMcdc method
			mcdcDepthFirstSearch2(andExp.left, leftList, resultList)
			mcdcDepthFirstSearch2(andExp.right, rightList, resultList)
			
		}
		else{
			if(exp instanceof OR){
				
				firstOperator = "or"
				
				var leftList = new ArrayList<Triplet<String, String, String>>
				var rightList = new ArrayList<Triplet<String, String, String>>
				
				//Add T1, T2 and F3 to lesftList
				leftList.add(new Triplet('T', "11", "1"))
				leftList.add(new Triplet('T', "12", "1"))
				leftList.add(new Triplet('F', "13", "1"))
				leftList.add(new Triplet('F', "21", "1"))
				
				//Add T1, F2 and T3 to righttList
				rightList.add(new Triplet('T', "11", "0"))
				rightList.add(new Triplet('F', "12", "0"))
				rightList.add(new Triplet('T', "13", "0"))
				rightList.add(new Triplet('F', "21", "0"))
				
				val orExp = (exp as OR)
				
				//call recursively on enumMcdc method
				mcdcDepthFirstSearch2(orExp.left, leftList, resultList)
				mcdcDepthFirstSearch2(orExp.right, rightList, resultList)
			}
			else{
				if( exp instanceof NOT){
					
					notCount = notCount + 1
					
					val notExp = (exp as NOT)
					//No need to define values for the first "not" expression
					mcdcDepthFirstSearch(notExp.exp, resultList)
				}
				else{ 
					if (exp instanceof EQUAL_DIFF || exp instanceof COMPARISON || exp instanceof VarExpRef){
						
						var list = new ArrayList<Triplet<String, String, String>>
						list.add(new Triplet('T', "1", ""))
						list.add(new Triplet('F', "2", ""))
						
						resultList.add(list)
					}
					else{
						throw new Exception("Illegal boolean expression")
					}
				}
			}
		}
			
	}//mcdcDepthFirstSearch
	
	
	/**
	 * Called by mcdcDepthFirstSearch method to perform the DFS
	 * @see 
	 * 		mcdcDepthFirstSearch
	 */
	def private void mcdcDepthFirstSearch2(EXPRESSION exp, List<Triplet<String, String, String>> list, List<List<Triplet<String, String, String>>> result){
		
		if (exp instanceof AND){
			
			var leftList = new ArrayList<Triplet<String, String, String>>
			var rightList = new ArrayList<Triplet<String, String, String>>
			
			doAndEval(list, leftList, rightList)
			
			mcdcDepthFirstSearch2( (exp as AND).left , leftList, result )
			mcdcDepthFirstSearch2( (exp as AND).right , rightList, result )
			
		}
		else{
			
			if (exp instanceof OR){
				
				var leftList = new ArrayList<Triplet<String, String, String>>
				var rightList = new ArrayList<Triplet<String, String, String>>
				
				doOrEval(list, leftList, rightList)
				
				mcdcDepthFirstSearch2( (exp as OR).left , leftList, result )
				mcdcDepthFirstSearch2( (exp as OR).right , rightList, result )
			
			}
			else{
				
				if (exp instanceof NOT){
					
					var notList = new ArrayList<Triplet<String, String, String>>
					doNotEval(list, notList)
					mcdcDepthFirstSearch2((exp as NOT).exp , notList, result)
				
				}
				else {
					if (exp instanceof EQUAL_DIFF || exp instanceof COMPARISON || exp instanceof VarExpRef){
						doEqCompVarEval(list , result)
					}
					else{
						throw new Exception("")
					}
				}
			}
		}
	
	}//mcdcDepthFirstSearch2
	
	
	/**
	 * 
	 */
	def private void doAndEval(List<Triplet<String, String, String>> Triplets, List<Triplet<String, String, String>> left, List<Triplet<String, String, String>> right) {
		
		//for each couple of the list do the following tests
		for (t:Triplets){
			if (t.first.toString == "T"){
				left.add(new Triplet('T', t.second + "1", t.third + "1" ))
				right.add(new Triplet('T', t.second + "1", t.third + "0"))
			}
			else {
				if(t.first.toString == "F"){
					left.add(new Triplet('T', t.second + "1", t.third + "1" ))
					right.add(new Triplet('F', t.second + "1", t.third + "0"))
					left.add(new Triplet('F', t.second + "2", t.third + "1"))
					right.add(new Triplet('T', t.second + "2", t.third + "0"))
					left.add(new Triplet('F', t.second + "3", t.third + "1"))
					right.add(new Triplet('F', t.second + "3", t.third + "0"))
				}
				else{
					throw new Exception("Illegal argument")
				}
			}
		}
	}//doAndEval
	
	
	/**
	 * 
	 */
	def private void doOrEval(List<Triplet<String, String, String>> Triplets, List<Triplet<String, String, String>> left, List<Triplet<String, String, String>> right) {
		
		//for each couple of the list do the following tests
		for (t:Triplets){
			if (t.first.toString == "F"){
				left.add(new Triplet('F', t.second + "1", t.third + "1"))
				right.add(new Triplet('F', t.second + "1", t.third + "0" ))
			}
			else {
				if(t.first.toString == "T"){
					left.add(new Triplet('T', t.second + "1", t.third + "1"))
					right.add(new Triplet('T', t.second + "1", t.third + "0" ))
					left.add(new Triplet('T', t.second + "2", t.third + "1"))
					right.add(new Triplet('F', t.second + "2", t.third + "0" ))
					left.add(new Triplet('F', t.second + "3", t.third + "1"))
					right.add(new Triplet('T', t.second + "3", t.third + "0" ))
				}
				else{
					throw new Exception("Illegal argument")
				}
			} 
		}
	
	}//doOrEval
	
	
	/**
	 * 
	 */
	def private void doNotEval(List<Triplet<String, String, String>> Triplets, List<Triplet<String, String, String>> notlist) {
		for (t:Triplets){
			if (t.first.toString == "F"){
				notlist.add(new Triplet('T', t.second, t.third))
			}
			else {
				if(t.first.toString == "T"){
					notlist.add(new Triplet('F', t.second, t.third))
				}
				else{
					throw new Exception("Illegal argument")
				}
			}
		}
	}//doNotEval
	
	
	/**
	 * 
	 */
	def private void doEqCompVarEval(List<Triplet<String, String, String>> Triplets, List<List<Triplet<String, String, String>>>result) {
		result.add(Triplets)
	}//doEqCompVarEval
	
	
	/**
	 * 
	 */
	def private List<Triplet<String, String, String>> mcdcBottomUp(List<List<Triplet<String, String, String>>> resultList){
		
		var myList = resultList
		
		//raise an exception if there is no values (leaves' values) in the list
		if (myList.size == 0){
			throw new Exception("List is empty") 
		}
		
		var i = 0
		do{
			
			if(myList.size == 1){
				return myList.get(0)
			}
			
			val tmpList = myList.get(i)
			val delPosition = tmpList.get(0).third.deleteLastChar
			val n1 = (tmpList.get(0).third.getLastChar).parseInt
			
			val cmp = myList.findFirst
			[ it != tmpList && ((it.get(0).third.deleteLastChar)==(delPosition)) && (n1-(it.get(0).third.getLastChar).parseInt) ==1 ]
			
			if(cmp != null){
				//they are siblings => merge theirs results
				myList.set(i, mergeResults(tmpList, cmp))
				//delete siblings after their merging
				myList.remove(cmp)
			}
			
			//System.out.println(myList.size)////
		} while ( (i=i+1) < myList.size )
		
		 //recursive call of the link method with the new list
		 mcdcBottomUp(myList)	
	
	}//mcdcBottomUp
	
	
	/**
	 * Merge two lists according to our MC/DC merging policy
	 * @param left
	 * 			 The first list 
	 * @param right
	 * 			 The second list
	 * @return A list that merges the two lists
	 */
	 def private mergeResults(List<Triplet<String, String, String>> left, List<Triplet<String, String, String>> right){
		
		val list = new ArrayList<Triplet<String, String, String>>
		
		for(t1: left){
			var index1 = t1.second
			var position = t1.third
			for(t2:right){
				val index2 = t2.second
				if(index1 == index2){//merge values that have the same index
					list.add(new Triplet(t1.first + t2.first, index1.deleteLastChar, position.deleteLastChar) )
				}
			}//for
		}
		
		return list
	
	}//mergeResults
	
	
	/**
	 * Evaluate the outcome of sequence
	 */
	def private String evalOperation(Triplet<String, String, String> t){
		
		var eval = ""
		
		if(notCount % 2 == 0 ){		 	
 			
 			if( t.second == "1"){
 				eval = "T"
 			}
 			else {
 				if (t.second == "2"){
 					eval = "F"
 				}
 			}	 				 
		
		}//if notCount == 0 
	 	else{ //if(notCount %2 == 1)
 			
 			if( t.second == "1"){
 				eval = "F"
 			}
 			else {
 				if (t.second == "2" || t.second == "3"){
 					eval = "T"
 				}
 			}
	 	
	 	}//else
	
	}//evalOperation
	
	
	/**
	 * 
	 */
	def private void addIndepVector(Couple<String,Integer> cp1, Couple<String,Integer> cp2, List<List<Couple< Couple<String,Integer>, Couple<String,Integer> >>> listOfList){
		
		val a1 = cp1.first.toCharArray
		val a2 = cp2.first.toCharArray
		
		val size = cp1.first.length
		
		val val1 = cp1.second.intValue
		val val2 = cp2.second.intValue
		
		var a =  ""
		var index = -1
		
		if( cp1.first.length !=  cp2.first.length ||  cp1.first ==  cp2.first){
			throw new Exception("Illegal arguments")
		}
		else{
			
			var i =0
			do{	 
				if( a1.get(i) == a2.get(i) ){
					a = a + "0"
				}
				else{
					a = a + "1"
				}
				
			}while( (i=i+1) < size)
			
			var j =0
			var cnt = 0
			var asize = a.length
			//System.out.println(a)
		
			do{
				if(a.charAt(j).toString() == "1"){
					cnt = cnt + 1
					index = j
				}
			} while((j=j+1) < asize)
			
			if(cnt == 1){ //independence is true				
				cp1.setSecond(val1 + 1)
				cp2.setSecond(val2 + 1)

				listOfList.get(index).add(new Couple(cp1, cp2))
			}
	
		}//else
	
	}//addIndepVector
	
	
	/**
	 * fill the List with 'Empty elements'. That way we create an array of fixed elements
	 */
	def private fillWithEmptyElements(ArrayList<List<Couple<Couple<String, Integer>, Couple<String, Integer>>>> listOfList, int size) {
		
		for(var i =0; i<size; i++){
			listOfList.add( new ArrayList<Couple<Couple<String, Integer>, Couple<String, Integer>>> )
		}
	
	}//fillWithEmptyElements
	
	
}//class