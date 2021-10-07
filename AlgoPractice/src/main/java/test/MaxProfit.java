package test;

import java.util.HashSet;
import java.util.Set;

public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Set<Integer> set = new HashSet<>();
        //set.contains()
        int profit = getProfitAnyNumTransaction(prices);
        System.out.println(profit);
    }

    private static int getProfitAnyNumTransaction(int[] prices) {
        int profit = 0;
        int buyDay = 0;
        int sellDay = 0;

        for (int i = 1; i < prices.length; i++) {
            // pricesDrop then sell
            if (prices[i] < prices[i - 1]) {
                profit += prices[sellDay] - prices[buyDay];
                buyDay = sellDay = i;
            } else {
                sellDay++;
            }
        }
        return profit;
    }

    private static int getProfitWithOneTransaction(int[] prices) {
        int[] maxPrices = new int[prices.length];

        maxPrices[prices.length - 1] = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] > maxPrices[i + 1]) {
                maxPrices[i] = prices[i];
            } else {
                maxPrices[i] = maxPrices[i + 1];
            }
        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            int currProfit = maxPrices[i] - prices[i];
            profit = Integer.max(profit, currProfit);
        }
        return profit;
    }

}
