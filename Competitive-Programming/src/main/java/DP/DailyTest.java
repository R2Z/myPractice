package DP;
public class DailyTest {

	public static void main(String[] args) {

		
	
	}
	
	static void rearrange(int arr[], int n) {
		// initialize index of first minimum and first
		// maximum element
		int max_idx = n - 1, min_idx = 0;

		// store maximum element of array
		int max_elem = arr[n - 1] + 1;

		// traverse array elements
		for (int i = 0; i < n; i++) {
			// at even index : we have to put maximum element
			if (i % 2 == 0) {
				arr[i] += (arr[max_idx] % max_elem) * max_elem;
				max_idx--;
			}

			// at odd index : we have to put minimum element
			else {
				arr[i] += (arr[min_idx] % max_elem) * max_elem;
				min_idx++;
			}
		}

		// array elements back to it's original form
		for (int i = 0; i < n; i++)
			arr[i] = arr[i] / max_elem;
	}

	private static void threewayPartition(int arr[], int low, int high) {

		int start = 0;
		int end = arr.length - 1;
		for (int i = 0; i < end;) {

			if (arr[i] < low) {
				swap(arr, i, start);
				i++;
				start++;
			} else if (arr[i] > high) {
				swap(arr, i, end);
				end--;
			} else {
				i++;
			}

		}

	}

	private static void segZeroOneandTwo(int arr[]) {

		int start = 0;
		int mid = 0;
		int end = arr.length - 1;

		while (mid <= end) {

			if (arr[mid] == 0) {
				swap(arr, start, mid);
				start++;
				mid++;
			} else if (arr[mid] == 1) {
				mid++;
			} else if (arr[mid] == 2) {
				swap(arr, mid, end);
				end--;
			}

		}

	}

	private static void segNegPosNos(int arr[]) {

		int start = 0;
		int end = arr.length - 1;

		while (true) {

			while (arr[start] < 0 && start < end) {
				start++;
			}

			while (arr[end] > 0 && start < end) {
				end--;
			}

			if (start < end) {
				swap(arr, start, end);
			} else {
				break;
			}
		}
	}

	private static void swap(int arr[], int start, int end) {

		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;
	}

	private static int binSearch(int arr[], int val, int start, int end) {

		if (end - start <= 1) {
			if (arr[start] == val) {
				return start;
			} else if (arr[end] == val) {
				return end;
			} else {
				return -1;
			}
		}

		int mid = start + (end - start) / 2;

		if (arr[mid] > val) {
			return binSearch(arr, val, start, mid);
		} else {
			return binSearch(arr, val, mid, end);
		}
	}

}
