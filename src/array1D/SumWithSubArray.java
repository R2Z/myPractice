package array1D;

public class SumWithSubArray {
	
	public static void main(String[] args) {
		
		int arr[] = {1,2,3,7,5};
		int sum = 12;
		//int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
		//int sum = 23;
		getSubArray(arr, sum);
	}

	private static void getSubArray(int[]arr , int sum){
		
		int currSum = arr[0];
		int start = 0;
		
		for (int i=1;i<=arr.length;i++) {
			
			if (currSum > sum) {
				currSum -= arr[start];
				start++;
				if(currSum == sum){
					System.out.println("Sum found at index "+start+" , "+(i-1));
					break;
				}
			}else  if(currSum == sum){
				System.out.println("Sum found at index "+start+" , "+(i-1));
				break;
			}
			currSum +=arr[i];			
		}
		
	}
}
