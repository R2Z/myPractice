package string;

import java.util.Arrays;

public class FirstNonRepeatingChar {
	
	public static void main(String[] args) {
		
		String str = "ADBCGHIEFKJLADTVDERFSWVGHQWCNOPENSMSJWIERTFB";
		firstNonRepeatingChar(str);
	}
	
	private static void firstNonRepeatingChar(String str){
		
		int charArr[] = new int[256];
		Arrays.fill(charArr, -1);
		
		for(int i=0;i<str.length();i++){
			if(charArr[str.charAt(i)] == -1){
				charArr[str.charAt(i)] = i;
			}else {
				charArr[str.charAt(i)] = -2;
			}
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0;i<charArr.length;i++){
			if(charArr[i] != -1 && charArr[i] != -2){
				if(charArr[i] < min){
					min = charArr[i];
				}
			}
		}
		System.out.println(str.charAt(min));
	}

}
