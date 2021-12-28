package array.recursion;

public class BoxFilling {
    public static void main(String[] args) {

        int boxes = 3;
        int items = 2;
        getPermutations(new int[boxes], 1, items);
        System.out.println("");
        System.out.println("");
        getCombinations(new int[boxes], -1, 1, items);
    }

    static void getPermutations(int[] arr, int ci, int totalItems) {

        if (ci > totalItems) {
            System.out.println("");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
            }
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

    static void getCombinations(int[] arr, int lastBox, int cv, int totalItems) {

        if (cv > totalItems) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
            }
            System.out.println("");
            return;
        }

        for (int i = lastBox + 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = cv;
                getCombinations(arr, i, cv + 1, totalItems);
                arr[i] = 0;
            }
        }
    }

}
