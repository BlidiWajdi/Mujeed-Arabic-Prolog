package operators;

import sdc.IncompatibleTypeException;
import sdc.UnaryOperator;
import sdc.Value;

public class NotOperation extends UnaryOperator {

    public boolean parse(String s) {
	return s.equals("!");
    }
    
    public Value compute(Value v) throws IncompatibleTypeException {
	return v.not();
    }

}
