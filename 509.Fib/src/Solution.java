/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/4/25
 **/
public class Solution {
    public static int fib(int N) {
//        return recursion(N);
//        int[] memo = new int[N + 1];
//        return recursionWithMemo(N, memo);
        int[] dp = new int[N + 1];
        return dynamicPlanning(N, dp);
    }

    private static int recursion(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1 || N == 2) {
            return 1;
        }
        return recursion(N - 1) + recursion(N - 2);
    }

    private static int recursionWithMemo(int N, int[] memo) {
        if (N == 0) {
            return 0;
        }
        if (N == 1 || N == 2) {
            return 1;
        }
        if(memo[N] == 0) {
            memo[N] = recursionWithMemo(N - 1, memo) + recursionWithMemo(N - 2, memo);
        }
        return memo[N];
    }

    private static int dynamicPlanning(int N, int[] dp) {
        if (N == 0) {
            return 0;
        }
        if (N == 1 || N == 2) {
            return 1;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int index = 3; index <= N; index++) {
            dp[index] = dp[index - 1] + dp[index - 2];
        }
        return dp[N];
    }

    public static void main(String[] args) {
        int N = 10;
        for (int index = 0; index <= N; index++) {
            System.out.println(fib(index));
        }
    }
}
