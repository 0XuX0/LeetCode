/**
 * @ClassName TODO
 * @Description TODO
 * @Author chenghao.xu
 * @Date 2021/5/11
 */
public class Solution {

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
//        return Math.max(dp(nums, 0, n - 2),
//                dp(nums, 1,n - 1));
        return Math.max(dp2(nums, 0, n - 2),
                dp2(nums, 1,n - 1));
    }

    public static int dp(int[] nums, int start, int end) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        for (int i = end; i >= start; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[start];
    }

    public static int dp2(int[] nums, int start, int end) {
        int dp_i_1 = 0, dp_i_2 = 0;
        int dp_i = 0;
        for (int i = end; i >= start; i--) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,2};
        System.out.println(rob(nums));
    }
}
