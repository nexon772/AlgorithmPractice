package practice_coupangTest2.dataStructure;

public class MyHeap {

    private int[] heap;

    public MyHeap(){
        heap = new int[]{};
    }

    public MyHeap(int ... args){
        heap = new int[args.length];
        for(int i=0; i<args.length; i++){
            heap[i] = args[i];
        }
        heapSort();
    }

    public boolean add(int data){
        if(heap == null) return false;
        if(heap.length < 1) heap = new int[]{};

        int[] temp = new int[heap.length+1];
        for(int i=0; i<heap.length; i++){
            temp[i] = heap[i];
        }
        temp[temp.length-1] = data;
        heap = temp;

        heapSort();

        return true;
    }

    public boolean remove(int data){
        if(heap == null || heap.length < 1) return false;

        int[] temp = new int[heap.length-1];
        int cnt = 0;
        for(int i=0; i<heap.length; i++){
            if(heap[i] != data){
                temp[cnt] = heap[i];
                cnt++;
            }
        }
        heap = temp;

        heapSort();

        return true;
    }

    public int poll(){
        int[] temp = new int[heap.length-1];
        int ret = heap[0];
        for(int i=1; i<heap.length; i++){
            temp[i-1] = heap[i];
        }
        heap = temp;

        heapSort();

        return ret;
    }

    public int peek(){
        return heap[0];
    }

    public int size(){
        return heap.length;
    }

    public int[] getHeap(){
        return heap;
    }

    private void heapSort(){
        int n = heap.length;
        if(n < 1) return;

        for(int i=n/2-1; i>=0; i--){
            heapify(heap, n, i);
        }
    }

    private void heapify(int[] arr, int n, int i){
        int p = i;
        int l = i*2+1;
        int r = l+1;

        if(l < n && arr[p] < arr[l]) p = l;
//        if(l < n && arr[p] > arr[l]) p = l;
        if(r < n && arr[p] < arr[r]) p = r;
//        if(r < n && arr[p] > arr[r]) p = r;
        if(i != p){
            swap(arr, p, i);
            heapify(arr, n, p);
        }
    }

    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
