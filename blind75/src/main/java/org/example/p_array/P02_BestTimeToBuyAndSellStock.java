package org.example.p_array;

/*
    Best Time to Buy and Sell Stock
    https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class P02_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        var lowestPrice = prices[0];
        var highestPrice = 0;

        for (int i = 1; i < prices.length; i++) {
            var profit = prices[i] - lowestPrice;

            if(profit > highestPrice)
                highestPrice = profit;

            if(prices[i] < lowestPrice)
                lowestPrice = prices[i];
        }

        return highestPrice;
    }
}
