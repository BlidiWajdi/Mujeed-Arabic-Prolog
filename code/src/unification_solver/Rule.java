package unification_solver;

import java.util.Hashtable;

/**
 * @author Bill
 *
 *         Rule is defined strictly, as a Horn clause, where the head is a
 *         simple sentence, and the body a simpleSentence or operation (And, Or,
 *         Not). A rule with only a head is an assertion (this approach of
 *         making both complete rules and assertions types of rules simplifies
 *         their handling in the RuleSet class and search nodes). Assertions,
 *         are leafs of the search tree.
 */
public class Rule implements PCExpression {

	private SimpleSentence head;
	private Goal body;

	/**
	 * Constructeur des Faits
	 */
	public Rule(SimpleSentence head) {
		this(head, null);
	}
	
	/**
	 * Constructeur des Régles
	 */

	public Rule(SimpleSentence head, Goal body) {
		this.head = head;
		this.body = body;

	}
	
	/**
	 * @return retourner le Head (premise)
	 */
	
	public SimpleSentence getHead() {
		return head;
	}
	
	/**
	 * @return retourner le body (tail)
	 */

	public Goal getBody() {
		return body;
	}
	
	/**
	 * définition de standardizeVariablesApart de Rule: 
	 * standardizeVariablesApart de Head et de Body
	 */
	public PCExpression standardizeVariablesApart(Hashtable<Variable, Variable> newVars) {
		SimpleSentence newHead = (SimpleSentence) getHead().standardizeVariablesApart(newVars);
		Goal newBody = null;
		if (getBody() != null)
			newBody = (Goal) getBody().standardizeVariablesApart(newVars);
		return new Rule(newHead, newBody);
	}
	
	/**
	 * définition de replaceVariables de Rule: 
	 * replaceVariables de Head et de Body
	 */

	public PCExpression replaceVariables(SubstitutionSet s) {
		SimpleSentence newHead = (SimpleSentence) getHead().replaceVariables(s);
		Goal newBody = null;
		if (getBody() != null)
			newBody = (Goal) getBody().replaceVariables(s);
		return new Rule(newHead, newBody);

	}
	
	/**
	 * toString des rules
	 */

	public String toString() {
		if (body == null)
			return head.toString();
		return head + " :- " + body;
	}

}
