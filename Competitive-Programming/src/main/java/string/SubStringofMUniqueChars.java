package string;

import java.util.HashMap;
import java.util.Map;

public class SubStringofMUniqueChars {
	
	public static void main(String[] args) {
		
		String str = "KARAPPA";
		finddSubString(str, 2);
	}
	private static void finddSubString(String str, int m){
		
		int s,e;
		int maxLength;
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		map.put(str.charAt(0), 1);
		maxLength = 1;
		char ch;
		
		s=e=0;
		for(int i=1;i<str.length();i++){
			
			ch = str.charAt(i);
			if(map.containsKey(ch)){
				map.put(ch, map.get(ch)+1);
			}else{
				map.put(ch,1);
			}
			
			if(isMaxLengthExceeded(map, m)){
				map.remove(str.charAt(s));
				s++;
			}else{
				e++;
			}
		}
	}

	private static boolean isMaxLengthExceeded(Map<Character,Integer> map,int m){

		return map.keySet().size() > m;
	}
}
