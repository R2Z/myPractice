package array.reverse;

public class Reverse {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println("");
        reverse(arr);
    }

    private static void reverse(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
        for (int i : arr)
            System.out.print(i + " ");
    }
}
