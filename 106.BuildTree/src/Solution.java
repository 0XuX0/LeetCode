/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/5/22
 **/
public class Solution {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int rootPos = findRootIndex(inorder, postorder[postorder.length - 1]);
        TreeNode root = new TreeNode();
        root.val = postorder[postorder.length - 1];
        root.right = buildSubTree(postorder, inorder, rootPos + 1, inorder.length - 1, rootPos + 1, inorder.length - 1);
        root.left = buildSubTree(postorder, inorder, 0, rootPos - 1, 1, rootPos);
        return root;
    }


    private static TreeNode buildSubTree(int[] preorder, int[] inorder, int inorderStart, int inorderEnd, int preorderStart, int preorderEnd) {

        if(inorderStart > inorderEnd || preorderStart > preorderEnd) {
            return null;
        }

        TreeNode subRoot = new TreeNode();
        subRoot.val = preorder[preorderStart];
        int subRootPos = findRootIndex(inorder,preorder[preorderStart]);

        subRoot.left = buildSubTree(preorder, inorder, inorderStart, subRootPos - 1, preorderStart + 1, subRootPos - inorderStart + preorderStart);

        subRoot.right = buildSubTree(preorder, inorder, subRootPos + 1, inorderEnd, subRootPos - inorderStart + preorderStart + 1, preorderEnd);

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
}
