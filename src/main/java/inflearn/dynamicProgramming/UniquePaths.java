package inflearn.dynamicProgramming;

/**
 * example #1
 * Input:
 * m = 3, n = 2
 * Output:
 * 3
 * Explanation:
 * [0,0][0,1][0,2]
 * [1,0][1,1][1,2]
 * There are three ways to go from 0,0 to 1,2
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 *
 * example #2
 * Input:
 * m = 7, n = 3
 * Output:
 * 28
 */
public class UniquePaths {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        System.out.println(solve(3,2));
        System.out.println(solve(7,3));
    }

    private static int solve(int m, int n){
        int[][] map = new int[m][n];

        for(int i=0; i<m; i++){
            map[i][0] = 1;
        }

        for(int i=0; i<n; i++){
            map[0][i] = 1;
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                map[i][j] = map[i][j-1] + map[i-1][j];
            }
        }

        return map[m-1][n-1];
    }
}
