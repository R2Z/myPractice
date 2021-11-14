package array.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGE {
    public static void main(String[] args) {
        int[] arr = {2, 5, 9, 3, 1, 12, 6, 8, 7};
        //nextGEFromRight(arr);
        nextGEFromLeft(arr);
    }

    private static void nextGEFromLeft(int[] arr) {
        Stack<Integer> stck = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], -1);
        stck.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            while (!stck.isEmpty() && arr[i] > stck.peek()) {
                stck.pop();
            }
            if (!stck.isEmpty()) {
                map.put(arr[i], stck.peek());
            } else {
                map.put(arr[i], -1);
            }
            stck.push(arr[i]);
        }
        for (int val : arr) {
            System.out.println(val + " -> " + map.get(val));
        }
    }

    private static void nextGEFromRight(int[] arr) {
        Stack<Integer> stck = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(arr[arr.length - 1], -1);
        stck.push(arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            while (!stck.isEmpty() && arr[i] > stck.peek()) {
                stck.pop();
            }
            if (!stck.isEmpty()) {
                map.put(arr[i], stck.peek());
            } else {
                map.put(arr[i], -1);
            }
            stck.push(arr[i]);
        }
        for (int val : arr) {
            System.out.println(val + " -> " + map.get(val));
        }
    }
}
