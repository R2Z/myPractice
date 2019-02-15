package bit;

import java.util.Scanner;

public class PowerOf2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println("Result "+ divBy2(n));
	}
	private static boolean divBy2(int n){
		boolean bool = false;
		
		n = n&(n-1);
		if(n ==0){
			bool = true;
		}
		return bool;
	}
}
