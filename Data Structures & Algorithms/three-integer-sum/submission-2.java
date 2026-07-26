class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i]== nums[i - 1]){
                continue;
            }

            int low = i+1; 
            int high = nums.length - 1;

            while(low < high) {
                int total = nums[i] + nums[low] + nums[high];
                if(total > 0){
                high--;
                } else if(total < 0){
                    low++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while(low < high && nums[low] == nums[low + 1]) low++;
                    low++;
                }


            }
        }
        return result;
        
    }
}
