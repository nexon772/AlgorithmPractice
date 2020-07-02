package programmers;

import java.util.PriorityQueue;

public class heap_RamenFactory {

    public static void main(String[] args){
        checkAnswer(new heap_RamenFactory().ramenFactory(4, new int[]{4,10,15}, new int[]{20,5,10}, 30), 2);
    }

    private static void checkAnswer(int result, int answer){
        if(result == answer){
            System.out.println("Correct! result: "+result+" / answer: "+answer);
        } else {
            System.out.println("Incorrect! result: "+result+" / answer: "+answer);
        }
    }

    private int ramenFactory(int stock, int[] dates, int[] supplies, int k){
        int day = k;
        int curStock;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        int cnt = 0;
        for(int i=0; i<dates.length; i++){

        }
        return 0;
    }
}
