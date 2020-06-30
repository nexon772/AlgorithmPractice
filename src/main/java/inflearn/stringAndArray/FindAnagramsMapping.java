package inflearn.stringAndArray;

import java.util.HashMap;
import java.util.Map;

/**
 * #Map
 *
 * example #1
 * input:
 * int[] A = {11, 27, 45, 31, 50}
 * int[] B = {50, 11, 31, 45, 27}
 * Output:
 * [1 4 3 2 0]
 * Explanation:
 * Find index of A's item in B
 */
public class FindAnagramsMapping {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        printArray(solve(new int[]{11, 27, 45, 31, 50}, new int[]{50, 11, 31, 45, 27}));
    }

    private static int[] solve(int[] A, int[] B){
        int[] result = new int[A.length];

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<A.length; i++){
            map.put(B[i],i);
        }

        for(int i=0; i<A.length; i++){
            result[i] = map.get(A[i]);
        }

        return result;
    }

    private static void printArray(int[] output){
        System.out.print("[ ");
        for(int i=0; i<output.length; i++){
            System.out.print(output[i]+" ");
        }
        System.out.println("]");
    }
}
