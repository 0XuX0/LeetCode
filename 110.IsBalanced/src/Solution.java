/**
 * ()
 *
 * @author xuchh
 * @date 2020/6/24
 */
public class Solution {

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return heightRecursion(root) > 0;
    }

    private static int heightRecursion(TreeNode node) {
        int leftHeight = 0;
        int rightHeight = 0;
        if (node.left != null) {
            leftHeight = heightRecursion(node.left);
        }
        if (node.right != null) {
            rightHeight = heightRecursion(node.right);
        }
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        int interval = leftHeight - rightHeight;
        if (interval < -1 || interval > 1) {
            return -1;
        }
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode r1 = new TreeNode();
        TreeNode r2 = new TreeNode();
        root.val = 1;
        r1.val = 2;
        r2.val  = 3;
        root.right = r1;
        r1.right = r2;

        System.out.println(isBalanced(root));

    }
}
