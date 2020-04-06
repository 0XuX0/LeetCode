import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/4/4
 **/
public class Solution {
    public static List<List<Integer>> combinationList = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        getCombination(candidates, target, new ArrayList<>(),0);
        return combinationList;
    }

    private static void getCombination(int[] candidates, int target, List<Integer> subCombinationList, int curPos) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            combinationList.add(new ArrayList<>(subCombinationList));
        } else {
            for (int index = curPos; index < candidates.length; index++) {
                subCombinationList.add(candidates[index]);
                getCombination(candidates, target - candidates[index], subCombinationList, index);
                subCombinationList.remove(subCombinationList.size() - 1);
                if (target - candidates[index] <= 0) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> res = combinationSum(candidates, target);
        res.forEach(item -> {
            for(int index = 0; index < item.size(); index ++) {
                System.out.print(item.get(index) + " ");
            }
            System.out.println("");
        });
    }
}
