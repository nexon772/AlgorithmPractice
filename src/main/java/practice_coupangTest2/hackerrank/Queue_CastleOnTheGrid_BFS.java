package practice_coupangTest2.hackerrank;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_CastleOnTheGrid_BFS {

    public static void main(String[] args){
        int[][] map = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int[][] map2 = new int[][]{
                {0, 1, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        System.out.println(new Queue_CastleOnTheGrid_BFS().solve(map, new int[]{0,0}, new int[]{1,2}));
        System.out.println(new Queue_CastleOnTheGrid_BFS().solve(map2, new int[]{0,0}, new int[]{0,2}));
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int solve(int[][] map, int[] start, int[] dest){
        int m = map.length;
        int n = map[0].length;
        if(start[0] == dest[0] && start[1] == dest[1]) return 0; //

        int cnt = 0;

        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true; // starting point
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()){
            cnt++;
            int[] p = queue.poll();
            for(int[] dir : dirs){
                int dx = p[0] + dir[0];
                int dy = p[1] + dir[1];
                while(dx >= 0 && dy >= 0 && dx < m && dy < n && map[dx][dy] == 0){
                    dx += dir[0];
                    dy += dir[1];
                }

                dx -= dir[0];
                dy -= dir[1];

                if(visited[dx][dy]) continue;
                visited[dx][dy] = true;


                if(dx == dest[0] && dy == dest[1]) return cnt;
                queue.offer(new int[]{dx, dy});
            }
        }
        return -1;
    }

    private static void printGrid(boolean[][] visited){
        System.out.println("===============================");
        for(int i=0; i<visited.length; i++){
            for(int j=0; j<visited[0].length; j++){
                System.out.print(visited[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("===============================");
    }
}
