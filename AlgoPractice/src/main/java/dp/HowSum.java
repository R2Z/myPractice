package dp;

import java.util.*;

public class HowSum {
    public static void main(String[] args) {
        List<Integer> result = null;
       /* List<Integer> result = howSum(7, new int[]{3, 4, 7, 5});
        System.out.println(result);
        result = howSum(300, new int[]{7, 14});
        System.out.println(result);*/

        //result = howSumDP(7, new int[]{3, 4, 7, 5}, null);
        // System.out.println(result);
        // result = howSumDP(300, new int[]{7, 14}, null);
        howSumDPTabular(7, new int[]{3, 4, 7, 5});
        System.out.println(result);

    }

    private static List<Integer> howSum(int targetSum, int[] arr) {

        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        for (int val : arr) {
            int diff = targetSum - val;
            List<Integer> result = howSum(diff, arr);
            if (result != null) {
                result.add(val);
                return result;
            }
        }
        return null;
    }

    private static List<Integer> howSumDP(int targetSum, int[] arr, Map<Integer, List<Integer>> map) {

        if (map == null) {
            map = new HashMap<>();
        }
        if (map.containsKey(targetSum)) {
            map.get(targetSum);
        }

        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        for (int val : arr) {
            int diff = targetSum - val;
            List<Integer> result = howSumDP(diff, arr, map);
            if (result != null) {
                result.add(val);
                map.put(targetSum, result);
                return result;
            }
        }
        map.put(targetSum, null);
        return null;
    }

    private static int[] copyAndCreate(int[] arr, int val) {
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[arr.length] = val;
        return newArr;
    }

    /// 2D array row is sum cols are all possible values to generate that sum
    private static int[] howSumDPTabular(int targetSum, int[] arr) {

        int[][] table = new int[targetSum + 1][];
        int[] init = new int[1];
        table[0] = init;

        for (int i = 0; i <= targetSum; i++) {
            if (table[i] != null) {
                for (int val : arr) {
                    if (i + val < table.length) {
                        table[i + val] = copyAndCreate(table[i], val);
                    }
                }
            }
        }
        return table[targetSum];
    }

}
