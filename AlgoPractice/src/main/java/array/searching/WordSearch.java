package array.searching;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String search = "ABCCED";

        int rows = board.length;
        int cols = board[0].length;

        boolean found = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == search.charAt(i)) {
                    found = dfs(board, search, i, j, 0);
                }
            }
        }
        System.out.println(found);
    }

    private static boolean dfs(char[][] board, String search, int i, int j, int count) {

        if (count == search.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != search.charAt(count)) {
            return false;
        }

        boolean found = dfs(board, search, i + 1, j, count + 1) ||
                dfs(board, search, i - 1, j, count + 1) ||
                dfs(board, search, i, j + 1, count + 1) ||
                dfs(board, search, i, j - 1, count + 1);
        return found;
    }
}
