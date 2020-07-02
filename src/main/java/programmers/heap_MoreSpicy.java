package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class heap_MoreSpicy {

    public static void main(String[] args){
        checkAnswer(new heap_MoreSpicy().mixedScoville(new int[]{1,2,3,9,10,12}, 7), 2);
        checkAnswer(new heap_MoreSpicy().mixedScoville(new int[]{0,1,1,1,1,1,1,1,1,1,1,2,2,2,}, 100), -1);
    }

    private static void checkAnswer(int result, int answer){
        if(result == answer){
            System.out.println("Correct! result: "+result+" / answer: "+answer);
        } else {
            System.out.println("Incorrect! result: "+result+" / answer: "+answer);
        }
    }

    private int mixedScoville(int[] scoville, int K){
        // MixedScoville = LeastSpicyScovile + (SecondLeastSpicySchoville * 2)

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer - t1;
            }
        });

        for(int i=0; i<scoville.length; i++){
            pQueue.offer(scoville[i]);
        }

        System.out.println(pQueue);
        int cnt = 0;
        while(pQueue.size() > 1) {
            if(pQueue.peek() >= K){
                break;
            }
            int leastSpicy = pQueue.poll();
            int secondLeastSpicy = pQueue.poll();
            if(secondLeastSpicy == 0) return -1;
            int newScoville = leastSpicy + (secondLeastSpicy * 2);
            pQueue.offer(newScoville);
            cnt++;
            System.out.println(pQueue);
        }
        if(pQueue.peek() < K) return -1;

        return cnt;
    }
}
