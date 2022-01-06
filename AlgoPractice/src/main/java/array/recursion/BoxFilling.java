package array.recursion;

public class BoxFilling {
    public static void main(String[] args) {

        int boxes = 3;
        int items = 3;
        getPermutations(new int[boxes], 1, items);
        System.out.println("");
        getCombinations(new int[boxes], -1, 1, items);
    }

    static void getPermutations(int[] arr, int ci, int totalItems) {

        if (ci > totalItems) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
            }
            System.out.println("");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = ci;
                getPermutations(arr, ci + 1, totalItems);
                arr[i] = 0;
            }
        }

    }

    static void getCombinations(int[] arr, int lastBox, int ci, int totalItems) {

        if (ci > totalItems) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
            }
            System.out.println("");
            return;
        }

        for (int i = lastBox + 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = ci;
                getCombinations(arr, i, ci + 1, totalItems);
                arr[i] = 0;
            }
        }
    }

}
