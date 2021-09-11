/**
 * @ClassName TODO
 * @Description TODO
 * @Author chenghao.xu
 * @Date 2021/5/11
 */
public class Solution {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], - prices[i]);
        }
        return dp[n - 1][0];
    }

    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }

    public static int maxProfit3(int[] prices) {
        int len = prices.length;
        int[][][] dp = new int[len][3][2];
        dp[0][0][0] = Integer.MIN_VALUE;
        dp[0][1][0] = Integer.MIN_VALUE;
        dp[0][2][0] = 0;
        dp[0][0][1] = Integer.MIN_VALUE;
        dp[0][1][1] = -1 * prices[0];
        dp[0][2][1] = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            for(int k = 2; k >= 1; k--) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][2][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,4,5};
//        System.out.println(maxProfit(prices));
//        System.out.println(maxProfit2(prices));
        System.out.println(maxProfit3(prices));
    }
}
