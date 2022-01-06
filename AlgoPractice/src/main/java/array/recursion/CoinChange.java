package array.recursion;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {2, 3, 5, 6, 7};
        int amount = 15;
        System.out.println("coinChangeCombinations");
        coinChangeCombinations(coins, 0, 0, amount, "");
        System.out.println("coinChangeCombination2");
        coinChangeCombination2(coins, new boolean[coins.length], amount, 0, "", -1);
        System.out.println("coinChangePermutations");
        coinChangePermutations(coins, new boolean[coins.length], amount, 0, "");
        System.out.println("infCoinChange");
        infiniteCoinsChange(coins, amount, 0, "");
    }

    static void coinChangeCombinations(int[] coins, int index, int currSum, int amount, String ans) {

        if (index == coins.length) {
            if (currSum == amount) {
                System.out.println(ans);
            }
            return;
        }

        coinChangeCombinations(coins, index + 1, currSum + coins[index], amount, ans.isEmpty() ? "" + coins[index] : ans + "-" + coins[index]);
        coinChangeCombinations(coins, index + 1, currSum, amount, ans);
    }

    static void coinChangeCombination2(int[] coins, boolean[] used, int total, int currSum, String ans, int currIndex) {

        if (currSum > total) {
            return;
        } else if (currSum == total) {
            System.out.println(ans);
            return;
        }

        for (int i = currIndex + 1; i < coins.length; i++) {
            if (!used[i]) {
                used[i] = true;
                coinChangeCombination2(coins, used, total, currSum + coins[i], ans.isEmpty() ? "" + coins[i] : ans + "-" + coins[i], i);
                used[i] = false;
            }
        }
    }

    static void coinChangePermutations(int[] coins, boolean[] used, int total, int currSum, String ans) {

        if (currSum > total) {
            return;
        } else if (currSum == total) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < coins.length; i++) {
            if (!used[i]) {
                used[i] = true;
                coinChangePermutations(coins, used, total, currSum + coins[i], ans.isEmpty() ? "" + coins[i] : ans + "-" + coins[i]);
                used[i] = false;
            }
        }
    }

    static void infiniteCoinsChange(int[] coins, int total, int curr, String ans) {

        if (curr >= total) {
            if (curr == total) {
                System.out.println(ans);
            }
            return;
        }

        for (int i = 0; i < coins.length; i++) {
            infiniteCoinsChange(coins, total, curr + coins[i], ans.isEmpty() ? "" + coins[i] : ans + "-" + coins[i]);
        }

    }

}
