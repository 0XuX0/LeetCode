import java.util.*;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/4/5
 **/
public class Solution {
    public static List<List<Integer>> combinationList = new ArrayList<>();
    public static Set<List<Integer>> combinationSet = new HashSet();
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        getCombination(candidates, target, new ArrayList<>(),0);
        combinationSet.forEach(item -> combinationList.addAll(Collections.singleton(item)));
        return combinationList;
    }

    private static void getCombination(int[] candidates, int target, List<Integer> subCombinationList, int curPos) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            combinationSet.add(new ArrayList<>(subCombinationList));
        } else {
            for (int index = curPos; index < candidates.length; index++) {
                subCombinationList.add(candidates[index]);
                getCombination(candidates, target - candidates[index], subCombinationList, index + 1);
                subCombinationList.remove(subCombinationList.size() - 1);
                if (target - candidates[index] <= 0) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = combinationSum2(candidates, target);
        res.forEach(item -> {
            for(int index = 0; index < item.size(); index ++) {
                System.out.print(item.get(index) + " ");
            }
            System.out.println("");
        });
    }
}
