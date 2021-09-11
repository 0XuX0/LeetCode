import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/6/25
 **/
public class Solution {

    public static int mindepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return depthRecursion(root);
    }

    private static int depthRecursion(TreeNode node) {
        int left = 0;
        int right = 0;
        if (node.left != null) {
            left = depthRecursion(node.left);
        }
        if (node.right != null) {
            right = depthRecursion(node.right);
        }

        if (left == 0) {
            return right + 1;
        }
        if (right == 0) {
            return left + 1;
        }

        return left < right ? left + 1 : right + 1;
    }

    // bfs
    private static int method2 (TreeNode node) {
        if (node == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int depth = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size(); //保证本次遍历只遍历本层所有节点
            for (int i = 0; i < sz; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left == null && tmp.right == null) {
                    return depth;
                }
                if(tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            depth++;
        }
        return depth;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);


        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

//        System.out.println(mindepth(root));
        System.out.println(method2(node1));
    }
}
