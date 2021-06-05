package array.sorting;


import array.Utils;

public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {10, 80, 30, 90, 40, 50, 70};
        Utils.print(arr);
        mergeSort(arr, 0, arr.length - 1);
        Utils.print(arr);
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int leftArraySize = mid - low + 1;
        int rightArraySize = high - mid;

        int[] left = new int[leftArraySize];
        int[] right = new int[rightArraySize];

        // copy data into tmp array
        for (int i = 0; i < leftArraySize; i++) {
            left[i] = arr[low + i];
        }

        for (int i = 0; i < rightArraySize; i++) {
            right[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = low;

        // sort elements from two sub arrays
        while (i < leftArraySize && j < rightArraySize) {
            // check if element from left is less than right if true
            // then keep left element in original array else from right array
            if (left[i] < right[j]) {
                arr[k] = left[i++];
            } else {
                arr[k] = right[j++];
            }
            k++;
        }

        // copy remaining from left and right arrays into original
        copyRemaining(arr, left, i, leftArraySize, k);
        copyRemaining(arr, right, j, rightArraySize, k);

    }

    private static void copyRemaining(int[] arr, int[] copyArray, int copyIndex, int copyIndexLength, int currIndex) {
        while (copyIndex < copyIndexLength) {
            arr[currIndex] = copyArray[copyIndex];
            copyIndex++;
            currIndex++;
        }
    }
}
