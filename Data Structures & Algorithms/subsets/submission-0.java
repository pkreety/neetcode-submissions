class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        backtrack(nums, 0, result, new ArrayList());
        return result;
        
    }

    public void backtrack(int[] nums, int start, List<List<Integer>> result, List<Integer> sublist){
        result.add(new ArrayList(sublist));
       for(int i = start; i < nums.length; i++){
        sublist.add(nums[i]);
        backtrack(nums, i + 1, result, sublist);
        sublist.remove(sublist.size() - 1);
       }

       return; 


    }
}
