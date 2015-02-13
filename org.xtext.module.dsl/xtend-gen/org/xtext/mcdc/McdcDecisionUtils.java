package org.xtext.mcdc;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.xtext.helper.Couple;
import org.xtext.moduleDsl.ADD;
import org.xtext.moduleDsl.AND;
import org.xtext.moduleDsl.AbstractVAR_DECL;
import org.xtext.moduleDsl.COMPARISON;
import org.xtext.moduleDsl.DIV;
import org.xtext.moduleDsl.EQUAL_DIFF;
import org.xtext.moduleDsl.EXPRESSION;
import org.xtext.moduleDsl.INTERFACE;
import org.xtext.moduleDsl.LSET;
import org.xtext.moduleDsl.Literal;
import org.xtext.moduleDsl.MODULE_DECL;
import org.xtext.moduleDsl.MODULO;
import org.xtext.moduleDsl.MULT;
import org.xtext.moduleDsl.NOT;
import org.xtext.moduleDsl.OR;
import org.xtext.moduleDsl.RANGE;
import org.xtext.moduleDsl.SUB;
import org.xtext.moduleDsl.VAR_DECL;
import org.xtext.moduleDsl.VarExpRef;
import org.xtext.moduleDsl.bitConstant;
import org.xtext.moduleDsl.boolConstant;
import org.xtext.moduleDsl.enumConstant;
import org.xtext.moduleDsl.hexConstant;
import org.xtext.moduleDsl.intConstant;
import org.xtext.moduleDsl.realConstant;
import org.xtext.moduleDsl.strConstant;
import org.xtext.solver.ProblemCoral;
import org.xtext.solver.SoverUtils;
import org.xtext.type.provider.ExpressionsTypeProvider;
import org.xtext.utils.DslUtils;

@SuppressWarnings("all")
public class McdcDecisionUtils {
  private final static HashMap<String, Object> intVars = new HashMap<String, Object>();
  
  private final static HashMap<String, Object> doubleVars = new HashMap<String, Object>();
  
  private final static HashMap<String, Object> dslVars = new HashMap<String, Object>();
  
  private final static int IMIN = (-100);
  
  private final static int IMAX = 100;
  
  private final static double DMIN = (-100.0);
  
  private final static double DMAX = 100.0;
  
  public static ArrayList<Couple<String, Integer>> discardInfeasibleTests(final EXPRESSION expression, final List<Couple<String, Integer>> testValues) {
    final ArrayList<Couple<String, Integer>> newfeasibleTests = new ArrayList<Couple<String, Integer>>();
    final ArrayList<EXPRESSION> booleanConditions = DslUtils.booleanConditions(expression);
    MODULE_DECL _containerOfType = EcoreUtil2.<MODULE_DECL>getContainerOfType(expression, MODULE_DECL.class);
    McdcDecisionUtils.recordDslVariables(_containerOfType, McdcDecisionUtils.dslVars);
    final Procedure1<Couple<String, Integer>> _function = new Procedure1<Couple<String, Integer>>() {
      public void apply(final Couple<String, Integer> couple) {
        final String testValue = couple.getFirst();
        final ArrayList<String> conditionsValues = DslUtils.toStringArray(testValue);
        ProblemCoral.configure();
        final ProblemCoral pb = new ProblemCoral();
        final Procedure2<EXPRESSION, Integer> _function = new Procedure2<EXPRESSION, Integer>() {
          public void apply(final EXPRESSION boolCondition, final Integer i) {
            boolean _isRelationalondition = McdcDecisionUtils.isRelationalondition(boolCondition);
            if (_isRelationalondition) {
              final String condValue = conditionsValues.get((i).intValue());
              boolean _boolValue = DslUtils.boolValue(condValue);
              final Object constraint = McdcDecisionUtils.toSolverExpression(pb, boolCondition, _boolValue);
              pb.post(constraint);
            } else {
              final Object constraint_1 = pb.makeBoolConstant(Boolean.valueOf(true));
              pb.post(constraint_1);
            }
          }
        };
        IterableExtensions.<EXPRESSION>forEach(booleanConditions, _function);
        SoverUtils.setRangeConstraints(pb, McdcDecisionUtils.dslVars, McdcDecisionUtils.intVars, McdcDecisionUtils.doubleVars);
        final int solve = pb.solve();
        if ((solve == 1)) {
          newfeasibleTests.add(couple);
        }
        pb.cleanup();
        McdcDecisionUtils.intVars.clear();
        McdcDecisionUtils.doubleVars.clear();
      }
    };
    IterableExtensions.<Couple<String, Integer>>forEach(testValues, _function);
    return newfeasibleTests;
  }
  
