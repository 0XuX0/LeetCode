import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2021/6/15
 **/
public class Solution {

    public static int findMiss(int[] arr) {
        if (arr.length == 0) return -1;
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] == mid) {
                // right side
                left = mid + 1;
            }
            else if (arr[mid] == mid + 1) {
                // left side
                right = mid - 1;
            }
        }
        return arr[left] + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,3,4,6,7};
        System.out.println(findMiss(arr));
    }
}
