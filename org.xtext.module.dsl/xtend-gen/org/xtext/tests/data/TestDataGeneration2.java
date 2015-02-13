package org.xtext.tests.data;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.jacop.core.IntVar;
import org.jacop.floats.core.FloatVar;
import org.xtext.helper.BinaryTree;
import org.xtext.helper.Couple;
import org.xtext.helper.Triplet;
import org.xtext.moduleDsl.AbstractVAR_DECL;
import org.xtext.moduleDsl.Flow;
import org.xtext.moduleDsl.INTERFACE;
import org.xtext.moduleDsl.INTERVAL;
import org.xtext.moduleDsl.LSET;
import org.xtext.moduleDsl.Literal;
import org.xtext.moduleDsl.MODULE_DECL;
import org.xtext.moduleDsl.RANGE;
import org.xtext.moduleDsl.TYPE;
import org.xtext.moduleDsl.VAR_DECL;
import org.xtext.solver.JacopUtils;
import org.xtext.solver.ProblemJacop;
import org.xtext.utils.DslUtils;

@SuppressWarnings("all")
public class TestDataGeneration2 {
  private final static HashMap<String, Object> intVars = new HashMap<String, Object>();
  
  private final static HashMap<String, Object> doubleVars = new HashMap<String, Object>();
  
  private final static HashMap<String, Object> dslInVars = new HashMap<String, Object>();
  
  private final static HashMap<String, Object> dslOutVars = new HashMap<String, Object>();
  
  private final static String splitPattern = "\\|";
  
  public static HashMap<List<Couple<String, String>>, List<Triplet<String, String, String>>> testDataGeneration(final MODULE_DECL module, final Map<List<Couple<String, String>>, String> mapTestSequencesAndIdents, final Map<String, List<String>> pathIdentsSequences, final Map<String, Couple<String, BinaryTree<Triplet<String, String, String>>>> expression) {
    final HashMap<List<Couple<String, String>>, List<Triplet<String, String, String>>> solutions = new HashMap<List<Couple<String, String>>, List<Triplet<String, String, String>>>();
    TestDataGeneration2.collectDslVariables(module, TestDataGeneration2.dslInVars, TestDataGeneration2.dslOutVars);
    Set<List<Couple<String, String>>> _keySet = mapTestSequencesAndIdents.keySet();
    final Procedure1<List<Couple<String, String>>> _function = new Procedure1<List<Couple<String, String>>>() {
      public void apply(final List<Couple<String, String>> testSequences) {
        final String pathID = mapTestSequencesAndIdents.get(testSequences);
        final List<String> pathIdentSeq = pathIdentsSequences.get(pathID);
        final ProblemJacop pb = new ProblemJacop();
        final HashMap<String, Object> solverInVarsMap = TestDataGeneration2.createInputVariables(pb, TestDataGeneration2.dslInVars);
        TestDataGeneration2.toSolverTranslator(pb, pathIdentSeq, testSequences, expression, pathID);
        final HashMap<String, Object> solverOutVarsMap = TestDataGeneration2.dslOutVarsWithSSAindexes(TestDataGeneration2.dslOutVars, TestDataGeneration2.intVars, TestDataGeneration2.doubleVars);
        final ArrayList<Object> solverVars = new ArrayList<Object>();
        Collection<Object> _values = solverInVarsMap.values();
        solverVars.addAll(_values);
        Collection<Object> _values_1 = solverOutVarsMap.values();
        solverVars.addAll(_values_1);
        final boolean solve = pb.solve(solverVars);
        if (solve) {
          final ArrayList<Triplet<String, String, String>> inSolutions = TestDataGeneration2.recordSolutions(pb, solverInVarsMap, TestDataGeneration2.dslInVars, "input");
          final ArrayList<Triplet<String, String, String>> outSolutions = TestDataGeneration2.recordSolutions(pb, solverOutVarsMap, TestDataGeneration2.dslOutVars, "output");
          inSolutions.addAll(outSolutions);
          solutions.put(testSequences, inSolutions);
        }
        TestDataGeneration2.intVars.clear();
        TestDataGeneration2.doubleVars.clear();
      }
    };
    IterableExtensions.<List<Couple<String, String>>>forEach(_keySet, _function);
    return solutions;
  }
  
  public static HashMap<String, Object> createInputVariables(final ProblemJacop pb, final HashMap<String, Object> dslInVarsMap) {
    final HashMap<String, Object> map = new HashMap<String, Object>();
    final Set<String> inputVarsNames = dslInVarsMap.keySet();
    for (final String inputVarName : inputVarsNames) {
      {
        final String ssaInputVarName = TestDataGeneration2.addSSAIndex(inputVarName, "0");
        Object _get = dslInVarsMap.get(inputVarName);
        final VAR_DECL dslInputVar = ((VAR_DECL) _get);
        final RANGE range = dslInputVar.getRange();
        TYPE _type = dslInputVar.getType();
        final String type = _type.getType();
        final Object solverVar = TestDataGeneration2.manageVariables(pb, ssaInputVarName, type);
        if ((range instanceof INTERVAL)) {
          JacopUtils.setIntervalConstraints(pb, solverVar, dslInputVar);
        } else {
          if ((range instanceof LSET)) {
            JacopUtils.setSetconstraints(pb, solverVar, dslInputVar);
          }
        }
        map.put(ssaInputVarName, solverVar);
      }
    }
    return map;
  }
  
