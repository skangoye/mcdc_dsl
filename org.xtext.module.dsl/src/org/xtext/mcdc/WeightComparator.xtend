package org.xtext.mcdc

import java.util.Comparator
import org.xtext.helper.Couple

class WeightComparator implements Comparator<Couple<Couple<String,Integer>, Couple<String,Integer>>>{
	
	//order is reversed in order to sort lists from the highest weight to the lowest
	override compare(Couple<Couple<String,Integer>, Couple<String,Integer>> cp1, Couple<Couple<String,Integer>, Couple<String,Integer>> cp2) {
		
		val cp1Weight = (cp1.first.second + cp1.second.second).intValue
		val cp2Weight = (cp2.first.second + cp2.second.second).intValue
		
		if(cp1Weight > cp2Weight){
			return -1
		}
		else{
			if(cp1Weight < cp2Weight){
				return 1
			}
			else{
				return 0
			}
		}
	}
	
}//class