package hackerrank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * PROBLEM
 * Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string.
 * Given a string, find the number of pairs of substrings of the string that are anagrams of each other.
 * For example s = mom, the list of all anagrammatic pairs is [m,m], [mo,om] at positions [[0],[2]],[[0,1],[1,2]] respectively.
 *
 * FUNCTION DESCRIPTION
 * Complete the function sherlockAndAnagrams in the editor below.
 * It must return an integer that represents the number of anagrammatic pairs of substrings in s.
 * sherlockAndAnagrams has the following parameter(s):
 * s: a string
 *
 * INPUT FORMAT
 * The first line contains an integer q, the number of queries.
 * Each of the next q lines contains a string s to analyze.
 *
 * CONSTRAINTS
 * 1<=q<=10
 * 2<=|s|<=100
 * String s contains only lowercase letters ASCII[a-z].
 *
 * OUTPUT FORMAT
 * For each query, return the number of unordered anagrammatic pairs.
 *
 * example #1
 * Input:
 * int q = 2;
 * String str1 = "abba";
 * String str2 = "abcd";
 * Output:
 * 4
 * 0
 * Explanation
 * The list of all anagrammatic pairs is [a,a], [ab,ba], [b,b] and [abb,bba].
 * No anagrammatic pairs exist in the second query as no character repeats.
 *
 * example #2
 * Input:
 * int q = 2;
 * String str1 = "ifailuhkqq";
 * String str2 = "kkkk";
 * Output:
 * 3
 * 10
 * Explanation:
 * [i,i], [q,q], [ifa,fai]
 * [k,k] x 6 times, [kk,kk] x 3, [kkk, kkk] x 1
 *
 * example #3
 * Input:
 * int q = 1;
 * String str = "cdcd";
 * Output:
 * 5
 */
public class SherlockAndAnagrams {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        println(solve("abba")+"");
        println(solve("abcd")+"");
        println(solve("ifailuhkqq")+"");
        println(solve("kkkk")+"");
        println(solve("cdcd")+"");
    }

    private static int solve(String s){
//        System.out.println(s.substring(0,1));
        int cnt = 0;
        Set<String> mSet = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                String temp = s.substring(i, j+1);
                System.out.println(temp);
                temp = sort(temp);
                boolean res = mSet.add(temp);
                if(!res){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static String sort(String s){
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        return String.valueOf(sArray);
    }

    private static boolean checkAnagram(String a, String b){
        if(a.length() != b.length())
            return false;
        char[] aA = a.toCharArray();
        char[] bA = b.toCharArray();
        Arrays.sort(aA);
        Arrays.sort(bA);
        for(int i=0; i<aA.length; i++){
            if(aA[i] != bA[i])
                return false;
        }
        return true;
    }

    private static void println(String msg){
        System.out.println(msg);
    }
}
