package dp;

import array.Utils;

import java.util.*;

//https://www.youtube.com/watch?v=SHFyIAnjj90
//https://www.youtube.com/watch?v=K9M6g7BiBX4
public class MaxIncreasingSubSequence {
    public static void main(String[] args) {
        int maxSubSequence = 0;
        Random r = new Random();
        int size = 1000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Math.abs(r.nextInt(size));
        }
        //Utils.print(arr);
        System.out.println("Array generated " + arr.length);
        long t1 = System.currentTimeMillis();
        int[][] dp = new int[size][size];
        maxSubSequence = 1;//LISCalcArray(arr, -1, 0, dp);
        long t2 = System.currentTimeMillis();
        long diff = (t2 - t1) / 1000;
        System.out.println("maxSubSequence " + maxSubSequence + " time(s) " + diff);

       /* t1 = System.currentTimeMillis();
        maxSubSequence = LISCalcMemo(arr, -1, 0, new HashMap<>(size));
        t2 = System.currentTimeMillis();
        diff = (t2 - t1) / 1000;
        System.out.println("LISCalcMemo " + maxSubSequence + " time(s) " + diff);
*/
        //int[] arr2 = {0, 3, 1, 6, 2, 2, 7};
        t1 = System.currentTimeMillis();
        maxSubSequence = getLIS(arr);
        t2 = System.currentTimeMillis();
        diff = (t2 - t1) / 1000;
        System.out.println("getLIS " + maxSubSequence + " time(s) " + diff);


    }

    private static int getLIS(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int val : arr) {
            Integer ceil = set.ceiling(val);
            if (ceil != null && ceil != val) {
                set.remove(ceil);
            }
            set.add(val);
        }
        return set.size();
    }

    private static int LISCalc(int[] arr, int previous, int curr) {
        if (curr == arr.length) return 0;
        int nextLis, currLis = 0;
        if (previous == -1 || arr[curr] > arr[previous]) {
            currLis = 1 + LISCalc(arr, curr, curr + 1);
        }
        nextLis = LISCalc(arr, previous, curr + 1);
        return Math.max(currLis, nextLis);
    }

    private static int LISCalcMemo(int[] arr, int previous, int curr, Map<String, Integer> map) {
        String key = previous + "|" + curr;
        if (map.containsKey(key)) return map.get(key);
        if (curr == arr.length) return 0;
        int nextLis, currLis = 0;
        if (previous == -1 || arr[curr] > arr[previous]) {
            currLis = 1 + LISCalc(arr, curr, curr + 1);
        }
        nextLis = LISCalc(arr, previous, curr + 1);
        map.put(key, Math.max(currLis, nextLis));
        return map.get(key);
    }

    private static int LISCalcArray(int[] arr, int previous, int curr, int[][] dp) {

        if (previous != -1 && dp[previous][curr] != 0) return dp[previous][curr];
        if (curr == arr.length) return 0;
        int nextLis, currLis = 0;
        if (previous == -1 || arr[curr] > arr[previous]) {
            currLis = 1 + LISCalc(arr, curr, curr + 1);
        }
        nextLis = LISCalc(arr, previous, curr + 1);
        if (previous != -1)
            dp[previous][curr] = Math.max(currLis, nextLis);
        return Math.max(currLis, nextLis);
    }
}
