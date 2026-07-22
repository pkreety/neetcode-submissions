class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList(); 
        backTrack(nums, new ArrayList(), result);
        return result;
    }

    public void backTrack(int[] nums, List<Integer> subList, List<List<Integer>> result){

        if(subList.size() == nums.length){
            result.add(new ArrayList(subList));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(subList.contains(nums[i])){
                continue;
            }
            subList.add(nums[i]); 
            backTrack(nums, subList, result);
            subList.remove(subList.size() - 1);
        }
    }
}
