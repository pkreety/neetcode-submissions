class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap(); 
        for(int num: nums){
            if(!map.containsKey(num)){
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);

        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for(int key: map.keySet()){
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] result = new int[k]; 
        int j = 0;
        for(int i = bucket.length - 1; i >= 0; i--){

            if(bucket[i] != null){
                for (int val : bucket[i]) {
                    result[j]= val;
                    j++; 
                    if(j == k) return result;
                }
            }
           
        }

        return result;
        
    }
}
