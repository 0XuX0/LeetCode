import java.util.*;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2021/7/5
 **/
public class Solution {

    // ---------------- Part 1 --------------------

    private static String combine(List<List<String>> list, int step, int maxLen) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        int cur = 0;
        while(cur <= maxLen) {
            for(int i = 0; i < list.size(); i++) {
                res.addAll(getOne(list.get(i), cur, cur + step));
            }
            cur += step;
        }
        res.remove(res.size() - 1);
        for (int i = 0; i < res.size(); i++) {
            sb.append(res.get(i));
        }
        return sb.toString();
    }

    private static List<String> getOne(List<String> list, int start, int end) {
        List<String> res = new ArrayList<>();
        if (start >= end || start >= list.size()) return res;
        for (int i = start; i < end; i++) {
            if (i == list.size()) break;
            res.add(list.get(i));
            res.add(",");
        }
        return res;
    }

    // ---------------- Part 2 --------------------

    private static String convert(String s, int k) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split("-");
        sb.append(arr[0]);
        String temp = "";
        for (int i = 1; i < arr.length; i++) {
            temp = temp + arr[i];
        }
        sb.append("-");
        sb.append(convertOne(temp, k));
        return sb.toString();
    }

    private static String convertOne(String str, int k) {
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        char[] arr = str.toCharArray();
        int small = 0;
        int big = 0;
        int step = 0;
        String temp = "";
        for (int i = 0; i < len; i++) {
            step++;
            temp = temp + arr[i];
            if (arr[i] >= 'a' && arr[i] <= 'z') small++;
            if (arr[i] >= 'A' && arr[i] <= 'Z') big++;

            if (step == k || i == len - 1) {
                if (big > small) {
                    temp = temp.toUpperCase();
                }
                else if (big < small) {
                    temp = temp.toLowerCase();
                }
                sb.append(temp);
                sb.append('-');

                temp = "";
                small = 0;
                big =  0;
                step = 0;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // ---------------- Part 3 --------------------
    private static int broadcast(int[][] dp) {
        int m = dp.length;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = i; j < m; j++) {
                if (j - i < 2) continue;
                if (dp[i][j - 1] == 1 && dp[i + 1][j] == 1) {
                    dp[i][j] = 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            if(dp[0][i] == 0) res++;
        }
        return res + 1;
    }



    private static int findKMissed(int[] arr, int k) {
        int len = arr.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(arr[i]);
        }

        int cnt = 0;
        int res = -1;
        int tmp = 0;
        while (cnt < k) {
            tmp++;
            while (set.contains(tmp)) {
                tmp++;
            }
            res = tmp;
            cnt++;
        }
        return res;
    }


    private static boolean[][] visited;
    private static boolean isFind;
    private static boolean findWord(char[][] words, String target) {
        char[] arr = target.toCharArray();
        int len = arr.length;
        visited = new boolean[len][len];
        isFind = false;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (words[i][j] == arr[0]) {
                    dfs(words, arr, 0, i, j);
                }
                if (isFind) return true;
            }
        }
        return isFind;
    }

    private static void dfs(char[][] words, char[] target, int cur, int row, int col) {
        if (target.length - 1 == cur) {
            isFind = true;
            return;
        }

        int len = words[0].length;
        // left
        if (col > 0 && !visited[row][col - 1] && words[row][col - 1] == target[cur]) {
            visited[row][col - 1] = true;
            dfs(words, target, ++cur, row, col - 1);
            visited[row][col - 1] = false;
        }
        // right
        else if (col < len - 1 && !visited[row][col + 1] && words[row][col + 1] == target[cur]) {
            visited[row][col + 1] = true;
            dfs(words, target, ++cur, row, col + 1);
            visited[row][col + 1] = false;
        }
        // up
        else if (row > 0 && !visited[row - 1][col] && words[row - 1][col] == target[cur]) {
            visited[row - 1][col] = true;
            dfs(words, target, ++cur, row - 1, col);
            visited[row - 1][col] = false;
        }
        // down
        else if (row < len - 1 && !visited[row + 1][col] && words[row + 1][col] == target[cur]) {
            visited[row + 1][col] = true;
            dfs(words, target, ++cur, row + 1, col);
            visited[row + 1][col] = false;
        }
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while(in.hasNextLine()) {
//            int step = Integer.parseInt(in.nextLine());
//            int row = Integer.parseInt(in.nextLine());
//            int maxLen = 0;
//            List<List<String>> nums = new ArrayList<>();
//            for(int i = 0; i < row; i++) {
//                String s = in.nextLine();
//                String[] arr = s.split(",");
//                List<String> list = Arrays.asList(arr);
//                if(list.size() > maxLen) maxLen = list.size();
//                nums.add(list);
//            }
//            System.out.println(combine(nums, step, maxLen));
//        }
//        int k = Integer.parseInt(in.nextLine());
//        String s = in.nextLine();
//        System.out.println(convert(s,k));
//        List<String> list = new ArrayList<>();
//        String temp = in.nextLine();
//        String[] tmp = temp.split(" ");
//        list.add(temp);
//        int row = tmp.length;
//        for (int i = 0; i < row - 1; i++) {
//            list.add(in.nextLine());
//        }
//        int n = list.size();
//        int dp[][] = new int[n][n];
//        for(int i = 0; i < n; i++) {
//            String[] str = list.get(i).split(" ");
//            for(int j = 0; j < n; j++) {
//                dp[i][j] = Integer.parseInt(str[j]);
//            }
//        }
//        System.out.println(broadcast(dp));


        int[] arr = new int[]{4,2,5};
        System.out.println(findKMissed(arr, 1));
    }
}
