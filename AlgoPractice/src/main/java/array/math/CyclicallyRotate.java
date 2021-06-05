package array.math;


import array.Utils;

public class CyclicallyRotate {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
       // rotateByOne(arr);
        //rotateByOne_1(arr);
        rotateUsingTwoPointers(arr);
    }

    private static void rotateUsingTwoPointers(int[] arr) {
        int i = 0;
        int n = arr.length - 1;
        while (i < n) {
            Utils.swap(arr, i++, n);
        }
        Utils.print(arr);
    }

    private static void rotateByOne_1(int[] arr) {
        int last = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;
        Utils.print(arr);
    }
}
