package dp;

import java.util.Arrays;
import java.util.Collections;

public class LongestBiotonicSeq {
    public static void main(String[] args) {
        Integer[] arr = {3, 10, 2, 1, 20};
        //Integer[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80, 3};
        Integer[] lis = LIS(arr);
        Collections.reverse(Arrays.asList(arr));
        Integer[] lds = LIS(arr);
        Collections.reverse(Arrays.asList(lds));

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int currMax = lis[i] + lds[i] - 1;
            max = Integer.max(max, currMax);
        }
        System.out.println(max);
    }

    private static Integer[] LIS(Integer[] arr) {
        Integer[] lis = new Integer[arr.length];
        Arrays.fill(lis, 1);
        for (int i = 1; i < arr.length; i++) {
            int currMax = lis[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    currMax = Integer.max(currMax, lis[j] + 1);
                }
            }
            lis[i] = Integer.max(currMax, currMax);
        }
        return lis;
    }
}
