package front_end;
//custom array-based stack class.
class StackArray{
    private String[] theArray;
    private int topOfStack;
 
    static final int DEFAULT_CAPACITY = 255;
 
    //constructor
    public StackArray(){
        this(DEFAULT_CAPACITY);
    }
 
    //constructor
    public StackArray(int capacity){
        theArray = new String[capacity];
        topOfStack = -1;
    }
 
    //tests whether the stack is empty or not
    public boolean isEmpty( ){
        return topOfStack == -1;
    }
 
    //function that tests whether the stack is already full
    public boolean isFull(){
        return topOfStack == theArray.length - 1;
    }
 
    //function which sets the stack to empty
    public void makeEmpty(){
        topOfStack = -1;
    }
 
    //function which returns the top of the stack
    public String top(){
        if(isEmpty()){
            return null;
        }
        return theArray[topOfStack];
    }
 
    //function which pops the top item on the stack
    public void pop(){
        if(!isEmpty()){
            theArray[topOfStack--] = null;
        }
    }
 
    //function which inserts item on the stack
    public void push(String x){
        if(!isFull()){          
            theArray[++topOfStack] = x;
        }
    }
         
    //function which pops the top item on the stack and then returns it.
    public String topAndPop(){
        if(isEmpty()){
            return null;
        }
        String topItem = top();
        theArray[topOfStack--] = null;
        return topItem;
    }
}