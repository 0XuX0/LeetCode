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

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> tmp = new ArrayList<>();
        TreeNode dummy = new TreeNode(-1);
        queue.add(root);
        queue.add(dummy);
        int row = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.equals(dummy) && queue.isEmpty()) {
                resAdd(res, tmp, row);
                break;
            }
            if (node.equals(dummy)) {
                resAdd(res, tmp, row);
                row++;
                tmp = new ArrayList<>();
                queue.add(dummy);
            } else {
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return res;
    }

    private static void resAdd(List<List<Integer>> res, List<Integer> tmp, int row) {
        if (row % 2 == 1) {
            res.add(tmp);
        }
        else {
            List<Integer> reverse = new ArrayList<>();
            for(int i = tmp.size() - 1; i >= 0; i--) {
                reverse.add(tmp.get(i));
            }
            res.add(reverse);
        }
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

        List<List<Integer>> res = zigzagLevelOrder(root);
        System.out.println("hhh");
    }
}
