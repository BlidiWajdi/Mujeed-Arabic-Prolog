/**
 * @author Bill Stubblefield
 *
 * PCExpression is the root of the hierarchy of Predicate Calculus expressions. 
 * Its descendants will include the elements of Predicate Calculus statements (constants & variables),
 * simple sentences (of the form p(. . .)), n-ary operators (And(operands*), Or(operands*)), negation( Not(operand),
 * and Rules (rule(head, tail)).
 * 
 * The hierarchy of PCExperssions is:
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
 * In this hierarchy, it is somewhat odd that rule is not considered a type of operator. This is a practical
 * result of the way the algorithm works. Because it constructs an AND/OR graph of the solution space, it needs
 * to distinguish nodes in the space from other sentences. Since a rule is not a node in the space but actually
 * represents a link between nodes, we must distinguish them. Goals are sentences that can correspond to nodes
 * in the space.
 * 
 * The method standardizeVariablesApart(...) is used in the problem solver to give each instance of 
 * an expression its own variable objects. This is necessary for multiple bindings of a rule in 
 * a search (as in recursive search).
 * 
 */
package unification_solver;

import java.util.Hashtable;

/**
 * @author Bill Stubblefield
 *
 *         The argument newVars contains a list of existing variable
 *         replacements. The intent is that before replacing a variable with a
 *         new variable, check this list to see if there is already a new
 *         variable with which to replace it.
 */
public interface PCExpression {
	public PCExpression standardizeVariablesApart(Hashtable<Variable, Variable> newVars);
	public PCExpression replaceVariables(SubstitutionSet s);
}
