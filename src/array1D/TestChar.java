package array1D;

import java.util.HashMap;
import java.util.Map;

public class TestChar {
	
	public static void main(String[] args) {
		String [] str = {"apple","racecars","abadba"};
		char[] cr = {'a','e','d'};
		
		for (int i=0;i<str.length;i++) {
			if(cr[i]==matched(str[i])){
				System.out.println("Matched for " +str[i]);
			}else{
				System.out.println("Not Matched for " +str[i]);
			}
		}
		
	}

	private static char matched(String str){
		char ch = 'x';
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i=0;i<str.length();i++){
			if(map.containsKey(str.charAt(i))){
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			}else{
				map.put(str.charAt(i), 1);
			}
		}
		
		for(int i=0;i<str.length();i++){
			ch = str.charAt(i);
			if(map.get(ch) ==1){
				break;
			}
		}
		
		return ch;		
	}
	
}
