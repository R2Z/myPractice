package array.sorting;


import array.Utils;

public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {10, 80, 30, 90, 40, 50, 70};
        Utils.print(arr);
        quickSort(arr, 0, arr.length - 1);
        Utils.print(arr);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int pI = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                Utils.swap(arr, ++pI, j);
            }
        }
        Utils.swap(arr, ++pI, high);
        return pI;
    }
}
