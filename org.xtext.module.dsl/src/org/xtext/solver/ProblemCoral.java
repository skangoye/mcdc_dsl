package org.xtext.solver;

import symlib.SymBool;
import symlib.SymDouble;
import symlib.SymInt;
import symlib.SymLiteral;
import symlib.SymNumber;
import symlib.Util;
import coral.PC;
import coral.solvers.Env;
import coral.solvers.Result;
import coral.solvers.Solver;
import coral.solvers.SolverKind;
import coral.util.Config;

public class ProblemCoral {

//	private static final long timeout = -1; //Config.timeout; // 1s default
	private static SolverKind defaultKind;
	private SolverKind solverKind;
	private coral.PC pc = new coral.PC();
	private boolean optmize;

	public ProblemCoral() {
		this(defaultKind);
	}

	public ProblemCoral(SolverKind solverKind){
		this.solverKind = solverKind;
	}

	public coral.PC getPc() {
		return pc;
	}
	
	/**
	 * Set CORAL's parameters with the values from the .jpf file. 
	 * Look at ExSymExeCoral.jpf for more information. 
	 */
	
	public static void configure(/*gov.nasa.jpf.Config conf*/) {
		long seed = 464655;//conf.getLong("coral.seed",464655);
		int nIterations = 600; //conf.getInt("coral.iterations",-1);
		SolverKind kind = SolverKind.PSO_OPT4J ;//valueOf("RANDOM");
		boolean optimize = true;//conf.getBoolean("coral.optimize", true);
		String intervalSolver = "none";//conf.getString("coral.interval_solver","none").toLowerCase();
		String intervalSolverPath = "none";//conf.getString("coral.interval_solver.path","none");
		
		Config.seed = seed;
		defaultKind = kind;
		if(optimize) {
			Config.toggleValueInference = true;
			Config.removeSimpleEqualities = true;
		}
		
		if(!intervalSolver.equals("none")) {
			Config.intervalSolver = intervalSolver;
			Config.enableIntervalBasedSolver = true;
			if(intervalSolver.equals("realpaver")) {
				Config.realPaverLocation = intervalSolverPath;
			} else if (intervalSolver.equals("icos")) {
				Config.icosLocation = intervalSolverPath;
			} else {
				throw new RuntimeException("Unsupported interval solver!");
			}
			
			Config.simplifyUsingIntervalSolver = optimize ? true : false;
		}
		
		/**
		 * setting maximum number of iterations allowed.
		 * the solver return with no solution in that
		 * case.  note that the constraint may still be
		 * satisfiable.
		 */
		if(nIterations != -1) {
			if(kind.equals(SolverKind.PSO_OPT4J)) {
				Config.nIterationsPSO = nIterations;
			} else if(kind.equals(SolverKind.RANDOM)) {
				Config.nIterationsRANDOM = nIterations;
			} else if(kind.equals(SolverKind.AVM)) {
				Config.nIterationsAVM = nIterations;
			} 
		}
	}
	
	public void cleanup() {
		//reset the id generator
		Util.resetID();
	}

	/**************************************************
	 * ignoring ranges passed from JPF.  We use a short
	 * range as default but that is dynamically reset
	 * based on relational constraints involving
	 * constants.  for example, x > 10 && x < 20
	 * redefines the initial range of x to [10,20].
	 **************************************************/

	/*
	 *  Make variables
	 */
	
	public Object makeIntVar(String name, int min, int max) {
		 return Util.createSymLiteral(0);
	}
	 
	public Object makeRealVar(String name, double min, double max) {
		 return Util.createSymLiteral(0d);
	}
	
	public void intervalConstraint(Object variable, int min, boolean exclMin, int max, boolean exclMax){
		if(variable instanceof SymInt){
			if(exclMin) 
				this.post(this.gt(((SymInt)variable), min));
			else
				this.post(this.geq(((SymInt)variable), min));
			 
			if(exclMax) 
				this.post(this.lt(((SymInt)variable), max));
			else
				this.post(this.leq(((SymInt)variable), max));
		}	
	}
	
	public void intervalConstraint(Object variable, double min,  boolean exclMin, double max,  boolean exclMax){
		if(variable instanceof SymDouble){
			if(exclMin) 
				this.post(this.gt(((SymDouble)variable), min));
			else
				this.post(this.geq(((SymDouble)variable), min));
			 
			if(exclMax) 
				this.post(this.lt(((SymDouble)variable), max));
			else
				this.post(this.leq(((SymDouble)variable), max));
		}	
	}
	
	public Object makeBoolConstant(Boolean value){
		if (value.booleanValue())
			return Util.TRUE;
		else
			return Util.FALSE;
	}
	
