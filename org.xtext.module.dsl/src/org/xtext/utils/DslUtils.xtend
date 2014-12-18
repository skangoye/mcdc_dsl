package org.xtext.utils

import java.util.List
import java.util.ArrayList

import org.xtext.helper.Couple
import org.xtext.helper.Triplet
import org.xtext.moduleDsl.EXPRESSION
import org.xtext.moduleDsl.AND
import org.xtext.moduleDsl.OR
import org.xtext.moduleDsl.EQUAL_DIFF
import org.xtext.moduleDsl.NOT
import org.xtext.moduleDsl.COMPARISON
import org.xtext.moduleDsl.VarExpRef
import org.xtext.moduleDsl.ADD
import org.xtext.moduleDsl.SUB
import org.xtext.moduleDsl.MULT
import org.xtext.moduleDsl.DIV
import org.xtext.moduleDsl.intConstant
import org.xtext.moduleDsl.realConstant
import org.xtext.moduleDsl.strConstant
import org.xtext.moduleDsl.enumConstant
import org.xtext.moduleDsl.boolConstant
import org.xtext.moduleDsl.bitConstant
import org.xtext.moduleDsl.hexConstant
import java.util.Set
import org.xtext.moduleDsl.Literal
import org.xtext.moduleDsl.bitLITERAL
import org.xtext.moduleDsl.intLITERAL
import org.xtext.moduleDsl.realLITERAL
import org.xtext.moduleDsl.boolLITERAL
import org.xtext.moduleDsl.enumLITERAL
import org.xtext.moduleDsl.strLITERAL
import org.xtext.moduleDsl.hexLITERAL
import org.xtext.moduleDsl.unknowLITERAL
import org.xtext.moduleDsl.CST_DECL

class DslUtils {
	
	  
	/**
	  * Checks whether two lists have common elements 
	  * @param list1: list of String
	  * @param list2: list of string
	  * @return list: A list of common elements except for the special characters '#' and '*'
	  */
	  def static List<String> intersectionOfLists(List<String> list1, List<String> list2){
	  	val commonList = new ArrayList<String>
	  	
	  	if (list1.size == 0 || list2.size == 0 ){
	  		return commonList
	  	}
	  	
	  	for (i:list1){
	  		for (j:list2){
	  			if ( i == j && j != "*" && j != "#"){
	  				commonList.add(j)
	  			}
	  		}
	  	}
	  	return commonList
	  }
	  
	  /**
	  * store the indexes of common elements of list1 and list2
	  * @param list1: list of String
	  * @param list2: list of string
	  * @return list: A list of common elements except special characters '#' and '*'
	  */
	   def static List<Couple<Integer,Integer>> indexOfCommonVars(List<String> list1, List<String> list2){
	  	val commonList = new ArrayList<Couple<Integer,Integer>>
	  	
	  	if (list1.size == 0 || list2.size == 0 ){
	  		return commonList
	  	}
	  	
	  	var i = 0
	  	val size1 = list1.size
	  	val size2 = list2.size
	  	do{
	  		val e1 = list1.get(i)
	  		var j = 0
	  		do{
	  			val e2 = list2.get(j)
	  			if ( (e1 != "*") && (e1 != "#") && (e2 != "*") && (e2 != "#") ){
	  				if( e1 == e2){
	  					commonList.add(new Couple(i,j))
	  				}	
	  			}
	  		} while((j=j+1) < size2)
	  		
	  	} while ((i=i+1) < size1)
	  	
	  	return commonList
	  }
	  
	/**
	 * Returns a new string that is this string without its last character 
	 * @param str The subject string i.e the string we want to delete its last character
	 * @return substring of the str without its last character
	 */
	def static String deleteLastChar(String str){
		val strSize = str.length
		var myStr = ""
		if(strSize > 0){
			myStr = str.substring(0, strSize-1)
		}
		return myStr
	}
	
	
	/**
	 * If a given String size is greater than 1, it returns a new string without the last character.
	 * Otherwise, it returns the actual string
	 */
	def static String deleteLastCharIfSup1(String str){
		val strSize = str.length
		if(strSize == 1 || strSize == 0){
			return str
		}
		else{
			val myStr = str.substring(0, strSize-1)
			return myStr
		}
	}
	
