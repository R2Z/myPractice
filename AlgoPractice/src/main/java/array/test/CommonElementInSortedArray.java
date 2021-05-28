package array.test;

import java.util.HashMap;
import java.util.Map;

public class CommonElementInSortedArray {
    public static void main(String[] args) {
        int ar1[] = {1, 5, 10, 20, 40, 80};
        int ar2[] = {6, 7, 20, 80, 100};
        int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120};
        findCommon(ar1, ar2, ar3);
    }

    private static void findCommon(int[] ar1, int[] ar2, int[] ar3) {
        Map<Integer, Integer> map = new HashMap<>();
        populateMap(ar1, map);
        populateMap(ar2, map);
        populateMap(ar3, map);
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == 3) {
                System.out.print(e.getKey() + " ");
            }
        }
    }

    private static void populateMap(int[] ar1, Map<Integer, Integer> map) {
        for (int val : ar1) {
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
        }
    }
}
