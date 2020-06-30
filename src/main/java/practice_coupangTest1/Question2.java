package practice_coupangTest1;

import java.util.Stack;

/**
 * <b>문제설명</b>
 * 0과 1로 이루어진 문자열 S가 있습니다. S의 임의의 위치에서, 0과 1이 붙어있을 경우
 * 두 개의 문자열을 짝지어 제거할 수 있습니다. 예를 들어, "1011"이라는 문자열이 있으면,
 * 첫 번째 문자 "1"과 두 번째 문자 "2"을 짝지어 제거하면 "11"만 남게 됩니다.
 * 제거한 후 연결된 새로운 문자열에서 짝이 생길 경우에도 반복하여 제거합니다. 남은 문자열
 * "11"은 짝지어 제거할 수 없습니다.
 * 문자열 s가 매개변수로 주어질 때, 짝지어 제거하며 만들 수 있는 문자열 중
 * 가장 짧은 문자열의 길이를 return하는 solution함수를 완성해 주세요
 *
 * <b>제한사항</b>
 * - 문자열 s의 길이: 100,000 이하의 자연수
 *
 * <b>입출력 예</b>
 * example #1
 * Input:
 * String S = "1011"
 * Output:
 * 2
 *
 * example #2
 * Input:
 * String S = "0110011"
 * Output:
 * 1
 *
 * example #3
 * Input:
 * String S = "000111"
 * Output:
 * 0
 */
public class Question2 {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        System.out.println(new Question2().solve("1011"));
        System.out.println(new Question2().solve("0110011"));
        System.out.println(new Question2().solve("000111"));
    }

    private int solve(String S){
        char[] s = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length; i++){
            if(stack.isEmpty()){
                stack.push(s[i]);
            } else {
                if(stack.peek() != s[i]){
                    stack.pop();
                } else {
                    stack.push(s[i]);
                }
            }
        }

        return stack.size();
    }
}
