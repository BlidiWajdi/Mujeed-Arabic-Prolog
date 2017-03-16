/**
 * @author Bill Stubblefield
 * 
 * Goal is part of the hierarchy rooted at PCExperssions:
 * 
 * PCExpression
 * 		|
 * 		|- unifiable
 * 			|- constant
 * 			|- variable
 * 			|- simpleSentence
 * 		|- goal
 * 			|- simpleSentence
 * 			|- abstractOperator
 * 				|-AND
 * 				|-OR
 * 				|-Not
 * 		|- rule
 * 
 * The method getSolver() returns a solver for the particular type of goal. The
 * getSolver method takes as arguments the rule set, which enables searching on 
 * the different rules, and the substitution set in the parent solution.
 * 
 * An earlier version of this used a Factory pattern to return solution nodes. 
 * This required testing on type of the goal to determine the proper solution node
 * to return. Because testing on types is often considered poor style, we chose to make 
 * each goal return the appropriate node.
 */

package unification_solver;

public interface Goal extends PCExpression {
	/** un Goal doit définir la fonction getSolver
	 * @see		chapitre 24: AI Algorithms, Data Structures and Idioms in Prolog, Lisp, and Java
	 */
	public AbstractSolutionNode getSolver(RuleSet rules, SubstitutionSet parentSolution);
}
