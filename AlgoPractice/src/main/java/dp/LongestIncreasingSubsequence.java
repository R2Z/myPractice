package dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {3, 10, 2, 15, 20, 25, 26};
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int MAX = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int localMax = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    localMax = Integer.max(localMax, dp[j] + 1);
                }
            }
            dp[i] = Integer.max(localMax, dp[i]);
            MAX = Integer.max( dp[i], MAX);
        }
        System.out.println(MAX);
    }
}
