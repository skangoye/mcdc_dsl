package org.xtext.solver;

import java.util.ArrayList;
import java.util.List;

import org.jacop.constraints.And;
import org.jacop.constraints.Or;
import org.jacop.constraints.PrimitiveConstraint;
import org.jacop.constraints.XdivYeqZ;
import org.jacop.constraints.XeqY;
import org.jacop.constraints.XgtY;
import org.jacop.constraints.XgteqY;
import org.jacop.constraints.XltY;
import org.jacop.constraints.XlteqY;
import org.jacop.constraints.XmodYeqZ;
import org.jacop.constraints.XmulYeqZ;
import org.jacop.constraints.XneqY;
import org.jacop.constraints.XplusYeqZ;
import org.jacop.core.BooleanVar;
import org.jacop.core.IntVar;
import org.jacop.core.Store;
import org.jacop.floats.constraints.AcosPeqR;
import org.jacop.floats.constraints.AsinPeqR;
import org.jacop.floats.constraints.AtanPeqR;
import org.jacop.floats.constraints.CosPeqR;
import org.jacop.floats.constraints.ExpPeqR;
import org.jacop.floats.constraints.LnPeqR;
import org.jacop.floats.constraints.PdivQeqR;
import org.jacop.floats.constraints.PeqQ;
import org.jacop.floats.constraints.PgtQ;
import org.jacop.floats.constraints.PgteqQ;
import org.jacop.floats.constraints.PltQ;
import org.jacop.floats.constraints.PlteqQ;
import org.jacop.floats.constraints.PminusQeqR;
import org.jacop.floats.constraints.PmulQeqR;
import org.jacop.floats.constraints.PneqQ;
import org.jacop.floats.constraints.PplusQeqR;
import org.jacop.floats.constraints.SinPeqR;
import org.jacop.floats.constraints.SqrtPeqR;
import org.jacop.floats.constraints.TanPeqR;
import org.jacop.floats.core.FloatDomain;
import org.jacop.floats.core.FloatVar;
import org.jacop.floats.search.SmallestDomainFloat;
import org.jacop.floats.search.SplitSelectFloat;
import org.jacop.search.DepthFirstSearch;
import org.jacop.search.IndomainMedian;
import org.jacop.search.PrintOutListener;
import org.jacop.search.SelectChoicePoint;
import org.jacop.search.SimpleSelect;
import org.jacop.search.SmallestDomain;


public class ProblemJacop {
	
	private Store store;
	double MIN_FLOAT = -1e+6;
    double MAX_FLOAT =  1e+6;
    int MIN_INT = (int) -1e+6;
    int MAX_INT = (int)  1e+6;
	public static int timeBound = 300;

	public ProblemJacop() {
		store = new Store();
	}
	
	//set float precision
	public void setFloatPrecision(double precision){
		FloatDomain.setPrecision(precision);
	}
	
	//Print interval
	public void intervalPrint(boolean printInterval){
		FloatDomain.intervalPrint(printInterval);
	}
	
	//Int variable creation
	public Object makeIntVar(String name, int min, int max) {
		return new IntVar(store, name, min, max);
	}
	
	//Real variable with max bounds
	public Object makeIntVar(String name) {
		return new IntVar(store, name, MIN_INT, MAX_INT);
	}
		
	//Int constant creation
	public Object makeIntConst(String name, int value) {
		return new IntVar(store, name, value, value);
	}
		
	//Real variable
	public Object makeRealVar(String name, double min, double max) {
		return new FloatVar(store, name, min, max);
	}	
	
	//Int constant creation
	public Object makeRealConst(String name, double value) {
		return new FloatVar(store, name, value, value);
	}
		
	//Real variable with max bounds
	public Object makeRealVar(String name) {
		return new FloatVar(store, name, MIN_FLOAT, MAX_FLOAT);
	}
	
	//Boolean variable
	public Object makeBoolVar(String name) {
		return new BooleanVar(store, name);
	}
	
	/***********************************************************************************************************************
	 * 
	 * 													Constraints
	 * 
	 ***********************************************************************************************************************/
	
