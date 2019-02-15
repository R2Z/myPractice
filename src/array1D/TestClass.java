package array1D;

import java.util.Scanner;

class TestClass {

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int b = 0, c = 0;
		for (int i = 0; i < t; i++) {
			int n = s.nextInt();
			int k = s.nextInt();
			int a[] = new int[n];
			for (int j = 0; j < n; j++) {
				a[j] = s.nextInt();
			}
			b = a[0];
			for (int m = 1; m < n; m++) {
				if (a[m] < b)
					b = a[m];
			}
			if (k <= b)
				c = 0;
			else
				c = k - b;
			System.out.println(c);
		}
	}
}
