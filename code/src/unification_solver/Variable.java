package unification_solver;

import java.util.Hashtable;

/**
 * @author Bill
 *
 *         The intent of the Variable class is that each instance will represent
 *         an occurrance of a variable in a context (e.g. a rule or other
 *         sentence). That way, comparisons in unify can be done with an ==
 *         test.
 */
public class Variable implements Unifiable {

	private String printName = null;
	protected static int nextId = 1; // Allows anonymous variables, indicated only
									// by id. Also, it is useful in tracing
									// solutions after standardizing variables
									// apart.
	protected int id;

	/**
	 * Constructeur: creation d'une Variable dont l'id = nextId ++ et le nom = printName
	 */
	
	public Variable(String printName) {
		this.id = nextId++;
		this.printName = printName;
	}
	
	/**
	 * Constructeur: creation d'une Variable par copie
	 */

	// Copy constructor. Currently considered to be better style than cloning.
	public Variable(Variable v) {
		this.id = nextId++;
		this.printName = v.printName;
	}
	
	/**
	 * la fonction unify de Variable
	 * @param	 p
	 * 				un <b>Unifiable</b> (Constante ou Variable)
	 * @param	 s
	 * 			 	SubstitutionSet contenant les Variables et leures binding 
	 * @return	<b>SubstitutionSet</b>
	 * 				retourner <b>s</b> sans modification si <b>p</b> est égale au Variable courant
	 * 				sinon si la variable courant est lié alors on vérifie la liaison et la nouvelle Unifiable p
	 * 				sinon (la variable est libre) alors on retourne s avec la nouvelle liaison <this,p> 
	 * @see		la fonction unify (chapitre 23: AI Algorithms, Data Structures and Idioms in Prolog, Lisp, and Java)
	 */

	public SubstitutionSet unify(Unifiable p, SubstitutionSet s) {
		// Unification with self always succeeds
		if (this == p)
			return s;

		// Find existing binding and unify with it, if one exists
		if (s.isBound(this))
			return s.getBinding(this).unify(p, s);

		// No binding? make a new one and succeed
		SubstitutionSet sNew = new SubstitutionSet(s);
		sNew.add(this, p);
		return sNew;

	}

	/**
	 * définition de standardizeVariablesApart de Variable: mettre à jour <b>newVars</b>
	 * @param newVars les variables et leurs binding 
	 * @return retourner le Variable courant
	 */
	
	public PCExpression standardizeVariablesApart(Hashtable<Variable, Variable> newVars) {
		Variable newVar = newVars.get(this); // Try to see if the current
												// expression already has a
												// substitute variable.
		if (newVar == null) { // if not create one.
			newVar = new Variable(this);
			newVars.put(this, newVar);
		}
		return newVar;
	}
	
	/**
	 * définition de replaceVariables de Variable
	 * @param s SubstitutionSet
	 * @return retourner la valeur de la variable si elle est liée sinon (libre) elle retourne la variable
	 */
	
	public PCExpression replaceVariables(SubstitutionSet s) {

		if (s.isBound(this))
			return s.getBinding(this).replaceVariables(s);
		else
			return this;

	}
	
	/**
	 * toString pour Variable
	 */
	public String toString() {
		if (printName != null)
			return printName;
		return "V";
	}

}
