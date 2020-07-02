package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class sort_BiggestNumber {

    public static void main(String[] args){
        checkAnswer(new sort_BiggestNumber().getBiggestNumber(new int[]{6, 10, 2}), "6210");
        checkAnswer(new sort_BiggestNumber().getBiggestNumber(new int[]{3, 30, 34, 5, 9}), "9534330");
        checkAnswer(new sort_BiggestNumber().getBiggestNumber(new int[]{51, 28, 492, 9, 1267, 426, 67}), "96751492426281267");
        checkAnswer(new sort_BiggestNumber().getBiggestNumber(new int[]{1101, 1200, 101, 10, 110, 1}), "12001101110101110");
    }

    private static void checkAnswer(String result, String answer){
        if(result.equals(answer)) System.out.println("Correct! result: "+result+" / answer: "+answer);
        else System.out.println("Incorrect! result: "+result+" / answer: "+answer);
    }

    private String getBiggestNumber(int[] numbers){
        List<char[]> mList = new ArrayList<>();
        for(int num : numbers){
            mList.add((num+"").toCharArray());
        }

        mList.sort(comp);

        for(int i=0; i<mList.size(); i++){
            System.out.println(mList.get(i));
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<mList.size(); i++){
            String str = new String(mList.get(i));
            sb.append(str);
        }

        return sb.toString();
    }

    Comparator<char[]> comp = new Comparator<char[]>() {
        @Override
        public int compare(char[] chArr1, char[] chArr2) {
            if(chArr1[0] - chArr2[0] == 0){
                return compareChar(chArr1, chArr2, 1);
            }
            return chArr2[0] - chArr1[0];
        }
    };

    private int compareChar(char[] ch1, char[] ch2, int index){
        System.out.println(Arrays.toString(ch1)+" "+Arrays.toString(ch2)+" "+index);
        if(ch1.length != ch2.length){
            if(ch1.length < ch2.length){
//                System.out.println(" !");
                if(ch2[ch1.length] == '0'){
                    return 1;
                } else {
                    return -1;
                }
            } else {
                if(ch1[ch2.length] == '0'){
                    return 1;
                } else return -1;
            }
        }
        if(ch1.length <= index) return 1;
        if(ch2.length <= index) return -1;
        if(ch1[index] - ch2[index] == 0) return compareChar(ch1, ch2, index++);
        return ch2[index] - ch1[index];
    }
}
