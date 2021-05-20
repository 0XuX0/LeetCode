import com.sun.source.tree.Tree;

/**
 * @ClassName TODO
 * @Description TODO
 * @Author chenghao.xu
 * @Date 2021/5/17
 */
public class Solution {

    public static boolean isSubTree(TreeNode A, TreeNode B) {
        if (B == null) return false;
        while(A != null) {
            if (A.val == B.val) {
                if (dfs(A, B)) {
                    return true;
                }
            }
            return  isSubTree(A.left, B) || isSubTree(A.right, B);
        }
        return false;
    }

    private static boolean dfs(TreeNode A, TreeNode B) {
        if (B == null && A == null) return true;
        if (A == null || B == null) return false;
        if (A.val == B.val) {
            return dfs(A.left, B.left) && dfs(A.right, B.right);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(4);
        TreeNode r1 = new TreeNode(5);
        TreeNode ll1 = new TreeNode(1);
        TreeNode lr1 = new TreeNode(2);
        TreeNode lrl1 = new TreeNode(0);

        root.left = l1;
        root.right = r1;
        l1.left = ll1;
        l1.right = lr1;
        lr1.left = lrl1;

        TreeNode sub = new TreeNode(4);
        TreeNode subl1 = new TreeNode(1);
        TreeNode subr1 = new TreeNode(2);
        sub.left = subl1;
        sub.right = subr1;

        System.out.println(isSubTree(root, sub));
    }
}
