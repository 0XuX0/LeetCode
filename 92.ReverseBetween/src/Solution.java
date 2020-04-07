/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/4/6
 **/
public class Solution {
    public static ListNode reverseBetween(ListNode head, int m,int n) {
        if (head == null || head.next == null) {
            return head;
        }
        if (m == n) {
            return head;
        }
        ListNode tmpStart = new ListNode(0);
        ListNode tmpStartBefore = new ListNode(0);
        ListNode tmpEnd = new ListNode(0);
        ListNode tmpEndBefore = new ListNode(0);
        ListNode lastNode = new ListNode(0);
        ListNode curNode = head;
        ListNode nextNode = head.next;

        lastNode.next = curNode;
        int curPos = 1;
        while (curNode != null) {
            if (curPos == m) {
                tmpStartBefore = lastNode;
                tmpEndBefore = curNode;

                lastNode.next = tmpStart;
                curNode.next = tmpEnd;
            }

            if (curPos > m && curPos <= n) {
                curNode.next = lastNode;
            }

            if (curPos == n) {
                tmpStart.next = curNode;
                tmpEnd.next = nextNode;

                break;
            }

            lastNode = curNode;
            curNode = nextNode;
            nextNode = nextNode.next;
            curPos ++;
        }
        tmpStartBefore.next = tmpStart.next;
        tmpEndBefore.next = tmpEnd.next;

        if (m == 1) {
            head = tmpStart.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode p = reverseBetween(head, 1,5);
        while(p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}