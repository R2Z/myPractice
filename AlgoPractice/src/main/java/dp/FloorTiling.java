package dp;

public class FloorTiling {

    public static void main(String[] args) {

        int n = 1000;
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        System.out.println(floorTiling(n, dp));

        dp = new long[n + 1];
        System.out.println(floorTiling(n, 100, dp));
    }

    private static long floorTiling(int n, long[] dp) {

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = floorTiling(n - 1, dp) + floorTiling(n - 2, dp);
        return dp[n];
    }

    private static long floorTiling(int n, int m, long[] dp) {

        if (dp[n] != 0) {
            return dp[n];
        }

        if (n < m) {
            return n;
        }
        if (m == n) {
            return 2;
        }

        dp[n] = floorTiling(n - 1, m, dp) + floorTiling(n - m, m, dp);

        return dp[n];
    }

}
