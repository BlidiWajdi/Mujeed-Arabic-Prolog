package sdc;

public class BooleanValue extends Value {

    private boolean value;

    public BooleanValue() {
    	this(false);
    }

    public BooleanValue(boolean value) {
	this.value = value;
    }

    public boolean parse(String s) {
	if(s.equals("صحيح")) {
	    this.value = true;
	    return true;
	}
	else if(s.equals("خطأ")) {
	    this.value = false;
	    return true;
	}
	else
	    return false;
    }
    
    public String toString() {
    	if(this.value)
    		return "صحيح";
    	else
    		return "خطأ";
    }
    
    public Value and(Value v) throws IncompatibleTypeException {
    	if(v instanceof BooleanValue)
    		return new BooleanValue(Boolean.logicalAnd(((BooleanValue) v).value, this.value));
    	else
    		throw new IncompatibleTypeException();
    }
    
    public Value or(Value v) throws IncompatibleTypeException {
    	if(v instanceof BooleanValue)
    		return new BooleanValue(Boolean.logicalOr(((BooleanValue) v).value, this.value));
    	else
    		throw new IncompatibleTypeException();
    }
    
    public Value not() {
    	if (this.value)
    		return new BooleanValue(false);
    	else
    		return new BooleanValue(true);
        }
    
    public Value add(Value v) throws IncompatibleTypeException {
    		throw new IncompatibleTypeException();
    }

    public Value multiply(Value v) throws IncompatibleTypeException {
    		throw new IncompatibleTypeException();
    }

    public Value divide(Value v) throws IncompatibleTypeException {
    		throw new IncompatibleTypeException();
    }
    
    public Value div(Value v) throws IncompatibleTypeException {
    		throw new IncompatibleTypeException();
	}
    
    public Value mod(Value v) throws IncompatibleTypeException {
    		throw new IncompatibleTypeException();
	}

    public Value substract(Value v) throws IncompatibleTypeException {
    		throw new IncompatibleTypeException();
    }

    public Value abs() throws IncompatibleTypeException {
    	throw new IncompatibleTypeException();
    }
    
    public Value less(Value v) throws IncompatibleTypeException {
		throw new IncompatibleTypeException();
    }
    
    public Value lessOrEqual(Value v) throws IncompatibleTypeException {
		throw new IncompatibleTypeException();
    }
    
    public Value greater(Value v) throws IncompatibleTypeException {
		throw new IncompatibleTypeException();
    }
    
    public Value greaterOrEqual(Value v) throws IncompatibleTypeException {
		throw new IncompatibleTypeException();
    }
    
    public Value equal(Value v) throws IncompatibleTypeException {
    	if(v instanceof BooleanValue)
    		if(((BooleanValue) v).value == this.value)
    			return new BooleanValue(true);
    		else
    			return new BooleanValue(false);
    	else
    		throw new IncompatibleTypeException();
    }
    
    public Value notEqual(Value v) throws IncompatibleTypeException {
    	if(v instanceof BooleanValue)
    		if(((BooleanValue) v).value != this.value)
    			return new BooleanValue(true);
    		else
    			return new BooleanValue(false);
    	else
    		throw new IncompatibleTypeException();
    }

}
