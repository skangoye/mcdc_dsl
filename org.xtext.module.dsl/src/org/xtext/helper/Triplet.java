package org.xtext.helper;

import org.xtext.helper.BinaryTree;
import org.xtext.helper.Couple;

public class Triplet <T1, T2, T3> {
	 private T1 val1; 
	 private T2 val2; 
	 private T3 val3;
	 
	 public Triplet(T1 myValue1, T2 myValue2, T3 myValue3 ){
			 this.val1 = myValue1;
			 this.val2 = myValue2;	
			 this.val3 = myValue3;
	 }
	 
	 public T1 getFirst(){
		 return this.val1;
	 }
	 
	 public void setFirst(T1 val){
		 this.val1 = val;
	 }
	 	 
	 public T2 getSecond(){
		 return this.val2;
	 }
	 
	 public void setSecond(T2 val){
		 this.val2 = val;
	 }
	 
	 public T3 getThird(){
		 return this.val3;
	 }
	 
	 public void setThird(T3 val){
		 this.val3 = val;
	 }

	public static void updateSubPath(Couple<String, String> couple, BinaryTree<Couple<String, String>> tree) {
	  throw new UnsupportedOperationException("TODO: auto-generated method stub");
	}
}

