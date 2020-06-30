package inflearn.stringAndArray;

import java.util.HashSet;
import java.util.Set;

/**
 * #Set
 *
 * **Set은 중복 허용 안함**
 * 보석 갯수, 스톤 갯수, letter 대소문자 구분
 *
 * 1. 보석은 대소문자를 구분해서 갖고 있어야 한다.
 * 2. aA -> 2개
 * 3. 스톤에 가서 aA가 개별적으로 몇 개였는 지 체크
 *
 * example #1
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 *
 * example #2
 * Input: J = "aBDd", S = "AbbbcCCCDeeefff"
 * Output: 1
 */
public class JewelsAndStones {

    public static void main(String[] args){run();}

    public static void run(){
        println(solve("aA", "aAAbbbb"));
        println(solve("aBDd", "AbbbcCCCDeeefff"));
    }

    private static String solve(String j, String s){
        Set<Character> jewelSet = new HashSet<>();
        for(char jew : j.toCharArray()){
            jewelSet.add(jew);
        }

        int cnt = 0;
        for(char st : s.toCharArray()){
            if(jewelSet.contains(st)){
                cnt++;
            }
        }

        return cnt+"";
    }

    private static void println(String msg){
        System.out.println(msg);
    }
}
