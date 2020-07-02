package programmers.skillCheck;

public class level1_1 {

    public static void main(String[] args){
        checkAnswer(new level1_1().solution("AB", 1), "BC");
        checkAnswer(new level1_1().solution("z", 1), "a");
        checkAnswer(new level1_1().solution("a B z", 4), "e F d");
    }

    private static void checkAnswer(String result, String answer){
        if(result.equals(answer)){
            System.out.println("Correct! result: "+result+" / answer: "+answer);
        } else {
            System.out.println("Incorrect! result: "+result+" / answer: "+answer);
        }
    }

    private String solution(String s, int n){
        char[] cA = s.toCharArray();
        for(int i=0; i<cA.length; i++){
            System.out.println(cA[i]);

            if(cA[i] != ' '){
                for(int j=0; j<n; j++){
                    if(cA[i] == 'z'){
                        cA[i] = 'a';
                    } else
                    if(cA[i] == 'Z'){
                        cA[i] = 'A';
                    } else {
                        cA[i] += 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<cA.length; i++){
            sb.append(cA[i]);
        }
        return sb.toString();
    }
}
