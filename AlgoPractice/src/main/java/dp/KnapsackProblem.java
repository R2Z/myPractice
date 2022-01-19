package dp;

import java.util.*;

public class KnapsackProblem {

    public static void main(String[] args) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> items1 = new ArrayList<>();
        items1.add(2);
        items1.add(4);
        map.put("Apple", items1);

        List<Integer> items2 = new ArrayList<>();
        items2.add(3);
        items2.add(5);
        map.put("Orange", items2);

        List<Integer> items3 = new ArrayList<>();
        items3.add(1);
        items3.add(3);
        map.put("Banana", items3);

        List<Integer> items4 = new ArrayList<>();
        items4.add(4);
        items4.add(7);
        map.put("Mango", items4);

        int maxWeight = 5;

        int maxProfit = getMaxProfit(map.keySet(), map, maxWeight, new ArrayList<>());
        System.out.println(maxProfit);
        maxProfit = getMaxProfit(map.keySet(), map, maxWeight, new ArrayList<>(), new HashMap<>());
        System.out.println(maxProfit);

    }

    private static int getMaxProfit(Set<String> items, Map<String, List<Integer>> map, int maxWeight, ArrayList<String> bag) {

        int maxProfit = Integer.MIN_VALUE;

        if (maxWeight == 0) {
            int profit = 0;
            for (String item : bag) {
                profit += map.get(item).get(1);
            }
            return profit;
        }

        for (String item : items) {
            int currProfit = Integer.MIN_VALUE;
            int currWt = map.get(item).get(0);
            if (maxWeight - currWt >= 0) {
                bag.add(item);
                currProfit = getMaxProfit(items, map, maxWeight - currWt, bag);
                // remove last item
                bag.remove(bag.size() - 1);
            }
            maxProfit = Integer.max(maxProfit, currProfit);
        }
        return maxProfit;
    }

    private static String getKey(List<String> bag) {
        StringBuilder sb = new StringBuilder();
        for (String item : bag) {
            sb.append(item + "|");
        }
        return sb.toString();
    }

    // Optimized Version of implementation
    private static int getMaxProfit(Set<String> items, Map<String, List<Integer>> map, int maxWeight, ArrayList<String> bag, Map<String, Integer> cache) {

        int maxProfit = Integer.MIN_VALUE;

        String key = getKey(bag);

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        if (maxWeight == 0) {
            int profit = 0;
            for (String item : bag) {
                profit += map.get(item).get(1);
            }
            return profit;
        }

        for (String item : items) {
            int currProfit = Integer.MIN_VALUE;
            int currWt = map.get(item).get(0);
            if (maxWeight - currWt >= 0) {
                bag.add(item);
                currProfit = getMaxProfit(items, map, maxWeight - currWt, bag, cache);
                // remove last item
                bag.remove(bag.size() - 1);
            }
            maxProfit = Integer.max(maxProfit, currProfit);
        }
        cache.put(key, maxProfit);
        return maxProfit;
    }
}
