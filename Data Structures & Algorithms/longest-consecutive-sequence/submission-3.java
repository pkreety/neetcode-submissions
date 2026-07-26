class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int max = 0;
        for(int i=0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                int low = map.containsKey(nums[i] - 1) ? map.get(nums[i] - 1) : 0;
                int high = map.containsKey(nums[i] + 1) ? map.get(nums[i] + 1) : 0;
               
                int count  = low + high + 1;
                 System.out.println(count);
                map.put(nums[i], count);
                System.out.println("i is "+nums[i]+" count "+count);
                
                map.put(nums[i]+ high, count);
                map.put(nums[i]- low, count);
                max = Math.max(max, count);
            } 

        }
        return max;
    }
}


//map  number, count
// 2 - 1
// 3 -  2
// 4 - 2 + 1
// 5 -  3 + 1 = 4