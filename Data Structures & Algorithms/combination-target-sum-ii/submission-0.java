class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(candidates);
        backTrack(candidates, result, 0, target, new ArrayList());
        return result;     
    }

    public void backTrack(int[] candidates, List<List<Integer>> result, int index, int target, List<Integer> subList) {
        if(target == 0){
            result.add(new ArrayList(subList));
            return;
        }
        if(target<0){
            return; 
        }
        for(int i=index; i <candidates.length ;i++){
             
            // backTrack(candidates, result, i + 1, target - candidates[i], subList); 
             if(i > index && candidates[i] == candidates[i - 1]){
                continue;
            }   
             subList.add(candidates[i]); 
             backTrack(candidates, result, i + 1, target - candidates[i], subList); 
             subList.remove(subList.size() - 1);
        }
    }
}
