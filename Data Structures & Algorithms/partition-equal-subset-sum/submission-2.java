class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0; 
        for(int i =0; i< nums.length; i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int target = sum/2; 
        Boolean[][] memo = new Boolean[nums.length + 1][target + 1];
        return checkTarget(target, nums, 0, 0, memo); // [1,2,3,4]
        
    }

    public boolean checkTarget(int target, int[] nums, int sum, int index, Boolean[][] memo){
        if(sum==target){
            memo[index][sum] = true;
            return true; 
        }

        if(sum > target || index >= nums.length){
            return false;
        }

        if (memo[index][sum] != null)
            return memo[index][sum];
        for(int i =index; i <nums.length; i++){
          sum+= nums[i];// 1, 3, 7
          
          if(checkTarget(target, nums, sum, i + 1, memo)){
            memo[index][sum] = true;
            return true;
          }
          
          sum-= nums[i]; // 3
        }
        memo[index][sum] = false;
        return false;

    }
}
