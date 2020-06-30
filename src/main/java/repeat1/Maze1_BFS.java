package repeat1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Maze1_BFS {


    public static void main(String[] args){
        System.out.println(new Maze1_BFS().solve(new int[][]{
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        }, new int[]{0,4}, new int[]{4,4}));
    }

    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    int m,n;
    private boolean solve(int[][] maze, int[] start, int[] dest){
        if(maze == null || maze.length == 0) return false;
        m = maze.length;
        n = maze[0].length;

        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int[] point = queue.poll();
            for(int[] dir : dirs){
                int x = point[0]+dir[0];
                int y = point[1]+dir[1];
                while(x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0){
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];
                if(visited[x][y])
                    continue;
                visited[x][y] = true;
                if(Arrays.equals(new int[]{x,y}, dest))
                    return true;
                queue.offer(new int[]{x,y});
            }
        }
        return false;
    }
}
