package front_end;

import java.util.*;

/**
 * @author Wajdi
 */
public class HistoryQuery {

	private List historyQuerySet = new LinkedList<String>();

	public HistoryQuery() {
	}

	/**
	 * ajouter une nouvelle requete
	 */
	public void add(String query) {
		historyQuerySet.add(query);
	}
	
	/**
	 * @return retourner la i eme requete depuis historyQuerySet
	 */
	public String getQuery(int i) {
		return (String) historyQuerySet.get(i);
	}

	public int size() {
		return historyQuerySet.size();
	}
	
}
