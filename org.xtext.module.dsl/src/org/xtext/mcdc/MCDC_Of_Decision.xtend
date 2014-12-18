package org.xtext.mcdc

import java.util.TreeSet
import java.util.Set
import org.xtext.helper.Couple
import java.util.ArrayList
import java.util.List
import org.xtext.moduleDsl.EXPRESSION
import org.xtext.moduleDsl.AND
import org.xtext.moduleDsl.OR
import org.xtext.moduleDsl.NOT
import org.xtext.moduleDsl.EQUAL_DIFF
import org.xtext.moduleDsl.COMPARISON
import org.xtext.moduleDsl.VarExpRef
import static extension org.xtext.utils.DslUtils.*
import org.xtext.moduleDsl.boolConstant

class MCDC_Of_Decision {
	
	//Counts the the number of 'not' operators crossed from the root to the first operator of type 'and/or', in the parse tree
	//e.g.: The expression 'not (a and b)' returns notCount = 1 while 'not a and not b' returns 0
	var private notCount = 0
	
	var private firstOperator = "" //used to record the first crossed operator of type 'and/or' in the parse tree	
	
	
	/**
	 * Compute the MC/DC of a boolean expression
	 * @param booleanExpression 
	 * 							The boolean expression to be used
	 * @return A list of booleanExpression's MC/DC tests and theirs corresponding outcomes
	 */
	 def mcdcOfBooleanExpression(EXPRESSION booleanExpression){
	 	
	 	val dfsValues = new ArrayList<List<Couple<Couple<String,String>, Couple<String,String>>>>
	 	val finalMCDCValues = new ArrayList<String>
	 	
	 	mcdcDepthFirstSearch(booleanExpression, dfsValues)
	 	val linkResult = mcdcBottomUp(dfsValues)
	 	
	 	for(i:linkResult){
	 		val couple = i.first
	 		finalMCDCValues.add(couple.second + couple.first) //couple.second is the outcome of the expression test (couple.first)
	 	}
	 	
	 	System.out.println( "Final Values: " + finalMCDCValues.toString)
	 		 	
	 	return finalMCDCValues
	 
	 }//mcdcOfBooleanExpression
	 

