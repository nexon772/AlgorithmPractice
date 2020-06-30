package inflearn.dynamicProgramming;

/**
 * example #1
 * Input:
 * coins = [1,2,5]
 * amount = 11
 * Output:
 * 3
 * Explanation:
 * 11 = 5 + 5 + 1
 */
public class CoinChange {

    public static void main(String[] args){
        run();
    }

    public static void run(){
        System.out.println(solve(new int[]{1,2,5}, 11));
    }

    private static int solve(int[] coins, int amount){
        return 0;
    }
}
