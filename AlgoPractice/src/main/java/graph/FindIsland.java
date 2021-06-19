package graph;

public class FindIsland {
    public static void main(String[] args) {
        int M[][] = new int[][]
                {{1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1}};

        int noOfIslands = 0;
        boolean[][] V = new boolean[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (!V[i][j] && M[i][j] != 0) {
                    findNoOfIslands(M, V, i, j);
                    noOfIslands += 1;
                }
            }
        }
        System.out.println(noOfIslands);
    }

    private static void findNoOfIslands(int[][] m, boolean[][] v, int i, int j) {
        // check if curr cell is not visited and not water and board boundaries are not broken
        if (i < 0 || j < 0 || i >= m.length || j >= m[0].length || v[i][j] || m[i][j] == 0) {
            return;
        }

        v[i][j] = true;

        // check with all neighbours
        findNoOfIslands(m, v, i, j + 1); // RIGHT
        findNoOfIslands(m, v, i, j - 1); // LEFT
        findNoOfIslands(m, v, i + 1, j); // UP
        findNoOfIslands(m, v, i - 1, j); // DOWN

        findNoOfIslands(m, v, i + 1, j + 1); // UP RIGHT CORNER
        findNoOfIslands(m, v, i - 1, j + 1); // DOWN RIGHT CORNER
        findNoOfIslands(m, v, i + 1, j - 1); // UP LEFT CORNER
        findNoOfIslands(m, v, i - 1, j - 1); // DOWN LEFT CORNER
    }
}
