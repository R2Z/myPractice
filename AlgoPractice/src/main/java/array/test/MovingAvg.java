package array.test;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class MovingAvg {
    public static void main(String[] args) {
        int[] arr = {3, 1, 10, 3, 5};
        int k = 3;
        Queue<Integer> q = new ArrayDeque<>(k);
        for (int val : arr) {
            q.add(val);
            if (q.size() > 3) {
                q.remove();
            }
            getAvg(q);
        }
    }

    static void getAvg(Queue<Integer> q) {
        double sum = 0;
        for (int val : q) {
            sum += val;
        }
        double d = sum / q.size();
        System.out.println(d);
    }
}
