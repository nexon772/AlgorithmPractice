package programmers;

public class BiggestNumber {

    public static void main(String[] args){
        checkAnswer(new BiggestNumber().getBiggestNumber(new int[]{6, 10, 2}), "6210");
        checkAnswer(new BiggestNumber().getBiggestNumber(new int[]{3, 30, 34, 5, 9}), "9534330");
    }

    private static void checkAnswer(String result, String answer){
        if(result != null){
            if(result.equals(answer)){
                System.out.println("Correct! result: "+result+" answer: "+answer);
            } else {
                System.out.println("Incorrect! result: "+result+" answer: "+answer);
            }
        } else {
            System.out.println("Invalid Input! Cannont be processed");
        }
    }

    private String getBiggestNumber(int[] array){
        String ret = null;
        

        return ret;
    }
}
