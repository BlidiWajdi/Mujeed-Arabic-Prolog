package unification_solver;

import front_end.Converter;

public class OpTermsSolutionNode extends AbstractSolutionNode {
	private SubstitutionSet parentSolution;
	private static boolean backSolution=false;
	private SimpleSentence expressionToUnify;
	public static Variable RES;
	
	public OpTermsSolutionNode(Unify goal, RuleSet rules, SubstitutionSet parentSolution) {
		super(rules, parentSolution);
		
		expressionToUnify = (SimpleSentence) ((SimpleSentence) goal.getOperand(0)).getTerm(0);
		
		/*System.out.println("goal              -> "+goal);
		System.out.println("expressionToUnify -> "+expressionToUnify);*/
	
		this.backSolution=false;
		this.parentSolution = parentSolution;
	}

	public SubstitutionSet nextSolution() {
		if(!this.backSolution) {
			backSolution = true;
			SimpleSentence expression = (SimpleSentence) Converter.infixToPostfix(expressionToUnify.replaceVariables(parentSolution).toString());
			//System.out.println("expression        -> "+expression);
			//System.out.println("evaluation        -> "+expression.evaluate());
			RES = new Variable("RES");
			parentSolution.add(RES, expression.evaluate());
			
			if((expression.evaluate().toString().charAt(0)=='خ') 
				&& (expression.evaluate().toString().charAt(1)=='ط') 
					&& (expression.evaluate().toString().charAt(2)=='أ')) {
				return null;}
			else 
				return parentSolution;
			}
		return null;
	}

	
}
