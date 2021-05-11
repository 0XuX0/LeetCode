/**
 * @ClassName TODO
 * @Description TODO
 * @Author chenghao.xu
 * @Date 2021/5/11
 */
public class Solution {

    /**
     * dp(n) = Max(dp(n - 1) , previousMax + f(n)), n > 2
     */
    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = nums[1];
        int previousMax = res[0];
        for (int i = 2; i < nums.length; i++) {
            res[i] = Math.max(previousMax + nums[i], res[i - 1]);
            previousMax = Math.max(previousMax, res[i - 1]);
        }
        return res[nums.length - 1];
    }

    /**
     * dp(n) = Max(dp(n-1), dp(n-2) + f(n))
     */
    public static int rob2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        dp[0] = dp[1] = 0;
        for (int i = 0; i < n; i++) {
            dp[i + 2] = Math.max(dp[i + 1], dp[i] + nums[i]);
        }
        return dp[dp.length - 1];
    }

    /**
     * dp(n) = Max(dp(n-1), dp(n-2) + f(n)) 空间优化版本
     */
    public static int rob_space(int[] nums) {
        int n = nums.length;
        int dp_i = 0, dp_i_1 = 0, dp_i_2 = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,1,2};
        System.out.println(rob(nums));
        System.out.println(rob2(nums));
        System.out.println(rob_space(nums));
    }
}
