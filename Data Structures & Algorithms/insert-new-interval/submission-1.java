class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> result = new ArrayList<>();
        int start =  newInterval[0]; 
        int end = newInterval[1]; 
        int i = 0;

        while(i < intervals.length && intervals[i][1] < start){ // before merge 
            result.add(intervals[i]);
            i++;
        }
        
        /// merge 
        while(i < intervals.length && intervals[i][0] <= end){
            start = Math.min(intervals[i][0], start);
            end = Math.max(intervals[i][1], end);
            i++;
        }
        result.add(new int[]{start, end});

        while(i < intervals.length){ // after merge 
            result.add(intervals[i]);
            i++;
        }

       
        return result.toArray(new int[0][]);
    }
}
