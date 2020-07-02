package programmers;

import java.util.*;

public class hash_BestAlbum {

    public static void main(String[] args){
        checkAnswer(new hash_BestAlbum().getBestAlbum(
                new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500}), new int[]{4,1,3,0});
    }

    private static void checkAnswer(int[] result, int[] answer){
        boolean flag = false;
        if(result.length != answer.length){
            System.out.println("Wrong input length! result: "+ Arrays.toString(result)+" / answer: "+Arrays.toString(answer));
            return;
        }

        for(int i=0; i<result.length; i++){
            if(result[i] != answer[i]){
                System.out.println("Incorrect! result: "+ Arrays.toString(result)+" / answer: "+Arrays.toString(answer));
                return;
            }
        }
        System.out.println("Correct! result: "+ Arrays.toString(result)+" / answer: "+Arrays.toString(answer));
    }

    private int[] getBestAlbum(String[] genres, int[] plays){

        // get list of genres ordered by total play by using priority queue
        // within the genres,

        PriorityQueue<Album> totalPlayOrder = new PriorityQueue<>(new Comparator<Album>() {
            @Override
            public int compare(Album album1, Album album2) {
                return album2.plays - album1.plays;
            }
        });

        List<Album> albumList = new ArrayList<>();
        Map<String, Integer> totalAlbumMap = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            albumList.add(new Album(genres[i], plays[i], i));
            if(!totalAlbumMap.containsKey(genres[i])){
                totalAlbumMap.put(genres[i], plays[i]);
            } else {
                totalAlbumMap.put(genres[i], totalAlbumMap.get(genres[i])+plays[i]);
            }
        }
        for(Map.Entry entry : totalAlbumMap.entrySet()){
            totalPlayOrder.offer(new Album(entry.getKey().toString(), (int)entry.getValue(), 0));
        }

        List<Integer> result = new ArrayList<>();
        while(!totalPlayOrder.isEmpty()){
            Album curAlbum = totalPlayOrder.poll();
//            System.out.println("current genre: "+curAlbum.genre);
            List<Album> genreList = new ArrayList<>();
            for(int i=0; i<albumList.size(); i++){
                if(albumList.get(i).genre.equals(curAlbum.genre)){
                    genreList.add(albumList.get(i));
                }
            }
            genreList.sort(new Comparator<Album>() {
                @Override
                public int compare(Album album1, Album album2) {
                    return album2.plays - album1.plays;
                }
            });
            for(int i=0; i<genreList.size(); i++){
//                System.out.println(genreList.get(i).genre+" "+genreList.get(i).plays);
            }

//            System.out.println(genreList.size());

            int cnt = 0;
            for(int i=0; i<(genreList.size() < 2 ? 1 : 2); i++){
                result.add(genreList.get(i).index);
                cnt++;
                if(cnt == 2) break;
            }
//            System.out.println(result);
        }

        int[] ret = new int[result.size()];
        for(int i=0; i<ret.length; i++){
            ret[i] = result.get(i);
        }

        return ret;
    }

    class Album{
        String genre;
        int plays;
        int index;
        public Album(String genre, int plays, int index){
            this.genre = genre;
            this.plays = plays;
            this.index = index;
        }
    }
}
