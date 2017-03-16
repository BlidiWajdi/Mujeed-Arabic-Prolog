package unification_solver;

import java.util.*;

/**
 * @author Bill
 *
 *         Most of the acapability of And is in the AbstractOperator parent
 *         class which defines accessors for operands, and in the
 *         AndSolutionNode, which defines how to to search it.
 */
public class And extends AbstractOperator {

	public And(Goal... operands) {
		super(operands);
	}

	public And(ArrayList<Goal> operands) {
		super(operands);
	}

	public AbstractSolutionNode getSolver(RuleSet rules, SubstitutionSet parentSolution) {
		return new AndSolutionNode(this, rules, parentSolution);
	}

	/**
	 * définition de standardizeVariablesApart de And: 
	 * standardizeVariablesApart des operands 
	 */
	public PCExpression standardizeVariablesApart(Hashtable<Variable, Variable> newVars) {
		ArrayList<Goal> newOperands = new ArrayList<Goal>();

		for (int i = 0; i < operandCount(); i++)
			newOperands.add((Goal) getOperand(i).standardizeVariablesApart(newVars));

		return new And(newOperands);
	}
	
	/**
	 * définition de replaceVariables de And: 
	 * replaceVariables des operands 
	 */
	public PCExpression replaceVariables(SubstitutionSet s) {
		ArrayList<Goal> newOperands = new ArrayList<Goal>();

		for (int i = 0; i < operandCount(); i++)
			newOperands.add((Goal) getOperand(i).replaceVariables(s));

		return new And(newOperands);
	}
	
	/**
	 * toString de And
	 */
	public String toString() {
		String result = new String("(AND ");
		for (int i = 0; i < operandCount(); i++)
			result = result + getOperand(i).toString();
		return result;
	}
}
