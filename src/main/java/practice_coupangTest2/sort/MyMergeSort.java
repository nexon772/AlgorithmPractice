package practice_coupangTest2.sort;

import java.util.Arrays;

public class MyMergeSort {
    public static void main(String[] args){
        int[] arr = new int[]{3, 1, 2, 8, 6, 7, 4, 9, 5};

        System.out.println(Arrays.toString(new MyMergeSort().mergeSort(arr)));
    }

    private int[] mergeSort(int[] arr){
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length-1);
        return arr;
    }

    private void mergeSort(int[] arr, int[] tmp, int left, int right){
        if(left < right){
            int m = (left + right) / 2;
            mergeSort(arr, tmp, left, m);
            mergeSort(arr, tmp, m+1, right);
            merge(arr, tmp, left, m, right);
        }
    }

    private void merge(int[] arr, int[] tmp, int left, int mid, int right){
        for(int i=left; i<=right; i++){
            tmp[i] = arr[i];
        }
        int part1 = left;
        int part2 = mid+1;
        int index = left;
        while(part1 <= mid && part2 <= right){
            if(tmp[part1] <= tmp[part2]){
                arr[index] = tmp[part1];
                part1++;
            } else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        for(int i=0; i<=mid-part1; i++){
            arr[index+i] = tmp[part1+i];
        }
    }
}