	/**
	 * Plus
	 */
	
	public Object plus(int value, Object exp) { 
		IntVar result = (IntVar) this.makeIntVar("result");
		IntVar constant = (IntVar) this.makeIntConst("const", value);
		store.impose(new XplusYeqZ( constant, (IntVar)exp, result) );
		return result;
	}
	
	public Object plus(Object exp, int value) { 
		IntVar result = (IntVar) this.makeIntVar("result");
		IntVar constant = (IntVar) this.makeIntConst("const", value);
		store.impose(new XplusYeqZ( (IntVar)exp, constant, result) );
		return result;
	}
	
	public Object plus(double value, Object exp) { 
		FloatVar result = (FloatVar) this.makeRealVar("result");
		FloatVar constant = (FloatVar) this.makeRealConst("const", value);
		store.impose(new PplusQeqR( constant, (FloatVar)exp, result) );
		return result;
	}
	
	public Object plus(Object exp, double value) { 
		FloatVar result = (FloatVar) this.makeRealVar("result");
		FloatVar constant = (FloatVar) this.makeRealConst("const", value);
		store.impose(new PplusQeqR( (FloatVar)exp, constant, result) );
		return result;
	}
	
	public Object plus(Object exp1, Object exp2)  { 
		if(exp1 instanceof IntVar && exp2 instanceof IntVar){
			IntVar result = (IntVar) this.makeIntVar("result");
			store.impose(new XplusYeqZ( (IntVar)exp1, (IntVar)exp2, result) );
			return result;
		}		
		if(exp1 instanceof FloatVar && exp2 instanceof FloatVar){
			FloatVar result = (FloatVar) this.makeRealVar("result");
			store.impose(new PplusQeqR( (FloatVar)exp1, (FloatVar)exp2, result) );
			return result;
		}		
		if(exp1 instanceof IntVar && exp2 instanceof Integer){
			return this.plus(exp1, ((Integer)exp2).intValue()) ;
		}
		if(exp1 instanceof Integer && exp2 instanceof IntVar){
			return this.plus(((Integer)exp1).intValue(), exp2) ;
		}
		if(exp1 instanceof FloatVar && exp2 instanceof Double){
			return this.plus( exp1, ((Double)exp2).doubleValue());
		}
		if(exp1 instanceof Double && exp2 instanceof FloatVar){
			return this.plus(((Double)exp1).doubleValue(), exp2 );
		}
		
		throw new UnsupportedOperationException("## Unsupported mixed constraints ##"); 	
	}
	
	
	/**
	 * Minus
	 */
	
	public Object minus(int value, Object exp) { 
		IntVar result = (IntVar) this.makeIntVar("result");
		IntVar constant = (IntVar) this.makeIntConst("const", value);
		store.impose(new XplusYeqZ( result, (IntVar)exp, constant) );
		return result;
	}
	
	public Object minus(Object exp, int value) { 
		IntVar result = (IntVar) this.makeIntVar("result");
		IntVar constant = (IntVar) this.makeIntConst("const", value);
		store.impose(new XplusYeqZ( result, constant, (IntVar)exp) );
		return result;
	}
	
	public Object minus(double value, Object exp) { 
		FloatVar result = (FloatVar) this.makeRealVar("result");
		FloatVar constant = (FloatVar) this.makeRealConst("const", value);
		store.impose(new PminusQeqR( constant, (FloatVar)exp, result) );
		return result;
	}
	
	public Object minus(Object exp, double value) { 
		FloatVar result = (FloatVar) this.makeRealVar("result");
		FloatVar constant = (FloatVar) this.makeRealConst("const", value);
		store.impose(new PminusQeqR( (FloatVar)exp,  constant, result) );
		return result;
	}
	
