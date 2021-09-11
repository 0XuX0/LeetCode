import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2021/6/6
 **/
public class Solution {

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private static List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode curTree = new TreeNode(i);
                    curTree.left = left;
                    curTree.right = right;
                    allTrees.add(curTree);
                }
            }
        }
        return allTrees;
    }



    public static String reverse(String s, int k) {
        if (s == null) return null;
        int len = s.length();
        char[] arr = s.toCharArray();
        int cur = 0;
        int nxt = 2 * k;
        while (cur < len) {
            if (nxt < len) {
                doReverse(arr, cur, nxt);
                cur = nxt;
                nxt += 2 * k;
            }
//            else if (nxt ){
//                doReverse();
//            }
        }
        return arr.toString();
    }

    private static void doReverse(char[] arr, int start, int end) {
        int mid = start + (end - start ) / 2;
        while (start < mid) {
            swap(arr, start, mid);
            start++;
            mid--;
        }
    }

    private static void swap(char[] arr, int start, int end) {
        char tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    public static TreeNode findPreNode(TreeNode root, TreeNode node) {
        if (root == null) return null;
        if (node.val <= root.val) {
            return findPreNode(root.left, node);
        }
        else {
            TreeNode right = findPreNode(root.right, node);
            return right == null ? root : right;
        }
    }

    public static TreeNode findNxtNode(TreeNode root, TreeNode node) {
        if (root == null) return null;
        if (node.val >= root.val) {
            return findNxtNode(root.right, node);
        }
        else {
            TreeNode left = findNxtNode(root.left, node);
            return left == null ? root : left;
        }
    }

    public static void main(String[] args) {
//        List<TreeNode> res = generateTrees(1,3);
//        for (TreeNode node : res) {
//            System.out.print(node.val + " ");
//        }
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);

        node.left = node1;
        node1.right = node3;
        node.right = node2;
        node2.left = node4;

        TreeNode res = findPreNode(node, node4);
        System.out.println(res.val);
    }
}
