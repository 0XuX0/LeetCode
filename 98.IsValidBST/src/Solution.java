/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/5/25
 **/
public class Solution {
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null && root.val < root.left.val) {
            return false;
        }
        if (root.right != null && root.val > root.right.val) {
            return false;
        }
        TreeNode preMaxNode = findPreMaxNode(root);
        TreeNode nextMinNode = findNextMinNode(root);
        if (preMaxNode != null && preMaxNode.val >= root.val) {
            return false;
        }
        if (nextMinNode != null && nextMinNode.val <= root.val) {
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }

    private static TreeNode findNextMinNode(TreeNode root) {
        if (root.right == null) return null;
        TreeNode nextMinNode = root.right;
        while(nextMinNode.left != null) {
            nextMinNode = nextMinNode.left;
        }
        return nextMinNode;
    }

    private static TreeNode findPreMaxNode(TreeNode root) {
        if (root.left == null) return null;
        TreeNode preMaxNode = root.left;
        while(preMaxNode.right != null) {
            preMaxNode = preMaxNode.right;
        }
        return preMaxNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);
        System.out.println(isValidBST(root));
    }
}
