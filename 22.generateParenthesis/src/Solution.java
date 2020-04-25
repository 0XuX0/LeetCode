
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/4/23
 **/
public class Solution {
    public static final String[] choice = {"(", ")"};
    public static List<String> res = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        backTrack(n, n, new ArrayList<>());
        return res;
    }

    private static void backTrack(int left, int right, List<String> tmpList) {
        if (left > right) {
            return;
        }
        if (left < 0) {
            return;
        }
        if (left == 0 && right == 0) {
            StringBuilder sb = new StringBuilder();
            for (String s : tmpList) {
                sb.append(s);
            }
            res.add(sb.toString());
            return;
        }
        for (int index = 0; index < choice.length; index++) {
            if (index == 0) {
                tmpList.add(choice[index]);
                backTrack(left - 1, right, tmpList);
                tmpList.remove(tmpList.size() - 1);
            } else {
                tmpList.add(choice[index]);
                backTrack(left, right - 1, tmpList);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> res = generateParenthesis(n);
        res.forEach(System.out::println);
    }
}
