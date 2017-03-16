package unification_solver;

import java.util.*;

/**
 * @author Wajdi
 */
public class VariableSet {

	private List variableSet = new LinkedList<Variable>();

	public VariableSet() {
	}

	public VariableSet(List variableSet) {
		this.variableSet = variableSet;
	}
	
	public VariableSet(Variable... args) {
		add(args);
	}

	/**
	 * ajouter un nouveau variable
	 */
	public void add(Variable v) {
		variableSet.add(v);
	}
	
	/**
	 * ajouter des nouveaus variables
	 */
	
	public void add(Variable... args) {
		for(int i=0; i<args.length; i++)
			variableSet.add(args[i]);
	}
	
	/**
	 * @return retourner la variable v depuis VariableSet 
	 */
	public Variable getVariable(String token) {
		for (int i=0; i<variableSet.size(); i++)
			if(token.equals(variableSet.get(i).toString()))
				return (Variable) variableSet.get(i);
		return null;
	}
	
	/**
	 * vérifie si une Variable est liée
	 */
	public boolean Exist(String token) {
		for (int i=0; i<variableSet.size(); i++)
			if(token.equals(variableSet.get(i).toString()))
				return true;
		return false;
	}
	
	/**
	 * toString de VariableSet
	 */

	public String toString() {
		String variables="";
		for (int i=0; i<variableSet.size(); i++)
			variables+=" "+variableSet.get(i).toString()+" ";
		return "VariableSet:[" + variables + "]";
	}

	public int size() {
		// TODO Auto-generated method stub
		return variableSet.size();
	}

	public String get(int i) {
		// TODO Auto-generated method stub
		return variableSet.get(i).toString();
	}
	
}
