/**
 * @ClassName TODO
 * @Description TODO
 * @Author chenghao.xu
 * @Date 2021/5/14
 */
public class Solution {

    /**
     * 链表两数相加
     *  input: l1 = [2,4,3], l2 = [5,6,4]
     *  output: [7,0,8]
     *  note: 342 + 465 = 807
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head;
        ListNode tmp = new ListNode(-1);
        head = tmp;
        int carry = 0;
        while(l1 != null || l2 != null) {
            if (l1 == null) l1 = new ListNode(0);
            if (l2 == null) l2 = new ListNode(0);
            tmp.next = new ListNode((l1.val + l2.val + carry) % 10);
            carry = (l1.val + l2.val + carry) / 10;
            l1 = l1.next;
            l2 = l2.next;
            tmp = tmp.next;
        }
        if (carry != 0) {
            tmp.next = new ListNode(carry);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;

        ListNode res = addTwoNumbers(node1, node4);
        System.out.println("end");
    }
}
