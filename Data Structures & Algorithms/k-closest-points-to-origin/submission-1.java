class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]));
        for (int[] each : points)
            pq.offer(each);
        int[][] ans = new int[k][2];
        while (k-- > 0){
            int[] top = pq.poll();
            ans[k][0] = top[0];
            ans[k][1] = top[1];
        }
        return ans;
    }
}
