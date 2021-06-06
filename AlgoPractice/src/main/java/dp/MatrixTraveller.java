package dp;

import java.util.HashMap;
import java.util.Map;

public class MatrixTraveller {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        //System.out.println(gridTraveller(m, n));
        System.out.println(gridTravellerDP(m, n, null));
    }

    private static int gridTraveller(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 && n == 1) return 1;
        return gridTraveller(m - 1, n) + gridTraveller(m, n - 1);
    }

    private static int gridTravellerDP(int m, int n, Map<String, Integer> map) {

        if (map == null) {
            map = new HashMap<>();
        }
        String key = m + "|" + n;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (m == 0 || n == 0) return 0;
        if (m == 1 && n == 1) return 1;
        int value = gridTraveller(m - 1, n) + gridTraveller(m, n - 1);
        map.put(key, value);
        return map.get(key);
    }

}
