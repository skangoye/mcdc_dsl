package org.xtext.mcdc;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.xtext.helper.Couple;
import org.xtext.helper.Triplet;
import org.xtext.mcdc.McdcDecisionUtils;
import org.xtext.mcdc.WeightComparator;
import org.xtext.moduleDsl.AND;
import org.xtext.moduleDsl.COMPARISON;
import org.xtext.moduleDsl.EQUAL_DIFF;
import org.xtext.moduleDsl.EXPRESSION;
import org.xtext.moduleDsl.NOT;
import org.xtext.moduleDsl.OR;
import org.xtext.moduleDsl.VarExpRef;
import org.xtext.utils.DslUtils;

@SuppressWarnings("all")
public class MCDC_Of_Decision3 {
  private final static String FalseChar = "F";
  
  private final static String TrueChar = "T";
  
  private int notCount = 0;
  
  private String firstOperator = "";
  
  /**
   * Compute the MC/DC of a boolean expression
   * @param booleanExpression
   * 							The boolean expression to be used
   * @return A list of booleanExpression's MC/DC tests and theirs corresponding outcomes
   */
  public List<String> mcdcOfBooleanExpression(final EXPRESSION booleanExpression) {
    try {
      final ArrayList<List<Triplet<String, String, String>>> dfsValues = new ArrayList<List<Triplet<String, String, String>>>();
      final TreeSet<String> finalMCDCValues = new TreeSet<String>();
      this.mcdcDepthFirstSearch(booleanExpression, dfsValues);
      final List<Triplet<String, String, String>> linkResult = this.mcdcBottomUp(dfsValues);
      final ArrayList<Couple<String, Integer>> falseValueWithWeight = new ArrayList<Couple<String, Integer>>();
      final ArrayList<Couple<String, Integer>> trueValueWithWeight = new ArrayList<Couple<String, Integer>>();
      for (final Triplet<String, String, String> triplet : linkResult) {
        {
          final String outcome = this.evalOperation(triplet);
          final String mcdcCandidate = triplet.getFirst();
          boolean _and = false;
          boolean _notEquals = (!Objects.equal(outcome, "T"));
          if (!_notEquals) {
            _and = false;
          } else {
            boolean _notEquals_1 = (!Objects.equal(outcome, "F"));
            _and = _notEquals_1;
          }
          if (_and) {
            throw new Exception(("Incorrect outcome result: " + outcome));
          }
          boolean _equals = Objects.equal(outcome, "T");
          if (_equals) {
            Couple<String, Integer> _couple = new Couple<String, Integer>(mcdcCandidate, Integer.valueOf(0));
            trueValueWithWeight.add(_couple);
          } else {
            Couple<String, Integer> _couple_1 = new Couple<String, Integer>(mcdcCandidate, Integer.valueOf(0));
            falseValueWithWeight.add(_couple_1);
          }
        }
      }
      final ArrayList<Couple<String, Integer>> feasibleFalseValueWithWeight = McdcDecisionUtils.discardInfeasibleTests(booleanExpression, falseValueWithWeight);
      final ArrayList<Couple<String, Integer>> feasibleTrueValueWithWeight = McdcDecisionUtils.discardInfeasibleTests(booleanExpression, trueValueWithWeight);
      Couple<String, Integer> _get = falseValueWithWeight.get(0);
      String _first = _get.getFirst();
      final int size = _first.length();
      final ArrayList<List<Couple<Couple<String, Integer>, Couple<String, Integer>>>> listOfIndepVectors = new ArrayList<List<Couple<Couple<String, Integer>, Couple<String, Integer>>>>();
      final TreeSet<String> feasibleTestCases = new TreeSet<String>();
      this.fillWithEmptyElements(listOfIndepVectors, size);
      for (final Couple<String, Integer> fc : feasibleFalseValueWithWeight) {
        {
          String _first_1 = fc.getFirst();
          feasibleTestCases.add(_first_1);
          for (final Couple<String, Integer> tc : feasibleTrueValueWithWeight) {
            {
              String _first_2 = tc.getFirst();
              feasibleTestCases.add(_first_2);
              this.addIndepVector(fc, tc, listOfIndepVectors);
            }
          }
        }
      }
      final Procedure1<List<Couple<Couple<String, Integer>, Couple<String, Integer>>>> _function = new Procedure1<List<Couple<Couple<String, Integer>, Couple<String, Integer>>>>() {
        public void apply(final List<Couple<Couple<String, Integer>, Couple<String, Integer>>> list) {
          int _size = list.size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            WeightComparator _weightComparator = new WeightComparator();
            ListExtensions.<Couple<Couple<String, Integer>, Couple<String, Integer>>>sortInplace(list, _weightComparator);
            final Couple<Couple<String, Integer>, Couple<String, Integer>> mostValuable = list.get(0);
            final Couple<String, Integer> couple1 = mostValuable.getFirst();
            final Couple<String, Integer> couple2 = mostValuable.getSecond();
            String _first = couple1.getFirst();
            String _plus = (MCDC_Of_Decision3.FalseChar + _first);
            finalMCDCValues.add(_plus);
            String _first_1 = couple2.getFirst();
            String _plus_1 = (MCDC_Of_Decision3.TrueChar + _first_1);
            finalMCDCValues.add(_plus_1);
          }
        }
      };
      IterableExtensions.<List<Couple<Couple<String, Integer>, Couple<String, Integer>>>>forEach(listOfIndepVectors, _function);
      return IterableExtensions.<String>toList(finalMCDCValues);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Performs a DFS (Depth-First-Search) upon the expression parse tree, to reach its leaf-nodes and store.
   * @param expression
   * 					Boolean expression parse tree
   * @param resultList
   * 					list of all leaf-nodes' with theirs values.
   * A leaf-node value is composed of trivial values 'True' and 'False', its index and its position in the tree
   */
  private void mcdcDepthFirstSearch(final EXPRESSION exp, final List<List<Triplet<String, String, String>>> resultList) {
    try {
      if ((exp instanceof AND)) {
        this.firstOperator = "and";
        ArrayList<Triplet<String, String, String>> leftList = new ArrayList<Triplet<String, String, String>>();
        ArrayList<Triplet<String, String, String>> rightList = new ArrayList<Triplet<String, String, String>>();
        Triplet<String, String, String> _triplet = new Triplet<String, String, String>("T", "11", "1");
        leftList.add(_triplet);
        Triplet<String, String, String> _triplet_1 = new Triplet<String, String, String>("T", "21", "1");
        leftList.add(_triplet_1);
        Triplet<String, String, String> _triplet_2 = new Triplet<String, String, String>("F", "22", "1");
        leftList.add(_triplet_2);
        Triplet<String, String, String> _triplet_3 = new Triplet<String, String, String>("F", "23", "1");
        leftList.add(_triplet_3);
        Triplet<String, String, String> _triplet_4 = new Triplet<String, String, String>("T", "11", "0");
        rightList.add(_triplet_4);
        Triplet<String, String, String> _triplet_5 = new Triplet<String, String, String>("F", "21", "0");
        rightList.add(_triplet_5);
        Triplet<String, String, String> _triplet_6 = new Triplet<String, String, String>("T", "22", "0");
        rightList.add(_triplet_6);
        Triplet<String, String, String> _triplet_7 = new Triplet<String, String, String>("F", "23", "0");
        rightList.add(_triplet_7);
        final AND andExp = ((AND) exp);
        EXPRESSION _left = andExp.getLeft();
        this.mcdcDepthFirstSearch2(_left, leftList, resultList);
        EXPRESSION _right = andExp.getRight();
        this.mcdcDepthFirstSearch2(_right, rightList, resultList);
      } else {
        if ((exp instanceof OR)) {
          this.firstOperator = "or";
          ArrayList<Triplet<String, String, String>> leftList_1 = new ArrayList<Triplet<String, String, String>>();
          ArrayList<Triplet<String, String, String>> rightList_1 = new ArrayList<Triplet<String, String, String>>();
          Triplet<String, String, String> _triplet_8 = new Triplet<String, String, String>("T", "11", "1");
          leftList_1.add(_triplet_8);
          Triplet<String, String, String> _triplet_9 = new Triplet<String, String, String>("T", "12", "1");
          leftList_1.add(_triplet_9);
          Triplet<String, String, String> _triplet_10 = new Triplet<String, String, String>("F", "13", "1");
          leftList_1.add(_triplet_10);
          Triplet<String, String, String> _triplet_11 = new Triplet<String, String, String>("F", "21", "1");
          leftList_1.add(_triplet_11);
          Triplet<String, String, String> _triplet_12 = new Triplet<String, String, String>("T", "11", "0");
          rightList_1.add(_triplet_12);
          Triplet<String, String, String> _triplet_13 = new Triplet<String, String, String>("F", "12", "0");
          rightList_1.add(_triplet_13);
          Triplet<String, String, String> _triplet_14 = new Triplet<String, String, String>("T", "13", "0");
          rightList_1.add(_triplet_14);
          Triplet<String, String, String> _triplet_15 = new Triplet<String, String, String>("F", "21", "0");
          rightList_1.add(_triplet_15);
          final OR orExp = ((OR) exp);
          EXPRESSION _left_1 = orExp.getLeft();
          this.mcdcDepthFirstSearch2(_left_1, leftList_1, resultList);
          EXPRESSION _right_1 = orExp.getRight();
          this.mcdcDepthFirstSearch2(_right_1, rightList_1, resultList);
        } else {
          if ((exp instanceof NOT)) {
            this.notCount = (this.notCount + 1);
            final NOT notExp = ((NOT) exp);
            EXPRESSION _exp = notExp.getExp();
            this.mcdcDepthFirstSearch(_exp, resultList);
          } else {
            boolean _or = false;
            if (((exp instanceof EQUAL_DIFF) || (exp instanceof COMPARISON))) {
              _or = true;
            } else {
              _or = (exp instanceof VarExpRef);
            }
            if (_or) {
              ArrayList<Triplet<String, String, String>> list = new ArrayList<Triplet<String, String, String>>();
              Triplet<String, String, String> _triplet_16 = new Triplet<String, String, String>("T", "1", "");
              list.add(_triplet_16);
              Triplet<String, String, String> _triplet_17 = new Triplet<String, String, String>("F", "2", "");
              list.add(_triplet_17);
              resultList.add(list);
            } else {
              throw new Exception("Illegal boolean expression");
            }
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Called by mcdcDepthFirstSearch method to perform the DFS
   * @see
   * 		mcdcDepthFirstSearch
   */
  private void mcdcDepthFirstSearch2(final EXPRESSION exp, final List<Triplet<String, String, String>> list, final List<List<Triplet<String, String, String>>> result) {
    try {
      if ((exp instanceof AND)) {
        ArrayList<Triplet<String, String, String>> leftList = new ArrayList<Triplet<String, String, String>>();
        ArrayList<Triplet<String, String, String>> rightList = new ArrayList<Triplet<String, String, String>>();
        this.doAndEval(list, leftList, rightList);
        EXPRESSION _left = ((AND) exp).getLeft();
        this.mcdcDepthFirstSearch2(_left, leftList, result);
        EXPRESSION _right = ((AND) exp).getRight();
        this.mcdcDepthFirstSearch2(_right, rightList, result);
      } else {
        if ((exp instanceof OR)) {
          ArrayList<Triplet<String, String, String>> leftList_1 = new ArrayList<Triplet<String, String, String>>();
          ArrayList<Triplet<String, String, String>> rightList_1 = new ArrayList<Triplet<String, String, String>>();
          this.doOrEval(list, leftList_1, rightList_1);
          EXPRESSION _left_1 = ((OR) exp).getLeft();
          this.mcdcDepthFirstSearch2(_left_1, leftList_1, result);
          EXPRESSION _right_1 = ((OR) exp).getRight();
          this.mcdcDepthFirstSearch2(_right_1, rightList_1, result);
        } else {
          if ((exp instanceof NOT)) {
            ArrayList<Triplet<String, String, String>> notList = new ArrayList<Triplet<String, String, String>>();
            this.doNotEval(list, notList);
            EXPRESSION _exp = ((NOT) exp).getExp();
            this.mcdcDepthFirstSearch2(_exp, notList, result);
          } else {
            boolean _or = false;
            if (((exp instanceof EQUAL_DIFF) || (exp instanceof COMPARISON))) {
              _or = true;
            } else {
              _or = (exp instanceof VarExpRef);
            }
            if (_or) {
              this.doEqCompVarEval(list, result);
            } else {
              throw new Exception("Illegal boolean expression");
            }
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void doAndEval(final List<Triplet<String, String, String>> Triplets, final List<Triplet<String, String, String>> left, final List<Triplet<String, String, String>> right) {
    try {
      for (final Triplet<String, String, String> t : Triplets) {
        String _first = t.getFirst();
        String _string = _first.toString();
        boolean _equals = Objects.equal(_string, "T");
        if (_equals) {
          String _second = t.getSecond();
          String _plus = (_second + "1");
          String _third = t.getThird();
          String _plus_1 = (_third + "1");
          Triplet<String, String, String> _triplet = new Triplet<String, String, String>("T", _plus, _plus_1);
          left.add(_triplet);
          String _second_1 = t.getSecond();
          String _plus_2 = (_second_1 + "1");
          String _third_1 = t.getThird();
          String _plus_3 = (_third_1 + "0");
          Triplet<String, String, String> _triplet_1 = new Triplet<String, String, String>("T", _plus_2, _plus_3);
          right.add(_triplet_1);
        } else {
          String _first_1 = t.getFirst();
          String _string_1 = _first_1.toString();
          boolean _equals_1 = Objects.equal(_string_1, "F");
          if (_equals_1) {
            String _second_2 = t.getSecond();
            String _plus_4 = (_second_2 + "1");
            String _third_2 = t.getThird();
            String _plus_5 = (_third_2 + "1");
            Triplet<String, String, String> _triplet_2 = new Triplet<String, String, String>("T", _plus_4, _plus_5);
            left.add(_triplet_2);
            String _second_3 = t.getSecond();
            String _plus_6 = (_second_3 + "1");
            String _third_3 = t.getThird();
            String _plus_7 = (_third_3 + "0");
            Triplet<String, String, String> _triplet_3 = new Triplet<String, String, String>("F", _plus_6, _plus_7);
            right.add(_triplet_3);
            String _second_4 = t.getSecond();
            String _plus_8 = (_second_4 + "2");
            String _third_4 = t.getThird();
            String _plus_9 = (_third_4 + "1");
            Triplet<String, String, String> _triplet_4 = new Triplet<String, String, String>("F", _plus_8, _plus_9);
            left.add(_triplet_4);
            String _second_5 = t.getSecond();
            String _plus_10 = (_second_5 + "2");
            String _third_5 = t.getThird();
            String _plus_11 = (_third_5 + "0");
            Triplet<String, String, String> _triplet_5 = new Triplet<String, String, String>("T", _plus_10, _plus_11);
            right.add(_triplet_5);
            String _second_6 = t.getSecond();
            String _plus_12 = (_second_6 + "3");
            String _third_6 = t.getThird();
            String _plus_13 = (_third_6 + "1");
            Triplet<String, String, String> _triplet_6 = new Triplet<String, String, String>("F", _plus_12, _plus_13);
            left.add(_triplet_6);
            String _second_7 = t.getSecond();
            String _plus_14 = (_second_7 + "3");
            String _third_7 = t.getThird();
            String _plus_15 = (_third_7 + "0");
            Triplet<String, String, String> _triplet_7 = new Triplet<String, String, String>("F", _plus_14, _plus_15);
            right.add(_triplet_7);
          } else {
            throw new Exception("Illegal argument");
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void doOrEval(final List<Triplet<String, String, String>> Triplets, final List<Triplet<String, String, String>> left, final List<Triplet<String, String, String>> right) {
    try {
      for (final Triplet<String, String, String> t : Triplets) {
        String _first = t.getFirst();
        String _string = _first.toString();
        boolean _equals = Objects.equal(_string, "F");
        if (_equals) {
          String _second = t.getSecond();
          String _plus = (_second + "1");
          String _third = t.getThird();
          String _plus_1 = (_third + "1");
          Triplet<String, String, String> _triplet = new Triplet<String, String, String>("F", _plus, _plus_1);
          left.add(_triplet);
          String _second_1 = t.getSecond();
          String _plus_2 = (_second_1 + "1");
          String _third_1 = t.getThird();
          String _plus_3 = (_third_1 + "0");
          Triplet<String, String, String> _triplet_1 = new Triplet<String, String, String>("F", _plus_2, _plus_3);
          right.add(_triplet_1);
        } else {
          String _first_1 = t.getFirst();
          String _string_1 = _first_1.toString();
          boolean _equals_1 = Objects.equal(_string_1, "T");
          if (_equals_1) {
            String _second_2 = t.getSecond();
            String _plus_4 = (_second_2 + "1");
            String _third_2 = t.getThird();
            String _plus_5 = (_third_2 + "1");
            Triplet<String, String, String> _triplet_2 = new Triplet<String, String, String>("T", _plus_4, _plus_5);
            left.add(_triplet_2);
            String _second_3 = t.getSecond();
            String _plus_6 = (_second_3 + "1");
            String _third_3 = t.getThird();
            String _plus_7 = (_third_3 + "0");
            Triplet<String, String, String> _triplet_3 = new Triplet<String, String, String>("T", _plus_6, _plus_7);
            right.add(_triplet_3);
            String _second_4 = t.getSecond();
            String _plus_8 = (_second_4 + "2");
            String _third_4 = t.getThird();
            String _plus_9 = (_third_4 + "1");
            Triplet<String, String, String> _triplet_4 = new Triplet<String, String, String>("T", _plus_8, _plus_9);
            left.add(_triplet_4);
            String _second_5 = t.getSecond();
            String _plus_10 = (_second_5 + "2");
            String _third_5 = t.getThird();
            String _plus_11 = (_third_5 + "0");
            Triplet<String, String, String> _triplet_5 = new Triplet<String, String, String>("F", _plus_10, _plus_11);
            right.add(_triplet_5);
            String _second_6 = t.getSecond();
            String _plus_12 = (_second_6 + "3");
            String _third_6 = t.getThird();
            String _plus_13 = (_third_6 + "1");
            Triplet<String, String, String> _triplet_6 = new Triplet<String, String, String>("F", _plus_12, _plus_13);
            left.add(_triplet_6);
            String _second_7 = t.getSecond();
            String _plus_14 = (_second_7 + "3");
            String _third_7 = t.getThird();
            String _plus_15 = (_third_7 + "0");
            Triplet<String, String, String> _triplet_7 = new Triplet<String, String, String>("T", _plus_14, _plus_15);
            right.add(_triplet_7);
          } else {
            throw new Exception("Illegal argument");
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void doNotEval(final List<Triplet<String, String, String>> Triplets, final List<Triplet<String, String, String>> notlist) {
    try {
      for (final Triplet<String, String, String> t : Triplets) {
        String _first = t.getFirst();
        String _string = _first.toString();
        boolean _equals = Objects.equal(_string, "F");
        if (_equals) {
          String _second = t.getSecond();
          String _third = t.getThird();
          Triplet<String, String, String> _triplet = new Triplet<String, String, String>("T", _second, _third);
          notlist.add(_triplet);
        } else {
          String _first_1 = t.getFirst();
          String _string_1 = _first_1.toString();
          boolean _equals_1 = Objects.equal(_string_1, "T");
          if (_equals_1) {
            String _second_1 = t.getSecond();
            String _third_1 = t.getThird();
            Triplet<String, String, String> _triplet_1 = new Triplet<String, String, String>("F", _second_1, _third_1);
            notlist.add(_triplet_1);
          } else {
            throw new Exception("Illegal argument");
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void doEqCompVarEval(final List<Triplet<String, String, String>> Triplets, final List<List<Triplet<String, String, String>>> result) {
    result.add(Triplets);
  }
  
  private List<Triplet<String, String, String>> mcdcBottomUp(final List<List<Triplet<String, String, String>>> resultList) {
    try {
      List<Triplet<String, String, String>> _xblockexpression = null;
      {
        List<List<Triplet<String, String, String>>> myList = resultList;
        int _size = myList.size();
        boolean _equals = (_size == 0);
        if (_equals) {
          throw new Exception("List is empty");
        }
        int i = 0;
        boolean _dowhile = false;
        do {
          {
            int _size_1 = myList.size();
            boolean _equals_1 = (_size_1 == 1);
            if (_equals_1) {
              return myList.get(0);
            }
            final List<Triplet<String, String, String>> tmpList = myList.get(i);
            Triplet<String, String, String> _get = tmpList.get(0);
            String _third = _get.getThird();
            final String delPosition = DslUtils.deleteLastChar(_third);
            Triplet<String, String, String> _get_1 = tmpList.get(0);
            String _third_1 = _get_1.getThird();
            String _lastChar = DslUtils.getLastChar(_third_1);
            final int n1 = DslUtils.parseInt(_lastChar);
            final Function1<List<Triplet<String, String, String>>, Boolean> _function = new Function1<List<Triplet<String, String, String>>, Boolean>() {
              public Boolean apply(final List<Triplet<String, String, String>> it) {
                boolean _and = false;
                boolean _and_1 = false;
                boolean _notEquals = (!Objects.equal(it, tmpList));
                if (!_notEquals) {
                  _and_1 = false;
                } else {
                  Triplet<String, String, String> _get = it.get(0);
                  String _third = _get.getThird();
                  String _deleteLastChar = DslUtils.deleteLastChar(_third);
                  boolean _equals = Objects.equal(_deleteLastChar, delPosition);
                  _and_1 = _equals;
                }
                if (!_and_1) {
                  _and = false;
                } else {
                  Triplet<String, String, String> _get_1 = it.get(0);
                  String _third_1 = _get_1.getThird();
                  String _lastChar = DslUtils.getLastChar(_third_1);
                  int _parseInt = DslUtils.parseInt(_lastChar);
                  int _minus = (n1 - _parseInt);
                  boolean _equals_1 = (_minus == 1);
                  _and = _equals_1;
                }
                return Boolean.valueOf(_and);
              }
            };
            final List<Triplet<String, String, String>> cmp = IterableExtensions.<List<Triplet<String, String, String>>>findFirst(myList, _function);
            boolean _notEquals = (!Objects.equal(cmp, null));
            if (_notEquals) {
              ArrayList<Triplet<String, String, String>> _mergeResults = this.mergeResults(tmpList, cmp);
              myList.set(i, _mergeResults);
              myList.remove(cmp);
            }
          }
          int _i = i = (i + 1);
          int _size_1 = myList.size();
          boolean _lessThan = (_i < _size_1);
          _dowhile = _lessThan;
        } while(_dowhile);
        _xblockexpression = this.mcdcBottomUp(myList);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Merge two lists according to our MC/DC merging policy
   * @param left
   * 			 The first list
   * @param right
   * 			 The second list
   * @return A list that merges the two lists
   */
  private ArrayList<Triplet<String, String, String>> mergeResults(final List<Triplet<String, String, String>> left, final List<Triplet<String, String, String>> right) {
    final ArrayList<Triplet<String, String, String>> list = new ArrayList<Triplet<String, String, String>>();
    for (final Triplet<String, String, String> t1 : left) {
      {
        String index1 = t1.getSecond();
        String position = t1.getThird();
        for (final Triplet<String, String, String> t2 : right) {
          {
            final String index2 = t2.getSecond();
            boolean _equals = Objects.equal(index1, index2);
            if (_equals) {
              String _first = t1.getFirst();
              String _first_1 = t2.getFirst();
              String _plus = (_first + _first_1);
              String _deleteLastChar = DslUtils.deleteLastChar(index1);
              String _deleteLastChar_1 = DslUtils.deleteLastChar(position);
              Triplet<String, String, String> _triplet = new Triplet<String, String, String>(_plus, _deleteLastChar, _deleteLastChar_1);
              list.add(_triplet);
            }
          }
        }
      }
    }
    return list;
  }
  
  /**
   * Evaluate the outcome of sequence
   */
  private String evalOperation(final Triplet<String, String, String> t) {
    String _xblockexpression = null;
    {
      String eval = "";
      String _xifexpression = null;
      if (((this.notCount % 2) == 0)) {
        String _xifexpression_1 = null;
        String _second = t.getSecond();
        boolean _equals = Objects.equal(_second, "1");
        if (_equals) {
          _xifexpression_1 = eval = "T";
        } else {
          String _xifexpression_2 = null;
          String _second_1 = t.getSecond();
          boolean _equals_1 = Objects.equal(_second_1, "2");
          if (_equals_1) {
            _xifexpression_2 = eval = "F";
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      } else {
        String _xifexpression_3 = null;
        String _second_2 = t.getSecond();
        boolean _equals_2 = Objects.equal(_second_2, "1");
        if (_equals_2) {
          _xifexpression_3 = eval = "F";
        } else {
          String _xifexpression_4 = null;
          boolean _or = false;
          String _second_3 = t.getSecond();
          boolean _equals_3 = Objects.equal(_second_3, "2");
          if (_equals_3) {
            _or = true;
          } else {
            String _second_4 = t.getSecond();
            boolean _equals_4 = Objects.equal(_second_4, "3");
            _or = _equals_4;
          }
          if (_or) {
            _xifexpression_4 = eval = "T";
          }
          _xifexpression_3 = _xifexpression_4;
        }
        _xifexpression = _xifexpression_3;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  private void addIndepVector(final Couple<String, Integer> cp1, final Couple<String, Integer> cp2, final List<List<Couple<Couple<String, Integer>, Couple<String, Integer>>>> listOfList) {
    try {
      String _first = cp1.getFirst();
      final char[] a1 = _first.toCharArray();
      String _first_1 = cp2.getFirst();
      final char[] a2 = _first_1.toCharArray();
      String _first_2 = cp1.getFirst();
      final int size = _first_2.length();
      Integer _second = cp1.getSecond();
      final int val1 = _second.intValue();
      Integer _second_1 = cp2.getSecond();
      final int val2 = _second_1.intValue();
      String a = "";
      int index = (-1);
      boolean _or = false;
      String _first_3 = cp1.getFirst();
      int _length = _first_3.length();
      String _first_4 = cp2.getFirst();
      int _length_1 = _first_4.length();
      boolean _notEquals = (_length != _length_1);
      if (_notEquals) {
        _or = true;
      } else {
        String _first_5 = cp1.getFirst();
        String _first_6 = cp2.getFirst();
        boolean _equals = Objects.equal(_first_5, _first_6);
        _or = _equals;
      }
      if (_or) {
        throw new Exception("Illegal arguments");
      } else {
        int i = 0;
        boolean _dowhile = false;
        do {
          char _get = a1[i];
          char _get_1 = a2[i];
          boolean _equals_1 = (_get == _get_1);
          if (_equals_1) {
            a = (a + "0");
          } else {
            a = (a + "1");
          }
          int _i = i = (i + 1);
          boolean _lessThan = (_i < size);
          _dowhile = _lessThan;
        } while(_dowhile);
        int j = 0;
        int cnt = 0;
        int asize = a.length();
        boolean _dowhile_1 = false;
        do {
          char _charAt = a.charAt(j);
          String _string = Character.valueOf(_charAt).toString();
          boolean _equals_2 = Objects.equal(_string, "1");
          if (_equals_2) {
            cnt = (cnt + 1);
            index = j;
          }
          int _j = j = (j + 1);
          boolean _lessThan_1 = (_j < asize);
          _dowhile_1 = _lessThan_1;
        } while(_dowhile_1);
        if ((cnt == 1)) {
          cp1.setSecond(Integer.valueOf((val1 + 1)));
          cp2.setSecond(Integer.valueOf((val2 + 1)));
          List<Couple<Couple<String, Integer>, Couple<String, Integer>>> _get_2 = listOfList.get(index);
          Couple<Couple<String, Integer>, Couple<String, Integer>> _couple = new Couple<Couple<String, Integer>, Couple<String, Integer>>(cp1, cp2);
          _get_2.add(_couple);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * fill the List with 'Empty elements'. That way we create an array of fixed elements
   */
  private void fillWithEmptyElements(final ArrayList<List<Couple<Couple<String, Integer>, Couple<String, Integer>>>> listOfList, final int size) {
    for (int i = 0; (i < size); i++) {
      ArrayList<Couple<Couple<String, Integer>, Couple<String, Integer>>> _arrayList = new ArrayList<Couple<Couple<String, Integer>, Couple<String, Integer>>>();
      listOfList.add(_arrayList);
    }
  }
}
