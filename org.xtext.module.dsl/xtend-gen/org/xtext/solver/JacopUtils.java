package org.xtext.solver;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.jacop.core.IntVar;
import org.jacop.floats.core.FloatDomain;
import org.jacop.floats.core.FloatVar;
import org.xtext.moduleDsl.INTERVAL;
import org.xtext.moduleDsl.LSET;
import org.xtext.moduleDsl.Literal;
import org.xtext.moduleDsl.RANGE;
import org.xtext.moduleDsl.TYPE;
import org.xtext.moduleDsl.VAR_DECL;
import org.xtext.solver.ProblemJacop;
import org.xtext.utils.DslUtils;

@SuppressWarnings("all")
public class JacopUtils {
  public static void setIntervalConstraints(final ProblemJacop pb, final Object solverVar, final VAR_DECL dslVar) {
    try {
      TYPE _type = dslVar.getType();
      final String type = _type.getType();
      RANGE _range = dslVar.getRange();
      final INTERVAL interval = ((INTERVAL) _range);
      Literal _min = interval.getMin();
      final String min = DslUtils.literalValue(_min);
      Literal _max = interval.getMax();
      final String max = DslUtils.literalValue(_max);
      final String leftSqBr = interval.getLsqbr();
      final String rightSqBr = interval.getRsqbr();
      boolean _equals = Objects.equal(type, "real");
      if (_equals) {
        double minVal = pb.MIN_FLOAT;
        double maxVal = pb.MAX_FLOAT;
        boolean _notEquals = (!Objects.equal(min, "?"));
        if (_notEquals) {
          double _parseDouble = DslUtils.parseDouble(min);
          minVal = _parseDouble;
        }
        boolean _notEquals_1 = (!Objects.equal(max, "?"));
        if (_notEquals_1) {
          double _parseDouble_1 = DslUtils.parseDouble(max);
          maxVal = _parseDouble_1;
        }
        ((FloatVar) solverVar).setDomain(minVal, maxVal);
        boolean _equals_1 = Objects.equal(leftSqBr, "]");
        if (_equals_1) {
          Object _gt = pb.gt(solverVar, minVal);
          pb.post(_gt);
        }
        boolean _equals_2 = Objects.equal(rightSqBr, "[");
        if (_equals_2) {
          Object _lt = pb.lt(solverVar, maxVal);
          pb.post(_lt);
        }
      } else {
        boolean _equals_3 = Objects.equal(type, "int");
        if (_equals_3) {
          int minVal_1 = pb.MIN_INT;
          int maxVal_1 = pb.MAX_INT;
          boolean _notEquals_2 = (!Objects.equal(min, "?"));
          if (_notEquals_2) {
            int _parseInt = DslUtils.parseInt(min);
            minVal_1 = _parseInt;
          }
          boolean _notEquals_3 = (!Objects.equal(max, "?"));
          if (_notEquals_3) {
            int _parseInt_1 = DslUtils.parseInt(max);
            maxVal_1 = _parseInt_1;
          }
          ((IntVar) solverVar).setDomain(minVal_1, maxVal_1);
          boolean _equals_4 = Objects.equal(leftSqBr, "]");
          if (_equals_4) {
            Object _gt_1 = pb.gt(solverVar, minVal_1);
            pb.post(_gt_1);
          }
          boolean _equals_5 = Objects.equal(rightSqBr, "[");
          if (_equals_5) {
            Object _lt_1 = pb.lt(solverVar, maxVal_1);
            pb.post(_lt_1);
          }
        } else {
          throw new Exception(" #### Type error #### ");
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static Object setSetconstraints(final ProblemJacop pb, final Object solverVar, final VAR_DECL dslVar) {
    Object _xblockexpression = null;
    {
      TYPE _type = dslVar.getType();
      final String type = _type.getType();
      RANGE _range = dslVar.getRange();
      final LSET set = ((LSET) _range);
      Object _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(type, "real")) {
          _matched=true;
          final EList<Literal> setElem = set.getValue();
          FloatDomain _dom = ((FloatVar) solverVar).dom();
          _dom.clear();
        }
      }
      if (!_matched) {
        if (Objects.equal(type, "int")) {
          _matched=true;
          _switchResult = null;
        }
      }
      if (!_matched) {
        if (Objects.equal(type, "enum")) {
          _matched=true;
          EList<Literal> _value = set.getValue();
          int _size = _value.size();
          int _minus = (_size - 1);
          ((IntVar) solverVar).setDomain(0, _minus);
        }
      }
      if (!_matched) {
        _switchResult = null;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
}
