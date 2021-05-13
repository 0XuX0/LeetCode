import java.util.LinkedList;

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

    public static boolean isSub1(TreeNode A,TreeNode B) {
        boolean flag = false;
        if (A != null) {
            if (A.val == B.val) {
                flag = isSub2(A, B);
            }
            if (flag) {
                return true;
            } else {
                return isSub1(A.left, B) || isSub1(A.right, B);
            }
        }
        return false;
    }

    private static boolean isSub2(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null) return false;
        if (A.val == B.val) {
            return isSub2(A.left,B.left) && isSub2(A.right,B.right);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(3);
        TreeNode r3 = new TreeNode(4);

        TreeNode target = new TreeNode(3);
        LinkedList list = new LinkedList<>();
        root.left = r1;
        root.right = r2;
        root.left.left = r3;
//        root.right = r1;
//        r1.right = r2;

        System.out.println(isSub1(root,target));
//        System.out.println(isBalanced(root));

    }
}
