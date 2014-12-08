package org.xtext.solver

import java.util.Map
import org.xtext.moduleDsl.VAR_DECL
import org.xtext.moduleDsl.INTERVAL
import org.xtext.helper.Couple
import org.xtext.moduleDsl.LSET

import static extension org.xtext.utils.DslUtils.*

class SoverUtils {
	
	def static void setRangeConstraints2(ProblemCoral pb, Map<String, Object> solverIntvars, Map<String, Object> solverDoubleVars, Map<String, Object> dslVars){
		
		val iSize = solverIntvars.size
		val dSize = solverDoubleVars.size
		
		if(iSize > 0) { //set ranges for SymInt values
			val solverIntvarsKeys= solverIntvars.keySet
			
			var min = -200 //default minimum variable value 
			var max = 100 //default maximum variable value
			var exclMin = false //exclude minimum value
			var exclMax = false //exclude maximum value
			
			//get variable ranges
			for(key : solverIntvarsKeys){
				val dslVarsValue = dslVars.get(key)
				if(dslVarsValue != null){
					
					System.out.println(" set range Constraint: " + key)
					val minCouple = getMin(dslVarsValue as VAR_DECL) 
					val maxCouple = getMax(dslVarsValue as VAR_DECL)
					
					min = minCouple.first.intValue
					exclMin = minCouple.second.booleanValue
					max = maxCouple.first.intValue
					exclMax = maxCouple.second.booleanValue
					
					val value = solverIntvars.get(key)
					pb.intervalConstraint(value, min, exclMin, max, exclMax)
				}
			
			}//for
		}
		
		if(dSize > 0){ //set ranges for SymDouble values
			val realVarsKeys= solverDoubleVars.keySet
			
			var min = -200.0 //default minimum variable value 
			var max = 100.0 //default maximum variable value
			var exclMin = false //exclude minimum value
			var exclMax = false //exclude maximum value
			
			//get variable ranges
			for(key : realVarsKeys){
				val dslVarsValue = dslVars.get(key)
				if(dslVarsValue != null){
					val minCouple = getMin(dslVarsValue as VAR_DECL) 
					val maxCouple = getMax(dslVarsValue as VAR_DECL)
					
					min = minCouple.first.doubleValue
					exclMin = minCouple.second.booleanValue
					max = maxCouple.first.doubleValue
					exclMax = maxCouple.second.booleanValue
			
					val value = solverDoubleVars.get(key)
					pb.intervalConstraint(value, min, exclMin, max, exclMax)
				}
		
			}//for	
		}
	}//
	
	def static setRangeConstraints(ProblemCoral pb, Map<String, Object> dslVars, Map<String, Object> solverIntvars, Map<String, Object> solverDoubleVars){
		val dslVarsKeys = dslVars.keySet
		for(key: dslVarsKeys){
			
			val dslVariable = (dslVars.get(key) as VAR_DECL)
			val dslVarType = dslVariable.type.type
			
			if(dslVarType == "int" || dslVarType == "enum"){
				if(solverIntvars.containsKey(key)){
					val solverVar = solverIntvars.get(key)
					
					val minCouple = getMin(dslVariable) 
					val maxCouple = getMax(dslVariable)
					
					val min = minCouple.first.intValue
					val exclMin = minCouple.second.booleanValue
					val max = maxCouple.first.intValue
					val exclMax = maxCouple.second.booleanValue
			
					pb.intervalConstraint(solverVar, min, exclMin, max, exclMax)
				}
			}
			else{
				if(dslVarType == "real"){		
					if(solverDoubleVars.containsKey(key)){
						val solverVar = solverDoubleVars.get(key)
						
						val minCouple = getMin(dslVariable) 
						val maxCouple = getMax(dslVariable)
						
						val min = minCouple.first.doubleValue
						val exclMin = minCouple.second.booleanValue
						val max = maxCouple.first.doubleValue
						val exclMax = maxCouple.second.booleanValue
				
						pb.intervalConstraint(solverVar, min, exclMin, max, exclMax)
					}
				}
				else{
					//not handled yet. TODO: handle str, bool, bit and hex
				}
			}
		
		}
	}
	
	
	def static Couple<Double, Boolean> getMin(VAR_DECL decl) {
		
		val range = decl.range
		val type = decl.type.type
		var strict = false //greater than 'min' value parameter
		
		if(range == null){
			return new Couple(-100.0, false)
		}
		else{
			if(range instanceof INTERVAL){
				
				val interval = (range as INTERVAL)
				val min = interval.min.literalValue
				val leftSqBr = interval.lsqbr
				
				if(leftSqBr == "]"){//set greater than parameter to true
				 	strict = true
				}
				
				if(min == "?"){
					return new Couple(-100.0, false)
				}
				else{
				 	if(type == "real"){
				 		return new Couple(min.parseDouble , strict)
				 	}
				 	else{
				 		if(type == "int"){
				 			return new Couple( min.parseDouble, strict)
				 		}
				 		else{
				 			throw new UnsupportedOperationException("Type error")
				 		}
				 	}
				}
					
			}//interval
			else{//set
				if(range instanceof LSET){
					val set = (range as LSET)
					if(type == "enum") {
						return new Couple(0.0 , false)
					}
					else{
						//TODO: 
					}
				}
				else{
					throw new UnsupportedOperationException("Unknown Range")
				}
			}
		}
	}//getMin
	
	def static Couple<Double, Boolean> getMax(VAR_DECL decl) {
		val range = decl.range
		val type = decl.type.type
		var strict = false //greater than 'max' value parameter
		
		if(range == null){
			return new Couple(100.0, false)
		}
		else{
			if(range instanceof INTERVAL){
				
				val interval = (range as INTERVAL)
				val max = interval.max.literalValue
				val rightSqBr = interval.rsqbr
				
				if(rightSqBr == "["){//set greater than parameter to true
				 	strict = true
				}
				
				if(max == "?"){
					return new Couple(100.0 , false)
				}
				else{
				 	if(type == "real"){
				 		return new Couple(max.parseDouble , strict)
				 	}
				 	else{
				 		if(type == "int"){
				 			return new Couple(max.parseDouble , strict)
				 		}
				 		else{
				 			throw new UnsupportedOperationException("Type error")
				 		}
				 	}
				}
					
			}//interval
			else{//set
				if(range instanceof LSET){
					val set = (range as LSET)
					if(type == "enum") {
						val maxInt = set.value.size.toString
						return new Couple(maxInt.parseDouble -1 , false)
					}
					else{
						//TODO: 
					}
				}
				else{
					throw new UnsupportedOperationException("Unknown Range")
				}
			}
		}
	}//getMax
}