	/**
	 * Returns a new string that is this string without its first character  
	 */
	def static String deleteFisrtChar(String str){
		val strSize = str.length
		var myStr = ""
		if(strSize > 0){
			myStr = str.substring(1)
		}
		return myStr
	}
	
	/**
	 * Returns the last character of this string. 
	 * If the string is empty it returns an empty string
	 */
	def static String getLastChar(String str){
		val strSize = str.length
		var myStr = ""
		if (strSize > 0){
		 	 myStr = str.charAt(strSize-1).toString
		}
		return myStr
	}
	
	
	/**
	 * return in the form of string, the value of the literal
	 */
	def static String literalValue(Literal literal){
		switch(literal){
			intLITERAL: literal.value.toString
			realLITERAL: literal.value.toString
			strLITERAL: literal.value.toString
			enumLITERAL: literal.value.toString
			boolLITERAL: literal.value.toString
			bitLITERAL: literal.value.toString
			hexLITERAL: literal.value.toString
			unknowLITERAL: literal.value.toString
		}
	}
	
	/**
	 * Converts integer characters 
	 */
	 def static convertToBooleanChar(int value){
	 	if(value == 0){
	 		return "F"
	 	}
	 	else{
	 		if(value == 1){
	 			return "T"
	 		}
	 		else{
	 			throw new RuntimeException("##### Cannot convert to Boolean char #####")
	 		}
	 	}
	 }
	 
	 def static boolean boolValue(String character){
	 	if(character == "T"){
	 		return true
	 	}
	 	else{
	 		if (character == "F")
	 			return false
	 		else
	 			throw new Exception("Cannot convert to a boolean value")
	 	}
	 }
	/**
	 * 
	 */
	def static indexesBeforeSeparator(List<String> list){
		val indexes = new ArrayList<Couple<Integer,Integer>>
		val size = list.size
		var cpt = 0
		var currentIndex = 0
		
		for(str: list){
			if(str == "#"){
				indexes.add( new Couple(cpt,currentIndex-1))
				cpt = currentIndex + 1
			}
			
			if(currentIndex == (size - 1)){
				indexes.add( new Couple(cpt,size-1))
			}
			currentIndex = currentIndex + 1
		}
		return indexes
	}
	
	/**
	 * Transforms an array of string to a new string that is the concatenation 
	 * of all the elements of the list w.r.t theirs orders
	 */
	def static arrayToString(List<String> list){
		var tmpStr = ""
		for(str: list){
			tmpStr = tmpStr + str
		}
		return tmpStr
	}
	
	/**
	 * Parse a given string to an 'int' value
	 * @param 
	 * 		str valid String to be parsed
	 * @return 
	 * 		Integer corresponding to the string 'str' value
	 */
	def static parseInt(String str){
		return Integer.parseInt(str)
	}
	
	def static parseDouble(String str){
		return Double.parseDouble(str)
	}
	
	def static parseBoolean(String str){
		return Boolean.parseBoolean(str)
	}
	/**
	 * Lists all elements of 'list1' that are not in 'list2'
	 *  @param 
	 * 			list1
	 * 			list2
	 * @return all elements in list1 that are not in list2
	 */
	def static listDiff(List<String> list1 , List<String> list2){
		val List<String> list = new ArrayList<String>
		for(e1:list1){
			if (! list2.contains(e1) ){
				list.add(e1)
			}
		}//for
		return list
	}
	
	/**
	 * Converts a String to a new String array. Each character of the string becomes an element of the new string list.
	 */
	 def static toStringArray(String str){
	 	val charArray = str.toCharArray
	 	val toStringArray = new ArrayList<String>
	 	charArray.forEach[c | toStringArray.add(c.toString)]
	 	return toStringArray
	 }
	
