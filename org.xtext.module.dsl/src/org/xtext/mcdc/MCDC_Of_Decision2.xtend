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

class MCDC_Of_Decision2 {
	
	/**
	 * Compute the MC/DC of a boolean expression
	 * @param booleanExpression 
	 * 							The boolean expression to be used
	 * @return A list of booleanExpression's MC/DC tests and theirs corresponding outcomes
	 */
	 def List<Couple<String, String>> mcdcOfBooleanExpression(EXPRESSION booleanExpression){
	 	
	 	val dfsValues = new ArrayList<List<Triplet<String, String, String>>>
	 	val mcdcResults = new ArrayList<Couple<String, String>>
	 	
	 	mcdcDepthFirstSearch(booleanExpression, dfsValues)
	 	val linkResult = mcdcBottomUp(dfsValues)
	 	
	 	val falseValueWithWeight = new ArrayList<Couple<String, Integer>>
	 	val trueValueWithWeight = new ArrayList<Couple<String, Integer>>
	 	
	 	for(triplet:linkResult){
	 		
	 		val outcome = triplet.evalOperation
	 		val mcdcCandidate = triplet.first
	 		
	 		if( outcome!= "T" && outcome!= "F" ){ throw new Exception("Incorrect outcome result") }
	 		
	 		if(outcome == "T"){
	 			trueValueWithWeight.add( new Couple(mcdcCandidate, 0))
	 		}
	 		else{//outcome == "F"
	 			falseValueWithWeight.add( new Couple(mcdcCandidate, 0))
	 		}
	 		
	 	}
	 	
	 	// falseValueWithWeight and trueValueWithWeight are set with the right values
	 	
	 	val listOfIndepVectors = new ArrayList<Couple<String, Integer>>
	 	
	 	notCount = 0 //reset notCountValue
	 	firstOperator = "" //reset first operator
	 	
	 	return mcdcResults
	 
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
	def void mcdcDepthFirstSearch(EXPRESSION exp, List<List<Triplet<String, String, String>>> resultList){
		
		if(exp instanceof AND){
			
			firstOperator = "and"
			
			var leftList = new ArrayList<Triplet<String, String, String>>
		    var rightList = new ArrayList<Triplet<String, String, String>>
			
			//Add T1, T2 and F3 to lesftList
			leftList.add(new Triplet('T', "1", "1"))
			leftList.add(new Triplet('T', "2", "1"))
			leftList.add(new Triplet('F', "3", "1"))
			
			//Add T1, F2 and T3 to righttList
			rightList.add(new Triplet('T', "1", "0"))
			rightList.add(new Triplet('F', "2", "0"))
			rightList.add(new Triplet('T', "3", "0"))
			
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
				leftList.add(new Triplet('T', "1", "1"))
				leftList.add(new Triplet('F', "2", "1"))
				leftList.add(new Triplet('F', "3", "1"))
				
				//Add T1, F2 and T3 to righttList
				rightList.add(new Triplet('F', "1", "0"))
				rightList.add(new Triplet('T', "2", "0"))
				rightList.add(new Triplet('F', "3", "0"))
				
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
	def void mcdcDepthFirstSearch2(EXPRESSION exp, List<Triplet<String, String, String>> list, List<List<Triplet<String, String, String>>> result){
		
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
	def void doAndEval(List<Triplet<String, String, String>> Triplets, List<Triplet<String, String, String>> left, List<Triplet<String, String, String>> right) {
		
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
	def void doOrEval(List<Triplet<String, String, String>> Triplets, List<Triplet<String, String, String>> left, List<Triplet<String, String, String>> right) {
		
		//for each couple of the list do the following tests
		for (t:Triplets){
			if (t.first.toString == "F"){
				left.add(new Triplet('F', t.second + "1", t.third + "1"))
				right.add(new Triplet('F', t.second + "1", t.third + "0" ))
			}
			else {
				if(t.first.toString == "T"){
					left.add(new Triplet('T', t.second + "1", t.third + "1"))
					right.add(new Triplet('F', t.second + "1", t.third + "0" ))
					left.add(new Triplet('F', t.second + "2", t.third + "1"))
					right.add(new Triplet('T', t.second + "2", t.third + "0" ))
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
	def void doNotEval(List<Triplet<String, String, String>> Triplets, List<Triplet<String, String, String>> notlist) {
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
	def void doEqCompVarEval(List<Triplet<String, String, String>> Triplets, List<List<Triplet<String, String, String>>>result) {
		result.add(Triplets)
	}//doEqCompVarEval
	
	
	/**
	 * 
	 */
	def List<Triplet<String, String, String>> mcdcBottomUp(List<List<Triplet<String, String, String>>> resultList){
		
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
	 def mergeResults(List<Triplet<String, String, String>> left, List<Triplet<String, String, String>> right){
		
		val list = new ArrayList<Triplet<String, String, String>>
		
		for(t1: left){
			var index = t1.second
			var position = t1.third
			for(t2:right){
				if(index == t2.second){//merge values that have the same index
					list.add(new Triplet(t1.first + t2.second, index.deleteLastChar, position.deleteLastChar) )
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
		 	
		 	if(firstOperator == "and"){
	 			if( t.second == "1"){
	 				eval = "T"
	 			}
	 			else {
	 				if (t.second == "2" || t.second == "3"){
	 					eval = "F"
	 				}
	 			}
		 	}//firstOperator == "and"
	 		
	 		else{
	 			
	 			if(firstOperator == "or"){
	 				if( t.second == "3"){
	 					eval = "F"
	 				}
	 				else {
	 					if (t.second == "1" || t.second == "2"){
	 						eval = "T"
	 					}
	 				}
	 			}//firstOperator == "or"
	 			else{
	 				eval = t.first///
	 			}
	 		
	 		}
		 
		 }//if notCount == 0
		 
	 	else{
	 		//if(notCount %2 == 1)
 			if(firstOperator == "and"){
	 			if( t.second == "1"){
	 				eval = "F"
	 			}
	 			else {
	 				if (t.second == "2" || t.second == "3"){
	 					eval = "T"
	 				}
	 			}
 			}
	 		else{
	 			if(firstOperator == "or"){
	 				if( t.second == "3"){
	 					eval = "T"
	 				}
	 				else {
	 					if (t.second == "1" || t.second == "2"){
	 						eval = "F"
	 					}
	 				}
	 			}// if first Operator
	 			else{
	 				if(t.first == "F"){
	 					 eval = "T"
	 				}
	 				else{
	 					eval = "F"
	 				}  
	 			}
	 	   }
	 	}//else
	}//evalOperation
	
	
	/**
	 * 
	 */
	def private void addIndepVector(Couple<String,Integer> cp1, Couple<String,Integer> cp2, List<List<Couple<String,String>>> list){
		
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
			
			if(cnt == 1){				
				cp1.setSecond(val1 + 1)
				cp2.setSecond(val2 + 1)
			
				//System.out.println(index)
				list.get(index).add(new Couple(cp1.first, cp2.first))////
			}
	
		}//else
	
	}//addIndepVector
	
	
}//class