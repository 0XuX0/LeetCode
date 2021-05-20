import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TODO
 * @Description TODO
 * @Author chenghao.xu
 * @Date 2021/5/17
 */
public class Solution {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        printOneLoop(matrix, 0, 0, m - 1, n - 1, ans);
        return ans;
    }

    private static void printOneLoop(int[][] matrix, int x1, int y1, int x2, int y2, List<Integer> ans) {
        if(x2 < x1 || y2 < y1) return;

        if(x1 == x2) {
            for (int i = y1; i <= y2; i++) ans.add(matrix[x1][i]);
            return;
        }

        if (y1 == y2) {
            for (int i = x1; i <= x2; i++) ans.add(matrix[i][y1]);
            return;
        }

        for (int i = y1; i < y2; i++) ans.add(matrix[x1][i]);
        for (int i = x1; i < x2; i++) ans.add(matrix[i][y2]);
        for (int i = y2; i > y1; i--) ans.add(matrix[x2][i]);
        for (int i = x2; i > x1; i--) ans.add(matrix[i][y1]);

        printOneLoop(matrix, x1 + 1, y1 + 1, x2 - 1, y2 - 1, ans);
    }

    public static void main(String[] args) {

    }
}
