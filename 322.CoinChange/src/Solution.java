/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/4/25
 **/
public class Solution {
    public static int coinChange(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for(int i = 0; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for (int index = 0; index <= amount; index++) {
            for (int coin : coins) {
                if (index - coin < 0) {
                    continue;
                }
                dp[index] = Math.min(dp[index], dp[index - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2};
        System.out.println(coinChange(coins, 3));
    }

}
