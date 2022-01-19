package dp;

import java.util.Arrays;

public class CollectMaxGold {

    public static void main(String[] args) {
        int[][] mat = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        int maxProfit = Integer.MIN_VALUE;
        int[][] dp = new int[mat.length][mat[0].length];

        for (int x = 0; x < mat.length; x++) {
            Arrays.fill(dp[x], -1);
        }

        for (int x = 0; x < mat.length; x++) {
            maxProfit = Integer.max(maxProfit, getMaxProfit(mat, x, 0, dp));
        }
        System.out.println(maxProfit);
    }

    private static int getMaxProfit(int[][] mat, int x, int y) {

        if (x < 0 || y >= mat[0].length || x >= mat.length || mat[x][y] == 0) {
            return 0;
        }

        int fwd = getMaxProfit(mat, x, y + 1);
        int upDig = getMaxProfit(mat, x - 1, y + 1);
        int dwDig = getMaxProfit(mat, x + 1, y + 1);
        return mat[x][y] + Integer.max(Integer.max(fwd, upDig), dwDig);

    }

    private static int getMaxProfit(int[][] mat, int x, int y, int[][] dp) {

        if (x < 0 || y >= mat[0].length || x >= mat.length || mat[x][y] == 0) {
            return 0;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        int fwd = getMaxProfit(mat, x, y + 1, dp);
        int upDig = getMaxProfit(mat, x - 1, y + 1, dp);
        int dwDig = getMaxProfit(mat, x + 1, y + 1, dp);

        dp[x][y] = mat[x][y] + Integer.max(Integer.max(fwd, upDig), dwDig);
        return dp[x][y];

    }

}
