package dp;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String[] args) {

        for (int i = 0; i <= 50; i++) {
            long t1 = System.currentTimeMillis();
            long num = recurDPFibonacci(i, null);
            System.out.println("For num " + i + " Time taken in sec's " + (System.currentTimeMillis() - t1));
            System.out.println(num);
        }
    }

    private static long iterativeDPFibonacci(int num) {

        long[] arr = new long[num + 2];
        // base case
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i <= num; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[num];
    }

    private static long iterativeFibonacci(long num) {
        long result = 1;
        long prevRes = 1;
        for (int i = 2; i < num; i++) {
            long tmp = result;
            result = result + prevRes;
            prevRes = tmp;
        }
        return result;
    }


    private static BigDecimal recurFibonacci(BigDecimal n) {
        if (n.longValue() <= 2) {
            return new BigDecimal(1);
        }
        return recurFibonacci(n.subtract(new BigDecimal(1))).add(recurFibonacci(n.subtract(new BigDecimal(2))));
    }

    private static long recurLongFibonacci(long n) {
        if (n <= 2) {
            return 1;
        }
        return recurLongFibonacci(n - 2) + recurLongFibonacci(n - 1);
    }


    private static long recurDPFibonacci(int num, Map<Integer, Long> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (map.containsKey(num)) return map.get(num);
        if (num <= 2) return 1;
        long result = recurDPFibonacci(num - 1, map) + recurDPFibonacci(num - 2, map);
        map.put(num, result);
        return map.get(num);
    }
}
