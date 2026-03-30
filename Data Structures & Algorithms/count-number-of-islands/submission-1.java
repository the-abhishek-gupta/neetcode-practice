class Solution {
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ct = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1'){
                    ct++;
                    traverse(grid, i, j);
                }
            }
        }
        return ct;
    }
    private void traverse(char[][] grid, int i, int j){
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';

        for (int[] d : dir){
            int dx = d[0];
            int dy = d[1];
            traverse(grid, i + dx, j+dy);
        }
    }
}
