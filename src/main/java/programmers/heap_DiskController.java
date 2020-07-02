package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class heap_DiskController {

    public static void main(String[] args){
        checkAnswer(new heap_DiskController().run(new int[][]{{0,3}, {1,9}, {2,6}}), 9);
        checkAnswer(new heap_DiskController().run(new int[][]{{0,4}, {2,7}, {4,8}, {6,4}, {7,1}, {10,5}}), 1);
    }

    private static void checkAnswer(int result, int answer){
        if(result == answer){
            System.out.println("Correct! result: "+result+" / answer: "+answer);
        } else {
            System.out.println("Incorrect! result: "+result+" / answer: "+answer);
        }
    }

    private int inputOrderAvgTime(int[][] jobs){
        PriorityQueue<job> pQueue = new PriorityQueue<>(new Comparator<job>() {
            @Override
            public int compare(job job, job t1) {
                return job.start - t1.start;
            }
        });
        for(int i=0; i<jobs.length; i++){
            pQueue.offer(new job(jobs[i][0], jobs[i][1]));
//            for(int j=0; j<jobs[i][0]; j++){
//                System.out.print(" ");
//            }
//            for(int j=0; j<jobs[i][1]; j++){
//                System.out.print("=");
//            }
//            System.out.println();
        }

        return getAverageTime(pQueue);
    }

    private int getAverageTime(PriorityQueue<job> pQueue){
        if(pQueue == null || pQueue.size() < 1) return -1;

        List<Integer> timeList = new ArrayList<>();
        int queueSize = pQueue.size();
        int time = 0;

        job firstJob = pQueue.poll();
        printJob(firstJob);
        time = firstJob.start + firstJob.duration;
        timeList.add(firstJob.duration);

        while(!pQueue.isEmpty()){
//            System.out.println(time);
            job curJob = pQueue.poll();

            printJob(curJob);

            if(curJob.start < time){
                time += curJob.duration;
            } else {
                time += (curJob.start - time) + curJob.duration;
            }
            timeList.add(time - curJob.start);
        }
//        System.out.println(time);

        int totalTime = 0;
        for(int i=0; i<timeList.size(); i++){
            totalTime += timeList.get(i);
        }

        return totalTime/queueSize;
    }

    private void printJob(job curJob){
        for(int i=0; i<curJob.start; i++){
            System.out.print(" ");
        }
        for(int i=0; i<curJob.duration; i++){
            System.out.print("=");
        }
        System.out.println();
    }

    private int run(int[][] jobs){
        // by incoming order
        System.out.println("Avg Time for Incoming order: "+inputOrderAvgTime(jobs));

        PriorityQueue<job> pQueue = new PriorityQueue<>(new Comparator<job>() {
            @Override
            public int compare(job job1, job job2) {
//                if(job1.start < job2.start && job1.duration < job2.duration){
//                    return job1.start - job2.start;
//                }
//                if(job2.start - job1.start < job2.duration - job1.duration){
//                    return job2.start - job1.start;
//                } else {
//                    return job1.start - job2.start;
//                }
                if(job1.start < job2.start){
//                    if()
                } else {

                }
                return 0; //
            }
        });
        for(int[] job : jobs){
            pQueue.offer(new job(job[0], job[1]));
        }

        int queueSize = pQueue.size();
        for(int i=0; i<queueSize; i++){
//            System.out.println(pQueue.poll().toString());
        }

        return getAverageTime(pQueue);
    }

    Comparator<job> comp = new Comparator<job>() {
        @Override
        public int compare(job job, job t1) {
            return 0;
        }
    };

    class job{
        int start, duration;
        public job(int start, int duration){
            this.start = start;
            this.duration = duration;
        }

        public String toString(){
            return start+"/"+duration;
        }
    }
}
