class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = prices[0], j = 1;
        
        while(j < prices.length) {
            min = Math.min(min, prices[j]);
            maxProfit = Math.max(maxProfit, (prices[j] - min));
            j++;
        }

        return maxProfit;
    }
}
