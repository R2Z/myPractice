package array.math;

import array.Utils;

public class RotateEvenOddNums {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        rotateRight(arr);
        Utils.print(arr);
    }

    private static void rotateRight(int[] arr) {
        int first = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = first;
    }

    private static void rotateLeft(int[] arr) {
        int last = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = last;
    }

    private static void rightRotateOdd(int[] arr) {
        // 1,3,5,7 = 7,1,3,5
        // 0,2,4,6 index
        //length = 8
        int first = arr[arr.length - 2];
        // start from last odd , dec by 2 until 1
        // arr[0] = last
        for (int i = arr.length - 4; i >= 0; i = i - 2) {
            arr[i + 2] = arr[i];
        }
        arr[0] = first;
    }

    private static void leftRotateEven(int[] arr) {
        // 2,4,6,8 => 4,6,8,2
        // 1,3,5,7 index position
        int last = arr[1];
        // start from 3 , place 3 into 1 , step 2 for all elements until 7
        for (int i = 3; i < arr.length; i = i + 2) {
            arr[i - 2] = arr[i];
        }
        // place lat last even index
        arr[arr.length - 1] = last;
    }
}
