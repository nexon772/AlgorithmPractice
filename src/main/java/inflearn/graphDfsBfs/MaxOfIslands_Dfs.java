package inflearn.graphDfsBfs;

/**
 *
 *
 * example #1
 * Input:
 * {'1', '1', '0', '1', '1'},
 * {'0', '1', '1', '0', '0'},
 * {'0', '0', '0', '0', '0'},
 * {'1', '1', '0', '1', '1'},
 * {'1', '0', '1', '1', '1'},
 * {'1', '0', '1', '1', '1'}
 * Output:
 * 8
 * Explanation:
 * 1 is land 0 is sea
 * Biggest island has 8 areas
 *
 */
public class MaxOfIslands_Dfs {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        System.out.println(solve(new int[][]{
                {1, 1, 0, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1}}));
    }

    static int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int m, n;
    private static int solve(int[][] map){
        if(map == null || map.length == 0 || map[0].length == 0) return 0;

        m = map.length;
        n = map[0].length;

        int max = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1){
                    int area = dfs(map, i, j, 0);
                    max = Math.max(area, max);
                }
            }
        }

        return max;
    }

    private static int dfs(int[][] map, int x, int y, int area){
        if(x<0 || x>=m || y<0 || y>=n || map[x][y] == 0) return area;

        map[x][y] = 0;
        area++;

        for(int[] dir:dirs){
            area = dfs(map, x+dir[0], y+dir[1], area);
        }
        return area;
    }
}
