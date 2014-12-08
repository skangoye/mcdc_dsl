package org.xtext.helper;

public class Couple<T1, T2> {
	 private T1 val1; 
	 private T2 val2; 
	 
	 public Couple(T1 myValue1, T2 myValue2){
			 this.val1 = myValue1;
			 this.val2 = myValue2;	
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
}
