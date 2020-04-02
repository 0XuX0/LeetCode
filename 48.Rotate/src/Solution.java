/**
 * @ClassName Solution
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/4/02
 **/
public class Solution {
    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i = 0; i < row; i++) {
            for(int j = i; j < col; j++) {
                if (i != j && matrix[i][j] != matrix[j][i]) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col / 2; j++) {
                if (matrix[i][j] != matrix[i][col - j -1]){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][col - j -1];
                    matrix[i][col - j -1] = temp;
                }
            }
        }
    }

    private static void print(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] matrix =
                {
                        {1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}
                };
        print(matrix);
        rotate(matrix);
        System.out.println("#####################");
        print(matrix);
    }
}
