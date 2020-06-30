package practice_coupangTest2.programmers;

import java.util.*;

public class QueueStack_Printer {

    public static void main(String[] args){
        new QueueStack_Printer().solve(new int[]{2,1,3,2}, 2);
        new QueueStack_Printer().solve(new int[]{1,1,9,1,1,1}, 0);
    }

    private void solve(int[] priorities, int location){

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            pQueue.offer(priorities[i]);
            queue.offer(priorities[i]);
        }
        int pQueueValue = pQueue.poll();

        int cnt = 0;
        int index = location;
        while(!queue.isEmpty()){
            int j = queue.poll();
            index--;
            if(j != pQueueValue){
                queue.offer(j);
                if(cnt == location){
                    index = queue.size()-1;
                }
            } else {
                if(pQueue.size() > 1)
                pQueueValue = pQueue.poll();
            }
            cnt++;
        }
        System.out.println(index);
    }
}
