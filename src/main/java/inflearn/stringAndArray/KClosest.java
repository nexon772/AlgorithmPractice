package inflearn.stringAndArray;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * #PriorityQueue
 *
 * example #1
 * Input:
 * points = [[1, 3], [-2, 2]]
 * K = 1
 * Output:
 * [[-2, 2]]
 * Explanation:
 * (0, 0)(1, 3) and the origin is sqrt(10) 1+9
 * (0, 0)(-2, 2) and the origin is sqrt(8) 4+4
 *
 * example #2
 * Input:
 * points = [[3,3], [5,-1], [-2, 4]] sqrt(18)=4.24 sqrt(26)=5.09 sqrt(20)=4.47
 * K = 1
 * Output:
 * [[3, 3]]
 */

// K Closest Points to Origin
public class KClosest {

    public static void main(String[] args){run();}

    private static int K = 1;

    public static void run(){
        printIntArray(solve(new int[][]{{1,3}, {-2,2}}, K));
        printIntArray(solve(new int[][]{{3,3}, {5,-1}, {-2,4}}, K));
    }

    private static int[][] solve(int[][] coords, int k){
        println("==== start solving");
//        printIntArray(coords);
//        Arrays.sort(coords, comp);
//        println("sorted");
//        printIntArray(coords);

        Queue<int[]> queue = new PriorityQueue<int[]>(coords.length, comp);
        int[][] result = new int[k][2];
        int idx = 0;

        for(int[] c : coords){
            queue.offer(c);
        }

        while(idx < k){
            result[idx] = queue.poll();
            idx++;
        }

        return result;
    }

    static Comparator<int[]> comp = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return (o1[0]*o1[0]+o1[1]*o1[1]) - (o2[0]*o2[0]+o2[1]*o2[1]);
        }
    };

    private static void println(String msg){
        System.out.println(msg);
    }

    private static void printIntArray(int[][] input){
        for(int i=0; i<input.length; i++){
            println("["+input[i][0]+", "+input[i][1]+"]");
        }
    }
}
