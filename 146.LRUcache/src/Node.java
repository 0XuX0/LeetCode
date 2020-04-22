/**
 * @ClassName Node
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/4/22
 **/
public class Node {
    int key;
    int val;
    public Node next;
    public Node prev;

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}
