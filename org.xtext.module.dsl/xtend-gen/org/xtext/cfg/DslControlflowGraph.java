package org.xtext.cfg;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.jgrapht.graph.DirectedWeightedMultigraph;
import org.xtext.cfg.CondCfgNode;
import org.xtext.cfg.LabeledWeightedEdge;
import org.xtext.cfg.Node;
import org.xtext.cfg.SimpleCfgNode;
import org.xtext.helper.Couple;
import org.xtext.helper.Triplet;
import org.xtext.mcdc.MCDC_Statement;
import org.xtext.moduleDsl.ASSIGN_STATEMENT;
import org.xtext.moduleDsl.AbstractVAR_DECL;
import org.xtext.moduleDsl.BODY;
import org.xtext.moduleDsl.EXPRESSION;
import org.xtext.moduleDsl.IF_STATEMENT;
import org.xtext.moduleDsl.MODULE_DECL;
import org.xtext.moduleDsl.STATEMENT;
import org.xtext.moduleDsl.VAR_REF;
import org.xtext.utils.DslUtils;

@SuppressWarnings("all")
public class DslControlflowGraph {
  private static int identifier = 0;
  
  private final static String entry = "entry";
  
  private final static String exit = "exit";
  
  private final static String trueLabel = "T";
  
  private final static String falseLabel = "F";
  
  private final static String emptyLabel = "";
  
  public static DirectedWeightedMultigraph<Node, LabeledWeightedEdge> buildCFG(final MODULE_DECL module, final MCDC_Statement mcdcStatement) {
    final DirectedWeightedMultigraph<Node, LabeledWeightedEdge> modelGraph = new DirectedWeightedMultigraph<Node, LabeledWeightedEdge>(LabeledWeightedEdge.class);
    final Node entryNode = new Node(DslControlflowGraph.entry);
    modelGraph.addVertex(entryNode);
    final ArrayList<Couple<String, String>> predsIdentAndLabel = new ArrayList<Couple<String, String>>();
    Couple<String, String> _couple = new Couple<String, String>(DslControlflowGraph.entry, DslControlflowGraph.emptyLabel);
    predsIdentAndLabel.add(_couple);
    BODY _body = module.getBody();
    final EList<STATEMENT> stmtList = _body.getStatements();
    final List<Couple<String, String>> finalPreds = DslControlflowGraph.toCFG(modelGraph, stmtList, predsIdentAndLabel, mcdcStatement);
    final Node exitNode = new Node(DslControlflowGraph.exit);
    modelGraph.addVertex(exitNode);
    DslControlflowGraph.addEdges(modelGraph, finalPreds, exitNode);
    DslControlflowGraph.identifier = 0;
    return modelGraph;
  }
  
