package array.subArray;

import java.util.Arrays;

public class SearchElementInSegment {

    public static void main(String[] args) {
       // int[] arr = {3, 5, 2, 4, 9, 3, 1, 7, 3, 11, 12, 3};
        int arr[] = { 21, 23, 56, 65, 34, 54, 76, 32, 23, 45, 21, 23, 25};
        int segment = 5;
        int search = 23;
        boolean bool = true;
        for (int i = 0; i < arr.length; i = i + segment) {
            int[] subArray = Arrays.copyOfRange(arr, i, i + segment);
            System.out.println(Arrays.toString(subArray));
            boolean subBool = search(subArray, search);
            System.out.println("subBool " + subBool);
            bool = bool & subBool;
            if (!bool) break;
        }

        System.out.println(bool);
    }

    private static boolean search(int[] arr, int x) {
        boolean found = false;
        for (int i : arr) {
            if (i == x) found = true;
        }
        return found;
    }
}