	public Object minus(Object exp1, Object exp2)  { 
		if(exp1 instanceof IntVar && exp2 instanceof IntVar){
			IntVar result = (IntVar) this.makeIntVar("result");
			store.impose(new XplusYeqZ( result, (IntVar)exp2, (IntVar)exp1) );
			return result;
		}		
		if(exp1 instanceof FloatVar && exp2 instanceof FloatVar){
			FloatVar result = (FloatVar) this.makeRealVar("result");
			store.impose(new PminusQeqR( (FloatVar)exp1, (FloatVar)exp2, result) );
			return result;
		}
		if(exp1 instanceof IntVar && exp2 instanceof Integer){
			return this.minus(exp1, ((Integer)exp2).intValue()) ;
		}
		if(exp1 instanceof Integer && exp2 instanceof IntVar){
			return this.minus(((Integer)exp1).intValue(), exp2) ;
		}
		if(exp1 instanceof FloatVar && exp2 instanceof Double){
			return this.minus( exp1, ((Double)exp2).doubleValue());
		}
		if(exp1 instanceof Double && exp2 instanceof FloatVar){
			return this.minus(((Double)exp1).doubleValue(), exp2 );
		}
		
		throw new UnsupportedOperationException("## Unsupported mixed constraints ##"); 	
	}
	
	
	/**
	 * Multiplication
	 */
	
	public Object mult(int value, Object exp) { 
		IntVar result = (IntVar) this.makeIntVar("result");
		IntVar constant = (IntVar) this.makeIntConst("const", value);
		store.impose(new XmulYeqZ( constant, (IntVar)exp, result) );
		return result;
	}
	
	public Object mult(Object exp, int value) { 
		IntVar result = (IntVar) this.makeIntVar("result");
		IntVar constant = (IntVar) this.makeIntConst("const", value);
		store.impose(new XmulYeqZ( (IntVar)exp, constant, result) );
		return result;
	}
	
	public Object mult(double value, Object exp) { 
		FloatVar result = (FloatVar) this.makeRealVar("result");
		FloatVar constant = (FloatVar) this.makeRealConst("const", value);
		store.impose(new PmulQeqR( constant, (FloatVar)exp, result) );
		return result;
	}
	
	public Object mult(Object exp, double value) { 
		FloatVar result = (FloatVar) this.makeRealVar("result");
		FloatVar constant = (FloatVar) this.makeRealConst("const", value);
		store.impose(new PmulQeqR( (FloatVar)exp, constant, result) );
		return result;
	}
	
	public Object mult(Object exp1, Object exp2)  { 
		if(exp1 instanceof IntVar && exp2 instanceof IntVar){
			IntVar result = (IntVar) this.makeIntVar("result");
			store.impose(new XmulYeqZ( (IntVar)exp1, (IntVar)exp2, result) );
			return result;
		}		
		if(exp1 instanceof FloatVar && exp2 instanceof FloatVar){
			FloatVar result = (FloatVar) this.makeRealVar("result");
			store.impose(new PmulQeqR( (FloatVar)exp1, (FloatVar)exp2, result) );
			return result;
		}	
		if(exp1 instanceof IntVar && exp2 instanceof Integer){
			return this.mult(exp1, ((Integer)exp2).intValue()) ;
		}
		if(exp1 instanceof Integer && exp2 instanceof IntVar){
			return this.mult(((Integer)exp1).intValue(), exp2) ;
		}
		if(exp1 instanceof FloatVar && exp2 instanceof Double){
			return this.mult( exp1, ((Double)exp2).doubleValue());
		}
		if(exp1 instanceof Double && exp2 instanceof FloatVar){
			return this.mult(((Double)exp1).doubleValue(), exp2 );
		}
		
		throw new UnsupportedOperationException("## Unsupported mixed constraints ##"); 	
	}
	
	
	/**
	 * Division
	 */
	
	public Object div(int value, Object exp) { 
		IntVar result = (IntVar) this.makeIntVar("result");
		IntVar constant = (IntVar) this.makeIntConst("const", value);
		store.impose(new XdivYeqZ( constant, (IntVar)exp, result) );
		return result;
	}
	
	public Object div(Object exp, int value) { 
		IntVar result = (IntVar) this.makeIntVar("result");
		IntVar constant = (IntVar) this.makeIntConst("const", value);
		store.impose(new XdivYeqZ( (IntVar)exp, constant, result) );
		return result;
	}
	
