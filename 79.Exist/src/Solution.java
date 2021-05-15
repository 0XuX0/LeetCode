/**
 * @ClassName TODO
 * @Description TODO
 * @Author chenghao.xu
 * @Date 2021/5/15
 */
public class Solution {

    public static boolean[][] used;

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    used[i][j] = true;
                    if (backTrack(i, j, board, word, 1)) {
                        return true;
                    }
                    used[i][j] = false;
                }
            }
        }
        return false;
    }

    public static boolean backTrack(int row, int col, char[][] board, String word, int step) {

        if (step == word.length()) {
            return true;
        }

        // do select in (four direction)
        // up
        if (row > 0 && !used[row - 1][col] && board[row - 1][col] == word.charAt(step)) {
            used[row - 1][col] = true;
            if (backTrack(row - 1, col, board, word, step + 1)) {
                return true;
            }
            used[row - 1][col] = false;
        }
        // left
        if (col > 0 && !used[row][col - 1] && board[row][col - 1] == word.charAt(step)) {
            used[row][col - 1] = true;
            if (backTrack(row, col - 1, board, word, step + 1)) {
                return true;
            }
            used[row][col - 1] = false;
        }
        // right
        if (col < board[0].length - 1 && !used[row][col + 1] && board[row][col + 1] == word.charAt(step)) {
            used[row][col + 1] = true;
            if (backTrack(row, col + 1, board, word, step + 1)) {
                return true;
            }
            used[row][col + 1] = false;
        }
        // down
        if (row < board.length - 1 && !used[row + 1][col] && board[row + 1][col] == word.charAt(step)) {
            used[row + 1][col] = true;
            if (backTrack(row + 1, col, board, word, step + 1)) {
                return true;
            }
            used[row + 1][col] = false;
        }

        return false;
    }

    public static void main(String[] args) {

        char[][] board = new char[3][4];
        board[0][0] = 'A';
        board[0][1] = 'B';
        board[0][2] = 'C';
        board[0][3] = 'E';

        board[1][0] = 'S';
        board[1][1] = 'F';
        board[1][2] = 'E';
        board[1][3] = 'S';

        board[2][0] = 'A';
        board[2][1] = 'D';
        board[2][2] = 'E';
        board[2][3] = 'E';

        System.out.println(exist(board, "ABCESEEEFS"));
    }
}
