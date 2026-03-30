class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    int area = fill(grid, i , j);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }
    private int fill(int[][] arr, int i, int j){
        if (i < 0 || i == arr.length || j < 0 || j == arr[0].length || arr[i][j] == 0)
            return 0;
        arr[i][j] = 0;
        return 1 + fill(arr, i+1, j) + fill(arr, i-1, j) + fill(arr, i, j+1) + fill(arr, i, j-1);
    }
}