	public Object div(double value, Object exp) { 
		FloatVar result = (FloatVar) this.makeRealVar("result");
		FloatVar constant = (FloatVar) this.makeRealConst("const", value);
		store.impose(new PdivQeqR( constant, (FloatVar)exp, result) );
		return result;
	}
	
	public Object div(Object exp, double value) { 
		FloatVar result = (FloatVar) this.makeRealVar("result");
		FloatVar constant = (FloatVar) this.makeRealConst("const", value);
		store.impose(new PdivQeqR( (FloatVar)exp, constant, result) );
		return result;
	}
	
	public Object div(Object exp1, Object exp2)  { 
		if(exp1 instanceof IntVar && exp2 instanceof IntVar){
			IntVar result = (IntVar) this.makeIntVar("result");
			store.impose(new XdivYeqZ( (IntVar)exp1, (IntVar)exp2, result) );
			return result;
		}		
		if(exp1 instanceof FloatVar && exp2 instanceof FloatVar){
			FloatVar result = (FloatVar) this.makeRealVar("result");
			store.impose(new PdivQeqR( (FloatVar)exp1, (FloatVar)exp2, result) );
			return result;
		}
		if(exp1 instanceof IntVar && exp2 instanceof Integer){
			return this.div(exp1, ((Integer)exp2).intValue()) ;
		}
		if(exp1 instanceof Integer && exp2 instanceof IntVar){
			return this.div(((Integer)exp1).intValue(), exp2) ;
		}
		if(exp1 instanceof FloatVar && exp2 instanceof Double){
			return this.div( exp1, ((Double)exp2).doubleValue());
		}
		if(exp1 instanceof Double && exp2 instanceof FloatVar){
			return this.div(((Double)exp1).doubleValue(), exp2 );
		}
		
		throw new UnsupportedOperationException("## Unsupported mixed constraints ##"); 	
	}
	

	/**
	 * Equality
	 */
	
	public Object eq(int value, Object exp) { 
		IntVar constant = (IntVar) this.makeIntConst("const", value);
		return new XeqY( constant, (IntVar)exp ) ;
	}
	
	public Object eq(Object exp, int value) { 
		IntVar constant = (IntVar) this.makeIntConst("const", value);
		return new XeqY( (IntVar)exp, constant ) ;
	}
	
	public Object eq(double value, Object exp) { 
		FloatVar constant = (FloatVar) this.makeRealConst("const", value);
		return new PeqQ( constant, (FloatVar)exp );
	}
	
	public Object eq(Object exp, double value) { 
		FloatVar constant = (FloatVar) this.makeRealConst("const", value);
		return new PeqQ( (FloatVar)exp, constant );
	}
	
	public Object eq(Object exp1, Object exp2)  { 
		
		if(exp1 instanceof IntVar && exp2 instanceof IntVar){
			return new XeqY( (IntVar)exp1, (IntVar)exp2 ) ;
		}
		if(exp1 instanceof FloatVar && exp2 instanceof FloatVar){
			return new PeqQ( (FloatVar)exp1, (FloatVar)exp2 );
		}
		if(exp1 instanceof IntVar && exp2 instanceof Integer){
			return this.eq(exp1, ((Integer)exp2).intValue()) ;
		}
		if(exp1 instanceof Integer && exp2 instanceof IntVar){
			return this.eq(((Integer)exp1).intValue(), exp2) ;
		}
		if(exp1 instanceof FloatVar && exp2 instanceof Double){
			return this.eq( exp1, ((Double)exp2).doubleValue());
		}
		if(exp1 instanceof Double && exp2 instanceof FloatVar){
			return this.eq(((Double)exp1).doubleValue(), exp2 );
		}
		
		throw new UnsupportedOperationException("## Unsupported mixed constraints ##" + " exp1: " + exp1.toString()
				+ " exp2 " + exp2.toString()); 	
	}
	
	
	/**
	 * Not Equality
	 */
	
	public Object neq(int value, Object exp) { 
		IntVar constant = (IntVar) this.makeIntConst("const", value);
		return new XneqY( constant, (IntVar)exp ) ;
	}
	
