import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/7/25
 **/
public class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        int temp = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return temp;
        }

        return dfs(node.left, temp) + dfs(node.right, temp);
    }
}
