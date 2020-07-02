package programmers.skillCheck;

import java.util.Arrays;

public class level1_2 {

    public static void main(String[] args){
        checkAnswer(new level1_2().solution(2,5), new int[]{2,4,6,8,10});
        checkAnswer(new level1_2().solution(4,3), new int[]{4,8,12});
        checkAnswer(new level1_2().solution(-4,2), new int[]{-4,-8});
    }

    private static void checkAnswer(long[] result, int[] answer){
        if(result.length != answer.length){
            System.out.println("Incorrect! result: "+ Arrays.toString(result)+" / answer: "+Arrays.toString(answer));
        }
        boolean flag = true;
        for(int i=0; i<result.length; i++){
            if(result[i] != answer[i]){
                flag = false;
            }
        }

        if(flag){
            System.out.println("Correct! result: "+ Arrays.toString(result)+" / answer: "+Arrays.toString(answer));
        }else {
            System.out.println("Incorrect! result: "+ Arrays.toString(result)+" / answer: "+Arrays.toString(answer));
        }
    }

    private long[] solution(int x, int n){
        long[] ret = new long[n];
        long origValue = x;
        for(int i=0; i<n; i++){
            int multiplier = i+1;
            ret[i] = origValue * multiplier;
        }

        return ret;
    }
}
