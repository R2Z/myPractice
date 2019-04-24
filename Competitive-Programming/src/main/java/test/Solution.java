package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		
		int arr[] = {2,1,5,1};
		int sum = 4;
		coinChangeProblem(arr, sum);
		
	}

	private static void Sum2() {
		int arr[] = { 5, 4, 6, 9, 3, 7 };
		int sum = 10;

		int l = 0;
		int r = arr.length - 1;
		Arrays.sort(arr);

		while (l < r) {
			if (arr[l] + arr[r] < sum) {
				l++;
			} else if (arr[l] + arr[r] > sum) {
				r--;
			} else {
				System.out.println(arr[l] + " " + arr[r]);
				l++;
			}
		}
	}

	public static void sum() {
	    int input[] = {1, 3, 9, 2};
	    int sum = 5;
	    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	    int diff = 0;
	    
	    for(int y = 0 ; y < input.length ; y ++){
	      diff = sum - input[y];
	      
	      if(map.containsKey(input[y])){
	          System.out.print("Pair "+ diff + " " + input[y] + " index "+ y + " " + map.get(input[y]) );
	      }else{
	      
	         map.put(diff, y);
	      }
	      
	    }
	  }
	private static void coinChangeProblem(int[] arr, int op) {

		int col = op + 1;
		int row = arr.length + 1;

		int[][] sol = new int[row][col];

		// set first column value to 0
		for (int i = 0; i < col; i++) {
			sol[0][i] = 0;
		}

		// set 1 row value to 0
		for (int i = 0; i < row; i++) {
			sol[i][0] = 1;
		}

		for (int i = 1; i < row-1; i++) {
			for (int j = 1; j < col-1; j++) {
				// coin value is greater than output col then use previous
				if (i > j) {
					sol[i][j] = sol[i - 1][j];
				} else {
					sol[i][j] = sol[i - 1][j] + sol[i][j - arr[i - 1]];
				}
			}
		}
		System.out.println(sol[row - 1][col - 1]);
	}
}
