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
     if (intervals.isEmpty()) return true;
     intervals.sort(Comparator.comparingInt(i -> i.start));
     int start = intervals.get(0).start;
     int end = intervals.get(0).end;
     for( int i=1; i <intervals.size(); i++){

        if(intervals.get(i).start<end){
            return false;
        }
        end = Math.max(end, intervals.get(i).end);
     }

        return true;
    }
}
