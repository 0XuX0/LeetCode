import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.StampedLock;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/4/8
 **/
public class Solution {

    private static List<List<Integer>> res;
    private static boolean[] isVisited;

    public static List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return null;
        }
        isVisited = new boolean[nums.length];
//        backTrack(nums, new ArrayList<>());
        backTrack2(nums,0);
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
            List<Integer> tmpResList = new ArrayList<>();
            for (int num : nums) {
                tmpResList.add(num);
            }
            res.add(tmpResList);
            return;
        }
        for(int index = curPos; index < nums.length; index++) {
            swap(nums, index, curPos);
            backTrack2(nums, curPos + 1);
            swap(nums, index, curPos);

        }
    }

    private static void swap(int[] nums, int startPos, int endPos) {
        int temp = nums[startPos];
        nums[startPos] = nums[endPos];
        nums[endPos] = temp;
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
