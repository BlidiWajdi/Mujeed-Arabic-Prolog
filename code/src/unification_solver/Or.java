package unification_solver;

import java.util.*;

/**
 * @author Bill
 *
 *         Most of the acapability of And is in the AbstractOperator parent
 *         class which defines accessors for operands, and in the
 *         AndSolutionNode, which defines how to to search it.
 */
public class Or extends AbstractOperator {

	public Or(Goal... operands) {
		super(operands);
	}

	public Or(ArrayList<Goal> operands) {
		super(operands);
	}

	public AbstractSolutionNode getSolver(RuleSet rules, SubstitutionSet parentSolution) {
		return new OrSolutionNode(this, rules, parentSolution);
	}
	
	/**
	 * définition de standardizeVariablesApart de Or: 
	 * standardizeVariablesApart des operands 
	 */
	public PCExpression standardizeVariablesApart(Hashtable<Variable, Variable> newVars) {
		ArrayList<Goal> newOperands = new ArrayList<Goal>();

		for (int i = 0; i < operandCount(); i++)
			newOperands.add((Goal) getOperand(i).standardizeVariablesApart(newVars));

		return new Or(newOperands);
	}
	
	/**
	 * définition de replaceVariables de Or: 
	 * replaceVariables des operands 
	 */
	public PCExpression replaceVariables(SubstitutionSet s) {
		ArrayList<Goal> newOperands = new ArrayList<Goal>();

		for (int i = 0; i < operandCount(); i++)
			newOperands.add((Goal) getOperand(i).replaceVariables(s));

		return new Or(newOperands);
	}

	/**
	 * toString de Or
	 */
	public String toString() {
		String result = new String("(OR ");
		for (int i = 0; i < operandCount(); i++)
			result = result + getOperand(i).toString();
		return result;
	}
}