	 /**
	   * 
	   */
	  def static unknownStringVector(int length){
	  	if(length < 1){
	  		throw new RuntimeException("The length has to be greater than 0")
	  	}
	  	
	  	var i =0
	  	var tmpStr = ""
	  	do {
	  		tmpStr = tmpStr + "*"
	  	}while ( (i=i+1) < length)
	  	
	  	return tmpStr
	  }
	
	
	  /**
	   * 
	   */
	  def static String setCharAt(String str, int index, char r){
	  		val size = str.length
	  		
	  		if(index >= size){
	  			throw new Exception("Index Out of range")
	  		}
	  		
	  		val toCharList = str.toCharArray
	  		toCharList.set(index, r)
	  		
	  		var newStr = ""
	  		
	  		for (e: toCharList){
	  			newStr = newStr + e.toString
	  		}

			return newStr	 		
	  }
	  	
	/**
	 * Returns a new list that is a clone of this list of list of triplet.
	 */
	def static copyListOfList(List<List<Triplet<List<String>, List<String>, List<String>>>> listOfList){
		
		val copyListOfList = new ArrayList<List<Triplet <List<String>, List<String>, List<String>>>> 
		
		for(list: listOfList){
			
			val copyList = new ArrayList<Triplet <List<String>, List<String>, List<String>>>
			
			for(triplet: list){		
				copyList.add(new Triplet(triplet.first.copyList, triplet.second.copyList, triplet.third.copyList)) 
			}//for
			
			copyListOfList.add(copyList)
		}
		return copyListOfList
	}
	
	/**
	 * Returns a new list that is a clone of this list of triplet.
	 */
	 def static copyListOfTriplet(List<Triplet <List<String>, List<String>, List<String>>> listOfTriplet){
	 	
	 	val copyList = new ArrayList<Triplet <List<String>, List<String>, List<String>>>
			
			for(triplet: listOfTriplet){		
				copyList.add(new Triplet(triplet.first.copyList, triplet.second.copyList, triplet.third.copyList)) 
			}//for
			
			return copyList
	 }
	
	
	/**
	 * Prints in the console the elements of this list of triplet
	 */
	 def static printListOfTriplet(List<Triplet<List<String>, List<String>, List<String>>> listOfTriplet){
	 	System.out.println
	 	for(triplet: listOfTriplet){
			System.out.print(triplet.first.toString + " => ")
			System.out.print(triplet.second.toString + " => " )
			System.out.println(triplet.third.toString )
			System.out.println
		}
	 }
	
	/**
	 * 
	 */
	 def static printListOfCouple(List<Couple<String,String>> listOfCouples){
	 	System.out.print ("[")
	 	for(couple: listOfCouples){
			System.out.print( "( " + couple.first.toString + " , " + couple.second.toString + ") ")
		}
		System.out.println("]")
	 }
	 
	/**
	 * Returns the number of occurrences of the string 'str' in the list 'list'
	 */
	def static countElements(String str, List<String> list){
		var count = 0
		
		if(list.size == 0){
			return 0
		}
		
		for(e : list){
			if(str == e){
				count = count + 1
			}
		}
		return count
	}
	
	/**
	 * Returns the identifier of the sub-identifier contained in this list
	 * @throws if the list size is 0or greater than 1
	 */
	def static extractIdentifier(List<String> ident) {
		
		if(ident.size != 1){
			throw new Exception("Incorrect number of identifiers")
		}
		else{
			return ident.get(0).deleteLastChar
		}
	}
	
	/**
	 * Returns the index (T or F or X or N) of the sub-identifier contained in this list.
	 * @throws if the list size is 0or greater than 1
	 */
	def static extractIdentIndex(List<String> ident) {
		
		if(ident.size != 1){
			throw new Exception("Incorrect number of identifiers")
		}
		else{
			return ident.get(0).getLastChar
		}
	}
	

