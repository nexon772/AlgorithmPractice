package test;

import java.util.*;

public class SortTest {

    /*
    public static void main(String[] args){
        List<Integer> mList = new ArrayList<>();
        mList.add(4);
        mList.add(3);
        mList.add(6);
        mList.add(1);

        printList(mList);
        Collections.sort(mList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        printList(mList);
    }

    private static void printList(List<Integer> mList){
        System.out.println("=========================");
        for(int i=0; i<mList.size(); i++){
            System.out.println("[ "+mList.get(i)+" ]");
        }
        System.out.println("=========================");
    }
    */

    public static void main(String[] args){
        int a[] = new int[]{1, 2, 3};
//        System.out.println(a[0]+" "+a[1]+" "+a[2]);
        function(a);
//        System.out.println(a[0]+" "+a[1]+" "+a[2]);

        Set<String> set = new HashSet<>();
        set.add("abc");
        set.add("def");
        set.remove("abc");

        Map<String, String> map = new HashMap<>();
        System.out.println(map.get("anthing"));

        int integ = 5;
        System.out.println(5/2);
        String sss = "1111";

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
//        System.out.println(list);
        list.remove(1);
//        System.out.println(list.get(0));

        String str = "aaabbb";
        str.length();
        String[] arg = new String[]{"aaa", "bbb"};
        int len = arg.length;
        int size = arg[0].length();


        String str2 = "aaabbb";
        String str3 = "aba";
//        System.out.println(str2.contains(str3));



    }

    private static void function(int[] a){
        a[2] = 4;
//        System.out.println(a[0]+" "+a[1]+" "+a[2]);
    }


}
