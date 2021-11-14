package array.recursion;

public class LexiGraphicNumbers {
    public static void main(String[] args) {
        int num = 100;
        for (int i = 1; i <= 9; i++) {
            dfs(i, num);
        }
    }

    private static void dfs(int curr, int num) {
        if (curr > num) {
            return;
        }
        System.out.println(curr);
        for (int i = 0; i <= 9; i++) {
            dfs(curr * 10 + i, num);
        }

    }
}
