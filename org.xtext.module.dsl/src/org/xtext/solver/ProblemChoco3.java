package org.xtext.solver;

import java.util.List;

import org.chocosolver.solver.Solver;
import org.chocosolver.solver.constraints.IntConstraintFactory;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.variables.VariableFactory;
import org.jacop.constraints.XdivYeqZ;
import org.jacop.constraints.XmulYeqZ;
import org.jacop.constraints.XneqY;
import org.jacop.constraints.XplusYeqZ;
import org.jacop.floats.constraints.PdivQeqR;
import org.jacop.floats.constraints.PminusQeqR;
import org.jacop.floats.constraints.PmulQeqR;
import org.jacop.floats.constraints.PneqQ;
import org.jacop.floats.constraints.PplusQeqR;
import org.jacop.floats.core.FloatVar;

public class ProblemChoco3 {
	
	int MIN_INT = VariableFactory.MIN_INT_BOUND;
    int MAX_INT = VariableFactory.MAX_INT_BOUND;
    Solver solver;
    double precision = 0.00000000001;
    
	public ProblemChoco3() {
		solver = new Solver();
	}
	
	//set float precision
	public void setFloatPrecision(double precision){
		this.precision = precision;
	}
		
	//Int variable creation with interval
	public Object makeIntVar(String name, int min, int max) {
		return VariableFactory.bounded(name, min, max, solver);
	}
	
	//Int variable creation with enumeration
	public Object makeIntVar(String name, List<Integer> enumValues) {
		int size = enumValues.size();
		int[] myInts = new int[size];
		for (int i=0; i<size; i++){
			myInts[i] = enumValues.get(i); 
		}
		return VariableFactory.enumerated(name, myInts, solver);
	}
		
	//Real variable with max bounds
	public Object makeIntVar(String name) {
		return VariableFactory.bounded(name, MIN_INT, MAX_INT, solver);
	}
		
	//Int constant creation
	public Object makeIntConst(String name, int value) {
		return VariableFactory.fixed(name, value, solver);
	}
		
	//Real variable
	public Object makeRealVar(String name, double min, double max) {
		return VariableFactory.real(name, min, max, precision, solver);
	}	
			
	//Real variable with max bounds
	public Object makeRealVar(String name) {
		return VariableFactory.real(name, (double) MIN_INT, (double) MAX_INT, precision, solver);
	}
	
	//real constant creation
	public Object makeRealConst(String name, double value) {
		return VariableFactory.real(name, value, value, precision, solver);
	}
		
	//Boolean variable
	public Object makeBoolVar(String name) {
		return VariableFactory.bool(name, solver);
	}
	
	/***********************************************************************************************************************
	 * 
	 * 													Constraints
	 * 
	 ***********************************************************************************************************************/
	
	/**
	 * Plus
	 */
	
	public Object plus(Object exp1, Object exp2)  { 
		
		if(exp1 instanceof IntVar && exp2 instanceof IntVar){
			return IntConstraintFactory.arithm((IntVar) exp1, "+", (IntVar) exp2);
		}		
		
		if(exp1 instanceof FloatVar && exp2 instanceof FloatVar){
			throw new UnsupportedOperationException();
		}		
		
		throw new UnsupportedOperationException("## Unsupported mixed constraints ##"); 	
	}

	/**
	 * Minus
	 */
	
	public Object minus(Object exp1, Object exp2)  { 
		
		if(exp1 instanceof IntVar && exp2 instanceof IntVar){
			return IntConstraintFactory.arithm((IntVar) exp1, "-", (IntVar) exp2);
		}		
		
		if(exp1 instanceof FloatVar && exp2 instanceof FloatVar){
			throw new UnsupportedOperationException();
		}
		
		throw new UnsupportedOperationException("## Unsupported mixed constraints ##"); 	
	}
	
	
	/**
	 * Multiplication
	 */
	
