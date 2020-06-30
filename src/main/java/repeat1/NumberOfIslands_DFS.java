package repeat1;

/**
 * Input:
 *
 */
public class NumberOfIslands_DFS {

    public static void main(String[] args){
        System.out.println(new NumberOfIslands_DFS().solve(new char[][]{
                {'1', '1', '1', '0', '1'},
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '0', '0', '1'}
        }));
    }

    int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    int m, n;
    private int solve(char[][] map){
        if(map == null || map.length == 0 || map[0].length == 0) return 0;

        m = map.length;
        n = map[0].length;

        int cnt = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == '1'){
                    cnt++;
                    System.out.println("cnt: "+cnt);
                    dfs(map, i, j);
                }
            }
        }

        return cnt;
    }

    private void dfs(char[][] map, int x, int y){
        if(x<0 || x>=m || y<0 || y>=n || map[x][y] != '1') return;

        map[x][y] = 'x'; // visited
        System.out.println("------------------------------");
        printMap(map);
        System.out.println("------------------------------");

        for(int[] dir : dirs){
            dfs(map, x+dir[0], y+dir[1]);
        }
    }

    private void printMap(char[][] map){
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                System.out.print("["+i+"]["+j+"] "+map[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
