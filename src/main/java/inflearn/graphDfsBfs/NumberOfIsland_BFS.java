package inflearn.graphDfsBfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * #BFS #QUEUE
 */
public class NumberOfIsland_BFS {

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
        if(map == null || map.length == 0 || map[0].length == 0) return 0;

        printMap(map);

        int cnt = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j] == '1'){
                    cnt++;
                    bfs(map, i, j);
                }
            }
        }

        return cnt;
    }

    private static int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    private static void bfs(char[][] map, int x, int y){
        map[x][y] = '0';
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});
        while(!queue.isEmpty()){
            int size = queue.size();
            int[] point = queue.poll();
            for(int i=0; i<size; i++){
                for(int[] dir : dirs){
                    int x1 = point[0]+dir[0];
                    int y1 = point[1]+dir[1];
                    if(x1 >= 0 && y1 >= 0 && x1 < map.length && y1 < map[0].length && map[x1][y1] == '1'){
                        map[x1][y1] = '0';
                        queue.offer(new int[] {x1,y1});
                    }
                }
            }
            System.out.println("---------------------------");
            printMap(map);
            System.out.println("---------------------------");
        }
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
