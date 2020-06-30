package inflearn.stringAndArray;

/**
 * example #1
 * Input:
 * {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
 * Output:
 * 6
 * Explanation:
 *
 */
public class TrappingRainWater {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        System.out.println(solve(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    private static int solve(int[] height){
        int[] left = getMaxHeight(height, true);
        int[] right = getMaxHeight(height, false);

        int cnt = 0;
        for(int i=0; i<height.length; i++){
            cnt += Math.min(left[i], right[i]) - height[i];
        }
        return cnt;
    }

    private static int[] getMaxHeight(int[] input, boolean flag){
        int[] result = new int[input.length];
        int before = 0;
        for(int i=0; i<input.length; i++){
            if(flag){
                // from left to right
                if(input[i] > before){
                    before = input[i];
                }
                result[i] = before;
            } else {
                // from right to left
                if(input[input.length-(i+1)] > before){
                    before = input[input.length-(i+1)];
                }
                result[input.length-(i+1)] = before;
            }
        }
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
