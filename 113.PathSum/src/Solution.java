import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/6/28
 **/
public class Solution {
    public static List<List<Integer>> path = new ArrayList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return path;
        }
        recursion(root, sum, new ArrayList<>());
        return path;
    }

    private static void recursion(TreeNode node, int sum, List<Integer> curList) {
        sum -= node.val;
        curList.add(node.val);
        if (sum == 0 && node.left == null && node.right == null) {
            path.add(new ArrayList<>(curList));
            curList.remove(curList.size() - 1);
            return;
        }

        if (node.left != null) {
            recursion(node.left, sum, curList);
        }

        if (node.right != null) {
            recursion(node.right, sum, curList);
        }

        curList.remove(curList.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode l1 = new TreeNode(4);
        TreeNode ll1 = new TreeNode(11);
        TreeNode r1 = new TreeNode(12);
        TreeNode rl1 = new TreeNode(-3);
        TreeNode rr1 = new TreeNode(3);

        root.left = l1;
        l1.left = ll1;
        root.right = r1;
        r1.left = rl1;
        r1.right = rr1;

        List<List<Integer>> res = pathSum(root,20);
        System.out.println(res.size());
        res.forEach(item -> {
            item.forEach(i -> {
                System.out.print(i + " ");
            });
            System.out.println(" ");
        });
    }

}
