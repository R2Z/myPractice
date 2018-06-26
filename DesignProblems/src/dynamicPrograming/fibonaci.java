package dynamicPrograming;

public class fibonaci {

	public static void main(String[] args) {

		long num = 5000;
		long t1 = System.currentTimeMillis();
		//System.out.println(fib(num));
		System.out.println((System.currentTimeMillis() - t1) );

		long memo[] = new long[(int) num + 1];
		memo[1] = 1;
		memo[2] = 1;

		t1 = System.currentTimeMillis();
		System.out.println(fib(num,memo));
		System.out.println((System.currentTimeMillis() - t1));
		
		t1 = System.currentTimeMillis();
		System.out.println(fibBU(num));
		System.out.println((System.currentTimeMillis() - t1));
	}

	public static long fib(long n) {

		long result = 0;
		if (n == 1 || n == 2) {
			result = 1;
		} else {
			result = fib(n - 1) + fib(n - 2);
		}
		return result;
	}

	public static long fib(long n, long[] memo) {

		int len = (int) n;
		long result = 0;

		if (memo[len] != 0)
			return memo[len];
		if (len == 1 || len == 2)
			result = 1;
		else {
			result = fib(len - 1, memo) + fib(len - 2, memo);
			memo[len] = result;
		}
		return result;
	}
	
	public static long fibBU(long n) {

		if (n == 1 || n == 2)
	        return 1;
	    long []bottom_up =  new long[(int) n + 1];
	    bottom_up[1] = 1;
	    bottom_up[2] = 1;
	    for (int i = 3 ; i < n+1;i++){
	    	 bottom_up[i] = bottom_up[i-1] + bottom_up[i-2];
	    }
	    return bottom_up[(int)n];
	}
}
