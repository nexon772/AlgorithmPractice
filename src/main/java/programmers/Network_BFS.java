package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Network_BFS {

    public static void main(String[] args){
        System.out.println(new Network_BFS().solve(3, new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
        System.out.println(new Network_BFS().solve(3, new int[][]{{1,1,0},{1,1,1},{0,1,1}}));
    }

    private int solve(int n, int[][] computers){
        boolean[] visited = new boolean[n];
        int result = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(n, computers, i, visited);
                result++;
            }
        }
        return result;
    }

    private void bfs(int n, int[][] computers, int idx, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(idx);
        visited[idx] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            visited[cur] = true;
            for(int i=0; i<n; i++){
                if(computers[cur][i] == 1 && !visited[i]){
                    queue.offer(i);
                }
            }
        }
    }
}
