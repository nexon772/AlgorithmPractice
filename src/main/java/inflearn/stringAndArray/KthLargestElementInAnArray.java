package inflearn.stringAndArray;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * example #1
 * Input:
 * int[] nums = {3,2,1,5,6,4}
 * int k = 2;
 * Output:
 * 5
 * Explanation:
 * return kth largest number in array nums
 */
public class KthLargestElementInAnArray {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        int K = 2;
        System.out.println(solve(new int[]{3,2,1,5,6,4}, K));
        System.out.println(solve(new int[]{6,7,4,3,2,8,5}, K));
    }

    private static int solve(int[] nums, int k){
        int result = 0;

        // Sort way
//        int[] temp = nums;
//        Arrays.sort(temp);
//        result = temp[temp.length-k];

        // PriorityQueue way
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++){
            if(queue.size() == k){
                if(nums[i] > queue.peek()){
                    queue.poll();
                    queue.offer(nums[i]);
                }
            } else {
                queue.offer(nums[i]);
            }
        }
        result = queue.peek();

        return result;
    }

    private static void printArray(int[] array){
        System.out.print("[ ");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("]");
    }
}
