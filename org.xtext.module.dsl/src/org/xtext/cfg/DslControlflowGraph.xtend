package org.xtext.cfg

import java.util.ArrayList
import java.util.List
import org.jgrapht.graph.DefaultWeightedEdge
import org.jgrapht.graph.DirectedWeightedMultigraph
import org.xtext.moduleDsl.ASSIGN_STATEMENT
import org.xtext.moduleDsl.AbstractVAR_DECL
import org.xtext.moduleDsl.IF_STATEMENT
import org.xtext.moduleDsl.MODULE_DECL
import org.xtext.moduleDsl.STATEMENT

import static extension org.xtext.utils.DslUtils.*

class DslControlflowGraph {
	
	var private static identifier = 0
	val static final entry = "entry"
	val static final exit = "exit"
	
	def static buildCFG(MODULE_DECL module){
		
		val modelGraph = new DirectedWeightedMultigraph<Node, DefaultWeightedEdge>(DefaultWeightedEdge) 
		
		val entryNode = new Node(entry) //entry node creation
		modelGraph.addVertex(entryNode) //adding entry node to the graph
		
		val predIdentList = new ArrayList<String> 
		predIdentList.add(entry) //setting the predIdentList with the entry node
		
		val stmtList = module.body.statements //module statements list
	
		val finalPredIdentList = modelGraph.toCFG(stmtList, predIdentList)
		
		val exitNode = new Node(exit) //exit node creation
		modelGraph.addVertex(exitNode) //adding exit node to the graph
			
		System.out.println(" Graph vertices:  " + modelGraph.vertexSet.size)

		modelGraph.addEdges(finalPredIdentList, exitNode) //setting final edges to the exit node
		
		identifier = 0 //reset identifier
		
		return modelGraph
		
	}//buildCFG
	
	def static private List<String> toCFG(DirectedWeightedMultigraph<Node, DefaultWeightedEdge> graph , List<STATEMENT> stmtList, List<String> predIdentList){
			
		System.out.println(" Statement list: " + stmtList.size)
		
		val stmtListSize = stmtList.size //statement list size
			
		if(stmtListSize > 0){
			
			identifier = identifier + 1 //identifier is incremented for the next statement
			val strIdentifier = identifier.toString
			
			val currentStatement = stmtList.get(0)
				
			switch (currentStatement) {
				
				AbstractVAR_DECL: {				
					
					val node = new Node(strIdentifier)
					graph.addVertex(node)
					graph.addEdges(predIdentList, node)
					
					val newPredIdentList = new ArrayList<String>
					newPredIdentList.add(strIdentifier)
					
					if (stmtList.size > 1){
						stmtList.remove(0)
						return graph.toCFG(stmtList, newPredIdentList)
					}
					else{//size is 1 because stmtList.get(0) doesn't raise an exception
						val nodeArray = new ArrayList<String>
						nodeArray.add(strIdentifier)
						return nodeArray						
					}			
				
				}//AbstractVAR_DECL
				
				ASSIGN_STATEMENT: {
					
					val node = new SimpleCfgNode(strIdentifier, currentStatement, false)
					graph.addVertex(node)
					graph.addEdges(predIdentList, node)
	
					val newPredIdentList = new ArrayList<String>
					newPredIdentList.add(strIdentifier)
					
					if (stmtList.size > 1){
						stmtList.remove(0)					
						return graph.toCFG(stmtList, newPredIdentList)
					}
					else{//size is 1 because stmtList.get(0) doesn't raise an exception
						val nodeArray = new ArrayList<String>
						nodeArray.add(strIdentifier)
						return nodeArray						
					}			
				
				}//ASSIGN_STATEMENT
				
				IF_STATEMENT: {				
					
					val condition = currentStatement.ifCond
					
					val node = new CondCfgNode(strIdentifier, condition, false)
					graph.addVertex(node)
					graph.addEdges(predIdentList, node)
					
					val newPredIdentList = new ArrayList<String>
					newPredIdentList.add(strIdentifier)
					
					val ifStmtList = currentStatement.ifst
					val elseStmtList = currentStatement.elst
					
					val list1 = graph.toCFG(ifStmtList, newPredIdentList)
					val list2 = graph.toCFG(elseStmtList, newPredIdentList)
					
					val cumulPredList = new ArrayList<String>
					cumulPredList.addAll(list1)
					cumulPredList.addAll(list2)
					
					if (stmtList.size > 1){ //currentStatement is not the last element
						stmtList.remove(0)
						return graph.toCFG(stmtList, cumulPredList)
					}
					else{//size is 1 because stmtList.get(0) doesn't raise an exception
						return cumulPredList					
					}			
					
				}//IF_STATEMENT
							
				default:{
				
				}
			
			}//switch
		
		}//if
		
		else{//size is 0
			
//			val node = new Node(strIdentifier)
//			graph.addVertex(node)
//			graph.addEdges(predIdentList, node)
			
//			val newPredIdentList = new ArrayList<String>
//			newPredIdentList.add(strIdentifier)

//			val nodeArray = new ArrayList<String>
//			nodeArray.add(strIdentifier)
			return predIdentList  //nodeArray												
	
		}//else
		
		
					
	}//toCFG
	
	
	def static private void addEdges(DirectedWeightedMultigraph<Node, DefaultWeightedEdge> graph , List<String> predIdentList, Node node){
		System.out.println(predIdentList + " => " + node.id)
		predIdentList.forEach[ 
			predIdent | val predNode = graph.getNode(predIdent)
			graph.addEdge(predNode, node)			
		]
	
	}//addEdges
	
		
	def private static Node getNode(DirectedWeightedMultigraph<Node, DefaultWeightedEdge> graph, String id){
		
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