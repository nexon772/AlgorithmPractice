package inflearn.stringAndArray;

import java.util.*;

/**
 * example #1
 * String txt = "BACDGABCDA";
 * String pat = "ABCD";
 *
 * Output: [0, 5, 6]
 */
public class FindAllAnagrams {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        printList(solve("BACDGABCDA", "ABCD")); // [0, 5, 6]
        printList(solve("ABDCAHIABJDCBACDBA", "ABCD")); // [0, 1, 10, 12, 13, 14]
    }

    private static List<Integer> solve(String txt, String pat){
        List<Integer> list = new ArrayList<>();

        char[] patArr = pat.toCharArray();
        Arrays.sort(patArr);

        for(int i=0; i<txt.length()-pat.length()+1; i++){
            String temp = txt.substring(i, i+4);
            if(compare(temp, patArr)){
                list.add(i);
            }
        }
        return list;
    }

    private static boolean compare(String a, char[] b){
        char[] aA = a.toCharArray();
        Arrays.sort(aA);
        for(int i=0; i<aA.length; i++){
            if(aA[i] != b[i]){
                return false;
            }
        }
        return true;
    }

    /*
    private static List<Integer> solve(String txt, String pat){
        //1
        List<Integer> result = new ArrayList<>();
        if(txt==null||txt.length()==0||pat==null||pat.length()==0||txt.length()<pat.length())
            return result;
        //2
        int[] patArr = new int[256];//[0,0,0,0,0,0,1,1,1,1,0,0,0]
        for(int i=0; i<pat.length();i++) {
            patArr[pat.charAt(i)]++;
        }

        for(int i=0; i<txt.length()-pat.length()+1; i++) {
            int[] txtArr = new int[256];
            for(int j=0; j<pat.length(); j++) {
                txtArr[txt.charAt(i+j)]++; //0+, 1+
            }

            if(check(patArr, txtArr)) {
                result.add(i);
            }
        }
        return result;
    }
    private static boolean check(int[] patArr, int[] txtArr) {
        for(int i=0; i<patArr.length; i++) {
            if(patArr[i] != txtArr[i]) {
                return false;
            }
        }
        return true;
    }
    */

    private static void printList(List<Integer> output){
        System.out.print("[ ");
        for(int i=0; i<output.size(); i++){
            System.out.print(output.get(i)+" ");
        }
        System.out.println("]");
    }

    private static void printArray(int[] output){
        System.out.print("[ ");
        for(int i=0; i<output.length; i++){
            System.out.print(output[i]+" ");
        }
        System.out.println("]");
    }
}
