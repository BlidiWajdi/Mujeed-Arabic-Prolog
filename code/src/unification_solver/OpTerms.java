package unification_solver;

import java.util.*;

/**
 * @author Wajdi
 */
public class OpTerms extends Unify {

	public OpTerms(Goal... operands) {
		super(operands);
	}

	public OpTerms(ArrayList<Goal> operands) {
		super(operands);
	}

	public AbstractSolutionNode getSolver(RuleSet rules, SubstitutionSet parentSolution) {
		return new OpTermsSolutionNode(this, rules, parentSolution);
	}
	
	public PCExpression standardizeVariablesApart(Hashtable<Variable, Variable> newVars) {
		ArrayList<Goal> newOperands = new ArrayList<Goal>();

		for (int i = 0; i < operandCount(); i++)
			newOperands.add((Goal) getOperand(i).standardizeVariablesApart(newVars));

		return new OpTerms(newOperands);
	}
	
	public PCExpression replaceVariables(SubstitutionSet s) {
		ArrayList<Goal> newOperands = new ArrayList<Goal>();

		for (int i = 0; i < operandCount(); i++)
			newOperands.add((Goal) getOperand(i).replaceVariables(s));

		return new OpTerms(newOperands);
	}

	public String toString() {
		String result = new String("(OpTerms ");
		for (int i = 0; i < operandCount(); i++)
			result = result + getOperand(i).toString();
		return result;
	}
}
