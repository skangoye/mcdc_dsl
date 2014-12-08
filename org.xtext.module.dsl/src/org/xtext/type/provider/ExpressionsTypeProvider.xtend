package org.xtext.type.provider

import org.xtext.moduleDsl.EXPRESSION
import org.xtext.moduleDsl.intConstant
import org.xtext.moduleDsl.realConstant
import org.xtext.moduleDsl.strConstant
import org.xtext.moduleDsl.enumConstant
import org.xtext.moduleDsl.boolConstant
import org.xtext.moduleDsl.bitConstant
import org.xtext.moduleDsl.hexConstant
import org.xtext.moduleDsl.AND
import org.xtext.moduleDsl.OR
import org.xtext.moduleDsl.NOT
import org.xtext.moduleDsl.EQUAL_DIFF
import org.xtext.moduleDsl.COMPARISON
import org.xtext.moduleDsl.MULT
import org.xtext.moduleDsl.DIV
import org.xtext.moduleDsl.SUB
import org.xtext.moduleDsl.ADD
import org.xtext.moduleDsl.VarExpRef
import org.xtext.moduleDsl.AbstractVAR_DECL

class ExpressionsTypeProvider {
	public static val intType = 'int'
	public static val realType = 'real'
	public static val boolType = 'bool'
	public static val strType = 'str'
	public static val enumType = 'enum'
	public static val hexType = 'hex'
	public static val bitType = 'bit'
	
	def static String typeFor(EXPRESSION e){
		
		switch(e){
			intConstant :  intType
	 		realConstant:  realType
	 		strConstant :  strType
	 		enumConstant:  enumType
	 		boolConstant:  boolType
	 		bitConstant :  bitType
	 		hexConstant :  hexType
	 		AND         :  boolType
	 		OR          :  boolType
	 		NOT         :  boolType
	 		EQUAL_DIFF  :  boolType
	 		COMPARISON  :  boolType
	 		MULT		:  typeForMult(e)
	 		DIV			:  typeForDiv(e)
	 		SUB			:  typeForSub(e)
	 		ADD			:  typeForAdd(e)
	 		VarExpRef	:  typeForVar(e)
		}	
	}
	
	def static String typeForMult(MULT e){
		val leftType = e.left?.typeFor
		val rightType = e.right?.typeFor
		if (leftType == intType && rightType == intType){
			return intType
		}
		else{
			if (leftType == realType && rightType == intType || leftType == intType && rightType == realType || leftType == realType && rightType == realType){
				return realType
			}
			else{
				return null
			}
		}
		
	}
	
	def static String typeForDiv(DIV e){
		val leftType = e.left?.typeFor
		val rightType = e.right?.typeFor
		if (leftType == intType && rightType == intType){
			return intType
		}
		else{
			if (leftType == realType && rightType == intType || leftType == intType && rightType == realType || leftType == realType && rightType == realType){
				return realType
			}
			else{
				return null
			}
		}
		
	}
	
	def static String typeForSub(SUB e){
		val leftType = e.left?.typeFor
		val rightType = e.right?.typeFor
		if (leftType == intType && rightType == intType){
			return intType
		}
		else{
			if (leftType == realType && rightType == intType || leftType == intType && rightType == realType || leftType == realType && rightType == realType){
				return realType
			}
			else{
				return null
			}
		}
		
	}
	
	def static String typeForAdd(ADD e){
		val leftType = e.left?.typeFor
		val rightType = e.right?.typeFor
		if (leftType == intType && rightType == intType){
			return intType
		}
		else{
			if (leftType == realType && rightType == intType || leftType == intType && rightType == realType || leftType == realType && rightType == realType){
				return realType
			}
			else{
				if (leftType == strType && rightType == strType){
					return strType
				}
				else{
					if (leftType == bitType && rightType == bitType){
						return bitType
					}
					else{
						if (leftType == hexType && rightType == hexType){
							return hexType
						}
						else{
							return null
						}
					}
				}
			}
		}
		
	}
	
	def static String typeForVar(VarExpRef e){
		if (e.vref == null	){
			return null
		}
		else{
			e.vref.varTypeProvider
		}
		
		
	}
	
	def static String varTypeProvider(AbstractVAR_DECL abstractVar) {
		val typ = abstractVar.type?.type
		switch typ {
			case typ=='int' : intType
			case typ=='real': realType
			case typ=='bool': boolType
			case typ=='enum': enumType
			case typ=='str' : strType
			case typ=='bit' : bitType
			case typ=='hex' : hexType
			default : null
			
		}
	}
	
	
	}