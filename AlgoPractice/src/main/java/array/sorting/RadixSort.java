package array.sorting;

import java.util.*;

import static array.Utils.copyArray;
import static array.Utils.print;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        print(arr);
        radixSort(arr);
        System.out.println("After radixSort ");
        print(arr);
    }

    private static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        for (int digit = 1; max / digit > 0; digit *= 10) {
            countSort(arr, digit);
        }
    }

    private static void countSort(int[] arr, int digit) {
        Map<Integer, List<Integer>> keyCountMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> numList = new ArrayList<>();
            int key = (arr[i] / digit) % 10;
            if (keyCountMap.containsKey(key)) {
                numList = keyCountMap.get(key);
            }
            numList.add(arr[i]);
            keyCountMap.put(key, numList);
        }
        //System.out.println(keyCountMap);
        Set<Integer> sortedKeySet = new TreeSet<>(keyCountMap.keySet());
        // System.out.println("sortedKeySet " + sortedKeySet);
        int[] outputArray = new int[arr.length];
        int outputIndex = 0;
        for (Integer element : sortedKeySet) {
            outputIndex = populateOutPutArray(outputArray, outputIndex, keyCountMap.get(element));
        }
        // 722 465 1465 273 383
        // digit 1 = {2=1, 3=2, 5=2}
        copyArray(outputArray, arr);
        System.out.println("digit " + digit);
        print(arr);
    }

    private static int populateOutPutArray(int[] outputArray, int outputIndex, List<Integer> numList) {
        for (int i = 0; i < numList.size(); i++) {
            outputArray[outputIndex++] = numList.get(i);
        }
        return outputIndex;
    }
}
