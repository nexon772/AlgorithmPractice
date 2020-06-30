package inflearn.stringAndArray;

import java.util.*;

/**
 * example #1
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * Output:
 * [
 *  ["ate", "eat", "tea"],
 *  ["nat', "tan"],
 *  ["bat"]
 * ]
 */
public class GroupAnagrams {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        printList(solve(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    private static List<List<String>> solve(String[] input){
        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i<input.length; i++){
            char[] charArray = input[i].toCharArray();
            Arrays.sort(charArray);
            if(map.containsKey(String.valueOf(charArray))){
//                List<String> tempList = map.get(String.valueOf(charArray));
//                tempList.add(input[i]);
//                map.put(String.valueOf(charArray), tempList);
                map.get(String.valueOf(charArray)).add(input[i]);
            } else {
                List<String> tempList = new ArrayList<>();
                tempList.add(input[i]);
                map.put(String.valueOf(charArray), tempList);
            }
        }

//        for(Map.Entry<String, List<String>> entry : map.entrySet()){
//            result.add(entry.getValue());
//        }
        result.addAll(map.values());

        return result;
    }

    private static void printList(List<List<String>> list){
        System.out.println("[");
        for(int i=0; i<list.size(); i++){
            System.out.print("[ ");
            for(int j=0; j<list.get(i).size(); j++){
                System.out.print(list.get(i).get(j)+" ");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}
