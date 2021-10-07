package test;

public class LongestPlusSign {
    public static void main(String[] args) {
        int boardSize = 2;
        int[][] mines = {{0, 0}, {0, 1}, {1, 0}};
        int board[][] = createBoard(boardSize, mines);
        System.out.println(largestPlus(board));
    }

    private static int largestPlus(int board[][]) {
        int maxCount = 0;
        int length = board[0].length;
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < length; j++) {
                int left = getMaxCells(board, i - 1, j, 0);
                int right = getMaxCells(board, i + 1, j, 1);
                int up = getMaxCells(board, i, j + 1, 2);
                int down = getMaxCells(board, i, j - 1, 3);
                maxCount = Integer.max(maxCount, Integer.min(Integer.min(Integer.min(left, right), up), down));
            }
        }
        return maxCount;
    }

    private static int getMaxCells(int board[][], int x, int y, int dir) {

        int left = 0;
        int right = 1;
        int up = 2;
        int down = 3;
        int length = board[0].length;
        int mxCells = 0;
        if (dir == left) {
            for (int i = x; i >= 0; i--) {
                if (board[i][y] != 0) {
                    mxCells++;
                }
            }
        } else if (dir == right) {
            for (int i = x; i < length; i++) {
                if (board[i][y] != 0) {
                    mxCells++;
                }
            }
        } else if (dir == up) {
            for (int i = y; i >= 0; i--) {
                if (board[x][i] != 0) {
                    mxCells++;
                }
            }
        } else {
            for (int i = 0; i < length; i++) {
                if (board[x][i] != 0) {
                    mxCells++;
                }
            }
        }
        return mxCells;
    }

    private static int[][] createBoard(int boardSize, int[][] mines) {
        int board[][] = new int[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = 1;
            }
        }
        for (int i = 0; i < mines.length; i++) {
            int[] mine = mines[i];
            board[mine[0]][mine[1]] = 0;
        }
        return board;
    }
}