	/**
	 * Performs a DFS (Depth-First-Search) upon the expression parse tree, to reach its leaf-nodes and store.
	 * @param expression
	 * 					Boolean expression parse tree
	 * @param resultList
	 * 					list of all leaf-nodes' with theirs values.
	 * A leaf-node value is composed of trivial values 'True' and 'False', its position in the tree and the sequence of its parents
	 */
	def void mcdcDepthFirstSearch(EXPRESSION expression, List<List<Couple< Couple<String, String>, Couple<String, String> >>> resultList){
		
		if(expression instanceof AND){
			//AND operator is crossed => Set position of its siblings (1 for left and 0 for right) and store "a" as their parent
			var leftCouple =  new Couple(new Couple("",""), new Couple("1","a")) 
		    var rightCouple = new Couple(new Couple("",""), new Couple("0","a")) 
			
			firstOperator = "and"
			
			//cast expression as AND
			val andExp = (expression as AND)
			
			//recursive call of mcdcDepthFirstSearch2 method with its siblings
			mcdcDepthFirstSearch2(andExp.left, leftCouple, resultList)
			mcdcDepthFirstSearch2(andExp.right, rightCouple, resultList)
			
		}
		else{
			if(expression instanceof OR){
				//OR operator is crossed => Set position of its siblings (1 for left and 0 for right) and store "o" as their parent
				var leftCouple =  new Couple(new Couple("",""), new Couple("1","o")) 
		    	var rightCouple = new Couple(new Couple("",""), new Couple("0","o")) 
				
				firstOperator = "or"
				
				val orExp = (expression as OR)
				
				//recursive call of mcdcDepthFirstSearch2 method with its siblings
				mcdcDepthFirstSearch2(orExp.left, leftCouple, resultList)
				mcdcDepthFirstSearch2(orExp.right, rightCouple, resultList)
			}
			else{
				//NOT operator is crossed before an "and/or" operator => increment "notCount"
				if( expression instanceof NOT){
					val notExp = (expression as NOT)
					notCount = notCount + 1
					//No need to define values for the first "not" expression
					//call recursively on mcdcDepthFirstSearch
					mcdcDepthFirstSearch(notExp.exp, resultList)
				}
				else{ 
					//The expression is a relational condition or a boolean atomic variable and are considered as leaves
					if (expression instanceof EQUAL_DIFF || expression instanceof COMPARISON || expression instanceof VarExpRef){
						
						var list = new ArrayList< Couple< Couple<String, String>, Couple<String, String> > >
							
							//Add False and True values to the result list
							list.add(new Couple(new Couple("F","F"), new Couple("","")))
							list.add(new Couple(new Couple("T","T"), new Couple("","")))
						
						resultList.add(list)
					}
					else{				
						throw new Exception("Illegal boolean expression")
					}
				}
			}
		}
	
	}//mcdcDepthFirstSearch method
	
	
	/**
	 * Called by mcdcDepthFirstSearch method to perform the DFS
	 * @see 
	 * 		mcdcDepthFirstSearch
	 */
	def void mcdcDepthFirstSearch2(EXPRESSION expression, Couple<Couple<String,String>,Couple<String,String>> couple, List<List<Couple< Couple<String, String>, Couple<String, String> >>> result) {
			
		if (expression instanceof AND){
			
			val position = couple.second.first
			val parent = couple.second.second
			
			//the new positions of the operator siblings are its current position + (1 or 0)
			//parent sequences are "a" + the operator current parent sequence
			var leftCouple =  new Couple( new Couple ("",""),  new Couple(position + "1", "a" + parent) )
		    var rightCouple = new Couple( new Couple ("",""),  new Couple(position + "0", "a" + parent) )
		    
		    //recursive call of mcdcDepthFirstSearch2 method with its siblings
			mcdcDepthFirstSearch2( (expression as AND).left , leftCouple, result )
			mcdcDepthFirstSearch2( (expression as AND).right , rightCouple, result )
			
		}
		else{
			if (expression instanceof OR){
				
				val position = couple.second.first
				val parent = couple.second.second
				
				var leftCouple =  new Couple( new Couple ("",""),  new Couple(position + "1", "o" + parent) )
			    var rightCouple = new Couple( new Couple ("",""),  new Couple(position + "0", "o" + parent) )
				
				mcdcDepthFirstSearch2( (expression as OR).left , leftCouple, result )
				mcdcDepthFirstSearch2( (expression as OR).right , rightCouple, result )
			
			}
			else{
				if (expression instanceof NOT){
					
					val position = couple.second.first
					val parent = couple.second.second
					
					//In case of not operator the position of its sibling is unchanged whereas
					//parent sequence is "n"+ the operator current parent
					var notCouple =  new Couple( new Couple ("",""),  new Couple(position , "n" + parent) )
					
					//recursive call of enumMcdc method with "not" sibling
					mcdcDepthFirstSearch2((expression as NOT).exp , notCouple, result)
					
				}
				else {
					
					//These expressions are considered as the parse tree leaves
					if (expression instanceof EQUAL_DIFF || expression instanceof COMPARISON || expression instanceof VarExpRef){
						
						val position = couple.second.first
						val parent = couple.second.second
						
						var list = new ArrayList< Couple< Couple<String, String>, Couple<String, String> > >
						
						//Add False and True values to the result list and stores theirs corresponding positions and parents sequence
						//in the resultList
						list.add( new Couple( new Couple ("F","F"),  new Couple(position , parent)) ) 
						list.add( new Couple( new Couple ("T","T"),  new Couple(position , parent)) )
						
						result.add(list)
					}
					else{
						throw new Exception("Illegal boolean expression")
					}
				}
			}
			
		}
	}//mcdcDepthFirstSearch2
	
