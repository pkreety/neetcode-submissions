class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList(); 
        backTrack(nums, 0, new ArrayList(), result);
        return result;
    }

    public void backTrack(int[] nums, int index, List<Integer> subList, List<List<Integer>> result){

        if(subList.size() == nums.length){
            result.add(new ArrayList(subList));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(subList.contains(nums[i])){
                continue;
            }
            subList.add(nums[i]); 
            backTrack(nums, i+1, subList, result);
            subList.remove(subList.size() - 1);
        }
    }
}