	/*
	 * Equality
	 */
	
	public Object eq(int value1, int value2) {
		if(value1 == value2)
			return Util.TRUE;
		else
			return Util.FALSE;
	}
	
	public Object eq(double value1, double value2) {
		if(value1 == value2)
			return Util.TRUE;
		else
			return Util.FALSE;
	}
	
	public Object eq(Object exp, boolean value) {
		return value?(SymBool)exp: Util.neg((SymBool) exp);
	}
	
	public Object eq(boolean value, Object exp) {
		return value?(SymBool)exp: this.not(exp);
	}
	
	public Object eq(boolean value1, boolean value2) {
		if (value1 == value2)
			return Util.TRUE;
		else
			return Util.FALSE;
	}
	
	public Object eq(Object exp1, Object exp2) {
			
		if (exp1 instanceof Integer) {
			if(exp2 instanceof Integer)
				return this.eq( ((Integer)exp1).intValue(), ((Integer)exp2).intValue() );
			else if (exp2 instanceof SymInt)
				return Util.eq(Util.createConstant(((Integer)exp1).intValue()), (SymInt)exp2);
			else
				throw new UnsupportedOperationException();				
		}
		
		else { 
			if (exp1 instanceof Double) {
				if(exp2 instanceof Double)
					return this.eq( ((Double)exp1).doubleValue(), ((Double)exp2).doubleValue() );
				else if (exp2 instanceof SymDouble)
					return Util.eq(Util.createConstant(((Double)exp1).doubleValue()), (SymDouble)exp2);
				else
					throw new UnsupportedOperationException();
			}
			else{
				if (exp1 instanceof SymInt) {
					if(exp2 instanceof Integer)
						return Util.eq((SymInt)exp1 , Util.createConstant(((Integer)exp2).intValue()));
					else if (exp2 instanceof SymInt)
						return Util.eq((SymInt)exp1, (SymInt)exp2);
					else
						throw new UnsupportedOperationException();
				}
				else{
					if (exp1 instanceof SymDouble) {
						if(exp2 instanceof Double)
							return Util.eq((SymDouble)exp1, Util.createConstant(((Double)exp2).doubleValue()));
						else if (exp2 instanceof SymDouble)
							return Util.eq((SymDouble)exp1, (SymDouble)exp2);
						else
							throw new UnsupportedOperationException();
					}
					else{
						if (exp1 instanceof Boolean) {
							if(exp2 instanceof Boolean)
								return this.eq( ((Boolean)exp1).booleanValue(), ((Boolean)exp2).booleanValue() );
							else if (exp2 instanceof SymBool)
								return this.eq(((Boolean)exp1).booleanValue(), (SymBool)exp2); ///////
							else
								throw new UnsupportedOperationException();
						}
						else{
							if (exp1 instanceof SymBool) {
								if(exp2 instanceof Boolean)
									return this.eq( (SymBool)exp1, ((Boolean)exp2).booleanValue());
								else if (exp2 instanceof SymBool)
									return Util.eq((SymBool)exp1, (SymBool)exp2);
								else
									throw new UnsupportedOperationException();
							}
							else{
								throw new UnsupportedOperationException();
							}
						}
					}
				}
			}
		}
	}
	
	
	 
	/*
	 * Not Equality
	 */
	
	public Object neq(int value1, int value2) {
		if(value1 != value2)
			return Util.TRUE;
		else
			return Util.FALSE;
	}
	
	public Object neq(double value1, double value2) {
		if(value1 != value2)
			return Util.TRUE;
		else
			return Util.FALSE;
	}
	
	public Object neq(Object exp, boolean value) {//////////////
		return value?(SymBool)exp: Util.neg((SymBool) exp);
	}
	
	public Object neq(boolean value, Object exp) { //////////////
		return value?(SymBool)exp: this.not(exp);
	}
	
	public Object neq(boolean value1, boolean value2) {
		if (value1 != value2)
			return Util.TRUE;
		else
			return Util.FALSE;
	}
	
