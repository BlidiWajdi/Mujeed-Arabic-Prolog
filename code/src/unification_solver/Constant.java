package unification_solver;

import java.util.Hashtable;

public class Constant implements Unifiable {

	private String printName;

	private static int nextId = 1;

	private int id;
	
	/**
	 * Constructeur: creation d'une Constante dont l'id = nextId ++ 
	 */
	
	public Constant() {
		this.id = nextId++;
	}
	
	/**
	 * Constructeur: creation d'une Constante dont l'id = nextId ++ et le nom = printName
	 * @param printName nom de la constante
	 */
	
	public Constant(String printName) {
		this();
		this.printName = printName;
	}
	
	
	/**
	 * définition des standardizeVariablesApart de constante
	 * @param newVars
	 * @return la constante courante
	 */

	public PCExpression standardizeVariablesApart(Hashtable<Variable, Variable> newVars) {
		return this;
	}
	
	/**
	 * définition de replaceVariables de Constant
	 * @param s
	 * @return la constante courante
	 */
	
	public PCExpression replaceVariables(SubstitutionSet s) {
		return this;
	}
	
	/**
	 * la fonction unify de Constant
	 * @param	 p
	 * 				un <b>Unifiable</b> (Constante ou Variable)
	 * @param	 s
	 * 				<b>SubstitutionSet</b>
	 * @return	<b>SubstitutionSet</b>
	 * 				retourner la substition vide {} si <b>p</b> égale la constante courante 
	 * 				sinon si <b>p</b> est un variable alors utilise la fonction unify de variable
	 * @see		la fonction unify (chapitre 23: AI Algorithms, Data Structures and Idioms in Prolog, Lisp, and Java)				
	 */

	public SubstitutionSet unify(Unifiable p, SubstitutionSet s) {
		// We can unify with another constant by comparing
		if (this == p)
			return new SubstitutionSet(s);

		if (p instanceof Variable)
			return p.unify(this, s);

		return null;
	}

	/**
	 * redéfinition de la méthode equals
	 * @param	 o
	 * 				l'objet à comparer avec la constante courante
	 * @return	<b>Boolean</b>
	 * 				retourner true si l'id de l'objet passé en parametre et l'id de la constante courante sont égales
	 * 				sinon retouner false 
	 */
	
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Constant))
			return false;
		return id == ((Constant) o).id;
	}
	
	/**
	 * toString pour Constant
	 */
	public String toString() {
		if (printName != null)
			return printName;
		return "a" + id;
	}
}
