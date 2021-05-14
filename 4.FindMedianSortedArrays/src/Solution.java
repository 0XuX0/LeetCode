/**
 * @ClassName TODO
 * @Description TODO
 * @Author chenghao.xu
 * @Date 2021/5/14
 */
public class Solution {

    /**
     * 寻找两个正序数组的中位数
     *  input: 11 = [1,2], l2 = [3,4]
     *  output: 2.50000
     *  note: 合并数组[1,2,3,4] (2 + 3) / 2 = 2.5
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int tmp1 = 0;
        int tmp2 = 0;
        int half = (m + n) / 2 + 1;
        int[] tmp = new int[half];
        for (int i = 0; i < half; i++) {
            if (tmp1 == m) {
                tmp[i] = nums2[tmp2];
                tmp2++;
                continue;
            }
            if (tmp2 == n) {
                tmp[i] = nums1[tmp1];
                tmp1++;
                continue;
            }
            if (nums1[tmp1] < nums2[tmp2]) {
                tmp[i] = nums1[tmp1];
                tmp1++;
            } else {
                tmp[i] = nums2[tmp2];
                tmp2++;
            }
        }
        if ((m + n) % 2 == 0) {
            return (double)(tmp[half - 1] + tmp[half - 2]) / 2;
        } else {
            return (double) tmp[half - 1];
        }
    }

    /**
     * 时间复杂度要 O(log(m+n))
     * k = (m + n) / 2
     * 每次在两个数组中比较第 k / 2 位置的数值大小，将较小的部分移除
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        return (findKth(nums1, 0, n - 1, nums2, 0 , m-1, left) + findKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    public static int findKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) return findKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return findKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return findKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{1,7};
        int[] n2 = new int[]{2,9,10};
        System.out.println(findMedianSortedArrays1(n1, n2));
        System.out.println(findMedianSortedArrays2(n1, n2));
    }
}
