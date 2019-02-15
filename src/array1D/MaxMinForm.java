package array1D;

public class MaxMinForm {
	
	public static void main(String[] args) {
		
		int arr[] = {1, 2, 3, 4, 5, 6, 7};
		
		int start =0;
		int end = arr.length-1;
		int tmp = -1;
		while(start<end){
			
			tmp = arr[start+1];
			arr[start+1]=arr[end];
			
			start+=2;
		}
	}

}
