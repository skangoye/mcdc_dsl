package org.xtext.cfg;

import org.xtext.moduleDsl.EXPRESSION;

public class CondCfgNode extends Node {
	
	private EXPRESSION condExpression ;
	private boolean isLoop ;
	
	public CondCfgNode(String nodeId, EXPRESSION condition, boolean isLoop) {
		super(nodeId) ;
		this.condExpression = condition ;
		this.isLoop = isLoop ;
	}
	
	public EXPRESSION getCondExpression(){
		return condExpression ;
	}
	
	public boolean isLoop(){
		return isLoop ;
	}

}//class
