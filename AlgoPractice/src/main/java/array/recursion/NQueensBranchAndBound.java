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

        for (int i = 0; i < boardSize; i++) {
            if (!cols[i] && !fd[row + i] && !rd[row - i + (boardSize - 1)]) {
                cols[i] = true;
                fd[row + i] = true;
                rd[row - i + (boardSize - 1)] = true;
                solve(boardSize, ans + row + "-" + i + " , ", row + 1, cols, fd, rd);
                cols[i] = false;
                fd[row + i] = false;
                rd[row - i + (boardSize - 1)] = false;
            }
        }

    }

}
