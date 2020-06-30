package inflearn.graphDfsBfs;

import java.util.*;

/**
 * example #1
 * Input:
 * "(a)())()"
 * Output:
 * ["(a)()()", "(a())()"]
 *
 * example #2
 * Input:
 * "()())()"
 * Output:
 * ["()()()", "(())()"]
 */
public class RemoveInvalidParentheses {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        printList(solve("(a)())()"));
        printList(solve("()())()"));
    }

    private static List<String> solve(String s){
        List<String> result = new ArrayList<>();
        if(s == null) return result;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        boolean found = false;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                String str = queue.poll();
                if(isValid(str)){
                    result.add(str);
                    found = true;
                }
                if(found) continue;
                for(int j=0; j<str.length(); j++){
                    //1
                    if(str.charAt(j) != '(' && str.charAt(j) != ')') continue;
                    //2
                    String newStr = str.substring(0, j)+str.substring(j+1);
                    if(!visited.contains(newStr)){
                        queue.offer(newStr);
                        visited.add(newStr);
                    }
                }
            }
        }
        return result;
    }

    private static boolean isValid(String s){
        int cnt = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                cnt++;
            } else if(ch == ')'){
                cnt--;
                if(cnt < 0) return false; // ())(
            }
        }
        return cnt == 0;
    }

    private static void printList(List<String> list){
        System.out.println(list);
    }
}
