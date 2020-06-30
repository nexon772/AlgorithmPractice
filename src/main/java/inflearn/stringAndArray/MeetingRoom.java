package inflearn.stringAndArray;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem
 *
 * example #1
 * Input: [[0,30], [5,10], [15,20]]
 * Output: false
 *
 * example #2
 * Input: [[7,10], [2,4]]
 * Output: true
 */

public class MeetingRoom {

    public static void main(String[] args){
        run();
    }

    public static void run() {
        println(solve(new Interval[]{new Interval(15, 20), new Interval(5, 10), new Interval(0, 30)})+"");
        println(solve(new Interval[]{new Interval(7, 10), new Interval(2,4)})+"");
        println(solve(new Interval[]{new Interval(1,5), new Interval(9,13), new Interval(7,8)})+"");
        println(solve(new Interval[]{new Interval(3,7), new Interval(10,13), new Interval(12, 14)})+"");
    }

    private static boolean solve(Interval[] intervals){
        if(intervals == null){
            return false;
        }
//        printArray(intervals);

        for(int i=0; i<intervals.length; i++){
            for(int j=0; j<intervals[i].start; j++){
                System.out.print(" ");
            }
            for(int j=intervals[i].start; j<intervals[i].end; j++){
                System.out.print("=");
            }

            System.out.println(" ");
        }

        Arrays.sort(intervals, comp);

        for(int i=0; i<intervals.length-1; i++){
            if(intervals[i].end > intervals[i+1].start){
                return false;
            }
        }
        return true;
    }

    static Comparator<Interval> comp = new Comparator<Interval>(){
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    };

    private static void println(String msg){
        System.out.println(msg+"\n");
    }

    private static void printArray(Interval[] intervals){
        for(int i=0; i<intervals.length; i++){
            println(intervals[i].start+" "+intervals[i].end);
        }
    }
}

class Interval{
    int start;
    int end;
    Interval(){
        this.start = 0;
        this.end = 0;
    }
    Interval(int s, int e){
        this.start = s;
        this.end = e;
    }
}