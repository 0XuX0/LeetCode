/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/6/28
 **/
public class Solution {
    public static void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                // find the left max node
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);

        root.left = l1;
        root.right = r1;

        flatten(root);

        while(root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
    }
}
