package dp;

import java.util.HashMap;
import java.util.Map;

public class RodCutting {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        int profit[] = {1, 5, 8, 9};
        int target = 5;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], profit[i]);
        }
        int max_profit = getMaxProfit(arr, map, target);
        System.out.println(max_profit);
        int max_profit2 = getMaxProfit(arr, map, target, new HashMap<>());
        System.out.println(max_profit2);
    }

    private static int getMaxProfit(int[] arr, Map<Integer, Integer> map, int target) {
        int MAX_PROFIT = Integer.MIN_VALUE;
        if (target == 0) {
            return 0;
        }

        for (int i = 0; i < arr.length; i++) {
            int new_target = target - arr[i];
            if (new_target >= 0) {
                int curProfit = map.get(arr[i]) + getMaxProfit(arr, map, new_target);
                MAX_PROFIT = Integer.max(MAX_PROFIT, curProfit);
            }
        }
        return MAX_PROFIT;
    }


    private static int getMaxProfit(int[] arr, Map<Integer, Integer> map, int target, Map<Integer, Integer> cache) {
        int MAX_PROFIT = Integer.MIN_VALUE;

        if (cache.containsKey(target)) {
            return cache.get(target);
        }

        if (target == 0) {
            return 0;
        }

        for (int i = 0; i < arr.length; i++) {
            int new_target = target - arr[i];
            if (new_target >= 0) {
                int curProfit = map.get(arr[i]) + getMaxProfit(arr, map, new_target);
                MAX_PROFIT = Integer.max(MAX_PROFIT, curProfit);
            }
        }
        cache.put(target, MAX_PROFIT);
        return MAX_PROFIT;
    }

}
