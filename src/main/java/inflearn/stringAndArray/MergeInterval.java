package inflearn.stringAndArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * #Comparator
 *
 * Given a collection of intervals, merge all overlapping intervals
 *
 * example #1
 * Input:
 * [[1,3], [2,6], [8,10], [15,18]]
 * Output:
 * [[1,6], [8,10], [15,18]]
 */
public class MergeInterval {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        List<Interval_merge> mList = new ArrayList<>();
        mList.add(new Interval_merge(1,3));
        mList.add(new Interval_merge(2,6));
        mList.add(new Interval_merge(8,10));
        mList.add(new Interval_merge(15, 18));
        mList.add(new Interval_merge(16, 20));
        mList.add(new Interval_merge(21, 23));
        mList.add(new Interval_merge(22, 30));
//        mList.add(new Interval_merge())
        printList(solve(mList));
    }

    private static List<Interval_merge> solve(List<Interval_merge> mList){
        if(mList.isEmpty())
            return null;

        List<Interval_merge> ret = new ArrayList<>();

//        Collections.sort(mList, (a, b) -> a.start - b.start);
        Collections.sort(mList, comp);

        Interval_merge before = mList.get(0);
        for(int i=1; i<mList.size(); i++){
            if(before.end >= mList.get(i).start){
                before.end = mList.get(i).end;
            } else {
                ret.add(before);
                before = mList.get(i);
            }
        }
        if(!ret.contains(before))
            ret.add(before);

//        printList(mList);

        return ret;
    }

    static Comparator comp = new Comparator<Interval_merge>() {
        @Override
        public int compare(Interval_merge o1, Interval_merge o2) {
            return o1.start - o2.start;
        }
    };

    private static void printList(List<Interval_merge> mList){
        if(mList == null){
            System.out.println("Error: List is null");
            return;
        }
        for(int i=0; i<mList.size(); i++){
            System.out.println("[ "+mList.get(i).start+", "+mList.get(i).end+" ]");
        }
    }
}

class Interval_merge{
    int start;
    int end;
    Interval_merge(){ start = 0; end = 0;}
    Interval_merge(int s, int e){
        start = s; end = e;
    }
}
