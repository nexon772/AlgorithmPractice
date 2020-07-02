package programmers;

import java.util.HashMap;
import java.util.Map;

public class hash_Disguise {

    public static void main(String[] args){
        checkAnswer(new hash_Disguise().solve(new String[][]{
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}}),5);
        checkAnswer(new hash_Disguise().solve(new String[][]{
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smokey_makeup", "face"}}), 3);
        checkAnswer(new hash_Disguise().solve(new String[][]{
                {"white_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"blue_hat", "headgear"},
                {"white_sunglasses", "eyewear"},
                {"crow_mask", "face"},
                {"smokey_makeup", "face"}}), 26);
    }

    private static void checkAnswer(int result, int answer){
        if(result == answer){
            System.out.println("Correct! result: "+result+" / answer: "+answer);
        } else {
            System.out.println("Incorrect! result: "+result+" / answer: "+answer);
        }
    }

    private void printCombination(String[][] clothes, int index){
        for(int i=0; i<clothes.length; i++){
            System.out.print(" ["+clothes[i][0]+","+clothes[i][1]+"][");
            if(i == index){
                System.out.print(i);
            }
            System.out.println("] ");
        }
    }

    private int solve(String[][] clothes) {

//        Arrays.sort(clothes, new Comparator<String[]>() {
//            @Override
//            public int compare(String[] arr1, String[] arr2) {
//                return arr1[1].compareTo(arr2[1]);
//            }
//        });
//
//        int cnt = 0;
//        for(int i=0; i<clothes.length; i++){
//            Set<String> mSet = new HashSet<>();
//            System.out.print(">"+clothes[i][0] +" "+clothes[i][1]);
//            if(mSet.add(clothes[i][1])){
//                cnt++;
//                System.out.println("YES "+ cnt);
//            } else {
//                System.out.println("NO "+cnt);
//            }
//            for(int j=i+1; j<clothes.length; j++){
//                System.out.print(clothes[j][0] +" "+clothes[j][1]);
//                if(mSet.add(clothes[j][1])){
//                    cnt++;
//                    System.out.println("YES "+cnt);
//                } else {
//                    System.out.println("NO "+cnt);
//                }
//            }
//        }
//
//        return cnt;

        Map<String, Integer> mMap = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            if(mMap.containsKey(clothes[i][1])){
                mMap.put(clothes[i][1], mMap.get(clothes[i][1])+1);
            } else {
                mMap.put(clothes[i][1], 1);
            }
            System.out.println(mMap);
        }

        int cnt = 1;
        for(Map.Entry entry : mMap.entrySet()){
            cnt *= ((int)entry.getValue() + 1);
        }
        return cnt -1;
    }

    class Combination {
        Map<String, String> combo; // <item, category>
        public Combination(String[] ... args){
            combo = new HashMap<>();
            for(String[] arg : args){
                if(!combo.containsValue(arg[1]))
                    combo.put(arg[0], arg[1]);
            }
        }

        public Combination(Combination arg){
            combo = new HashMap<>();
            for(Map.Entry entry : arg.getCombinationMap().entrySet()){
                if(!combo.containsValue(entry.getValue()))
                    combo.put(entry.getKey().toString(), entry.getValue().toString());
            }
        }

        public int size(){
            return combo.size();
        }

        public Map<String, String> getCombinationMap(){
            return combo;
        }

        public void add(String[] arg){
            if(!combo.containsValue(arg[1]))
                combo.put(arg[0], arg[1]);
        }

        public String printCombination(){
            String str = "[ ";
            for(Map.Entry entry : combo.entrySet()){
                str += "["+entry.getKey()+", "+entry.getValue()+"] ";
            }
            str += "]";
            return str;
        }
    }
}