	public Object neq(Object exp1, Object exp2) {
			
		if (exp1 instanceof Integer) {
			if(exp2 instanceof Integer)
				return this.neq( ((Integer)exp1).intValue(), ((Integer)exp2).intValue() );
			else if (exp2 instanceof SymInt)
				return Util.ne(Util.createConstant(((Integer)exp1).intValue()), (SymInt)exp2);
			else
				throw new UnsupportedOperationException();				
		}
		
		else { 
			if (exp1 instanceof Double) {
				if(exp2 instanceof Double)
					return this.neq( ((Double)exp1).doubleValue(), ((Double)exp2).doubleValue() );
				else if (exp2 instanceof SymDouble)
					return Util.ne(Util.createConstant(((Double)exp1).doubleValue()), (SymDouble)exp2);
				else
					throw new UnsupportedOperationException();
			}
			else{
				if (exp1 instanceof SymInt) {
					if(exp2 instanceof Integer)
						return Util.ne((SymInt)exp1 , Util.createConstant(((Integer)exp2).intValue()));
					else if (exp2 instanceof SymInt)
						return Util.ne((SymInt)exp1, (SymInt)exp2);
					else
						throw new UnsupportedOperationException();
				}
				else{
					if (exp1 instanceof SymDouble) {
						if(exp2 instanceof Double)
							return Util.ne((SymDouble)exp1, Util.createConstant(((Double)exp2).doubleValue()));
						else if (exp2 instanceof SymDouble)
							return Util.ne((SymDouble)exp1, (SymDouble)exp2);
						else
							throw new UnsupportedOperationException();
					}
					else{
						if (exp1 instanceof Boolean) {
							if(exp2 instanceof Boolean)
								return this.neq( ((Boolean)exp1).booleanValue(), ((Boolean)exp2).booleanValue() );
							else if (exp2 instanceof SymBool)
								return this.neq(((Boolean)exp1).booleanValue(), (SymBool)exp2); ///////
							else
								throw new UnsupportedOperationException();
						}
						else{
							if (exp1 instanceof SymBool) {
								if(exp2 instanceof Boolean)
									return this.neq( (SymBool)exp1, ((Boolean)exp2).booleanValue());
								else if (exp2 instanceof SymBool)
									return Util.ne((SymBool)exp1, (SymBool)exp2);
								else
									throw new UnsupportedOperationException();
							}
							else{
								throw new UnsupportedOperationException();
							}
						}
					}
				}
			}
		}
	}


	
	/*
	 * Less or equal comparison
	 */
	
	public Object leq(int value1, int value2) {
		if(value1 <= value2)
			return Util.TRUE;
		else
			return Util.FALSE;
	}
	
	public Object leq(double value1, double value2) {
		if(value1 <= value2)
			return Util.TRUE;
		else
			return Util.FALSE;
	}
	
	public Object leq(Object exp1, Object exp2) {
		
		if (exp1 instanceof Integer) {
			if(exp2 instanceof Integer)
				return this.leq( ((Integer)exp1).intValue(), ((Integer)exp2).intValue() );
			else if (exp2 instanceof SymInt)
				return Util.le(Util.createConstant(((Integer)exp1).intValue()), (SymInt)exp2);
			else
				throw new UnsupportedOperationException();				
		}
		
		else { 
			if (exp1 instanceof Double) {
				if(exp2 instanceof Double)
					return this.leq( ((Double)exp1).doubleValue(), ((Double)exp2).doubleValue() );
				else if (exp2 instanceof SymDouble)
					return Util.le(Util.createConstant(((Double)exp1).doubleValue()), (SymDouble)exp2);
				else
					throw new UnsupportedOperationException();
			}
			else{
				if (exp1 instanceof SymInt) {
					if(exp2 instanceof Integer)
						return Util.le((SymInt)exp1,Util.createConstant(((Integer)exp2).intValue()));
					else if (exp2 instanceof SymInt)
						return Util.le((SymInt)exp1, (SymInt)exp2);
					else
						throw new UnsupportedOperationException();
				}
				else{
					if (exp1 instanceof SymDouble) {
						if(exp2 instanceof Double)
							return Util.le((SymDouble)exp1, Util.createConstant(((Double)exp2).doubleValue()));
						else if (exp2 instanceof SymDouble)
							return Util.le((SymDouble)exp1, (SymDouble)exp2);
						else
							throw new UnsupportedOperationException();
					}
					else{
						throw new UnsupportedOperationException();
					}
				}
			}
		}
	}
 
	
		
	/*
	 * great or equal comparison
	 */
	
	public Object geq(int value1, int value2) {
		if(value1 >= value2)
			return Util.TRUE;
		else
			return Util.FALSE;
	}
	
	public Object geq(double value1, double value2) {
		if(value1 >= value2)
			return Util.TRUE;
		else
			return Util.FALSE;
	}
	
