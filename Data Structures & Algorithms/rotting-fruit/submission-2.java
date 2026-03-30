class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int orange = grid[i][j];
                if (orange == 1)
                    fresh++;
                if (orange == 2)
                    queue.offer(new int[]{i, j});
            }
        }
        int ct = 0;
        if (fresh == 0)
            return ct;
        int[][] dir = new int[][]{{-1,0}, {1,0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty() && fresh > 0){
            ct++;
            int len = queue.size();
            for (int i = 0; i < len; i++){
                int[] each = queue.poll();
                for (int[] d : dir){
                    int dx = d[0] + each[0];
                    int dy = d[1] + each[1];
                    if (dx >=0 && dx < m && dy >=0 && dy <n && grid[dx][dy] == 1){
                        grid[dx][dy] = 2;
                        fresh--;
                        queue.offer(new int[]{dx, dy});
                    }
                }
            }
        }
        if (fresh > 0)
            return -1;
        return ct;
    }
}
