package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstNonRepetingString {

	public static void main(String[] args) {
		System.out.println("" + getNonRepetingChar("ADBCGHIEFKJLADTVDERFSWVGHQWCNOPENSMSJWIERTFB"));
		System.out.println("" + getNonRepetingChar2("ADBCGHIEFKJLADTVDERFSWVGHQWCNOPENSMSJWIERTFB"));
	}

	static Map<Character, Integer> charCountMap = new HashMap<>();
	static Map<Character, Integer> charCountMap2 = new HashMap<>();

	static {
		for (int i = 65; i <= 90; i++) {
			charCountMap.put((char) i, 0);
			charCountMap2.put((char) i, -1);
		}
	}

	private static char getNonRepetingChar2(String str) {
		
		char ch = '*';
		
		for (int i = 0; i < str.length(); i++) {
			if (charCountMap2.containsKey(str.charAt(i))) {
				if(charCountMap2.get(str.charAt(i)) == -1){
					charCountMap2.put(str.charAt(i),i);
				}else{
					charCountMap2.put(str.charAt(i),-2);
				}
				
			} else {
				charCountMap2.put(str.charAt(i), i);
			}
		}
		
		int MIN = Integer.MAX_VALUE;
		for(Entry<Character,Integer> en : charCountMap2.entrySet()){
			if(en.getValue() != -1 && en.getValue() != -2 && en.getValue() < MIN){
				MIN = en.getValue();
				ch = en.getKey();
			}
		}
		
		return ch;
	}
	
	private static char getNonRepetingChar(String str) {

		char ch = '*';

		for (int i = 0; i < str.length(); i++) {
			charCountMap.put(str.charAt(i), charCountMap.get(str.charAt(i)) + 1);
		}

		for (int i = 0; i < str.length(); i++) {
			if (charCountMap.containsKey(str.charAt(i)) && charCountMap.get(str.charAt(i)) == 1) {
				ch = str.charAt(i);
				break;
			}
		}

		return ch;
	}
}
