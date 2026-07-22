class Solution {
    private Map<Integer, Integer> memo;
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums); 
        memo = new HashMap<>();
        memo.put(0, 1);
        return findCombination(nums, target);      
    }

    public int findCombination(int[] nums, int sum){

        if(sum == 0){
            return 1;
        }
        if (memo.containsKey(sum)) {
            return memo.get(sum);
        }
        int result = 0; 
        for(int i = 0; i < nums.length; i++){
            if(sum < nums[i]){
                break;
            }
            result += findCombination(nums, sum - nums[i]);

        }

        memo.put(sum, result);

        return result;

    }


}