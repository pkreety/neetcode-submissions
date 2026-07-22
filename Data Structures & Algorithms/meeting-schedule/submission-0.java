/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() == 0){
            return true;
        }
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        //Arrays.sort(intervals, (p1, p2) -> p1.start-p2.start);

        // Arrays.sort(intervals, Comparator.comparing(interval -> interval.start)); 
        int lastEnd = intervals.get(0).end;
        for(int i=1; i <intervals.size(); i++){
            if(lastEnd > intervals.get(i).start){
                return false;
            }else {
                lastEnd = Math.max(lastEnd, intervals.get(i).end);
            }

        }
        return true;
    }
}
