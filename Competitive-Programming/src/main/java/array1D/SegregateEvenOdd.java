package array1D;

public class SegregateEvenOdd {
	
	public static void main(String[] args) {
		
		int arr[] = {12, 34, 45, 9, 8, 90, 3,4,50,7};
		int start = 0;
		int end = arr.length-1;
		
		while(start < end){
			
			if(arr[start]%2!=0 && arr[end]%2 ==0){
				swap(arr, start, end);
			}else if(arr[start]%2==0){
				start++;
			}else if(arr[end]%2!=0){
				end--;
			}
		}
		
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}

	private static void swap(int []arr, int start, int end){
		int tmp = arr[start];
		arr[start]= arr[end];
		arr[end]=tmp;
	}
}