	/**
	 * Returns a string representation of this expression
	 */
	def static String stringReprOfExpression(EXPRESSION expression){
		
		switch(expression){
	 		AND: "(" + stringReprOfExpression(expression.left) + " and " + stringReprOfExpression(expression.right) + ")"
	 		OR: "(" + stringReprOfExpression(expression.left) + " or " + stringReprOfExpression(expression.right) + ")"
	 		EQUAL_DIFF: "(" + stringReprOfExpression(expression.left) + expression.op + stringReprOfExpression(expression.right) + ")"
	 		COMPARISON: "(" + stringReprOfExpression(expression.left) + expression.op + stringReprOfExpression(expression.right) + ")"
	 		NOT: " not " + stringReprOfExpression(expression.exp)
	 		ADD: "(" + stringReprOfExpression(expression.left) + "+" + stringReprOfExpression(expression.right) + ")"
	  		SUB: "(" + stringReprOfExpression(expression.left) + "-" + stringReprOfExpression(expression.right) + ")"
	  		MULT: "(" + stringReprOfExpression(expression.left) + "*" + stringReprOfExpression(expression.right) + ")"
	  		DIV: "(" + stringReprOfExpression(expression.left) + "/" + stringReprOfExpression(expression.right) + ")"
	  		VarExpRef: expression.vref.name 
	  		intConstant: expression.value.toString
	  		realConstant:expression.value.toString
	  		strConstant: expression.value.toString
	  		enumConstant: expression.value.toString
	  		boolConstant: expression.value.toString
	  		bitConstant: expression.value.toString
	  		hexConstant: expression.value.toString
	 	}
	}
	
	
	/**
	 * Stores in the set all the variables involved in the expression 
	 */
	 def static void allVarInExpression(EXPRESSION expression, Set<String> set){
	 	switch(expression){
	 		AND: {allVarInExpression(expression.left, set) allVarInExpression(expression.right, set)}
	 		OR: {allVarInExpression(expression.left, set) allVarInExpression(expression.right, set)} 
	 		NOT: allVarInExpression(expression.exp, set)
	 		EQUAL_DIFF: {allVarInExpression(expression.left, set) allVarInExpression(expression.right, set)}
	 		COMPARISON: {allVarInExpression(expression.left, set) allVarInExpression(expression.right, set)}
	 		ADD:{allVarInExpression(expression.left, set) allVarInExpression(expression.right, set)}
	 		SUB: {allVarInExpression(expression.left, set) allVarInExpression(expression.right, set)}
	 		MULT:{allVarInExpression(expression.left, set) allVarInExpression(expression.right, set)}
	 		DIV: {allVarInExpression(expression.left, set) allVarInExpression(expression.right, set)} 
	 		VarExpRef: set.add(expression.vref.name)
	 	}//
	 }
	 
	 
	 /**
	 * Stores in the list, all the boolean conditions involved in the expression.
	 * A relational condition (e.g (a<4)) is considered as a single variable
	 * @param expression The expression in which we want to extract the variables
	 * @param list All the variables will be stored in this list
	 */
	 def static booleanConditions(EXPRESSION expression){
	 	val listOfConditions = new ArrayList<EXPRESSION>
	 	expression.booleanConditions(listOfConditions)
	 	return listOfConditions
	 }
	 
	 def private static void booleanConditions(EXPRESSION expression, List<EXPRESSION> list){
	 	switch(expression){
	 		AND: {booleanConditions(expression.left, list) booleanConditions(expression.right, list)}
	 		OR: {booleanConditions(expression.left, list) booleanConditions(expression.right, list)}
	 		NOT: { booleanConditions(expression.exp, list) }
	 		EQUAL_DIFF: { list.add(expression) } 
	 		COMPARISON: { list.add(expression) }
	 		VarExpRef: { list.add(expression) } //boolean variable
	 		default: { /* nothing */}
	 	}
	 }
	 
