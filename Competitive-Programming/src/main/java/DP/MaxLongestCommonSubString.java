package DP;

import java.util.ArrayList;
import java.util.List;

public class MaxLongestCommonSubString {

	public static void main(String[] args) {

		List<String> result = commonSubstring("CLCL", "LCLC");
		for (String string : result) {
			System.out.println(string);
		}
	}

	private static List<String> commonSubstring(String str1, String str2) {

		int max = Integer.MIN_VALUE;
		List<String> reslt = new ArrayList<String>();
		;
		int[][] match = new int[str1.length()][str2.length()];

		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					if (i == 0 || j == 0) {
						match[i][j] = 1;
					} else {
						match[i][j] = match[i - 1][j - 1] + 1;
					}

					if (match[i][j] > max) {
						max = match[i][j];
						reslt = new ArrayList<String>();
						reslt.add(str1.substring(i + 1 - max, i + 1));
					} else if (match[i][j] == max) {
						reslt.add(str1.substring(i + 1 - max, i + 1));
					}
				}
			}
		}
		return reslt;
	}

}
