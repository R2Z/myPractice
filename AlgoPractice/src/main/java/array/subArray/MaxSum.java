package array.subArray;

public class MaxSum {
    public static void main(String[] args) {
        int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        int n = arr.length;
        System.out.println(maxSum(arr, n, k));
    }

    private static int maxSum(int[] arr, int n, int k) {
        if (n < k) {
            System.out.println("Invalid window");
            return -1;
        }

        // Take sum of first window
        int max_sum = 0;
        for (int i = 0; i < k; i++)
            max_sum = max_sum + arr[i];

        int win_sum = max_sum;
        // sliding window
        for (int i = k; i < arr.length; i++) {
            win_sum = win_sum + arr[i] - arr[i - k];
            max_sum = Math.max(win_sum, max_sum);
        }
        return max_sum;

    }
}
