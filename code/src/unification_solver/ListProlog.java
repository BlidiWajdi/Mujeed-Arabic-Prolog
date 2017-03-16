package unification_solver;

/**
 * @author Wajdi
 *
 *         Une Liste est constituée d'un Head et un Tail 
 *         le Head est un Unifiable
 *         le tail est une liste 
 *         la liste: [a,b,c,d] = (.a .(b .(c .(d []))))
 */

public class ListProlog extends SimpleSentence {
	
	private static Constant functor = new Constant(".");
	private static Constant emptyList = new Constant("[]");
	private static SimpleSentence list ;
	
	/**
	 * Constructeur: creation d'une liste
	 */
	public ListProlog(Unifiable... args) {
			Unifiable Head = args[0];
			Unifiable[] Tail = new Unifiable[args.length-1];
			System.arraycopy(args, 1, Tail, 0, args.length-1);
		
			if(!Tail[0].equals(emptyList))
				list = new SimpleSentence(functor, Head,new ListProlog(Tail).list);
			else
				list = new SimpleSentence(functor, Head,Tail[0]);
	}

	public static Constant getFunctor() {
		return functor;
	}

	public static Constant getEmptyList() {
		return emptyList;
	}

	public static SimpleSentence getList() {
		return list;
	}

	public static boolean isList(SimpleSentence simpleSentence) {
		return simpleSentence.getTerm(0).equals(functor);
	}

	public static String getStringList(SimpleSentence simpleSentence) {
		// TODO Auto-generated method stub
		String list = "[";
		Unifiable unifiable = simpleSentence; 
		while (unifiable instanceof SimpleSentence) {
			SimpleSentence temp = (SimpleSentence) unifiable;
			list += temp.getTerm(1)+"، ";
			unifiable = temp.getTerm(2);
		}
		list += "]";
		list = list.replaceAll("، ]", "]");
		return list;
	}
	
}
