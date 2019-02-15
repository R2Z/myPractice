package alltests;

public class RotateArray {

	public static void main(String[] args) {

		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int rot = 3;
		reverse(arr, 0, rot-1);
		reverse(arr, rot, arr.length-1);
		reverse(arr, 0, arr.length-1);

		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	static void  reverse(int a[], int start, int end) {
		int i;
		int temp;
		while (start < end) {
			temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
	}

	private static int gcd(int a, int b) {

		int gcd = 1;
		for (int i = 1; i <= a && i <= b; i++) {
			if (a % i == 0 && b % i == 0) {
				gcd = i;
			}
		}
		return gcd;

	}
}
