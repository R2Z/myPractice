package string;

public class ReverseString {
	public static void main(String[] args) {
		
		
		String str = "Hello Rajnish how are you";
		char[] charArr = str.toCharArray();
		System.out.println(str);

		int start = 0;
		int end = str.length() - 1;

		reverseString(charArr, start, end);

		for (int i = 0; i < charArr.length; i++) {
			System.out.print(charArr[i]);
		}

		start = 0;
		for (int i = 0; i < charArr.length; i++) {

			if (charArr[i] == ' ' ) {
				reverseString(charArr, start, i - 1);
				start = i +1;
			} else if(i == charArr.length-1){
				reverseString(charArr, start, i);
			}
		}

		System.out.print(" ");
		System.out.print("Reverse String ==> ");

		for (int i = 0; i < charArr.length; i++) {
			System.out.print(charArr[i]);
		}

	}

	private static void reverseString(char[] charArr, int start, int end) {

		while (start < end) {
			swap(charArr, start, end);
			start++;
			end--;
		}

	}

	private static void swap(char[] charArr, int x, int y) {

		char tmp = charArr[x];
		charArr[x] = charArr[y];
		charArr[y] = tmp;
	}
}
