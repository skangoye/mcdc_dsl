package org.xtext.solver;

import choco.Choco;
import choco.cp.model.CPModel;
import choco.cp.solver.CPSolver;
import choco.kernel.model.Model;
import choco.kernel.model.constraints.Constraint;
import choco.kernel.model.variables.integer.IntegerExpressionVariable;
import choco.kernel.model.variables.integer.IntegerVariable;

/**
 * Integration of the Choco CP library version 2 (2.1.1, specifically).
 * Currently only supports integer operations.
 *
 * @author kangoye
 *
 */

public class ProblemChoco {
	
	private CPSolver solver;
	private Model model;
	public static int timeBound = 300;

	public ProblemChoco() {
		model = new CPModel();
		solver = new CPSolver();
	}

	//Division
	public Object div(int value, Object exp) { return Choco.div(value, (IntegerExpressionVariable) exp); }
	public Object div(Object exp, int value) { return Choco.div((IntegerExpressionVariable) exp, value); }
	public Object div(Object exp1, Object exp2) { return Choco.div((IntegerExpressionVariable) exp1, (IntegerExpressionVariable) exp2); }

	//Equality
	public Object eq(int value, Object exp) { return Choco.eq(value, (IntegerExpressionVariable) exp);	}
	public Object eq(Object exp, int value) { return Choco.eq((IntegerExpressionVariable) exp, value);	}
	public Object eq(Object exp1, Object exp2) { return Choco.eq((IntegerExpressionVariable) exp1, (IntegerExpressionVariable) exp2);	}
	
	//Greater than or equality
	public Object geq(int value, Object exp) { return Choco.geq(value, (IntegerExpressionVariable) exp);	}
	public Object geq(Object exp, int value) { return Choco.geq((IntegerExpressionVariable) exp, value);	}
	public Object geq(Object exp1, Object exp2) { return Choco.geq((IntegerExpressionVariable) exp1, (IntegerExpressionVariable) exp2);	}

	//get int variable value
	public int getIntValue(Object dpVar) {
		try {
			return solver.getVar((IntegerVariable) dpVar).getVal();
		} catch (Throwable t) {
			return ((IntegerVariable) dpVar).getLowB();
		}
	}
	
	//Greater than
	public Object gt(int value, Object exp) { return Choco.gt(value, (IntegerExpressionVariable) exp); }
	public Object gt(Object exp, int value) { return Choco.gt((IntegerExpressionVariable) exp, value); }
	public Object gt(Object exp1, Object exp2) { return Choco.gt((IntegerExpressionVariable) exp1, (IntegerExpressionVariable) exp2); }
	
	//Lower than, or equality
	public Object leq(int value, Object exp) { return Choco.leq(value, (IntegerExpressionVariable) exp); }
	public Object leq(Object exp, int value) { return Choco.leq((IntegerExpressionVariable) exp, value); }
	public Object leq(Object exp1, Object exp2) { return Choco.leq((IntegerExpressionVariable) exp1, (IntegerExpressionVariable) exp2); }
	
	//Lower than
	public Object lt(int value, Object exp) { return Choco.lt(value, (IntegerExpressionVariable) exp); }
	public Object lt(Object exp, int value) { return Choco.lt((IntegerExpressionVariable) exp, value); }
	public Object lt(Object exp1, Object exp2) { return Choco.lt((IntegerExpressionVariable) exp1, (IntegerExpressionVariable) exp2); }
	
	//Int variable creation
	public Object makeIntVar(String name, int min, int max) {
		return Choco.makeIntVar(name, min, max);
	}
	
	//constant variables
	public Object makeIntConst(int value) {
		return Choco.constant(value);
	}

	//Minus
	public Object minus(int value, Object exp) { return Choco.minus(value, (IntegerExpressionVariable) exp); }
	public Object minus(Object exp, int value) { return Choco.minus((IntegerExpressionVariable) exp, value); }
	public Object minus(Object exp1, Object exp2)  { return Choco.minus((IntegerExpressionVariable) exp1, (IntegerExpressionVariable) exp2); }

	//Multiplication
	public Object mult(int value, Object exp) { return Choco.mult(value, (IntegerExpressionVariable) exp); }
	public Object mult(Object exp, int value) { return Choco.mult((IntegerExpressionVariable) exp, value); }
	public Object mult(Object exp1, Object exp2)  { return Choco.mult((IntegerExpressionVariable) exp1, (IntegerExpressionVariable) exp2); }
	
	//Not equals
	public Object neq(int value, Object exp) { return Choco.neq(value, (IntegerExpressionVariable) exp); }
	public Object neq(Object exp, int value) { return Choco.neq((IntegerExpressionVariable) exp, value); }
	public Object neq(Object exp1, Object exp2)  { return Choco.neq((IntegerExpressionVariable) exp1, (IntegerExpressionVariable) exp2); }

	//Plus
	public Object plus(int value, Object exp) { return Choco.plus(value, (IntegerExpressionVariable) exp); }
	public Object plus(Object exp, int value) { return Choco.plus((IntegerExpressionVariable) exp, value); }
	public Object plus(Object exp1, Object exp2)  { return Choco.plus((IntegerExpressionVariable) exp1, (IntegerExpressionVariable) exp2); }

	//Add constraints
	public void addConstraint(Object constraint) {
		model.addConstraint((Constraint) constraint);
	}

	/*
	 * One potential issue is determining the best way to build constraints.
	 * Currently the model is reset after solving, and the solver
	 * is reset right before solving. Is this the best way to do this?
	 * We could alternatively pop constraints when backtracking,
	 * though this would require some changes to how ProblemGeneral
	 * is interfaced.
	 *
	 */
	
	//Solve
	public Boolean solve() {
		solver.read(model);

		//System.out.println("Model:" + model.constraintsToString());

		solver.setTimeLimit(timeBound);
		Boolean solved = solver.solve();
		//boolean feasible = solver.isFeasible();

		//System.out.println("Solved: " + solved);
		//System.out.println("Feasible: " + feasible);

		return solved;
	}

}

