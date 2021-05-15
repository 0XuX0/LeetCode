import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName TODO
 * @Description TODO
 * @Author chenghao.xu
 * @Date 2021/5/15
 */
public class Solution {

    /**
     * 最长回文子串
     * 动态规划
     * dp[i][j] 表示s[i] 到 s[j] 是否为回文串
     * dp[i][j] = dp[i + 1][j - 1] && (s[i] == s[j])
     */
    public static String longestPalindrome1(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = "";
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    /**
     * 遍历每个点,判断左右两侧是否相等
     */
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        int L = left;
        int R = right;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        boolean[][] used = new boolean[1][1];
        System.out.println(used[0][0]);
//        String s = "abcba";
//        System.out.println(longestPalindrome1(s));
//        System.out.println(longestPalindrome2(s));
    }
}
