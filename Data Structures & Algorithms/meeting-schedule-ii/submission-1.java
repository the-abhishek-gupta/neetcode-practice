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
        Collections.sort(intervals, (a,b) -> a.start - b.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Interval each : intervals){
            if (pq.isEmpty())
                pq.offer(each.end);
            else{
                int currentEnd = pq.peek();
                if (currentEnd <= each.start)
                    pq.poll();
                pq.offer(each.end);
            }
        }
        return pq.size();
    }
}
