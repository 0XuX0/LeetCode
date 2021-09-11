import java.util.*;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2021/5/27
 **/
public class Solution {

//    /**
//     * sort & return n numbers
//     * space: logn for sort
//     * time: O(nlogn)
//     */
//    public static int[] getLeastNumbers1(int[] arr, int k) {
//        Arrays.sort(arr);
//        int[] res = new int[k];
//        for (int i = 0; i < k; i++) {
//            res[i] = arr[;
//        }
//        return res;
//    }
//
//    /**
//     * 固定大小为k的大根堆
//     * space: k
//     * time: O(nlogk)
//     */
//    public static int[] getLeastNumbers2(int[] arr, int k) {
//        int[] res = new int[k];
//        if (k == 0) {
//            return res;
//        }
//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        for(int i = 0; i < k; i++) {
//            queue.add(arr[i]);
//        }
//        for (int i = k; i < arr.length; i++) {
//            if (queue.peek() > arr[i]) {
//                queue.poll();
//                queue.add(arr[i]);
//            }
//        }
//        for (int i = 0; i < k; i++) {
//            res[i] = queue.poll();
//        }
//        return res;
//    }
//
//    public static int[] getLeastNumbers3(int[] arr, int k) {
//        select(arr, 0, arr.length - 1, k);
//        int[] res = new int[k];
//        for (int i = 0; i < k; i++) {
//            res[i] = arr[i];
//        }
//        return res;
//    }
//
//    private static void select(int[] nums, int l, int r, int k) {
//        if (l >= r) {
//            return;
//        }
//        int pos = partition(nums, l, r);
//        int num = pos - l + 1;
//        if (k == num) {
//            return;
//        } else if (k < num) {
//            select(nums, l, pos - 1, k);
//        } else {
//            select(nums, pos + 1, r, k - num);
//        }
//    }
//
//    private static int partition(int[] nums, int l, int r) {
//        int pivot = nums[l];
//        while(l < r) {
//            while(l < r && pivot <= nums[r]) {
//                r--;
//            }
//            swap(nums, l, r);
//            while(l < r && pivot >= nums[l]) {
//                l++;
//            }
//            swap(nums,l, r);
//        }
//        return l;
//    }
//
//    private static void swap (int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }


    // 翻转链表 A->B->C ==> C->B->A
    public static ListNode reverse (ListNode head) {
        if (head == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt = head.next;
        while(cur != null) {
            cur.next = pre;

            pre = cur;
            cur = nxt;
            if (nxt.next != null) {
                nxt = nxt.next;
            }
        }
        return pre;
    }



    // 查找目标节点的后继节点
    public static TreeNode findNextNode(TreeNode root, TreeNode target) {
        if(root == null) return null;
        path.push(root);
        return find(root, target);
    }

    public static Stack<TreeNode> path = new Stack<>();
    private static TreeNode find(TreeNode node, TreeNode target) {
        if (node == null) return null;
        TreeNode res;
        if (node.val == target.val) {
            TreeNode grandParent = null;
            for(int i = 0; i < 2; i++) {
                if (!path.isEmpty()) {
                    path.pop();
                }
            }
            if (!path.isEmpty()) {
                grandParent = path.peek();
            }
            return findNext(node, grandParent);
        }
        path.push(node.left);
        res = find(node.left, target);
        if (res == null) {
            path.pop();
            res = find(node.right, target);
        }
        return res;
    }

    private static TreeNode findNext(TreeNode node, TreeNode grandFather) {
        if (node.right == null) {
            if (grandFather == null) {
                return null;
            } else if (grandFather.left != null && grandFather.left.right == node){
                return grandFather;
            } else {
                return null;
            }
        } else {
            node = node.right;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {

//        int[] arr = new int[] {7,3,1,2,9,5};
//        int[] res = getLeastNumbers3(arr, 4);
//        for (int t : res) {
//            System.out.print(t);
//        }

        TreeNode root = new TreeNode(5);
        TreeNode l1 = new TreeNode(3);
        TreeNode r1 = new TreeNode(7);
        TreeNode lr1 = new TreeNode(4);

        root.left = l1;
        root.right = r1;

        l1.right = lr1;

        TreeNode target = new TreeNode(4);

        TreeNode res = findNextNode(root, target);
        System.out.println(res.val);
    }
}
