package unification_solver;

public class UnifySolutionNode extends AbstractSolutionNode {
	
	private SubstitutionSet parentSolution;
	private static boolean backSolution=false;
	private Variable left;
	private SimpleSentence right;
	
	public UnifySolutionNode(Unify goal, RuleSet rules, SubstitutionSet parentSolution) {
		super(rules, parentSolution);
		left = (Variable) ((SimpleSentence) goal.getOperand(0)).getTerm(0);
		right = (SimpleSentence) ((SimpleSentence) goal.getOperand(0)).getTerm(1);
		this.backSolution=false;
		//System.out.println(parentSolution);
		this.parentSolution = parentSolution;
	}

	/**
	 * Unification de la partie gauche avec l'evaluation de la partie droite
	 */
	public SubstitutionSet nextSolution() {
		if(!this.backSolution) {
			backSolution = true;
			parentSolution.add(left, right);
			return parentSolution;
			}
		return null;
	}

	
}
