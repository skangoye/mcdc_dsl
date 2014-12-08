package org.xtext.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.xtext.services.ModuleDslGrammarAccess;

@SuppressWarnings("all")
public class ModuleDslSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ModuleDslGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ASSIGN_STATEMENT_SemicolonKeyword_3_q;
	protected AbstractElementAlias match_CRITERION_DECL_SemicolonKeyword_4_q;
	protected AbstractElementAlias match_CST_DECL_SemicolonKeyword_6_q;
	protected AbstractElementAlias match_DATASEL_DECL_SemicolonKeyword_5_q;
	protected AbstractElementAlias match_ERROR_STATEMENT_SemicolonKeyword_2_q;
	protected AbstractElementAlias match_PrimaryExpression_LeftParenthesisKeyword_0_0_a;
	protected AbstractElementAlias match_PrimaryExpression_LeftParenthesisKeyword_0_0_p;
	protected AbstractElementAlias match_TmpVAR_DECL_SemicolonKeyword_5_q;
	protected AbstractElementAlias match_VAR_DECL_SemicolonKeyword_6_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ModuleDslGrammarAccess) access;
		match_ASSIGN_STATEMENT_SemicolonKeyword_3_q = new TokenAlias(false, true, grammarAccess.getASSIGN_STATEMENTAccess().getSemicolonKeyword_3());
		match_CRITERION_DECL_SemicolonKeyword_4_q = new TokenAlias(false, true, grammarAccess.getCRITERION_DECLAccess().getSemicolonKeyword_4());
		match_CST_DECL_SemicolonKeyword_6_q = new TokenAlias(false, true, grammarAccess.getCST_DECLAccess().getSemicolonKeyword_6());
		match_DATASEL_DECL_SemicolonKeyword_5_q = new TokenAlias(false, true, grammarAccess.getDATASEL_DECLAccess().getSemicolonKeyword_5());
		match_ERROR_STATEMENT_SemicolonKeyword_2_q = new TokenAlias(false, true, grammarAccess.getERROR_STATEMENTAccess().getSemicolonKeyword_2());
		match_PrimaryExpression_LeftParenthesisKeyword_0_0_a = new TokenAlias(true, true, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0());
		match_PrimaryExpression_LeftParenthesisKeyword_0_0_p = new TokenAlias(true, false, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0());
		match_TmpVAR_DECL_SemicolonKeyword_5_q = new TokenAlias(false, true, grammarAccess.getTmpVAR_DECLAccess().getSemicolonKeyword_5());
		match_VAR_DECL_SemicolonKeyword_6_q = new TokenAlias(false, true, grammarAccess.getVAR_DECLAccess().getSemicolonKeyword_6());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_ASSIGN_STATEMENT_SemicolonKeyword_3_q.equals(syntax))
				emit_ASSIGN_STATEMENT_SemicolonKeyword_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_CRITERION_DECL_SemicolonKeyword_4_q.equals(syntax))
				emit_CRITERION_DECL_SemicolonKeyword_4_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_CST_DECL_SemicolonKeyword_6_q.equals(syntax))
				emit_CST_DECL_SemicolonKeyword_6_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DATASEL_DECL_SemicolonKeyword_5_q.equals(syntax))
				emit_DATASEL_DECL_SemicolonKeyword_5_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ERROR_STATEMENT_SemicolonKeyword_2_q.equals(syntax))
				emit_ERROR_STATEMENT_SemicolonKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_PrimaryExpression_LeftParenthesisKeyword_0_0_a.equals(syntax))
				emit_PrimaryExpression_LeftParenthesisKeyword_0_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_PrimaryExpression_LeftParenthesisKeyword_0_0_p.equals(syntax))
				emit_PrimaryExpression_LeftParenthesisKeyword_0_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TmpVAR_DECL_SemicolonKeyword_5_q.equals(syntax))
				emit_TmpVAR_DECL_SemicolonKeyword_5_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_VAR_DECL_SemicolonKeyword_6_q.equals(syntax))
				emit_VAR_DECL_SemicolonKeyword_6_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_ASSIGN_STATEMENT_SemicolonKeyword_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_CRITERION_DECL_SemicolonKeyword_4_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_CST_DECL_SemicolonKeyword_6_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_DATASEL_DECL_SemicolonKeyword_5_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_ERROR_STATEMENT_SemicolonKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_PrimaryExpression_LeftParenthesisKeyword_0_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_PrimaryExpression_LeftParenthesisKeyword_0_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_TmpVAR_DECL_SemicolonKeyword_5_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_VAR_DECL_SemicolonKeyword_6_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
