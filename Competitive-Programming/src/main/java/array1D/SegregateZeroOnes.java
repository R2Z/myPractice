package array1D;

public class SegregateZeroOnes {

	public static void main(String[] args) {

		int arr[] = { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1 };
		int start = 0;
		int end = arr.length - 1;

		while (start < end) {

			if (arr[start] == 1 && arr[end] == 0) {
				swap(arr, start, end);
			} else if (arr[start] == 1 && arr[end] != 0) {
				end--;
			} else {
				start++;
			}
		}

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private static void swap(int arr[], int i, int j) {

		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;

	}
}
