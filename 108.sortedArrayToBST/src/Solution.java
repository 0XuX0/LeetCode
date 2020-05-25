/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/5/25
 **/
public class Solution {

    static int[] num;

    public static TreeNode sortedArrayToBST(int[] nums) {
        num = nums;
        return convertToTree(0, nums.length - 1);
    }

    private static TreeNode convertToTree(int start, int end) {
        if (start >= end) {
            return null;
        }
        int middlePos = (start + end) / 2;
        TreeNode root = new TreeNode(num[middlePos]);
        root.left = convertToTree(start, middlePos - 1);
        root.right = convertToTree(middlePos + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(sortedArrayToBST(nums));
        System.out.println("");
    }
}
