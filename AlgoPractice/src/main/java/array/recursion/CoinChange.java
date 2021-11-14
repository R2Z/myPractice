package array.recursion;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {2, 3, 5, 6, 7};
        int amount = 120;
        //coinChange(coins, 0, 0, amount, "");
        infCoinChange(coins, amount, 0, "");
    }

    static void coinChange(int[] coins, int index, int currSum, int amount, String ans) {

        if (index == coins.length) {
            if (currSum == amount) {
                System.out.println(ans);
            }
            return;
        }

        coinChange(coins, index + 1, currSum + coins[index], amount, ans.isEmpty() ? "" + coins[index] : ans + "-" + coins[index]);
        coinChange(coins, index + 1, currSum, amount, ans);
    }

    static void infCoinChange(int[] coins, int total, int curr, String ans) {

        if ( curr >= total) {
            if (curr == total) {
                System.out.println(ans);
            }
            return;
        }

        for (int i = 0; i < coins.length; i++) {
            infCoinChange(coins, total, curr + coins[i], ans.isEmpty() ? "" + coins[i] : ans + "-" + coins[i]);
        }

    }

}
