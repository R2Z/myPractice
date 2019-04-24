package array1D;

public class SearchInSortedRotatedArray {
	
	public static void main(String[] args) {
		
		int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		
		int key = 3;
		
		
		
	}
	
	static int binarySearch(int arr[] , int l , int r , int key){
		
		int ele = -1;
		
		if( r < l){
			ele = l;
		}else {
			
			int mid = l + (r -l)/2;
			if(key == arr[mid]){
				ele = mid;
			}else if ( key > arr[mid]){
				ele =binarySearch(arr, mid + 1, r, key);
			}else{
				ele =binarySearch(arr, l, mid -1, key);
			}
		}
		
		return ele;
	}
	
	private static int binarySearchOnPivot(int arr[] , int n , int key){
		
		int element = 0;
		
		int pivot = findPivotElement(arr, 0, n-1);
		
		if( pivot == -1){
			element = binarySearch(arr, 0, n-1, key);
		}else if( arr[pivot] == key) {
			element = pivot;
		}else if( arr[0] <= key ){
			element = binarySearch(arr, 0, pivot-1, key);
		}else{
			element = binarySearch(arr, pivot+1, n-1, key);
		}
		return element;
	} 
	
	private static int findPivotElement(int arr[] , int l , int r){
		
		int pivot = -1;
		
		if( r < l){
			pivot = -1;
		}else if ( l ==r ){
			pivot = l;
		}else{
			
			int mid = l + (r-l)/2;
			if( mid < r && arr[mid] > arr[mid+1]){
				pivot = mid;
			}else if( mid > l && arr[mid] < arr[mid -1]){
				pivot = mid -1;
			}else if( arr[l] >= arr[mid]){
				pivot = findPivotElement(arr, l, mid -1);
			}else{
				pivot = findPivotElement(arr, mid+1, r);
			}
			
		}
		
		return pivot;
	}

}
