package repeat1;

import java.util.LinkedList;
import java.util.Queue;

public class MaxOfIslands_BFS {

    public static void main(String[] args){
        System.out.println(new MaxOfIslands_BFS().solve(new int[][]{
                {1,1,0,1,1},
                {0,1,1,0,0},
                {0,0,0,0,0},
                {1,1,0,1,1},
                {1,0,0,1,1},
                {1,0,1,1,1}
        }));

//        System.out.println(new MaxOfIslands_BFS().solve(new int[][]{
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
        if(map == null || map.length == 0 || map[0].length == 0) return 0;

        m = map.length;
        n = map[0].length;

        int max = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1){
                    int cnt = bfs(map, i, j);
                    max = Math.max(cnt, max);
                }
            }
        }

        printMap(map);

        return max;
    }

    private int bfs(int[][] map, int x, int y){
        int cnt = 1;
        map[x][y] = 2;

        System.out.println("------------------------------");
        printMap(map);
        System.out.println("------------------------------");
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        while(!queue.isEmpty()){
            int size = queue.size();
            int[] point = queue.poll();
            for(int i=0; i<size; i++){
                for(int[] dir : dirs){
                    int dx = point[0]+dir[0];
                    int dy = point[1]+dir[1];
                    if(dx >= 0 && dx < m && dy >= 0 && dy < n && map[dx][dy] == 1){
                        map[dx][dy] = 2;
                        cnt++;
                        queue.offer(new int[]{dx, dy});
                        System.out.println("------------------------------");
                        printMap(map);
                        System.out.println("------------------------------");
                    }
                }
            }
        }
        return cnt;
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
