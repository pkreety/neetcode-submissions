class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> b-a);

        int start = 0; 
        int end= k - 1;

        for(int i =0; i < k  ;i ++){
            queue.offer(nums[i]);
        }
        result[start] = queue.peek();

        while(end < nums.length - 1){
            queue.remove(nums[start]);
            start++;
            end++;
            queue.offer(nums[end]);
            result[start] = queue.peek();
            
        }
        return result;
    }
}