package unification_solver;

import java.util.*;

/**
 * @author Bill
 *
 *         SubstitutionSet manages a HashTable of bindings. In an earlier
 *         version of the code, this class was much more powerful, including
 *         much of the larger unification capability. In the final version, it
 *         is little more than a wrapper on a hash table.
 * 
 *         The reason for doing this, rather than just using a hash table is
 *         twofold:
 * 
 *         1. To clarify design intent. 2. To support addition of
 *         content-specific error types (e.g. the add method could throw an
 *         error if we tried to add a binding for a variable that was already
 *         bound). Adding this could be a nice exercise.
 */
public class SubstitutionSet {

	private HashMap<Variable, Unifiable> bindings = new HashMap<Variable, Unifiable>();

	public SubstitutionSet() {
	}

	public SubstitutionSet(SubstitutionSet s) {
		this.bindings = new HashMap<Variable, Unifiable>(s.bindings);
	}

	/**
	 * effacer toutes les liaisons
	 */
	public void clear() {
		bindings.clear();
	}

	/**
	 * ajouter une nouvelle liaison
	 */
	public void add(Variable v, Unifiable exp) {
		bindings.put(v, exp);
	}
	
	/**
	 * @return retourner la liaison du Variable v 
	 */
	public Unifiable getBinding(Variable v) {
		return (Unifiable) bindings.get(v);
	}
	
	/**
	 * vérifie si une Variable est liée
	 */
	public boolean isBound(Variable v) {
		return bindings.get(v) != null;
	}
	
	/**
	 * toString des SubstitutionSet
	 */

	public String toString() {
		return "Bindings:[" + bindings + "]";
	}
	
}
