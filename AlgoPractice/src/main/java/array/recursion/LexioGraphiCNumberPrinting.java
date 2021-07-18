package array.recursion;

public class LexioGraphiCNumberPrinting {
    public static void main(String[] args) {
        int num = 1000;
        for (int i = 1; i < 10; i++) {
            dfs(i, num);
        }
    }

    private static void dfs(int i, int num) {
        if (i > num) {
            return;
        }
        System.out.println(i);
        for (int j = 0; j < 10; j++) {
            dfs(10 * i + j, num);
        }
    }
}
