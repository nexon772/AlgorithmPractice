package programmers;

/**
 * n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타켓 넘버를 만들려고 합니다.
 * 예를 들어 [1,1,1,1,1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 타켓넘버 만드는 방법의 수를 반환하시오
 */
public class TargetNumber {

    public static void main(String[] args){
        System.out.println(new TargetNumber().solve(new int[]{1,1,1,1,1}, 3));
    }

    private int solve(int[] numbers, int target){

        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int cnt, int num){
        if(cnt == numbers.length) return num == target ? 1 : 0;
        else return dfs(numbers, target, cnt+1, num+numbers[cnt])+dfs(numbers, target, cnt+1, num-numbers[cnt]);
    }
}