	public Object neq(Object exp, int value) { 
		IntVar constant = (IntVar) this.makeIntConst("const", value);
		return new XneqY( (IntVar)exp, constant ) ;
	}
	
	public Object neq(double value, Object exp) { 
		FloatVar constant = (FloatVar) this.makeRealConst("const", value);
		return new PneqQ( constant, (FloatVar)exp );
	}
	
	public Object neq(Object exp, double value) { 
		FloatVar constant = (FloatVar) this.makeRealConst("const", value);
		return new PneqQ( (FloatVar)exp, constant );
	}
	
	public Object neq(Object exp1, Object exp2)  { 
		if(exp1 instanceof IntVar && exp2 instanceof IntVar){
			return new XneqY( (IntVar)exp1, (IntVar)exp2 ) ;
		}
		if(exp1 instanceof FloatVar && exp2 instanceof FloatVar){
			return new PneqQ( (FloatVar)exp1, (FloatVar)exp2 );
		}
		if(exp1 instanceof IntVar && exp2 instanceof Integer){
			return this.neq(exp1, ((Integer)exp2).intValue()) ;
		}
		if(exp1 instanceof Integer && exp2 instanceof IntVar){
			return this.neq(((Integer)exp1).intValue(), exp2) ;
		}
		if(exp1 instanceof FloatVar && exp2 instanceof Double){
			return this.neq( exp1, ((Double)exp2).doubleValue());
		}
		if(exp1 instanceof Double && exp2 instanceof FloatVar){
			return this.neq(((Double)exp1).doubleValue(), exp2 );
		}
		throw new UnsupportedOperationException("## Unsupported mixed constraints ##"); 	
	}
	
	
	/**
	 * Greater or Equality
	 */
	
	public Object geq(int value, Object exp) { 
		IntVar constant = (IntVar) this.makeIntConst("const", value);
		return new XgteqY( constant, (IntVar)exp ) ;
	}
	
	public Object geq(Object exp, int value) { 
		IntVar constant = (IntVar) this.makeIntConst("const", value);
		return new XgteqY( (IntVar)exp, constant ) ;
	}
	
	public Object geq(double value, Object exp) { 
		FloatVar constant = (FloatVar) this.makeRealConst("const", value);
		return new PgteqQ( constant, (FloatVar)exp );
	}
	
	public Object geq(Object exp, double value) { 
		FloatVar constant = (FloatVar) this.makeRealConst("const", value);
		return new PgteqQ( (FloatVar)exp, constant );
	}
	
	public Object geq(Object exp1, Object exp2)  { 
		if(exp1 instanceof IntVar && exp2 instanceof IntVar){
			return new XgteqY( (IntVar)exp1, (IntVar)exp2 ) ;
		}		
		if(exp1 instanceof FloatVar && exp2 instanceof FloatVar){
			return new PgteqQ( (FloatVar)exp1, (FloatVar)exp2 );
		}	
		if(exp1 instanceof IntVar && exp2 instanceof Integer){
			return this.geq(exp1, ((Integer)exp2).intValue()) ;
		}
		if(exp1 instanceof Integer && exp2 instanceof IntVar){
			return this.geq(((Integer)exp1).intValue(), exp2) ;
		}
		if(exp1 instanceof FloatVar && exp2 instanceof Double){
			return this.geq( exp1, ((Double)exp2).doubleValue());
		}
		if(exp1 instanceof Double && exp2 instanceof FloatVar){
			return this.geq(((Double)exp1).doubleValue(), exp2 );
		}
		
		throw new UnsupportedOperationException("## Unsupported mixed constraints ##"); 	
	}

	
	/**
	 * lower or Equality
	 */
	
	public Object leq(int value, Object exp) { 
		IntVar constant = (IntVar) this.makeIntConst("const", value);
		return new XlteqY( constant, (IntVar)exp ) ;
	}
	
	public Object leq(Object exp, int value) { 
		IntVar constant = (IntVar) this.makeIntConst("const", value);
		return new XlteqY( (IntVar)exp, constant ) ;
	}
	
