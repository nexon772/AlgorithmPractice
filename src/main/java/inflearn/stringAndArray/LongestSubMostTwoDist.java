package inflearn.stringAndArray;

import java.util.HashMap;
import java.util.Map;

/**
 * #Map
 *
 * Longest Substring With At most Two Distinct
 *
 * example #1
 * Input: String s = "ccaabbb"
 * Output: 5 -> "aabbb" length of 5
 *
 * example #2
 * Input: String s = "cccaaabbbb"
 * Output: 7 -> "aaabbbb" length of 7
 *
 * example #3
 * Input: String s = "dddccaaaabb"
 * Output: 6 -> ccaaaa
 *
 * example #4
 * Input: String s = "aacddbe"
 * Output: 3 -> aac
 */
public class LongestSubMostTwoDist {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        println(solve("ccaabbb"));
        println(solve("cccaaabbbb"));
        println(solve("dddccaaaabb"));
        println(solve("aacddbe"));
    }

    private static String solve(String input){
        int start = 0, end = 0, len = 0, cnt = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(end < input.length()){
            char endChar = input.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0)+1);
            if(map.get(endChar) == 1){
                cnt++;
            }
            end++;
            while(cnt > 2){
                char startChar = input.charAt(start);
                map.put(startChar, map.get(startChar)-1);
                if(map.get(startChar) == 0) cnt--;
                start++;
            }
            len = Math.max(len, end-start);
        }

        return len+" ";
    }

    private static void println(String msg){
        System.out.println(msg);
    }
}
