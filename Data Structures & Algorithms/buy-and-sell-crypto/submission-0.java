class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int minProfit = Integer.MAX_VALUE;
        int profit = 0;

        for(int i =0; i < prices.length; i++){
            if(minProfit > prices[i]){
                minProfit = prices[i];
            
            }
            profit = Math.max(profit, prices[i]- minProfit);

        }
        return profit;
    }
}
