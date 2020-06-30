package programmers;

import java.util.Arrays;

public class KthNumber {

    public static void main(String[] args){
        int[] array = {1,5,2,6,3,7,4};
        checkAnswer(new KthNumber().findKthNumber(array, new int[]{2,5,3}), 5);
        checkAnswer(new KthNumber().findKthNumber(array, new int[]{4,4,1}), 6);
        checkAnswer(new KthNumber().findKthNumber(array, new int[]{1,7,3}), 3);
    }

    private static void checkAnswer(int result, int answer){
        if(result == answer){
            System.out.println("Correct! answer: "+answer+" / result: "+result);
        } else if(result == -1) {
            System.out.println("Invalid input! Cannot be processed");
        } else {
            System.out.println("Incorrect! answer: "+answer+" / result: "+result);
        }
    }

    private int findKthNumber(int[] array, int[] commands){
        if(commands[0] < 1 || commands[1] > array.length){
            return -1;
        }

        int[] crop = new int[commands[1] - commands[0] + 1];
        int j = 0;
        for(int i=commands[0]-1; i<commands[1]; i++){
            crop[j] = array[i];
            j++;
        }
        Arrays.sort(crop);
        int idx = commands[2]-1;
        return crop[idx];
    }
}
