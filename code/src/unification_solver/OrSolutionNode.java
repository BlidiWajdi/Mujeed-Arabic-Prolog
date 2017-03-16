package unification_solver;

import java.util.*;

public class OrSolutionNode extends AbstractSolutionNode {
	private Or goal;
	private RuleSet rules;
	private SubstitutionSet parentSolution;
	private List operands;
	
	/**
	 * satisfaire un seul goal est satisfaisant
	 */
	public OrSolutionNode(Or goal, RuleSet rules, SubstitutionSet parentSolution) {
		super(rules, parentSolution);
		this.goal = goal;
		
		operands = new LinkedList();
		for(int i=0; i<goal.operandCount(); i++)
			operands.add(goal.getOperand(i).getSolver(rules, parentSolution));
	}
	
	/**
	 * une seul solution est satisfaisante
	 */
	public SubstitutionSet nextSolution() {
		SubstitutionSet solution;
		ListIterator operandsIterator = operands.listIterator();
		
		while(operandsIterator.hasNext()){
			AbstractSolutionNode s = (AbstractSolutionNode) (operandsIterator.next());
			solution = s.nextSolution();
			if(solution != null){
				return(solution);
			}
		}
		return null;
	}

	
}
