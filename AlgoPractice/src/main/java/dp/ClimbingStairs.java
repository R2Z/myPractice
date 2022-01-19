package dp;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public static void main(String[] args) {
        int noOFStairs = 30;
        int[] steps = {1, 2, 3, 4, 5};

        long t1 = System.currentTimeMillis();
        int ans = countWays(steps, noOFStairs);
        System.out.println("Time " + (System.currentTimeMillis() - t1) / 100 + " ans " + ans);

        t1 = System.currentTimeMillis();
        ans = countWays(steps, noOFStairs, new HashMap<>());
        System.out.println("Time " + (System.currentTimeMillis() - t1) / 100 + " ans " + ans);

    }

    private static int countWays(int[] steps, int noOFStairs) {

        if (noOFStairs < 0) {
            return 0;
        }

        if (noOFStairs == 0) {
            return 1;
        }
        int st = 0;
        for (int i = 0; i < steps.length; i++) {
            st += countWays(steps, noOFStairs - steps[i]);
        }
        return st;
    }

    private static int countWays(int[] steps, int noOFStairs, Map<Integer, Integer> map) {

        if (map.containsKey(noOFStairs)) {
            return map.get(noOFStairs);
        }
        if (noOFStairs < 0) {
            return 0;
        }

        if (noOFStairs == 0) {
            return 1;
        }
        int st = 0;
        for (int i = 0; i < steps.length; i++) {
            st += countWays(steps, noOFStairs - steps[i], map);
        }

        map.put(noOFStairs, st);

        return st;
    }

}
