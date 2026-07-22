class Solution {
    
    public int numSquares(int n) {
        Integer[] memo = new Integer[n + 1];
        memo[0] = 0;
        return dfs(n, memo);
        
    }

    public int dfs(int n, Integer[] memo){
        if(n == 0){
            return 0;
        }
        if(memo[n] != null){
            return memo[n];
        }
        int result = n;
        for(int i = 1; i*i <=n; i++){
            result = Math.min(result, 1 + dfs(n-i*i, memo));

        }
        memo[n] = result;
        return result;
    }
}