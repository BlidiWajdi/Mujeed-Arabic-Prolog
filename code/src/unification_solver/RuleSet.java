package unification_solver;

import java.util.Hashtable;

public class RuleSet {

	private Rule[] rules;
	
	/**
	 * une RuleSet est tableau des rules
	 */
	public RuleSet(Rule... rules) {
		this.rules = rules;
	}

	/**
	 * @return retourner le Rule standardisé à la position i
	 */
	public Rule getRuleStandardizedApart(int i) {
		Rule rule = (Rule) rules[i].standardizeVariablesApart(new Hashtable<Variable, Variable>());
		return rule;
	}

	/**
	 * @return retourner le Rule à la position i
	 */
	public Rule getRule(int i) {
		return rules[i];
	}

	/**
	 * @return retourner le nombre des rules
	 */
	public int getRuleCount() {
		return rules.length;
	}
	
	/**
	 * toString de RuleSet
	 */
	public String toString() {
		String s = null;
		for (PCExpression r : rules)
			if (s == null)
				s = r.toString();
			else
				s += "; " + r;
		if (s == null)
			return "true";
		return "(" + s + ")";
	}

}
