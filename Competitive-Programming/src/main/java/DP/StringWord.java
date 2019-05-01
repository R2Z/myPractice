package DP;

import java.util.HashSet;
import java.util.Set;

public class StringWord {
	
	
	public static void main(String[] args) {
        Set<String> numbers = new HashSet<String>();
        // Create a lookup for allowed numbers
        for (int i = 1; i <= 26; i++) {
            numbers.add(i +"");
        }

        String input = "2112";

        int len = input.length();

        //All initialized with 0
        long[] dp = new long[len + 1];

        //Base case set as 1 to propogate the count
        dp[len] = 1;

        // Check for last number and set base case
        if (numbers.contains(input.substring(len - 1, len))) {
            dp[len - 1] = 1;
        }

        for (int i = len - 2; i >= 0; i--) {
            //Consider only one digit number
            if(numbers.contains(input.substring(i, i+1))){
                dp[i] += dp[i+1]; //Add the count at i+1
            }
            //Consider two digits number
            if(numbers.contains(input.substring(i, i+1))){
                dp[i] += dp[i+2]; //Add the count at i+2
            }
            
        }
        System.out.println(dp[0]);
    }

}
