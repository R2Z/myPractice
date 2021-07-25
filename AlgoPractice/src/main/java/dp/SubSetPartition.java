package dp;

import java.util.HashMap;
import java.util.Map;

public class SubSetPartition {

    public static void main(String[] args) {

        int n = 50;
        int k = 2;
        Map<String, Long> map = new HashMap<>();
        System.out.println(subSetPartition(n, k, map));
    }

    private static long subSetPartition(int n, int k, Map<String, Long> map) {

        String key = n + "|" + k;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (n == 0 || k == 0 || n < k) {
            return 0;
        }

        if (n == k) {
            return 1;
        }

        long numWays = k * subSetPartition(n - 1, k, map) + subSetPartition(n - 1, k - 1, map);
        map.put(key, numWays);
        return map.get(key);
    }
}
