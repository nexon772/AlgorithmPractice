package inflearn.graphDfsBfs;

/**
 * #Dfs
 *
 * dfs로 미로에서 길을 찾는 방식은 막힐 때까지 재귀함수로 한방향으로 계속 나아가는 것이다.
 * 때문에 해당 함수를 탈출할 수 있는 예외처리를 꼭 해줘야 한다.
 */
public class Maze1_Dfs {

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
        if(maze == null || maze.length == 0) return false;
        m = maze.length;
        n = maze[0].length;
        boolean[][] visited = new boolean[m][n];

        return dfs(maze, start, dest, visited);
    }

    // start는 각 재귀함수의 시작점이다
    private static boolean dfs(int[][] maze, int[] start, int[] dest, boolean[][] visited){
        if(start[0] < 0 || start[0] >= m || start[1] < 0 || start[1] >= n || visited[start[0]][start[1]]) return false;

        // 현재 dfs 시작점 visited 처리
        visited[start[0]][start[1]] = true;
        // 현재 위치가 목표지점과 같다면 true
        if(start[0] == dest[0] && start[1] == dest[1]) return true;

        // 각 방향으로 진행한다.
        for(int[] dir : dirs){
            int x = start[0];
            int y = start[1];
            // 현재 dirs에서 받은 좌표로 이동하기 전에 valid한 지 확인한다.
            while(x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1){
                // valid하다면 막힐때까지 계속 해당 방향으로 직진한다
                x += dir[0];
                y += dir[1];
            }
            // 해당 방향에서 벽에 부딛혔기 때문에 올렸던 좌표를 뺀다
            x -= dir[0];
            y -= dir[1];
            // 새로운 시작점에서 언젠가 true를 반환한다면 똑같이 true를 반환한다.
            if(dfs(maze, new int[]{x,y}, dest, visited)){
                return true;
            }
        }
        return false;
    }
}
