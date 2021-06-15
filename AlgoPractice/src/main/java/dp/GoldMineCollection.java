package dp;

import java.util.Random;

public class GoldMineCollection {
    public static void main(String[] args) {
        int rowSize = 5;
        int colSize = 5;

        int[][] mine = new int[rowSize][colSize];
        int[][] memo = new int[rowSize][colSize];
        Random r = new Random();
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                mine[i][j] = Math.abs(r.nextInt(10));
                memo[i][j] = Integer.MIN_VALUE;
            }
        }

        //int mine2[][] = {{0, 3, 7}, {8, 5, 1}, {0, 6, 2}};
        long t1 = System.currentTimeMillis();
        int profit = goldMineCollection(mine, rowSize - 1, colSize - 1);
        long diff = (System.currentTimeMillis() - t1) / 1000;
        System.out.println(profit + " time " + diff);
        t1 = System.currentTimeMillis();
        int profit2 = goldMineCollectionMemo(mine, rowSize - 1, colSize - 1, memo);
        long diff2 = (System.currentTimeMillis() - t1) / 1000;
        System.out.println(profit2 + " time " + diff2);
    }

    private static int goldMineCollection(int[][] mine, int rowSize, int colSize) {

        int totalRows = mine.length - 1;
        int totalCols = mine[0].length - 1;

        if (rowSize < 0 || rowSize > totalRows || colSize < 0 || colSize > totalCols) {
            return Integer.MIN_VALUE;
        }

        if (colSize == 0) {
            return mine[rowSize][colSize];
        }

        int maxProfit = Integer.MIN_VALUE;
        for (int row = rowSize; row >= 0; row--) {
            int currValue = mine[row][colSize];
            int forwardValue = currValue + goldMineCollection(mine, row, colSize - 1);
            int upperDiagonal = currValue + goldMineCollection(mine, row - 1, colSize - 1);
            int lowerDiagonal = currValue + goldMineCollection(mine, row + 1, colSize - 1);
            int currentCellProfit = Math.max(Math.max(forwardValue, upperDiagonal), lowerDiagonal);
            if (currentCellProfit > maxProfit) {
                maxProfit = currentCellProfit;
            }
        }
        return maxProfit;
    }

    private static int goldMineCollectionMemo(int[][] mine, int rowSize, int colSize, int[][] memo) {

        int totalRows = mine.length - 1;
        int totalCols = mine[0].length - 1;

        if (rowSize < 0 || rowSize > totalRows || colSize < 0 || colSize > totalCols) {
            return Integer.MIN_VALUE;
        }

        if (colSize == 0) {
            return mine[rowSize][colSize];
        }

        if (memo[rowSize][colSize] != Integer.MIN_VALUE) {
            return memo[rowSize][colSize];
        }

        int maxProfit = Integer.MIN_VALUE;
        for (int row = rowSize; row >= 0; row--) {
            int currValue = mine[row][colSize];
            int forwardValue = currValue + goldMineCollectionMemo(mine, row, colSize - 1, memo);
            int upperDiagonal = currValue + goldMineCollectionMemo(mine, row - 1, colSize - 1, memo);
            int lowerDiagonal = currValue + goldMineCollectionMemo(mine, row + 1, colSize - 1, memo);
            int currentCellProfit = Math.max(Math.max(forwardValue, upperDiagonal), lowerDiagonal);
            memo[row][colSize] = currentCellProfit;
            if (currentCellProfit > maxProfit) {
                maxProfit = currentCellProfit;
            }
        }
        return maxProfit;
    }

}
