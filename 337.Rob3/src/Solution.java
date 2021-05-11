import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TODO
 * @Description TODO
 * @Author chenghao.xu
 * @Date 2021/5/11
 */
public class Solution {

    static Map<TreeNode, Integer> memo = new HashMap<>();

    public static int rob(TreeNode node) {
        if (node == null) return 0;
        if (memo.containsKey(node)) return memo.get(node);
        int rob = node.val + (node.left == null ? 0 : rob(node.left.left) + rob(node.left.right)) + (node.right == null ? 0 : rob(node.right.left) + rob(node.right.right));
        int not_rob = rob(node.left) + rob(node.right);
        int res = Math.max(rob, not_rob);
        memo.put(node, res);
        return res;
    }

    public static void main(String[] args) {

    }
}
