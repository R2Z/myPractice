package array.sorting;

import array.Utils;

import java.util.Arrays;


public class CountSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 1, 2, 7, 5, 2};
        Utils.print(arr);
        countSort(arr, arr.length);
    }

    private static void countSort(int[] arr, int length) {
        // find Max from array
        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println("max " + max);
        // create CountArr of size max+1
        int[] countArr = new int[max + 1];
        Arrays.fill(countArr, 0);
        System.out.println("initial countArr");
        Utils.print(countArr);
        // populate countArr with number of times element from main array exists
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]] = countArr[arr[i]] + 1;
        }
        System.out.println("countArr populated with number of times element from main arr");
        Utils.print(countArr);
        // iterate over countArr
        // find current Index
        // find current Index value
        // output index counter
        int outPutIndex = 0;
        int[] outPutArr = new int[arr.length];
        for (int countIndex = 0; countIndex < countArr.length; countIndex++) {
            if (countArr[countIndex] > 0) {
                int value = countArr[countIndex];
                outPutIndex = populateOutPutArray(outPutArr, outPutIndex, countIndex, value);
            }
        }
        Utils.print(outPutArr);
    }

    private static int populateOutPutArray(int[] outPutArr, int outPutIndex, int value, int counts) {
        for (int i = 0; i < counts; counts--) {
            outPutArr[outPutIndex] = value;
            outPutIndex++;
        }
        return outPutIndex;
    }
}
