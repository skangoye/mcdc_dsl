package org.xtext.cfg;

import java.util.List;

import org.xtext.helper.Triplet;
import org.xtext.moduleDsl.STATEMENT;

public class CondCfgNode extends Node {
	
	private STATEMENT statement ; //Assignment or Variable declaration
	private Triplet<List<String>, List<String>, List<String>> trueTriplet ;
	private Triplet<List<String>, List<String>, List<String>> falseTriplet ;
	
	public CondCfgNode(String nodeId, 
						STATEMENT statement,
						Triplet<List<String>, List<String>, List<String>> trueTriplet, 
						Triplet<List<String>, List<String>, List<String>> falseTriplet) 
	{
		super(nodeId) ;
		this.statement = statement ;
		this.trueTriplet = trueTriplet ;
		this.falseTriplet = falseTriplet ;
	}
	
	public STATEMENT getStatement(){
		return this.statement ;
	}
	
	public Triplet<List<String>, List<String>, List<String>> getTrueTriplet(){
		return this.trueTriplet ;
	}
	
	public Triplet<List<String>, List<String>, List<String>> getFalseTriplet(){
		return this.falseTriplet ;
	}

}//class