  /**
   * Translate a SSA expression into the Solver expression
   */
  public static void toSolverTranslator(final ProblemJacop pb, final List<String> pathIdentSeq, final List<Couple<String, String>> testSequences, final Map<String, Couple<String, BinaryTree<Triplet<String, String, String>>>> ssaExprMap, final String pathID) {
    final Procedure1<String> _function = new Procedure1<String>() {
      public void apply(final String pathCondID) {
        final String condLastChar = DslUtils.getLastChar(pathCondID);
        boolean _equals = Objects.equal(condLastChar, "N");
        if (_equals) {
          final String identAtPathID = TestDataGeneration2.addPathID(pathCondID, pathID);
          final Couple<String, BinaryTree<Triplet<String, String, String>>> expCouple = ssaExprMap.get(identAtPathID);
          final String ssaName = expCouple.getFirst();
          final BinaryTree<Triplet<String, String, String>> btExp = expCouple.getSecond();
          Triplet<String, String, String> _value = btExp.getValue();
          String type = _value.getThird();
          boolean _or = false;
          boolean _or_1 = false;
          boolean _equals_1 = Objects.equal(type, "c_int");
          if (_equals_1) {
            _or_1 = true;
          } else {
            boolean _equals_2 = Objects.equal(type, "c_real");
            _or_1 = _equals_2;
          }
          if (_or_1) {
            _or = true;
          } else {
            boolean _equals_3 = Objects.equal(type, "c_enum");
            _or = _equals_3;
          }
          if (_or) {
            int _length = type.length();
            String _substring = type.substring(2, _length);
            type = _substring;
          }
          final Object solverVar = TestDataGeneration2.manageVariables(pb, ssaName, type);
          final Object solverBtExp = TestDataGeneration2.toSolverExpression(pb, btExp, true);
          final Object constraint = pb.eq(solverVar, solverBtExp);
          pb.post(constraint);
        } else {
          final String pathCondIDwithoutLast = DslUtils.deleteLastChar(pathCondID);
          final String identAtPathID_1 = TestDataGeneration2.addPathID(pathCondIDwithoutLast, pathID);
          final Couple<String, BinaryTree<Triplet<String, String, String>>> expCouple_1 = ssaExprMap.get(identAtPathID_1);
          final BinaryTree<Triplet<String, String, String>> btExp_1 = expCouple_1.getSecond();
          final String ssaName_1 = expCouple_1.getFirst();
          final ArrayList<String> results = TestDataGeneration2.getIdSequence(testSequences, pathCondIDwithoutLast);
          final ArrayList<BinaryTree<Triplet<String, String, String>>> btBooleanConditions = TestDataGeneration2.booleanConditions(btExp_1);
          final Procedure2<BinaryTree<Triplet<String, String, String>>, Integer> _function = new Procedure2<BinaryTree<Triplet<String, String, String>>, Integer>() {
            public void apply(final BinaryTree<Triplet<String, String, String>> boolCondition, final Integer i) {
              final String outcome = results.get(((i).intValue() + 1));
              boolean _isRelationalCondition = TestDataGeneration2.isRelationalCondition(boolCondition);
              if (_isRelationalCondition) {
                boolean _boolValue = DslUtils.boolValue(outcome);
                final Object constraint = TestDataGeneration2.toSolverExpression(pb, boolCondition, _boolValue);
                pb.post(constraint);
              } else {
                Triplet<String, String, String> _value = boolCondition.getValue();
                final String varName = _value.getFirst();
                Triplet<String, String, String> _value_1 = boolCondition.getValue();
                final String ssaIndex = _value_1.getSecond();
                final String ssaVarName = TestDataGeneration2.addSSAIndex(varName, ssaIndex);
              }
            }
          };
          IterableExtensions.<BinaryTree<Triplet<String, String, String>>>forEach(btBooleanConditions, _function);
          boolean _notEquals = (!Objects.equal(ssaName_1, "*"));
          if (_notEquals) {
            String _get = results.get(0);
            final boolean outcome = DslUtils.boolValue(_get);
          }
        }
      }
    };
    IterableExtensions.<String>forEach(pathIdentSeq, _function);
  }
  
