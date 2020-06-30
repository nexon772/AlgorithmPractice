package inflearn.stringAndArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * #Priority Queue
 *
 * solve procedure
 * 1. sorting (start time ascending)
 * 2. priority queue
 * 3. end <= start merge
 *
 * example #1
 * Input: [[0, 30], [5, 10]. [15, 20]]
 * Output: 2
 *
 * example #2
 * Input: [[7, 10], [2, 4]]
 * Output: 1
 *
 * example #3
 * Input: [[1, 4], [4, 5], [4, 6]]
 * Output: 2
 */
public class MeetingRoom2 {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        MeetingRoom2 mr2 = new MeetingRoom2();
        mr2.println(mr2.solve(new Interval2[]{new Interval2(5,10), new Interval2(15, 20), new Interval2(0, 30)}));
        mr2.println(mr2.solve(new Interval2[]{new Interval2(7, 10), new Interval2(2,4)}));
        mr2.println(mr2.solve(new Interval2[]{new Interval2(1,4), new Interval2(4,5), new Interval2(4,6)}));
    }

    private String solve(Interval2[] intervals){
        if(intervals == null || intervals.length == 0){
            return null;
        }
        Arrays.sort(intervals, comp);
//        printArray(intervals);

        Queue<Interval2> heap = new PriorityQueue<Interval2>(intervals.length, comp2);
        heap.offer(intervals[0]);

        for(int i=1; i<intervals.length; i++){
            Interval2 temp = heap.poll();
            if(temp.end <= intervals[i].start){
                temp.end = intervals[i].end;
            } else {
                heap.offer(intervals[i]);
            }
            heap.offer(temp);
        }
        return heap.size()+"";
    }

    Comparator<Interval2> comp = new Comparator<Interval2>() {
        @Override
        public int compare(Interval2 o1, Interval2 o2) {
            return o1.start - o2.start;
        }
    };

    Comparator<Interval2> comp2 = new Comparator<Interval2>() {
        @Override
        public int compare(Interval2 o1, Interval2 o2) {
            return o1.end - o2.end;
        }
    };

    private void printArray(Interval2[] intervals){
        for(int i=0; i<intervals.length; i++){
            println(intervals[i].start+", "+intervals[i].end);
        }
    }

    private void println(String msg){
        System.out.println(msg);
    }
}

class Interval2{
    int start, end;
    Interval2(){
        this.start = 0;
        this.end = 0;
    }
    Interval2(int s, int e){
        this.start = s;
        this.end = e;
    }
}