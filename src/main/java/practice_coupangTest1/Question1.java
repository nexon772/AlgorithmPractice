package practice_coupangTest1;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>문제설명</b>
 * 숫자로 된 케이크 초를 손님에게 판매하려고 합니다.
 * 케이크 초 한 세트에는 숫자 0 부터 9모양의 초가 하나씩 들어있으며, 6과 9는 어느 방향으로 꽂아도
 * 상관없도록 제작되어 있습니다. 손님들이 케이크 초로 표시하려는 나이의 리스트가 ages로 주어집니다.
 * 이 떄, 모든 손님이 원하는 나이의 케이크 초를 제공하기 위해 준비해야 하는 케이크 초 세트의 최솟값을
 * return하도록 solution 함수를 완성하세요.
 *
 * <b>제한사항</b>
 * - ages의 길이 : 10,000 이하의 자연수
 * - ages의 원소 : 100이하의 자연수
 *
 * <b>입출력 예</b>
 * example #1
 * Input:
 * [23, 61, 46]
 * Output:
 * 1
 *
 * example #2
 * Input:
 * [44, 33, 69, 62]
 * Output:
 * 2
 *
 * example #3
 * Input:
 * [66, 69, 62, 24, 57]
 * Output:
 * 3
 *
 * <b>입출력 예 설명</b>
 * example #1
 * 케이크 초 1세트를 뜯어 나이가 23, 61인 손님을 위해 2,3,6,1 모양의 초를 판매했으므로
 * 0,4,7,8,9 모양의 초가 남아있습니다. 다음으로 46의 경우 앞에서 숫자 6 모양의 초를 팔았지만,
 * 9모양의 초로 대체하여 판매할 수 있으므로 새로운 초 세트를 뜯을 필요가 없습니다. 따라서 1 세트로
 * 3명의 고객 모두에게 판매할 수 있어서 1을 return합니다.
 */
public class Question1 {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        System.out.println(new Question1()
                .solve(new int[]{23, 61, 46}));
        System.out.println(new Question1()
                .solve(new int[]{44, 33, 69, 62}));
        System.out.println(new Question1()
                .solve(new int[]{66, 69, 62, 24, 57}));
    }

    private int solve(int[] ages){

        int max = 0, max69 = 0;

        /*
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<ages.length; i++){
            char[] charArray = String.valueOf(ages[i]).toCharArray();
            for(int j=0; j<charArray.length; j++){
                if(!map.containsKey(charArray[j])){
                    map.put(charArray[j], 1);
                } else {
                    map.put(charArray[j], map.get(charArray[j])+1);
                }
            }
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getKey() == '6' || entry.getKey() == '9'){
                max69 += entry.getValue();
            } else {
                max = Math.max(max, entry.getValue());
            }
        }
        */

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<ages.length; i++){
            char[] charArray = String.valueOf(ages[i]).toCharArray();
            for(int j=0; j<charArray.length; j++){
                if(!map.containsKey(charArray[j])){
                    map.put(charArray[j], 1);
                    if(charArray[j] == '6' || charArray[j] == '9'){
                        max69 += 1;
                    } else {
                        max = Math.max(max, map.get(charArray[j]));
                    }
                } else {
                    map.put(charArray[j], map.get(charArray[j])+1);
                    if(charArray[j] == '6' || charArray[j] == '9'){
                        max69 += 1;
                    } else {
                        max = Math.max(max, map.get(charArray[j]));
                    }
                }
            }
        }

        if(max69%2 != 0){
            max69 = max69/2 +1;
        } else {
            max69 = max69/2;
        }

        if(max < max69){
            return max69;
        }
        return max;
    }
}
