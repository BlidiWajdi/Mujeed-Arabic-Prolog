package sdc;

import java.util.Stack;

public abstract class UnaryOperator implements Symbol {

    public abstract Value compute(Value v) throws IncompatibleTypeException;

    public void execute(Stack<Value> s) throws IncompatibleTypeException {
	
    Value v = s.pop();
	
	s.push(this.compute(v));
    }

}
