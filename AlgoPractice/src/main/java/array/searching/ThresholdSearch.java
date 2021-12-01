package array.searching;

public class ThresholdSearch {

    public static void main(String[] args) {
        int arr[] = {1, 2, 5, 9};
        int th = 6;
        int l = 0;
        int h = 10000000;

        while (l <= h) {
            int m = l + (h - l) / 2;
            long sum = getSum(arr, m);
            if (sum > th) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        System.out.println(l);
    }

    private static long getSum(int[] arr, int div) {
        int sum = 0;
        for (int num : arr) {
            sum += (num - 1) / div + 1;
        }
        return sum;
    }
}
