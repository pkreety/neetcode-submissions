class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i =0; i <stones.length; i++){
            pq.add(stones[i]);
        }

        while(pq.size() > 1){
            int num1 = pq.poll();
            int num2 = pq.poll(); 
            if(num1==num2){
                continue;
            }     
            pq.add(Math.abs(num1-num2));      
        }

        return pq.isEmpty()?0:pq.poll();
        
    }
}
