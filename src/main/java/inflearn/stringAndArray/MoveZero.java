package inflearn.stringAndArray;

/**
 * 배열 num을 감안할 때 0이 아닌 요소의 상대적인 순서를 유지하면서 모든 0을 끝으로 이동시키는 함수를 작성하십시오.
 *
 * example #1
 * Input: [0, 3, 2, 0, 8, 5]
 * Output: [3, 2, 8, 5, 0, 0]
 */

public class MoveZero {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        solve(new int[]{0, 3, 2, 0, 8, 5});
    }

    private static void solve(int[] nums){
        printArray(nums);

        int[] ret = new int[nums.length];
        int cnt = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                ret[cnt] = nums[i];
                cnt++;
            } else {
                ret[nums.length-i-1] = 0;
            }
        }
        printArray(ret);
    }

    private static void printArray(int[] intArray){
        System.out.print("[ ");
        for(int i=0; i<intArray.length; i++){
            System.out.print(intArray[i]+" ");
        }
        System.out.println("]");
    }
}
