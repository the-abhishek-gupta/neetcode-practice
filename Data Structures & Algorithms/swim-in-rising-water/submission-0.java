class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> a[2] - b[2]);
        queue.offer(new int[]{0,0, grid[0][0]});
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int min = grid[0][0];
        while (!queue.isEmpty()){
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            min = node[2];
            if (x == m-1 && y == n-1)
                return min;
            for (int[] d : directions){
                int dx = d[0] + x;
                int dy = d[1] + y;
                if (dx >= 0 && dx < m && dy >= 0 && dy < n && !visited[dx][dy]){
                    visited[dx][dy] = true;
                    queue.offer(new int[]{dx,dy, Math.max(min, grid[dx][dy])});
                }
            }
        }
        return min;
    }
}
