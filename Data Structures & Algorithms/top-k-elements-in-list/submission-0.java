class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> map = new HashMap(); 
       Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);


       for(int i=0; i<nums.length; i++){
        map.putIfAbsent(nums[i], 0);
        map.put(nums[i],map.get(nums[i])+1);
       }

       for(int key: map.keySet()){
         pq.offer(new int[]{key, map.get(key)});
         if(pq.size()>k){
            pq.poll();

         }
       }

       int[] result = new int[k]; 
        for(int i = k - 1; i >= 0; --i) {
            result[i] = pq.poll()[0];
        }
        return result;
    }
}
