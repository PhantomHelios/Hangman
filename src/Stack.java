public class Stack {
    private Object[] stack;
    private int top;

    public Stack(int capacity){
        stack = new Object[capacity];
        top = -1;
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top + 1 == stack.length);
    }

    public void push(Object object){
        if (isFull())
            System.out.println("Stack Overflow!");
        else{
            top++;
            stack[top] = object;
        }
    }

    public Object peek(){
        if (isEmpty()){
            System.out.println("Stack is Empty!");
            return null;
        }
        else return stack[top];
    }

    public Object pop(){
        if (isEmpty()){
            System.out.println("Stack is Empty!");
            return null;
        }
        else{
            top--;
            return stack[top + 1];
        }
    }

    public int size(){
        return top + 1;
    }
}
