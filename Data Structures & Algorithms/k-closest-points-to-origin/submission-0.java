class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> (a[0]*a[0]+a[1]*a[1]) - (b[0]*b[0]+b[1]*b[1]));
        for (int[] each : points)
            pq.offer(each);
        int[][] ans = new int[k][2];
        for (int i = 0; i <k;i++){
            int[] p = pq.poll();
            ans[i][0] = p[0];
            ans[i][1] = p[1];
        }
        return ans;

    }
}
