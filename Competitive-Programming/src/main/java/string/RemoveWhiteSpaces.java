package string;

import java.util.Arrays;

public class RemoveWhiteSpaces {

	public static void main(String[] args) {
		String str = "  Hi there, how  are you   doing? ";
		System.out.println(RemoveSpacesWithExtraStorage(str.toCharArray()));
		System.out.println(removeSpaces(str.toCharArray()));

	}

	private static String RemoveSpacesWithExtraStorage(char[] str) {

		int cnt = 0;
		char[] str2 = new char[str.length];
		for (int i = 0; i < str.length; i++) {
			if (str[i] != ' ') {
				str2[cnt] = str[i];
				cnt++;
			}
		}
		return new String(str2);
	}

	private static String removeSpaces(char[] chrArr) {

		int spcCount = 0;

		for (int i = 0; i < chrArr.length; i++) {

			if (chrArr[i] == ' ') {
				spcCount++;
			} else {
				chrArr[i - spcCount] = chrArr[i];
			}
		}

		chrArr = Arrays.copyOf(chrArr, chrArr.length - spcCount);

		return new String(chrArr);

	}

}
