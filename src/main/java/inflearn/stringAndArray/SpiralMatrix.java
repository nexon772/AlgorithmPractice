package inflearn.stringAndArray;

import java.util.ArrayList;
import java.util.List;

/**
 * example #1
 * Input:
 * {1, 2, 3}
 * {4, 5, 6}
 * {7, 8, 9}
 * Output: {1,2,3,6,9,8,7,4,5}
 *
 * example #2
 * Input:
 * {1, 2, 3, 4, 5, 6, 7}
 * {8, 9,10,11,12,13,14}
 * {15,16,17,18,19,20,21}
 * {22,23,24,25,26,27,28}
 * {29,30,31,32,33,34,35}
 * {36,37,38,39,40,41,42}
 * {43,44,45,46,47,48,49}
 * Output:
 * {1,2,3,4,5,6,7,14,21,28,35,42,49,48,47,46,45,44,43,
 * 36,29,22,15,8,9,10,11,12,13,20,27,34,41,40,39,38,37,
 * 30,23,16,17,18,19,26,33,32,31,24,25}
 */
public class SpiralMatrix {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        List<Integer> answer = solve(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}});
        printList(answer);
        int[] solution1 = new int[]{1,2,3,6,9,8,7,4,5};
        check(answer, solution1);

        answer = solve(new int[][]{
                {1, 2, 3, 4, 5, 6, 7},
                {8, 9,10,11,12,13,14},
                {15,16,17,18,19,20,21},
                {22,23,24,25,26,27,28},
                {29,30,31,32,33,34,35},
                {36,37,38,39,40,41,42},
                {43,44,45,46,47,48,49}});
        printList(answer);
        int[] solution2 = new int[]
                {1,2,3,4,5,6,7,14,21,28,35,
                 42,49,48,47,46,45,44,43,36,
                 29,22,15,8,9,10,11,12,13,20,
                 27,34,41,40,39,38,37,30,23,
                 16,17,18,19,26,33,32,31,24,25};
        check(answer, solution2);
    }

    private static List<Integer> solve(int[][] matrix){
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<matrix.length; i++){
            printArray(matrix[i]);
        }

        int totalSize = matrix.length * matrix[0].length;
        int rowStart = 0, rowEnd = matrix.length-1, colStart = 0, colEnd = matrix[0].length-1;
        while(rowStart <= rowEnd && colStart <= colEnd){
            // right
            for(int i=colStart; i<=colEnd; i++){
                list.add(matrix[rowStart][i]);
            }
            rowStart++;
            // down
            for(int i=rowStart; i<=rowEnd; i++){
                list.add(matrix[i][colEnd]);
            }
            colEnd--;
            // left
            if(rowStart <= rowEnd){
                for(int i=colEnd; i>=colStart; i--){
                    list.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            // up
            if(colStart <= colEnd){
                if(rowStart <= rowEnd){
                    for(int i=rowEnd; i>=rowStart; i--){
                        list.add(matrix[i][colStart]);
                    }
                }
            }
            colStart++;
        }

        return list;
    }

    private static void printList(List<Integer> list){
        System.out.print("[ ");
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println("]");
    }

    private static void printArray(int[] array){
        System.out.print("{ ");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("}");
    }

    private static void println(String msg){
        System.out.println(msg);
    }

    private static void check(List<Integer> answer, int[] solution){
        if(answer.size() != solution.length){
            println("size and length does not match!");
            return;
        }

        printList(answer);
        printArray(solution);

        println("=================================");

    }
}
