package array.recursion;

public class NQueensPermutations {
    public static void main(String[] args) {
        int boxes = 2;
        int noq = 2;
        int[][] chessBoard = new int[boxes][boxes];
        printQueensPermutations(chessBoard, noq, 0);
    }

    private static void printQueensPermutations(int[][] chessBoard, int noq, int cq) {

        if (cq == noq) {
            for (int i = 0; i < chessBoard.length; i++) {
                for (int j = 0; j < chessBoard[0].length; j++) {
                    if (chessBoard[i][j] == 0) {
                        System.out.print("_\t");
                    } else {
                        System.out.print("Q" + chessBoard[i][j] + "\t");
                    }
                }
                System.out.println();
            }
            System.out.println("-------------------");
            return;
        }

        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[0].length; j++) {
                if (chessBoard[i][j] == 0) {
                    chessBoard[i][j] = cq + 1;
                    printQueensPermutations(chessBoard, noq, cq + 1);
                    chessBoard[i][j] = 0;
                }
            }
        }

    }
}
