package operators;

import sdc.BinaryOperation;
import sdc.IncompatibleTypeException;
import sdc.Value;

public class GreaterOrEqualOperation extends BinaryOperation {

    public boolean parse(String s) {
	return s.equals("=<");
    }
    
    public Value compute(Value v1, Value v2) throws IncompatibleTypeException {
	return v1.greaterOrEqual(v2);
    }

}
