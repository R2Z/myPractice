package dp;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticSequence {
    public static void main(String[] args) {
        //ffgg
        int arr[] = {0, 2000000000, -294967296};
        int count = getAPSubSequences(arr);
        System.out.println(count);
    }

    private static int getAPSubSequences(int nums[]) {
        int ans = 0;
        Map<Long, Integer>[] dp = new Map[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = new HashMap<>();
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                Long diff = Long.valueOf(nums[i]) - Long.valueOf(nums[j]);
                int apsj = dp[j].getOrDefault(diff, 0);
                int apsi = dp[i].getOrDefault(diff, 0);
                dp[i].put(diff, apsi + apsj + 1);
                ans += apsj;
            }
        }

        return ans;
    }

    private static int getAP(int[] arr) {
        int dp[] = new int[arr.length];
        int count = 0;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                count += dp[i];
            }
        }
        return count;
    }
}
