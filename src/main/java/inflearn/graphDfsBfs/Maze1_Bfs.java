package inflearn.graphDfsBfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * #BFS #Queue
 *
 * example #1
 * Input:
 * {0, 0, 1, 0, 0},
 * {0, 0, 0, 0, 0},
 * {0, 0, 0, 1, 0},
 * {1, 1, 0, 1, 1},
 * {0, 0, 0, 0, 0}
 * start = (0, 4)
 * destination = (4, 4)
 * Output:
 * true
 */
public class Maze1_Bfs {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        System.out.println(solve(new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        }, new int[]{0,4}, new int[]{4,4}));
    }

    static int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int m, n;
    private static boolean solve(int[][] maze, int[] start, int[] dest){
        m = maze.length;
        n = maze[0].length;
        if(start[0]==dest[0] && start[1] == dest[1]) return true; // 이미 도착?

        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true; // 현재 위치는 이미 들린 곳
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start); // 시작점 넣어줌

        while(!queue.isEmpty()){
            int[] p = queue.poll();
            for(int[] dir : dirs){
                // 다음 지점
                int x = p[0]+dir[0];
                int y = p[1]+dir[1];
                // 루프가 끝날때까지 계속 해당방향으로 진행
                while(x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0){
                    x += dir[0];
                    y += dir[1];
                }
                // 막다른 곳으로 옴
                x -= dir[0];
                y -= dir[1];
                // 이미 들린 곳이라면 패스
                if(visited[x][y]) continue;
                // 아직 안 들린 곳이라면 visited 마킹
                visited[x][y] = true;
                printGrid(visited);
                // 만약 목적지에 도착했으면 완료
                if(x == dest[0] && y == dest[1]) return true;
                // 새로운 시작점을 queue에 넣어준다
                queue.offer(new int[]{x,y});
            }
        }
        return false;
    }

    private static void printGrid(boolean[][] visited){
        System.out.println("===============================");
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(visited[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("===============================");
    }
}
