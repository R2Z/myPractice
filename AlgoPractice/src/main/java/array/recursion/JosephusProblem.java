package array.recursion;

public class JosephusProblem {
    public static void main(String[] args) {
        int knights = 5;
        int k = 3;
        System.out.println(solve(knights, k));
    }

    private static int solve(int knights, int k) {
        if (knights == 1) {
            return 0;
        }
        int x = solve(knights - 1, k);
        return (x + knights) % k;
    }
}
