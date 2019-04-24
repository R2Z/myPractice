package array1D;

public class Fibonacci {

	public static void main(String[] args) {

		int fibFor = 1000;

		long arr[] = new long[fibFor + 1];
		arr[0] = 0;
		arr[1] = 1;

		for (int i = 2; i <= fibFor; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}

		System.out.print(arr[fibFor]);

	}
}
