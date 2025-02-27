class Solution {
    public int maxProfit(int[] prices) {

        int buy = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0 ; i < prices.length ; i++){

         buy = Math.min(buy , prices[i]);

         int profit = prices[i] - buy;

         maxProfit = Math.max(maxProfit, profit);

        }

        return maxProfit;
        
    }
}