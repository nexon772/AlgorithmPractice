package inflearn.queueAndStack;

import java.util.Stack;

/**
 * #Map #Stack
 *
 * example #1
 * Input: "{[]}"
 * Output: true
 *
 * example #2
 * Input: "()[]{}"
 * Output: true
 *
 * example #3
 * Input: "([)]"
 * Output: false
 *
 * example #4
 * Input: "(]"
 * Output: false
 */
public class ValidParentheses {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        println(solve("{[]}")+"");
        println(solve("()[]{}")+"");
        println(solve("([)]")+"");
        println(solve("(]")+"");
    }

    private static boolean solve(String parentheses){
        if(parentheses.length()%2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<parentheses.length(); i++){
            switch (parentheses.charAt(i)){
                case '}':
                    if(!stack.empty() && stack.peek() == '{'){
                        stack.pop();
                    }
                    break;
                case ']':
                    if(!stack.empty() && stack.peek() == '['){
                        stack.pop();
                    }
                    break;
                case ')':
                    if(!stack.empty() && stack.peek() == '('){
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(parentheses.charAt(i));
                    break;
            }
        }
        return stack.isEmpty();
    }

    private static void println(String msg){
        System.out.println(msg);
    }

}
