package practice_coupangTest2.sort;

import java.util.Arrays;

public class MySelectionSort {

    public static void main(String[] args){
        int[] arr = new int[]{3, 1, 2, 8, 6, 7, 4, 9, 5};

        System.out.println(new MySelectionSort().selectionSort(arr));
    }

    public String selectionSort(int[] arr){
        System.out.println(Arrays.toString(arr));

        for(int i=0; i<arr.length-1; i++){
            int[] minNum = new int[]{0, 0}; // index, value
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] < minNum[1] || minNum[1] == 0){
                    minNum[0] = j;
                    minNum[1] = arr[j];
                }
            }
            if(arr[i] > minNum[1]){
                int temp = arr[i];
                arr[i] = minNum[1];
                arr[minNum[0]] = temp;
            }
        }

        return Arrays.toString(arr);
    }
}
