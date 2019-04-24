package search;

public class BinarySearch {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 5, 7, 9, 10, 50, 66 };
		System.out.println(binSearch(arr, 50, 0, arr.length - 1));
	}

	private static int binSearch(int[] arr, int value, int start, int end) {

		if (end - start <= 1) {
			if (value == arr[start]) {
				return start;
			} else if (value == arr[end]) {
				return end;
			} else {
				return -1;
			}
		}

		int mid = start + (end - start) / 2;

		if (arr[mid] > value) {
			return binSearch(arr, value, 0, mid);
		} else {
			return binSearch(arr, value, mid, end);
		}

	}

}
