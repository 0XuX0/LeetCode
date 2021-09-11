import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2021/6/11
 **/
public class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        backTrack(n,k,1,new ArrayList<>());
        return res;
    }

    private void backTrack(int n, int k, int cur, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = cur; i <= n; i++) {
            list.add(i);
            backTrack(n, k, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
