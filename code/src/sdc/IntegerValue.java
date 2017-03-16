package sdc;

public class IntegerValue extends Value {

    private int value;

    public IntegerValue() {
	this(0);
    }

    public IntegerValue(int value) {
	this.value = value;
    }

    public boolean parse(String s) {
	try {
	    this.value = Integer.parseInt(s);
	} catch (NumberFormatException e) {
	    return false;
	}
	return true;
    }
    
    public String toString() {
	return "" + this.value;
    }

    public Value add(Value v) throws IncompatibleTypeException {
    	if(v instanceof IntegerValue)
    		return new IntegerValue(((IntegerValue) v).value + this.value);
    	else if (v instanceof DoubleValue)
    		return new DoubleValue(((DoubleValue) v).getValue() + this.value);
    	else 	// v instanceof BooleanValue
    		throw new IncompatibleTypeException();
    }

    public Value multiply(Value v) throws IncompatibleTypeException {
    	if(v instanceof IntegerValue)
    		return new IntegerValue(((IntegerValue) v).value * this.value);
    	else if (v instanceof DoubleValue)
    		return new DoubleValue(((DoubleValue) v).getValue() * this.value);
    	else
    		throw new IncompatibleTypeException();
    }

    public Value divide(Value v) throws IncompatibleTypeException {
    	if(v instanceof IntegerValue)
    		return new IntegerValue(((IntegerValue) v).value / this.value);
    	else if (v instanceof DoubleValue) 
    		return new DoubleValue(((DoubleValue) v).getValue() / this.value);
    	else
    		throw new IncompatibleTypeException();
    }
    
    public Value div(Value v) throws IncompatibleTypeException {
    	if(v instanceof IntegerValue)
    		return new IntegerValue(((IntegerValue) v).value / this.value);
    	else
    		throw new IncompatibleTypeException();
	}
    
    public Value mod(Value v) throws IncompatibleTypeException {
    	if(v instanceof IntegerValue)
    		return new IntegerValue(((IntegerValue) v).value % this.value);
    	else
    		throw new IncompatibleTypeException();
	}

    public Value substract(Value v) throws IncompatibleTypeException {
    	if(v instanceof IntegerValue)
    		return new IntegerValue(((IntegerValue) v).value - this.value);
    	else if (v instanceof DoubleValue)
    		return new DoubleValue(((DoubleValue) v).getValue() - this.value);
    	else
    		throw new IncompatibleTypeException();
    }

    public Value abs() {
	if (this.value < 0) {
	    return new IntegerValue(-1 * this.value);
	} else {
	    return new IntegerValue(this.value);
	}
    }
    
    public Value and(Value v) throws IncompatibleTypeException {
		throw new IncompatibleTypeException();
    }
    
    public Value or(Value v) throws IncompatibleTypeException {
		throw new IncompatibleTypeException();
    }
    
    public Value not() throws IncompatibleTypeException {
		throw new IncompatibleTypeException();
	}
    
    public Value equal(Value v) throws IncompatibleTypeException {
    	if(v instanceof IntegerValue)
    		if(((IntegerValue) v).value == this.value)
    			return new BooleanValue(true);
    		else
    			return new BooleanValue(false);
    	else
    		throw new IncompatibleTypeException();
    }
    
    public Value notEqual(Value v) throws IncompatibleTypeException {
    	if(v instanceof IntegerValue)
    		if(((IntegerValue) v).value != this.value)
    			return new BooleanValue(true);
    		else
    			return new BooleanValue(false);
    	else
    		throw new IncompatibleTypeException();
    }
    
    public Value less(Value v) throws IncompatibleTypeException {
    	if(v instanceof IntegerValue)
    		if(((IntegerValue) v).value < this.value)
    			return new BooleanValue(true);
    		else
    			return new BooleanValue(false);
    	else
    		throw new IncompatibleTypeException();
    }
    
    public Value lessOrEqual(Value v) throws IncompatibleTypeException {
    	if(v instanceof IntegerValue)
    		if(((IntegerValue) v).value <= this.value)
    			return new BooleanValue(true);
    		else
    			return new BooleanValue(false);
    	else
    		throw new IncompatibleTypeException();
    }
    
    public Value greater(Value v) throws IncompatibleTypeException {
    	if(v instanceof IntegerValue)
    		if(((IntegerValue) v).value > this.value)
    			return new BooleanValue(true);
    		else
    			return new BooleanValue(false);
    	else
    		throw new IncompatibleTypeException();
    }
    
    public Value greaterOrEqual(Value v) throws IncompatibleTypeException {
    	if(v instanceof IntegerValue)
    		if(((IntegerValue) v).value >= this.value)
    			return new BooleanValue(true);
    		else
    			return new BooleanValue(false);
    	else
    		throw new IncompatibleTypeException();
    }

}
