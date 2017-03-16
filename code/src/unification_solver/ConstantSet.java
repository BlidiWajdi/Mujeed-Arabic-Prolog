package unification_solver;

import java.util.*;

/**
 * @author Wajdi
 */
public class ConstantSet {

	private List constantSet = new LinkedList<Constant>();

	public ConstantSet() {
	}

	public ConstantSet(List constantSet) {
		this.constantSet = constantSet;
	}
	
	public ConstantSet(Constant... args) {
		add(args);
	}

	/**
	 * ajouter un nouveau Constant
	 */
	public void add(Constant v) {
		constantSet.add(v);
	}
	
	/**
	 * ajouter des nouveaus Constants
	 */
	
	public void add(Constant... args) {
		for(int i=0; i<args.length; i++)
			constantSet.add(args[i]);
	}
	
	/**
	 * @return retourner la Constant v depuis ConstantSet 
	 */
	public Constant getConstant(String token) {
		for (int i=0; i<constantSet.size(); i++)
			if(token.equals(constantSet.get(i).toString()))
				return (Constant) constantSet.get(i);
		return null;
	}
	
	/**
	 * vérifie si une Constant est liée
	 */
	public boolean Exist(String token) {
		for (int i=0; i<constantSet.size(); i++)
			if(token.equals(constantSet.get(i).toString()))
				return true;
		return false;
	}
	
	/**
	 * toString de ConstantSet
	 */

	public String toString() {
		String Constants="";
		for (int i=0; i<constantSet.size(); i++)
			Constants+=" "+constantSet.get(i).toString()+" ";
		return "ConstantSet:[" + Constants + "]";
	}

	public int size() {
		// TODO Auto-generated method stub
		return constantSet.size();
	}

	public String get(int i) {
		// TODO Auto-generated method stub
		return constantSet.get(i).toString();
	}
	
}
