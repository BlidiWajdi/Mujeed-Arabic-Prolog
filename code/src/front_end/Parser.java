package front_end;

import java.awt.Color;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.gui.TreeViewer;

import antlr4.ArabicPrologBaseListener;
import antlr4.ArabicPrologLexer;
import antlr4.ArabicPrologParser;

import frames.PrincipalWindow;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import unification_solver.*;

public class Parser {
	private static List<Couple> 	lexemes 	= 	new LinkedList()	;
	public static ConstantSet 		constants 	= 	new ConstantSet() 	;
	public static VariableSet 		variables 	= 	new VariableSet() 	;
	public static CutSet      		cuts	 	= 	new CutSet()		;
	public static int 				id			=	0					;
	public static RuleSet 			ruleSet 	= 	new RuleSet() 		;
	private static String 			query								;
	

	public void createknowledgeBase(String arabicKnowledgeBase) {
		//initialisation
		arabicKnowledgeBase = arabicKnowledgeBase.replaceAll("،", ",");
		lexemes.clear();
		lexemes	= Lexer.getLexemes(arabicKnowledgeBase);
		cuts.initialize();
		getConstants(lexemes);
		getVariables(lexemes);
		 
		FromGui.insert(PrincipalWindow.interpreter, "/>  ", Color.BLACK);
				
		//construct RuleSet
		String code = "";
			try {
				ANTLRInputStream input = new ANTLRInputStream( arabicKnowledgeBase );
				ArabicPrologLexer lexer = new ArabicPrologLexer(input);
				CommonTokenStream tokens = new CommonTokenStream(lexer);
				ArabicPrologParser parser = new ArabicPrologParser(tokens);
				ParseTree tree = parser.ruleSet();
				// showTree(parser,tree);
				// Walk it and attach our listener
			    ParseTreeWalker walker = new ParseTreeWalker();
		        ArabicPrologBaseListener listener = new ArabicPrologBaseListener();
				walker.DEFAULT.walk(listener, tree);
				code = ArabicPrologBaseListener.code.replaceAll(",\\)", "\\)")+";";
				code  = code.replaceAll(",;", ";");
				//System.out.println(code);
				}
				catch (Exception e){e.printStackTrace();}
					
				//convert String to java code with groovy
				Binding binding = new Binding();
				GroovyShell shell = new GroovyShell(binding);
				shell.setProperty("constants", constants);
				shell.setProperty("variables", variables);
				shell.setProperty("cuts", cuts);
				shell.setProperty("id", id);
				//System.out.println(constants);
				//System.out.println(variables);
				Object value = shell.evaluate(
						  "import unification_solver.*	;"
						+ "import front_end.Converter 	;"
						+ "RuleSet a = "+code+" return a;");
				ruleSet = (RuleSet) value;	
	}
	

	private static void getVariables(List<Couple> arg) {
		// TODO Auto-generated method stub
		for(int i=0; i<arg.size(); i++){
			if (arg.get(i).getCategory().equals("Variable")) {
				if(! variables.Exist(arg.get(i).getValue()))
					variables.add(new Variable(arg.get(i).getValue()));
			}
		}
		
	}


	public static void getConstants(List<Couple> arg) {
		// TODO Auto-generated method stub
		for(int i=0; i<arg.size(); i++){
			if(arg.get(i).getCategory().equals("Constant") || 
					arg.get(i).getCategory().equals("Integer") ||
						arg.get(i).getCategory().equals("Double")) {
				if(! constants.Exist(arg.get(i).getValue()))
					constants.add(new Constant(lexemes.get(i).getValue()));
			}
		}
	}


