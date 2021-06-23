package dp;

public class StringEncoding {
    public static void main(String[] args) {
        String num = "124124345232434354323";
        int dp[] = new int[num.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        int count = encodingCount(num.toCharArray(), num.length(), dp);
        System.out.println(count);
        count = countDecoding(num.toCharArray(), num.length());
        System.out.println(count);
    }

    private static int encodingCount(char[] num, int n, int dp[]) {

        if (dp[n] > 0) {
            return dp[n];
        }
        int count = 0;

        if (n == 0 || n == 1) {
            return 1;
        }
        // encode last element , condition not 0
        if (num[n - 1] > '0') {
            count += encodingCount(num, n - 1, dp);
        }

        // encode last two element , condition 1st element 1 or 2 , second element less than 7
        if ((num[n - 2] == '1' || num[n - 2] == '2') && num[n - 1] < '7') {
            count += encodingCount(num, n - 2, dp);
        }

        dp[n] = count;
        return dp[n];
    }

    static int countDecoding(char[] digits, int n) {
        // base cases
        if (n == 0 || n == 1)
            return 1;

        // for base condition "01123" should return 0
        if (digits[0] == '0')
            return 0;

        // Initialize count
        int count = 0;

        // If the last digit is not 0, then
        // last digit must add to
        // the number of words
        if (digits[n - 1] > '0')
            count = countDecoding(digits, n - 1);

        // If the last two digits form a number
        // smaller than or equal to 26,
        // then consider last two digits and recur
        if (digits[n - 2] == '1'
                || (digits[n - 2] == '2'
                && digits[n - 1] < '7'))
            count += countDecoding(digits, n - 2);

        return count;
    }
}
