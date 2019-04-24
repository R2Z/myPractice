package string;

public class PrintAllPalindromes {
	
	public static void main(String[] args) {
		String str = "anana";
		System.out.println(isPalindrome(str, 0, str.length()-1));
	}
	
	private static boolean isPalindrome(String str , int start , int end){
		
		boolean isPalindrome = true;
		while( start < end){
			if(str.charAt(start) != str.charAt(end)){
				isPalindrome = false;
				break;
			}
			start++;
			end--;
		}
		
		return isPalindrome;
		
	}

}
