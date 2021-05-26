package array.count;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrence {
    public static void main(String[] args) {
        int a[] = {0, 5, 5, 5, 4};
        int x = 5;
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : a) {
            int y = 0;
            if (map.get(val) != null) {
                y = map.get(val);
            }
            map.put(val, ++y);
        }
        System.out.println(map.get(x));
    }
}
