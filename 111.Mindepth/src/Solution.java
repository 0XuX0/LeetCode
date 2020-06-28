/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/6/25
 **/
public class Solution {

    public static int mindepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return depthRecursion(root);
    }

    private static int depthRecursion(TreeNode node) {
        int left = 0;
        int right = 0;
        if (node.left != null) {
            left = depthRecursion(node.left);
        }
        if (node.right != null) {
            right = depthRecursion(node.right);
        }

        if (left == 0) {
            return right + 1;
        }
        if (right == 0) {
            return left + 1;
        }

        return left < right ? left + 1 : right + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        TreeNode l1 = new TreeNode();
        l1.val = 2;
        TreeNode l2 = new TreeNode();
        l2.val = 3;
        TreeNode r1 = new TreeNode();
        r1.val = 4;

        root.left = l1;
        l1.left = l2;
        root.right = r1;

        System.out.println(mindepth(root));
    }
}
