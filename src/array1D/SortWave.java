package array1D;

public class SortWave {
	
	public static void main(String[] args) {
		
		int arr[] = {10, 90, 49, 2, 1, 5, 23};
        int n = arr.length;
        sortInWave(arr);
        for (int i : arr)
            System.out.print(i+" ");
	}
	
	private static void sortInWave(int arr[]){
		
		for(int i=0;i<arr.length;i+=2){
			if(i>0 && arr[i-1] > arr[i]){
				swap(arr, i-1, i);
			}
			
			if(i<arr.length-1 && arr[i] < arr[i+1]){
				swap(arr, i, i+1);
			}
		}
	}
	
	private static void swap(int arr[], int i, int j){
		int tmp;
		tmp= arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}

}
