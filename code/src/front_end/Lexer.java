package front_end;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import unification_solver.Unifiable;
import unification_solver.Variable;

public class Lexer { 

	private static List<Couple> lexemes = new LinkedList<Couple>();
	
    public static enum Category {
    	Unification("="),Evaluation("يساوي"),True("صحيح"),False("خطأ"),If(":-"),Separator(","),EOQ("."),
    	Equality("=="),Inequality("=!"),GreaterOrEqual("=<"),LessOrEqual("=>"),Greater("<"),Less(">"),
        Add("+"), Sub("-"), Mul("*"), Div("\\"),Mod("%"),
        And("&"), Or("|"),Not("!"),Anonymous("_"),
        LPAR ("("), RPAR (")"),
        Constant(null), Variable(null),Integer(null), Double(null), EOF(null), ERROR (null);

        final private String lexeme;
        Category (String s) {
            lexeme = s;
        }
    }

    public String lastLexeme;

    private static HashMap<String, Category> tokenMap = new HashMap<String, Category> ();
    static {
        for (Category c : Category.values ())
            tokenMap.put (c.lexeme, c);
    }
    
    private Scanner inp;

    private static final Pattern tokenPat = 
        Pattern.compile ( 
       /*groupe 1: tout les espaces*/	
		"(\\s+|#.*)" +
		/*Mots ClÃ©s composÃ©*/	
		"|:-|==|=!|=<|=>"+
		/*groupe 2: les variables*/
		//"|(ØŸ?\\p{InArabic}+([0-9]|\\p{InArabic})*)"+
		"|(؟\\p{InArabic}[\\p{InArabic}|[0-9]]*)"+
		/*groupe 3: les constantes*/
		//"|(\\p{InArabic}+[0-9]|\\p{InArabic}*)"+
		"|(\\p{InArabic}[\\p{InArabic}|[0-9]]*)"+
		/*groupe 4: les doubles*/
		"|(-?[0-9]+\\.[0-9]+)" +
		/*groupe 5: les entier*/
		"|(-?[0-9]+)" +
		/*groupe 6: les listes*/
		/*groupe 7: coupure*/
		
		/* supporter tous les scriptes */
		
		"|=|>|<|\\+|\\*|\\|%|\\&|\\||\\(|\\)|!|-|.|,|_|\\p{L}+"
		);
	
    public Lexer (Reader reader) {
        inp = new Scanner (reader);
    }

    public Category nextToken () {
        if (inp.findWithinHorizon (tokenPat, 0) == null)
            return Category.EOF;
        else {
            lastLexeme = inp.match ().group (0);
            if (inp.match ().start (1) != -1)
                return nextToken ();
            else if (inp.match ().start (2) != -1)
                return Category.Variable;
            else if (inp.match().start (3) != -1) 
                return Category.Constant;
            else if (inp.match ().start (4) != -1)
                return Category.Double;
            else if (inp.match ().start (5) != -1)
                return Category.Integer;
            Category result = tokenMap.get (lastLexeme);
            if (result == null)
                return Category.ERROR;
            else
                return result;
        }
    }
    public static List<Couple> getLexemes(String code){
    	code = code.replaceAll("،", ",");
    	InputStream inputStream = new ByteArrayInputStream(code.getBytes());
    	Lexer in = new Lexer(new InputStreamReader(inputStream)) ;
    	while (in.inp.hasNext()){
    		Category cat = in.nextToken();
    		if(in.lastLexeme.equals("صحيح"))
    			lexemes.add(new Couple("True","صحيح"));
    		else if (in.lastLexeme.equals("خطأ"))
    			lexemes.add(new Couple("False","خطأ"));
    		else if (in.lastLexeme.equals("يساوي"))
    			lexemes.add(new Couple("Evaluation","يساوي"));
    		else if (in.lastLexeme.equals("قطع"))
    			lexemes.add(new Couple("Cut","قطع"));
    		else
    			lexemes.add(new Couple(cat.toString(),in.lastLexeme));
    	}
    	return lexemes;
    }
    
    public static String[] getLexemesOnlyValue(String code){
    	List lexemes = new LinkedList<String>();
    	InputStream inputStream = new ByteArrayInputStream(code.getBytes());
    	Lexer in = new Lexer(new InputStreamReader(inputStream)) ;
    	while (in.inp.hasNext()){
    		in.nextToken();
    		if(in.lastLexeme.equals("صحيح"))
    			lexemes.add("صحيح");
    		else if (in.lastLexeme.equals("خطأ"))
    			lexemes.add("خطأ");
    		else
    			lexemes.add(in.lastLexeme);
    	}
    	return (String[]) lexemes.toArray(new String[lexemes.size()]);
    }
}