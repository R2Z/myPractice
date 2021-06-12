package dp;

import array.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MaxSumIncreasingSubSequence {
    public static void main(String[] args) {
        //int arr2[] = {10, 22, 9, 23};
        int size = 140;
        Random r = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Math.abs(r.nextInt(size));
        }
        Utils.print(arr);
        long t1 = System.currentTimeMillis();
        int sum = maxSumIncreasingSubSequence(arr, -1, 0);
        long t2 = System.currentTimeMillis();
        long diff = (t2 - t1) / 1000;
        System.out.println("Sum " + sum + " time(s) " + diff);


        t1 = System.currentTimeMillis();
        sum = maxSumIncreasingSubSequenceMemo(arr, -1, 0, new HashMap<>());
        t2 = System.currentTimeMillis();
        diff = (t2 - t1) / 1000;
        System.out.println("Memo Sum " + sum + " time(s) " + diff);


    }

    private static int maxSumIncreasingSubSequence(int arr[], int previous, int curr) {

        if (curr == arr.length) {
            return 0;
        }
        int sumIncludingCurr = 0;
        int sumExcludingCurr;
        // find max sum by including or excluding current element from array
        // include current only if its GE than previous
        // return max sum by including or excluding curr element
        if (previous == -1 || arr[curr] > arr[previous]) {
            sumIncludingCurr = arr[curr] + maxSumIncreasingSubSequence(arr, curr, curr + 1);
        }
        sumExcludingCurr = maxSumIncreasingSubSequence(arr, previous, curr + 1);

        return Math.max(sumIncludingCurr, sumExcludingCurr);
    }

    private static int maxSumIncreasingSubSequenceMemo(int arr[], int previous, int curr, Map<String, Integer> map) {

        String key = previous + "|" + curr;

        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (curr == arr.length) {
            return 0;
        }
        int sumIncludingCurr = 0;
        int sumExcludingCurr;
        // find max sum by including or excluding current element from array
        // include current only if its GE than previous
        // return max sum by including or excluding curr element
        if (previous == -1 || arr[curr] > arr[previous]) {
            sumIncludingCurr = arr[curr] + maxSumIncreasingSubSequenceMemo(arr, curr, curr + 1, map);
        }
        sumExcludingCurr = maxSumIncreasingSubSequenceMemo(arr, previous, curr + 1, map);
        map.put(key, Math.max(sumIncludingCurr, sumExcludingCurr));

        return map.get(key);
    }

}
