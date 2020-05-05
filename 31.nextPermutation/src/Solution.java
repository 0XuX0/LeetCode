/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/5/4
 **/
public class Solution {
    public static void nextPermutation(int[] nums) {
        int length = nums.length;
        int index = length - 1;
        for (index -= 1; index >= 0; index--) {
            if (nums[index] < nums[index + 1]) {
                break;
            }
        }

        if (index == -1) {
            reOrderTail(nums, 0);
            return;
        }

        int nextBiggerPos = findSmallestBigOne(nums, index);
        swap(nums, index, nextBiggerPos);
        reOrderTail(nums, index + 1);
    }

    private static int findSmallestBigOne(int[] nums, int start) {
        for (int index = nums.length - 1; index >= start; index--) {
            if (nums[index] > nums[start]) {
                return index;
            }
        }
        return  start;
    }

    private static void reOrderTail(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start += 1;
            end -= 1;
        }
    }

    private static void swap(int[] nums, int start, int end) {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,0,2,3,2,0};
        nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