	/**
	 * Performs a bottom-up walking on the parse tree (from the leaves to the root). It merges the parse tree siblings values until reaching its root.
	 * @param resultList
	 * 					list resulting from the Depth-First-Search of the method mcdcDepthFirstSearch
	 * @return list of MC/DC values of the boolean expression given in the mcdcDepthFirstSearch method
	 * @see mcdcDepthFirstSearch
	 */
	def List<Couple< Couple<String, String>, Couple<String, String> >> mcdcBottomUp (List<List<Couple< Couple<String, String>, Couple<String, String> >>> resultList){
		
		var myList = resultList
		
		//raise an exception if there is no values (leaves' values) in the list
		if (myList.size == 0){
			throw new Exception("List is empty") 
		}
		
		var i = 0
		do{
			if(myList.size == 1){
				//if the list size is 1 => return this as result
				//We use notCount here to determine the expressions' outcomes
				if (notCount % 2 == 0){
					//We have an even number of "not" crossed before the first (and/or) operator in the parse tree
					return myList.get(0)		
				}
				else{
					//invert values (outcome) in case of odd number of "not" crossed before the first (and/or) operator in the parse tree
					return myList.get(0).invertValues()
				}
				
			}
			
			//Two sequences can be considered as siblings if they are the same parent position
			// e.g. S1 position is "1110" and S2 position is "1111", they are siblings because theirs parents has the same position
			//which is "111"
			val tmpList = myList.get(i)
			val position = tmpList.get(0).second.first
			val parentPosition = position.deleteLastChar
			val toInt = Integer.parseInt(position.getLastChar)
			
			val cmp = myList.findFirst
			[ it != tmpList && ((it.get(0).second.first.deleteLastChar)==(parentPosition)) 
			 && (toInt - Integer.parseInt(it.get(0).second.first.getLastChar)) ==1]
			
			if(cmp != null){
				//they are siblings => merge theirs results
				myList.set(i, mergeResults(tmpList, cmp))
				//delete siblings after their merging
				myList.remove(cmp)
			}	
			
		} while ((i=i+1) < myList.size)
		
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
	def List<Couple<Couple<String,String>,Couple<String,String>>> mergeResults(List<Couple<Couple<String,String>,Couple<String,String>>> left, List<Couple<Couple<String,String>,Couple<String,String>>> right) {
		
		var listLeft = left
		var listRight = right
		
		//Next parent of the left sibling in the parent sequence
		var list1NextParent = listLeft.get(0).second.second.charAt(0)
		
		//if the next parent is "not" invert sequences outcome values and delete it in the sequence
		//Repeat the operation until the next parent will be of type "and/or"
		while(list1NextParent.toString == "n"){
			listLeft = invertValues(listLeft)
			list1NextParent = listLeft.get(0).second.second.charAt(0)
		}
		
		//Next parent of the right sibling in the parent sequence
		var list2NextParent = listRight.get(0).second.second.charAt(0)
		
		//if the next parent is "not" invert sequences outcome values and delete it in the sequence
		//Repeat the operation until the next parent is of type "and/or"
		while(list2NextParent.toString == "n"){
			listRight = invertValues(listRight)
			list2NextParent = listRight.get(0).second.second.charAt(0)
		}
		
		//position of the common parent
		//parent sequence of the common parent
		val position = listLeft.get(0).second.first.deleteLastChar
		val parent = listLeft.get(0).second.second.deleteFisrtChar
		
		//
		return optimMerge(listLeft, listRight, list1NextParent.toString , list2NextParent.toString, position, parent)

	}//mergeResults
	
	/**
	 * Merging approach of the MC/DC tests generation
	 */
	def optimMerge(List<Couple<Couple<String,String>,Couple<String,String>>> l1, List<Couple<Couple<String,String>,Couple<String,String>>> l2, String p1, String p2, String position, String parent) {
		
		//Filter sequences in the left list whose outcome are True
		var leftTrue = l1.filter[it.first.second == "T"]
		
		//Filter sequences in the left list whose outcome are False
		var leftFalse = l1.filter[it.first.second == "F"]
		
		var leftCouple = new ArrayList<Couple<String, String>>
		val resultList = new ArrayList< Couple< Couple<String, String>, Couple<String, String> > >
		
		//compose mcdc independent pairs on left list
		for(i: leftFalse){
			for(j: leftTrue){
				if(independantPairs(i.first.first, j.first.first).first.booleanValue){
					leftCouple.add(new Couple (i.first.first, j.first.first))
				}
			}
		}
		
		//Filter sequences in the right list whose outcome are True
		var rightTrue = l2.filter[it.first.second == "T"]
		
		//Filter sequences in the right list whose outcome are False
		var rightFalse = l2.filter[it.first.second == "F"]
		
		var rightCouple = new ArrayList<Couple<String, String>>
		
		//compose mcdc independent pairs on right list
		for(ii: rightFalse){
			for(jj: rightTrue){
				if(independantPairs(ii.first.first, jj.first.first).first.booleanValue){
					rightCouple.add(new Couple (ii.first.first, jj.first.first))
				}
			}
		}
		
		//will be used to store merge results with True outcome
		val setWithTrue = new TreeSet<String>
		
		//will be used to store merge results with false outcome
		val setWithFalse = new TreeSet<String>
		
		if(p1 != p2){
			//raise an exception if the two siblings has not the same parent sequence
			throw new Exception("Parent mismatch")
		}
		else{
			//p1 = p2
			compute(leftCouple, rightCouple, setWithFalse, setWithTrue, p1)
			
			//return a new list that merged two siblings results with respect to mcdc independent pairs
			for(st: setWithTrue){
				resultList.add(new Couple (new Couple(st ,"T"), new Couple(position, parent)))
			}
			
			for(sf: setWithFalse){
				resultList.add(new Couple (new Couple(sf ,"F"), new Couple(position, parent)))
			}
			
		}//else
		
		return resultList
	}//optimMerge
	
	
	/**
	 * Compute the merging approach according to the next parent (and/or) and mcdc independent pairs
	 */
	def void compute(ArrayList<Couple<String,String>> list1, ArrayList<Couple<String,String>> list2, Set<String> setF, Set<String> setT, String nextParent) {
		
		if(nextParent == "a"){
			//common parent is an "and" operator
			
			//Pick one sequence whose outcome is True in the right sibling
			val  trueVal = list2.get(0).second 
			
			//merge left sibling values with sequence whose outcome is True in the right sibling results 
			for(i:list1){
				setF.add(i.first + trueVal)
				setT.add(i.second + trueVal)
			}
			 
			//Pick one sequence whose outcome is True in the left sibling
			val tValue = list1.get(0).second
			
			//merge left sibling value whose outcome is True with right sibling results
			for(j: list2){
				setF.add(tValue + j.first)
				setT.add(tValue + j.second)
			}
		}
		
		else{
			//common parent is an "or" operator
			if(nextParent == "o"){
				
				//Pick one sequence whose outcome is False in the right sibling
				val  falseVal = list2.get(0).first 
				
				//merge left sibling values with sequence whose outcome is False in the right sibling results 
				for(i:list1){
					setF.add(i.first + falseVal)
					setT.add(i.second + falseVal)
				}
				
				//Pick one sequence whose outcome is False in the left sibling
				val fVal = list1.get(0).first
				
				//merge left sibling value whose outcome is False with right sibling results 
				for(j: list2){
					setF.add(fVal + j.first)
					setT.add(fVal + j.second)
				}
			}
			else{
				throw new Exception("Invalid parent")
			}
		}
		
	}//compute
	
	/**
	 * Invert the outcome of a list of values
	 * @param list
	 * 			 list whose the outcome values have to be inverted
	 * @return list whose outcome values have been inverted
	 */
	def List<Couple<Couple<String,String>,Couple<String,String>>> invertValues(List<Couple<Couple<String,String>,Couple<String,String>>> list) {
		var tmp = list
		for(c: tmp){
			var parent = c.second.second
			if( c.first.second == "F"){
				c.first.setSecond("T")
				c.second.setSecond(parent.deleteFisrtChar)
			}
			else{
				if( c.first.second == "T"){
					c.first.setSecond("F")
					c.second.setSecond(parent.deleteFisrtChar)
				}
				else{
					throw new Exception ("Illegal Boolean value")
				}
			}
		}//for
		
		return tmp
	}//invertValues
	
	
}// end class 