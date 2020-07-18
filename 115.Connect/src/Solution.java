/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/6/28
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
        if(node.left == null || node.right == null) {
            return;
        }

        compensate(node);

        recursion(node.left);
        recursion(node.right);

        node.left.next = node.right;
    }

    private static void compensate(Node node) {
        Node pre = node.left;
        Node after = node.right;
        while(pre.right != null && after.left != null) {
            pre.next = after;

            pre = pre.right;
            after = after.left;
        }
        pre.next = after;
    }

    public static void main(String[] args) {
        Node root = new Node(-1);
        Node l1 = new Node(0);
        Node r1 = new Node(1);
        Node ll1 = new Node(2);
        Node lr1 = new Node(3);
        Node rl1 = new Node(4);
        Node rr1 = new Node(5);
        Node lll1 = new Node(6);
        Node llr1 = new Node(7);
        Node lrl1 = new Node(8);
        Node lrr1 = new Node(9);
        Node rll1 = new Node(10);
        Node rlr1 = new Node(11);
        Node rrl1 = new Node(12);
        Node rrr1 = new Node(13);

        root.left = l1;
        root.right = r1;
        l1.left = ll1;
        l1.right = lr1;
        r1.left = rl1;
        r1.right = rr1;
        ll1.left = lll1;
        ll1.right = llr1;
        lr1.left = lrl1;
        lr1.right = lrr1;
        rl1.left = rll1;
        rl1.right = rlr1;
        rr1.left = rrl1;
        rr1.right = rrr1;

        connect(root);

        System.out.println(root.next);

    }
}
