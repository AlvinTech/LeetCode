/**
 * 2014-3-4
 * @author Alvin
 * Question:
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple
 *  transactions at the same time (ie, you must sell the stock before you buy again).
 */

public class Best_Time_to_Buy_and_Sell_Stock_II {

	   public int maxProfit(int[] prices) {
		 	int max = 0;
		 	for(int i =0;i< prices.length-1;i++){
		 		 if(prices[i+1]> prices[i])
		 			 max += prices[i+1]- prices[i];
		 	}
	        return  max;
	    }

}

/**思路：只要明天的股票会涨，我今天就买进，明天就卖出。
 * */
