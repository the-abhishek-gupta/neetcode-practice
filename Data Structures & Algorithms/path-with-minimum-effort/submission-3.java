class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] visited = new int[m][n];
        for (int[] each : visited){
            Arrays.fill(each, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> a[2]-b[2]);
        queue.offer(new int[]{0,0,0});

        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        while(! queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int cost = current[2];
            if (x == m-1 && y == n-1)
                return cost;
            if (cost > visited[x][y])
                continue;
            for (int[] d : dirs){
                int dx = x + d[0];
                int dy = y + d[1];
                if (dx < 0 || dy < 0 || dx == m || dy == n)
                    continue;
                int diff = Math.max(cost, Math.abs(heights[x][y] - heights[dx][dy]));
                if (diff < visited[dx][dy]){
                    visited[dx][dy] = diff;
                    queue.offer(new int[]{dx, dy, diff});
                }
            }
        }
        return 0;
    }
}