package practice_coupangTest2.testClass;

import practice_coupangTest2.dataStructure.MyPriorityQueue;

import java.util.Arrays;

public class MyPriorityQueueTester {

    public static void main(String[] args){
        testMyPriorityQueue();
    }

    public static void testMyPriorityQueue(){
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue();
        int[] arr = new int[]{9, 7, 5, 8, 1, 2, 4, 6, 10, 3};

        for(int i=0; i<arr.length; i++){
            System.out.println(myPriorityQueue.offer(arr[i]));
            System.out.println(Arrays.toString(myPriorityQueue.getQueue()));
        }

        System.out.println(myPriorityQueue.peek());
        System.out.println(myPriorityQueue.remove(3));
        System.out.println(Arrays.toString(myPriorityQueue.getQueue()));

        for(int i=0; i<arr.length-1; i++){
            System.out.println(myPriorityQueue.poll());
        }
    }
}
