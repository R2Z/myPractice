package array2d;

import java.util.Scanner;

public class SearchElement {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int[][] arr = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		search2(arr, row, 29);
	}

	private static void search(int[][] arr, int row, int el) {

		int j = 0;
		int i = 0;
		while (i != (row - 1) || j != (row - 1)) {
			if (arr[i][j] == el) {
				System.out.println("Element Fount at row " + i + " col " + j);
				break;
			} else if (arr[i][j] > el) {
				j++;
			} else {
				i++;
			}
		}
		System.out.println("Element Not found");
	}

	private static void search2(int[][] mat, int n, int x) {

		int i = 0, j = n - 1;

		while (i < n && j >= 0) {
			if (mat[i][j] == x) {
				System.out.print("n Found at " + i + " " + j);
				return;
			}
			if (mat[i][j] > x)
				j--;
			else
				i++;
		}

		System.out.print("n Element not found");
		return;

	}

}
