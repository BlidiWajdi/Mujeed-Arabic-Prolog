package front_end;

import java.util.LinkedList;
import java.util.List;

import unification_solver.SimpleSentence;
import unification_solver.Unifiable;

/**
 * @author Wajdi
 *
 */

public class Tree extends SimpleSentence {

	private static SimpleSentence tree;

	public Tree(Unifiable[] args) {
		List tree = new LinkedList<Unifiable>();
		for(int i=0; i<args.length; i++)
			if((args[i].toString().equals("!")) &&
				(!Converter.isOperator(args[i+1].toString())))	{
					tree.add(new SimpleSentence(args[i],new SimpleSentence(args[i+1])));	
					i++;
				}		
			else if((Converter.isOperator(args[i].toString()))&&
					(!Converter.isOperator(args[i+1].toString()))&&
						(!Converter.isOperator(args[i+2].toString()))) {
				 	tree.add( new SimpleSentence(args[i],new SimpleSentence(args[i+1],args[i+2])));
				 	i=i+2;
			}
			else 
				tree.add(args[i]);
			
		if(tree.size()>1)
			 new Tree((Unifiable[]) tree.toArray(new Unifiable[tree.size()]));
		
		else if(tree.size()==1)
			this.tree = (SimpleSentence) tree.get(0);
		
	}
	
	public SimpleSentence getTree() {
		return tree;
	}
	
}
