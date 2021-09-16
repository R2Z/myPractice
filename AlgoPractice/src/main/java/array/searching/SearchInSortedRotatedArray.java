package array.searching;

public class SearchInSortedRotatedArray {

    public static void main(String[] args) {
        int arr[] = {5, 1, 2, 3, 4};
        //int arr[] = {5, 4, 3, 2, 1};
        int min = findMinElementAsPivot(arr);
        System.out.println(min);
    }

    private static int findMinElementAsPivot(int arr[]) {

        int start = 0;
        int end = arr.length - 1;

        while (end >= start) {
            int mid = (start + end) / 2;
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                return mid;
            } else if (mid + 1 < arr.length - 1 && arr[mid] > arr[mid + 1]) {
                return mid + 1;
            } else if (arr[start] < arr[mid]) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return -1;
    }

    private static int findPivotIndex(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        // array is not rotated
        if (arr[s] < arr[e]) {
            return 0;
        }
        // case 1 : 5,1,2,3,4
        while (e > s) {
            int m = s + (e - s) / 2;
            if (arr[m] > arr[m + 1]) {
                return m + 1;
            } else if (arr[s] <= arr[m]) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return -1;
    }

    /*private static int findPivotIndex(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        // array is not rotated
        if (arr[s] < arr[e]) {
            return 0;
        }
        // case 1 : 5,1,2,3,4
        while (e > s) {
            int m = s + (e - s) / 2;
             //for case 1 if mid (2) is > mid -1 (1) return mid -1
            if (arr[m] < arr[m - 1] && arr[m] < arr[m + 1]) {
                return m;
                // case 2 : 4,5,1,2,3
            } else if (arr[m] > arr[e]) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return -1;
    }*/
}
