package kakaovx;

import java.util.Arrays;

public class FindIndexOfX {

    public static void main(String[] args){
        new FindIndexOfX().findIndexOfX(new int[]{3, 7}, new int[]{1,2,3,4,5,6,7,8,9,10});
    }

    private void findIndexOfX(int[] shiftAndX, int[] arr){
        // shift
        for(int i=0; i<shiftAndX[0]; i++){
            int first = arr[0];

            for(int j=0; j<arr.length-1; j++){
                arr[j] = arr[j+1];
            }
            arr[arr.length-1] = first;
        }
        System.out.println(Arrays.toString(arr));

        // get Index of X
        for(int i=0; i<arr.length; i++){
            if(arr[i] == shiftAndX[1]){
                System.out.println(i);
            }
        }
    }
}
