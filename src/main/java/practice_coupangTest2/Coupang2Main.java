package practice_coupangTest2;

import java.util.Iterator;
import java.util.LinkedList;

public class Coupang2Main {

    public static void main(String[] args){
        linkedListTest();
    }

    private static void linkedListTest(){
        LinkedList<String> llist = new LinkedList<>();
        llist.add("hello");
        llist.add("world");

        int i=0;
        Iterator it = llist.iterator();
        while(it.hasNext()){
            System.out.println(i+" "+it.next());
            i++;
        }
    }
}
