/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2021/6/6
 **/
public class Solution {
    public static void reorderList(ListNode head) {
        if (head == null) return;

        ListNode slow = head;
        ListNode fast = head.next;

        // 快慢指针找到左中节点
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = null;
        ListNode reverseCur = slow.next;
        slow.next = null;

        // 反转链表
        while (reverseCur != null) {
            ListNode reverseNxt = reverseCur.next;

            reverseCur.next = head2;
            head2 = reverseCur;
            reverseCur = reverseNxt;
        }

        // merge head && reversePre
        ListNode oldCur = head;
        ListNode newCur = head2;
        while (oldCur != null && newCur != null) {
            ListNode tmpOld = oldCur.next;
            ListNode tmpNew = newCur.next;

            oldCur.next = newCur;
            newCur.next = tmpOld;

            oldCur = tmpOld;
            newCur = tmpNew;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        reorderList(node1);
        System.out.println("Hello World");
    }
}
