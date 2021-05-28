package array.count;

import java.util.ArrayList;
import java.util.List;

public class KadaneAlgo {

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        getMaxSumSubArray(arr);
        int arr1[] = {-2, -5, 6, -2, -3, 1, 5, -6};
        getMaxSumSubArray(arr1);
    }

    /**
     * Init C = M = arr[0]
     * iterate from 1 until n
     * if C > 0 then add to chain C else reset chain C = arr[i]
     * if( C > M) then M = C
     *
     * @param arr array of elements
     */
    private static void getMaxSumSubArray(int[] arr) {
        int currSum = arr[0];
        int maxSum = currSum;
        List<Integer> currList = new ArrayList<>();
        currList.add(currSum);
        List<Integer> maxList = currList;
        for (int i = 1; i < arr.length; i++) {
            if (currSum >= 0) {
                currSum += arr[i];
                currList.add(arr[i]);
            } else {
                currList.clear();
                currList.add(arr[i]);
                currSum = arr[i];
            }
            if (currSum > maxSum) {
                maxSum = currSum;
                maxList = new ArrayList<>(currList);
            }
        }
        System.out.println("Element " + maxList);
        System.out.println("maxSum " + maxSum);
    }
}
