package array.searching;

public class MountainPeak {

    public static void main(String[] args) {
        int arr[] = {24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
        System.out.println(binSearch(arr, 0, arr.length-1));
    }

    static int binSearch(int arr[], int st, int end) {

        while (st < end) {
            int mid = st + (end - st) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                st = mid + 1;
            }
        }
        return st;
    }

}
