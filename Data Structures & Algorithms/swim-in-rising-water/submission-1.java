class Solution {
    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean visited[][] = new boolean[m][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[2]-b[2]);
        visited[0][0] = true;
        pq.offer(new int[]{0,0, grid[0][0]});

        while (!pq.isEmpty()){
            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];
            int currentLevel = current[2];
            if (x == m-1 && y == n-1)
                return currentLevel;
            for (int[] d : dirs){
                int dx = d[0] + x;
                int dy = d[1] + y;
                if (dx < 0 || dy < 0 || dx ==m || dy == n || visited[dx][dy])
                    continue;
                visited[dx][dy] = true;
                int level = Math.max(currentLevel, grid[dx][dy]);
                pq.offer(new int[]{dx, dy, level});
            }
        }
        return -1;
    }
}
