package array.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class LargestThreeElement {
    public static void main(String[] args) {
        int arr[] = {10, 4, 3, 50, 23, 90};
        findMaxThreeElement(arr);
    }

    private static void findMaxThreeElement(int[] arr) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int val : arr) {
            minHeap.add(val);
            if (minHeap.size() > 3) {
                minHeap.poll();
            }
        }
        for (int val : minHeap) {
            System.out.print(val + " ");
        }
    }
}
