package array1D;

import java.util.Arrays;

public class Sumpair {
	public static void main(String[] args) {
		int arr[] = { 5, 4, 6, 9, 3, 7 };
		int sum = 10;
		int l = 0;
		int r = arr.length - 1;
		Arrays.sort(arr);
		while (l < r) {
			if (arr[l] + arr[r] < sum) {
				l++;
			} else if (arr[l] + arr[r] > sum) {
				r--;
			} else {
				System.out.println(arr[l] + " " + arr[r]);
				l++;
			}
		}
	}

}
