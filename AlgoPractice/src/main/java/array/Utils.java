package array;

public class Utils {

    public static void swap(int arr[], int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public static void print(int arr[]) {
        for (int i : arr)
            System.out.print(i + " ");

        System.out.println("");
    }

    public static void copyArray(int src[], int dest[]) {
        for (int i = 0; i < src.length; i++) {
            dest[i] = src[i];
        }
    }
}
