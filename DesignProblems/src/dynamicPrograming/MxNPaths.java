package dynamicPrograming;

public class MxNPaths {

	public static void main(String[] args) {


		System.out.println(findNoOfPaths( 4, 4, 2, 3));
	}

	private static int findNoOfPaths(int row, int col, int x, int y) {

		int[][] resultMat = new int[row][col];

		for (int r = 0; r < row; r++) {
			resultMat[r][0] = 1;
		}

		for (int c = 0; c < col; c++) {
			resultMat[0][c] = 1;
		}

		for (int r = 1; r < row; r++) {
			for (int c = 1; c < col; c++) {
				resultMat[r][c] = resultMat[r - 1][c] + resultMat[r][c - 1];
			}
		}

		return resultMat[x ][y];
	}

}
