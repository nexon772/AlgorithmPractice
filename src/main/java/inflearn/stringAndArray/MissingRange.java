package inflearn.stringAndArray;

import java.util.ArrayList;
import java.util.List;

/**
 * example #1
 * Input:
 * int[] nums = {2,3,5,50,75};
 * int lower = 0;
 * int upper = 99;
 * Output:
 * [0->1, 4, 6->49, 51->74, 76->99]
 */
public class MissingRange {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        printList(solve(new int[]{2,3,5,50,75}, 0, 99));
        printList(solve(new int[]{1,2,5,8,9,10,20,50}, 0, 99));
    }

    private static List<String> solve(int[] nums, int lower, int upper){
        List<String> list = new ArrayList<>();

        if(lower < nums[0]){
            list.add(makeRange(lower, nums[0]));
        }
        for(int i=0; i<nums.length-1; i++){
            if(nums[i+1] - nums[i] != 1){
                list.add(makeRange(nums[i]+1, nums[i+1]));
            }
        }
        if(nums[nums.length-1] < upper){
            list.add(makeRange(nums[nums.length-1]+1, upper+1));
        }

        return list;
    }

    private static String makeRange(int min, int max){
        if(max - min == 1){
            return min+"";
        }
        return min+"->"+(max-1);
    }

    private static void printList(List<String> list){
        System.out.println(list);
    }
}
