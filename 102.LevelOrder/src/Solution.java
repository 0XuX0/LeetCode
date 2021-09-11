import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName TODO
 * @Description TODO
 * @Author chenghao.xu
 * @Date 2021/5/17
 */
public class Solution {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        TreeNode dummy = new TreeNode(-1);
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        queue.add(root);
        queue.add(dummy);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.equals(dummy) && queue.isEmpty()) {
                res.add(tmp);
                break;
            }
            if (node.equals(dummy)) {
                res.add(tmp);
                tmp = new ArrayList<>();
                queue.add(dummy);
            } else {
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                tmp.add(node.val);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(6);

        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node2.right = node4;

        List<List<Integer>> res = levelOrder(root);
        System.out.println("hhh");
    }
}
