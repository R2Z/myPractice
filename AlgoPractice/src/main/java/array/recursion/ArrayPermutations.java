package array.recursion;

import java.util.Arrays;

public class ArrayPermutations {

    public static void main(String[] args) throws Exception {
        int nboxes = 3;
        int ritems = 2;
        //printAllPermutations(new int[nboxes], 1, ritems);
        System.out.println("permutations");
        printAllPermutations(new int[nboxes], 1, ritems);
        System.out.println("printAllCombinations");
        printAllCombinations(new int[nboxes], 1, ritems, -1);
    }

    private static void printAllCombinations(int[] arr, int currItem, int totalItems, int currIndex) {

        if (currItem > totalItems) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = currIndex + 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
                printAllCombinations(arr, currItem + 1, totalItems, i);
                arr[i] = 0;
            }
        }

    }

    //https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/permutation-i-official/ojquestion
    private static void printAllPermutations(int[] arr, int ck, int k) {

        if (ck > k) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = ck;
                printAllPermutations(arr, ck + 1, k);
                arr[i] = 0;
            }
        }

    }

}
