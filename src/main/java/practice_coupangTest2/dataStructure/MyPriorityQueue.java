package practice_coupangTest2.dataStructure;

public class MyPriorityQueue {

    MyHeap heap;

    public MyPriorityQueue(){
        heap = new MyHeap();
    }

    public MyPriorityQueue(int ... args){
        heap = new MyHeap(args);
    }

    public boolean offer(int data){
        return heap.add(data);
    }

    public boolean remove(int data){
        return heap.remove(data);
    }

    public int poll(){
        return heap.poll();
    }

    public int peek(){
        return heap.peek();
    }

    public int size(){
        return heap.size();
    }

    public int[] getQueue(){
        return heap.getHeap();
    }
}
