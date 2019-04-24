package bit;

import java.util.Scanner;

public class DivBy3 {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		System.out.println(" Result "+ divBy3CharSum(str));
		System.out.println(" Result "+ divBy3EvenOddSetBit(str));
	}

	private static boolean divBy3CharSum(String str){
		
		boolean bool = false;
		char val = 0;
		for(int i=0;i<str.length();i++){
			val += +str.charAt(i);
		}
		if(val % 3 == 0){
			bool = true;
		}
		return bool;
	}
	
	private static boolean divBy3EvenOddSetBit(String str){
		
		boolean bool = false;
		int num = Integer.valueOf(str);
		int eCount=0;
		int oCount = 0;
		if(num == 0){
			bool = true;
		}else if(num == 1){
			bool = false;
		}else{
			while(num != 0){
				if( (num & 1)  == 0){
					oCount++;
				}
				num = num>>1;
				if( (num & 1)  == 0){
					eCount++;
				}
				num = num>>1;
			}
			
			if((oCount - eCount)%3 ==0){
				bool = true;
			}
		}
		return bool;
	}
}
