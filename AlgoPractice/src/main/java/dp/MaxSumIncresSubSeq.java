package dp;

import java.util.HashMap;
import java.util.Map;

public class MaxSumIncresSubSeq {
    public static void main(String[] args) {
        //int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11};
        //int arr[] = {1, 101, 2, 3, 100, 4, 5};
        int arr[] = {3, 10, 2, 1, 20};
        int pi = 0;
        int maxSum = maxSumIncSubSeq(arr, pi, arr[pi]);
        System.out.println(maxSum);
        maxSum = maxSumIncSubSeq(arr, pi, arr[pi], new HashMap<>());
        System.out.println(maxSum);
    }

    private static int maxSumIncSubSeq(int[] arr, int pi, int ps) {

        if (pi == arr.length - 1) {
            return ps;
        }

        int maxSum = ps;
        for (int i = pi + 1; i < arr.length; i++) {
            if (arr[i] > arr[pi]) {
                int currSum = ps + maxSumIncSubSeq(arr, i, arr[i]);
                maxSum = Integer.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

    private static int maxSumIncSubSeq(int[] arr, int ci, int cs, Map<Integer, Integer> map) {

        if (map.containsKey(ci)) {
            return map.get(ci);
        }

        if (ci == arr.length - 1) {
            return cs;
        }

        int maxSum = cs;
        for (int i = ci + 1; i < arr.length; i++) {
            if (arr[i] > arr[ci]) {
                int currSum = cs + maxSumIncSubSeq(arr, i, arr[i]);
                maxSum = Integer.max(maxSum, currSum);
            }
        }
        map.put(ci, maxSum);
        return maxSum;
    }
}