  private static List<Couple<String, String>> toCFG(final DirectedWeightedMultigraph<Node, LabeledWeightedEdge> graph, final List<STATEMENT> stmtList, final List<Couple<String, String>> preds, final MCDC_Statement mcdcStatement) {
    List<Couple<String, String>> _xblockexpression = null;
    {
      final int stmtListSize = stmtList.size();
      List<Couple<String, String>> _xifexpression = null;
      if ((stmtListSize > 0)) {
        List<Couple<String, String>> _xblockexpression_1 = null;
        {
          DslControlflowGraph.identifier = (DslControlflowGraph.identifier + 1);
          final String strIdentifier = Integer.valueOf(DslControlflowGraph.identifier).toString();
          final STATEMENT currentStatement = stmtList.get(0);
          List<Couple<String, String>> _switchResult = null;
          boolean _matched = false;
          if (!_matched) {
            if (currentStatement instanceof AbstractVAR_DECL) {
              _matched=true;
              final Triplet<List<String>, List<String>, List<String>> varTriplet = mcdcStatement.mcdcVarStatement(((AbstractVAR_DECL)currentStatement));
              final SimpleCfgNode node = new SimpleCfgNode(strIdentifier, currentStatement, varTriplet);
              graph.addVertex(node);
              DslControlflowGraph.addEdges(graph, preds, node);
              final ArrayList<Couple<String, String>> newPreds = new ArrayList<Couple<String, String>>();
              Couple<String, String> _couple = new Couple<String, String>(strIdentifier, DslControlflowGraph.emptyLabel);
              newPreds.add(_couple);
              int _size = stmtList.size();
              boolean _greaterThan = (_size > 1);
              if (_greaterThan) {
                stmtList.remove(0);
                return DslControlflowGraph.toCFG(graph, stmtList, newPreds, mcdcStatement);
              } else {
                final ArrayList<Couple<String, String>> nodeArray = new ArrayList<Couple<String, String>>();
                Couple<String, String> _couple_1 = new Couple<String, String>(strIdentifier, DslControlflowGraph.emptyLabel);
                nodeArray.add(_couple_1);
                return nodeArray;
              }
            }
          }
          if (!_matched) {
            if (currentStatement instanceof ASSIGN_STATEMENT) {
              _matched=true;
              final Triplet<List<String>, List<String>, List<String>> assignTriplet = mcdcStatement.mcdcAssignStatement(((ASSIGN_STATEMENT)currentStatement));
              final SimpleCfgNode node = new SimpleCfgNode(strIdentifier, currentStatement, assignTriplet);
              graph.addVertex(node);
              DslControlflowGraph.addEdges(graph, preds, node);
              final ArrayList<Couple<String, String>> newPreds = new ArrayList<Couple<String, String>>();
              Couple<String, String> _couple = new Couple<String, String>(strIdentifier, DslControlflowGraph.emptyLabel);
              newPreds.add(_couple);
              int _size = stmtList.size();
              boolean _greaterThan = (_size > 1);
              if (_greaterThan) {
                stmtList.remove(0);
                return DslControlflowGraph.toCFG(graph, stmtList, newPreds, mcdcStatement);
              } else {
                final ArrayList<Couple<String, String>> nodeArray = new ArrayList<Couple<String, String>>();
                Couple<String, String> _couple_1 = new Couple<String, String>(strIdentifier, DslControlflowGraph.emptyLabel);
                nodeArray.add(_couple_1);
                return nodeArray;
              }
            }
          }
          if (!_matched) {
            if (currentStatement instanceof IF_STATEMENT) {
              _matched=true;
              final Couple<Triplet<List<String>, List<String>, List<String>>, Triplet<List<String>, List<String>, List<String>>> condTriplet = mcdcStatement.mcdcIfThenElseStatement(((IF_STATEMENT)currentStatement));
              Triplet<List<String>, List<String>, List<String>> _first = condTriplet.getFirst();
              Triplet<List<String>, List<String>, List<String>> _second = condTriplet.getSecond();
              final CondCfgNode node = new CondCfgNode(strIdentifier, currentStatement, _first, _second);
              graph.addVertex(node);
              DslControlflowGraph.addEdges(graph, preds, node);
              final ArrayList<Couple<String, String>> ifPreds = new ArrayList<Couple<String, String>>();
              final ArrayList<Couple<String, String>> elsePreds = new ArrayList<Couple<String, String>>();
              Couple<String, String> _couple = new Couple<String, String>(strIdentifier, DslControlflowGraph.trueLabel);
              ifPreds.add(_couple);
              Couple<String, String> _couple_1 = new Couple<String, String>(strIdentifier, DslControlflowGraph.falseLabel);
              elsePreds.add(_couple_1);
              final EList<STATEMENT> ifStmtList = ((IF_STATEMENT)currentStatement).getIfst();
              final EList<STATEMENT> elseStmtList = ((IF_STATEMENT)currentStatement).getElst();
              final List<Couple<String, String>> list1 = DslControlflowGraph.toCFG(graph, ifStmtList, ifPreds, mcdcStatement);
              final List<Couple<String, String>> list2 = DslControlflowGraph.toCFG(graph, elseStmtList, elsePreds, mcdcStatement);
              final ArrayList<Couple<String, String>> cumulPreds = new ArrayList<Couple<String, String>>();
              cumulPreds.addAll(list1);
              cumulPreds.addAll(list2);
              int _size = stmtList.size();
              boolean _greaterThan = (_size > 1);
              if (_greaterThan) {
                stmtList.remove(0);
                return DslControlflowGraph.toCFG(graph, stmtList, cumulPreds, mcdcStatement);
              } else {
                return cumulPreds;
              }
            }
          }
          if (!_matched) {
            _switchResult = null;
          }
          _xblockexpression_1 = _switchResult;
        }
        _xifexpression = _xblockexpression_1;
      } else {
        return preds;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  private static void addEdges(final DirectedWeightedMultigraph<Node, LabeledWeightedEdge> graph, final List<Couple<String, String>> preds, final Node node) {
    final Procedure1<Couple<String, String>> _function = new Procedure1<Couple<String, String>>() {
      public void apply(final Couple<String, String> pred) {
        final String nodeId = pred.getFirst();
        final String labelValue = pred.getSecond();
        final Node predNode = DslControlflowGraph.getNode(graph, nodeId);
        final LabeledWeightedEdge label = new LabeledWeightedEdge(labelValue);
        graph.addEdge(predNode, node, label);
      }
    };
    IterableExtensions.<Couple<String, String>>forEach(preds, _function);
  }
  
  private static Node getNode(final DirectedWeightedMultigraph<Node, LabeledWeightedEdge> graph, final String id) {
    try {
      Node _xblockexpression = null;
      {
        final Set<Node> nodeSet = graph.vertexSet();
        Node _xtrycatchfinallyexpression = null;
        try {
          final Function1<Node, Boolean> _function = new Function1<Node, Boolean>() {
            public Boolean apply(final Node node) {
              String _id = node.getId();
              return Boolean.valueOf(Objects.equal(_id, id));
            }
          };
          _xtrycatchfinallyexpression = IterableExtensions.<Node>findFirst(nodeSet, _function);
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            final Exception e = (Exception)_t;
            throw new Exception((("Error: Node with the id " + id) + " not found! "));
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        _xblockexpression = _xtrycatchfinallyexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String getStmtID(final STATEMENT stmt) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (stmt instanceof AbstractVAR_DECL) {
        _matched=true;
        return ((AbstractVAR_DECL)stmt).getName();
      }
    }
    if (!_matched) {
      if (stmt instanceof ASSIGN_STATEMENT) {
        _matched=true;
        final VAR_REF left = ((ASSIGN_STATEMENT)stmt).getLeft();
        final EXPRESSION exp = ((ASSIGN_STATEMENT)stmt).getRight();
        AbstractVAR_DECL _variable = left.getVariable();
        String _name = _variable.getName();
        String _plus = (_name + " = ");
        String _stringReprOfExpression = DslUtils.stringReprOfExpression(exp);
        return (_plus + _stringReprOfExpression);
      }
    }
    if (!_matched) {
      if (stmt instanceof IF_STATEMENT) {
        _matched=true;
        EXPRESSION _ifCond = ((IF_STATEMENT)stmt).getIfCond();
        return DslUtils.stringReprOfExpression(_ifCond);
      }
    }
    if (!_matched) {
      _switchResult = "";
    }
    return _switchResult;
  }
}
