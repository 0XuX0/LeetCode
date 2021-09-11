/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2021/6/11
 **/
public class Solution {
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1,-1};
        }
        return new int[]{findLeft(nums,target), findRight(nums,target)};
    }

    private static int findLeft(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        int res = -1;
        while (start <= end) {
            mid = (start + end + 1) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                if (nums[mid] == target) {
                    res = mid;
                }
                end = mid - 1;
            }
        }
        return res;
    }

    private static int findRight(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        int res = -1;
        while (start <= end) {
            mid = (start + end + 1) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                if (nums[mid] == target) {
                    res = mid;
                }
                start = mid + 1;
            }
        }
        return res;
    }
}