	public Object mult(Object exp1, Object exp2)  { 
		
		if(exp1 instanceof IntVar && exp2 instanceof IntVar){
			return IntConstraintFactory.arithm((IntVar) exp1, "*", (IntVar) exp2);
		}		
		
		if(exp1 instanceof FloatVar && exp2 instanceof FloatVar){
			throw new UnsupportedOperationException();
		}	
		
		throw new UnsupportedOperationException("## Unsupported mixed constraints ##"); 	
	}

	
	/**
	 * Division
	 */
	
	public Object div(Object exp1, Object exp2)  { 
		
		if(exp1 instanceof IntVar && exp2 instanceof IntVar){
			return IntConstraintFactory.arithm((IntVar) exp1, "/", (IntVar) exp2);
		}		
		
		if(exp1 instanceof FloatVar && exp2 instanceof FloatVar){
			throw new UnsupportedOperationException();
		}
				
		throw new UnsupportedOperationException("## Unsupported mixed constraints ##"); 	
	}
	
	
	/**
	 *Equality
	 */

	public Object eq(Object exp1, Object exp2)  { 
		
		if(exp1 instanceof IntVar && exp2 instanceof IntVar){
			return IntConstraintFactory.arithm((IntVar) exp1, "=", (IntVar) exp2);
		}
		
		if(exp1 instanceof FloatVar && exp2 instanceof FloatVar){
			throw new UnsupportedOperationException();
		}
		
		throw new UnsupportedOperationException("## Unsupported mixed constraints ##"); 	
	}
	
	
	/**
	 * Not Equality
	 */

	public Object neq(Object exp1, Object exp2)  { 
		
		if(exp1 instanceof IntVar && exp2 instanceof IntVar){
			return IntConstraintFactory.arithm((IntVar) exp1, "!=", (IntVar) exp2);
		}
		
		if(exp1 instanceof FloatVar && exp2 instanceof FloatVar){
			throw new UnsupportedOperationException();
		}
		
		throw new UnsupportedOperationException("## Unsupported mixed constraints ##"); 	
	}

	
	/**
	 * lower or Equality
	 */
	public Object leq(Object exp1, Object exp2)  { 
		
		if(exp1 instanceof IntVar && exp2 instanceof IntVar){
			return IntConstraintFactory.arithm((IntVar) exp1, "<=", (IntVar) exp2);
		}
		
		if(exp1 instanceof FloatVar && exp2 instanceof FloatVar){
			throw new UnsupportedOperationException();
		}
		
		throw new UnsupportedOperationException("## Unsupported mixed constraints ##"); 	
	}

	
	/**
	 * Lower
	 */
	public Object lt(Object exp1, Object exp2)  { 
		
		if(exp1 instanceof IntVar && exp2 instanceof IntVar){
			return IntConstraintFactory.arithm((IntVar) exp1, "<", (IntVar) exp2);
		}
		
		if(exp1 instanceof FloatVar && exp2 instanceof FloatVar){
			throw new UnsupportedOperationException();
		}
		
		throw new UnsupportedOperationException("## Unsupported mixed constraints ##"); 	
	}
	
	
	/**
	 * Greater or Equality
	 */
	public Object geq(Object exp1, Object exp2)  { 
		
		if(exp1 instanceof IntVar && exp2 instanceof IntVar){
			return IntConstraintFactory.arithm((IntVar) exp1, ">=", (IntVar) exp2);
		}
		
		if(exp1 instanceof FloatVar && exp2 instanceof FloatVar){
			throw new UnsupportedOperationException();
		}
		
		throw new UnsupportedOperationException("## Unsupported mixed constraints ##"); 	
	}
	
	
	/**
	 * Greater
	 */
	public Object gt(Object exp1, Object exp2)  { 
		
		if(exp1 instanceof IntVar && exp2 instanceof IntVar){
			return IntConstraintFactory.arithm((IntVar) exp1, ">", (IntVar) exp2);
		}
		
		if(exp1 instanceof FloatVar && exp2 instanceof FloatVar){
			throw new UnsupportedOperationException();
		}
		
		throw new UnsupportedOperationException("## Unsupported mixed constraints ##"); 	
	}




}
