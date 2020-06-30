package practice_coupangTest2.programmers;

import java.util.*;

public class BestAlbum {

    public static void main(String[] args){
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};

        new BestAlbum().bestAlbum(genres, plays);
    }

    ArrayList<Integer> bestAlbum;
    ArrayList<Song> songList;
    HashMap<String, Integer> genreMap;
    HashMap<String, Integer> albumMap;

    private void bestAlbum(String[] genres, int[] plays){
//
//        Map<String, Integer> map = new HashMap<>();
//        for(int i=0; i<genres.length; i++){
//            if(map.containsKey(genres[i])){
//                map.put(genres[i], map.get(genres[i])+plays[i]);
//            } else {
//                map.put(genres[i], plays[i]);
//            }
//        }
//
//        ArrayList<Song> list = new ArrayList<>();
//        for(Map.Entry<String, Integer> entry : map.entrySet()){
//            list.add(new Song(entry.getKey(), entry.getValue()));
//        }
//        Collections.sort(list, comp);
//
//        for(Song)
//
//
//
//
//
//
//
//
//        for(int i=0; i<genres.length; i++){
//            String curGenre = genres[i];
//            if(list.stream().filter(o -> o.genre.equals(curGenre)).findFirst().isPresent()){
//                int oldSongIdx = list.indexOf();
//                Song oldSong = list.get(oldSongIdx);
//                list.remove(oldSongIdx);
//                Song newSong = new Song(genres[i], oldSong.play + plays[i], oldSong.id);
//                list.add(newSong);
//            } else {
//                list.add(new Song(genres[i], plays[i], i));
//            }
//        }
//        Collections.sort(list, comp);
//
//        for(int i=0; i<list.size(); i++){
//            Song curSong = list.get(i);
//            System.out.println(curSong.genre+" "+curSong.play+" "+curSong.id);
//        }

        bestAlbum = new ArrayList<>();
        songList = new ArrayList<>();
        genreMap = new HashMap<>();
        albumMap = new HashMap<>();

        for(int i = 0 ; i < genres.length ; ++i){
            int id = i;
            int play = plays[i];
            String genre = genres[i];

            songList.add(new Song(id, play, genre));

            if(genreMap.containsKey(genre)){
                genreMap.put(genre, genreMap.get(genre) + play);
            } else {
                genreMap.put(genre, play);
            }
        }

        Collections.sort(songList, new Comparator<Song>(){
            @Override
            public int compare(Song s1, Song s2){
                if(s1.genre.equals(s2.genre)){
                    return s1.compareTo(s2);
                } else {
                    return -(genreMap.get(s1.genre) - genreMap.get(s2.genre));
                }
            }
        });

        for(Song song : songList){
            if(!albumMap.containsKey(song.genre)){
                albumMap.put(song.genre, 1);
                bestAlbum.add(song.id);
            } else {
                int genreCnt = albumMap.get(song.genre);

                if(genreCnt >= 2) continue;
                else {
                    albumMap.put(song.genre, genreCnt + 1);
                    bestAlbum.add(song.id);
                }
            }
        }

        int[] answer = new int[bestAlbum.size()];
        for(int i = 0 ; i < answer.length ; ++i){
            answer[i] = bestAlbum.get(i);
        }

        System.out.println(Arrays.toString(answer));
    }

    Comparator<Song> comp = new Comparator<Song>() {
        @Override
        public int compare(Song o1, Song o2) {
            if(o1.genre.equals(o2.genre)){
                return o1.compareTo(o2);
            } else {
                return o2.play - o1.play;
            }
        }
    };

    class Song implements Comparable<Song> {
        int id, play;
        String genre;

        Song(int id, int play, String genre){
            this.id = id;
            this.play = play;
            this.genre = genre;
        }

        @Override
        public int compareTo(Song o){
            if(this.play == o.play){
                return this.id - o.id;
            } else {
                return -(this.play - o.play);
            }
        }
    }
}
