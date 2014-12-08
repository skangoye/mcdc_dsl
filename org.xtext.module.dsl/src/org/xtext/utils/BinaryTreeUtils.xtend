package org.xtext.utils

import org.xtext.helper.Couple
import org.xtext.helper.BinaryTree
import java.util.List
import java.util.ArrayList

class BinaryTreeUtils {
	
	def static boolVarsInBT(BinaryTree<Couple<String,String>> bt){
		val listOfBoolVars = new ArrayList<String>
		boolVarsInBT(bt, listOfBoolVars)
		return listOfBoolVars
	}
	
	def private static void boolVarsInBT(BinaryTree<Couple<String,String>> bt, List<String> list){
		
		val btvalue = bt.value
		val operator = btvalue.first
		val index = btvalue.second
		
		switch(operator){
			case "OR": {
				bt.left.boolVarsInBT(list)
				bt.right.boolVarsInBT(list)
			}
				
			case "AND": {
				bt.left.boolVarsInBT(list)
				bt.right.boolVarsInBT(list)
			}
			
			case "XOR": {
				bt.left.boolVarsInBT(list)
				bt.right.boolVarsInBT(list)
			}
			
			case "NOT": {
				bt.right.boolVarsInBT(list)
			}
			
			case "==": {
				list.add( bt.left.stringRepr + "==" + bt.right.stringRepr)
			}
			
			case "!=": {
				list.add( bt.left.stringRepr + "!=" + bt.right.stringRepr)
			}
			
			case "<": {
				list.add( bt.left.stringRepr + "<" + bt.right.stringRepr)
			}
			
			case ">": {
				list.add( bt.left.stringRepr + ">" + bt.right.stringRepr)
			}
			
			case "<=": {
				list.add( bt.left.stringRepr + "<=" + bt.right.stringRepr)
			}
			
			case ">=": {
				list.add( bt.left.stringRepr + ">=" + bt.right.stringRepr)
			}
			default:{ 
				if (index != ""){//variable
					list.add(nameWithIndex(btvalue))
				}
			}
		}
	}//
	
	def static String nameWithIndex( Couple<String, String> value){
		val ident = value.second
		if(ident != ""){
			return value.first + "|" + value.second + "|"
		}
		else{
			return value.first
		}
	}
	
	def static String stringRepr(BinaryTree<Couple<String,String>> bt){
		if(!bt.isEmpty()){
			if(!bt.isLeaf()){
				"(" + bt.left.stringRepr + bt.value.first + bt.right.stringRepr +")"
			}
			else{ //leaf
				return nameWithIndex(bt.value)
			}//leaf
		}
	}
	
}