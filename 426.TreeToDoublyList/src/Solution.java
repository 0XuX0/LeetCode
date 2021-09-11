import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TODO
 * @Description TODO
 * @Author chenghao.xu
 * @Date 2021/5/18
 */
public class Solution {

    static  Node pre, head;

    public static Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private static void dfs(Node node) {
        if (node == null) return;
        dfs(node.left);
        if(pre != null) {
            pre.right = node;
        }
        else {
            head = node;
        }
        node.left = pre;
        pre = node;
        dfs(node.right);
    }

    public static void main(String[] args) {
        Node node1 = new Node(4);
        Node node2 = new Node(2);
        Node node3 = new Node(5);
        Node node4 = new Node(1);
        Node node5 = new Node(3);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;


//        inOrder(node1, res);
        treeToDoublyList(node1);
        System.out.printf("lll");
    }
}
