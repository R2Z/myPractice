package dp;

public class CoinChange {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5};
        int sum = 17;

        int waysToPay = howSumCombination(arr, sum, 0);
        int waysToPay2 = howSumPermutation(arr, sum);
        System.out.println(waysToPay + " - " + waysToPay2);

    }

    // find combination
    private static int howSumCombination(int[] arr, int sum, int startIndex) {

        if (sum == 0) {
            return 1;
        }

        if (sum < 0) {
            return 0;
        }

        int noOfWays = 0;
        for (int i = startIndex; i < arr.length; i++) {
            noOfWays += howSumCombination(arr, sum - arr[i], startIndex++);
        }
        return noOfWays;
    }

    private static int howSumPermutation(int[] arr, int sum) {

        if (sum == 0) {
            return 1;
        }

        if (sum < 0) {
            return 0;
        }

        int noOfWays = 0;
        for (int i = 0; i < arr.length; i++) {
            noOfWays += howSumPermutation(arr, sum - arr[i]);
        }
        return noOfWays;
    }
}
