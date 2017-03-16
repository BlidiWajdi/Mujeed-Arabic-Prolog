package unification_solver;

/**
 * @author Bill
 *
 *         The strategy implied by AbstractSolutionNode is straightforward. It
 *         saves the substition set with which it was created as the context of
 *         its subtree. It then creates new substitution sets to complete the
 *         solution. This allows backtracking to the original substitution set
 *         (original state).
 * 
 *         It also keeps pointers into the rule set, remembering the last rule
 *         tried. When these pointers "run off the end" of the rule set, the
 *         node has finished its search, causing backtrack to the parent.
 * 
 *         Essentially, solution nodes are analogous to stack frames in the
 *         search.
 */
public abstract class AbstractSolutionNode {

	private RuleSet rules;

	// saving the parent solution allows backtracking to the original state
	private SubstitutionSet parentSolution;

	// These variables allow the solution node to iterate over the rule set.
	private int ruleNumber = 0;

	/**
	 * une AbstractSolutionNode contenant les rules et des SubstitutionSet
	 */
	public AbstractSolutionNode(RuleSet rules, SubstitutionSet parentSolution) {
		this.rules = rules;
		this.parentSolution = parentSolution;
	}

	public abstract SubstitutionSet nextSolution();

	/**
	 * @return retouner le prochain Rule
	 */
	protected Rule nextRule() {
		if (hasNextRule())
			return rules.getRuleStandardizedApart(ruleNumber++);
		else
			return null;
	}
	
	/**
	 * vérifie s'il y a des autres rules
	 */
	protected boolean hasNextRule() {
		return ruleNumber < rules.getRuleCount();
	}
	
	/**
	 * @return retourner la substitutionSet du noeud courant
	 */
	protected SubstitutionSet getParentSolution() {
		return parentSolution;
	}

	protected RuleSet getRuleSet() {
		return rules;
	}

}
