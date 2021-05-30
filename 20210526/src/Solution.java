import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2021/5/26
 **/
public class Solution {

    public static List<String> res;

    public static String[] permutation(String s) {
        res = new ArrayList<>();
        dfs(s.toCharArray(), new boolean[s.length()], new ArrayList<>());
        return res.toArray(new String[0]);
    }

    private static void dfs(char[] c, boolean[] visited, List<Character> list) {
        if (list.size() == c.length) {
            res.add(toString(list));
            return;
        }
        for (int i = 0; i < c.length; i++) {
            if(visited[i]) {
                continue;
            }
            list.add(c[i]);
            visited[i] = true;
            dfs(c, visited, list);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }


    private static String toString(List<Character> list) {
        StringBuilder sb = new StringBuilder();
        for(Character c : list) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abb";
        String[] res = permutation(s);
        for (String ss : res) {
            System.out.println(ss);
        }
        System.out.println("Hello World");
    }
}