	private static void showTree(ArabicPrologParser parser, ParseTree tree) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Antlr AST");
        JPanel panel = new JPanel();
        TreeViewer viewr = new TreeViewer(Arrays.asList(
                parser.getRuleNames()),tree);
        viewr.setScale(1.5);//scale a little
        panel.add(viewr);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,200);
        frame.setVisible(true);
		
	}

	public static Object getQueryToSolve(String userQuery) {
		userQuery = userQuery.replaceAll("،", ",");
		lexemes.clear();
		lexemes = Lexer.getLexemes(userQuery);
		getConstants(lexemes);
		getVariables(lexemes);
		cuts.initialize();

		query = userQuery;
		String code = "";
		try {
		userQuery = userQuery.replaceAll("،", ",");
		ANTLRInputStream input = new ANTLRInputStream( userQuery );
		ArabicPrologLexer lexer = new ArabicPrologLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ArabicPrologParser parser = new ArabicPrologParser(tokens);
		ParseTree tree = parser.query();
		//showTree(parser, tree);
		// Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        ArabicPrologBaseListener listener = new ArabicPrologBaseListener();
    
		walker.DEFAULT.walk(listener, tree);
		code = ArabicPrologBaseListener.code.replaceAll(",\\)", "\\)")+";";
		code  = code.replaceAll(",;", ";");
		//System.out.println(code);
		}
		catch (Exception e){e.printStackTrace();}
		
		//convert String to java code with groovy
		Binding binding = new Binding();
		GroovyShell shell = new GroovyShell(binding);
		shell.setProperty("constants", constants);
		shell.setProperty("variables", variables);
		shell.setProperty("cuts", cuts);
		shell.setProperty("id", id);
		Object value = shell.evaluate(
				  "import unification_solver.*	;"
				+ "import front_end.Converter 	;"
				+ "Object a = "+code+" return a;");
		Object a = value;
		return a;
	}
	
	public static int numberVariableOfCurrentQuery() {
		return query.length() - query.replace("؟", "").length();
	}
	
	public static List solve(SimpleSentence goal) {
		long startTime = System.nanoTime();
		List results = new LinkedList<String>();
		AbstractSolutionNode root = goal.getSolver(ruleSet, new SubstitutionSet());
		SubstitutionSet solution;
		while ((solution = root.nextSolution()) != null) {
			int termCount = goal.length();
			for(int i=0; i<termCount; i++) {
				Unifiable v = goal.getTerm(i);
				if(v instanceof Variable ) {
					if(v.replaceVariables(solution) instanceof SimpleSentence )
						if (ListProlog.isList((SimpleSentence) v.replaceVariables(solution)))
							results.add(v.toString()+"	=	"+ListProlog.getStringList((SimpleSentence) v.replaceVariables(solution))+"	");
						else
							results.add(v.toString()+"	=	"+v.replaceVariables(solution)+"	");
					else
						results.add(v.toString()+"	=	"+v.replaceVariables(solution)+"	");
				}
			}
			results.add("newLine");
		}
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("time: "+duration/1000000+" ms");
		return results;
	}
	
	public static List solve(Is is, RuleSet rules) {
		List results = new LinkedList<String>();
		IsSolutionNode root = (IsSolutionNode) is.getSolver(rules, new SubstitutionSet());
		SubstitutionSet solution;
		while ((solution = root.nextSolution()) != null) {
			int termCount = ((SimpleSentence) is.getOperand(0)).length();
			for(int i=0; i<termCount; i++) {
				Unifiable v = ((SimpleSentence) is.getOperand(0)).getTerm(i);
				if(v instanceof Variable ) {
					if(v.replaceVariables(solution) instanceof SimpleSentence )
						if (ListProlog.isList((SimpleSentence) v.replaceVariables(solution)))
							results.add(v.toString()+"	=	"+ListProlog.getStringList((SimpleSentence) v.replaceVariables(solution))+"	");
						else
							results.add(v.toString()+"	=	"+v.replaceVariables(solution)+"	");
					else
						results.add(v.toString()+"	=	"+v.replaceVariables(solution)+"	");
				}
			}
			results.add("newLine");
		}
		return results;
	}
	
	public static List solve(Unify unify, RuleSet rules) {
		List results = new LinkedList<String>();
		UnifySolutionNode root = (UnifySolutionNode) unify.getSolver(rules, new SubstitutionSet());
		SubstitutionSet solution;
		while ((solution = root.nextSolution()) != null) {
			int termCount = ((SimpleSentence) unify.getOperand(0)).length();
			for(int i=0; i<termCount; i++) {
				Unifiable v = ((SimpleSentence) unify.getOperand(0)).getTerm(i);
				if(v instanceof Variable ) {
					if(v.replaceVariables(solution) instanceof SimpleSentence )
						if (ListProlog.isList((SimpleSentence) v.replaceVariables(solution)))
							results.add(v.toString()+"	=	"+ListProlog.getStringList((SimpleSentence) v.replaceVariables(solution))+"	");
						else
							results.add(v.toString()+"	=	"+v.replaceVariables(solution)+"	");
					else
						results.add(v.toString()+"	=	"+v.replaceVariables(solution)+"	");
				}
			}
			results.add("newLine");
		}
		return results;
	}

}
