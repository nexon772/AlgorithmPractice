package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class hash_PhoneNumberList {

    public static void main(String[] args){
//        checkAnswer(new hash_PhoneNumberList().solve(new String[]{"119", "97674223", "1195524421"}), false);
        checkAnswer(new hash_PhoneNumberList().solve2(new String[]{"119", "97674223", "1195524421"}), false);
//        checkAnswer(new hash_PhoneNumberList().solve(new String[]{"123", "456", "789"}), true);
        checkAnswer(new hash_PhoneNumberList().solve2(new String[]{"123", "456", "789"}), true);
//        checkAnswer(new hash_PhoneNumberList().solve(new String[]{"12", "123", "1235", "567", "88"}), false);
        checkAnswer(new hash_PhoneNumberList().solve2(new String[]{"12", "123", "1235", "567", "88"}), false);
    }

    private static void checkAnswer(boolean result, boolean answer){
        if(result == answer){
            System.out.println("Correct! result: "+result+" / answer: "+answer);
        } else {
            System.out.println("Incorrect! result: "+result+" / answer: "+answer);
        }
    }

    // gets error with some testcases
    private boolean solve(String[] phone_book){
        boolean answer = true;
        for(int i=0; i<phone_book.length; i++){
            for(int j=i+1; j<phone_book.length; j++){
                boolean result;
                if(phone_book[i].length() < phone_book[j].length())
                    result = compare(phone_book[j], phone_book[i]);
                else if(phone_book[i].length() > phone_book[i].length())
                    result = compare(phone_book[i], phone_book[j]);
                else
                    result = phone_book[i].equals(phone_book[j]);

                if(result)
                    return false;
            }
        }
        return answer;
    }

    private boolean compare(String str, String target){
        return str.startsWith(target);
    }

    // =============================================

    // gets best result
    private boolean solve2(String[] phone_book){
        Arrays.sort(phone_book, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.length() - t1.length();
            }
        });
        System.out.println(Arrays.toString(phone_book));

        for(int i=0; i<phone_book.length; i++){
            for(int j=i+1; j<phone_book.length; j++){
                if(phone_book[j].startsWith(phone_book[i])) return false;
            }
        }
        return true;
    }
}
