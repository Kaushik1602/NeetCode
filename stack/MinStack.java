package stack;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    Integer min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int val) {
        min = Math.min(val,min);
        minStack.push(min);
        stack.push(val);
    }

    public void pop() {
        minStack.pop();
        stack.pop();
        min = minStack.empty()?Integer.MAX_VALUE:minStack.peek();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

