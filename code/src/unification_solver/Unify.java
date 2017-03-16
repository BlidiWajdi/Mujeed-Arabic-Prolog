package unification_solver;

import java.util.*;

/**
 * @author Wajdi
 */
public class Unify extends AbstractOperator {

	public Unify(Goal... operands) {
		super(operands);
	}

	public Unify(ArrayList<Goal> operands) {
		super(operands);
	}

	public AbstractSolutionNode getSolver(RuleSet rules, SubstitutionSet parentSolution) {
		return new UnifySolutionNode(this, rules, parentSolution);
	}
	
	public PCExpression standardizeVariablesApart(Hashtable<Variable, Variable> newVars) {
		ArrayList<Goal> newOperands = new ArrayList<Goal>();

		for (int i = 0; i < operandCount(); i++)
			newOperands.add((Goal) getOperand(i).standardizeVariablesApart(newVars));

		return new Unify(newOperands);
	}
	
	public PCExpression replaceVariables(SubstitutionSet s) {
		ArrayList<Goal> newOperands = new ArrayList<Goal>();

		for (int i = 0; i < operandCount(); i++)
			newOperands.add((Goal) getOperand(i).replaceVariables(s));

		return new Unify(newOperands);
	}

	public String toString() {
		String result = new String("(Unify ");
		for (int i = 0; i < operandCount(); i++)
			result = result + getOperand(i).toString();
		return result;
	}
}
