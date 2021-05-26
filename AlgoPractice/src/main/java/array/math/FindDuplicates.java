package array.math;

import java.util.*;

public class FindDuplicates {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 6, 3, 6, 1};
        printDupConstantSpace(arr);
        //printRepeating_1(Arrays.stream(arr).sorted().toArray());
    }

    private static void printDupConstantSpace(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int abs = Math.abs(arr[i]);
            if (arr[abs] > 0) {
                arr[abs] = -arr[abs];
            } else {
                System.out.print(abs+" ");
            }
        }
    }

    private static void printRepeating_1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    static void printRepeating(int arr[]) {
        int i;
        int size = arr.length;
        System.out.println("The repeating elements are : ");
        for (i = 0; i < size; i++) {
            int j = Math.abs(arr[i]);
            if (arr[j] >= 0)
                arr[j] = -arr[j];
            else
                System.out.print(j + " ");
        }
    }

    private static void findDuplicates(int[] arr) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int val : arr) {
            if (set.contains(val))
                list.add(val);
            else
                set.add(val);
        }
        System.out.println(list);
    }
}
