package unification_solver;

import java.util.*;

/**
 * @author Wajdi
 */
public class Cut extends AbstractOperator {
	public static CutSet cuts;
	public static int id;

	public Cut(Goal... operands) {
		super(operands);
	}

	public Cut(ArrayList<Goal> operands) {
		super(operands);
	}

	public Cut(CutSet cuts, int id) {
		this.id=id;
		cuts.add(id);
		this.cuts = cuts;
	}

	public AbstractSolutionNode getSolver(RuleSet rules, SubstitutionSet parentSolution) {
		if (cuts.getBinding(id))
			return new CutSolutionNode(this, rules, parentSolution);
		else
			return new CutSolutionNode(this, rules, null);		
	}
	
	public PCExpression standardizeVariablesApart(Hashtable<Variable, Variable> newVars) {
		ArrayList<Goal> newOperands = new ArrayList<Goal>();

		for (int i = 0; i < operandCount(); i++)
			newOperands.add((Goal) getOperand(i).standardizeVariablesApart(newVars));

		return new Cut(newOperands);
	}
	
	public PCExpression replaceVariables(SubstitutionSet s) {
		ArrayList<Goal> newOperands = new ArrayList<Goal>();

		for (int i = 0; i < operandCount(); i++)
			newOperands.add((Goal) getOperand(i).replaceVariables(s));

		return new Cut(newOperands);
	}

	public String toString() {
		String result = new String("(Cut ");
		for (int i = 0; i < operandCount(); i++)
			result = result + getOperand(i).toString();
		return result;
	}
}
