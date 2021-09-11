/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2021/6/5
 **/
public class Solution {

    public static ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;

        ListNode smallEnd = new ListNode(-1);
        ListNode bigHead = new ListNode(-1);
        boolean findMidPos = false;

        while(cur != null) {

            if (cur.val >= x) {
                if (!findMidPos) {
                    smallEnd = pre;
                    bigHead = cur;
                    findMidPos = true;
                }
                ListNode tmp1 = cur;
                ListNode tmp2 = cur.next;
                while(tmp2 != null && tmp2.val >= x) {
                    tmp1 = tmp1.next;
                    tmp2 = tmp2.next;
                }
                if (tmp2 == null) {
                    break;
                }
                smallEnd.next = tmp2;
                tmp1.next = tmp2.next;
                tmp2.next = bigHead;
                smallEnd = smallEnd.next;

                pre = tmp2;
                cur = tmp1;
            }
            else {
                cur = cur.next;
                pre = pre.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode res = partition(node1, 3);
        while(res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println("Hello");
    }
}
