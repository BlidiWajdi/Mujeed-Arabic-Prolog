package unification_solver;

public class CutSolutionNode extends AbstractSolutionNode {
	
	private SubstitutionSet parentSolution;
	private boolean backSolution=false;
	
	public CutSolutionNode(Cut goal, RuleSet rules, SubstitutionSet parentSolution) {
		super(rules, parentSolution);
		this.backSolution=false;
		this.parentSolution = parentSolution;
	}

	public SubstitutionSet nextSolution() {
		if(!backSolution) {
			backSolution = true;
			return parentSolution;
			}
		Cut.cuts.noNextSolution(Cut.id);
		return null;
	}

	
}
