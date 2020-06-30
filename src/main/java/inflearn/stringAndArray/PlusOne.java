package inflearn.stringAndArray;

/**
 *
 * procedure
 * 1. 뒷자리 9 체크
 * 2.
 *
 * example #1
 * Input: [1,2,3]
 * Output: [1,2,4]
 *
 * example #2
 * Input: [9,9,9]
 * Output: [1,0,0,0]
 */
public class PlusOne {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        printArray(solve(new int[]{1,2,3}));
        printArray(solve(new int[]{9,9,9}));
        printArray(solve(new int[]{1,2,9}));
        printArray(solve(new int[]{1,3,9,9}));
        printArray(solve(new int[]{1,9,9,4}));
    }

    private static int[] solve(int[] digits){
        System.out.println("==== start solving");
        printArray(digits);

        for(int i=0; i<digits.length; i++){
            if(digits[digits.length-(i+1)] != 9){
                digits[digits.length-(i+1)]++;
                break;
            } else {
                digits[digits.length-(i+1)] = 0;
            }
        }

        if(digits[0] == 0){
            int[] result = new int[digits.length+1];
            for(int i=0; i<digits.length; i++){
                result[result.length-(i+2)] = digits[digits.length-(i+1)];
            }
            result[0] = 1;
            return result;
        }

        return digits;
    }

    private static void printArray(int[] input){
        System.out.print("[");
        for(int i=0; i<input.length; i++){
            System.out.print(input[i]+" ");
        }
        System.out.println("]");
    }
}
