package inflearn.queueAndStack;

import java.util.Stack;

/**
 * #Stack
 *
 * example #1:
 * Input:
 * ["5", "-2", "4", "C", "D", "9", "+", "+"]
 * Output:
 * 27
 * Explanation:
 * 1. The sum is 5
 * 2. -2 points, 5-2 = 3
 * 3. 4 points, 3+4 = 7
 * 4. cancel data from #3, 7-4 = 3
 * 5. double data from #2: -2 * 2 = -4, 3-4 = -1
 * 6. 9 points, -1+9 = 8
 * 7. add sum of prev two data -4+9 = 5, 8+5 = 13
 * 8. add sum of prev two data 5+9 = 14, 13+14 = 27
 */
public class BaseballGame {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        println(solve(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"})+"");
    }

    private static int solve(String[] input){
        Stack<Integer> stack = new Stack<>();
        int point = 0;
        for(int i=0; i<input.length; i++){
            switch (input[i]){
                case "+":
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b);
                    stack.push(a);
                    stack.push(a+b);
                    break;
                case "C":
                    stack.pop();
                    break;
                case "D":
                    int temp = stack.peek();
                    stack.push(temp * 2);
                    break;
                default:
                    stack.push(Integer.parseInt(input[i]));
                    break;
            }
        }

        int size = stack.size();
        for(int i=0; i<size; i++){
            point += stack.pop();
        }

        return point;
    }

    private static void println(String msg){
        System.out.print(msg);
    }
}
