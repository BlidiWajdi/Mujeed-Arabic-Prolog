package sdc;

import java.util.ArrayList;

public class Factory {

    private ArrayList<String> list;

    public Factory() {
	this.list = new ArrayList<String>();

	// add all types or operation here
	this.list.add("sdc.IntegerValue");
	this.list.add("sdc.DoubleValue");
	this.list.add("sdc.BooleanValue");

	this.list.add("sdc.ClearSymbol");
	this.list.add("sdc.ViewSymbol");

	this.list.add("operators.AddOperation");
	this.list.add("operators.SubOperation");
	this.list.add("operators.DivOperation");
	this.list.add("operators.MulOperation");
	this.list.add("operators.ModOperation");
	
	this.list.add("operators.AndOperation");
	this.list.add("operators.OrOperation");
	this.list.add("operators.NotOperation");
	
	this.list.add("operators.EqualOperation");
	this.list.add("operators.NotEqualOperation");
	this.list.add("operators.LessOperation");
	this.list.add("operators.GreaterOperation");
	this.list.add("operators.LessOrEqualOperation");
	this.list.add("operators.GreaterOrEqualOperation");
    }


    public Symbol[] registered() throws InternalError {
	ArrayList<Symbol> s = new ArrayList<Symbol>();

	for (String objectName : this.list) {
	    //objectName = "sdc." + objectName;
	    s.add(this.createInstance(objectName));
	}

	return s.toArray(new Symbol[this.list.size()]);
    }

    private Symbol createInstance(String className) throws InternalError {
	try {
	    Class cl = Class.forName(className);
	    java.lang.reflect.Constructor co = cl.getConstructor();
	    return (Symbol) co.newInstance();
	} catch (Exception e) {
	    throw new InternalError();
	}
    }

}
