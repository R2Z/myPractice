package array.recursion;

public class NQueensPermutations {
    public static void main(String[] args) {
        int boxes = 3;
        int noq = 2;
        int[][] chessBoard = new int[boxes][boxes];
        //printQueensPermutations(chessBoard, noq, 0);
        printQueensCombination(chessBoard, noq, 0, 0, -1);
    }

    static void printNQueensWithNoKill(int arr[][], int tQ, int cQ) {

        if (cQ == tQ) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] == 0) {
                        System.out.print("_\t");
                    } else {
                        System.out.print("Q" + arr[i][j] + "\t");
                    }
                }
                System.out.println();
            }
            System.out.println("-------------------");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0 && isValid(arr, i, j)) {
                    arr[i][j] = cQ + 1;
                    printNQueensWithNoKill(arr, tQ, cQ + 1);
                    arr[i][j] = 0;
                }
            }
        }

    }

    private static boolean isValid(int[][] arr, int i, int j) {
        int rows = arr.length - 1;
        int cols = arr[0].length - 1;

        boolean bool = false;

        // left = j -1 >= 0 && arr[i][j-1] != 1
        // right = j  + 1 <= cols && arr[i][j+1] != 1
        // up = i -1 >= 0 && arr[i-1][j] != 1
        // down = i +1 <= rows && ar[i+1][j] != 1
        // leftUpDiagonal = i - 1 >= 0 && j - 1 >= 0 &&  arr[i-1][j-1] !=1
        // leftDownDiagonal = i+1 >=0 && j + 1 <= cols && arr[i+1][j-1] != 1
        // rightUpDia = i+1 <=


        if (true) {
            bool = true;
        }

        return bool;
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

    private static void printQueensCombination(int[][] chessBoard, int noq, int cq, int pRow, int pCol) {

        if (cq == noq) {
            for (int i = 0; i < chessBoard.length; i++) {
                for (int j = 0; j < chessBoard[0].length; j++) {
                    if (chessBoard[i][j] == 0) {
                        System.out.print("_\t");
                    } else {
                        System.out.print("Q\t");
                    }
                }
                System.out.println();
            }
            System.out.println("-------------------");
            return;
        }

        for (int col = pCol + 1; col < chessBoard.length; col++) {
            if (chessBoard[pRow][col] == 0) {
                chessBoard[pRow][col] = 1;
                printQueensCombination(chessBoard, noq, cq + 1, pRow, col);
                chessBoard[pRow][col] = 0;
            }
        }

        for (int i = pRow + 1; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[0].length; j++) {
                if (chessBoard[i][j] == 0) {
                    chessBoard[i][j] = 1;
                    printQueensCombination(chessBoard, noq, cq + 1, i, j);
                    chessBoard[i][j] = 0;
                }
            }
        }

    }
}
