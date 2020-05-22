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
        root.right = buildSubTree(postorder, inorder, rootPos + 1, inorder.length - 1, postorder.length - inorder.length  + rootPos, postorder.length - 2);
        root.left = buildSubTree(postorder, inorder, 0, rootPos - 1, 0, rootPos - 1);
        return root;
    }


    private static TreeNode buildSubTree(int[] postorder, int[] inorder, int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {

        if(inorderStart > inorderEnd || postorderStart > postorderEnd) {
            return null;
        }

        TreeNode subRoot = new TreeNode();
        subRoot.val = postorder[postorderEnd];
        int subRootPos = findRootIndex(inorder,postorder[postorderEnd]);

        subRoot.right = buildSubTree(postorder, inorder, subRootPos + 1, inorderEnd, postorderEnd - inorderEnd  + subRootPos, postorderEnd - 1);

        subRoot.left = buildSubTree(postorder, inorder, inorderStart, subRootPos - 1, postorderStart, postorderEnd - inorderEnd + subRootPos - 1);

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
        int[] postorder = {1,3,2,5,7,6,10,9,8,4};
        int[] inorder = {1,2,3,4,5,6,7,8,9,10};
        TreeNode root = buildTree(inorder, postorder);
        System.out.println("end");
    }
}
