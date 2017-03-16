package sdc;

import java.util.Stack;

public class ViewSymbol implements Symbol {
    
    public boolean parse(String s) {
	return s.equals("view");
    }
    
    public void execute(Stack<Value> s) throws ShutdownException {
    	if (s.isEmpty())
    		System.out.println("la pile est vide !");
    	else
    		for (int i=0; i<s.size(); i++)
    			System.out.println("	"+s.elementAt(i));
    }

}