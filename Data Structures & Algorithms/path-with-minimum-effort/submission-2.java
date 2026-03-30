class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dp = new int[m][n];
        for (int[] each : dp)   Arrays.fill(each, Integer.MAX_VALUE);
        dp[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[2]-b[2]);
        pq.offer(new int[]{0,0,0});

        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

        while (!pq.isEmpty()){
            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];
            int effort = current[2];

            if (x == m-1 && y == n-1)
                return dp[x][y];

            // if (effort > dp[x][y])
            //     continue;
            for (int[] d : directions){
                int dx = x + d[0];
                int dy = y + d[1];

                if (dx >=0 && dx < m && dy >= 0 && dy < n){
                    int minEffort = Math.max(effort, Math.abs(heights[x][y] - heights[dx][dy]));
                    if (minEffort < dp[dx][dy]){
                        dp[dx][dy] = minEffort;
                        pq.offer(new int[]{dx, dy, minEffort});
                    }
                }
            }
        }
        return 0;
    }
}