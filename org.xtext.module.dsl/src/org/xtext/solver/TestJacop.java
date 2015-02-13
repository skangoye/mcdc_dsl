package org.xtext.solver;

import java.util.ArrayList;
import java.util.List;

import org.jacop.constraints.And;
import org.jacop.constraints.Or;
import org.jacop.constraints.PrimitiveConstraint;
import org.jacop.core.IntVar;
import org.jacop.core.Store;
import org.jacop.floats.constraints.PeqQ;
import org.jacop.floats.constraints.PgtQ;
import org.jacop.floats.constraints.PgteqQ;
import org.jacop.floats.constraints.PltQ;
import org.jacop.floats.constraints.PlteqQ;
import org.jacop.floats.constraints.PneqQ;
import org.jacop.floats.constraints.PplusQeqR;
import org.jacop.floats.core.FloatDomain;
import org.jacop.floats.core.FloatVar;
import org.jacop.floats.search.SplitSelectFloat;
import org.jacop.search.DepthFirstSearch;
import org.jacop.search.PrintOutListener;
import org.jacop.search.SelectChoicePoint;

public class TestJacop {
	
	public static void main(String[] args) {
		
		double MIN_FLOAT = -1e+6;
	    double MAX_FLOAT =  1e+6;
	    
	    FloatDomain.setPrecision(0.0001);
		//create Coral solver
		Store store = new Store();	
		
		//create variables
//		FloatVar x = new FloatVar(store, "X", -1, 100); 
				
//		FloatVar y = new FloatVar(store, "Y", -1, 100); 
	
		FloatVar z = new FloatVar(store, "Z", 0, 10);
		
//		FloatVar tmp_result0 = new FloatVar(store,"tmp_result0", MIN_FLOAT, MAX_FLOAT);
//		
//		FloatVar zero = new FloatVar(store, 0, 0);
		
//		FloatVar mOne = new FloatVar(store,-1, -1);
		
//		PrimitiveConstraint c1 = new PeqQ(tmp_result0, mOne);
//		store.impose(c1);
		
//		PrimitiveConstraint c2 = new PgteqQ(x, zero);
//		store.impose(c2);
		
//		PrimitiveConstraint c3 = new PgteqQ(y, zero);
//		store.impose(c3);
//		
//		PrimitiveConstraint c4 = new PgteqQ(z, zero);
//		store.impose(c4);		
		
		FloatVar x1 = new FloatVar(store, "X1", 0, 10); 
//		PrimitiveConstraint c5 = new PeqQ(x1, y);
//		store.impose(c5); 
		
//		FloatVar tmp_result1 = new FloatVar(store, "tmp_result1", MIN_FLOAT, MAX_FLOAT);
//		PrimitiveConstraint c6 = new PeqQ(tmp_result1, zero);
//		store.impose(c6); 
				
//		PrimitiveConstraint c8 = new PneqQ(z, zero);
//		store.impose(c8);
		
		PrimitiveConstraint c9 =  new PltQ(z, x1);
		c9.impose(store);
		
		PrimitiveConstraint c10 = new PgtQ(z, x1);
		c10.impose(store);
		
		
//		FloatVar plus = new FloatVar(store, "plus", MIN_FLOAT, MAX_FLOAT);
//		PrimitiveConstraint c11 = new PplusQeqR(x1, y, plus);
//		store.impose(c11);
		
//		PrimitiveConstraint c12 = new PlteqQ(z,plus);
//		store.impose(c12);		
		
//		FloatVar tmp_result2 = new FloatVar(store, "tmp_result2", MIN_FLOAT, MAX_FLOAT);
//		PrimitiveConstraint c13 = new PeqQ(tmp_result2, plus);
//		store.impose(c13); 
		
//		FloatVar result = new FloatVar(store, "result", MIN_FLOAT, MAX_FLOAT);
//		PrimitiveConstraint c14 = new PeqQ(result, tmp_result2);
//		store.impose(c14);
		
		System.out.println("Consistency: " + store.consistency());
		
//		PrimitiveConstraint[] c = { c9, c10 };
//		store.impose(new And(c));

		DepthFirstSearch<FloatVar> floatSearch = new DepthFirstSearch<FloatVar>();
		SelectChoicePoint<FloatVar> floatSelect = new SplitSelectFloat<FloatVar>(store, new FloatVar[] {z, x1}, null) ;
//		floatSearch.setAssignSolution(true);
//		floatSearch.setSolutionListener( new PrintOutListener<FloatVar>());
//		floatSearch.getSolutionListener().searchAll(true); 
		floatSearch.getSolutionListener().recordSolutions(true);
//		floatSearch.setTimeOut(1);
		boolean searchResult = floatSearch.labeling(store, floatSelect);
		
		System.out.println("Solved: " + searchResult);
	
	}
}
