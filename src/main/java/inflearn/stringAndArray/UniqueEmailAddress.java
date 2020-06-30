package inflearn.stringAndArray;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * example #1
 * Input:
 * [
 * "test.email+james@coding.com",
 * "test.e.mail+toto.jane@coding.com",
 * "testemail+tom@cod.ing.com"]
 * Output:
 * 2
 * "testemail@coding.com"
 * "testemail@cod.ing.com"
 *
 */
public class UniqueEmailAddress {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        printResult(solve(new String[]{
                "test.email+james@coding.com",
                "test.e.mail+toto.jane@coding.com",
                "testemail+tom@cod.ing.com"
        }));
    }

    private static Set<String> solve(String[] input){
        Set<String> result = new HashSet<>();
        for(int i=0; i<input.length; i++){
            String[] delim = input[i].split("@");

            String user = delim[0].replace(".", "");
            if(user.contains("+")){
                int idx = user.indexOf("+");
                user = user.substring(0, idx);
            }

            result.add(user+"@"+delim[1]);
        }
        return result;
    }

    private static void println(String msg){
        System.out.println(msg);
    }

    private static void printArray(String[] array){
        for(int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }

    private static void printResult(Set<String> result){
        System.out.println(result.size()+"\n"+result.toString());

    }
}
