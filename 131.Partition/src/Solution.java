import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2021/6/27
 **/
public class Solution {

    static List<List<String>> res;
    static boolean[][] dp;

    public static List<List<String>> partition(String s) {
        int len = s.length();
        res = new ArrayList<>();
        if (len == 1) return res;
        dp = new boolean[len][len];
        char[] arr = s.toCharArray();

        for(int i = len - 1; i >= 0; i--) {
            for(int j = i; j < len; j++) {
                dp[i][j] = arr[i] == arr[j] && (j - i < 2 || dp[i + 1][j - 1]);
            }
        }

        dfs(arr, 0, new ArrayList<>());

        return res;
    }

    private static void dfs(char[] arr, int pos, List<String> list) {
        if (pos == arr.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = pos; i < arr.length; i++) {
            if (dp[pos][i]) {
                list.add(new String(arr, pos, i + 1 - pos));
                dfs(arr, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> res = partition(s);
        System.out.println("Hello world");
    }
}
