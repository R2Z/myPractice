package dynamicPrograming;

public class LargestSqrInMat {

	public static void main(String[] args) {

		int[][] mat = { { 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 0, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0 }, { 0, 0, 1, 1, 1 } };

		System.out.println(findLargestSqr(mat, 5, 5));
	}

	private static int findLargestSqr(int[][] mat, int row, int col) {

		int max = 1;

		for (int r = 1; r < row; r++) {
			for (int c = 1; c < col; c++) {
				if (mat[r][c] != 0) {
					mat[r][c] += minOfThree(mat[r][c - 1], mat[r - 1][c], mat[r - 1][c - 1]);
					if (mat[r][c] > max) {
						max = mat[r][c];
					}
				}
			}
		}

		return max;
	}

	private static int minOfThree(int l, int u, int d) {

		int min = l;

		if (u < min) {
			min = u;
		} else if (d < min) {
			min = d;
		}
		return min;
	}
}
