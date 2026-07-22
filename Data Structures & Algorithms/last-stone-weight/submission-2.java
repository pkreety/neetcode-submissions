class Solution {

    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a); 

    public int lastStoneWeight(int[] stones) {
        for(int i = 0; i < stones.length; i++){
            queue.offer(stones[i]);
        }

        while(queue.size() > 1){
            int x = queue.poll();
            int y = queue.poll();

            if (x != y) {
                int z =  x - y; 
                queue.offer(z);
            }
        }

        return queue.isEmpty() ? 0 : queue.poll();
        
    }
}
