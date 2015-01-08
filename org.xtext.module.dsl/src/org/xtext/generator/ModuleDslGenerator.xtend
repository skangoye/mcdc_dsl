/*
 * generated by Xtext
 */
package org.xtext.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.xtext.mcdc.MCDC_Module
import org.xtext.moduleDsl.MODULE_DECL

/**
 * Generates code from your model files on save.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#TutorialCodeGeneration
 */
class ModuleDslGenerator implements IGenerator {
	
	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		for(e: resource.allContents.toIterable.filter(typeof(MODULE_DECL))){
			val moduleName = e.name
			fsa.generateFile( moduleName + ".txt", e.compile())
		}
	}//doGenerate
	
//	def compile (MODULE_DECL module){		
//		val mcdc = new MCDC_Module()
//		mcdc.testCFG(module)
//		return ""
//	}
	
	def compile (MODULE_DECL module){
		
		val mcdc = new MCDC_Module()
		val solutionsAndCoverage = mcdc.mcdcOfModule(module)
		val solutions = solutionsAndCoverage.first
		val coveragereport = solutionsAndCoverage.second
		
		'''
		
				MC/DC TESTS DATA FOR MODULE «module.name» 
				
			« var i = 0»
			«FOR dataList: solutions»
				/***********************************************************************************************/
			
				  Test data «i = i + 1» :
					
					«FOR variable: dataList»		
						«val flow = variable.first»
						«val name = variable.second»
						«val value = variable.third»	
						«IF flow == "in" ||  flow == "inout"»
							input: « name » => «value»
						«ENDIF»					
						«IF flow == "out"»
							expected: « name » => «value»
						«ENDIF»	
					
					«ENDFOR»
				/***********************************************************************************************/
			«ENDFOR»
			
				COVERAGE REPORT FOR THE MODULE «module.name» 
			
				«coveragereport»
			
		'''
	} 
	
/* 	def compile(IF_STATEMENT ifst, String mcdcDecisionAlgo){
		
		val condExp = ifst.ifCond
		 mcdcDecision(mcdcDecisionAlgo, condExp)
		
		return ""
	}
	
	def private mcdcDecision(String mcdcDecisionAlgo, EXPRESSION cond){
		
		try{
			val algoCode = Integer.parseInt(mcdcDecisionAlgo)
		
			if(algoCode == 1){
			 	(new MCDC_Of_Decision).mcdcOfBooleanExpression(cond)
			}
			else{
				if(algoCode == 2){
					(new MCDC_Of_Decision2).mcdcOfBooleanExpression(cond)
				}
				else{
					if(algoCode == 3){
						(new MCDC_Of_Decision3).mcdcOfBooleanExpression(cond)
					}
				}
			}
		}//try
		catch (Exception e){
			(new MCDC_Of_Decision3).mcdcOfBooleanExpression(cond)
		}
		
		
	}//mcdcDecision */

}//ModuleDslGenerator
