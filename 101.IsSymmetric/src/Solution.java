/**
 * @ClassName TODO
 * @Description TODO
 * @Author chenghao.xu
 * @Date 2021/5/17
 */
public class Solution {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return doSymmetric(root.left, root.right);
    }

    private static boolean doSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val == right.val) {
            return doSymmetric(left.right, right.left) && doSymmetric(left.left, right.right);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
