package unification_solver;

import front_end.Converter;

public class IsSolutionNode extends AbstractSolutionNode {
	
	private SubstitutionSet parentSolution;
	private static boolean backSolution=false;
	private Variable left;
	private SimpleSentence right;
	
	public IsSolutionNode(Unify goal, RuleSet rules, SubstitutionSet parentSolution) {
		super(rules, parentSolution);
		left = (Variable) ((SimpleSentence) goal.getOperand(0)).getTerm(0);
		right = (SimpleSentence) ((SimpleSentence) goal.getOperand(0)).getTerm(1);
		this.backSolution=false;
		this.parentSolution = parentSolution;
	}

	/**
	 * Unification de la partie gauche avec l'evaluation de la partie droite
	 */
	public SubstitutionSet nextSolution() {
		if(!this.backSolution) {
			backSolution = true;
			parentSolution.add(left, right);
			SimpleSentence expression = (SimpleSentence) Converter.infixToPostfix(left.replaceVariables(parentSolution).toString());
			parentSolution.add(left, expression.evaluate());
			return parentSolution;
			}
		return null;
	}

	
}
