// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        
        int maxProfit = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            
            int profit = prices[i] - min;
            if (profit> maxProfit) {
                maxProfit = profit;
            }
        }
        
        return maxProfit;
    }
}
