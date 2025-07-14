package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

    private void backtrack(int openN, int closedN, int n, List<String> res, Stack<String> stack) {
        if (openN == closedN && openN == n) {
            StringBuilder s1 = new StringBuilder();
            for(String s: stack){
                s1.append(s);
            }
            res.add(s1.toString());
            return;
        }

        if (openN < n) {
            stack.push("(");
            backtrack(openN + 1, closedN, n, res, stack);
            stack.pop();
        }
        if (closedN < openN) {
            stack.push(")");
            backtrack(openN, closedN + 1, n, res, stack);
            stack.pop();
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        backtrack(0, 0, n, res, stack);
        return res;
    }
}