	public Object geq(Object exp1, Object exp2) {
			
		if (exp1 instanceof Integer) {
			if(exp2 instanceof Integer)
				return this.geq( ((Integer)exp1).intValue(), ((Integer)exp2).intValue() );
			else if (exp2 instanceof SymInt)
				return Util.ge(Util.createConstant(((Integer)exp1).intValue()), (SymInt)exp2);
			else
				throw new UnsupportedOperationException();				
		}
		
		else { 
			if (exp1 instanceof Double) {
				if(exp2 instanceof Double)
					return this.geq( ((Double)exp1).doubleValue(), ((Double)exp2).doubleValue() );
				else if (exp2 instanceof SymDouble)
					return Util.ge(Util.createConstant(((Double)exp1).doubleValue()), (SymDouble)exp2);
				else
					throw new UnsupportedOperationException();
			}
			else{
				if (exp1 instanceof SymInt) {
					if(exp2 instanceof Integer)
						return Util.ge((SymInt)exp1,Util.createConstant(((Integer)exp2).intValue()));
					else if (exp2 instanceof SymInt)
						return Util.ge((SymInt)exp1, (SymInt)exp2);
					else
						throw new UnsupportedOperationException();
				}
				else{
					if (exp1 instanceof SymDouble) {
						if(exp2 instanceof Double)
							return Util.ge((SymDouble)exp1, Util.createConstant(((Double)exp2).doubleValue()));
						else if (exp2 instanceof SymDouble)
							return Util.ge((SymDouble)exp1, (SymDouble)exp2);
						else
							throw new UnsupportedOperationException();
					}
					else{
						throw new UnsupportedOperationException();
					}
				}
			}
		}
	}

	 
	
	/*
	 * Less comparison
	 */
	
	public Object lt(int value1, int value2) {
		if(value1 < value2)
			return Util.TRUE;
		else
			return Util.FALSE;
	}
	
	public Object lt(double value1, double value2) {
		if(value1 < value2)
			return Util.TRUE;
		else
			return Util.FALSE;
	}
	
	public Object lt(Object exp1, Object exp2) {
		
		if (exp1 instanceof Integer) {
			if(exp2 instanceof Integer)
				return this.lt( ((Integer)exp1).intValue(), ((Integer)exp2).intValue() );
			else if (exp2 instanceof SymInt)
				return Util.lt(Util.createConstant(((Integer)exp1).intValue()), (SymInt)exp2);
			else
				throw new UnsupportedOperationException();				
		}
		
		else { 
			if (exp1 instanceof Double) {
				if(exp2 instanceof Double)
					return this.lt( ((Double)exp1).doubleValue(), ((Double)exp2).doubleValue() );
				else if (exp2 instanceof SymDouble)
					return Util.lt(Util.createConstant(((Double)exp1).doubleValue()), (SymDouble)exp2);
				else
					throw new UnsupportedOperationException();
			}
			else{
				if (exp1 instanceof SymInt) {
					if(exp2 instanceof Integer)
						return Util.lt((SymInt)exp1,Util.createConstant(((Integer)exp2).intValue()));
					else if (exp2 instanceof SymInt)
						return Util.lt((SymInt)exp1, (SymInt)exp2);
					else
						throw new UnsupportedOperationException();
				}
				else{
					if (exp1 instanceof SymDouble) {
						if(exp2 instanceof Double)
							return Util.lt((SymDouble)exp1, Util.createConstant(((Double)exp2).doubleValue()));
						else if (exp2 instanceof SymDouble)
							return Util.lt((SymDouble)exp1, (SymDouble)exp2);
						else
							throw new UnsupportedOperationException();
					}
					else{
						throw new UnsupportedOperationException();
					}
				}
			}
		}
	}

	 
	
	/*
	 * great comparison
	 */
	
	public Object gt(int value1, int value2) {
		if(value1 > value2)
			return Util.TRUE;
		else
			return Util.FALSE;
	}
	
	public Object gt(double value1, double value2) {
		if(value1 > value2)
			return Util.TRUE;
		else
			return Util.FALSE;
	}
	
	public Object gt(Object exp1, Object exp2) {
			
			if (exp1 instanceof Integer) {
				if(exp2 instanceof Integer)
					return this.gt( ((Integer)exp1).intValue(), ((Integer)exp2).intValue() );
				else if (exp2 instanceof SymInt)
					return Util.gt(Util.createConstant(((Integer)exp1).intValue()), (SymInt)exp2);
				else
					throw new UnsupportedOperationException();				
			}
			
			else { 
				if (exp1 instanceof Double) {
					if(exp2 instanceof Double)
						return this.gt( ((Double)exp1).doubleValue(), ((Double)exp2).doubleValue() );
					else if (exp2 instanceof SymDouble)
						return Util.gt(Util.createConstant(((Double)exp1).doubleValue()), (SymDouble)exp2);
					else
						throw new UnsupportedOperationException();
				}
				else{
					if (exp1 instanceof SymInt) {
						if(exp2 instanceof Integer)
							return Util.gt((SymInt)exp1,Util.createConstant(((Integer)exp2).intValue()));
						else if (exp2 instanceof SymInt)
							return Util.gt((SymInt)exp1, (SymInt)exp2);
						else
							throw new UnsupportedOperationException();
					}
					else{
						if (exp1 instanceof SymDouble) {
							if(exp2 instanceof Double)
								return Util.gt((SymDouble)exp1, Util.createConstant(((Double)exp2).doubleValue()));
							else if (exp2 instanceof SymDouble)
								return Util.gt((SymDouble)exp1, (SymDouble)exp2);
							else
								throw new UnsupportedOperationException();
						}
						else{
							throw new UnsupportedOperationException();
						}
					}
				}
			}
		}

	

