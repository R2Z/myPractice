package array.sorting;

import array.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class CountSortAdvanced {

    public static void main(String[] args) {
        int[] arr = {-1, -2, -1, 2, -3, -4, 6, 2, 0, 8};
        //int[] arr = {1, 4, 1, 2, 7, 5, 2};
        Utils.print(arr);
        countSortAdvanced(arr, arr.length);
    }

    private static void countSortAdvanced(int[] arr, int length) {
        // find min and max from array
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        System.out.println("min " + min + " max " + max);
        // create map with element and its count
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            if (map.containsKey(arr[i])) {
                count = map.get(arr[i]);
            }
            map.put(arr[i], count + 1);
        }
        System.out.println(" element & count " + map);
        int[] outputArray = new int[arr.length];
        int outputIndex = 0;
        // iterate from min to max and check if it is present in map then populate outputArray
        for (int element = min; element <= max; element++) {
            if (map.containsKey(element)) {
                int times = map.get(element);
                outputIndex = populateOutputArray(outputArray, outputIndex, element, times);
            }
        }
        Utils.print(outputArray);
    }

    private static int populateOutputArray(int[] outputArray, int outputIndex, int value, int times) {
        for (int i = 0; i < times; i++) {
            outputArray[outputIndex] = value;
            outputIndex++;
        }
        return outputIndex;
    }
}
