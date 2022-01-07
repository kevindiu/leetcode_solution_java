// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/submissions/
class Solution {    
    public int maxProfit(int[] prices, int fee) {
        Map<String, Integer> cache = new HashMap<>();
        cache.put(cacheKey(prices.length, true), 0);
        cache.put(cacheKey(prices.length,false), 0);
        
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                boolean brought = (j == 0);
                if (cache.containsKey(cacheKey(i, brought))) {
                    return cache.get(cacheKey(i, brought));
                }

                int maxProfit = 0;

                if (!brought){
                    maxProfit = max(maxProfit, cache.get(cacheKey(i + 1, true)) - prices[i] - fee);
                } else {
                    maxProfit = max(maxProfit, cache.get(cacheKey(i + 1, false)) + prices[i]);
                }

                maxProfit = max(maxProfit, cache.get(cacheKey(i + 1, brought)));

                cache.put(cacheKey(i, brought), maxProfit);
            }
        }
        
        return cache.get(cacheKey(0, false));
    }
    
    private int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }
    
    private String cacheKey(int price, boolean brought) {
        return price + String.valueOf(brought);
    }
}