	/*
	 * Addition
	 */
	
	public Object plus(int value1, int value2) {
		return Util.createConstant(value1 + value2);
	}
	
	public Object plus(double value1, double value2) {
		return Util.createConstant(value1 + value2);
	}
	
	public Object plus(Object exp1, Object exp2) {
		
		if (exp1 instanceof Integer) {
			if(exp2 instanceof Integer)
				return this.plus( ((Integer)exp1).intValue(), ((Integer)exp2).intValue() );
			else if (exp2 instanceof SymInt)
				return Util.add(Util.createConstant(((Integer)exp1).intValue()), (SymInt)exp2);
			else
				throw new UnsupportedOperationException();				
		}
		
		else { 
			if (exp1 instanceof Double) {
				if(exp2 instanceof Double)
					return this.plus( ((Double)exp1).doubleValue(), ((Double)exp2).doubleValue() );
				else if (exp2 instanceof SymDouble)
					return Util.add(Util.createConstant(((Double)exp1).doubleValue()), (SymDouble)exp2);
				else
					throw new UnsupportedOperationException();
			}
			else{
				if (exp1 instanceof SymInt) {
					if(exp2 instanceof Integer)
						return Util.add((SymInt)exp1,Util.createConstant(((Integer)exp2).intValue()));
					else if (exp2 instanceof SymInt)
						return Util.add((SymInt)exp1, (SymInt)exp2);
					else
						throw new UnsupportedOperationException();
				}
				else{
					if (exp1 instanceof SymDouble) {
						if(exp2 instanceof Double)
							return Util.add((SymDouble)exp1, Util.createConstant(((Double)exp2).doubleValue()));
						else if (exp2 instanceof SymDouble)
							return Util.add((SymDouble)exp1, (SymDouble)exp2);
						else
							throw new UnsupportedOperationException();
					}
					else{
						throw new UnsupportedOperationException();
					}
				}
			}
		}
	}

	
	
	/*
	 * Subtraction
	 */
	 
	public Object minus(int value1, int value2) {
		return Util.createConstant(value1 - value2);
	}
	
	public Object minus(double value1, double value2) {
		return Util.createConstant(value1 - value2);
	}
	
	public Object minus(Object exp1, Object exp2) {
			
			if (exp1 instanceof Integer) {
				if(exp2 instanceof Integer)
					return this.minus( ((Integer)exp1).intValue(), ((Integer)exp2).intValue() );
				else if (exp2 instanceof SymInt)
					return Util.sub(Util.createConstant(((Integer)exp1).intValue()), (SymInt)exp2);
				else
					throw new UnsupportedOperationException();				
			}
			
			else { 
				if (exp1 instanceof Double) {
					if(exp2 instanceof Double)
						return this.minus( ((Double)exp1).doubleValue(), ((Double)exp2).doubleValue() );
					else if (exp2 instanceof SymDouble)
						return Util.sub(Util.createConstant(((Double)exp1).doubleValue()), (SymDouble)exp2);
					else
						throw new UnsupportedOperationException();
				}
				else{
					if (exp1 instanceof SymInt) {
						if(exp2 instanceof Integer)
							return Util.sub((SymInt)exp1,Util.createConstant(((Integer)exp2).intValue()));
						else if (exp2 instanceof SymInt)
							return Util.sub((SymInt)exp1, (SymInt)exp2);
						else
							throw new UnsupportedOperationException();
					}
					else{
						if (exp1 instanceof SymDouble) {
							if(exp2 instanceof Double)
								return Util.sub((SymDouble)exp1, Util.createConstant(((Double)exp2).doubleValue()));
							else if (exp2 instanceof SymDouble)
								return Util.sub((SymDouble)exp1, (SymDouble)exp2);
							else
								throw new UnsupportedOperationException();
						}
						else{
							throw new UnsupportedOperationException();
						}
					}
				}
			}
		}

	 
	
	/*
	 * Multiplication
	 */
	
	public Object mult(int value1, int value2) {
		return Util.createConstant(value1 * value2);
	}
	
	public Object mult(double value1, double value2) {
		return Util.createConstant(value1 * value2);
	}
	
