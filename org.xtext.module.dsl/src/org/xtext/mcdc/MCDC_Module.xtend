package org.xtext.mcdc

import java.util.ArrayList
import java.util.HashMap
import java.util.List
import org.jgrapht.alg.KShortestPaths
import org.jgrapht.graph.DirectedWeightedMultigraph
import org.xtext.cfg.CondCfgNode
import org.xtext.cfg.LabeledWeightedEdge
import org.xtext.cfg.Node
import org.xtext.cfg.SimpleCfgNode
import org.xtext.coverage.Module_Coverage
import org.xtext.helper.Couple
import org.xtext.helper.Triplet
import org.xtext.moduleDsl.MODULE_DECL
import org.xtext.optimization.optimStrategy1

import static org.xtext.tests.data.TestDataGeneration.*

import static extension org.xtext.SSA.StaticSingleAssignment2.*
import static extension org.xtext.cfg.DslControlflowGraph.*
import static extension org.xtext.equations.solving.ChocoEquationsTranslator.*
import static extension org.xtext.path.constraints.GetFeasiblePaths.*
import static extension org.xtext.tests.data.MergedSuiteToTestSuite.*
import static extension org.xtext.utils.DslUtils.*

class MCDC_Module {
	
	def testCFG(MODULE_DECL module){
		val mcdcStatement = new MCDC_Statement()
		val graph = module.buildCFG(mcdcStatement)
		System.out.println("Graph Representation! ")
		System.out.println("Graph vertices:  " + graph.vertexSet.size)
		System.out.println(graph.toString)
	}
	
	def mcdcOfModule(MODULE_DECL module){
		
		val mcdcStatement = new MCDC_Statement() //new MCDC_Statement instance
		val optim = new optimStrategy1() // new optimization instance
		val coverage = new Module_Coverage() //new coverage instance
	
		val graph = module.buildCFG(mcdcStatement)
		val modulePaths = graph.graphPaths.copyListOfList 
		
		val feasiblePaths = modulePaths.getFeasiblePaths(module, mcdcStatement) //get feasible execution paths

		val hashmap = feasiblePaths.staticSingleAssignmentOnPaths(mcdcStatement)
		
		val pathsIdentSequencesMap = feasiblePaths.getPathsIdentSequences
		

		System.out.println
		System.out.println
		System.out.println("####### MODULES PATHS...Size => " + modulePaths.size + " #######")
		for(r: feasiblePaths){
			System.out.println("{")
			r.printListOfTriplet
			System.out.println("}")
			System.out.println
		}
				
		val feasiblePathsForMcdc = feasiblePaths.filterBooleanExpressions //remove non-boolean expressions

//		System.out.println("####### TESTS SUITE #######")
		val mergedSuite = mcdcStatement.mergeMcdcValues(feasiblePathsForMcdc) //merge MC/DC values 
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
			
			val listOfEquations = mcdcStatement.buildEquations(notMergedValues, feasiblePathsForMcdc)//get the equations
//			
//			System.out.println ("####### EQUATIONS ####### ")
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
	
	def getGraphPaths(DirectedWeightedMultigraph<Node, LabeledWeightedEdge> graph){
		
		val startVertexPattern = "entry"
		val endVertexPattern = "exit"
		val startVertex = graph.getNode(startVertexPattern)
		val endVertex = graph.getNode(endVertexPattern)
		
		val size = graph.vertexSet.size 
		
		val pathGenerator = new KShortestPaths<Node, LabeledWeightedEdge>(graph, startVertex, 100, size)
		val paths = pathGenerator.getPaths(endVertex)
		
		val listOfPathsEdges = new ArrayList<List<LabeledWeightedEdge>>
		paths.forEach[ graphPath | listOfPathsEdges.add(graphPath.edgeList) ]
		
		return graph.graphPathsToTripletsPaths(listOfPathsEdges)
		
	}//getGraphPaths
	
	
	def graphPathsToTripletsPaths(DirectedWeightedMultigraph<Node, LabeledWeightedEdge> graph, List<List<LabeledWeightedEdge>> graphPaths){
		
		val tripletsPaths = new ArrayList<List<Triplet <List<String>, List<String>, List<String>>>>
		
		graphPaths.forEach[ 
			
			listOfedges | val tripletPath = new ArrayList< Triplet<List<String>, List<String>, List<String>> >
			
			listOfedges.forEach[ 
				
				edge | val edgeSource = graph.getEdgeSource(edge)
				
				if(edgeSource.getId != "entry"){ //discard entry node. 
					
					switch(edgeSource){
						
						CondCfgNode:{ 
							val edgeLabel = edge.label
							if( edgeLabel == "T" ) { tripletPath.add(edgeSource.getTrueTriplet) }
							else{ 
								if(edgeLabel == "F"){ tripletPath.add(edgeSource.getFalseTriplet) }	
								else{ throw new Exception("Unknown label")}
							}
						}
						
						SimpleCfgNode:{
							tripletPath.add(edgeSource.getTriplet)
						}
						
						default:{ /*nothing*/ }
					}//switch
				
				}//if
			
			]//forEach
		
			tripletsPaths.add(tripletPath)
			
		]//forEach
	
		return tripletsPaths
	
	}//graphPathsToTripletsPaths
	
	
	def private Node getNode(DirectedWeightedMultigraph<Node, LabeledWeightedEdge> graph, String id){
		
		val nodeSet = graph.vertexSet
		
		try{
			nodeSet.findFirst[ node | node.getId == id]
		}
		catch(Exception e){
			throw new Exception("Error: Node with the id " + id + " not found! ")
		}
	
	}//getNode
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