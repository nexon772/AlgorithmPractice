package practice_coupangTest2.heap;

import java.util.Arrays;

public class Heap2 {

    public static void main(String[] args){
        int[] arr = new int[]{9, 7, 5, 8, 1, 2, 4, 6, 10, 3};
        int[] arr2 = new int[]{9, 7, 5, 8, 1, 2, 4, 6, 10, 3};

//        minHeap(arr);
        maxHeap(arr2);
    }

    private static void minHeap(int[] arr){
        MinHeap minHeap = new MinHeap(100);
        for(int arg : arr){
            minHeap.push(arg);
            System.out.println(Arrays.toString(minHeap.heap));
        }

        for(int arg : arr){
            System.out.println(minHeap.pop());
        }
    }

    private static void maxHeap(int[] arr){
        MaxHeap maxHeap = new MaxHeap(100);
        for(int arg : arr){
            maxHeap.push(arg);
            System.out.println(Arrays.toString(maxHeap.heap));
        }

        for(int arg: arr){
            System.out.println(maxHeap.pop());
        }
    }

    private static class MinHeap{
        int[] heap;

        public MinHeap(){}

        public MinHeap(int n){
            heap = new int[n];
        }

        public MinHeap(int[] arr){
            this.heap = arr;
        }

        int hCnt = 0;

        public void push(int x){
            heap[++hCnt] = x;
            int idx = hCnt;
            while(idx > 1 && heap[idx/2] > heap[idx]){
                if(idx == 1 || heap[idx/2] < heap[idx]) break;
                int tmp = heap[idx/2];
                heap[idx/2] = heap[idx];
                heap[idx] = tmp;
                idx /= 2;
            }
        }

        public int pop(){
            int pop = heap[1];
            heap[1] = heap[hCnt--];
            int idx = 1;
            int next;
            while(true){
                next = idx * 2;
                if(next < hCnt && heap[next] > heap[next+1]) next++;
                if(next > hCnt || heap[next] > heap[idx]) break;
                int tmp = heap[idx];
                heap[idx] = heap[next];
                heap[next] = tmp;
                idx = next;
            }
            return pop;
        }
    }

    public static class MaxHeap{

        int[] heap;

        public MaxHeap(int n){
            heap = new int[n];
        }

        int hCnt = 0;

        public void push(int x){
            heap[++hCnt] = x;
            int idx = hCnt;
            while(idx > 1 && heap[idx/2] < heap[idx]){
                if(idx == 1 || heap[idx/2] > heap[idx]) break;
                int tmp = heap[idx/2];
                heap[idx/2] = heap[idx];
                heap[idx] = tmp;
                idx /= 2;
            }
        }

        public int pop(){
            int pop = heap[1];
            heap[1] = heap[hCnt--];
            int idx = 1;
            int next;
            while(true){
                next = idx * 2;
                if(next < hCnt && heap[next] < heap[next+1]) next++;
                if(next > hCnt || heap[next] < heap[idx]) break;
                int tmp = heap[idx];
                heap[idx] = heap[next];
                heap[next] = tmp;
                idx = next;
            }
            return pop;
        }
    }
}
