package stack;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length()%2!=0){
            return false;
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            try{
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                }else if(c==stack.peek()+1 || c==stack.peek()+2){
                    stack.pop();
                }else {
                    return false;
                }
            }catch (Exception e){
                System.out.println(e);
                return false;
            }
        }

        return stack.empty();
    }
}
