package array.count;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithZeroSum {

    public static void main(String[] args) {
        int arr[] = {4, 2, -3, 1, 6};
        //int arr[] = {4, 2, 0, 1, 6};
        //int arr[] = {-3, 2, 3, 1, 6};
        maxLengthSubArray(arr);
    }

    static void maxLengthSubArray(int[] arr) {
        int max = -1;
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        int sum = 0;
        int start = -1;
        int end = -1;
        sumIndexMap.put(sum, 0);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sumIndexMap.containsKey(sum)) {
                int diff = i - sumIndexMap.get(sum);
                if (diff > max) {
                    max = diff;
                    start = sumIndexMap.get(sum) + 1;
                    end = i;
                }

            } else {
                sumIndexMap.put(sum, i);
            }
        }
        System.out.println("MAX " + max + " start " + start + " end " + end);
    }

}
