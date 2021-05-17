package array.minmax;

public class FindMinMax {

    public static void main(String[] args) {
        long arr[] = {12, 1234, 45, 67, 1};
        System.out.println(getMin(arr));
        System.out.println(getMax(arr));
    }

    private static Long getMin(long arr[]) {
        long minValue = Long.MAX_VALUE;
        for (long val : arr) {
            minValue = Math.min(minValue, val);
        }
        return minValue;
    }

    private static Long getMax(long arr[]) {
        long maxValue = Long.MIN_VALUE;
        for (long val : arr) {
            maxValue = Math.max(maxValue, val);
        }
        return maxValue;
    }
}