	public Object leq(double value, Object exp) { 
		FloatVar constant = (FloatVar) this.makeRealConst("const", value);
		return new PlteqQ( constant, (FloatVar)exp );
	}
	
	public Object leq(Object exp, double value) { 
		FloatVar constant = (FloatVar) this.makeRealConst("const", value);
		return new PlteqQ( (FloatVar)exp, constant );
	}
	
	public Object leq(Object exp1, Object exp2)  { 
		if(exp1 instanceof IntVar && exp2 instanceof IntVar){
			return new XlteqY( (IntVar)exp1, (IntVar)exp2 ) ;
		}		
		if(exp1 instanceof FloatVar && exp2 instanceof FloatVar){
			return new PlteqQ( (FloatVar)exp1, (FloatVar)exp2 );
		}
		if(exp1 instanceof IntVar && exp2 instanceof Integer){
			return this.leq(exp1, ((Integer)exp2).intValue()) ;
		}
		if(exp1 instanceof Integer && exp2 instanceof IntVar){
			return this.leq(((Integer)exp1).intValue(), exp2) ;
		}
		if(exp1 instanceof FloatVar && exp2 instanceof Double){
			return this.leq( exp1, ((Double)exp2).doubleValue());
		}
		if(exp1 instanceof Double && exp2 instanceof FloatVar){
			return this.leq(((Double)exp1).doubleValue(), exp2 );
		}
		throw new UnsupportedOperationException("## Unsupported mixed constraints ##"); 	
	}
	
	
	/**
	 * Greater
	 */
	
	public Object gt(int value, Object exp) { 
		IntVar constant = (IntVar) this.makeIntConst("const", value);
		return new XgtY( constant, (IntVar)exp ) ;
	}
	
	public Object gt(Object exp, int value) { 
		IntVar constant = (IntVar) this.makeIntConst("const", value);
		return new XgtY( (IntVar)exp, constant ) ;
	}
	
	public Object gt(double value, Object exp) { 
		FloatVar constant = (FloatVar) this.makeRealConst("const", value);
		return new PgtQ( constant, (FloatVar)exp );
	}
	
	public Object gt(Object exp, double value) { 
		FloatVar constant = (FloatVar) this.makeRealConst("const", value);
		return new PgtQ( (FloatVar)exp, constant );
	}
	
	public Object gt(Object exp1, Object exp2)  { 
		if(exp1 instanceof IntVar && exp2 instanceof IntVar){
			return new XgtY( (IntVar)exp1, (IntVar)exp2 ) ;
		}		
		if(exp1 instanceof FloatVar && exp2 instanceof FloatVar){
			return new PgtQ( (FloatVar)exp1, (FloatVar)exp2 );
		}
		if(exp1 instanceof IntVar && exp2 instanceof Integer){
			return this.gt(exp1, ((Integer)exp2).intValue()) ;
		}
		if(exp1 instanceof Integer && exp2 instanceof IntVar){
			return this.gt(((Integer)exp1).intValue(), exp2) ;
		}
		if(exp1 instanceof FloatVar && exp2 instanceof Double){
			return this.gt( exp1, ((Double)exp2).doubleValue());
		}
		if(exp1 instanceof Double && exp2 instanceof FloatVar){
			return this.gt(((Double)exp1).doubleValue(), exp2 );
		}
		
		throw new UnsupportedOperationException("## Unsupported mixed constraints ##"); 	
	}
	
	
	/**
	 * Lower
	 */
	
	public Object lt(int value, Object exp) { 
		IntVar constant = (IntVar) this.makeIntConst("const", value);
		return new XltY( constant, (IntVar)exp ) ;
	}
	
	public Object lt(Object exp, int value) { 
		IntVar constant = (IntVar) this.makeIntConst("const", value);
		return new XltY( (IntVar)exp, constant ) ;
	}
	
	public Object lt(double value, Object exp) { 
		FloatVar constant = (FloatVar) this.makeRealConst("const", value);
		return new PltQ( constant, (FloatVar)exp );
	}
	
