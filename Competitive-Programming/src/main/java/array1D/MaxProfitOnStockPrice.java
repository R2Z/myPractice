package array1D;

public class MaxProfitOnStockPrice {

	public static void main(String[] args) {
		int[] prices = {200, 500, 1000, 700, 30, 400, 900, 400, 50};
        maxProfit(prices);
	}

	private static void maxProfit(int[] prices) {
		
		int SI = prices.length-1;
		int SP = prices[SI];
		int BP = 0;
		int BI = 0;
		int profit = 0;
		int finalSp = 0;
		int finalBp = 0;
		
		for(int i = prices.length-2 ; i >= 0 ; i--){
			BI = i;
			BP = prices[i];
			if(SP > BP && (SP-BP) > profit){
				profit = SP-BP;
				finalSp = SI;
				finalBp = BI;
			}else{
				SP = BP;
				SI = BI;
			}
		}
		System.out.println("profit "+ profit  + " BI " + finalBp+ " SI " + finalSp);
	}
}
