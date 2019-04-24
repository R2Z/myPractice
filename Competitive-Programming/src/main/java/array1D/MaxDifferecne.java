package array1D;

import java.util.Arrays;

public class MaxDifferecne {
	
	public static void main(String[] args) {
		
		 int [] a = {2, 8, 1, 6, 10, 4};
	        findGap(a);
	        findGap2(a);
	}

	private static void findGap2(int[] a) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i : a) {
			if(i > max){
				max = i;
			}
			if (i < min ){
				min = i;
			}
		}
		System.out.println("Max Difference "+ (max-min));
	}

	private static void findGap(int[] a) {
		
		Arrays.sort(a);
		int min = a[0];
		int max = a[a.length-1];
		//System.out.println("Max Difference "+ (max-min));
		
	}

}
