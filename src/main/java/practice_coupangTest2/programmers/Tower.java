package practice_coupangTest2.programmers;

import java.util.Arrays;
import java.util.Stack;

public class Tower {

    public static void main(String[] args){
        int[][] heights = {
                {6,9,5,7,4},
                {3,9,9,3,5,7,2},
                {1,5,3,6,7,6,5}
        };
        for(int[] height : heights){
            new Tower().solve(height);
        }
    }

    private void solve(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int n = heights.length; // 5
        int[] result = new int[n];
        int min = heights[n-1];
        stack.push(min);
        for(int i=n-2; i>=0; i--){
            int cnt = 0;
            while(!stack.isEmpty()){
                int h = stack.peek();
                if(heights[i] > h){
                    stack.pop();
                    cnt++;
                    result[i+cnt] = i+1;
                } else {
                    break;
                }
            }
            stack.push(heights[i]);
        }

        System.out.println(Arrays.toString(result));
    }
}
