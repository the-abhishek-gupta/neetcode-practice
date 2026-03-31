class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1] - b[1]);
        pq.offer(new int[]{0,0});

        int edges = 0, totalCost = 0;

        while (edges < n){
            int[] current = pq.poll();
            int index = current[0];
            int cost = current[1];
            if (visited[index])
                continue;
            visited[index] = true;
            totalCost += cost;
            for (int i = 0; i < n; i++){
                if (!visited[i]){
                    int newCost = Math.abs(points[index][0] - points[i][0]) + Math.abs(points[index][1] - points[i][1]);
                    pq.offer(new int[]{i, newCost});
                }
            }
            edges++;
        }
        return totalCost;
    }
}
