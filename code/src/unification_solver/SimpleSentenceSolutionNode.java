package unification_solver;

public class SimpleSentenceSolutionNode extends AbstractSolutionNode {

	private SimpleSentence goal;
	private AbstractSolutionNode child = null;

	public SimpleSentenceSolutionNode(SimpleSentence goal, RuleSet rules, SubstitutionSet parentSolution) {
		super(rules, parentSolution);
		this.goal = goal;
	}
	
	/**
	 *  @see		[ref]chapitre 24: AI Algorithms, Data Structures and Idioms in Prolog, Lisp, and Java
	 */
	public SubstitutionSet nextSolution() {
		SubstitutionSet solution;
		if (child != null) {
			solution = child.nextSolution();
			if (solution != null)
				return solution;
		}

		child = null;

		Rule rule;

		while (hasNextRule() == true) {
			rule = nextRule();

			SimpleSentence head = rule.getHead();

			solution = goal.unify(head, getParentSolution());
			if (solution != null) {
				Goal tail = rule.getBody();
				if (tail == null)
					return solution;
				child = tail.getSolver(getRuleSet(), solution);
				SubstitutionSet childSolution = child.nextSolution();
				if (childSolution != null)
					return childSolution;
			}

		}

		return null;
	}

}
