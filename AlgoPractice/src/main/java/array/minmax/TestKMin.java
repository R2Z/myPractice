package array.minmax;

import array.Utils;

import java.util.Arrays;


public class TestKMin {

    public static void main(String[] args) {
        /*int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;*/
        int[] arr = {12, 5, 787, 1, 23};
        int k = 2;
        System.out.println("Sorted Array");
        Utils.print(Arrays.stream(arr).sorted().toArray());
        System.out.println(Solution.kthSmallest(arr, 0, arr.length - 1, k));
    }

}

class Solution {
    public static int kthSmallest(int[] arr, int l,
                                  int r, int k)
    {
        if (k > 0 && k <= r - l + 1) {
            int pos = partition(arr, l, r);
            if (pos - l == k - 1)
                return arr[pos];
            if (pos - l > k - 1)
                return kthSmallest(arr, l, pos - 1, k);
            return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
        }
        return Integer.MAX_VALUE;
    }


    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int pi = low;
        for (int i = low; i < high; i++) {
            if (arr[i] <= pivot)
                swap(arr, pi++, i);
        }
        swap(arr, pi, high);
        return pi;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

