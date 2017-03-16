package sdc;

public class DoubleValue extends Value {

    private double value;

    public DoubleValue() {
	this(0.0);
    }

    public DoubleValue(double value) {
	this.setValue(value);
    }

    public boolean parse(String s) {
	try {
	    this.setValue(Double.parseDouble(s));
	} catch (NumberFormatException e) {
	    return false;
	}
	return true;
    }
    
    public String toString() {
	return "" + this.getValue();
    }

    public Value add(Value v) throws IncompatibleTypeException {
        if(v instanceof IntegerValue)
        	return new DoubleValue(Double.parseDouble(v.toString()) + this.value); 
        else if (v instanceof DoubleValue)
        	return new DoubleValue(((DoubleValue) v).value + this.value);
        else
        	throw new IncompatibleTypeException();
    }

    public Value multiply(Value v) throws IncompatibleTypeException {
        if(v instanceof IntegerValue)
        	return new DoubleValue(Double.parseDouble(v.toString()) * this.value); 
        else if (v instanceof DoubleValue)
        	return new DoubleValue(((DoubleValue) v).value * this.value);
        else
        	throw new IncompatibleTypeException();
    }

    public Value divide(Value v) throws IncompatibleTypeException {
        if(v instanceof IntegerValue)
        	return new DoubleValue(Double.parseDouble(v.toString()) / this.value); 
        else if (v instanceof DoubleValue)
        	return new DoubleValue(((DoubleValue) v).value / this.value);
        else
        	throw new IncompatibleTypeException();
    }

    public Value substract(Value v) throws IncompatibleTypeException {
        if(v instanceof IntegerValue)
        	return new DoubleValue(Double.parseDouble(v.toString()) - this.value); 
        else if (v instanceof DoubleValue)
        	return new DoubleValue(((DoubleValue) v).value - this.value);
        else
        	throw new IncompatibleTypeException();
    }

    public Value abs() throws IncompatibleTypeException {
	if (this.getValue() < 0) {
	    return new DoubleValue(-1 * this.getValue());
	} else {
	    return new DoubleValue(this.getValue());
	}
    }

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Value mod(Value v) throws IncompatibleTypeException {
		throw new IncompatibleTypeException();
	}
	
	public Value div(Value v) throws IncompatibleTypeException {
		throw new IncompatibleTypeException();
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
    	if(v instanceof DoubleValue)
    		if(((DoubleValue) v).value == this.value)
    			return new BooleanValue(true);
    		else
    			return new BooleanValue(false);
    	else
    		throw new IncompatibleTypeException();
    }
	
	public Value notEqual(Value v) throws IncompatibleTypeException {
    	if(v instanceof DoubleValue)
    		if(((DoubleValue) v).value != this.value)
    			return new BooleanValue(true);
    		else
    			return new BooleanValue(false);
    	else
    		throw new IncompatibleTypeException();
    }
	
	public Value less(Value v) throws IncompatibleTypeException {
    	if(v instanceof DoubleValue)
    		if(((DoubleValue) v).value < this.value)
    			return new BooleanValue(true);
    		else
    			return new BooleanValue(false);
    	else
    		throw new IncompatibleTypeException();
    }
	
	public Value lessOrEqual(Value v) throws IncompatibleTypeException {
    	if(v instanceof DoubleValue)
    		if(((DoubleValue) v).value <= this.value)
    			return new BooleanValue(true);
    		else
    			return new BooleanValue(false);
    	else
    		throw new IncompatibleTypeException();
    }
    
    public Value greater(Value v) throws IncompatibleTypeException {
    	if(v instanceof DoubleValue)
    		if(((DoubleValue) v).value > this.value)
    			return new BooleanValue(true);
    		else
    			return new BooleanValue(false);
    	else
    		throw new IncompatibleTypeException();
    }
    
    public Value greaterOrEqual(Value v) throws IncompatibleTypeException {
    	if(v instanceof DoubleValue)
    		if(((DoubleValue) v).value >= this.value)
    			return new BooleanValue(true);
    		else
    			return new BooleanValue(false);
    	else
    		throw new IncompatibleTypeException();
    }

}
