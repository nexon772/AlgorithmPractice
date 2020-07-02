package programmers;

public class stackQueue_IronStick {

    public static void main(String[] args){
        checkAnswer(new stackQueue_IronStick().solve("()(((()())(())()))(())"), 17);
    }

    private static void checkAnswer(int result, int answer){
        if(result == answer){
            System.out.println("Correct! result: "+result+" / answer: "+answer);
        } else {
            System.out.println("Incorrect! result: "+result+" / answer: "+answer);
        }
    }

    private int solve(String arrangement){
        return 0;
    }
}
