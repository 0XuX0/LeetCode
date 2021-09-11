/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2021/6/16
 **/
public class Solution {

    public static int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int mid_L = mid - 1;
            int mid_R = mid + 1;
            if (mid == 0 || mid == len - 1) break;
            if (nums[mid_L] < nums[mid] && nums[mid_R] < nums[mid]) {
                return mid;
            } else if (nums[mid_L] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left] > nums[right] ? left : right;
    }

    public static int findPeakElement2(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else if (nums[mid] > nums[mid + 1]) {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {

    }
}
