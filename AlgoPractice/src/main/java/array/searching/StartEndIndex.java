package array.searching;

public class StartEndIndex {
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        int target = 5;

        int start = binSearch(arr, 0, arr.length, target, true);
        System.out.println(start);
        int end = binSearch(arr, 0, arr.length, target, false);
        System.out.println(end);

    }

    static int binSearch(int[] arr, int st, int ed, int target, boolean startIndex) {

        int position = -1;

        while (st <= ed) {
            int mid = st + (ed - st) / 2;
            if (target < arr[mid]) {
                ed = mid - 1;
            } else if (target > arr[mid]) {
                st = mid + 1;
            } else {
                position = mid;
                if (startIndex) {
                    ed = mid - 1;
                } else {
                    st = mid + 1;
                }

            }

        }

        return position;

    }

}
