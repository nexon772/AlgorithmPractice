package programmers;

import java.util.Arrays;
import java.util.List;

public class TravelRoute {

    public static void main(String[] args){
        System.out.println(Arrays.toString(new TravelRoute().solve(new String[][]{
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        })));
        System.out.println(Arrays.toString(new TravelRoute().solve(new String[][]{
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"}
        })));
    }

    private String[] solve(String[][] tickets){
        boolean[] visited = new boolean[tickets.length];
//        List<String> result =
        for(int i=0; i<tickets.length; i++){
            String start = tickets[i][0];
            String end = tickets[i][1];

        }
        return null;
    }
}
