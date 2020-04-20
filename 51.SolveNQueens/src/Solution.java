import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/4/20
 **/
public class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        boolean[][] nums = new boolean[n][n];
        return res;
    }

    private void backTrack(boolean[][] nums, int curRow) {
        if (curRow == nums.length) {
            //布尔类型转换String
            //printRes
            return;
        }
        for (int curCol = 0; curCol < nums[0].length; curCol++) {
            if (isValid(nums,curRow,curCol)) {
                nums[curRow][curCol] = true;
                backTrack(nums, curRow + 1);
                nums[curRow][curCol] = false;
            }
        }
    }

    private static boolean isValid(boolean[][] nums, int curRow, int curCol) {
        //当前行
        for (int i = 0; i < curCol; i++) {
            if(nums[curRow][i]) {
                return false;
            }
        }
        //当前列
        for (int i = 0; i < curRow; i++) {
            if (nums[i][curCol]) {
                return false;
            }
        }
        if (curRow == 0) {
            return true;
        }
        //左对角线
        int tmpRow = curRow - 1;
        int tmpCol = curCol - 1;
        while (tmpRow >= 0 && tmpCol >= 0) {
            if (nums[tmpRow][tmpCol]) {
                return false;
            }
            tmpRow -= 1;
            tmpCol -= 1;
        }
        //右对角线
        tmpRow = curRow - 1;
        tmpCol = curCol + 1;
        while(tmpRow < nums.length && tmpCol < nums.length) {
            if (nums[tmpRow][tmpCol]) {
                return false;
            }
            tmpRow -= 1;
            tmpCol += 1;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean[][] nums = new boolean[3][3];
        nums[0][0] = true;
        for(int i = 0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++) {
                isValid(nums,i,j);
                System.out.print(nums[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
