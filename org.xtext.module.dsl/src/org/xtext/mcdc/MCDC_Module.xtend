package org.xtext.mcdc

import java.util.ArrayList
import java.util.List
import org.xtext.helper.Triplet
import org.xtext.moduleDsl.ASSIGN_STATEMENT
import org.xtext.moduleDsl.AbstractVAR_DECL
import org.xtext.moduleDsl.ERROR_STATEMENT
import org.xtext.moduleDsl.IF_STATEMENT
import org.xtext.moduleDsl.LOOP_STATEMENT
import org.xtext.moduleDsl.MODULE_DECL
import org.xtext.optimization.optimStrategy1
import org.xtext.solver.ProblemCoral
import org.xtext.coverage.Module_Coverage

import static org.xtext.path.constraints.pathConstraintsUtils.*
import static extension org.xtext.SSA.StaticSingleAssignment.*
import static extension org.xtext.SSA.StaticSingleAssignment2.*
import static extension org.xtext.utils.DslUtils.*
import static extension org.xtext.equations.solving.ChocoEquationsTranslator.*
import static extension org.xtext.tests.data.TestDataGeneration.*
import static extension org.xtext.tests.data.MergedSuiteToTestSuite.*
import static extension org.xtext.path.constraints.GetFeasiblePaths.*
import java.util.HashMap
import org.xtext.helper.Couple

class MCDC_Module {
	

	def mcdcOfModule(MODULE_DECL module){
		
		val mcdcStatement = new MCDC_Statement() //new MCDC_Statement instance
		val optim = new optimStrategy1() // new optimization instance
		val coverage = new Module_Coverage() //new coverage instance
	
		val modulePaths = enumerateModulePaths(module, mcdcStatement).copyListOfList //module execution paths
		
		val feasiblePaths = modulePaths.getFeasiblePaths(module, mcdcStatement) //get feasible execution paths

		val hashmap = feasiblePaths.staticSingleAssignmentOnPaths(mcdcStatement)
		
		val pathsIdentSequencesMap = feasiblePaths.getPathsIdentSequences
		

		System.out.println
		System.out.println
		System.out.println("####### MODULES PATHS...Size => " + feasiblePaths.size + " #######")
		for(r: feasiblePaths){
			System.out.println("{")
			r.printListOfTriplet
			System.out.println("}")
			System.out.println
		}
				
		val modulePaths_forMCDC = feasiblePaths.filterBooleanExpressions //remove non-boolean expressions

//		System.out.println("####### TESTS SUITE #######")
		val mergedSuite = mcdcStatement.mergeMcdcValues(modulePaths_forMCDC) //merge MC/DC values 
//		mergedSuite.printListOfTriplet
//		
		val decomposeMergedResult = mcdcStatement.splitMergedValues(mergedSuite) //Split the merged results

//		System.out.println("####### COVERAGE RESULT #######")
//		for(triplet:coverageResult){
//			System.out.println
//			System.out.print(triplet.first.toString + " => ")
//			System.out.print(triplet.second.toString + " => " )
//			System.out.println(triplet.third.toString )
//			System.out.println
//		}
		
		val notMergedValues = mcdcStatement.notMergedValues(decomposeMergedResult) //not merged values
		
//		System.out.println("####### NOT COVERED #######")
//		notMergedValues.printListOfTriplet
		
		if(notMergedValues.size != 0){ //values in notMergedValues have not been covered
			
			val listOfEquations = mcdcStatement.buildEquations(notMergedValues, modulePaths_forMCDC)//get the equations
//			
			System.out.println ("####### EQUATIONS ####### ")
//			for(r: listOfEquations){
//				System.out.println("{")
//				r.printListOfTriplet
//				System.out.println("}")
//				System.out.println
//			}
			
			//try to solve the equations
			for(equations: listOfEquations){
				mcdcStatement.chocoEquationSolving(equations, mergedSuite) //build equation
			}
//			
//			val newDecomposeMergedResult = mcdcStatement.splitMergedValues(mergedSuite) //coverage results after the resolution of equations
//		
//			System.out.println("####### NEW TESTS SUITE #######")
//			mergedSuite.printListOfTriplet
			
//			val newNotCoveredValues = mcdcStatement.notCoveredValues(newCoverageResult)// not covered values after the resolution
			
//			System.out.println("####### NEW NOT COVERED #######")
//			newNotCoveredValues.printListOfTriplet
			
		}//notMergedValues.size != 0
			
		val testSuiteMap = mergedSuite.mergedSuiteToTestSuite
	
		val solutions = testDataGen(module, testSuiteMap, pathsIdentSequencesMap, hashmap)
		
		val coveredSequences = solutions.keySet.toList
		
		val coverageReport = coverage.moduleCoverageReport(coveredSequences, mcdcStatement.allBooleanExpressions,  mcdcStatement.getAllExpressionsMcdcValues)
		
		val optimizedSolutions = optim.optimize(mcdcStatement.getAllExpressionsMcdcValues, solutions)
		
		return new Couple(optimizedSolutions, coverageReport)
		
	
	}//mcdcOfModule
	
	
	/**
	 * Lists the different execution paths of the module. 
	 * In our context each path is represented by a list of triplets, where a triplet represents an evaluation of an instruction
	 */
	def private enumerateModulePaths(MODULE_DECL module, MCDC_Statement mcdcStatement){
		
		val allStatements = module.body.statements
		var List<List<Triplet <List<String>, List<String>, List<String> >>> result = new ArrayList<List<Triplet <List<String>, List<String>, List<String> >>>
		
		for(st: allStatements){
			switch(st){
				
				AbstractVAR_DECL: {
					val triplet = mcdcStatement.mcdcVarStatement(st)
					if(triplet != null){
						result = buildPaths(result, triplet.tripletToListOfList)
					}
				}//AbstractVAR_DECL
				
				ASSIGN_STATEMENT: {
					val triplet = mcdcStatement.mcdcAssignStatement(st)
					if(triplet != null){
						result = buildPaths(result, triplet.tripletToListOfList)
					}
				}//ASSIGN_STATEMENT
				
				IF_STATEMENT: {
					result = buildPaths(result, mcdcStatement.mcdcIfStatement(st))
				}//IF_STATEMENT
				
				ERROR_STATEMENT:{
					//nothing to do
				}//ERROR_STATEMENT
				
				LOOP_STATEMENT:{
					//TODO: To be implemented later
				}//LOOP_STATEMENT
				
			}//switch
		}//for
		
		return result
		
	}
	