	/**
	 * Stores in the list, all the boolean variables involved in the expression.
	 * A relational condition (e.g (a<4)) is considered as a single variable
	 * @param expression The expression in which we want to extract the variables
	 * @param list All the variables will be stored in this list
	 */
	 def static booleanVarInExpression(EXPRESSION expression){
	 	val booleanVarInExpression = new ArrayList<String>
	 	expression.booleanVarInExpression(booleanVarInExpression)
	 	return booleanVarInExpression
	 }
	 
	 
	 def static void booleanVarInExpression(EXPRESSION expression, List<String> list){
	 	switch(expression){
	 		AND: {booleanVarInExpression(expression.left, list) booleanVarInExpression(expression.right, list)}
	 		OR: {booleanVarInExpression(expression.left, list) booleanVarInExpression(expression.right, list)}
	 		EQUAL_DIFF: list.add(arithRepr(expression.left) + expression.op + arithRepr(expression.right)) 
	 		NOT: booleanVarInExpression(expression.exp, list)
	 		COMPARISON: list.add(arithRepr(expression.left) + expression.op + arithRepr(expression.right)) 
	 		VarExpRef: list.add(expression.vref.name)
	 	}
	 }
	 
	 /**
	  * Returns a string representation of any non boolean expression
	  */
	  def static String arithRepr(EXPRESSION expression){
	  	switch(expression){
	  		ADD: return "(" + arithRepr(expression.left)+ "+" +  arithRepr(expression.right) +")"
	  		SUB: return "(" + arithRepr(expression.left)+ "-" +  arithRepr(expression.right) +")"
	  		MULT: return "(" + arithRepr(expression.left)+ "*" +  arithRepr(expression.right) +")"
	  		DIV: return "(" + arithRepr(expression.left)+ "/" +  arithRepr(expression.right) +")"
	  		intConstant: return expression.value.toString
	  		realConstant: return expression.value.toString
	  		strConstant: return expression.value.toString
	  		enumConstant:return expression.value.toString
	  		boolConstant:return expression.value.toString
	  		bitConstant: return expression.value.toString
	  		hexConstant: return expression.value.toString
	  		VarExpRef: return expression.vref.name
	  		default:""
	  	}
	  }
	 
	/**
	 * Checks whether two given strings form an independent pair
	 * Two string (of bits) are said to form an independent pair if their XOR gives a new string of bits
	 * where exactly one element is equal to 1. e.g. "1010" and "1110" form an independence pair since their XOR is "0100"
	 * @param str1 String of bits
	 * @param str2 String of bits
	 * @return returns a couple, where the first parameter is a boolean assessing whether two strings form an independent pair.
	 * The second parameter is the index of the condition considered.
	 */
	def static independantPairs(String str1, String str2) {

		val a1 = str1.toCharArray
		val a2 = str2.toCharArray
		val size = str1.length
		
		var a =  ""
		var compatible = false
		var index = -1
		
		if(str1 == str2){
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
				//str1 at cp1 first param compatible with str2 at cp2 first param
				compatible = true;
				//list.add(new Couple (str1,str2))
			}
	
		}//else
		return new Couple(compatible, index)
	}
	 
	/**
	 * Returns a new list that is a clone of this list. The elements of the list should be primitive or strings. 
	 * @param list the subject list
	 * @return The new cloned list.
	 */
	def static <T> copyList(List<T> list){
		val List<T> copy = new ArrayList<T>
		for(e: list){
			copy.add(e)
		}
		return copy
	}
	
	/**
	 * Returns a new string list that is for each element the concatenation of the element of each couple of this list
	 * e.g: one Couple(String1,String2) => one String = 'String2 + String1'
	 * @ param list
	 * @return List of String w.r.t the rule
	 */
	def static List<String> reduceList( List<Couple<String, String>> list){
		val listOfString = new ArrayList<String>
		list.forEach[ t | listOfString.add(t.second + t.first)]
		return listOfString
	}
	
	/**
	 * Returns true if each first parameter of each triplet doesn't share common elements with the others
	 */
	def static boolean noVarInCommon(List<Triplet<List<String>,List<String>,List<String>>> list){
		var cumulList = new ArrayList<String>
		for(e:list){
			val varList = e.first
			if( intersectionOfLists(cumulList, varList).size > 0) {
				return false
			}
			cumulList.addAll(varList)
		}
		return true
	}
	
}//class

