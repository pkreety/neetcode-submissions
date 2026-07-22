class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList(); 
        backTrack(nums, result, 0, new ArrayList());
        return result;
    }

    public void backTrack(int[] nums, List<List<Integer>> result, int index, List<Integer> subList){
        result.add(new ArrayList(subList));
        

        for(int i = index; i<nums.length; i++){
            if(i!=index && nums[i]==nums[i-1]){
                continue;
            }
            subList.add(nums[i]);
            backTrack(nums, result, i + 1, subList);
            subList.remove(subList.size() - 1); 

        }


    }
}
