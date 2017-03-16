package unification_solver;

import java.util.*;

/**
 * @author Bill
 *
 *         AbstractOperator is a common java pattern of creating an abstract
 *         implementation of an interface to define common functions. These are
 *         mainly methods to access operands.
 */
public abstract class AbstractOperator implements Goal {

	private ArrayList<Goal> operands;

	/**
	 * un opérateur est constitué par des operands
	 * chaque opérand représente un Goal
	 */
	public AbstractOperator(Goal... operands) {
		Goal[] operandArray = operands;

		this.operands = new ArrayList<Goal>();

		for (int i = 0; i < operandArray.length; i++) {
			this.operands.add(operandArray[i]);
		}
	}

	public AbstractOperator(ArrayList<Goal> operands) {
		this.operands = operands;
	}
	
	/**
	 * @return retouner le nombre des operands
	 */

	public int operandCount() {
		return operands.size();
	}

	/**
	 * @return retouner l'operand à la position i
	 */
	public Goal getOperand(int i) {
		return operands.get(i);
	}
	
	/**
	 * @return retouner le premier Operand
	 */
	public Goal firstOperand() {
		return operands.get(0);
	}
	
	/**
	 * @return retouner les operands de Tail (tous les operands sauf le premier)
	 */
	public ArrayList<Goal> tailOperands() {
		ArrayList<Goal> tail = new ArrayList<Goal>(operands);
		tail.remove(0);
		return tail;
	}

	/**
	 * vérifie s'il existe des operand
	 */
	public boolean isEmpty() {
		return operands.isEmpty();
	}

}
