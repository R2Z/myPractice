package dp;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class BuildingBridges {

    public static void main(String[] args) {
        int[] northX = {1, 2, 3, 4, 5, 6};
        int[] southX = {3, 4, 5, 6, 1, 2};
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < northX.length; i++) {
            map.put(southX[i], northX[i]);
        }

        System.out.println("North " + map.values());
        System.out.println("South " + map.keySet());

        Integer[] vals = new Integer[map.values().size()];
        vals = map.values().toArray(vals);

        int max_bridges = LIS(vals, 0, -1);
        System.out.println(max_bridges);
        max_bridges = LIS_Tree(vals);
        System.out.println(max_bridges);
    }

    private static int LIS_Tree(Integer[] vals) {

        TreeSet<Integer> set = new TreeSet<>();
        for (int e : vals) {
            Integer high = set.ceiling(e);
            if (high != null) {
                set.remove(high);
            }
            set.add(e);
        }
        return set.size();
    }

    private static int LIS(Integer[] values, int curr, int prev) {

        if (curr == values.length) {
            return 0;
        }

        int currSub = -1;
        int nextSub = -1;
        // including curr element
        if (prev == -1 || values[curr] > values[prev]) {
            currSub = 1 + LIS(values, curr + 1, curr);
        }
        // curr element is greater than next element
        nextSub = LIS(values, curr + 1, prev);


        return Math.max(currSub, nextSub);
    }

}
