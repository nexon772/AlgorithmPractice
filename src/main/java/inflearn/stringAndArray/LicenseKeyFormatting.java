package inflearn.stringAndArray;

/**
 * #String
 * #StringBuilder
 *
 * 1. remove hyphen
 * 2. 끝에서 네자리 끊기
 *
 * ** String, StringBuffer, StringBulder 차이점 & 장단점
 * 1. String: + 연산이나 concat을 -> 새로운 String객체를 new로 만듬 (메모리 사용량 증가)
 * 2. StringBuffer: 멀티쓰레드환경에서는 synchronized
 * 3. StringBuilder: asynchronized 싱글쓰레드환경
 *
 * example #1
 * Input:
 * String str = "8F3Z-2e-9-w";
 * String str = "8-5g-3-J";
 * String str = "8F3Z-2e-9-wabcdef"
 * int k = 4;
 * Output:
 * 8F3Z-2E9W
 * 8-5G3J
 * 8F-3Z2E-9WAB-CDEF
 */
public class LicenseKeyFormatting {

    public static void main(String[] args){run();}

    public static void run(){
        int k = 4;
        println(solve("8F3Z-2e-9-w", k));
        println(solve("8-5g-3-J", k));
        println(solve("8F3Z-2e-9-wabcdef", k));
    }

    public static String solve(String input, int digit){
        println("Input: "+input);
        String license = input.replace("-", "");
//        println(license);
        license = license.toUpperCase();
//        println(license);

        int len = license.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<license.length(); i++){
            sb.append(license.charAt(i));
        }
        for(int i=digit; i<len; i+=digit){
            println(len-i+"");
            sb.insert(len - i, "-");
        }

        return "Output: "+sb.toString();
    }

    private static void println(String msg){
        System.out.println(msg);
    }
}
