/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/6/26
 **/
public class Solution {
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSumRecursion(root, sum);
    }

    private static boolean hasPathSumRecursion(TreeNode node, int sum) {
        sum -= node.val;
        if (sum == 0 && node.left == null && node.right == null) {
            return true;
        }
        boolean left = false;
        boolean right = false;
        if (node.left != null) {
            left = hasPathSumRecursion(node.left, sum);
        }
        if (node.right != null) {
            right = hasPathSumRecursion(node.right, sum);
        }
        return left || right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(hasPathSum(root,5));

    }
}
