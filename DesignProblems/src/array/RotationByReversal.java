package array;

public class RotationByReversal {

	public static void main(String[] args) {
		
		int rev =3;
		 int arr[] = {1, 2, 3, 4, 5, 6, 7};
		 reverse(arr, 0, rev-1);
		 reverse(arr, rev, arr.length-1);
		 reverse(arr, 0, arr.length-1);
		 for (int i : arr) {
			System.out.print(" "+i);
		}
	}
	
	public static void reverse(int arr[] , int s , int e){
		
		int tmp;
		while( s < e){
			tmp = arr[s];
			arr[s]=arr[e];
			arr[e]=tmp;
			s++;
			e--;
		}
		
	}

}
