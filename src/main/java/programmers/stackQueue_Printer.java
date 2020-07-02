package programmers;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class stackQueue_Printer {

    public static void main(String[] args){
        checkAnswer(new stackQueue_Printer().prioritize(new int[]{2,1,3,2}, 2), 1);
        checkAnswer(new stackQueue_Printer().prioritize(new int[]{1,1,9,1,1,1}, 0), 5);
    }

    private static void checkAnswer(int result, int answer){
        if(result == answer){
            System.out.println("Correct! result: "+result+" / answer: "+answer);
        } else {
            System.out.println("Incorrect! result: "+result+" / answer: "+answer);
        }
    }

    private int prioritize(int[] priorities, int location){
        // priority queue to order by higher priority
        // run while loop of taskqueue
        // if current task is not priorityqueue poll, then push back to taskqueue
        MyTask targetTask = new MyTask(priorities[location], location);

        Queue<MyTask> taskQueue = new LinkedList<>();
        PriorityQueue<MyTask> priorityQueue = new PriorityQueue<>(new Comparator<MyTask>() {
            @Override
            public int compare(MyTask task1, MyTask task2) {
                return task2.priority - task1.priority;
            }
        });

        for(int i=0; i<priorities.length; i++){
            MyTask mTask = new MyTask(priorities[i], i);
            taskQueue.add(mTask);
            priorityQueue.offer(mTask);
        }

        int index = 0, cnt = 0;
        MyTask highestPriority = priorityQueue.poll();
//        System.out.println("current highestPriority: "+highestPriority.priority+", "+highestPriority.index);
        while(!taskQueue.isEmpty()){
            MyTask currentTask = taskQueue.poll();
//            System.out.println("current Task: "+currentTask.priority+", "+currentTask.index);
            if(currentTask.priority < highestPriority.priority){
                // less
                taskQueue.add(currentTask);
            } else {
                // cannot be greater
                // equal
                cnt++;
                if(currentTask.index == targetTask.index){
                    index = cnt;
                    break;
                }
                highestPriority = priorityQueue.poll();
            }
        }

        //
        return index;
    }

    class MyTask{
        int priority, index;
        public MyTask(int priority, int index){
            this.priority = priority;
            this.index = index;
        }
    }
}
