package sdc;

import java.util.Stack;

public interface Symbol {
    // the root type. All features must be defined by inheriting from
    // this type and overriding routines Parse and Execute below.

    // All types derived from Symbol must provide this routine.  Given
    // a string S, Parse must determine whether S can form an object with
    // the same type as T. If so, a pointer to a new object is
    // returned. Otherwise, exception Not_Matching is raised.
    public boolean parse(String s);

    //  Execute T, ie undertake the corresponding actions.
    public void execute(Stack<Value> s) throws ShutdownException, IncompatibleTypeException;
}