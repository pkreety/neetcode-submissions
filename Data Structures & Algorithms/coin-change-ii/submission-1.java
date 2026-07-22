class Solution {
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1]; // [1,2,3]
        dp[0] = 1; 
               for(int coin: coins){ // [1,2,3]
                for(int i = coin; i < amount + 1; i ++){
                     // 1
                    dp[i] = dp[i] + (dp[i - coin]);  // dp[3 - 1] dp[2 -1 ]1
                    //System.out.println("i is "+ i + " dp is  " + dp[i]);
                
                }
                

               } 

        return dp[amount] > 0 ? dp[amount] : 0;
    }
}

