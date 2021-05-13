import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName TODO
 * @Description TODO
 * @Author chenghao.xu
 * @Date 2021/5/13
 */
public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int max = 0;
        int left = 0, right = 0;
        int len = s.length();
        while(right < len) {
            Character c = s.charAt(right);
            right++;

            // 窗口右边界右移
            window.put(c, window.getOrDefault(c,0) + 1);

            while (window.containsValue(2)) {
              Character d = s.charAt(left);
              left++;
              window.put(d, window.get(d) - 1);
            }
            max = Math.max(max, right - left);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "pwwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
