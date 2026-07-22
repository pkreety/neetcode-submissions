class Solution {
    int[][] mem;
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        
        mem = new int[nums.length][nums.length+1];

        return dp(nums, 0, -1);
    }
                                              //  0 1 2 3 4 5  6  7
    public int dp(int[] nums, int i, int j) { // [0,3,1,3,2,3]
        if (i >= nums.length) {  // 2
            return 0;
        }
        if (mem[i][j + 1] != 0) {
            return mem[i][j + 1];
        }
        
        int max = 0;
        if (j == -1 || nums[j] < nums[i]) { 
            max = 1 + dp(nums, i+1, i);   
        } 
        max = Math.max(max, dp(nums, i + 1, j));
        mem[i][j + 1] = max;
        return max;
    }
}
