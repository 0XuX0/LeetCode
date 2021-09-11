/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2021/6/6
 **/
public class Solution {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        while(tmpA != null && tmpB != null) {
            tmpA = tmpA.next;
            tmpB = tmpB.next;
        }
        if (tmpA == null) {
            tmpA = headB;
            while (tmpB != null) {
                tmpB = tmpB.next;
                tmpA = tmpA.next;
            }
            tmpB = headA;
        }
        if (tmpB == null) {
            tmpB = headA;
            while (tmpA != null) {
                tmpB = tmpB.next;
                tmpA = tmpA.next;
            }
            tmpA = headB;
        }
        while(tmpA != null) {
            tmpA = tmpA.next;
            tmpB = tmpB.next;
            if (tmpA == tmpB) {
                return tmpA;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
