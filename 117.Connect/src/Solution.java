import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/6/30
 **/
public class Solution {
    public static Node connect(Node root) {
        Node dummy = new Node(0); // 每一层的头结点
        dummy.next = root;
        while(dummy.next!=null){
            Node cur = dummy.next;
            Node pre = dummy;
            dummy.next = null;
            while(cur!=null){
                if(cur.left!=null){
                    pre.next = cur.left;
                    pre = cur.left;
                }
                if(cur.right!=null){
                    pre.next = cur.right;
                    pre = cur.right;
                }
                cur = cur.next;
            }
        }
        return root;
    }

    private static Node connect2(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                Node tmp = queue.poll();
                if(i < sz - 1) {
                    tmp.next = queue.peek();
                }
                if(tmp.left != null) queue.add(tmp.left);
                if(tmp.right != null) queue.add(tmp.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        Node l = new Node(1);
        Node r = new Node (3);
        Node ll = new Node (0);
        Node lr = new Node (7);
        Node rl = new Node (9);
        Node rr = new Node (1);
        Node lll = new Node (2);
        Node rrl = new Node (8);
        Node rrr = new Node (8);
        Node lrl = new Node(1);
        Node lrr = new Node(0);
        Node lrrl = new Node(7);

        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        r.right = rr;
        r.left = rl;
        ll.left = lll;
        rr.left = rrl;
        rr.right = rrr;
        lr.left = lrl;
        lr.right = lrr;
        lrr.left = lrrl;

        connect(root);
        System.out.println("Hello");
    }
}
