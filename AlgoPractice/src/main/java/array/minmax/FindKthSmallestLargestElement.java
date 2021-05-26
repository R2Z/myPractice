package array.minmax;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import static array.Utils.print;

public class FindKthSmallestLargestElement {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println("Original Array");
        print(arr);
        int kMin = findKmin(arr, k);
        int kMax = findKmax(arr, k);
        System.out.println("Sorted Array");
        print(Arrays.stream(arr).sorted().toArray());
        System.out.println("kMin " + kMin + " kMax " + kMax);
    }

    private static int findKmax(int[] arr, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int val : arr) {
            minHeap.add(val);
            if (minHeap.size() > k)
                minHeap.remove();
        }
        return minHeap.remove();
    }

    private static int findKmin(int[] arr, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> {
            if(o1 > o2)
                return -11;
            if(o1 < o2)
                return 1;
            else return 0;
        });
        for (int val : arr) {
            maxHeap.add(val);
            if (maxHeap.size() > k)
                maxHeap.remove();
        }
        return maxHeap.remove();
    }
}
