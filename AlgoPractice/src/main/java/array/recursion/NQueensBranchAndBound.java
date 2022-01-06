package array.recursion;

public class NQueensBranchAndBound {
    public static void main(String[] args) {
        int board = 5;
        boolean[] cols = new boolean[board];
        boolean[] fd = new boolean[2 * board - 1];
        boolean[] rd = new boolean[2 * board - 1];
        solve(board, "", 0, cols, fd, rd);
    }

    static void solve(int boardSize, String ans, int row, boolean[] cols, boolean[] fd, boolean[] rd) {
        if (row == boardSize) {
            System.out.println(ans);
            return;
        }
        for (int col = 0; col < boardSize; col++) {
            if (!cols[col] && !fd[row + col] && !rd[row - col + (boardSize - 1)]) {
                cols[col] = true;
                fd[row + col] = true;
                rd[row - col + (boardSize - 1)] = true;
                solve(boardSize, ans + row + "-" + col + " , ", row + 1, cols, fd, rd);
                cols[col] = false;
                fd[row + col] = false;
                rd[row - col + (boardSize - 1)] = false;
            }
        }
    }
}
