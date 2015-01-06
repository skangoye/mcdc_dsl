package org.xtext.cfg;

import org.jgrapht.graph.DefaultWeightedEdge;

public class LabeledWeightedEdge extends DefaultWeightedEdge{

//	private V v1;
//   private V v2;
    private String label;
    
	public LabeledWeightedEdge(String label) {
//		 this.v1 = v1;
//       this.v2 = v2;
         this.label = label;
	}
	
//	public V getV1() {
//        return v1;
//    }

//    public V getV2() {
//        return v2;
//    }

    public String toString() {
        return label;
    }

}
