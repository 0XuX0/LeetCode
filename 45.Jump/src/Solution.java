/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/3/31
 **/
public class Solution {
    public static int jump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int cnt = 0;
        int length = nums.length - 1;
        int curPos = 0;
        int curMove = 0;
        int nextMaxPos = 0;
        while(curPos < length && nums[curPos] > 0) {
            for(int i = 0; i <= nums[curPos]; i++) {
                if(curPos + i >= length) {
                    return cnt + 1;
                }
                if((nums[curPos + i] + curPos + i) > nextMaxPos) {
                    nextMaxPos = nums[curPos + i] + curPos + i;
                    curMove = i;
                }
            }
            curPos += curMove;
            cnt ++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
        int[] nums = {2,3,1,1,4};
        int res = jump(nums);
        System.out.println(res);
    }
}
