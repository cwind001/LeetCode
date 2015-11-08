package com.cwind.leetcode.greedy;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/11/8
 * Email: billchen01@163.com
 * #122 Best Time to Buy and Sell Stock II - Medium
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i=prices.length-1; i>0; i--){
            if(prices[i-1]>=prices[i]){
                continue;
            }else {
                maxProfit += prices[i]-prices[i-1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock tester = new BestTimeToBuyAndSellStock();
        int[] prices = {4,2,1,3,1};
        System.out.println(tester.maxProfit(prices));
    }
}
