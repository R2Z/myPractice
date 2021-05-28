package array.test;

import array.Utils;

import java.util.Arrays;

public class ReArrangeArray {
    public static void main(String[] args) {
        //int arr[] = {1, 2, 3, -4, -1, 4};
        int arr[] = {9, -3, 5, -2, -8, -6, 1, 3};
        int pI = partition(arr);
        Utils.print(arr);
        // incr i by 2 to hover on even index and also increment PI to hover + element
        for (int i = 1; i < arr.length; i = i + 2) {
            if (arr[i] < 0) {
                Utils.swap(arr, i, pI++);
            }
        }
        Utils.print(arr);
    }

    static int partition(int[] arr) {
        int pivot = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                Utils.swap(arr, i, pivot++);
            }
        }
        return pivot;
    }
}
