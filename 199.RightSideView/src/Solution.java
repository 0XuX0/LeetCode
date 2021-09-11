import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2021/6/13
 **/
public class Solution {

    public static List<Integer> res;
    public static List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) return res;
        levelOrder(root);
        return res;
    }

    private static void levelOrder(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode tmp = queue.poll();
                if (i == sz - 1) res.add(tmp.val);
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
            }
        }
    }

    public static void main(String[] args) {

    }
}