	public Object lt(Object exp, double value) { 
		FloatVar constant = (FloatVar) this.makeRealConst("const", value);
		return new PltQ( (FloatVar)exp, constant );
	}
	
	public Object lt(Object exp1, Object exp2)  { 
		if(exp1 instanceof IntVar && exp2 instanceof IntVar){
			return new XltY( (IntVar)exp1, (IntVar)exp2 ) ;
		}		
		if(exp1 instanceof FloatVar && exp2 instanceof FloatVar){
			return new PltQ( (FloatVar)exp1, (FloatVar)exp2 );
		}
		if(exp1 instanceof IntVar && exp2 instanceof Integer){
			return this.lt(exp1, ((Integer)exp2).intValue()) ;
		}
		if(exp1 instanceof Integer && exp2 instanceof IntVar){
			return this.lt(((Integer)exp1).intValue(), exp2) ;
		}
		if(exp1 instanceof FloatVar && exp2 instanceof Double){
			return this.lt( exp1, ((Double)exp2).doubleValue());
		}
		if(exp1 instanceof Double && exp2 instanceof FloatVar){
			return this.lt(((Double)exp1).doubleValue(), exp2 );
		}
		
		throw new UnsupportedOperationException("## Unsupported mixed constraints ##"); 	
	}
	
	/**
	 * Modulo
	 */
	public Object mod(Object exp, int value){
		IntVar result = (IntVar) this.makeIntVar("result");
		IntVar constant = (IntVar) this.makeIntConst("const", value);
		store.impose(new XmodYeqZ((IntVar)exp, constant, result));
		return result;
	}
	
	public Object mod(Object exp1, Object exp2){
		if(exp1 instanceof IntVar && exp2 instanceof IntVar){
			IntVar result = (IntVar) this.makeIntVar("result");
			store.impose(new XmodYeqZ((IntVar)exp1, (IntVar)exp2, result));
			return result;
		}
		if(exp1 instanceof IntVar && exp2 instanceof Integer){
			return this.mod(exp1, ((Integer)exp2).intValue());
		}
		throw new UnsupportedOperationException("## Unsupported ##"); 
	}
	
	/**
	 * Logical And
	 */
	
	public Object and(Object ctr1, Object ctr2)  { 
		if(ctr1 instanceof PrimitiveConstraint && ctr2 instanceof PrimitiveConstraint){
			return new And((PrimitiveConstraint)ctr1, (PrimitiveConstraint)ctr2);
		}
		
		throw new UnsupportedOperationException("## Unsupported mixed constraints ##"); 	
	}
	
	
	/**
	 * Logical Or
	 */
	
	public Object or(Object ctr1, Object ctr2)  { 
		if(ctr1 instanceof PrimitiveConstraint && ctr2 instanceof PrimitiveConstraint){
			return new Or((PrimitiveConstraint)ctr1, (PrimitiveConstraint)ctr2);
		}
		
		throw new UnsupportedOperationException("## Unsupported mixed constraints ##"); 	
	}
	
	
	/**
	 * Sinus
	 */
	
	public Object sin(Object exp) {
		FloatVar result = (FloatVar) this.makeRealVar("result");
		store.impose(new SinPeqR( (FloatVar)exp, result) );
		return result;
	}

	
	/**
	 * Cosinus
	 */
	
	public Object cos(Object exp) {
		FloatVar result = (FloatVar) this.makeRealVar("result");
		store.impose(new CosPeqR( (FloatVar)exp, result) );
		return result;
	}
	
	
	/**
	 * tangent
	 */
	
	public Object tan(Object exp) {
		FloatVar result = (FloatVar) this.makeRealVar("result");
		store.impose(new TanPeqR( (FloatVar)exp, result) );
		return result;
	}
	
	
	/**
	 * Arc sinus
	 */
	
	public Object asin(Object exp) {
		FloatVar result = (FloatVar) this.makeRealVar("result");
		store.impose(new AsinPeqR( (FloatVar)exp, result) );
		return result;
	}

	
	/**
	 * Arc cosinus
	 */
	
