/**
 * @ClassName DouleList
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/4/22
 **/
public class DoubleList {
    private Node head;
    private Node tail;
    private int size;

    public DoubleList() {
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.next = head;
        size = 0;
    }

    public void addFirst(Node x) {
        x.next = head.next;
        x.prev = head;
        head.next.prev = x;
        head.next = x;
        size++;
    }

    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    public Node removeLast() {
        if (tail.prev == head) {
            return null;
        }
        Node last = tail.prev;
        remove(last);
        return last;
    }

    public int size() {
        return size;
    }
}