	public Object mult(Object exp1, Object exp2) {
		
		if (exp1 instanceof Integer) {
			if(exp2 instanceof Integer)
				return this.mult( ((Integer)exp1).intValue(), ((Integer)exp2).intValue() );
			else if (exp2 instanceof SymInt)
				return Util.mul(Util.createConstant(((Integer)exp1).intValue()), (SymInt)exp2);
			else
				throw new UnsupportedOperationException();				
		}
		
		else { 
			if (exp1 instanceof Double) {
				if(exp2 instanceof Double)
					return this.mult( ((Double)exp1).doubleValue(), ((Double)exp2).doubleValue() );
				else if (exp2 instanceof SymDouble)
					return Util.mul(Util.createConstant(((Double)exp1).doubleValue()), (SymDouble)exp2);
				else
					throw new UnsupportedOperationException();
			}
			else{
				if (exp1 instanceof SymInt) {
					if(exp2 instanceof Integer)
						return Util.mul((SymInt)exp1,Util.createConstant(((Integer)exp2).intValue()));
					else if (exp2 instanceof SymInt)
						return Util.mul((SymInt)exp1, (SymInt)exp2);
					else
						throw new UnsupportedOperationException();
				}
				else{
					if (exp1 instanceof SymDouble) {
						if(exp2 instanceof Double)
							return Util.mul((SymDouble)exp1, Util.createConstant(((Double)exp2).doubleValue()));
						else if (exp2 instanceof SymDouble)
							return Util.mul((SymDouble)exp1, (SymDouble)exp2);
						else
							throw new UnsupportedOperationException();
					}
					else{
						throw new UnsupportedOperationException();
					}
				}
			}
		}
	}

	
	
	/*
	 * Division
	 */
	
	public Object div(int value1, int value2) {
		return Util.createConstant(value1 / value2);
	}
	
	public Object div(double value1, double value2) {
		return Util.createConstant(value1 / value2);
	}

	public Object div(Object exp1, Object exp2) {
			
		if (exp1 instanceof Integer) {
			if(exp2 instanceof Integer)
				return this.div( ((Integer)exp1).intValue(), ((Integer)exp2).intValue() );
			else if (exp2 instanceof SymInt)
				return Util.div(Util.createConstant(((Integer)exp1).intValue()), (SymInt)exp2);
			else
				throw new UnsupportedOperationException();				
		}
		
		else { 
			if (exp1 instanceof Double) {
				if(exp2 instanceof Double)
					return this.div( ((Double)exp1).doubleValue(), ((Double)exp2).doubleValue() );
				else if (exp2 instanceof SymDouble)
					return Util.div(Util.createConstant(((Double)exp1).doubleValue()), (SymDouble)exp2);
				else
					throw new UnsupportedOperationException();
			}
			else{
				if (exp1 instanceof SymInt) {
					if(exp2 instanceof Integer)
						return Util.div((SymInt)exp1,Util.createConstant(((Integer)exp2).intValue()));
					else if (exp2 instanceof SymInt)
						return Util.div((SymInt)exp1, (SymInt)exp2);
					else
						throw new UnsupportedOperationException();
				}
				else{
					if (exp1 instanceof SymDouble) {
						if(exp2 instanceof Double)
							return Util.div((SymDouble)exp1, Util.createConstant(((Double)exp2).doubleValue()));
						else if (exp2 instanceof SymDouble)
							return Util.div((SymDouble)exp1, (SymDouble)exp2);
						else
							throw new UnsupportedOperationException();
					}
					else{
						throw new UnsupportedOperationException();
					}
				}
			}
		}
	}

	
	
	/*
	 * Logical and
	 */
	
	public Object and(boolean exp1 , boolean exp2) {
		if(exp1 && exp2)
			return Util.TRUE;
		else
			return Util.FALSE;				
	}
	
	public Object and(Object exp1, Object exp2) {
		if (exp1 instanceof Boolean){
			if(exp2 instanceof Boolean)
				return this.and( ((Boolean)exp1).booleanValue(), ((Boolean)exp2).booleanValue() );
			else if(exp2 instanceof SymBool)
				return Util.and( (((Boolean)exp1).booleanValue())?Util.TRUE:Util.FALSE, (SymBool)exp2 );
			else
				throw new UnsupportedOperationException();
		}
		else{
			if (exp1 instanceof SymBool){
				if(exp2 instanceof Boolean)
					return Util.and( (SymBool)exp2 , (((Boolean)exp2).booleanValue())?Util.TRUE:Util.FALSE );
				else if(exp2 instanceof SymBool)
					return Util.and((SymBool)exp1, (SymBool)exp2);
				else
					throw new UnsupportedOperationException();
			}
			else{
				throw new UnsupportedOperationException();
			}
		}
	}
	
	
	
