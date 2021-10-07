package test;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSumRaw(nums));
        System.out.println(maxSumIncreasingSubSequence(nums,-1,0));
    }

    private static int maxSumRaw(int[] nums) {
        int maxSum = nums[0];
        int currSum = maxSum;
        for (int i = 1; i < nums.length; i++) {
            currSum = Integer.max(currSum+nums[i], nums[i]);
            maxSum = Integer.max(maxSum,currSum);
        }
        return maxSum;
    }

    private static int maxSumIncreasingSubSequence(int arr[], int previous, int curr) {

        if (curr == arr.length) {
            return 0;
        }
        int sumIncludingCurr = 0;
        int sumExcludingCurr;
        // find max sum by including or excluding current element from array
        // include current only if its GE than previous
        // return max sum by including or excluding curr element
        if (previous == -1 || arr[curr] > arr[previous]) {
            sumIncludingCurr = arr[curr] + maxSumIncreasingSubSequence(arr, curr, curr + 1);
        }
        sumExcludingCurr = maxSumIncreasingSubSequence(arr, previous, curr + 1);

        return Math.max(sumIncludingCurr, sumExcludingCurr);
    }
}
