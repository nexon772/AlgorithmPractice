package programmers;

import java.util.*;

/**
 *
 */
public class IncompletedPlayer {

    public static void main(String[] args){
        System.out.println(new IncompletedPlayer().solve(
                new String[]{"leo", "kiki", "eden"},
                new String[]{"eden", "kiki"}));
        System.out.println(new IncompletedPlayer().solve(
                new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
                new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(new IncompletedPlayer().solve(
                new String[]{"mislav", "stanko", "mislav", "ana"},
                new String[]{"stanko", "ana", "mislav"}));
    }

    private String solve(String[] participant, String[] completion){
        if(participant == null || completion == null ||
                participant.length == 0 || completion.length == 0) return null;

        // accuracy 100%, efficiency 0%
        List<String> list = new ArrayList<>(Arrays.asList(completion));
        for(String str : participant){
            if (list.contains(str)) {
                list.remove(str);
            } else {
                return str;
            }
        }
        return null;
    }
}
