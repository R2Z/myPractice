package alltests;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RotationsCount {

	public static void main(String[] args) {
		
		int arr[] = {15, 18, 2, 3, 6, 12};
		
		int min = Integer.MAX_VALUE;
		int index = -1;
		
		for(int i=0;i<arr.length;i++){
			if(arr[i]<min){
				min= arr[i];
				index = i;
			}
		}
		System.out.println(index);
	}
	
	private static int countRotation(int arr[] , int left, int right){
		
		int noOfRotations = -1;
		
		int mid = left + (right-left)/2;
		
		if(arr[right]> arr[mid]){
			countRotation(arr, left, mid-1);
		}else{
			countRotation(arr, left, right);
		}
		
		return noOfRotations;
	}

}
