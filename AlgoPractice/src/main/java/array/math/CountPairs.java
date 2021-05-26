package array.math;

import java.util.*;

public class CountPairs {

    private static void pairSum(int[] arr, int k) {

        // store occurrence of each element
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
        }

        int pairSum = 0;
        for (int val : arr) {
            int diff = k - val;
            if (map.containsKey(diff)) {
                pairSum += map.get(diff);
            }
            if (diff == val) {
                pairSum--;
            }
        }
        System.out.println(pairSum / 2);
    }

    public static void main(String[] args) {
        int arr[] = {48, 24, 99, 51, 33, 39, 29, 83, 74, 72, 22, 46, 40, 51, 67, 37, 78, 76, 26, 28, 76, 25, 10, 65, 64, 47, 34, 88, 26, 49, 86, 73, 73, 36, 75, 5, 26, 4, 39, 99, 27, 12, 97, 67, 63, 15, 3, 92, 90};
        //int arr[] = {1, 1, 1, 1};
        //int[] arr = {1, 5, 7, -1};
        int sum = 50;
        pairSum(arr, sum);
        getPairSumCount(Arrays.stream(arr).sorted().toArray(), sum);
    }

    // works for sorted array
    private static void getPairSumCount(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;
        int sum = 0;
        while (l < r) {
            if (arr[l] + arr[r] > k) {
                r--;
            } else if (arr[l] + arr[r] < k) {
                l++;
            } else {
                sum++;
                r--;
            }
        }
        System.out.println(sum);
    }
}
