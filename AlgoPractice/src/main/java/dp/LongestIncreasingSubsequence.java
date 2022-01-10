package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {3, 10, 2, 15, 20, 25, 26};
        //int[] nums = {3, 10, 2, 1, 20};
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
            MAX = Integer.max(dp[i], MAX);
        }
        System.out.println(MAX);
        System.out.println(LIS(nums, 0, 1, -1));
        System.out.println(LIS(nums, 0, 1, -1, new HashMap<>()));
    }

    static int LIS(int[] arr, int curr, int next, int ci) {
        if (curr >= arr.length || next >= arr.length) {
            return 1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = ci + 1; i < arr.length; i++) {
            int currMax;
            if (arr[curr] < arr[next]) {
                currMax = LIS(arr, curr + 1, next + 1, i) + 1;
            } else {
                currMax = LIS(arr, curr + 1, next + 1, i);
            }
            max = Integer.max(max, currMax);
        }
        return max;
    }

    static int LIS(int[] arr, int curr, int next, int ci, Map<String, Integer> map) {

        String key = curr + "" + next;

        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (curr >= arr.length || next >= arr.length) {
            return 1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = ci + 1; i < arr.length; i++) {
            int currMax;
            if (arr[curr] < arr[next]) {
                currMax = LIS(arr, curr + 1, next + 1, i, map) + 1;
            } else {
                currMax = LIS(arr, curr + 1, next + 1, i, map);
            }
            max = Integer.max(max, currMax);
        }
        map.put(key, max);
        return max;
    }

}
