// Generated from C:\Users\User\ArabicProlog.g4 by ANTLR 4.1
package antlr4;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import antlr4.ArabicPrologParser.ArabicBooleanContext;
import antlr4.ArabicPrologParser.BinaryOperatorContext;
import antlr4.ArabicPrologParser.CutContext;
import antlr4.ArabicPrologParser.ElementListContext;
import antlr4.ArabicPrologParser.EmptyListContext;
import antlr4.ArabicPrologParser.ExpContext;
import antlr4.ArabicPrologParser.IsExpressionContext;
import antlr4.ArabicPrologParser.LeftExpressionContext;
import antlr4.ArabicPrologParser.ListPrologContext;
import antlr4.ArabicPrologParser.OpTermsContext;
import antlr4.ArabicPrologParser.OperandContext;
import antlr4.ArabicPrologParser.RightExpressionContext;
import antlr4.ArabicPrologParser.TupleContext;
import antlr4.ArabicPrologParser.UnaryOperatorContext;
import antlr4.ArabicPrologParser.UnifyExpressionContext;
//import front_end.Converter;
import front_end.Parser;
//import unification_solver.Cut;
//import unification_solver.Is;
//import unification_solver.ListProlog;
//import unification_solver.SimpleSentence;

/**
 * This class provides an empty implementation of {@link ArabicPrologListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class ArabicPrologBaseListener implements ArabicPrologListener {
	public static String code="";
	private static boolean isQuery = false;
	public void enterSimpleSentence(@NotNull ArabicPrologParser.SimpleSentenceContext ctx) {
		code+="new SimpleSentence ("; 
		
	}
	public void exitSimpleSentence(@NotNull ArabicPrologParser.SimpleSentenceContext ctx) { 
		code+="),";
	}
	
	public void enterTuple(TupleContext ctx) {
		code+="new SimpleSentence ("; 
		
	}
	public void exitTuple(TupleContext ctx) {
		code+="),";
	}
	
	public void enterConstant(@NotNull ArabicPrologParser.ConstantContext ctx) { 
		if (ctx.getParent() instanceof ArabicPrologParser.OperandContext)
			code += "";
		else {
			if(Parser.constants.Exist(ctx.getText()))
				code+="constants.getConstant(\""+ctx.getText()+"\"),";
			else
				code+="new Constant(\""+ctx.getText()+"\"),";
		}
	}
	
	public void exitConstant(@NotNull ArabicPrologParser.ConstantContext ctx) { }
	
	public void enterVariable(@NotNull ArabicPrologParser.VariableContext ctx) { 
		if (ctx.getParent() instanceof ArabicPrologParser.OperandContext)
			code += "";
		else {
			if(Parser.variables.Exist(ctx.getText()))
				code+="variables.getVariable(\""+ctx.getText()+"\"),";
			else
				code+="new Variable(\""+ctx.getText()+"\"),";
		}
	}
	public void exitVariable(@NotNull ArabicPrologParser.VariableContext ctx) { }
	
	public void enterAnonymous(@NotNull ArabicPrologParser.AnonymousContext ctx) {
		code+="new Anonymous(),";
	}
	
	public void exitAnonymous(@NotNull ArabicPrologParser.AnonymousContext ctx) { }
	
	public void enterArabicProlog(@NotNull ArabicPrologParser.ArabicPrologContext ctx) { }
	public void exitArabicProlog(@NotNull ArabicPrologParser.ArabicPrologContext ctx) { }
	
	public void enterOr(@NotNull ArabicPrologParser.OrContext ctx) { 
		code+="new Or (";
	}
	
	public void exitOr(@NotNull ArabicPrologParser.OrContext ctx) { 
		code+="),";
	}
	
	public void enterAnd(@NotNull ArabicPrologParser.AndContext ctx) { 
		code+="new And (";
	}
	public void exitAnd(@NotNull ArabicPrologParser.AndContext ctx) { 
		code+="),";
	}
	
	public void enterQuery(@NotNull ArabicPrologParser.QueryContext ctx) { 
		isQuery = true;
	}
	public void exitQuery(@NotNull ArabicPrologParser.QueryContext ctx) { }
	
	
	public void enterRule(@NotNull ArabicPrologParser.RuleContext ctx) { 
		isQuery = false;
		code+="new Rule (";
	}
	public void exitRule(@NotNull ArabicPrologParser.RuleContext ctx) { 
		code+="),";
	}
	
	public void enterRuleSet(@NotNull ArabicPrologParser.RuleSetContext ctx) {
		code+="new RuleSet (";
	}
	public void exitRuleSet(@NotNull ArabicPrologParser.RuleSetContext ctx) {
		code+=")";
	}
	
	public void enterEveryRule(@NotNull ParserRuleContext ctx) { }
	public void exitEveryRule(@NotNull ParserRuleContext ctx) { }
	public void visitTerminal(@NotNull TerminalNode node) { }
	public void visitErrorNode(@NotNull ErrorNode node) { 
		System.out.println(node.getText());
	}
	@Override
	public void enterElementList(ElementListContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitElementList(ElementListContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterListProlog(ListPrologContext ctx) {
		// TODO Auto-generated method stub
		if(isQuery){
			code+="new ListProlog(";
			}
		else { //Is rule
			code+="new SimpleSentence(ListProlog.getFunctor(),";
		}
		
	}
	@Override
	public void exitListProlog(ListPrologContext ctx) {
		// TODO Auto-generated method stub
		if(isQuery)
			code+="ListProlog.getEmptyList()).getList(),";

		else { //Is rule
			if(ctx.getChildCount()==3) 
				//code+="ListProlog.getEmptyList(),";
				code+="ListProlog.getEmptyList(),";
				//System.out.println("########"+ctx.getText()+"########");
				
				code+="),";
				
		}
		
	}
	@Override
	public void enterEmptyList(EmptyListContext ctx) {
		// TODO Auto-generated method stub
		code+= "ListProlog.getEmptyList(),";
		
	}
	@Override
	public void exitEmptyList(EmptyListContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterCut(CutContext ctx) {
		// TODO Auto-generated method stub
		code+= "new Cut(cuts,id++),";
		
	}
	@Override
	public void exitCut(CutContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterLeftExpression(LeftExpressionContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void exitLeftExpression(LeftExpressionContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterRightExpression(RightExpressionContext ctx) {
		// TODO Auto-generated method stub
		if (ctx.getParent() instanceof ArabicPrologParser.ExpContext)
			code += "";
		else
			code +="Converter.infixToTree(\"";
		
	}
	@Override
	public void exitRightExpression(RightExpressionContext ctx) {
		// TODO Auto-generated method stub
		if (ctx.getParent() instanceof ArabicPrologParser.ExpContext)
			code += "";
		else
			code += "\",variables),";
	}
	@Override
	public void enterOperand(OperandContext ctx) {
		// TODO Auto-generated method stub
		code += " "+ctx.getText()+" ";
		
	}
	@Override
	public void exitOperand(OperandContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterUnaryOperator(UnaryOperatorContext ctx) {
		// TODO Auto-generated method stub
		code += " "+ctx.getText()+" ";
		
	}
	@Override
	public void exitUnaryOperator(UnaryOperatorContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterExp(ExpContext ctx) {
		// TODO Auto-generated method stub
		code += "( ";
		
	}
	@Override
	public void exitExp(ExpContext ctx) {
		// TODO Auto-generated method stub
		code += " )";
		
	}
	@Override
	public void enterBinaryOperator(BinaryOperatorContext ctx) {
		// TODO Auto-generated method stub
		code += " "+ctx.getText()+" ";
		
	}
	@Override
	public void exitBinaryOperator(BinaryOperatorContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterIsExpression(IsExpressionContext ctx) {
		// TODO Auto-generated method stub
		code += "new Is(new SimpleSentence(";
		
	}
	@Override
	public void exitIsExpression(IsExpressionContext ctx) {
		// TODO Auto-generated method stub
		code += ")),";
		
	}
	@Override
	public void enterArabicBoolean(ArabicBooleanContext ctx) {
		// TODO Auto-generated method stub
		code += " "+ctx.getText()+" ";
		
	}
	@Override
	public void exitArabicBoolean(ArabicBooleanContext ctx) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void enterUnifyExpression(UnifyExpressionContext ctx) {
		// TODO Auto-generated method stub
		code += "new Unify(new SimpleSentence(";
		
	}
	@Override
	public void exitUnifyExpression(UnifyExpressionContext ctx) {
		// TODO Auto-generated method stub
		code += ")),";
	}
	@Override
	public void enterOpTerms(OpTermsContext ctx) {
		// TODO Auto-generated method stub
		code += "new OpTerms(new SimpleSentence(";
	}
	@Override
	public void exitOpTerms(OpTermsContext ctx) {
		// TODO Auto-generated method stub
		code += ")),";
		
	}
}