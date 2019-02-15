package array1D;

public class SegPosNegNum {

	public static void main(String[] args) {
		int[] arr = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
		segPosFirst(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private static void segPosFirst(int[] arr) {

		int start = 0;
		int end = arr.length - 1;

		while (true) {

			while (arr[start] > 0 && start < end) {
				start++;
			}

			while (arr[end] < 0 && start < end) {
				end --;
			}

			if(start < end){
				swap(arr, start, end);
			}else{
				break;
			}
		}
	}

	private static void segNegFirst(int[] arr) {

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

	private static void swap(int[] arr, int start, int end) {

		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;

	}

}