	/**
	 * Transforms a triplet to a 'list of list of triplet' format.
	 */
	def private tripletToListOfList(Triplet <List<String>, List<String>, List<String> > triplet){
		val tmp = new ArrayList<Triplet <List<String>, List<String>, List<String> >>
		tmp.add(triplet)
		val List<List<Triplet <List<String>, List<String>, List<String> >>> tmpList = new ArrayList<List<Triplet <List<String>, List<String>, List<String> >>>
		tmpList.add(tmp)
		return tmpList
	}//tripletToListOfList
	
	/**
	 * Remove expressions that doesn't take part (directly) on MCDC computation.
	 * In our context these expressions are those having an identifier of the form: '-N'
	 * where '-' is an integer 
	 */
	 def private filterBooleanExpressions(List<List<Triplet <List<String>, List<String>, List<String>>>> modulePaths){
	 	//filter boolean expressions along  the path
		val result =  new ArrayList<List<Triplet <List<String>, List<String>, List<String>>>>
		modulePaths.forEach[ 
			list | val newList = list.filter[ it.third.extractIdentIndex != "N" ].toList
			result.add(newList)
		]
		return result
	 }
	/**
	 * enumerateModulePaths private method.
	 * It builds paths by merging modules semi-paths
	 */
	def private buildPaths(List<List<Triplet<List<String>, List<String>, List<String>>>> list1, List<List<Triplet <List<String>, List<String>, List<String> >>> list2){
		
		val result = new ArrayList<List<Triplet <List<String>, List<String>, List<String>>>>
		
		val size1 = list1.size
		val size2 = list2.size
		
		if (size2 == 0){
			throw new RuntimeException("##### Invalid argument #####")
		}
		else{//list2 is not empty
			
			if( size1 == 0){
				return list2
			}
			else{//list1 is not empty and list2 is not empty
				for(e1: list1){
					for(e2: list2){
						val tmpList = new ArrayList<Triplet <List<String>, List<String>, List<String> >>
						
						tmpList.addAll(e1)
						tmpList.addAll(e2) //tmpList now contains 'e1 + e2'
	
						result.add(tmpList)
					}//for
				}//for
			}	
		
		}//else
		
		return result
	
	}//mergePaths	
	
	
	/**
	 * Return a map that maps the path ID with the sequence of expressions identifiers along this path
	 */
	def getPathsIdentSequences(List<List<Triplet<List<String>, List<String>, List<String>>>> modulePaths){
		
		val map = new HashMap<String, List<String>>
		
		modulePaths.forEach[ 
			
			path, pathId | val listOfIdents = new ArrayList<String>
			
			path.forEach[
				subPath | val ident = subPath.third.get(0) //get the ident
				listOfIdents.add(ident)
			]//forEach
			
			val put = map.put(pathId.toString, listOfIdents)
		
		]//forEach
		
		return map
	
	}//getPathsIdentSequences

}//class