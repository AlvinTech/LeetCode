package com.alvin.java;

/*贪心算法：如果明天的股价比今天高，我就今天买明天卖;
但是该题先定只能买卖一次，所以你需要遍历找出差值最大的买卖价格。
Best Time to Buy and Sell Stock 
My Submissions
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one 
share of the stock), design an algorithm to find the maximum profit.
*/
public class Best_Time_to_Buy_and_Sell_Stock{
    public int maxProfit(int[] prices) {
        int  profit =0;
        if(prices.length == 0)
            return 0;
        int up = prices[0];
        int low = prices[0];
        for (int i = 0; i < prices.length ;i++ ){
            if(prices[i] > up){
                up = prices[i];
                profit = Math.max(up- low,profit);
            }

            else if(prices[i] < low) {
                low = prices[i];
                up = low;
            }
        }
        return profit;
    }
    public int maxProfit1(int[] prices) {
        int  profit =0;
        for (int i = 0; i < prices.length ;i++ )
            for(int j = i+1 ; j< prices.length;j++){
                if(prices[j] - prices[i] > profit)
                    profit = prices[j] - prices[i] ;
            }
        return profit;
    }
    public static void main(String[] args){
        int[] price = {2,1,2,0,1};
        System.out.println(new Best_Time_to_Buy_and_Sell_Stock().maxProfit(price));
    }
}