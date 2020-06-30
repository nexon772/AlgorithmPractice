package repeat1;

public class MaxOfIslands_DFS {

    public static void main(String[] args){
        System.out.println(new MaxOfIslands_DFS().solve(new int[][]{
                {1,1,0,1,1},
                {0,1,1,0,0},
                {0,0,0,0,0},
                {1,1,0,1,1},
                {1,0,0,1,1},
                {1,0,1,1,1}
        }));

//        System.out.println(new MaxOfIslands_Dfs().solve(new int[][]{
//                {1,1,1,1,1},
//                {1,1,1,0,0},
//                {1,1,1,0,0},
//                {1,1,1,1,1},
//                {1,0,0,1,1},
//                {1,0,1,1,1}
//        }));


    }

    int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    int m, n;
    private int solve(int[][] map){
        if(map == null) return 0;
        m = map.length;
        n = map[0].length;

        boolean[][] visited = new boolean[m][n];

        int cnt = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1){
                    int area = 0;
                    int num = dfs(map, i, j, area);
                    cnt = Math.max(cnt, num);
                }
            }
        }

        printMap(map);

        return cnt;
    }

    private int dfs(int[][] map, int x, int y, int area){
        if(x < 0 || x >= m || y < 0 || y >= n || map[x][y] != 1) return area;

        System.out.println("------------------------------");
        printMap(map);
        System.out.println("("+x+","+y+")");
        System.out.println("------------------------------");

        map[x][y] = 2;
        area++;
        for(int[] dir : dirs){
            area = dfs(map, x+dir[0], y+dir[1], area);
        }
        return area;
    }

    private void printMap(int[][] map){
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                System.out.print("["+i+"]["+j+"] "+map[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
