class Solution {
    public int maxProfit(int[] prices) {

        int minUntilNow = Integer.MAX_VALUE;
        int maxProfit = 0; 

        for(int i=0; i <prices.length; i++){
            if(prices[i] < minUntilNow){
                minUntilNow=prices[i];
                continue;
            }
            int profit = prices[i] - minUntilNow;
            maxProfit = Math.max(profit, maxProfit);


        }
        return maxProfit;
        
    }
}
