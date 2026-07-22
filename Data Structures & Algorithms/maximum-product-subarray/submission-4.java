class Solution {
    public int maxProduct(int[] nums) {
        int max_so_far = nums[0];
        int min_so_far = nums[0]; 
        int result = nums[0];

        for(int i =1; i < nums.length; i++){
            int current = nums[i]; // -2 
            int maxWithPreviousMax = current * max_so_far;
            int maxWithPreviousMin = current * min_so_far;
            int tempMax = Math.max(maxWithPreviousMax, maxWithPreviousMin);
            max_so_far = Math.max(current, tempMax);
            result = Math.max(max_so_far, result);
            int tempMin = Math.min(maxWithPreviousMax, maxWithPreviousMin);
            min_so_far = Math.min(current, tempMin);

        }
      return result;

        
    }
}
