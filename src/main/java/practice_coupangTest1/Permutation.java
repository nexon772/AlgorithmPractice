package practice_coupangTest1;

import java.util.Arrays;

public class Permutation {

    public static void main(String[] args){
        System.out.println(new Permutation().solve("ab", "eidbaooo"));
        System.out.println(new Permutation().solve("ab", "eiddoaoo"));
    }

    private boolean solve(String s1, String s2){
        char[] patArr = s1.toCharArray();
        Arrays.sort(patArr);

        for(int i=0; i<s2.length()-patArr.length+1; i++){
            String temp = s2.substring(i, i+s1.length());
            if(compare(temp, patArr)){
                return true;
            }
        }
        return false;
    }

    private boolean compare(String a, char[] b){
        char[] aA = a.toCharArray();
        Arrays.sort(aA);
        for(int i=0; i<aA.length; i++){
            if(aA[i] != b[i]){
                return false;
            }
        }
        return true;
    }
}
