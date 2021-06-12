package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BestSum {
    public static void main(String[] args) {
        //int[] arr = bestSum(7, new int[]{3, 4, 7, 5});
        //int[] arr = bestSum(8, new int[]{2, 3, 5});
        /*int[] arr = bestSumDP(100, new int[]{1, 2, 5, 25}, null);
        //int[] arr = bestSumDP(8, new int[]{1, 4, 5}, null);
        if (arr != null) {
            for (int val : arr)
                System.out.print(val + " ");
        }
        System.out.println("DP");*/
        int[] arr = bestSumTable(100, new int[]{1, 2, 5, 25});
        if (arr != null) {
            for (int val : arr)
                System.out.print(val + " ");
        }
    }

    private static int[] copyAndCreate(int[] arr, int val) {
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[arr.length] = val;
        return newArr;
    }

    private static int[] bestSumTable(int targetSum, int[] arr) {
        int[][] table = new int[targetSum + 1][];
        int[] init = new int[1];
        table[0] = init;

        for (int i = 0; i <= targetSum; i++) {
            if (table[i] != null) {
                for (int val : arr) {
                    if (i + val <= targetSum) {
                        int[] currSum = copyAndCreate(table[i], val);
                        if (table[i + val] == null || table[i + val].length > currSum.length) {
                            table[i + val] = currSum;
                        }
                    }
                }
            }
        }
        return table[targetSum];
    }

    private static int[] bestSum(int targetSum, int[] arr) {

        if (targetSum == 0) return new int[0];
        if (targetSum < 0) return null;

        int[] shortestSum = null;

        for (int val : arr) {
            int diff = targetSum - val;
            int[] currResult = bestSum(diff, arr);
            if (currResult != null) {
                int[] currMin = Arrays.copyOf(currResult, currResult.length + 1);
                currMin[currResult.length] = val;
                if (shortestSum == null || currMin.length < shortestSum.length) {
                    shortestSum = currMin;
                }
            }
        }
        return shortestSum;
    }

    private static int[] bestSumDP(int targetSum, int[] arr, Map<Integer, int[]> map) {

        if (map == null) {
            map = new HashMap<>();
        }

        if (map.containsKey(targetSum)) {
            return map.get(targetSum);
        }

        if (targetSum == 0) return new int[0];
        if (targetSum < 0) return null;

        int[] shortestSum = null;

        for (int val : arr) {
            int diff = targetSum - val;
            int[] currResult = bestSumDP(diff, arr, map);
            if (currResult != null) {
                int[] currMin = Arrays.copyOf(currResult, currResult.length + 1);
                currMin[currResult.length] = val;
                if (shortestSum == null || currMin.length < shortestSum.length) {
                    shortestSum = currMin;
                    map.put(targetSum, shortestSum);
                }
            }
        }
        map.put(targetSum, shortestSum);
        return shortestSum;
    }
}