  private static boolean isRelationalondition(final EXPRESSION expression) {
    String _typeFor = ExpressionsTypeProvider.typeFor(expression);
    boolean _equals = Objects.equal(_typeFor, "bool");
    if (_equals) {
      boolean _or = false;
      if ((expression instanceof EQUAL_DIFF)) {
        _or = true;
      } else {
        _or = (expression instanceof COMPARISON);
      }
      if (_or) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * Transform a relational condition into a Coral solver constraint
   */
  private static Object toSolverExpression(final ProblemCoral pb, final EXPRESSION expression, final boolean outcome) {
    Object _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (expression instanceof OR) {
        _matched=true;
        Object _xifexpression = null;
        if ((outcome == false)) {
          EXPRESSION _left = ((OR)expression).getLeft();
          Object _solverExpression = McdcDecisionUtils.toSolverExpression(pb, _left, outcome);
          EXPRESSION _right = ((OR)expression).getRight();
          Object _solverExpression_1 = McdcDecisionUtils.toSolverExpression(pb, _right, outcome);
          _xifexpression = pb.and(_solverExpression, _solverExpression_1);
        } else {
          EXPRESSION _left_1 = ((OR)expression).getLeft();
          Object _solverExpression_2 = McdcDecisionUtils.toSolverExpression(pb, _left_1, outcome);
          EXPRESSION _right_1 = ((OR)expression).getRight();
          Object _solverExpression_3 = McdcDecisionUtils.toSolverExpression(pb, _right_1, outcome);
          _xifexpression = pb.or(_solverExpression_2, _solverExpression_3);
        }
        _switchResult = _xifexpression;
      }
    }
    if (!_matched) {
      if (expression instanceof AND) {
        _matched=true;
        Object _xifexpression = null;
        if ((outcome == false)) {
          EXPRESSION _left = ((AND)expression).getLeft();
          Object _solverExpression = McdcDecisionUtils.toSolverExpression(pb, _left, outcome);
          EXPRESSION _right = ((AND)expression).getRight();
          Object _solverExpression_1 = McdcDecisionUtils.toSolverExpression(pb, _right, outcome);
          _xifexpression = pb.or(_solverExpression, _solverExpression_1);
        } else {
          EXPRESSION _left_1 = ((AND)expression).getLeft();
          Object _solverExpression_2 = McdcDecisionUtils.toSolverExpression(pb, _left_1, outcome);
          EXPRESSION _right_1 = ((AND)expression).getRight();
          Object _solverExpression_3 = McdcDecisionUtils.toSolverExpression(pb, _right_1, outcome);
          _xifexpression = pb.and(_solverExpression_2, _solverExpression_3);
        }
        _switchResult = _xifexpression;
      }
    }
    if (!_matched) {
      if (expression instanceof NOT) {
        _matched=true;
        Object _xifexpression = null;
        if ((outcome == false)) {
          Object _xblockexpression = null;
          {
            boolean new_invert = true;
            EXPRESSION _exp = ((NOT)expression).getExp();
            _xblockexpression = McdcDecisionUtils.toSolverExpression(pb, _exp, new_invert);
          }
          _xifexpression = _xblockexpression;
        } else {
          Object _xblockexpression_1 = null;
          {
            boolean new_invert = false;
            EXPRESSION _exp = ((NOT)expression).getExp();
            _xblockexpression_1 = McdcDecisionUtils.toSolverExpression(pb, _exp, new_invert);
          }
          _xifexpression = _xblockexpression_1;
        }
        _switchResult = _xifexpression;
      }
    }
    if (!_matched) {
      if (expression instanceof EQUAL_DIFF) {
        _matched=true;
        Object _xifexpression = null;
        String _op = ((EQUAL_DIFF)expression).getOp();
        boolean _equals = Objects.equal(_op, "==");
        if (_equals) {
          Object _xifexpression_1 = null;
          if ((outcome == false)) {
            EXPRESSION _left = ((EQUAL_DIFF)expression).getLeft();
            Object _solverExpression = McdcDecisionUtils.toSolverExpression(pb, _left, outcome);
            EXPRESSION _right = ((EQUAL_DIFF)expression).getRight();
            Object _solverExpression_1 = McdcDecisionUtils.toSolverExpression(pb, _right, outcome);
            _xifexpression_1 = pb.neq(_solverExpression, _solverExpression_1);
          } else {
            EXPRESSION _left_1 = ((EQUAL_DIFF)expression).getLeft();
            Object _solverExpression_2 = McdcDecisionUtils.toSolverExpression(pb, _left_1, outcome);
            EXPRESSION _right_1 = ((EQUAL_DIFF)expression).getRight();
            Object _solverExpression_3 = McdcDecisionUtils.toSolverExpression(pb, _right_1, outcome);
            _xifexpression_1 = pb.eq(_solverExpression_2, _solverExpression_3);
          }
          _xifexpression = _xifexpression_1;
        } else {
          Object _xifexpression_2 = null;
          if ((outcome == false)) {
            EXPRESSION _left_2 = ((EQUAL_DIFF)expression).getLeft();
            Object _solverExpression_4 = McdcDecisionUtils.toSolverExpression(pb, _left_2, outcome);
            EXPRESSION _right_2 = ((EQUAL_DIFF)expression).getRight();
            Object _solverExpression_5 = McdcDecisionUtils.toSolverExpression(pb, _right_2, outcome);
            _xifexpression_2 = pb.eq(_solverExpression_4, _solverExpression_5);
          } else {
            EXPRESSION _left_3 = ((EQUAL_DIFF)expression).getLeft();
            Object _solverExpression_6 = McdcDecisionUtils.toSolverExpression(pb, _left_3, outcome);
            EXPRESSION _right_3 = ((EQUAL_DIFF)expression).getRight();
            Object _solverExpression_7 = McdcDecisionUtils.toSolverExpression(pb, _right_3, outcome);
            _xifexpression_2 = pb.neq(_solverExpression_6, _solverExpression_7);
          }
          _xifexpression = _xifexpression_2;
        }
        _switchResult = _xifexpression;
      }
    }
    if (!_matched) {
      if (expression instanceof COMPARISON) {
        _matched=true;
        Object _xblockexpression = null;
        {
          final String operator = ((COMPARISON)expression).getOp();
          Object _switchResult_1 = null;
          boolean _matched_1 = false;
          if (!_matched_1) {
            if (Objects.equal(operator, "<=")) {
              _matched_1=true;
              Object _xifexpression = null;
              if ((outcome == false)) {
                EXPRESSION _left = ((COMPARISON)expression).getLeft();
                Object _solverExpression = McdcDecisionUtils.toSolverExpression(pb, _left, outcome);
                EXPRESSION _right = ((COMPARISON)expression).getRight();
                Object _solverExpression_1 = McdcDecisionUtils.toSolverExpression(pb, _right, outcome);
                _xifexpression = pb.gt(_solverExpression, _solverExpression_1);
              } else {
                EXPRESSION _left_1 = ((COMPARISON)expression).getLeft();
                Object _solverExpression_2 = McdcDecisionUtils.toSolverExpression(pb, _left_1, outcome);
                EXPRESSION _right_1 = ((COMPARISON)expression).getRight();
                Object _solverExpression_3 = McdcDecisionUtils.toSolverExpression(pb, _right_1, outcome);
                _xifexpression = pb.leq(_solverExpression_2, _solverExpression_3);
              }
              _switchResult_1 = _xifexpression;
            }
          }
          if (!_matched_1) {
            if (Objects.equal(operator, ">=")) {
              _matched_1=true;
              Object _xifexpression_1 = null;
              if ((outcome == false)) {
                EXPRESSION _left_2 = ((COMPARISON)expression).getLeft();
                Object _solverExpression_4 = McdcDecisionUtils.toSolverExpression(pb, _left_2, outcome);
                EXPRESSION _right_2 = ((COMPARISON)expression).getRight();
                Object _solverExpression_5 = McdcDecisionUtils.toSolverExpression(pb, _right_2, outcome);
                _xifexpression_1 = pb.lt(_solverExpression_4, _solverExpression_5);
              } else {
                EXPRESSION _left_3 = ((COMPARISON)expression).getLeft();
                Object _solverExpression_6 = McdcDecisionUtils.toSolverExpression(pb, _left_3, outcome);
                EXPRESSION _right_3 = ((COMPARISON)expression).getRight();
                Object _solverExpression_7 = McdcDecisionUtils.toSolverExpression(pb, _right_3, outcome);
                _xifexpression_1 = pb.geq(_solverExpression_6, _solverExpression_7);
              }
              _switchResult_1 = _xifexpression_1;
            }
          }
          if (!_matched_1) {
            if (Objects.equal(operator, "<")) {
              _matched_1=true;
              Object _xifexpression_2 = null;
              if ((outcome == false)) {
                EXPRESSION _left_4 = ((COMPARISON)expression).getLeft();
                Object _solverExpression_8 = McdcDecisionUtils.toSolverExpression(pb, _left_4, outcome);
                EXPRESSION _right_4 = ((COMPARISON)expression).getRight();
                Object _solverExpression_9 = McdcDecisionUtils.toSolverExpression(pb, _right_4, outcome);
                _xifexpression_2 = pb.geq(_solverExpression_8, _solverExpression_9);
              } else {
                EXPRESSION _left_5 = ((COMPARISON)expression).getLeft();
                Object _solverExpression_10 = McdcDecisionUtils.toSolverExpression(pb, _left_5, outcome);
                EXPRESSION _right_5 = ((COMPARISON)expression).getRight();
                Object _solverExpression_11 = McdcDecisionUtils.toSolverExpression(pb, _right_5, outcome);
                _xifexpression_2 = pb.lt(_solverExpression_10, _solverExpression_11);
              }
              _switchResult_1 = _xifexpression_2;
            }
          }
          if (!_matched_1) {
            if (Objects.equal(operator, ">")) {
              _matched_1=true;
              Object _xifexpression_3 = null;
              if ((outcome == false)) {
                EXPRESSION _left_6 = ((COMPARISON)expression).getLeft();
                Object _solverExpression_12 = McdcDecisionUtils.toSolverExpression(pb, _left_6, outcome);
                EXPRESSION _right_6 = ((COMPARISON)expression).getRight();
                Object _solverExpression_13 = McdcDecisionUtils.toSolverExpression(pb, _right_6, outcome);
                _xifexpression_3 = pb.leq(_solverExpression_12, _solverExpression_13);
              } else {
                EXPRESSION _left_7 = ((COMPARISON)expression).getLeft();
                Object _solverExpression_14 = McdcDecisionUtils.toSolverExpression(pb, _left_7, outcome);
                EXPRESSION _right_7 = ((COMPARISON)expression).getRight();
                Object _solverExpression_15 = McdcDecisionUtils.toSolverExpression(pb, _right_7, outcome);
                _xifexpression_3 = pb.gt(_solverExpression_14, _solverExpression_15);
              }
              _switchResult_1 = _xifexpression_3;
            }
          }
          _xblockexpression = _switchResult_1;
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      if (expression instanceof ADD) {
        _matched=true;
        EXPRESSION _left = ((ADD)expression).getLeft();
        Object _solverExpression = McdcDecisionUtils.toSolverExpression(pb, _left, outcome);
        EXPRESSION _right = ((ADD)expression).getRight();
        Object _solverExpression_1 = McdcDecisionUtils.toSolverExpression(pb, _right, outcome);
        _switchResult = pb.plus(_solverExpression, _solverExpression_1);
      }
    }
    if (!_matched) {
      if (expression instanceof SUB) {
        _matched=true;
        EXPRESSION _left = ((SUB)expression).getLeft();
        Object _solverExpression = McdcDecisionUtils.toSolverExpression(pb, _left, outcome);
        EXPRESSION _right = ((SUB)expression).getRight();
        Object _solverExpression_1 = McdcDecisionUtils.toSolverExpression(pb, _right, outcome);
        _switchResult = pb.minus(_solverExpression, _solverExpression_1);
      }
    }
    if (!_matched) {
      if (expression instanceof MULT) {
        _matched=true;
        EXPRESSION _left = ((MULT)expression).getLeft();
        Object _solverExpression = McdcDecisionUtils.toSolverExpression(pb, _left, outcome);
        EXPRESSION _right = ((MULT)expression).getRight();
        Object _solverExpression_1 = McdcDecisionUtils.toSolverExpression(pb, _right, outcome);
        _switchResult = pb.mult(_solverExpression, _solverExpression_1);
      }
    }
    if (!_matched) {
      if (expression instanceof DIV) {
        _matched=true;
        EXPRESSION _left = ((DIV)expression).getLeft();
        Object _solverExpression = McdcDecisionUtils.toSolverExpression(pb, _left, outcome);
        EXPRESSION _right = ((DIV)expression).getRight();
        Object _solverExpression_1 = McdcDecisionUtils.toSolverExpression(pb, _right, outcome);
        _switchResult = pb.div(_solverExpression, _solverExpression_1);
      }
    }
    if (!_matched) {
      if (expression instanceof MODULO) {
        _matched=true;
        EXPRESSION _left = ((MODULO)expression).getLeft();
        Object _solverExpression = McdcDecisionUtils.toSolverExpression(pb, _left, outcome);
        EXPRESSION _right = ((MODULO)expression).getRight();
        Object _solverExpression_1 = McdcDecisionUtils.toSolverExpression(pb, _right, outcome);
        _switchResult = pb.mod(_solverExpression, _solverExpression_1);
      }
    }
    if (!_matched) {
      if (expression instanceof VarExpRef) {
        _matched=true;
        Object _xblockexpression = null;
        {
          final String type = ExpressionsTypeProvider.typeFor(expression);
          AbstractVAR_DECL _vref = ((VarExpRef)expression).getVref();
          final String name = _vref.getName();
          _xblockexpression = McdcDecisionUtils.createVariable(pb, name, type);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      if (expression instanceof intConstant) {
        _matched=true;
        final int value = ((intConstant)expression).getValue();
        return new Integer(value);
      }
    }
    if (!_matched) {
      if (expression instanceof realConstant) {
        _matched=true;
        final double value = ((realConstant)expression).getValue();
        return new Double(value);
      }
    }
    if (!_matched) {
      if (expression instanceof enumConstant) {
        _matched=true;
        final String actualValue = ((enumConstant)expression).getValue();
        final EQUAL_DIFF parent = EcoreUtil2.<EQUAL_DIFF>getContainerOfType(expression, EQUAL_DIFF.class);
        EXPRESSION exp = parent.getLeft();
        boolean _equals = Objects.equal(exp, expression);
        if (_equals) {
          EXPRESSION _right = parent.getRight();
          exp = _right;
        }
        AbstractVAR_DECL _vref = ((VarExpRef) exp).getVref();
        final VAR_DECL enumVariable = ((VAR_DECL) _vref);
        RANGE _range = enumVariable.getRange();
        final EList<Literal> enumSet = ((LSET) _range).getValue();
        int index = 0;
        for (final Literal enumValue : enumSet) {
          {
            index = (index + 1);
            String _literalValue = DslUtils.literalValue(enumValue);
            boolean _equals_1 = Objects.equal(_literalValue, actualValue);
            if (_equals_1) {
              return new Integer(index);
            }
          }
        }
      }
    }
    if (!_matched) {
      if (expression instanceof boolConstant) {
        _matched=true;
        throw new UnsupportedOperationException(" #### Boolean Constants are not allowed here #### ");
      }
    }
    if (!_matched) {
      if (expression instanceof strConstant) {
        _matched=true;
        _switchResult = null;
      }
    }
    if (!_matched) {
      if (expression instanceof hexConstant) {
        _matched=true;
        throw new UnsupportedOperationException(" #### hexadecimal not supported yet #### ");
      }
    }
    if (!_matched) {
      if (expression instanceof bitConstant) {
        _matched=true;
        throw new UnsupportedOperationException(" #### bit not supported yet #### ");
      }
    }
    if (!_matched) {
      throw new RuntimeException(" #### unknown expression #### ");
    }
    return _switchResult;
  }
  
  /**
   * Deal with variable creation in the solver
   */
  private static Object createVariable(final ProblemCoral pb, final String varName, final String varType) {
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(varType, "int")) {
        _matched=true;
        boolean _containsKey = McdcDecisionUtils.intVars.containsKey(varName);
        if (_containsKey) {
          return McdcDecisionUtils.intVars.get(varName);
        } else {
          final Object value = pb.makeIntVar(varName, McdcDecisionUtils.IMIN, McdcDecisionUtils.IMAX);
          final Object putValue = McdcDecisionUtils.intVars.put(varName, value);
          return value;
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(varType, "real")) {
        _matched=true;
        boolean _containsKey_1 = McdcDecisionUtils.doubleVars.containsKey(varName);
        if (_containsKey_1) {
          return McdcDecisionUtils.doubleVars.get(varName);
        } else {
          final Object value_1 = pb.makeRealVar(varName, McdcDecisionUtils.DMIN, McdcDecisionUtils.DMAX);
          final Object putValue_1 = McdcDecisionUtils.doubleVars.put(varName, value_1);
          return value_1;
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(varType, "bool")) {
        _matched=true;
        throw new RuntimeException(" #### Boolean are not allowed here #### ");
      }
    }
    if (!_matched) {
      if (Objects.equal(varType, "enum")) {
        _matched=true;
        boolean _containsKey_2 = McdcDecisionUtils.intVars.containsKey(varName);
        if (_containsKey_2) {
          return McdcDecisionUtils.intVars.get(varName);
        } else {
          final Object enumVar = pb.makeIntVar(varName, McdcDecisionUtils.IMIN, McdcDecisionUtils.IMAX);
          final Object putValue_2 = McdcDecisionUtils.intVars.put(varName, enumVar);
          return enumVar;
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(varType, "str")) {
        _matched=true;
        throw new UnsupportedOperationException(" #### Coral does not handle string constraint #### ");
      }
    }
    if (!_matched) {
      if (Objects.equal(varType, "hex")) {
        _matched=true;
        throw new UnsupportedOperationException(" #### Coral does not handle hexadecimal constraint #### ");
      }
    }
    if (!_matched) {
      if (Objects.equal(varType, "bit")) {
        _matched=true;
        throw new UnsupportedOperationException(" #### Coral does not handle bit constraint #### ");
      }
    }
    throw new RuntimeException(" #### Incorrect operation type #### ");
  }
  
  /**
   * Put dsl interface variables in the  map
   */
  private static void recordDslVariables(final MODULE_DECL module, final Map<String, Object> dslVarsMap) {
    INTERFACE _interface = module.getInterface();
    EList<AbstractVAR_DECL> _declaration = _interface.getDeclaration();
    final Iterable<VAR_DECL> listOfVariables = Iterables.<VAR_DECL>filter(_declaration, VAR_DECL.class);
    dslVarsMap.clear();
    final Procedure1<VAR_DECL> _function = new Procedure1<VAR_DECL>() {
      public void apply(final VAR_DECL variable) {
        final String name = variable.getName();
        dslVarsMap.put(name, variable);
      }
    };
    IterableExtensions.<VAR_DECL>forEach(listOfVariables, _function);
  }
  
  public static void hasStronglyCoupledConditions(final EXPRESSION expression) {
    final ArrayList<String> allVarsInExpression = new ArrayList<String>();
    DslUtils.booleanVarInExpression(expression, allVarsInExpression);
  }
}
