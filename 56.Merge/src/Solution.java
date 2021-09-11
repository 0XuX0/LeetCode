import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2021/7/31
 **/
public class Solution {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }

    public static void main(String[] args) {.idea/modules.xml.idea/modules.xml
        int[][] test = new int[3][2];
        test[0][0] = 1;
        test[0][1] = 3;
        test[1][0] = 2;
        test[1][1] = 4;
        test[2][0] = 6;
        test[2][1] = 7;
        int[][] res = merge(test);
        System.out.println("res" + res.length);
    }
}
