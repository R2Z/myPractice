package array.searching;

public class BinSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int tgt = 13;
        int ans = binSearch(arr, 0, arr.length - 1, tgt);
        System.out.println(ans);
        System.out.println(binSearchItr(arr, 0, arr.length - 1, tgt));
    }

    private static int binSearch(int[] arr, int st, int ed, int tgt) {
        if (st > ed) {
            return -1;
        }

        int mid = st + (ed - st) / 2;

        if (arr[mid] == tgt) {
            return mid;
        } else if (arr[mid] > tgt) {
            return binSearch(arr, st, mid - 1, tgt);
        } else {
            return binSearch(arr, mid + 1, ed, tgt);
        }
    }

    private static int binSearchItr(int[] arr, int st, int ed, int tgt) {

        while (st <= ed) {
            int mid = st + (ed - st) / 2;

            if (arr[mid] == tgt) {
                return mid;
            } else if (arr[mid] > tgt) {
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return -1;
    }
}
