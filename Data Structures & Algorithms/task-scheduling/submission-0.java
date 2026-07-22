class Solution {

    int[] frequencies = new int[26];
    public int leastInterval(char[] tasks, int n) {
        for(char task: tasks){

            int index = task - 'A';
            frequencies[index]++;
        }
        Arrays.sort(frequencies);
        int maxSlots = frequencies[25] - 1;
        int idle_slots = maxSlots * n;

        for(int i =24; i >= 0 && frequencies[i]>0; i--){
            idle_slots -= Math.min(frequencies[i], maxSlots);
        }
        
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;









        


    }
}
