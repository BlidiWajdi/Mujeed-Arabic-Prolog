package sdc;

import java.util.Stack;

public abstract class Value implements Symbol {
	private static Stack<Value> s;

    public void execute(Stack<Value> s) {
    	this.s=s;
    	s.push(this);
    }
    
    public static Stack<Value> getStack() {
		return s;
    }

    public abstract Value multiply(Value v) throws IncompatibleTypeException;
    public abstract Value divide(Value v) throws IncompatibleTypeException;
    public abstract Value add(Value v) throws IncompatibleTypeException;
    public abstract Value substract(Value v) throws IncompatibleTypeException;
    public abstract Value mod(Value v) throws IncompatibleTypeException;
    public abstract Value div(Value v) throws IncompatibleTypeException;
    public abstract Value abs() throws IncompatibleTypeException;
    
    public abstract Value and(Value v) throws IncompatibleTypeException;
    public abstract Value or(Value v) throws IncompatibleTypeException;
    public abstract Value not() throws IncompatibleTypeException;
    
    public abstract Value equal(Value v) throws IncompatibleTypeException;
    public abstract Value notEqual(Value v) throws IncompatibleTypeException;
    
    public abstract Value less(Value v) throws IncompatibleTypeException;
    public abstract Value lessOrEqual(Value v) throws IncompatibleTypeException;
    
    public abstract Value greater(Value v) throws IncompatibleTypeException;
    public abstract Value greaterOrEqual(Value v) throws IncompatibleTypeException;
 
}
