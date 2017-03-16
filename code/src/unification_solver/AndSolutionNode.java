package unification_solver;

import java.util.*;

public class AndSolutionNode extends AbstractSolutionNode {
	private AbstractSolutionNode headSolutionNode = null;
	private AndSolutionNode tailSolutionNode = null;
	private And tailGoal = null;
	
	/**
	 * pour satisfaire AndSolutionNode il faut satisfaire tout les opérands (goals)
	 */

	public AndSolutionNode(And goal, RuleSet rules, SubstitutionSet parentSolution) {
		super(rules, parentSolution);
		headSolutionNode = goal.firstOperand().getSolver(rules, parentSolution);
		ArrayList<Goal> tail = goal.tailOperands();

		if (tail.isEmpty() != true)
			tailGoal = new And(tail);
	}

	/**
	 * nextSolution en suivant la logique de And 
	 * @see		[ref]chapitre 24: AI Algorithms, Data Structures and Idioms in Prolog, Lisp, and Java
	 */
	public SubstitutionSet nextSolution() {
		SubstitutionSet solution;
		if (tailSolutionNode != null) {
			solution = tailSolutionNode.nextSolution();
			if (solution != null)
				return solution;
		}

		while ((solution = headSolutionNode.nextSolution()) != null) {

			if (tailGoal == null)
				return solution;
			else {
				tailSolutionNode = new AndSolutionNode(tailGoal, getRuleSet(), solution);

				SubstitutionSet tailSolution = tailSolutionNode.nextSolution();
				if (tailSolution != null)
					return tailSolution;
			}
		}
		return null;
	}
}
