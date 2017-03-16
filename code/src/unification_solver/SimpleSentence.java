package unification_solver;

import java.util.Hashtable;

import sdc.ProcessingException;
import sdc.SDC;
import sdc.ShutdownException;
import sdc.Value;

/**
 *
 * SimpleSentence represents expressions of the form constant(Unifiable*).
 * 
 * Internally, the head an arguments of the SimpleSentence are represented as an
 * array, Unifiable[]. The constraint that a simpleSentence must have a constant
 * as its head is captured through the public constructor: public
 * SimpleSentence(Constant functor, Unifiable... args)
 * 
 * There is also a private constructor, private SimpleSentence(Unifiable...
 * args), that is used by the standardizeVariablesApart method.
 */
public class SimpleSentence implements Unifiable, Goal {

	private Unifiable[] terms;
	
	/**
	 * Constructeur d'un predicat: foncteur suivi par des Unifiables
	 */
	public SimpleSentence(Constant functor, Unifiable... args) {
		this.terms = new Unifiable[args.length + 1];
		terms[0] = functor;
		System.arraycopy(args, 0, terms, 1, args.length);
	}
	
	public SimpleSentence(Unifiable... args) {
		terms = args;
	}

	/**
	 * toString pour SimpleSentence
	 */
	
	public String toString() {
		String s = null;
		for (Unifiable p : terms)
			if (s == null)
				s = p.toString();
			else
				s += " " + p;
		if (s == null)
			return "false";
		return "( " + s + " )";
	}
	
	/**
	 * @return retourner le nombre des termes
	 */
	
	public int length() {
		return terms.length;
	}
	
	/**
	 * la fonction unify de SimpleSentence
	 * @see		la fonction unify (chapitre 23: AI Algorithms, Data Structures and Idioms in Prolog, Lisp, and Java)
	 */

	public SubstitutionSet unify(Unifiable p, SubstitutionSet s) {

		if (p instanceof Variable)
			return p.unify(this, s);

		// Unification with another List
		if (p instanceof SimpleSentence) {
			SimpleSentence s2 = (SimpleSentence) p;
			// Compare list lengths
			if (this.length() != s2.length())
				return null;

			// Unify pairs
			SubstitutionSet sNew = new SubstitutionSet(s);
			for (int i = 0; i < this.length(); i++) {
				sNew = this.getTerm(i).unify(s2.getTerm(i), sNew);
				if (sNew == null)
					return null;
			}
			return sNew;
		}

		return null;
	}
	
	/**
	 * dÃƒÂ©finition de standardizeVariablesApart de SimpleSentence: parcourir les Unifiables (Constant ou Variable)
	 * on applicant la fonction standardizeVariablesApart
	 */
	
	public PCExpression standardizeVariablesApart(Hashtable<Variable, Variable> newVars) {
		Unifiable[] newTerms = new Unifiable[terms.length]; // create an array
															// for new terms.
		for (int i = 0; i < length(); i++) {
			newTerms[i] = (Unifiable) terms[i].standardizeVariablesApart(newVars); // standardize
																					// apart
																					// each
																					// term.
																					// Only
																					// variables
																					// will
																					// be
																					// affected.
		}

		return new SimpleSentence(newTerms); // create a new simple sentence
												// with new variables.
	}
	
	/**
	 * @return retourner le terme ÃƒÂ  la position index
	 */
	public Unifiable getTerm(int index) {
		return terms[index];
	}
	
	/**
	 * @see		[ref]chapitre 24: AI Algorithms, Data Structures and Idioms in Prolog, Lisp, and Java
	 */
	public AbstractSolutionNode getSolver(RuleSet rules, SubstitutionSet parentSolution) {
		return new SimpleSentenceSolutionNode(this, rules, parentSolution);
	}
	
	/**
	 * dÃƒÂ©finition de replaceVariables de SimpleSentence: parcourir les Unifiables (Constant ou Variable)
	 * on applicant la fonction replaceVariables
	 */
	public PCExpression replaceVariables(SubstitutionSet s) {
		Unifiable[] newTerms = new Unifiable[terms.length]; // create an array
															// for new terms.
		for (int i = 0; i < length(); i++)
			newTerms[i] = (Unifiable) terms[i].replaceVariables(s);

		return new SimpleSentence(newTerms); // create a new simple sentence
												// with new variables.
	}
	
	/*public Variable evaluate(){
		Unifiable[] expression = this.terms;
		String postfixExpression="";
		for(int i=0; i<expression.length; i++)
			postfixExpression += " "+expression[i];
		Boolean error = false;
		
		SDC sdc = new SDC();
		
		try {
				try {
					sdc.executeLine(postfixExpression);
				} catch (ProcessingException e) {
					System.out.println(e.getMessage());
					error = true;
				}
		
				} catch (ShutdownException e) {
					System.out.println("Thank you for using sdc.");
					error = true;
		} catch (Exception e) {
		    System.out.println("!!! Internal error !!!");
		    e.printStackTrace();
		    error = true;
		}
		Value result = null;
		if ((!Value.getStack().isEmpty())&&(!error))
			result = Value.getStack().pop();
		if((Value.getStack().size()!=0)&&(!error)) {
			System.out.println("Ø¹Ø¨Ø§Ø±Ø© Ù…Ù†Ù‚ÙˆØµØ©");
			result = null;
		}
		return new Variable(result.toString());
	}*/
	
	public Variable evaluate(){
		Unifiable[] expression = this.terms;
		String postfixExpression="";
		for(int i=0; i<expression.length; i++)
			postfixExpression += " "+expression[i];
		Boolean error = false;
		
		SDC sdc = new SDC();
		
		try {
				try {
					sdc.executeLine(postfixExpression);
				} catch (ProcessingException e) {
					System.out.println(e.getMessage());
					error = true;
				}
		
				} catch (ShutdownException e) {
					System.out.println("Thank you for using sdc.");
					error = true;
		} catch (Exception e) {
		    System.out.println("!!! Internal error !!!");
		    e.printStackTrace();
		    error = true;
		}
		Value result = null;
		if ((!Value.getStack().isEmpty())&&(!error))
			result = Value.getStack().pop();
		if((Value.getStack().size()!=0)&&(!error)) {
			System.out.println("عبارة منقوصة");
			result = null;
		}
		return new Variable(result.toString());
	}
}
