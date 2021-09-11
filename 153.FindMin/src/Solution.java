/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2021/6/15
 **/
public class Solution {

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[right];
    }

    public static int findDuplicatedMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                right -= 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{5,1,2,3,4};
        int[] nums2 = new int[]{2,2,2,0,1,2,2};
        System.out.println(findMin(nums1));
        System.out.println(findDuplicatedMin(nums2));
        System.out.println("Hello World");
    }
}
