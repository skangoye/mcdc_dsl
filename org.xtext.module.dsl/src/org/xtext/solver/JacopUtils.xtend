package org.xtext.solver

import org.jacop.core.IntVar
import org.jacop.floats.core.FloatVar
import org.xtext.moduleDsl.INTERVAL
import org.xtext.moduleDsl.LSET
import org.xtext.moduleDsl.VAR_DECL

import static extension org.xtext.utils.DslUtils.*

class JacopUtils {
	
	/**
	 * 
	 */
	def static setIntervalConstraints(ProblemJacop pb, Object solverVar, VAR_DECL dslVar) {
			
		val type = dslVar.type.type
		val interval = (dslVar.range as INTERVAL)
		
		val min = interval.min.literalValue
		val max = interval.max.literalValue

		val leftSqBr = interval.lsqbr
		val rightSqBr = interval.rsqbr
		
	 	if(type == "real"){
	 		
	 		var minVal = pb.MIN_FLOAT 
	 		var maxVal = pb.MAX_FLOAT
	 		
	 		if(min != "?"){
	 			minVal = min.parseDouble	 			
	 		}
	 		
	 		if(max != "?"){
	 			maxVal = max.parseDouble
	 			
	 		}
	 		
	 		//set the initial domain
	 		(solverVar as FloatVar).setDomain(minVal, maxVal)
	 		
	 		if(leftSqBr == "]"){ pb.post(pb.gt(solverVar, minVal)) }
	 		
	 		if(rightSqBr == "["){ pb.post(pb.lt(solverVar, maxVal)) }
	 		
	 	}
	 	else{
	 		if(type == "int"){
	 			
	 			var minVal = pb.MIN_INT 
	 			var maxVal = pb.MAX_INT
	 		
	 			if(min != "?"){
	 				minVal = min.parseInt
	 			}
	 		
	 			if(max != "?"){
	 				maxVal = max.parseInt 				
	 			}
	 			
	 			//set the initial domain
	 			(solverVar as IntVar).setDomain(minVal, maxVal)
	 		
	 			if(leftSqBr == "]"){ pb.post(pb.gt(solverVar, minVal)) }
	 			
	 			if(rightSqBr == "["){ pb.post(pb.lt(solverVar, maxVal)) }
	 			
	 		}
	 		
	 		else{
	 			throw new Exception(" #### Type error #### ")
	 		}
	 	}		
		
	}//setIntervalConstraints
	
	
	/**
	 * 
	 */
	def static setSetconstraints(ProblemJacop pb, Object solverVar, VAR_DECL dslVar){
		
		val type = dslVar.type.type
		val set = (dslVar.range as LSET)
		
		switch(type){
			
			case "real": { //TODO: complete this part
				val setElem = set.value;
				//val dom = new Float
				(solverVar as FloatVar).dom.clear
			}
			
			case "int": {
				
			}
			
			case "enum": {
				//set the initial domain
	 			(solverVar as IntVar).setDomain(0, set.value.size-1) //enumvar <= size of its elements -
			}
			
			default: {}
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}