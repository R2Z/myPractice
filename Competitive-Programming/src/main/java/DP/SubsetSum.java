package DP;


public class SubsetSum {
    private static boolean isSubsetSum(final int set[], int n, int sum) {
        final boolean subset[][] = new boolean[sum + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            subset[0][i] = true;
        }
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1]) {
                    subset[i][j] = subset[i][j] ||
                            subset[i - set[j - 1]][j - 1];
                }
            }
        }
        return subset[sum][n];
    }

    public static void main(String args[]) {
        int set[] = {3, 34, 4, 12, 5, 2};
        if (isSubsetSum(set, set.length, 9)) {
            System.out.println("Found a subset with given sum");
        } else {
            System.out.println("No subset with given sum");
        }
    }
}
