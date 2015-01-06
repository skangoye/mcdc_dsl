package org.xtext.cfg;

import java.util.List;

import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.ClassBasedEdgeFactory;
import org.jgrapht.graph.DirectedWeightedMultigraph;

public class TestGraph {

	public static void main(String[] args) {
		
		DirectedWeightedMultigraph<String, LabeledWeightedEdge> graph = 
				new DirectedWeightedMultigraph<String, LabeledWeightedEdge>((LabeledWeightedEdge.class));
	
		//vertices
//		Node n1 = new Node("n1") ;
//		Node n2 = new Node("n2") ;
//		Node n3 = new Node("n3") ;
//		Node n4 = new Node("n4") ;
		
		//Add vertices
		graph.addVertex("n1") ;
		graph.addVertex("n2") ;
		graph.addVertex("n3") ;
		graph.addVertex("n4") ;
		
		//Add edges to create linking structure
		LabeledWeightedEdge n12 = new LabeledWeightedEdge("n12") ;
		graph.addEdge("n1", "n2", n12 );
		graph.setEdgeWeight(n12, 23);
		
		LabeledWeightedEdge n13 = new LabeledWeightedEdge("n13") ;
		graph.addEdge("n1", "n3", n13) ;
		
		LabeledWeightedEdge n24 = new LabeledWeightedEdge("n24") ;
		graph.addEdge("n2", "n4", n24);
		
		LabeledWeightedEdge n41 = new LabeledWeightedEdge("n41") ;
		graph.addEdge("n4", "n1", n41);
		
		LabeledWeightedEdge n34 = new LabeledWeightedEdge("n34") ;
		graph.addEdge("n3", "n4", n34);
	
		System.out.println("Graph Representation: " + graph.toString()) ;
		System.out.println("Shortest path from n1 to n4:");
	    List<LabeledWeightedEdge> shortest_path =   DijkstraShortestPath.findPathBetween(graph, "n1", "n4");
	     
	     System.out.println(shortest_path);
	     
	     System.out.println("n12 weight: " + graph.getEdgeWeight(n12));
	     System.out.println("n13 weight: " + graph.getEdgeWeight(n13));
	     System.out.println("n24 weight: " + graph.getEdgeWeight(n24));
	     System.out.println("n41 weight: " + graph.getEdgeWeight(n41));
	}

}
