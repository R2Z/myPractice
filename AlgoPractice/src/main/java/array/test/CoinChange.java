package array.test;

public class CoinChange {

    public static void main(String[] args) {
        int coins[] = {1, 3};
        int tgt = 2;
        System.out.println(countMinCoins(coins, tgt));

    }

    static int MIN = Integer.MAX_VALUE;
    static int COUNT = 0;

    private static int countMinCoins(int[] coins, int tgt) {

        if (tgt == 0) {
            return 0;
        }

        if (tgt < 0) {
            return tgt;
        }

        for (int c : coins) {
            tgt = tgt - c;
            int count = countMinCoins(coins, tgt);
            if (count >= 0) {
                COUNT = COUNT + 1;
                MIN = Integer.min(MIN, COUNT);
            }
        }
        return MIN;
    }
}
