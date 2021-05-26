package array.sortingProblems;

import array.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sort012s {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2};
        countSort(arr);
    }

    private static void countSort(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            int y = 0;
            if (map.get(val) != null) {
                y = map.get(val);
            }
            map.put(val, ++y);
        }
        int[] outPutArr = new int[arr.length];
        int currIndex = 0;
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        for (int e = min; e <= max; e++) {
            int count = map.get(e);
            for (int i = 0; i < count; i++) {
                outPutArr[currIndex++] = e;
            }
        }
        Utils.print(outPutArr);
    }
}