  /**
   * Transform a relational condition into a Coral solver constraint
   */
  public static Object toSolverExpression(final ProblemJacop pb, final BinaryTree<Triplet<String, String, String>> bt, final boolean outcome) {
    try {
      Object _xblockexpression = null;
      {
        final Triplet<String, String, String> btValue = bt.getValue();
        final String operator = btValue.getFirst();
        Object _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          if (Objects.equal(operator, "OR")) {
            _matched=true;
            Object _xifexpression = null;
            if ((outcome == false)) {
              BinaryTree<Triplet<String, String, String>> _left = bt.getLeft();
              Object _solverExpression = TestDataGeneration2.toSolverExpression(pb, _left, outcome);
              BinaryTree<Triplet<String, String, String>> _right = bt.getRight();
              Object _solverExpression_1 = TestDataGeneration2.toSolverExpression(pb, _right, outcome);
              _xifexpression = pb.and(_solverExpression, _solverExpression_1);
            } else {
              BinaryTree<Triplet<String, String, String>> _left_1 = bt.getLeft();
              Object _solverExpression_2 = TestDataGeneration2.toSolverExpression(pb, _left_1, outcome);
              BinaryTree<Triplet<String, String, String>> _right_1 = bt.getRight();
              Object _solverExpression_3 = TestDataGeneration2.toSolverExpression(pb, _right_1, outcome);
              _xifexpression = pb.or(_solverExpression_2, _solverExpression_3);
            }
            _switchResult = _xifexpression;
          }
        }
        if (!_matched) {
          if (Objects.equal(operator, "AND")) {
            _matched=true;
            Object _xifexpression_1 = null;
            if ((outcome == false)) {
              BinaryTree<Triplet<String, String, String>> _left_2 = bt.getLeft();
              Object _solverExpression_4 = TestDataGeneration2.toSolverExpression(pb, _left_2, outcome);
              BinaryTree<Triplet<String, String, String>> _right_2 = bt.getRight();
              Object _solverExpression_5 = TestDataGeneration2.toSolverExpression(pb, _right_2, outcome);
              _xifexpression_1 = pb.or(_solverExpression_4, _solverExpression_5);
            } else {
              BinaryTree<Triplet<String, String, String>> _left_3 = bt.getLeft();
              Object _solverExpression_6 = TestDataGeneration2.toSolverExpression(pb, _left_3, outcome);
              BinaryTree<Triplet<String, String, String>> _right_3 = bt.getRight();
              Object _solverExpression_7 = TestDataGeneration2.toSolverExpression(pb, _right_3, outcome);
              _xifexpression_1 = pb.and(_solverExpression_6, _solverExpression_7);
            }
            _switchResult = _xifexpression_1;
          }
        }
        if (!_matched) {
          if (Objects.equal(operator, "XOR")) {
            _matched=true;
            _switchResult = null;
          }
        }
        if (!_matched) {
          if (Objects.equal(operator, "NOT")) {
            _matched=true;
            Object _xifexpression_2 = null;
            if ((outcome == false)) {
              Object _xblockexpression_1 = null;
              {
                boolean new_invert = true;
                BinaryTree<Triplet<String, String, String>> _right_4 = bt.getRight();
                _xblockexpression_1 = TestDataGeneration2.toSolverExpression(pb, _right_4, new_invert);
              }
              _xifexpression_2 = _xblockexpression_1;
            } else {
              Object _xblockexpression_2 = null;
              {
                boolean new_invert = false;
                BinaryTree<Triplet<String, String, String>> _right_4 = bt.getRight();
                _xblockexpression_2 = TestDataGeneration2.toSolverExpression(pb, _right_4, new_invert);
              }
              _xifexpression_2 = _xblockexpression_2;
            }
            _switchResult = _xifexpression_2;
          }
        }
        if (!_matched) {
          if (Objects.equal(operator, "==")) {
            _matched=true;
            Object _xifexpression_3 = null;
            if ((outcome == false)) {
              BinaryTree<Triplet<String, String, String>> _left_4 = bt.getLeft();
              Object _solverExpression_8 = TestDataGeneration2.toSolverExpression(pb, _left_4, outcome);
              BinaryTree<Triplet<String, String, String>> _right_4 = bt.getRight();
              Object _solverExpression_9 = TestDataGeneration2.toSolverExpression(pb, _right_4, outcome);
              _xifexpression_3 = pb.neq(_solverExpression_8, _solverExpression_9);
            } else {
              BinaryTree<Triplet<String, String, String>> _left_5 = bt.getLeft();
              Object _solverExpression_10 = TestDataGeneration2.toSolverExpression(pb, _left_5, outcome);
              BinaryTree<Triplet<String, String, String>> _right_5 = bt.getRight();
              Object _solverExpression_11 = TestDataGeneration2.toSolverExpression(pb, _right_5, outcome);
              _xifexpression_3 = pb.eq(_solverExpression_10, _solverExpression_11);
            }
            _switchResult = _xifexpression_3;
          }
        }
        if (!_matched) {
          if (Objects.equal(operator, "!=")) {
            _matched=true;
            Object _xifexpression_4 = null;
            if ((outcome == false)) {
              BinaryTree<Triplet<String, String, String>> _left_6 = bt.getLeft();
              Object _solverExpression_12 = TestDataGeneration2.toSolverExpression(pb, _left_6, outcome);
              BinaryTree<Triplet<String, String, String>> _right_6 = bt.getRight();
              Object _solverExpression_13 = TestDataGeneration2.toSolverExpression(pb, _right_6, outcome);
              _xifexpression_4 = pb.eq(_solverExpression_12, _solverExpression_13);
            } else {
              BinaryTree<Triplet<String, String, String>> _left_7 = bt.getLeft();
              Object _solverExpression_14 = TestDataGeneration2.toSolverExpression(pb, _left_7, outcome);
              BinaryTree<Triplet<String, String, String>> _right_7 = bt.getRight();
              Object _solverExpression_15 = TestDataGeneration2.toSolverExpression(pb, _right_7, outcome);
              _xifexpression_4 = pb.neq(_solverExpression_14, _solverExpression_15);
            }
            _switchResult = _xifexpression_4;
          }
        }
        if (!_matched) {
          if (Objects.equal(operator, "<=")) {
            _matched=true;
            Object _xifexpression_5 = null;
            if ((outcome == false)) {
              BinaryTree<Triplet<String, String, String>> _left_8 = bt.getLeft();
              Object _solverExpression_16 = TestDataGeneration2.toSolverExpression(pb, _left_8, outcome);
              BinaryTree<Triplet<String, String, String>> _right_8 = bt.getRight();
              Object _solverExpression_17 = TestDataGeneration2.toSolverExpression(pb, _right_8, outcome);
              _xifexpression_5 = pb.gt(_solverExpression_16, _solverExpression_17);
            } else {
              BinaryTree<Triplet<String, String, String>> _left_9 = bt.getLeft();
              Object _solverExpression_18 = TestDataGeneration2.toSolverExpression(pb, _left_9, outcome);
              BinaryTree<Triplet<String, String, String>> _right_9 = bt.getRight();
              Object _solverExpression_19 = TestDataGeneration2.toSolverExpression(pb, _right_9, outcome);
              _xifexpression_5 = pb.leq(_solverExpression_18, _solverExpression_19);
            }
            _switchResult = _xifexpression_5;
          }
        }
        if (!_matched) {
          if (Objects.equal(operator, ">=")) {
            _matched=true;
            Object _xifexpression_6 = null;
            if ((outcome == false)) {
              BinaryTree<Triplet<String, String, String>> _left_10 = bt.getLeft();
              Object _solverExpression_20 = TestDataGeneration2.toSolverExpression(pb, _left_10, outcome);
              BinaryTree<Triplet<String, String, String>> _right_10 = bt.getRight();
              Object _solverExpression_21 = TestDataGeneration2.toSolverExpression(pb, _right_10, outcome);
              _xifexpression_6 = pb.lt(_solverExpression_20, _solverExpression_21);
            } else {
              BinaryTree<Triplet<String, String, String>> _left_11 = bt.getLeft();
              Object _solverExpression_22 = TestDataGeneration2.toSolverExpression(pb, _left_11, outcome);
              BinaryTree<Triplet<String, String, String>> _right_11 = bt.getRight();
              Object _solverExpression_23 = TestDataGeneration2.toSolverExpression(pb, _right_11, outcome);
              _xifexpression_6 = pb.geq(_solverExpression_22, _solverExpression_23);
            }
            _switchResult = _xifexpression_6;
          }
        }
        if (!_matched) {
          if (Objects.equal(operator, "<")) {
            _matched=true;
            Object _xifexpression_7 = null;
            if ((outcome == false)) {
              BinaryTree<Triplet<String, String, String>> _left_12 = bt.getLeft();
              Object _solverExpression_24 = TestDataGeneration2.toSolverExpression(pb, _left_12, outcome);
              BinaryTree<Triplet<String, String, String>> _right_12 = bt.getRight();
              Object _solverExpression_25 = TestDataGeneration2.toSolverExpression(pb, _right_12, outcome);
              _xifexpression_7 = pb.geq(_solverExpression_24, _solverExpression_25);
            } else {
              BinaryTree<Triplet<String, String, String>> _left_13 = bt.getLeft();
              Object _solverExpression_26 = TestDataGeneration2.toSolverExpression(pb, _left_13, outcome);
              BinaryTree<Triplet<String, String, String>> _right_13 = bt.getRight();
              Object _solverExpression_27 = TestDataGeneration2.toSolverExpression(pb, _right_13, outcome);
              _xifexpression_7 = pb.lt(_solverExpression_26, _solverExpression_27);
            }
            _switchResult = _xifexpression_7;
          }
        }
        if (!_matched) {
          if (Objects.equal(operator, ">")) {
            _matched=true;
            Object _xifexpression_8 = null;
            if ((outcome == false)) {
              BinaryTree<Triplet<String, String, String>> _left_14 = bt.getLeft();
              Object _solverExpression_28 = TestDataGeneration2.toSolverExpression(pb, _left_14, outcome);
              BinaryTree<Triplet<String, String, String>> _right_14 = bt.getRight();
              Object _solverExpression_29 = TestDataGeneration2.toSolverExpression(pb, _right_14, outcome);
              _xifexpression_8 = pb.leq(_solverExpression_28, _solverExpression_29);
            } else {
              BinaryTree<Triplet<String, String, String>> _left_15 = bt.getLeft();
              Object _solverExpression_30 = TestDataGeneration2.toSolverExpression(pb, _left_15, outcome);
              BinaryTree<Triplet<String, String, String>> _right_15 = bt.getRight();
              Object _solverExpression_31 = TestDataGeneration2.toSolverExpression(pb, _right_15, outcome);
              _xifexpression_8 = pb.gt(_solverExpression_30, _solverExpression_31);
            }
            _switchResult = _xifexpression_8;
          }
        }
        if (!_matched) {
          if (Objects.equal(operator, "+")) {
            _matched=true;
            BinaryTree<Triplet<String, String, String>> _left_16 = bt.getLeft();
            Object _solverExpression_32 = TestDataGeneration2.toSolverExpression(pb, _left_16, outcome);
            BinaryTree<Triplet<String, String, String>> _right_16 = bt.getRight();
            Object _solverExpression_33 = TestDataGeneration2.toSolverExpression(pb, _right_16, outcome);
            _switchResult = pb.plus(_solverExpression_32, _solverExpression_33);
          }
        }
        if (!_matched) {
          if (Objects.equal(operator, "-")) {
            _matched=true;
            BinaryTree<Triplet<String, String, String>> _left_17 = bt.getLeft();
            Object _solverExpression_34 = TestDataGeneration2.toSolverExpression(pb, _left_17, outcome);
            BinaryTree<Triplet<String, String, String>> _right_17 = bt.getRight();
            Object _solverExpression_35 = TestDataGeneration2.toSolverExpression(pb, _right_17, outcome);
            _switchResult = pb.minus(_solverExpression_34, _solverExpression_35);
          }
        }
        if (!_matched) {
          if (Objects.equal(operator, "*")) {
            _matched=true;
            BinaryTree<Triplet<String, String, String>> _left_18 = bt.getLeft();
            Object _solverExpression_36 = TestDataGeneration2.toSolverExpression(pb, _left_18, outcome);
            BinaryTree<Triplet<String, String, String>> _right_18 = bt.getRight();
            Object _solverExpression_37 = TestDataGeneration2.toSolverExpression(pb, _right_18, outcome);
            _switchResult = pb.mult(_solverExpression_36, _solverExpression_37);
          }
        }
        if (!_matched) {
          if (Objects.equal(operator, "/")) {
            _matched=true;
            BinaryTree<Triplet<String, String, String>> _left_19 = bt.getLeft();
            Object _solverExpression_38 = TestDataGeneration2.toSolverExpression(pb, _left_19, outcome);
            BinaryTree<Triplet<String, String, String>> _right_19 = bt.getRight();
            Object _solverExpression_39 = TestDataGeneration2.toSolverExpression(pb, _right_19, outcome);
            _switchResult = pb.div(_solverExpression_38, _solverExpression_39);
          }
        }
        if (!_matched) {
          if (Objects.equal(operator, "%")) {
            _matched=true;
            BinaryTree<Triplet<String, String, String>> _left_20 = bt.getLeft();
            Object _solverExpression_40 = TestDataGeneration2.toSolverExpression(pb, _left_20, outcome);
            BinaryTree<Triplet<String, String, String>> _right_20 = bt.getRight();
            Object _solverExpression_41 = TestDataGeneration2.toSolverExpression(pb, _right_20, outcome);
            _switchResult = pb.mod(_solverExpression_40, _solverExpression_41);
          }
        }
        if (!_matched) {
          Object _xblockexpression_3 = null;
          {
            final String nameOrValue = operator;
            final String ident = btValue.getSecond();
            final String type = btValue.getThird();
            Object _xifexpression_9 = null;
            boolean _notEquals = (!Objects.equal(nameOrValue, ""));
            if (_notEquals) {
              Object _xifexpression_10 = null;
              boolean _notEquals_1 = (!Objects.equal(ident, ""));
              if (_notEquals_1) {
                Object _xblockexpression_4 = null;
                {
                  final String ssaName = TestDataGeneration2.addSSAIndex(nameOrValue, ident);
                  _xblockexpression_4 = TestDataGeneration2.manageVariables(pb, ssaName, type);
                }
                _xifexpression_10 = _xblockexpression_4;
              } else {
                _xifexpression_10 = TestDataGeneration2.manageConstants(pb, nameOrValue, type);
              }
              _xifexpression_9 = _xifexpression_10;
            } else {
              throw new Exception(" #### Incorrect expression type #### ");
            }
            _xblockexpression_3 = _xifexpression_9;
          }
          _switchResult = _xblockexpression_3;
        }
        _xblockexpression = _switchResult;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Deal with variable creation in the solver
   */
  private static Object manageVariables(final ProblemJacop pb, final String ssaVarName, final String varType) {
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(varType, "int")) {
        _matched=true;
        boolean _containsKey = TestDataGeneration2.intVars.containsKey(ssaVarName);
        if (_containsKey) {
          return TestDataGeneration2.intVars.get(ssaVarName);
        } else {
          final Object value = pb.makeIntVar(ssaVarName);
          final Object putValue = TestDataGeneration2.intVars.put(ssaVarName, value);
          return value;
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(varType, "real")) {
        _matched=true;
        boolean _containsKey_1 = TestDataGeneration2.doubleVars.containsKey(ssaVarName);
        if (_containsKey_1) {
          return TestDataGeneration2.doubleVars.get(ssaVarName);
        } else {
          final Object value_1 = pb.makeRealVar(ssaVarName);
          final Object putValue_1 = TestDataGeneration2.doubleVars.put(ssaVarName, value_1);
          return value_1;
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(varType, "enum")) {
        _matched=true;
        boolean _containsKey_2 = TestDataGeneration2.intVars.containsKey(ssaVarName);
        if (_containsKey_2) {
          return TestDataGeneration2.intVars.get(ssaVarName);
        } else {
          final Object enumVar = pb.makeIntVar(ssaVarName);
          final Object putValue_2 = TestDataGeneration2.intVars.put(ssaVarName, enumVar);
          return enumVar;
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(varType, "bool")) {
        _matched=true;
        throw new RuntimeException(" #### Jacop does not handle boolean constraint #### ");
      }
    }
    if (!_matched) {
      if (Objects.equal(varType, "str")) {
        _matched=true;
        throw new UnsupportedOperationException(" #### Jacop does not handle string constraint #### ");
      }
    }
    if (!_matched) {
      if (Objects.equal(varType, "hex")) {
        _matched=true;
        throw new UnsupportedOperationException(" #### Jacop does not handle hexadecimal constraint #### ");
      }
    }
    if (!_matched) {
      if (Objects.equal(varType, "bit")) {
        _matched=true;
        throw new UnsupportedOperationException(" #### Jacop does not handle bit constraint #### ");
      }
    }
    throw new RuntimeException((((((" #### Incorrect operation type #### " + 
      "variable name: ") + ssaVarName) + " ") + "variable type: ") + varType));
  }
  
  /**
   * Deal with constants creation in the solver
   */
  private static Number manageConstants(final ProblemJacop pb, final String value, final String type) {
    Number _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(type, "c_int")) {
        _matched=true;
        _switchResult = Integer.valueOf(DslUtils.parseInt(value));
      }
    }
    if (!_matched) {
      if (Objects.equal(type, "c_real")) {
        _matched=true;
        _switchResult = Double.valueOf(DslUtils.parseDouble(value));
      }
    }
    if (!_matched) {
      if (Objects.equal(type, "c_enum")) {
        _matched=true;
        final String[] split = value.split("@");
        final String enumVar = split[0];
        final String enumValue = split[1];
        return Integer.valueOf(TestDataGeneration2.getIndexOfEnumValue(enumVar, enumValue));
      }
    }
    if (!_matched) {
      if (Objects.equal(type, "c_bool")) {
        _matched=true;
        throw new UnsupportedOperationException(" #### bool not supported #### ");
      }
    }
    if (!_matched) {
      if (Objects.equal(type, "c_bit")) {
        _matched=true;
        throw new UnsupportedOperationException(" #### bit not supported yet #### ");
      }
    }
    if (!_matched) {
      if (Objects.equal(type, "c_hex")) {
        _matched=true;
        throw new UnsupportedOperationException(" #### hexadecimal not supported yet  #### ");
      }
    }
    if (!_matched) {
      if (Objects.equal(type, "c_str")) {
        _matched=true;
        throw new UnsupportedOperationException(" #### string not supported yet  #### ");
      }
    }
    return _switchResult;
  }
  
  /**
   * Put dsl interface variables in maps as follows: dsl input variables are stored into the inVarsMap map and
   * the output variables are stored into the outVarsMap map.
   */
  public static void collectDslVariables(final MODULE_DECL module, final Map<String, Object> inVarsMap, final Map<String, Object> outVarsMap) {
    INTERFACE _interface = module.getInterface();
    EList<AbstractVAR_DECL> _declaration = _interface.getDeclaration();
    final Iterable<VAR_DECL> listOfVariables = Iterables.<VAR_DECL>filter(_declaration, VAR_DECL.class);
    inVarsMap.clear();
    outVarsMap.clear();
    final Procedure1<VAR_DECL> _function = new Procedure1<VAR_DECL>() {
      public void apply(final VAR_DECL variable) {
        final String name = variable.getName();
        Flow _flow = variable.getFlow();
        final String flow = _flow.getFlow();
        boolean _equals = Objects.equal(flow, "in");
        if (_equals) {
          inVarsMap.put(name, variable);
        } else {
          boolean _equals_1 = Objects.equal(flow, "out");
          if (_equals_1) {
            outVarsMap.put(name, variable);
          } else {
            boolean _equals_2 = Objects.equal(flow, "inout");
            if (_equals_2) {
              inVarsMap.put(name, variable);
              outVarsMap.put(name, variable);
            }
          }
        }
      }
    };
    IterableExtensions.<VAR_DECL>forEach(listOfVariables, _function);
  }
  
  private static ArrayList<Triplet<String, String, String>> recordSolutions(final ProblemJacop pb, final Map<String, Object> solverVarsMap, final Map<String, Object> dslVarsMap, final String flow) {
    final ArrayList<Triplet<String, String, String>> solutionsList = new ArrayList<Triplet<String, String, String>>();
    Set<String> _keySet = solverVarsMap.keySet();
    final Procedure1<String> _function = new Procedure1<String>() {
      public void apply(final String varSSAname) {
        final String varName = TestDataGeneration2.removeSSAindex(varSSAname);
        Object _get = dslVarsMap.get(varName);
        final VAR_DECL dslVariable = ((VAR_DECL) _get);
        TYPE _type = dslVariable.getType();
        final String varType = _type.getType();
        boolean _matched = false;
        if (!_matched) {
          if (Objects.equal(varType, "int")) {
            _matched=true;
            Object _get_1 = solverVarsMap.get(varSSAname);
            final IntVar solverVar = ((IntVar) _get_1);
            int _value = solverVar.value();
            String _string = Integer.valueOf(_value).toString();
            Triplet<String, String, String> _triplet = new Triplet<String, String, String>(flow, varName, _string);
            solutionsList.add(_triplet);
          }
        }
        if (!_matched) {
          if (Objects.equal(varType, "real")) {
            _matched=true;
            Object _get_2 = solverVarsMap.get(varSSAname);
            final FloatVar solverVar_1 = ((FloatVar) _get_2);
            double _value_1 = solverVar_1.value();
            String _string_1 = Double.valueOf(_value_1).toString();
            Triplet<String, String, String> _triplet_1 = new Triplet<String, String, String>(flow, varName, _string_1);
            solutionsList.add(_triplet_1);
          }
        }
        if (!_matched) {
          if (Objects.equal(varType, "enum")) {
            _matched=true;
            Object _get_3 = solverVarsMap.get(varSSAname);
            final IntVar solverEnumVar = ((IntVar) _get_3);
            RANGE _range = dslVariable.getRange();
            EList<Literal> _value_2 = ((LSET) _range).getValue();
            int _value_3 = solverEnumVar.value();
            final Literal enumSolution = _value_2.get(_value_3);
            String _literalValue = DslUtils.literalValue(enumSolution);
            Triplet<String, String, String> _triplet_2 = new Triplet<String, String, String>(flow, varName, _literalValue);
            solutionsList.add(_triplet_2);
          }
        }
        if (!_matched) {
        }
      }
    };
    IterableExtensions.<String>forEach(_keySet, _function);
    return solutionsList;
  }
  
  private static ArrayList<String> getIdSequence(final List<Couple<String, String>> testSeq, final String id) {
    try {
      for (final Couple<String, String> test : testSeq) {
        {
          final String testId = test.getSecond();
          boolean _equals = Objects.equal(testId, id);
          if (_equals) {
            String _first = test.getFirst();
            return DslUtils.toStringArray(_first);
          }
        }
      }
      throw new Exception("#### Associated sequence not found ####");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static String addSSAIndex(final String varName, final String index) {
    return (((varName + "|") + index) + "|");
  }
  
  private static String removeSSAindex(final String ssaName) {
    final String[] split = ssaName.split(TestDataGeneration2.splitPattern);
    return split[0];
  }
  
  /**
   * Return the position of an enumeration value listed in the enumeration variable list
   */
  private static int getIndexOfEnumValue(final String enumVar, final String enumValue) {
    try {
      int index = (-1);
      Object variable = TestDataGeneration2.dslInVars.get(enumVar);
      boolean _equals = Objects.equal(variable, null);
      if (_equals) {
        Object _get = TestDataGeneration2.dslOutVars.get(enumVar);
        variable = _get;
      }
      RANGE _range = ((VAR_DECL) variable).getRange();
      final EList<Literal> list = ((LSET) _range).getValue();
      for (final Literal e : list) {
        {
          index = (index + 1);
          String _literalValue = DslUtils.literalValue(e);
          boolean _equals_1 = Objects.equal(_literalValue, enumValue);
          if (_equals_1) {
            return index;
          }
        }
      }
      throw new Exception("#### Index not found ####");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Return a set of Boolean conditions that get involved in the Boolean expression represented by the Binary tree
   */
  public static ArrayList<BinaryTree<Triplet<String, String, String>>> booleanConditions(final BinaryTree<Triplet<String, String, String>> bt) {
    final ArrayList<BinaryTree<Triplet<String, String, String>>> boolVarsList = new ArrayList<BinaryTree<Triplet<String, String, String>>>();
    TestDataGeneration2.booleanConditions(bt, boolVarsList);
    return boolVarsList;
  }
  
  private static void booleanConditions(final BinaryTree<Triplet<String, String, String>> bt, final List<BinaryTree<Triplet<String, String, String>>> boolVars) {
    final Triplet<String, String, String> btValue = bt.getValue();
    final String operator = btValue.getFirst();
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(operator, "OR")) {
        _matched=true;
        BinaryTree<Triplet<String, String, String>> _left = bt.getLeft();
        TestDataGeneration2.booleanConditions(_left, boolVars);
        BinaryTree<Triplet<String, String, String>> _right = bt.getRight();
        TestDataGeneration2.booleanConditions(_right, boolVars);
      }
    }
    if (!_matched) {
      if (Objects.equal(operator, "AND")) {
        _matched=true;
        BinaryTree<Triplet<String, String, String>> _left_1 = bt.getLeft();
        TestDataGeneration2.booleanConditions(_left_1, boolVars);
        BinaryTree<Triplet<String, String, String>> _right_1 = bt.getRight();
        TestDataGeneration2.booleanConditions(_right_1, boolVars);
      }
    }
    if (!_matched) {
      if (Objects.equal(operator, "NOT")) {
        _matched=true;
        BinaryTree<Triplet<String, String, String>> _right_2 = bt.getRight();
        TestDataGeneration2.booleanConditions(_right_2, boolVars);
      }
    }
    if (!_matched) {
      if (Objects.equal(operator, "==")) {
        _matched=true;
        boolVars.add(bt);
      }
    }
    if (!_matched) {
      if (Objects.equal(operator, "!=")) {
        _matched=true;
        boolVars.add(bt);
      }
    }
    if (!_matched) {
      if (Objects.equal(operator, "<")) {
        _matched=true;
        boolVars.add(bt);
      }
    }
    if (!_matched) {
      if (Objects.equal(operator, "<=")) {
        _matched=true;
        boolVars.add(bt);
      }
    }
    if (!_matched) {
      if (Objects.equal(operator, ">")) {
        _matched=true;
        boolVars.add(bt);
      }
    }
    if (!_matched) {
      if (Objects.equal(operator, ">=")) {
        _matched=true;
        boolVars.add(bt);
      }
    }
    if (!_matched) {
      {
        final String ssaIdent = btValue.getSecond();
        final String varType = btValue.getThird();
        boolean _and = false;
        boolean _notEquals = (!Objects.equal(ssaIdent, ""));
        if (!_notEquals) {
          _and = false;
        } else {
          boolean _equals = Objects.equal(varType, "bool");
          _and = _equals;
        }
        if (_and) {
          boolVars.add(bt);
        } else {
        }
      }
    }
  }
  
  /**
   * Check whether or not, a Boolean condition is relational
   */
  public static boolean isRelationalCondition(final BinaryTree<Triplet<String, String, String>> bt) {
    try {
      final Triplet<String, String, String> btValue = bt.getValue();
      final String type = btValue.getThird();
      boolean _or = false;
      boolean _equals = Objects.equal(type, "bool");
      if (_equals) {
        _or = true;
      } else {
        boolean _equals_1 = Objects.equal(type, "c_bool");
        _or = _equals_1;
      }
      if (_or) {
        boolean _and = false;
        BinaryTree<Triplet<String, String, String>> _left = bt.getLeft();
        boolean _isEmpty = _left.isEmpty();
        if (!_isEmpty) {
          _and = false;
        } else {
          BinaryTree<Triplet<String, String, String>> _right = bt.getRight();
          boolean _isEmpty_1 = _right.isEmpty();
          _and = _isEmpty_1;
        }
        if (_and) {
          String _second = btValue.getSecond();
          boolean _notEquals = (!Objects.equal(_second, ""));
          if (_notEquals) {
            return false;
          } else {
            throw new Exception("#### incorrect boolean condition ####");
          }
        } else {
          boolean _and_1 = false;
          BinaryTree<Triplet<String, String, String>> _left_1 = bt.getLeft();
          boolean _isEmpty_2 = _left_1.isEmpty();
          boolean _not = (!_isEmpty_2);
          if (!_not) {
            _and_1 = false;
          } else {
            BinaryTree<Triplet<String, String, String>> _right_1 = bt.getRight();
            boolean _isEmpty_3 = _right_1.isEmpty();
            boolean _not_1 = (!_isEmpty_3);
            _and_1 = _not_1;
          }
          if (_and_1) {
            return true;
          } else {
            throw new Exception("#### incorrect boolean condition ####");
          }
        }
      } else {
        throw new Exception("#### Not a boolean condition ####");
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Return a string representation of the Binary tree
   */
  public static String stringRepr(final BinaryTree<Triplet<String, String, String>> bt) {
    String _xifexpression = null;
    boolean _isEmpty = bt.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      String _xifexpression_1 = null;
      boolean _isLeaf = bt.isLeaf();
      boolean _not_1 = (!_isLeaf);
      if (_not_1) {
        BinaryTree<Triplet<String, String, String>> _left = bt.getLeft();
        String _stringRepr = TestDataGeneration2.stringRepr(_left);
        String _plus = ("(" + _stringRepr);
        Triplet<String, String, String> _value = bt.getValue();
        String _first = _value.getFirst();
        String _plus_1 = (_plus + _first);
        BinaryTree<Triplet<String, String, String>> _right = bt.getRight();
        String _stringRepr_1 = TestDataGeneration2.stringRepr(_right);
        String _plus_2 = (_plus_1 + _stringRepr_1);
        _xifexpression_1 = (_plus_2 + ")");
      } else {
        final Triplet<String, String, String> btValue = bt.getValue();
        String _first_1 = btValue.getFirst();
        String _second = btValue.getSecond();
        return (_first_1 + _second);
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  private static String addPathID(final String ident, final String pathID) {
    return ((ident + "@") + pathID);
  }
  
  private static HashMap<String, Object> dslOutVarsWithSSAindexes(final Map<String, Object> dlsOutVars, final Map<String, Object> intVars, final Map<String, Object> doubleVars) {
    final Set<String> intKeys = intVars.keySet();
    final Set<String> doubleKeys = doubleVars.keySet();
    final Set<String> dslVarsKeys = dlsOutVars.keySet();
    final HashMap<String, Object> map = new HashMap<String, Object>();
    final Procedure1<String> _function = new Procedure1<String>() {
      public void apply(final String dslVarName) {
        try {
          Object _get = dlsOutVars.get(dslVarName);
          final VAR_DECL dslVar = ((VAR_DECL) _get);
          TYPE _type = dslVar.getType();
          final String dslVarType = _type.getType();
          Flow _flow = dslVar.getFlow();
          final String dslVarFlow = _flow.getFlow();
          boolean _or = false;
          boolean _equals = Objects.equal(dslVarFlow, "out");
          if (_equals) {
            _or = true;
          } else {
            boolean _equals_1 = Objects.equal(dslVarFlow, "inout");
            _or = _equals_1;
          }
          if (_or) {
            boolean _or_1 = false;
            boolean _equals_2 = Objects.equal(dslVarType, "int");
            if (_equals_2) {
              _or_1 = true;
            } else {
              boolean _equals_3 = Objects.equal(dslVarType, "enum");
              _or_1 = _equals_3;
            }
            if (_or_1) {
              final String ssaName = TestDataGeneration2.dslOutVarWithHighestIndex(dslVarName, intKeys);
              boolean _notEquals = (!Objects.equal(ssaName, ""));
              if (_notEquals) {
                Object _get_1 = intVars.get(ssaName);
                map.put(ssaName, _get_1);
              }
            } else {
              boolean _equals_4 = Objects.equal(dslVarType, "real");
              if (_equals_4) {
                final String ssaName_1 = TestDataGeneration2.dslOutVarWithHighestIndex(dslVarName, doubleKeys);
                boolean _notEquals_1 = (!Objects.equal(ssaName_1, ""));
                if (_notEquals_1) {
                  Object _get_2 = doubleVars.get(ssaName_1);
                  map.put(ssaName_1, _get_2);
                }
              } else {
                throw new UnsupportedOperationException(((" #### Type " + dslVarType) + " not supported #### "));
              }
            }
          } else {
            throw new Exception(" #### Incorrect or Unsupported variable\'s flow #### ");
          }
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    IterableExtensions.<String>forEach(dslVarsKeys, _function);
    return map;
  }
  
  private static String dslOutVarWithHighestIndex(final String dslOutVarName, final Set<String> ssaVarsNames) {
    String highestIndexVar = "";
    int tmpIndex = (-1);
    for (final String ssaName : ssaVarsNames) {
      {
        final String[] split = ssaName.split(TestDataGeneration2.splitPattern);
        final String name = split[0];
        final String index = split[1];
        boolean _equals = Objects.equal(dslOutVarName, name);
        if (_equals) {
          final int indexValue = DslUtils.parseInt(index);
          if ((indexValue > tmpIndex)) {
            highestIndexVar = ssaName;
            tmpIndex = indexValue;
          }
        }
      }
    }
    return highestIndexVar;
  }
}
