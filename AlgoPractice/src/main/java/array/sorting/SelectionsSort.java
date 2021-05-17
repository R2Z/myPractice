package array.sorting;

import array.Utils;

public class SelectionsSort {
    public static void main(String[] args) {
        int arr[] = {64,25,12,22,11};
        Utils.print(arr);
        sortArray(arr);
        Utils.print(arr);
    }

    private static void sortArray(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            int minIndex = i;
            for (int k = i+1; k< arr.length; k++){
                // find min Index
                if(arr[k] < arr[minIndex])
                minIndex = k;
            }
            // place it at first index
            Utils.swap(arr,i,minIndex);
        }
    }
}
