package array1D;

public class MinElementInRotatedArray {

	public static void main(String[] args) {
		int arr1[] = { 5, 6, 1, 2, 3, 4 };
		int n1 = arr1.length;
		System.out
				.println("The minimum element is " + findMin(arr1, 0, n1 - 1));
	}

	static int findMin(int arr[], int low, int high) {
		// This condition is needed to handle the case when array
		// is not rotated at all
		if (high < low)
			return arr[0];

		// If there is only one element left
		if (high == low)
			return arr[low];

		// Find mid
		int mid = low + (high - low) / 2; /* (low + high)/2; */

		// Check if element (mid+1) is minimum element. Consider
		// the cases like {3, 4, 5, 1, 2}
		if (mid < high && arr[mid + 1] < arr[mid])
			return arr[mid + 1];

		// Check if mid itself is minimum element
		if (mid > low && arr[mid] < arr[mid - 1])
			return arr[mid];

		// Decide whether we need to go to left half or right half
		if (arr[high] > arr[mid])
			return findMin(arr, low, mid - 1);
		return findMin(arr, mid + 1, high);
	}
}
