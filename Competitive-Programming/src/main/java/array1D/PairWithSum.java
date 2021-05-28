package array1D;

import java.util.HashMap;
import java.util.Map;

public class PairWithSum {

	public static void main(String[] args) {

		int arr[] = { 1, 3, 9, 2 };
		int sum = 5;
		pairSum(arr, sum);
		bruteForce(arr, sum);
		subSetDP(arr, sum);
	}

	private static void subSetDP(int[] A, int sum) {
		boolean[][] solution = new boolean[A.length + 1][sum + 1];		
		// if sum is not zero and subset is 0, we can't make it 
		for(int i=1;i<=sum;i++){
			solution[0][i]=false;
		}
		// if sum is 0 the we can make the empty subset to make sum 0
				for(int i=0;i<=A.length;i++){
					solution[i][0]=true;
				}
		//
		for(int i=1;i<=A.length;i++){
			for(int j=1;j<=sum;j++){				
				//first copy the data from the above row
				solution[i][j] = solution[i-1][j];
				
				//If solution[i][j]==false check if can be made
				if(!solution[i][j] && j>=A[i-1]){
					//solution[i][j] = solution[i][j] || solution[i-1][j-A[i-1]];
					solution[i][j] = solution[i-1][j-A[i-1]];	
				}	
			}
		}	
		
		System.out.println(solution[A.length][sum]);
	}
	private static void bruteForce(int arr[], int sum) {

		int result[] = new int[arr.length];
		;
		boolean found = false;
		int resultSum = 0;

		for (int i = 0; i < arr.length; i++) {
			if (found)
				break;

			result = new int[arr.length];

			for (int j = i; j < arr.length; j++) {
				if (found) {
					break;
				} else {
					resultSum = 0;
					for (int k = 0; k < result.length; k++) {
						resultSum += result[k];
					}
					if (arr[j] < sum) {
						if (arr[j] + resultSum <= sum) {
							result[j] = arr[j];
							if (arr[j] + resultSum == sum) {
								found = true;
							}
						}
					}
				}
			}
		}

		for (int k = 0; k < result.length; k++) {
			System.out.println(" " + result[k]);
		}
	}

	private static void pairSum(int arr[], int sum) {

		Map<Integer, Integer> mp = new HashMap();

		for (int i = 0; i < arr.length; i++) {
			int x = sum - arr[i];
			mp.put(x, arr[i]);
		}

		for (int i = 0; i < arr.length; i++) {
			if (mp.containsKey(arr[i])) {
				System.out.println("Pairs " + arr[i] + " " + mp.get(arr[i]) + " Sum " + sum);
				break;
			}
		}
	}

}
