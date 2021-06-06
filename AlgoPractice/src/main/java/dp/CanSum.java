package dp;

import java.util.HashMap;
import java.util.Map;

public class CanSum {

    public static void main(String[] args) {
        new Thread(() -> {
            long t1 = System.currentTimeMillis();
            boolean result = canSum(7, new int[]{5, 3, 4, 7});
            long t2 = System.currentTimeMillis();
            System.out.println(result + " iter t1 " + (t2 - t1) / 1000);
            result = canSum(300, new int[]{7, 14});
            System.out.println(result + " iter t2 " + (System.currentTimeMillis() - t2) / 1000);
        }).start();

        new Thread(() -> {
            long t1 = System.currentTimeMillis();
            boolean result = canSumDP(7, new int[]{5, 3, 4, 7}, null);
            long t2 = System.currentTimeMillis();
            System.out.println(result + " DP t1 " + (t2 - t1) / 1000);
            result = canSumDP(300, new int[]{7, 14}, null);
            System.out.println(result + " DP t2 " + (System.currentTimeMillis() - t2) / 1000);
        }).start();
    }

    private static boolean canSum(int targetSum, int[] arr) {

        if (targetSum == 0) return true;
        if (targetSum < 0) return false;

        for (int val : arr) {
            int diff = targetSum - val;
            if (canSum(diff, arr))
                return true;
        }
        return false;
    }

    private static boolean canSumDP(int targetSum, int[] arr, Map<Integer, Boolean> memo) {

        if (memo == null) {
            memo = new HashMap<>();
        }

        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;

        for (int val : arr) {
            int diff = targetSum - val;
            if (canSumDP(diff, arr, memo)) {
                memo.put(diff, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }
}
