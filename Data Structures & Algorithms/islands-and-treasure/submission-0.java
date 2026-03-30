class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 0)
                    queue.offer(new int[]{i, j, 0});
            }
        }
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!queue.isEmpty()){
            for (int i = queue.size(); i > 0; i--){
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];
                int val = cell[2];

                for (int[] d : dirs){
                    int dx = x + d[0];
                    int dy = y + d[1];
                    int dv = val+1;

                    if (dx >= 0 && dx < m && dy>=0 && dy<n && grid[dx][dy] == 2147483647){
                        grid[dx][dy] = dv;
                        queue.offer(new int[]{dx, dy, dv});
                    }
                }

            }
        }
    }
}
