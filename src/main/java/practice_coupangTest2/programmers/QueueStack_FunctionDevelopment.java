package practice_coupangTest2.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class QueueStack_FunctionDevelopment {

    public static void main(String[] args){
        new QueueStack_FunctionDevelopment().solve(new int[]{93, 30, 55}, new int[]{1, 30, 5});
    }

    private void solve(int[] progresses, int[] speeds){

        Queue<Project> queue = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            queue.offer(new Project(progresses[i], speeds[i]));
        }

        ArrayList<Integer> answer = new ArrayList<>();

        int release = -1;
        int cnt = 0;

        while(!queue.isEmpty()){
            Project project = queue.peek();
            int thisRelease = (100 - project.progress) / project.speed + 1;
            if(release == -1){
                release = thisRelease;
            }

            if(thisRelease <= release){
                queue.poll();
                cnt++;
            } else {
                answer.add(cnt);
                cnt = 0;
                release = -1;
            }
        }
        answer.add(cnt);

        int[] ret = new int[answer.size()];

        for(int i=0; i<answer.size(); i++){
            ret[i] = answer.get(i);
        }

        System.out.println(answer);

    }

    class Project{
        int progress, speed;
        public Project(int progress, int speed){
            this.progress = progress;
            this.speed = speed;
        }
    }
}
