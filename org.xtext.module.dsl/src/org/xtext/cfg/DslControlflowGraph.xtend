package org.xtext.cfg

import java.util.ArrayList
import java.util.List
import org.jgrapht.graph.DirectedWeightedMultigraph
import org.xtext.moduleDsl.ASSIGN_STATEMENT
import org.xtext.moduleDsl.AbstractVAR_DECL
import org.xtext.moduleDsl.IF_STATEMENT
import org.xtext.moduleDsl.MODULE_DECL
import org.xtext.moduleDsl.STATEMENT

import static extension org.xtext.utils.DslUtils.*
import org.xtext.helper.Couple
import org.xtext.mcdc.MCDC_Statement

class DslControlflowGraph {
	
	var private static identifier = 0
	val private static final entry = "entry"
	val private static final exit = "exit"
	val private static final trueLabel = "T"
	val private static final falseLabel = "F"
	val private static final emptyLabel = ""
	
	def static buildCFG(MODULE_DECL module, MCDC_Statement mcdcStatement){
		
		val modelGraph = new DirectedWeightedMultigraph<Node, LabeledWeightedEdge>(LabeledWeightedEdge) 
		
		val entryNode = new Node(entry) //entry node creation
		modelGraph.addVertex(entryNode) //adding entry node to the graph
		
		val predsIdentAndLabel = new ArrayList<Couple<String,String>> 
		predsIdentAndLabel.add( new Couple(entry, emptyLabel) ) //setting the predIdentList with the entry node id and its outgoing edge label
		
		val stmtList = module.body.statements //module statements list
	
		val finalPreds = modelGraph.toCFG(stmtList, predsIdentAndLabel, mcdcStatement)
		
		val exitNode = new Node(exit) //exit node creation
		modelGraph.addVertex(exitNode) //adding exit node to the graph
			
		modelGraph.addEdges(finalPreds, exitNode) //setting final edges to the exit node
		
		identifier = 0 //reset identifier
		
		return modelGraph
		
	}//buildCFG
	
	def static private List<Couple<String,String>> toCFG(DirectedWeightedMultigraph<Node, LabeledWeightedEdge> graph , List<STATEMENT> stmtList, List<Couple<String,String>> preds, MCDC_Statement mcdcStatement){
			
//		System.out.println(" Statement list: " + stmtList.size)
		
		val stmtListSize = stmtList.size //statement list size
			
		if(stmtListSize > 0){
			
			identifier = identifier + 1 //identifier is incremented for the next statement
			val strIdentifier = identifier.toString
			
			val currentStatement = stmtList.get(0)
				
			switch (currentStatement) {
				
				AbstractVAR_DECL: {				
					
					val varTriplet = mcdcStatement.mcdcVarStatement(currentStatement)
					
					val node = new SimpleCfgNode(strIdentifier, currentStatement, varTriplet)
					graph.addVertex(node)
					graph.addEdges(preds, node)
					
					val newPreds = new ArrayList<Couple<String,String>>
					newPreds.add( new Couple(strIdentifier, emptyLabel) )
					
					if (stmtList.size > 1){
						stmtList.remove(0)
						return graph.toCFG(stmtList, newPreds, mcdcStatement)
					}
					else{//size is 1 because stmtList.get(0) doesn't raise an exception
						val nodeArray = new ArrayList<Couple<String,String>>
						nodeArray.add( new Couple(strIdentifier,emptyLabel) )
						return nodeArray						
					}			
				
				}//AbstractVAR_DECL
				
				ASSIGN_STATEMENT: {
					
					val assignTriplet = mcdcStatement.mcdcAssignStatement(currentStatement)
					val node = new SimpleCfgNode(strIdentifier, currentStatement, assignTriplet)
					graph.addVertex(node)
					graph.addEdges(preds, node)
	
					val newPreds = new ArrayList<Couple<String,String>>
					newPreds.add( new Couple(strIdentifier,emptyLabel) )
					
					if (stmtList.size > 1){
						stmtList.remove(0)					
						return graph.toCFG(stmtList, newPreds, mcdcStatement)
					}
					else{//size is 1 because stmtList.get(0) doesn't raise an exception
						val nodeArray = new ArrayList<Couple<String,String>>
						nodeArray.add( new Couple(strIdentifier,emptyLabel) )
						return nodeArray						
					}			
				
				}//ASSIGN_STATEMENT
				
				IF_STATEMENT: {				
					
					val condTriplet = mcdcStatement.mcdcIfThenElseStatement(currentStatement)

					val node = new CondCfgNode(strIdentifier, currentStatement, condTriplet.first, condTriplet.second)
					graph.addVertex(node)
					graph.addEdges(preds, node)
					
					val ifPreds = new ArrayList<Couple<String,String>>
					val elsePreds = new ArrayList<Couple<String,String>>
					ifPreds.add( new Couple(strIdentifier, trueLabel) )
					elsePreds.add( new Couple(strIdentifier, falseLabel) )
					
					val ifStmtList = currentStatement.ifst
					val elseStmtList = currentStatement.elst
					
					val list1 = graph.toCFG(ifStmtList, ifPreds, mcdcStatement)
					val list2 = graph.toCFG(elseStmtList, elsePreds, mcdcStatement)
					
					val cumulPreds = new ArrayList<Couple<String,String>>
					cumulPreds.addAll(list1)
					cumulPreds.addAll(list2)
					
					if (stmtList.size > 1){ //currentStatement is not the last element
						stmtList.remove(0)
						return graph.toCFG(stmtList, cumulPreds, mcdcStatement)
					}
					else{//size is 1 because stmtList.get(0) doesn't raise an exception
						return cumulPreds					
					}			
					
				}//IF_STATEMENT
							
				default:{
				
				}
			
			}//switch
		
		}//if
		
		else{//size is 0		
			
			return preds  //nodeArray													
		
		}//else
		
		
					
	}//toCFG
	
	
	def static private void addEdges(DirectedWeightedMultigraph<Node, LabeledWeightedEdge> graph , List<Couple<String,String>> preds, Node node){
		
		preds.forEach[ pred | 
			
			val nodeId = pred.first 
			val labelValue = pred.second
			
			val predNode = graph.getNode(nodeId)
			val label = new LabeledWeightedEdge(labelValue)
			
			graph.addEdge(predNode, node, label)			
		
		]
	
	}//addEdges
	
		
	def private static Node getNode(DirectedWeightedMultigraph<Node, LabeledWeightedEdge> graph, String id){
		
		val nodeSet = graph.vertexSet
		
		try{
			nodeSet.findFirst[ node | node.getId == id]
		}
		catch(Exception e){
			throw new Exception("Error: Node with the id " + id + " not found! ")
		}
	
	}//getNode
	
	
	def String getStmtID (STATEMENT stmt){
		
		switch(stmt){
			
			AbstractVAR_DECL: {
				return stmt.name
			}
			
			ASSIGN_STATEMENT: {
				val left = stmt.left
				val exp = stmt.right
				return left.variable.name + " = " + exp.stringReprOfExpression
			}
			
			IF_STATEMENT: {
				return stmt.ifCond.stringReprOfExpression
			}
			
			default: ""
				
		}
	
	}

}// class