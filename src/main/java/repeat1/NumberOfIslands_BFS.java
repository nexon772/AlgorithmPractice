package repeat1;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands_BFS {

    public static void main(String[] args){
        System.out.println(new NumberOfIslands_BFS().solve(new char[][]{
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
                    bfs(map, i, j);
                }
            }
        }

        return cnt;
    }

    private void bfs(char[][] map, int x, int y){

        map[x][y] = 'x';
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        while(!queue.isEmpty()){
            // queue size dynamically changes, so get size beforehand
            int size = queue.size();
            int[] point = queue.poll();
            System.out.println(point[0]+" "+point[1]);
            for(int i=0; i<size; i++){
                for(int[] dir : dirs){
                    int dx = point[0]+dir[0];
                    int dy = point[1]+dir[1];
                    if(dx >= 0 && dy >= 0 && dx < m && dy < n && map[dx][dy] == '1'){
                        map[dx][dy] = 'x';
                        queue.offer(new int[]{dx,dy});
                    }
                }
            }
            System.out.println("------------------------------");
            printMap(map);
            System.out.println("------------------------------");
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
