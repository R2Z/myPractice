package dp;

public class NumWithSquares {
    public static void main(String[] args) {
        int Num = 200;

        int i = 1;
        while (i * i <= Num) {
            i++;
        }
        int minSquares = findMinSquares(Num, i - 1);
        System.out.println(minSquares);
    }

    private static int findMinSquares(int s, int n) {
        if (s == 0 || s == n * n) {
            return 1;
        }
        if (s < n * n) {
            return findMinSquares(s, n - 1);
        }
        return 1 + findMinSquares(s - (n * n), n - 1);
    }
}
