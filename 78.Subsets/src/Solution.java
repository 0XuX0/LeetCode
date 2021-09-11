import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2021/6/11
 **/
public class Solution {

    public static List<List<Integer>> res;
    public static List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        backTrack(nums, 0, new ArrayList<>());
        return res;
    }

    private static void backTrack(int[] nums, int cur, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i= cur; i < nums.length; i++) {
            list.add(nums[i]);
            backTrack(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> res = subsets(nums);
        System.out.println("Hello");
    }
}
