package inflearn.stringAndArray;

import java.util.HashMap;
import java.util.Map;

/**
 * Map & Array
 *
 * example #1
 * Input:
 * int[] nums = {2,8,10,21};
 * int target = 10;
 * Output:
 * int[] = {1,2};
 *
 * example #2
 * Input:
 * int[] nums = {2,5,7,8,10}
 * int target = 15;
 * Output:
 * int[] = {3,4}
 *
 * example #3
 * Input:
 * int[] nums = {1,6,10,20}
 * int target = 12;
 * Output:
 * null;
 *
 * example #4
 * Input:
 * int[] nums = {1, 20, 30, 45 ,50 ,60 ,70};
 * int target = 70;
 * Output:
 * int[] = {2, 5}
 */

public class TwoSum {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        printArray(solve(new int[]{2,8,10,21}, 10));
        printArray(solve(new int[]{2,5,7,8,10}, 15));
        printArray(solve(new int[]{1,6,10,20}, 12));
        printArray(solve(new int[]{1,20,30,45,50,60,70}, 70));
    }

    private static int[] solve(int[] nums, int target){
        // My method
//        for(int i=0; i<nums.length-1; i++){
//            if(nums[i] + nums[i+1] == target){
//                return new int[]{i+1, i+2};
//            }
//        }
//        return null;

        // Using Map, Array method
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                int idx = map.get(nums[i]);
                return new int[]{idx+1, i+1};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return null;
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
