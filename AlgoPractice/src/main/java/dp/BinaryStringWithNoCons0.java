package dp;

import java.util.HashMap;
import java.util.Map;

public class BinaryStringWithNoCons0 {

    public static void main(String[] args) {
        int size = 30;
        Map<Integer, Integer> map = new HashMap<>();
        /*for (int i = 0; i < 2; i++) {
            getNoConsecutiveZeros(size, i, "");
        }*/
        getCount2(size);
        getCount(size);
        /*long t1 = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 2; i++) {
            count += getNoConsecutiveZerosCount(size, i);
        }
        System.out.println(count);
        System.out.println("Time " + (System.currentTimeMillis() - t1) / 1000);

        count = 0;
        t1 = System.currentTimeMillis();
        for (int i = 0; i < 2; i++) {
            count += getNoConsecutiveZerosCount(size, i, map);
        }
        System.out.println(count);
        System.out.println("Time " + (System.currentTimeMillis() - t1) / 1000);*/
    }

    private static void getCount(int size) {

        int zero[] = new int[size + 1];
        int one[] = new int[size + 1];

        zero[1] = 1;
        one[1] = 1;
        for (int i = 2; i <= size; i++) {
            zero[i] = one[i - 1];
            one[i] = zero[i - 1] + one[i - 1];
        }
        System.out.println(zero[size] + one[size]);
    }


    private static void getCount2(int size) {

        int curr_zero = 0;
        int curr_one = 0;

        int prev_zero = 1;
        int prev_one = 1;

        for (int i = 1; i < size; i++) {
            curr_zero = prev_one;
            curr_one = prev_zero + prev_one;

            prev_one = curr_one;
            prev_zero = curr_zero;
        }
        System.out.println(curr_one + curr_zero);
    }

    private static void getNoConsecutiveZeros(int size, int currVal, String ans) {

        if (size == 0) {
            System.out.println(ans);
            return;
        }

        if (currVal == 1) {
            getNoConsecutiveZeros(size - 1, 0, ans + 0);
        }
        getNoConsecutiveZeros(size - 1, 1, ans + 1);
    }

    private static int getNoConsecutiveZerosCount(int size, int currVal) {

        if (size == 0) {
            return 1;
        }

        int count = 0;
        if (currVal == 1) {
            count += getNoConsecutiveZerosCount(size - 1, 0);
        }
        count += getNoConsecutiveZerosCount(size - 1, 1);

        return count;
    }

    private static int getNoConsecutiveZerosCount(int size, int currVal, Map<Integer, Integer> map) {

        if (map.containsKey(size)) {
            map.get(size);
        }
        if (size == 0) {
            return 1;
        }

        int count = 0;
        if (currVal == 1) {
            count += getNoConsecutiveZerosCount(size - 1, 0, map);
        }
        count += getNoConsecutiveZerosCount(size - 1, 1, map);

        map.put(size, count);
        return count;
    }


}