	/*
	 * Logical or
	 */
	
	public Object or(boolean exp1 , boolean exp2) {
		if(exp1 || exp2)
			return Util.TRUE;
		else
			return Util.FALSE;				
	}
	
	public Object or(Object exp1, Object exp2) {
		if (exp1 instanceof Boolean){
			if(exp2 instanceof Boolean)
				return this.or( ((Boolean)exp1).booleanValue(), ((Boolean)exp2).booleanValue() );
			else if(exp2 instanceof SymBool)
				return Util.or( (((Boolean)exp1).booleanValue())?Util.TRUE:Util.FALSE, (SymBool)exp2 );
			else
				throw new UnsupportedOperationException();
		}
		else{
			if (exp1 instanceof SymBool){
				if(exp2 instanceof Boolean)
					return Util.or( (SymBool)exp2 , (((Boolean)exp2).booleanValue())?Util.TRUE:Util.FALSE );
				else if(exp2 instanceof SymBool)
					return Util.or((SymBool)exp1, (SymBool)exp2);
				else
					throw new UnsupportedOperationException();
			}
			else{
				throw new UnsupportedOperationException();
			}
		}
	}

	
	
	/*
	 * Logical xor
	 */
	public Object xor(boolean exp1 , boolean exp2) {
		if( (exp1 && !exp2) || (!exp1 && exp2) )
			return Util.TRUE;
		else
			return Util.FALSE;				
	}
	
	public Object xor(Object exp1, Object exp2) {
		if (exp1 instanceof Boolean){
			if(exp2 instanceof Boolean)
				return this.xor( ((Boolean)exp1).booleanValue(), ((Boolean)exp2).booleanValue() );
			else if(exp2 instanceof SymBool)
				return Util.xor( (((Boolean)exp1).booleanValue())?Util.TRUE:Util.FALSE, (SymBool)exp2 );
			else
				throw new UnsupportedOperationException();
		}
		else{
			if (exp1 instanceof SymBool){
				if(exp2 instanceof Boolean)
					return Util.xor( (SymBool)exp2 , (((Boolean)exp2).booleanValue())?Util.TRUE:Util.FALSE );
				else if(exp2 instanceof SymBool)
					return Util.xor((SymBool)exp1, (SymBool)exp2);
				else
					throw new UnsupportedOperationException();
			}
			else{
				throw new UnsupportedOperationException();
			}
		}
	}
	
	
	
	/*
	 * Logical not
	 */
	
	public Object not(Object exp){
		if(exp instanceof Boolean)
			return (((Boolean)exp).booleanValue())?Util.FALSE:Util.TRUE;
		else
			return Util.neg((SymBool)exp);
			//return (SymBool)exp;
	}
	
	
	
	/*
	 * Shift left
	 */
	
	public Object shiftL(int value, Object exp) {
		return Util.sl(Util.createConstant(value), (SymInt)exp);
	}

	public Object shiftL(Object exp, int value) {
		return Util.sl((SymInt)exp, Util.createConstant(value));
	}
 
	public Object shiftL(Object exp1, Object exp2) {
		return Util.sl((SymInt)exp1, (SymInt)exp2);
	}
	
	
	
	/*
	 * Shift right
	 */
	 
	public Object shiftR(int value, Object exp) {
		return Util.sr(Util.createConstant(value), (SymInt)exp);
	}
	 
	public Object shiftR(Object exp, int value) {
		return Util.sr((SymInt)exp, Util.createConstant(value));
	}

	public Object shiftR(Object exp1, Object exp2) {
		return Util.sr((SymInt)exp1, (SymInt)exp2);
	}

	/*
	 * Shift 
	 */ 
	public Object shiftUR(int value, Object exp) {
		return Util.usr(Util.createConstant(value), (SymInt)exp);
	}
	 
	public Object shiftUR(Object exp, int value) {
		return Util.usr((SymInt)exp, Util.createConstant(value));
	}
	 
	public Object shiftUR(Object exp1, Object exp2) {
		return Util.usr((SymInt)exp1, (SymInt)exp2);
	}

	
	
	/*
	 * Mixed int/double types
	 */
	public Object mixed(Object exp1, Object exp2) {
        if (exp1 instanceof SymDouble && exp2 instanceof SymInt)
            return Util.eq((SymDouble)exp1, Util.createASDouble((SymInt)exp2));
        else
            throw new RuntimeException("## Error CORAL: unsupported mixed case");
	}

	
	/*
	 * Sinus
	 */
	public Object sin(Object exp) {
		return Util.sin((SymDouble)exp);
	}

	
	/*
	 * Cosinus
	 */
	public Object cos(Object exp) {
		return Util.cos((SymDouble)exp);
	}
	
	
	/*
	 * tangent
	 */
	public Object tan(Object exp) {
		return Util.tan((SymDouble)exp);
	}
	
	
	/*
	 * Round
	 */
	public Object round(Object exp) {
		return Util.round((SymDouble)exp);
	}
	
	
	/*
	 * Exponent
	 */
	public Object exp(Object exp) {
		return Util.exp((SymDouble)exp);
	}
	
