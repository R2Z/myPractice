package array.searching;

public class Celing {

    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int target = 3;
        int ans = ceil(arr, 0, arr.length - 1, target);
        System.out.println(ans);
        ans = floor(arr, 0, arr.length - 1, target);
        System.out.println(ans);

    }

    private static int ceil(int[] arr, int start, int end, int target) {

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target <= arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return arr[mid];
            }
        }
        return arr[start];
    }

    private static int floor(int[] arr, int start, int end, int target) {

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target <= arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return arr[mid];
            }
        }
        return arr[end];
    }
}
