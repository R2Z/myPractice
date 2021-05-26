package array.minmax;

import java.util.Arrays;

import static array.Utils.print;
import static array.Utils.swap;

public class FindKthMnUsingQuickSort {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 6;
        System.out.println("Original Array");
        print(arr);
        int kMin = findKmin(arr, k, 0, arr.length - 1);
        System.out.println("Sorted Array");
        print(Arrays.stream(arr).sorted().toArray());
        System.out.println(k + " kMin " + kMin);
    }

    // do partitioning until partition Index + is equal to K
    private static int findKmin(int[] arr, int k, int low, int high) {
        int kMin = -1;
        if (k > 0 && k <= (high - low) + 1) {
            int pI = partition(arr, low, high);
            if (pI + 1 == k) {
                kMin = arr[pI];
                // check for left partition
            } else if (k < pI + 1) {
                kMin = findKmin(arr, k, low, pI - 1);
            } else {
                kMin = findKmin(arr, k, pI + 1, high);
            }
        } else if (k > 0 && high == low) {
            kMin = arr[low];
        }
        return kMin;
    }

    // partition gives right element for the partitionIndex resolved
    private static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int pivotIndex = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, pivotIndex++, j);
            }
        }
        swap(arr, pivotIndex, high);
        return pivotIndex;
    }
}
