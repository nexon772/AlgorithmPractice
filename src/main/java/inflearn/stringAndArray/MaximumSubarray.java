package inflearn.stringAndArray;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum
 *
 * Subarray 주엥 합이 가장 큰 수 반환
 *
 * example #1
 * Input: int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4}
 * Output: 6
 * Explanation: [4, -1, 2, 1] has the largetst sum = 6
 */
public class MaximumSubarray {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        println(solve(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})+"");
        println(solve(new int[]{4, -1, 2, 1, -2, 1, -3, -5, 4})+"");
    }

    private static int solve(int[] nums){

        int newSum = nums[0];
        int curMax = nums[0];
        int start = 0;
        for(int i=1; i<nums.length; i++){
            newSum = Math.max(nums[i], newSum+nums[i]);
            curMax = Math.max(newSum, curMax);
//            newSum = curMax + nums[i];
//            if(nums[i] > newSum){
//                curMax = nums[i];
////                newSum = nums[i];
//                start = i;
//            } else {
//                newSum += nums[i];
//            }
        }
        return curMax;
    }

    private static void printArray(int[] input){
        System.out.print("[ ");
        for(int i=0; i<input.length; i++){
            System.out.print(input[i]+" ");
        }
        println("]");
    }

    private static void println(String msg){
        System.out.println(msg);
    }
}
