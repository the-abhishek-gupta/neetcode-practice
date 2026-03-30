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
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a,b)-> a.start - b.start);
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)-> a.end - b.end);
        for (Interval each : intervals){
            if (!pq.isEmpty()){
                if (pq.peek().end <= each.start)
                    pq.poll();
            }
            pq.offer(each);
        }
        return pq.size();
    }
}
