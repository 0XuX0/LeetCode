/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2021/6/4
 **/
public class Solution {

    // 删除递增链表所有重复的节点
    // 1 -> 1 -> 2 -> 3  ==> 2 -> 3
    public static ListNode deleteDuplicates (ListNode head) {
        ListNode newHead = findNextNode(head);
        if (newHead == null)    return null;
        ListNode cur = newHead;
        while (cur.next != null) {
            ListNode tmp = findNextNode(cur.next);
            if (tmp == null) {
                cur.next = null;
                break;
            }
            cur.next = tmp;
            cur = cur.next;
        }
        return newHead;
    }

    private static ListNode findNextNode(ListNode node) {
        if (node == null) return null;
        boolean flag = false;
        while (node.next != null && node.val == node.next.val) {
            node = node.next;
            flag = true;
        }
        if (flag) return findNextNode(node.next);
        else return node;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while(curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                ListNode temp = curr.next;
                while (temp != null && temp.val == curr.val) {
                    temp = temp.next;
                }
                prev.next = temp;
                curr = temp;
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode res = findNextNode(head);

        if (res == null) {
            System.out.println("null");
        } else {
            System.out.println(res.val);
        }

//        ListNode resHead = deleteDuplicates(head);
        ListNode resHead = deleteDuplicates2(head);
        while (resHead != null) {
            System.out.print(resHead.val + " ");
            resHead = resHead.next;
        }

        System.out.println("Hello World");
    }
}
