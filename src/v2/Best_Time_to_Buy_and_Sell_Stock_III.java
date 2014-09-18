/*
Best_Time_to_Buy_and_Sell_Stock_III
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
public class Best_Time_to_Buy_and_Sell_Stock_III{

    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length == 0)
            return 0;
        int[] history = new int[length];
        int[] furture = new int[length];
        int maxProfit=0;
        int valley = prices[0];
        int peak = prices[length-1];
        for(int i =0 ; i< length;i++){
            valley = Math.min(valley,prices[i]);
            if(i>0)
                history[i] = Math.max(history[i-1],prices[i]-valley);
        }
        for (int i =length-1;i > 0 ; i--) {
            peak = Math.max(peak,prices[i]);
            if(i<length-1)
                furture[i] = Math.max(furture[i+1],peak- prices[i]);
            maxProfit = Math.max(maxProfit,furture[i] + history[i]);

        }
        return maxProfit;
    }
    public static void main(String[] args){
        int[] price = {2,1,2,0,1};
        System.out.println(new Best_Time_to_Buy_and_Sell_Stock_III().maxProfit(price));
    }
}