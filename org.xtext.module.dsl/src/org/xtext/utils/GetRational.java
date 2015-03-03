package org.xtext.utils;

import org.xtext.helper.Couple;

public class GetRational {

	public static void main(String[] args){
		Couple<Long,Long> c = toRational(0.75);
		System.out.println( c.getFirst() + "/" + c.getSecond());
	}
	
	public static Couple<Long, Long> toRational(double value){
		
		long term = 1;	
		while( (value*term - (long)(value*term)) != 0 ){
			term = term*10;
		}
		
		long divident = (long) (value*term);
		long divisor = term;
	
		long gcd = 1;
		
		if(divident > divisor)
			gcd = GCD(divident, divisor);
		else
			gcd = GCD(divisor, divident);
	
		divident = divident / gcd ;
		divisor  = divisor / gcd ;
		
		if(divisor < 0){ //invert divident and divisor signs
			divisor = 0 - divisor;
			divident = 0 - divident;
		}
		
		return new Couple<Long, Long>(divident, divisor);
		
	}//toRational
	
	//a>=b
	private static long GCD(long a, long b){
		
		long remainder = a%b;
		
		if(remainder == 0)
			return b;
		else
			return GCD(b, remainder);
	
	}//GCD
	
}
