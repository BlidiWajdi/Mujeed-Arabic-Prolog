
package unification_solver;

/**
 * @author Bill Stubblefield
 *
 * Unifiable defines those PCExpressions that can be matched through
 * the unify method.
 * 
 * The hierarchy that includes unifiable is:
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
 * One of the early design decisions concerned what was unifiable. In an earlier
 * version of the program, all PCExpressions were made unifiable. In this version,
 * the unify method handled both matching and search. This version of the code separates
 * matching and search. Unifiable expressions are simple sentences, constants and variables. 
 * Goals will be simple sentences and the operators And, Or and Not. These will form the nodes
 * of the and/or graph search.
 * 
 * Under this approach, rules are treated as an exception, since they do not form nodes
 * of the tree, but links between them. This idea of treating rules separately as 
 */

/**
 * @author Bill Stubblefield
 *
 *         unify will take as arguments a unifiable expression and a
 *         substitution set, and determine if its object will unify with the
 *         expression under the substitution set. As a side effect, it will add
 *         the new argument to the substitution set.
 * 
 *         Design note: there was some argument as to whether to make unify a
 *         method on substitution set. The advantage of this is that it
 *         eliminates the side effect of modifying the substitution set on
 *         creating a new variable binding. The disadvantage of this approach is
 *         that it requires testing on expression type in the unify algorithm,
 *         which is a slow operation and generally considered to be bad style. A
 *         third approach, of having unify return a substitution set as a result
 *         (and null on failure) makes the modification of the substitution set,
 *         but loses the convenience for testing of having the return type be a
 *         boolean.
 */
public interface Unifiable extends PCExpression {
	/**
	 * un Unifiable (Constant, Variable ou SimpleSentence) doit définir la fonction unify
	 * @see		la fonction unify (chapitre 23: AI Algorithms, Data Structures and Idioms in Prolog, Lisp, and Java)	
	 */
	public SubstitutionSet unify(Unifiable exp, SubstitutionSet s);
}
