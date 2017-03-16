package unification_solver;

import java.util.*;

/**
 * @author Wajdi
 */
public class Is extends Unify {

	public Is(Goal... operands) {
		super(operands);
	}

	public Is(ArrayList<Goal> operands) {
		super(operands);
	}

	public AbstractSolutionNode getSolver(RuleSet rules, SubstitutionSet parentSolution) {
		return new IsSolutionNode(this, rules, parentSolution);
	}
	
	public PCExpression standardizeVariablesApart(Hashtable<Variable, Variable> newVars) {
		ArrayList<Goal> newOperands = new ArrayList<Goal>();

		for (int i = 0; i < operandCount(); i++)
			newOperands.add((Goal) getOperand(i).standardizeVariablesApart(newVars));

		return new Is(newOperands);
	}
	
	public PCExpression replaceVariables(SubstitutionSet s) {
		ArrayList<Goal> newOperands = new ArrayList<Goal>();

		for (int i = 0; i < operandCount(); i++)
			newOperands.add((Goal) getOperand(i).replaceVariables(s));

		return new Is(newOperands);
	}

	public String toString() {
		String result = new String("(Is ");
		for (int i = 0; i < operandCount(); i++)
			result = result + getOperand(i).toString();
		return result;
	}
}
