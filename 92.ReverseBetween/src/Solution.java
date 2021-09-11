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

    public static ListNode reverseBetween1(ListNode head, int m, int n) {
        if (head == null) return null;
        if (m == n) return head;
        int curPos = 1;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        // 旋转的前一个节点
        ListNode tempStart = new ListNode(-1);
        // 旋转后的最后一个节点
        ListNode tempStart2 = new ListNode(-1);

        while(curr != null) {
            if (curPos == m) {
                tempStart.next = prev;
                tempStart2.next = curr;
            } else if (curPos > m && curPos < n) {
                ListNode nxt = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nxt;
                curPos++;
                continue;
            } else if (curPos == n) {
                ListNode nxt = curr.next;
                curr.next = prev;
                tempStart.next.next = curr;
                tempStart2.next.next = nxt;
                break;
            }
            curr = curr.next;
            prev = prev.next;
            curPos++;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(7);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode p = reverseBetween1(head, 1,7);
        while(p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}