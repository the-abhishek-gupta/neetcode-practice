class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        int last = intervals[0][1];
        int ct = 0;
        for (int i = 1; i < intervals.length; i++){
            int[] in = intervals[i];
            if (in[0] < last){
                last = Math.min(last, in[1]);
                ct++;
            }
            else
                last = in[1];
        }
        return ct;
        
    }
}
