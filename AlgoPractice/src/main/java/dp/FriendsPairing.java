package dp;

import java.util.Arrays;

public class FriendsPairing {

    public static void main(String[] args) {
        int n = 50;
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        System.out.println(findPairCount(n, dp));
    }

    private static long findPairCount(int n, long[] dp) {
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = findPairCount(n - 1, dp) + (n - 1) * findPairCount(n - 2, dp);
        return dp[n];
    }
}
