package array.recursion;

public class NQueenProblem {
    public static void main(String[] args) {
        int n = 6;
        boolean board[][] = new boolean[n][n];
        boolean cols[] = new boolean[n];
        boolean fDiag[] = new boolean[2 * n - 1];
        boolean rDiag[] = new boolean[2 * n - 1];
        solveNQueen(board, 0, cols, fDiag, rDiag, "");
    }

    private static void solveNQueen(boolean[][] board, int row, boolean[] cols, boolean[] fDiag, boolean[] rDiag, String ans) {
        if (row == board.length) {
            System.out.println(ans);
            return;
        }
        for (int col = 0; col < board[0].length; col++) {
            // check if queen can be placed in col , fdiag , rDiag
            if (!cols[col] && !fDiag[row + col] && !rDiag[row - col + board.length - 1]) {
                board[row][col] = true;
                cols[col] = true;
                fDiag[row + col] = true;
                rDiag[row - col + board.length - 1] = true;
                solveNQueen(board, row + 1, cols, fDiag, rDiag, ans + row + "-" + col + ",");
                board[row][col] = false;
                cols[col] = false;
                fDiag[row + col] = false;
                rDiag[row - col + board.length - 1] = false;
            }
        }
    }
}
