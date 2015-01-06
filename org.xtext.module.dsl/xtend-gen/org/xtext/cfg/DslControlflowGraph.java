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
  
  public static DirectedWeightedMultigraph<Node, LabeledWeightedEdge> buildCFG(final MODULE_DECL module) {
    final DirectedWeightedMultigraph<Node, LabeledWeightedEdge> modelGraph = new DirectedWeightedMultigraph<Node, LabeledWeightedEdge>(LabeledWeightedEdge.class);
    final Node entryNode = new Node(DslControlflowGraph.entry);
    modelGraph.addVertex(entryNode);
    final ArrayList<String> predIdentList = new ArrayList<String>();
    predIdentList.add(DslControlflowGraph.entry);
    BODY _body = module.getBody();
    final EList<STATEMENT> stmtList = _body.getStatements();
    final List<String> finalPredIdentList = DslControlflowGraph.toCFG(modelGraph, stmtList, predIdentList);
    final Node exitNode = new Node(DslControlflowGraph.exit);
    modelGraph.addVertex(exitNode);
    DslControlflowGraph.addEdges(modelGraph, finalPredIdentList, exitNode);
    DslControlflowGraph.identifier = 0;
    return modelGraph;
  }
  
  private static List<String> toCFG(final DirectedWeightedMultigraph<Node, LabeledWeightedEdge> graph, final List<STATEMENT> stmtList, final List<String> predIdentList) {
    List<String> _xtrycatchfinallyexpression = null;
    try {
      final STATEMENT currentStatement = stmtList.get(0);
      DslControlflowGraph.identifier = (DslControlflowGraph.identifier + 1);
      final String strIdentifier = Integer.valueOf(DslControlflowGraph.identifier).toString();
      boolean _matched = false;
      if (!_matched) {
        if (currentStatement instanceof AbstractVAR_DECL) {
          _matched=true;
          final Node node = new Node(strIdentifier);
          graph.addVertex(node);
          DslControlflowGraph.addEdges(graph, predIdentList, node);
          final ArrayList<String> newPredIdentList = new ArrayList<String>();
          newPredIdentList.add(strIdentifier);
          int _size = stmtList.size();
          boolean _greaterThan = (_size > 1);
          if (_greaterThan) {
            stmtList.remove(0);
            return DslControlflowGraph.toCFG(graph, stmtList, newPredIdentList);
          } else {
            final ArrayList<String> nodeArray = new ArrayList<String>();
            nodeArray.add(strIdentifier);
            return nodeArray;
          }
        }
      }
      if (!_matched) {
        if (currentStatement instanceof ASSIGN_STATEMENT) {
          _matched=true;
          final SimpleCfgNode node = new SimpleCfgNode(strIdentifier, ((ASSIGN_STATEMENT)currentStatement), false);
          graph.addVertex(node);
          DslControlflowGraph.addEdges(graph, predIdentList, node);
          final ArrayList<String> newPredIdentList = new ArrayList<String>();
          newPredIdentList.add(strIdentifier);
          int _size = stmtList.size();
          boolean _greaterThan = (_size > 1);
          if (_greaterThan) {
            stmtList.remove(0);
            return DslControlflowGraph.toCFG(graph, stmtList, newPredIdentList);
          } else {
            final ArrayList<String> nodeArray = new ArrayList<String>();
            nodeArray.add(strIdentifier);
            return nodeArray;
          }
        }
      }
      if (!_matched) {
        if (currentStatement instanceof IF_STATEMENT) {
          _matched=true;
          final EXPRESSION condition = ((IF_STATEMENT)currentStatement).getIfCond();
          final CondCfgNode node = new CondCfgNode(strIdentifier, condition, false);
          graph.addVertex(node);
          DslControlflowGraph.addEdges(graph, predIdentList, node);
          final ArrayList<String> newPredIdentList = new ArrayList<String>();
          newPredIdentList.add(strIdentifier);
          final EList<STATEMENT> ifStmtList = ((IF_STATEMENT)currentStatement).getIfst();
          final EList<STATEMENT> elseStmtList = ((IF_STATEMENT)currentStatement).getElst();
          final List<String> list1 = DslControlflowGraph.toCFG(graph, ifStmtList, newPredIdentList);
          final List<String> list2 = DslControlflowGraph.toCFG(graph, elseStmtList, newPredIdentList);
          final ArrayList<String> cumulPredList = new ArrayList<String>();
          cumulPredList.addAll(list1);
          cumulPredList.addAll(list2);
          int _size = stmtList.size();
          boolean _greaterThan = (_size > 1);
          if (_greaterThan) {
            stmtList.remove(0);
            return DslControlflowGraph.toCFG(graph, stmtList, cumulPredList);
          } else {
            return cumulPredList;
          }
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        _xtrycatchfinallyexpression = null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  private static void addEdges(final DirectedWeightedMultigraph<Node, LabeledWeightedEdge> graph, final List<String> predIdentList, final Node node) {
    System.out.println(((node.id + " => ") + predIdentList));
    final Procedure1<String> _function = new Procedure1<String>() {
      public void apply(final String predIdent) {
        final Node predNode = DslControlflowGraph.getNode(graph, predIdent);
        graph.addEdge(predNode, node);
      }
    };
    IterableExtensions.<String>forEach(predIdentList, _function);
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
