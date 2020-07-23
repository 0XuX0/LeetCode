import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/7/18
 **/
public class Solution {
    private static Integer[][] memo;
    public static int minimumTotal(List<List<Integer>> triangle) {
        memo = new Integer[triangle.size()][triangle.size()];
        return dfs(triangle, 0, 0);
    }

    private static int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        return memo[i][j] = Math.min(dfs(triangle, i + 1, j),dfs(triangle, i + 1, j +1)) + triangle.get(i).get(j);
    }

    private static int min(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }


    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();
        List<Integer> r3 = new ArrayList<>();
        r1.add(1);
        r2.add(1);
        r2.add(2);
        r3.add(1);
        r3.add(2);
        r3.add(3);
        triangle.add(r1);
        triangle.add(r2);
        triangle.add(r3);
        System.out.println(minimumTotal(triangle));
        System.out.println(min(triangle));
    }
}
