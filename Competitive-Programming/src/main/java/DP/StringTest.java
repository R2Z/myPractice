package DP;
import java.util.HashSet;
import java.util.Set;

public class StringTest {
	
	public static void main(String[] args) {
		
		isPangram("The quick brown fox jumps over the lazy dog");
	}

	@SuppressWarnings("unused")
	private static boolean isPangram(String str){
		
		boolean bool = false;
		
		int sumOfsmallChars = 0;
		for(int i=97;i<=122;i++){
			sumOfsmallChars +=i;
		}
		
		str=str.toLowerCase();
		Set<Character> ch = new HashSet<Character>(str.length()-1);
		int sum = 0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i) != ' ' && ch.add(str.charAt(i))){
				System.out.println(str.charAt(i) + " " +(int)str.charAt(i));
				sum+=(int)str.charAt(i);
			}

		}
		
		return sumOfsmallChars == sum;
	}
	
	private static void removeDuplicates(String str){
		
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < str.length(); i++) {
			if(set.add(str.charAt(i))){
				System.out.print(str.charAt(i));
			}
		}
		
	}
	private static void strRevrs(String str) {

		// String str = "Ab,c,de!$";
		char[] s = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			s[i] = str.charAt(i);
		}

		int start = 0;
		int end = str.length() - 1;

		while (start < end) {

			if (isAlphabet(s[start]) && isAlphabet(s[end])) {
				swapString(s, start, end);
				start++;
				end--;
			} else if (isAlphabet(s[start]) && !isAlphabet(s[end])) {
				end--;
			} else if (!isAlphabet(s[start]) && isAlphabet(s[end])) {
				start++;
			} else {
				start++;
				end--;
			}
		}

		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i]);
		}

	}

	private static void swapString(char[] str, int start, int end) {
		char c = str[start];
		str[start] = str[end];
		str[end] = c;
	}

	private static boolean isAlphabet(char c) {

		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'A');

	}
}
