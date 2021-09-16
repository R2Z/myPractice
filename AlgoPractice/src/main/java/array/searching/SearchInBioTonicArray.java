package array.searching;

public class SearchInBioTonicArray {

    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1};
        int arr[] = arr1;
        int target = 4;
        int start = 0;
        int end = arr.length - 1;
        int peak = findPeak(arr);
        int ans = orderAgnosticBS(arr, start, peak, target);
        if (ans == -1) {
            ans = orderAgnosticBS(arr, peak, end, target);
        }
        System.out.println(ans);

    }

    static int orderAgnosticBS(int arr[], int start, int end, int target) {

        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
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

    static int findPeak(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
