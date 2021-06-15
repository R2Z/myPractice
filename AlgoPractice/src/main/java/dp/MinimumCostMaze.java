package dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MinimumCostMaze {
    public static void main(String[] args) {
        int rowSize = 100;
        int colSize = 100;

        /*int noOfWays = matrixTraversal(rowSize - 1, colSize - 1);
        System.out.println(noOfWays);*/
        int[][] costMatrix = new int[rowSize][colSize];
        int[][] memo = new int[rowSize][colSize];
        Random r = new Random();
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                costMatrix[i][j] = Math.abs(r.nextInt(10));
                memo[i][j] = Integer.MAX_VALUE;
            }
        }

        long t1 = System.currentTimeMillis();
        int cost = minCostMovesMemoArray(costMatrix, rowSize - 1, colSize - 1, memo);
        long t2 = System.currentTimeMillis();
        long diff = (t2 - t1) / 1000;
        System.out.println(" time(s) " + diff + " cost " + cost);

        t1 = System.currentTimeMillis();
        //int cost2 = minCostMovesMemo(costMatrix, rowSize - 1, colSize - 1, new HashMap<>(rowSize * colSize));
        int cost2 = findMinCost(costMatrix);
        t2 = System.currentTimeMillis();
        diff = (t2 - t1) / 1000;
        System.out.println(" time(s) " + diff + " cost2 " + cost2);

    }

    private static int minCostMoves(int[][] costMatrix, int row, int col) {

        if (row == 0 && col == 0) {
            return costMatrix[0][0];
        }

        if (row < 0 || col < 0) {
            return Integer.MAX_VALUE;
        }
        int currCelCost = costMatrix[row][col];
        int rightCost = minCostMoves(costMatrix, row, col - 1);
        int downCost = minCostMoves(costMatrix, row - 1, col);


        return Math.min(rightCost, downCost) + currCelCost;
    }

    private static int minCostMovesMemo(int[][] costMatrix, int row, int col, Map<String, Integer> map) {

        String key = row + "|" + col;

        if (map.containsKey(key)) map.get(key);

        if (row == 0 && col == 0) {
            return costMatrix[0][0];
        }

        if (row < 0 || col < 0) {
            return Integer.MAX_VALUE;
        }
        int currCelCost = costMatrix[row][col];
        int rightCost = minCostMovesMemo(costMatrix, row, col - 1, map);
        int downCost = minCostMovesMemo(costMatrix, row - 1, col, map);

        map.put(key, Math.min(rightCost, downCost) + currCelCost);

        return map.get(key);
    }


    private static int minCostMovesMemoArray(int[][] costMatrix, int row, int col, int[][] memo) {

        if ((row >= 0 && col >= 0) && memo[row][col] != Integer.MAX_VALUE) return memo[row][col];

        if (row == 0 && col == 0) {
            return costMatrix[0][0];
        }

        if (row < 0 || col < 0) {
            return Integer.MAX_VALUE;
        }
        int currCelCost = costMatrix[row][col];
        int rightCost = minCostMovesMemoArray(costMatrix, row, col - 1, memo);
        int downCost = minCostMovesMemoArray(costMatrix, row - 1, col, memo);

        memo[row][col] = Math.min(rightCost, downCost) + currCelCost;

        return memo[row][col];
    }


    public static int findMinCost(int[][] cost) {
        // `M × N` matrix
        int M = cost.length;
        int N = cost[0].length;

        // `T[i][j]` maintains the minimum cost to reach cell `(i, j)`
        // from cell `(0, 0)`
        int[][] T = new int[M][N];

        // fill the matrix in a bottom-up manner
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                T[i][j] = cost[i][j];

                // fill the first row (there is only one way to reach any cell
                // in the first row from its adjacent left cell)
                if (i == 0 && j > 0) {
                    T[0][j] += T[0][j - 1];
                }

                // fill the first column (there is only one way to reach any cell
                // in the first column from its adjacent top cell)
                else if (j == 0 && i > 0) {
                    T[i][0] += T[i - 1][0];
                }

                // fill the rest with the matrix (there are two ways to reach any
                // cell in the rest of the matrix, from its adjacent
                // left cell or adjacent top cell)
                else if (i > 0 && j > 0) {
                    T[i][j] += Integer.min(T[i - 1][j], T[i][j - 1]);
                }
            }
        }

        // last cell of `T[][]` stores the minimum cost to reach destination cell
        // (M-1, N-1) from source cell `(0, 0)`
        return T[M - 1][N - 1];
    }

    private static int matrixTraversal(int rowSize, int colSize) {

        if (rowSize == 0 || colSize == 0) {
            return 1;
        }
        if (rowSize < 0 || colSize < 0) {
            return -1;
        }
        int ways = matrixTraversal(rowSize - 1, colSize) + matrixTraversal(rowSize, colSize - 1);
        return ways;
    }


}
