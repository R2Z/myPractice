package dp;

import java.util.HashMap;
import java.util.Map;

public class AlternativeMaxSum {
    public static void main(String[] args) {
        int[] arr = {6, 5, 10, 10, 100, 5};

        int maxSum = getMaxSum(arr, 0, new HashMap<>());
        System.out.println(maxSum);

        maxSum = getMaxSum2(arr, 0);
        System.out.println(maxSum);

    }

    private static int getMaxSum2(int[] arr, int currEle) {

        if (currEle >= arr.length) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = currEle; i < arr.length; i++) {
            currSum = arr[i] + getMaxSum2(arr, i + 2);
            maxSum = Integer.max(maxSum, currSum);
        }

        return maxSum;

    }

    private static int getMaxSum(int[] arr, int curr) {

        if (curr >= arr.length) {
            return 0;
        }

        int currEx = 0;
        int currIn = 0;

        currIn = arr[curr] + getMaxSum(arr, curr + 2);
        currEx = getMaxSum(arr, curr + 1);

        return Integer.max(currEx, currIn);
    }

    private static int getMaxSum(int[] arr, int curr, Map<Integer, Integer> map) {

        if (map.containsKey(curr)) {
            map.get(curr);
        }

        if (curr >= arr.length) {
            return 0;
        }

        int currEx = 0;
        int currIn = 0;

        currIn = arr[curr] + getMaxSum(arr, curr + 2, map);
        currEx = getMaxSum(arr, curr + 1, map);

        map.put(curr, Integer.max(currEx, currIn));

        return map.get(curr);
    }
}
