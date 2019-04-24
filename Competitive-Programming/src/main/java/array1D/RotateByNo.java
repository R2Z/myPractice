package array1D;

import java.util.Scanner;

public class RotateByNo {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int rot = s.nextInt();
		int []arr = new int[size];
		
		for(int i = 0;i<size;i++){
			 arr[i]=s.nextInt();
		 }
		
		//simpleRotation(arr, size, rot);
		
		/*for(int i=0;i<rot;i++){
			rotatateLeftByOne(arr, size);
		}
		*/
		
		leftRotate(arr, rot);
		
		for(int i = 0;i<size;i++){
			System.out.print(arr[i]+" ");
		}
	}

	 static void leftRotate(int arr[], int d){
	        int n = arr.length;
	        rvereseArray(arr, 0, d-1);
	        rvereseArray(arr, d, n-1);
	        rvereseArray(arr, 0, n-1);
	    }
	 
	 static void rvereseArray(int arr[], int start, int end){
	        int temp;
	        while (start < end)
	        {
	            temp = arr[start];
	            arr[start] = arr[end];
	            arr[end] = temp;
	            start++;
	            end--;
	        }
	    }
	 
	
	private static void rotatateLeftByOne(int []arr, int size) {
		
		int tmp = arr[0];
		
		for(int i=0;i<size-1;i++){
			arr[i]=arr[i+1];
		}
		
		arr[size-1]=tmp;
	}
	
	
	private static void simpleRotation(int []arr, int size, int rot) {
		
		int []tmp = new int[rot];
		
		for(int i = 0;i<size;i++){
			
			if(i<rot){
				tmp[i]=arr[i];
			}
			
			if((i+rot) >= size){
				arr[i]=tmp[(i+rot)-size];
			}else{
				arr[i]=arr[i+rot];
			}
		}
	}

}
