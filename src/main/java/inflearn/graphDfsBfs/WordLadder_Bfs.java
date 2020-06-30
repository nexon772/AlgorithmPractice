package inflearn.graphDfsBfs;

import java.util.*;

/**
 * #Queue #Bfs
 *
 * example #1
 * Input:
 * beginWord = "hit", endWord = "cog",
 * wordList = ["hot, "dot", "dog", "lot", "log", "cog"]
 * Output:
 * 5
 * "hit"->"hot"->"dot"->"dog"->"cog
 */
public class WordLadder_Bfs {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(solve("hit", "cog", wordList));
    }

    private static int solve(String beginWord, String endWord, List<String> wordList){
        List<String> result = new ArrayList<>();
        if(wordList == null || !wordList.contains(endWord)) return 0;

//        char charact = 96;
//        for(int i=0; i<26; i++){
//            charact ++;
//            System.out.println(charact);
//        }

        Queue<String> queue = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);

        queue.offer(beginWord);
        dict.add(endWord);
        dict.remove(beginWord);
        int level = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                String str = queue.poll();
                if(str.equals(endWord)) return level;
                for(String neighbor : neighbors(str, wordList)){
                    queue.offer(neighbor);
                }
            }
            level++;
        }

        return level;
    }

    private static List<String> neighbors(String s, List<String> wordList){

        List<String> res = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);

        for(int i=0; i<s.length(); i++){
            char[] charArray = s.toCharArray();
            for(char ch = 'a'; ch <= 'z'; ch++){
                charArray[i] = ch;
                String word = String.valueOf(charArray);
                if(dict.remove(word)){
                    res.add(word);
                }
            }
        }
        return res;
    }


}
