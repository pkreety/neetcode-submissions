class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int numSquares(int n) {
        return dfs(n);
    }

    public int dfs(int n){
        if(n == 0){
            return 0;
        }
        if (memo.containsKey(n)) return memo.get(n);
        int res = n; 
        for(int i =1; i * i <= n; i++){
            res = Math.min(res, 1 + dfs(n - i*i));
        }
        memo.put(n, res);
        return res;
    }
}