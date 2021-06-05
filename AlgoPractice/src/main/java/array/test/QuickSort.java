package array.test;


import array.Utils;

public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {10, 80, 30, 90, 40, 50, 70};
        quickSort(arr, 0, arr.length - 1);
        Utils.print(arr);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int PI = partition(arr, low, high);
            quickSort(arr, 0, PI - 1);
            quickSort(arr, PI + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int PI = low - 1;
        for (int j = low; j < high; j++) {
            //keep elements lesser than pivot to the left side of the pivot
            if (arr[j] < pivot) {
                Utils.swap(arr, j, ++PI);
            }
        }
        Utils.swap(arr, ++PI, high);
        return PI;
    }
}
