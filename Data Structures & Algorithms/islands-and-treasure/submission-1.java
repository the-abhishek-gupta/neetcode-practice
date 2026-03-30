class Solution {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
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
        
        while (!queue.isEmpty()){
            int[] node = queue.poll();
            int nodeX = node[0];
            int nodeY = node[1];
            int nodeDistanceFromWater = node[2];

            for (int[] d : dirs){
                int dx = d[0] + nodeX;
                int dy = d[1] + nodeY;
                if (dx < 0 || dx == m || dy < 0 || dy == n || grid[dx][dy] == -1)
                    continue;
                if (grid[dx][dy] > nodeDistanceFromWater){
                    grid[dx][dy] = nodeDistanceFromWater+1;
                    queue.offer(new int[]{dx, dy, nodeDistanceFromWater+1});
                }
            }
        }

    }
}
