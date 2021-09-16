package array.searching;

public class OrderAgnosticBS {
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5, 6};
        int arr2[] = {6, 5, 4, 3, 2, 1};
        int arr[] = arr2;
        int target = 4;
        int start = 0;
        int end = arr.length - 1;
        int ans = binSearch(arr, start, end, target);
        System.out.println(ans);
    }

    private static int binSearch(int[] arr, int start, int end, int target) {

        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return mid;
            }

            if (isAsc) {
                if (target > arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target > arr[mid]) {
                    start = mid - 1;
                } else {
                    end = mid + 1;
                }
            }

        }
        return -1;
    }

}
