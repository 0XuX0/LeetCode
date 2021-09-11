import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2021/6/13
 **/
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) return new ArrayList<>();
        Set<String> set = new HashSet<>();
        Set<String> out = new HashSet<>();
        int len = s.length();

        for (int i = 0; i <= len - 10; i++) {
            String tmp = s.substring(i, i + 10);
            if (set.contains(tmp)) out.add(tmp);
            set.add(tmp);
        }
        return new ArrayList<>(out);
    }
}
