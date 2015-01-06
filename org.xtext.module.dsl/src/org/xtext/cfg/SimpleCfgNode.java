package org.xtext.cfg;

import org.xtext.moduleDsl.ASSIGN_STATEMENT;
import org.xtext.moduleDsl.EXPRESSION;
import org.xtext.moduleDsl.VAR_REF;

public class SimpleCfgNode extends Node{
	
	private ASSIGN_STATEMENT assignment ;
	private boolean isBooleanAssignment ;
	
	public SimpleCfgNode(String nodeId, ASSIGN_STATEMENT assignmentStmt, boolean isBoolAssign) {
		super(nodeId) ;
		this.assignment = assignmentStmt ;
		this.isBooleanAssignment = isBoolAssign ;
	}
	
	public ASSIGN_STATEMENT getAssignment(){
		return assignment ;
	}
	
	public EXPRESSION getAssignmentRightHand(){
		return assignment.getRight() ;
	}
	
	public VAR_REF getAssignmentLefttHand(){
		return assignment.getLeft() ;
	}
	
	public boolean isBooleanAssignment(){
		return isBooleanAssignment ;
	}

}//class

