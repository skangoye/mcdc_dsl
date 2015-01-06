package org.xtext.cfg;

import org.xtext.moduleDsl.STATEMENT;;

public class Node {
	
	protected String id ;
	protected STATEMENT statement ;
	
	public Node(String nodeId){
		id = nodeId ;
	}
	
	public String getId(){
		return id ;
	}
	
	public void setId(String newId){
		this.id = newId ;
	}
	
	@Override
	public String toString(){
		return id;
	}

}//class