	public Object acos(Object exp) {
		FloatVar result = (FloatVar) this.makeRealVar("result");
	store.impose(new AcosPeqR( (FloatVar)exp, result) );
		return result;
	}
	
	
	/**
	 * Arc tangent
	 */
	
	public Object atan(Object exp) {
		FloatVar result = (FloatVar) this.makeRealVar("result");
		store.impose(new AtanPeqR( (FloatVar)exp, result) );
		return result;
	}
	
		
	/**
	 * Exponent
	 */
	
	public Object exp(Object exp) {
		FloatVar result = (FloatVar) this.makeRealVar("result");
		store.impose(new ExpPeqR( (FloatVar)exp, result) );
		return result;
	}
	
	/**
	 * Neperian Logarithm
	 */
	
	public Object log(Object exp) {
		FloatVar result = (FloatVar) this.makeRealVar("result");
		store.impose(new LnPeqR( (FloatVar)exp, result) );
		return result;
	}

	
	/**
	 * Square root
	 */
	
	public Object sqrt(Object exp) {
		FloatVar result = (FloatVar) this.makeRealVar("result");
		store.impose(new SqrtPeqR( (FloatVar)exp, result) );
		return result;
	}
	
	
	/**
	 * Round
	 */
	
	public Object round(Object exp) {
		throw new UnsupportedOperationException("## Unsupported constraint ##");
	}
	
	
	//Add constraints
	public void post(Object constraint) {
		store.impose((PrimitiveConstraint) constraint); 
	}

	//Print constraints
	public void printConstraint(Object constraint) {
		System.out.println(((PrimitiveConstraint) constraint).toString()); 
	}
		
	//Solve
	public boolean solve(List<Object> vars){
		
		List<IntVar> intVars = new ArrayList<IntVar>();
		List<FloatVar> floatVars = new ArrayList<FloatVar>();
		
		if(! store.consistency() ){ return false; }
		
		boolean result1 = false;
		boolean result2 = false;
		
		for(int i=0; i<vars.size(); i++){
			Object var = vars.get(i);
			if( var instanceof IntVar ){
				intVars.add((IntVar) var);
			}
			else{
				if( var instanceof FloatVar ){
					floatVars.add((FloatVar) var);
				}
			}
		}
		
		if(intVars.size() > 0) { result1 = solveInt(intVars); }
		if(floatVars.size() > 0) { result2 = solveReal(floatVars);}
	
		return (result1 || result2);
	}
		
	public boolean solveInt(List<IntVar> vars) {
		
		int size = vars.size();
		IntVar[] intVars = new IntVar[size];
		
		for(int i=0; i<size; i++){
			intVars[i] = vars.get(i);
		}
		
		DepthFirstSearch<IntVar> intSearch = new DepthFirstSearch<IntVar>();
		SelectChoicePoint<IntVar> intSelect = new SimpleSelect<IntVar>(intVars, new SmallestDomain<IntVar>(), new IndomainMedian<IntVar>()) ;
	
		intSearch.getSolutionListener().recordSolutions(true);
		boolean result = intSearch.labeling(store, intSelect);
		
		return result;
	
	}
	
	//Solve
	public boolean solveReal( List<FloatVar> vars) {
		
		int size = vars.size();
		FloatVar[] floatVars = new FloatVar[size];
		
		for(int i=0; i<size; i++){
			floatVars[i] = vars.get(i);
		}
		
		DepthFirstSearch<FloatVar> floatSearch = new DepthFirstSearch<FloatVar>();
		SelectChoicePoint<FloatVar> floatSelect = new SplitSelectFloat<FloatVar>(store, floatVars, null) ;
		
		floatSearch.setSolutionListener(new PrintOutListener<FloatVar>());
		floatSearch.getSolutionListener().searchAll(true); 
//		floatSearch.getSolutionListener().recordSolutions(true);
//		floatSearch.setTimeOut(1);
		boolean result = floatSearch.labeling(store, floatSelect);
		
		return result;
	
	}
	
	public void string(){
		this.store.countConstraint();
	}
	
	public void printStore(){
		this.store.print();
	}
	
}//class
