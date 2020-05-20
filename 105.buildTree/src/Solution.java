
/**
 * ()
 *
 * @author xuchh
 * @date 2020/5/20
 */
public class Solution {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int rootPos = findRootIndex(inorder, preorder[0]);
        TreeNode root = new TreeNode();
        root.val = preorder[0];
        root.left = buildSubTree(preorder, inorder, 0, rootPos - 1, 1, rootPos);
        root.right = buildSubTree(preorder, inorder, rootPos + 1, inorder.length - 1, rootPos + 1, inorder.length - 1);
        return root;
    }

    private static TreeNode buildSubTree(int[] preorder, int[] inorder, int inorderStart, int inorderEnd, int preorderStart, int preorderEnd) {

        if(inorderStart > inorderEnd || preorderStart > preorderEnd) {
            return null;
        }

        TreeNode subRoot = new TreeNode();
        subRoot.val = preorder[preorderStart];
        int subRootPos = findRootIndex(inorder,preorder[preorderStart]);

        subRoot.left = buildSubTree(preorder, inorder, inorderStart, subRootPos - 1, preorderStart + 1, subRootPos - inorderStart - 1 + preorderStart);

        subRoot.right = buildSubTree(preorder, inorder, subRootPos + 1, inorderEnd, inorderEnd - inorderStart - 1 + preorderStart, preorderEnd);

        return subRoot;
    }

    private static int findRootIndex(int[] order, int key) {
        for (int index = 0; index < order.length; index++) {
            if (order[index] == key) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] preorder = {4,2,1,3,8,6,5,7,9,10};
        int[] inorder = {1,2,3,4,5,6,7,8,9,10};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println("end");
    }
}
