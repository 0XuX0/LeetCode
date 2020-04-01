/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/4/01
 **/
public class Solution {

    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
             return 0;
        }
        int sum = 0;
        int length = height.length;
        int[] left = new int[length];
        int[] right = new int[length];

        left[0] = height[0];
        right[length - 1] = height[length - 1];

        for(int index = 1; index < length - 1; index ++) {
            left[index] = height[index] > left[index - 1] ? height[index] : left[index - 1];
        }
        for(int index = length - 2; index >= 0; index --) {
            right[index] = height[index] > right[index + 1] ? height[index] : right[index + 1];
        }

        for(int index = 0; index < length - 1; index ++) {
            sum += Math.min(left[index], right[index]) - height[index];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int res = trap(height);
        System.out.println(res);
    }
}
