package array.math;

public class UnionAndIntersection {

    public static void main(String[] args) {
        int arr1[] = {1, 3, 4, 5, 7};
        int arr2[] = {2, 3, 5, 6};
        getUnion(arr1, arr2);
        System.out.println("Intersection");
        getIntersection(arr1, arr2);
    }

    private static void getIntersection(int[] arr1, int[] arr2) {
        int l1 = 0, l2 = 0;
        int m = arr1.length;
        int n = arr2.length;
        while (l1 < m && l2 < n) {
            if (arr1[l1] == arr2[l2]) {
                System.out.print(arr1[l1]);
                l1++;
                l2++;
            } else if (arr1[l1] < arr2[l2]) {
                l1++;
            } else {
                l2++;
            }
        }
    }

    private static void getUnion(int[] arr1, int[] arr2) {

        int l1 = 0, l2 = 0;
        int m = arr1.length;
        int n = arr2.length;
        while (l1 < m && l2 < n) {
            if (arr1[l1] < arr2[l2]) {
                System.out.print(arr1[l1++]);
            } else if (arr2[l2] < arr1[l1]) {
                System.out.print(arr2[l2++]);
            } else {
                System.out.print(arr1[l1]);
                l1++;
                l2++;
            }
        }
        while (l1 < m) {
            System.out.print(arr1[l1++]);
        }
        while (l2 < n) {
            System.out.print(arr2[l2++]);
        }
    }
}
