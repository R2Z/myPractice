package dp;

import array.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        // input: a set of items, each with a weight and a value
        //int[] v = {20, 5, 10, 40, 15, 25};
        //int[] w = {1, 2, 3, 8, 7, 4};

        int size = 1000;
        int[] v = new int[size];
        int w[] = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            int val = Math.abs(r.nextInt(size));
            int weight = Math.abs(r.nextInt(size));
            if (val == 0) {
                v[i] = 1;
            } else {
                v[i] = val;
            }
            if (weight == 0) {
                w[i] = 1;
            } else {
                w[i] = weight;
            }
        }

        // knapsack capacity
        int W = Arrays.stream(w).max().getAsInt();
        System.out.println("Max Weight " + W);
        Utils.print(w);
        System.out.println("Value");
        Utils.print(v);
        //int profit = knapsack(v, w, w.length - 1, W);
        //System.out.println(profit);
        int profit = knapsackMemo(v, w, w.length - 1, W, new HashMap<>());
        System.out.println(profit);
    }


    public static int knapsackMemo(int[] v, int[] w, int n, int W, Map<String, Integer> map) {

        String key = n + "|" + W;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        // base case: Negative capacity
        if (W < 0) {
            return Integer.MIN_VALUE;
        }

        // base case: no items left or capacity becomes 0
        if (n < 0 || W == 0) {
            return 0;
        }

        // Case 1. Include current item `v[n]` in the knapsack and recur for
        // remaining items `n-1` with decreased capacity `W-w[n]`

        int include = v[n] + knapsackMemo(v, w, n - 1, W - w[n], map);

        // Case 2. Exclude current item `v[n]` from the knapsack and recur for
        // remaining items `n-1`

        int exclude = knapsackMemo(v, w, n - 1, W, map);

        // return maximum value we get by including or excluding the current item
        map.put(key, Integer.max(include, exclude));
        return map.get(key);
    }

    // Values (stored in array `v`)
    // Weights (stored in array `w`)
    // Total number of distinct items `n`
    // Knapsack capacity `W`
    public static int knapsack(int[] v, int[] w, int n, int W) {
        // base case: Negative capacity
        if (W < 0) {
            return Integer.MIN_VALUE;
        }

        // base case: no items left or capacity becomes 0
        if (n < 0 || W == 0) {
            return 0;
        }

        // Case 1. Include current item `v[n]` in the knapsack and recur for
        // remaining items `n-1` with decreased capacity `W-w[n]`

        int include = v[n] + knapsack(v, w, n - 1, W - w[n]);

        // Case 2. Exclude current item `v[n]` from the knapsack and recur for
        // remaining items `n-1`

        int exclude = knapsack(v, w, n - 1, W);

        // return maximum value we get by including or excluding the current item
        return Integer.max(include, exclude);
    }
}
