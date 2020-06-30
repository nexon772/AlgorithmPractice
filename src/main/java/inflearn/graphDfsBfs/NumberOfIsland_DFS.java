package inflearn.graphDfsBfs;

/**
 * #DFS (Depth First Search) (#Stack)
 *
 * example #1
 * Input:
 * {'1', '1', '1', '0', '1'},
 * {'1', '1', '0', '0', '0'},
 * {'1', '1', '0', '0', '1'},
 * {'0', '0', '0', '0', '1'}
 * Output:
 * 3
 * Explanation:
 * 1 is land 0 is sea
 *
 */
public class NumberOfIsland_DFS {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        System.out.println(solve(new char[][]{
                {'1', '1', '1', '0', '1'},
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '0', '0', '1'}}));

        System.out.println(solve(new char[][]{
                {'1', '1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0', '0'},
                {'1', '1', '0', '0', '1', '1'},
                {'0', '0', '0', '0', '1', '1'},
                {'1', '0', '1', '0', '0', '1'}})); // answer 5
    }

    private static int solve(char[][] map){
//        printMap(map);

        if(map == null || map.length == 0 || map[0].length == 0)
            return 0;

        // 0,0 위치가 1인것부터 찾는다
        int cnt = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j] == '1'){
                    cnt++;
                    dfs(map, i, j);
                }
            }
        }
        printMap(map);
        return cnt;
    }

    private static void dfs(char[][] map, int i, int j){
        int m = map.length;
        int n = map[0].length;
        if(i<0 || i>=m || j<0 || j>=n || map[i][j] != '1') return;

        map[i][j] = 'X';
        System.out.println("---------------------------");
        printMap(map);
        System.out.println("---------------------------");

        dfs(map, i-1, j);
        dfs(map, i+1, j);
        dfs(map, i, j-1);
        dfs(map, i, j+1);

    }

    private static void printMap(char[][] map){
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                System.out.print("["+i+"]["+j+"] "+map[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
