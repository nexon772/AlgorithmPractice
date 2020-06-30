package practice_coupangTest2.testClass;

import java.util.Arrays;

public class MyHeapTester {

    public static void main(String[] args){
        heapTest1();
    }

    public static void heapTest1(){
        int[] arr = new int[]{9, 7, 5, 8, 1, 2, 4, 6, 10, 3};
        heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr){

        System.out.println(Arrays.toString(arr));

        int n = arr.length;

        for(int i=(n-1)/2; i>=0; i--){
            downHeap(arr, i, n-1);

            System.out.println(Arrays.toString(arr));
        }

        for(int i=n-1; i>0; i--){
            swap(arr, 0, i);
            downHeap(arr, 0, i-1);
        }
    }

    private static void downHeap(int[] arr, int left, int right){
        int temp = arr[left];
        int child;
        int parent;

        for(parent = left; parent<(right+1)/2; parent = child){
            int childLeft = parent * 2 + 1;
            int childRight = childLeft + 1;
            child = (childRight <= right && arr[childRight] > arr[childLeft]) ? childRight : childLeft;
            if(temp >= arr[child]) break;
            arr[parent] = arr[child];
        }

        arr[parent] = temp;
    }

    private static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

}
