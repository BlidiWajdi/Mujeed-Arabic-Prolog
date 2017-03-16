package front_end;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import unification_solver.Constant;
import unification_solver.SimpleSentence;
import unification_solver.Unifiable;
import unification_solver.VariableSet;
 
public class Converter
{	
	private static String LPAREN = "(";
    private static String RPAREN = ")";
    
	private static String ADD = "+";
    private static String SUB = "-";
    private static String MUL = "*";
    private static String DIV = "\\";
    private static String MOD = "%";
    
    private static String AND = "&";
    private static String OR = "|";
    private static String NOT = "!";
    
    private static String EQUAL = "==";
    private static String NOTEQUAL = "=!";
    private static String LESS = ">";
    private static String LESSOREQUAL = "=>";
    private static String GREATER = "<";
    private static String GREATEROREQUAL = "=<";
     
    //function that returns the priority level of the passed operator parameter
    public static int getOperatorPriority(String operator){
        int retval = -1;
        if(operator.equals(LPAREN) ){
            retval = 100;
        }
        else if(operator.equals(NOT)){
            retval = 1;
        }
        else if(operator.equals(MUL) || operator.equals(DIV) || operator.equals(MOD) ){
            retval = 2;
        }
        else if(operator.equals(ADD) || operator.equals(SUB)){
            retval = 3;
        }
        else if( operator.equals(LESS) || operator.equals(LESSOREQUAL) 
        	|| operator.equals(GREATER) || operator.equals(GREATEROREQUAL)){
            retval = 4;
        }
        else if(operator.equals(EQUAL)	|| operator.equals(NOTEQUAL) ){
            retval = 5;
        }
        else if(operator.equals(AND)){
            retval = 6;
        }
        else if(operator.equals(OR)){
            retval = 7;
        }
        return retval;
    }
 
    //function that tests if the parameter is an operator
    public static boolean isOperator(String operator){
        return operator.equals(ADD) || operator.equals(SUB) 
            || operator.equals(MUL) || operator.equals(DIV)
            || operator.equals(MOD) || operator.equals(AND) 
            || operator.equals(OR)  || operator.equals(NOT) 
            || operator.equals(EQUAL)       || operator.equals(NOTEQUAL) 
            || operator.equals(LESS) 		|| operator.equals(LESSOREQUAL)
            || operator.equals(GREATER)		|| operator.equals(GREATEROREQUAL);
    }
    
    private static List sortLexemes(String Infix, VariableSet variables) {
	StackArray operatorStack = new StackArray();
    String tokens[] = Lexer.getLexemesOnlyValue(Infix);
    String token = "";
    List postfix = new LinkedList<Unifiable>();
    int tokenPriority = 0; 

    for(int i=0; i<tokens.length; i++){    
    	
        if(tokens[i].equals(LPAREN)){
            operatorStack.push(tokens[i]);
        }
        else if(tokens[i].equals(RPAREN)){
            while(!operatorStack.isEmpty()){  
                token  = operatorStack.topAndPop();
                if(token.equals(LPAREN)){
                    break;
                }
                postfix.add(new Constant(token));
            }
        }
        else if(isOperator(tokens[i])){
            tokenPriority = getOperatorPriority(tokens[i]);
            
                while(!operatorStack.isEmpty() && getOperatorPriority(operatorStack.top()) <= tokenPriority){
                    token = operatorStack.topAndPop();
                    if(!token.equals(LPAREN)){
                    	postfix.add(new Constant(token));
                    }
                }
            
            operatorStack.push(tokens[i]);
        }
        else{
        	if (variables != null)
        		if (variables.Exist(tokens[i]))
        			postfix.add(variables.getVariable(tokens[i]));
        		else
        			postfix.add(new Constant(tokens[i]));
        	else
    			postfix.add(new Constant(tokens[i]));
        }
    }

    while(!operatorStack.isEmpty()){
        token = operatorStack.topAndPop();
        if(!token.equals(LPAREN)){
        	postfix.add(new Constant(token));
        }
    }
	
    return postfix	;
    }
    
    //function that converts from infix to postfix notation
    public static SimpleSentence infixToPostfix(String Infix){
    	List postfix = sortLexemes(Infix, null);
        return new SimpleSentence((Unifiable[]) postfix.toArray(new Unifiable[postfix.size()]));
    }
    
    //function that converts from infix to tree notation
    public static SimpleSentence infixToTree(String Infix, VariableSet variables){
    	List postfix = sortLexemes(Infix,variables);
    	Collections.reverse(postfix);
        return (SimpleSentence) new Tree((Unifiable[]) postfix.toArray(new Unifiable[postfix.size()])).getTree();
    }
}