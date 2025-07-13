package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if(!"+-*/".contains(token)) {
                stack.push(Integer.parseInt(token));
            }else {
                stack.push(evaluate(stack.pop(), stack.pop(), token));
            }
        }
        return stack.pop();
    }

    private int evaluate(int num1,  int num2, String operator) {
        return switch (operator) {
            case "+" -> num2 + num1;
            case "-" -> num2 - num1;
            case "*" -> num2 * num1;
            case "/" -> num2 / num1;
            default -> 0;
        };
    }

}
