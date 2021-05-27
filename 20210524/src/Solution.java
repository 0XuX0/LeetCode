import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2021/5/24
 **/
public class Solution {

    public static ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode dummy = new TreeNode(-1);
        queue.add(root);
        queue.add(dummy);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.equals(dummy) && !temp.isEmpty()) {
                res.add(temp);
                temp = new ArrayList<>();
                queue.add(dummy);
                continue;
            }
            temp.add(new Integer(node.val));
            if (node.left!= null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

        }
        return res;
    }


    public static int method2(int[] A, int target) {
        int len = A.length;
        int left = 0;
        int right = len - 1;
        if (len == 1) {
            return A[0] == target ? 0 : -1;
        }
        while(left < right) {
            int mid = (left + right) / 2;
            if (A[mid] == target) return mid;
//            if (A[left] == target) return left;
//            if (A[right] == target) return right;
            if (A[right] < A[mid]) {
                left = mid + 1;
            } else if (A[right] > A[mid]) {
                right = mid;
            } else {
                right --;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        TreeNode node1 = new TreeNode(9);
//        TreeNode node2 = new TreeNode(20);
//        root.left = node1;
//        root.right = node2;
//        ArrayList<ArrayList<Integer>> res = levelOrder(root);
//        System.out.println("Hello World");
        int[] A = new int[]{1,3};
        System.out.println(method2(A, 3));
    }
}