package org.xtext.cfg;

import java.util.List;

import org.xtext.helper.Triplet;
import org.xtext.moduleDsl.STATEMENT;

public class SimpleCfgNode extends Node{
	
	private STATEMENT statement ; //Assignment or Variable declaration
	private Triplet<List<String>, List<String>, List<String>> triplet ;
	
	public SimpleCfgNode(String nodeId, STATEMENT statement, Triplet<List<String>, List<String>, List<String>> triplet) {
		super(nodeId) ;
		this.statement = statement ;
		this.triplet = triplet ;
	}
	
	public STATEMENT getStatement(){
		return this.statement ;
	}
	
	public Triplet<List<String>, List<String>, List<String>> getTriplet(){
		return this.triplet ;
	}
	
}//class

