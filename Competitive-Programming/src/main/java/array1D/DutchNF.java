package array1D;

public class DutchNF {

	public static void main(String[] args) {
		
		int []arr = {0,0,2,2,1,0,2,1,0,2,1,0,2,1,0,0,2,1,2,0,2,1,2};
		segZerpOnesTwos(arr);
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}

	private static void segZerpOnesTwos(int[] arr) {

		int mid = 0;
		int start = 0;
		int end = arr.length-1;

		while (mid <= end) {
			if (arr[mid] == 0) {
				swap(arr, start, mid);
				mid++;
				start++;
			} else if (arr[mid] == 1) {
				mid++;
			} else if (arr[mid] == 2) {
				swap(arr, mid, end);
				end--;
			}
		}
	}
	
	private static void swap(int[] arr, int start, int end) {

		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;

	}
}
