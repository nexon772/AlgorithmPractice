package programmers;

import java.lang.reflect.Array;
import java.util.*;

public class Disguise {
    public static void main(String[] args){
        System.out.println(new Disguise().solve(new String[][]{
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        }));

        System.out.println(new Disguise().solve(new String[][]{
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}
        }));
    }

    private int solve(String[][] clothes){

        for(int i=0; i<clothes.length-1; i++){
            Map<String, String> map = new HashMap<>();
            map = getCombination(clothes, i);
            System.out.println(map);
        }
        return 0;

//        Set<String[]> set = new HashSet<>();
//        for(int i=0; i<clothes.length; i++){
//            for(int j=i; j<clothes.length; j++){
//                System.out.println(clothes[i][0] +" "+ clothes[j][0]);
//                if(clothes[i][0].equals(clothes[j][0]))
//                    set.add(clothes[i]);
//                else {
//                    if(!clothes[i][1].equals(clothes[j][1])){
//                        set.add(new String[]{clothes[i][0]+clothes[j][0], clothes[i][1]+clothes[j][1]});
//                    }
//                }
//            }
//        }
//        return set.size();
    }

//    List<String> combi;
//
//    private void combination(String[][] clothes, int start){
//        for(int i=start; i<clothes.length; i++){
//            if(!combi.contains(clothes[i][0]))
//            combi.add(clothes[i][0]);
//            System.out.println("add: "+combi);
//            if(i<clothes.length)
//                combination(clothes, start+1);
//            combi.remove(clothes[i][0]);
//        }
//    }

    private Map<String, String> getCombination(String[][] clothes, int start){
        Map<String, String> map = new HashMap<>();
        for(int i=start; i<clothes.length; i++){
            if(!map.containsValue(clothes[i][1])){
                map.put(clothes[i][0], clothes[i][1]);
            }
        }
        return map;
    }
}
