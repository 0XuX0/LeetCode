/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/6/30
 **/
public class Solution {
    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        root.next = null;
        recursion(root);
        return root;
    }

    private static void recursion(Node node) {
        if (node.left == null && node.right == null) {
            return;
        }

        compensate(node);

        if (node.left != null) {
            recursion(node.left);
        }

        if (node.right != null) {
            recursion(node.right);
        }

        if (node.left != null) {
            node.left.next = node.right;
        }
    }

    private static void compensate(Node node) {
        Node pre = node.left;
        Node after = node.right;
        while(pre != null && after != null) {

            if (pre.right != null) {
                pre = pre.right;
            } else if (pre.left != null) {
                pre = pre.left;
            } else {
                break;
            }
            if (after.left != null) {
                after = after.left;
            } else if (after.right != null) {
                after = after.right;
            } else {
                break;
            }

            pre.next = after;
        }
     }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node l = new Node(2);
        Node r = new Node (3);
        Node ll = new Node (4);
        Node lr = new Node (5);
        Node rr = new Node (7);
        Node lll = new Node (8);
        Node rrl = new Node (12);

        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        r.right = rr;
        ll.left = lll;
        rr.left = rrl;

        connect(root);
    }
}