	/*
	 * Arc sinus
	 */
	public Object asin(Object exp) {
		return Util.asin((SymDouble)exp);
	}

	/*
	 * Arc cosinus
	 */
	public Object acos(Object exp) {
		return Util.acos((SymDouble)exp);
	}
	
	/*
	 * Arc tangent
	 */
	public Object atan(Object exp) {
		return Util.atan((SymDouble)exp);
	}
	
	
	/*
	 * Logarithm
	 */
	public Object log(Object exp) {
		return Util.log((SymDouble)exp);
	}

	
	/*
	 * Square root
	 */
	public Object sqrt(Object exp) {
		return Util.sqrt((SymDouble)exp);
	}
	
	
	
	/*
	 * Power
	 */
	
	public Object power(Object exp1, Object exp2) {
		return Util.pow((SymDouble)exp1, (SymDouble)exp2);
	}

	public Object power(Object exp1, double exp2) {
		return Util.pow((SymDouble)exp1, Util.createConstant(exp2));
	}

	public Object power(double exp1, Object exp2) {
		return Util.pow(Util.createConstant(exp1), (SymDouble)exp2);
	}
	
	
	/*
	 * Arc tangent2
	 */
	public Object atan2(Object exp1, Object exp2) {
		return Util.atan2((SymDouble)exp1, (SymDouble)exp2);
	}

	public Object atan2(Object exp1, double exp2) {
		return Util.atan2((SymDouble)exp1, Util.createConstant(exp2));
	}

	public Object atan2(double exp1, Object exp2) {
		return Util.atan2(Util.createConstant(exp1), (SymDouble)exp2);
	}

	
	
	Env sol = null;
	 
	/**
	 * JPF calls this method when it needs to solve the path condition
	 */
	public int solve() {
		Solver solver = solverKind.get();
		int result = -1;
		try {
			sol = solveIt(pc, solver);
			/**
			 * this is to comply with the assumption
			 * of the calling method
			 */

			if (sol.getResult() == Result.SAT) {
				result = 1;
			}
			else{
				if (sol.getResult() == Result.UNSAT) {
					result = 0;
				}
				else{
					//unknow result
				}
			}
		} catch (Exception _) {
		}
//		finally {
//			System.out.printf(">>> %s %s %s\n", pc.toString(), sol, result);
//		}
		return result;
	}



	private Env solveIt(final PC pc, final Solver solver) throws InterruptedException {
		final Env[] env = new Env[1];
		Runnable solverJob = new Runnable() {
			 
			public void run() {
				try {
					env[0] = solver.getCallable(pc).call();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		/**
		 * If solving is based on timeouts (value > 0)
		 * the code spawns a timer thread.  otherwise,
		 * it calls the run() method directly.
		 */
//		if (timeout > 0) { // old code; not executed
//			Thread t = new Thread(solverJob);
//			t.start();
//			t.join(timeout);
//			solver.setPleaseStop(true);
//			Thread.sleep(10);
//		} else {
		solverJob.run();
//		}
		return env[0];
	}

	 
	public double getRealValueInf(Object dpvar) {
		return -1;
	}

	 
	public double getRealValueSup(Object dpVar) {
		return -1;
	}

	 
	public double getRealValue(Object dpVar) {
		SymNumber symNumber = sol.getValue((SymLiteral)dpVar);
		return symNumber.evalNumber().doubleValue();
	}

	 
	public int getIntValue(Object dpVar) {
		SymNumber symNumber = sol.getValue((SymLiteral)dpVar);
		try {
		return symNumber.evalNumber().intValue();
		} catch (NullPointerException _) {
			throw _;
		}
	}

	 
	/**
	 * JPF calls this method to add a new boolean expression
	 * to the path condition
	 */
	public void post(Object constraint) {
		pc.addConstraint((SymBool)constraint);
	}

	 
	public void postLogicalOR(Object[] constraints) {
		SymBool orResult = Util.FALSE;
		for (int i =0; i<constraints.length; i++) {
			System.out.println("****** orResult"+ orResult + "************ " +i);
			orResult = Util.or(orResult, (SymBool) ( constraints[i]));
		}

		post(orResult);

	}
	
}
