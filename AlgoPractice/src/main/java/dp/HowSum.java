package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {
    public static void main(String[] args) {
        List<Integer> result = null;
       /* List<Integer> result = howSum(7, new int[]{3, 4, 7, 5});
        System.out.println(result);
        result = howSum(300, new int[]{7, 14});
        System.out.println(result);*/

        //result = howSumDP(7, new int[]{3, 4, 7, 5}, null);
       // System.out.println(result);
        result = howSumDP(300, new int[]{7, 14}, null);
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

}
