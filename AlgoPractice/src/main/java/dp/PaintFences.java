package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaintFences {
    public static void main(String[] args) {
        int n = 8;
        int k = 3;
        List<Integer> fencing = new ArrayList<>();
        int count = countFencingPaint(n, k, fencing);
        System.out.println(count);
        fencing = new ArrayList<>();
        count = countFencingPaint(n, k, fencing, new HashMap<>());
        System.out.println(count);
    }

    private static int countFencingPaint(int n, int k, List<Integer> fencing) {

        if (n == 0) {
            //System.out.println(fencing);
            return 1;
        }

        int count = 0;
        for (int i = 1; i <= k; i++) {
            if (fencing.size() >= 2) {
                int lastFence = fencing.get(fencing.size() - 1);
                int secLastFence = fencing.get(fencing.size() - 2);
                if (lastFence != secLastFence || lastFence != i) {
                    fencing.add(i);
                    count += countFencingPaint(n - 1, k, fencing);
                    fencing.remove(fencing.size() - 1);
                }
            } else {
                fencing.add(i);
                count += countFencingPaint(n - 1, k, fencing);
                fencing.remove(fencing.size() - 1);
            }
        }
        return count;
    }

    private static int countFencingPaint(int n, int k, List<Integer> fencing, Map<String, Integer> map) {

        String key = "";

        if (fencing.size() > 0) {
            for (int val : fencing) {
                key += "|" + val;
            }
        }

        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (n == 0) {
            //System.out.println(fencing);
            return 1;
        }

        int count = 0;
        for (int i = 1; i <= k; i++) {
            if (fencing.size() >= 2) {
                int lastFence = fencing.get(fencing.size() - 1);
                int secLastFence = fencing.get(fencing.size() - 2);
                if (lastFence != secLastFence || lastFence != i) {
                    fencing.add(i);
                    count += countFencingPaint(n - 1, k, fencing, map);
                    fencing.remove(fencing.size() - 1);
                }
            } else {
                fencing.add(i);
                count += countFencingPaint(n - 1, k, fencing, map);
                fencing.remove(fencing.size() - 1);
            }
        }
        map.put(key, count);
        return count;
    }
}
