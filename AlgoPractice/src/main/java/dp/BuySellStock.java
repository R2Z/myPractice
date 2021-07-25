package dp;

import java.util.PriorityQueue;
import java.util.Queue;

public class BuySellStock {

    // Profit = SP - BP
    // To Maximize Profit SP should be max and BP should be least
    // BP = min (hold Previous Day BP,buy today again) , buy today -> current day stock price - previous day profit booked
    // SP = max (previous day profit , today's Sell) , today's sell -> current day stock price - previous buy price - fee
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int cooling = 1;
        System.out.println(buSellStockWithTransactionFee(prices, fee));
        int[] prices1 = {1, 2, 3, 0, 2};
        System.out.println(buySellStockWithCooling(prices1, 1));

        System.out.println(buySellStocksWithAnyNumberOfTransactions(prices1));
        System.out.println(buySellStocksWithAnyNumberOfTransactions2(prices1));

        int[] prices3 = {5, 11, 3, 50, 60, 90};
        System.out.println(buySellStocksWithTwoTransactions(prices3));

    }

    private static int buySellStockWithCooling(int[] prices, int cooling) {

        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];

        buy[0] = prices[0];
        sell[0] = 0;

        for (int T = 1; T <= cooling; T++) {
            buy[T] = Integer.min(buy[T - 1], prices[T] - sell[T - 1]);
            sell[T] = Integer.max(sell[T - 1], prices[T] - buy[T - 1]);
        }


        for (int T = cooling + 1; T < prices.length; T++) {
            buy[T] = Integer.min(buy[T - 1], prices[T] - sell[T - 2]);
            sell[T] = Integer.max(sell[T - 1], prices[T] - buy[T - 1]);
        }

        return sell[prices.length - 1];
    }

    private static int buSellStockWithTransactionFee(int[] prices, int fee) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = prices[0];
        sell[0] = 0;
        int profitSoFar = 0;

        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.min(buy[i - 1], prices[i] - profitSoFar);
            sell[i] = Math.max(profitSoFar, prices[i] - buy[i - 1] - fee);
            profitSoFar = sell[i];
        }
        return profitSoFar;
    }

    private static void addToQueue(Queue<Integer> queue, int profit, int k) {
        queue.add(profit);
        if (queue.size() > k) {
            queue.remove();
        }
    }

    private static int buySellStocksWithAnyNumberOfTransactions(int[] prices) {
        int buyDay = 0;
        int sellDay = 0;
        int profit = 0;
        for (int T = 1; T < prices.length; T++) {
            if (prices[T] >= prices[T - 1]) {
                sellDay++;
            } else {
                profit += prices[sellDay] - prices[buyDay];
                buyDay = T;
                sellDay = T;
            }
        }
        // settling last day
        if (prices[prices.length - 1] > prices[buyDay]) {
            profit += prices[prices.length - 1] - prices[buyDay];
        }
        return profit;
    }

    private static int buySellStocksWithAnyNumberOfTransactions2(int[] prices) {
        int profit = 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];

        buy[0] = prices[0];
        for (int T = 1; T < prices.length; T++) {
            buy[T] = Integer.min(buy[T - 1], prices[T] - profit);
            sell[T] = Integer.max(profit, prices[T] - buy[T - 1]);
            profit = sell[T];
        }

        return profit;
    }

    //https://www.youtube.com/watch?v=Pw6lrYANjz4&t=2446s
    private static int buySellStocksWithTwoTransactions(int[] prices) {

        int k = 2;
        int[][] profit = new int[k + 1][prices.length];
        for (int T = 1; T < k + 1; T++) {
            int profitSoFar = Integer.MIN_VALUE;
            for (int D = 1; D < prices.length; D++) {
                profitSoFar = Integer.max(profitSoFar, profit[T - 1][D - 1] - prices[D - 1]);
                profit[T][D] = Integer.max(profit[T][D - 1], prices[D] + profitSoFar);
            }
        }
        return profit[k][prices.length - 1];
    }
}
