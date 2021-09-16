package array.searching;

public class InfiniteArraySearch {

    public static void main(String[] args) {

        int arr[] = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170, 190, 200, 210, 220, 221, 223};

        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }

        System.out.println();

        int t = 140;
        int s = 0;
        int e = 1;
        int n = 1;

        while (t > arr[e]) {
            s = e + 1;
            n = n + 1;
            e = (int) (Math.pow(2, n));
        }
        System.out.println(binarySearch(arr, s, e, t));
    }

    private static int binarySearch(int[] arr, int start, int end, int target) {

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
