// Generated from C:\Users\User\ArabicProlog.g4 by ANTLR 4.1
package antlr4;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ArabicPrologParser}.
 */
public interface ArabicPrologListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#leftExpression}.
	 * @param ctx the parse tree
	 */
	void enterLeftExpression(@NotNull ArabicPrologParser.LeftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#leftExpression}.
	 * @param ctx the parse tree
	 */
	void exitLeftExpression(@NotNull ArabicPrologParser.LeftExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#rightExpression}.
	 * @param ctx the parse tree
	 */
	void enterRightExpression(@NotNull ArabicPrologParser.RightExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#rightExpression}.
	 * @param ctx the parse tree
	 */
	void exitRightExpression(@NotNull ArabicPrologParser.RightExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(@NotNull ArabicPrologParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(@NotNull ArabicPrologParser.QueryContext ctx);

	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#simpleSentence}.
	 * @param ctx the parse tree
	 */
	void enterSimpleSentence(@NotNull ArabicPrologParser.SimpleSentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#simpleSentence}.
	 * @param ctx the parse tree
	 */
	void exitSimpleSentence(@NotNull ArabicPrologParser.SimpleSentenceContext ctx);

	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#tuple}.
	 * @param ctx the parse tree
	 */
	void enterTuple(@NotNull ArabicPrologParser.TupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#tuple}.
	 * @param ctx the parse tree
	 */
	void exitTuple(@NotNull ArabicPrologParser.TupleContext ctx);

	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#elementList}.
	 * @param ctx the parse tree
	 */
	void enterElementList(@NotNull ArabicPrologParser.ElementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#elementList}.
	 * @param ctx the parse tree
	 */
	void exitElementList(@NotNull ArabicPrologParser.ElementListContext ctx);

	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#anonymous}.
	 * @param ctx the parse tree
	 */
	void enterAnonymous(@NotNull ArabicPrologParser.AnonymousContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#anonymous}.
	 * @param ctx the parse tree
	 */
	void exitAnonymous(@NotNull ArabicPrologParser.AnonymousContext ctx);

	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#binaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOperator(@NotNull ArabicPrologParser.BinaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#binaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOperator(@NotNull ArabicPrologParser.BinaryOperatorContext ctx);

	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#rule}.
	 * @param ctx the parse tree
	 */
	void enterRule(@NotNull ArabicPrologParser.RuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#rule}.
	 * @param ctx the parse tree
	 */
	void exitRule(@NotNull ArabicPrologParser.RuleContext ctx);

	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#listProlog}.
	 * @param ctx the parse tree
	 */
	void enterListProlog(@NotNull ArabicPrologParser.ListPrologContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#listProlog}.
	 * @param ctx the parse tree
	 */
	void exitListProlog(@NotNull ArabicPrologParser.ListPrologContext ctx);

	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#arabicProlog}.
	 * @param ctx the parse tree
	 */
	void enterArabicProlog(@NotNull ArabicPrologParser.ArabicPrologContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#arabicProlog}.
	 * @param ctx the parse tree
	 */
	void exitArabicProlog(@NotNull ArabicPrologParser.ArabicPrologContext ctx);

	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(@NotNull ArabicPrologParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(@NotNull ArabicPrologParser.ConstantContext ctx);

	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#or}.
	 * @param ctx the parse tree
	 */
	void enterOr(@NotNull ArabicPrologParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#or}.
	 * @param ctx the parse tree
	 */
	void exitOr(@NotNull ArabicPrologParser.OrContext ctx);

	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(@NotNull ArabicPrologParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(@NotNull ArabicPrologParser.OperandContext ctx);

	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#emptyList}.
	 * @param ctx the parse tree
	 */
	void enterEmptyList(@NotNull ArabicPrologParser.EmptyListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#emptyList}.
	 * @param ctx the parse tree
	 */
	void exitEmptyList(@NotNull ArabicPrologParser.EmptyListContext ctx);

	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAnd(@NotNull ArabicPrologParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAnd(@NotNull ArabicPrologParser.AndContext ctx);

	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperator(@NotNull ArabicPrologParser.UnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperator(@NotNull ArabicPrologParser.UnaryOperatorContext ctx);

	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(@NotNull ArabicPrologParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(@NotNull ArabicPrologParser.ExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#opTerms}.
	 * @param ctx the parse tree
	 */
	void enterOpTerms(@NotNull ArabicPrologParser.OpTermsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#opTerms}.
	 * @param ctx the parse tree
	 */
	void exitOpTerms(@NotNull ArabicPrologParser.OpTermsContext ctx);

	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#isExpression}.
	 * @param ctx the parse tree
	 */
	void enterIsExpression(@NotNull ArabicPrologParser.IsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#isExpression}.
	 * @param ctx the parse tree
	 */
	void exitIsExpression(@NotNull ArabicPrologParser.IsExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#arabicBoolean}.
	 * @param ctx the parse tree
	 */
	void enterArabicBoolean(@NotNull ArabicPrologParser.ArabicBooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#arabicBoolean}.
	 * @param ctx the parse tree
	 */
	void exitArabicBoolean(@NotNull ArabicPrologParser.ArabicBooleanContext ctx);

	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#cut}.
	 * @param ctx the parse tree
	 */
	void enterCut(@NotNull ArabicPrologParser.CutContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#cut}.
	 * @param ctx the parse tree
	 */
	void exitCut(@NotNull ArabicPrologParser.CutContext ctx);

	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(@NotNull ArabicPrologParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(@NotNull ArabicPrologParser.VariableContext ctx);

	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#ruleSet}.
	 * @param ctx the parse tree
	 */
	void enterRuleSet(@NotNull ArabicPrologParser.RuleSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#ruleSet}.
	 * @param ctx the parse tree
	 */
	void exitRuleSet(@NotNull ArabicPrologParser.RuleSetContext ctx);

	/**
	 * Enter a parse tree produced by {@link ArabicPrologParser#unifyExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnifyExpression(@NotNull ArabicPrologParser.UnifyExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArabicPrologParser#unifyExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnifyExpression(@NotNull ArabicPrologParser.UnifyExpressionContext ctx);
}