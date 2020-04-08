import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/4/8
 **/
public class Solution {

    private static List<List<Integer>> res = new ArrayList<>();
    private static boolean[] isVisited;

    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        isVisited = new boolean[nums.length];
        backTrack(nums, new ArrayList<>());
        return  res;
    }

    private static void backTrack(int[] nums, List<Integer> tempList) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for(int index = 0; index < nums.length; index++) {
            if (!isVisited[index]) {
                isVisited[index] = true;
                tempList.add(nums[index]);

                backTrack(nums, tempList);

                isVisited[index] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private static void backTrack2(int[] nums, int curPos) {
        if (curPos == nums.length - 1) {
            // res add new arrayList nums
            return;
        }
        for(int index = curPos; index < nums.length; index++) {
            // swap(nums index curPos)
            // backTrack2(nums,curPos + 1)
            // swap(nums index curPos)
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = permute(nums);
        res.forEach(item -> {
            for(int index = 0; index < item.size(); index ++) {
                System.out.print(item.get(index) + " ");
            }
            System.out.println("");
        });
    }
}
