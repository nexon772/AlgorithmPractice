package inflearn.stringAndArray;

import java.util.Stack;

/**
 * Stack
 *
 * example #1
 * Input:
 * int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
 * Output:
 * 1 1 4 2 1 1 0 0
 */

public class DailyTemperature {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        printArray(solve(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }

    private static int[] solve(int[] temps){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temps.length];

        for(int i=0; i<temps.length; i++){
            while(!stack.isEmpty() && temps[stack.peek()] < temps[i]){
                int idx = stack.pop();
                result[idx] = i-idx;
            }
            stack.push(i);

        }

        return result;
    }

    private static void printArray(int[] nums){
        if(nums != null) {
            System.out.print("Output: { ");
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println("}");
        } else {
            System.out.println("null");
        }
    }
}
