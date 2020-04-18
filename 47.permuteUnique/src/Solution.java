import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/4/18
 **/
public class Solution {

    public static List<List<Integer>> res;
    private static boolean[] isVisited;

    public static List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        isVisited = new boolean[nums.length];
        backTrack(nums, new ArrayList<>());
        return res;
    }

    private static void backTrack(int[] nums, List<Integer> tempList) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for(int index = 0; index < nums.length; index++) {
            if (!isVisited[index]) {

                if (index > 0 && !isVisited[index - 1] && nums[index] == nums[index - 1]) {
                    continue;
                }

                isVisited[index] = true;
                tempList.add(nums[index]);

                backTrack(nums, tempList);

                isVisited[index] = false;
                tempList.remove(tempList.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> res = permuteUnique(nums);
        res.forEach(item -> {
            for(int index = 0; index < item.size(); index ++) {
                System.out.print(item.get(index) + " ");
            }
            System.out.println("");
        });
    }
}
