package dp;

import java.util.HashMap;
import java.util.Map;

public class CoinChangeInfinite {

    public static void main(String[] args) {
        int[] coins = {1, 3, 5, 7, 9, 10, 11};
        int target = 45;
        Map<Integer, Integer> map = new HashMap<>();
        long t1 = System.currentTimeMillis();
        System.out.println(findNumberOfCoins(coins, target));
        long t2 = System.currentTimeMillis();
        System.out.println("Time taken " + (t2 - t1));
        System.out.println(findNumberOfCoins(coins, target, map));
        System.out.println("Time taken " + (System.currentTimeMillis() - t2));
    }


    private static int findNumberOfCoins(int[] coins, int target) {
        int minCount = Integer.MAX_VALUE;
        if (target == 0) {
            return 0;
        } else if (target < 0) {
            return -1;
        }
        for (int i = 0; i < coins.length; i++) {
            int count = findNumberOfCoins(coins, target - coins[i]);
            if (count >= 0)
                minCount = Integer.min(count + 1, minCount);
        }
        return minCount;
    }

    private static int findNumberOfCoins(int[] coins, int target, Map<Integer, Integer> map) {
        int minCount = Integer.MAX_VALUE;

        if (map.containsKey(target)) {
            return map.get(target);
        }

        if (target == 0) {
            return 0;
        } else if (target < 0) {
            return -1;
        }
        for (int i = 0; i < coins.length; i++) {
            int count = findNumberOfCoins(coins, target - coins[i], map);
            if (count >= 0)
                minCount = Integer.min(count + 1, minCount);
        }
        map.put(target, minCount);
        return minCount;
    }

}
