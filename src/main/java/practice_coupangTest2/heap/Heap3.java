package practice_coupangTest2.heap;

import java.util.Arrays;

public class Heap3 {

    public static void main(String[] args){
        int[] arr = new int[]{9, 7, 5, 8, 1, 2, 4, 6, 10, 3};

        heapSort(arr);
    }

    private static void heapSort(int[] arr){
        int n = arr.length;

        for(int i=n/2-1; i>=0; i--){
            heapify(arr, n, i);
        }
        System.out.println(Arrays.toString(arr));

        for(int i=n-1; i>0; i--){
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void heapify(int[] arr, int n, int i){
        int p = i;
        int l = i * 2 + 1;
        int r = l + 1;

        // left childNode
        if(l < n && arr[p] < arr[l]) p = l;
        // right childNode
        if(r < n && arr[p] < arr[r]) p = r;
        // parentNode < childNode
        if(i != p){
            swap(arr, p, i);
            heapify(arr, n, p);
        }
    }

    private static void swap(int[] arr, int p, int i){
        int temp = arr[p];
        arr[p] = arr[i];
        arr[i] = temp;
    }
}
