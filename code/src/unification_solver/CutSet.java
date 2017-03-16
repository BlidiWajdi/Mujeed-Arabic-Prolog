package unification_solver;

import java.util.*;

/**
 * @author Wajdi
 */
public class CutSet {

	private HashMap<Integer, Boolean> cuts = new HashMap<Integer, Boolean>();

	public CutSet() {
	}

	public CutSet(CutSet s) {
		this.cuts = new HashMap<Integer, Boolean>(s.cuts);
	}

	public void clear() {
		cuts.clear();
	}

	public void add(int v) {
		cuts.put(v, true);
	}
	
	public boolean getBinding(int v) {
		if(!cuts.isEmpty())
			return (boolean) cuts.get(v);
		return false;
	}
	
	public boolean isBound(int v) {
		return cuts.get(v) != null;
	}

	public String toString() {
		return "Cuts:[" + cuts + "]";
	}

	public void noNextSolution(int id) {
		cuts.replace(id, false);
	}

	public void initialize() {
		if (this != null) {
			Iterator iterator = cuts.keySet().iterator();
			while (iterator.hasNext())
				cuts.replace((Integer) iterator.next(), true);
			}
	}
	
}
