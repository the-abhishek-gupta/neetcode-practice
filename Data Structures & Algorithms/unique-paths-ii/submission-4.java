class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        for (int i = 0; i < m; i++){
            if (obstacleGrid[i][0] == 1)
                break;
            obstacleGrid[i][0] = -1;
        } 
        for (int i = 0; i < n; i++){
            if (obstacleGrid[0][i] == 1)
                break;
            obstacleGrid[0][i] = -1;
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                int top = 0;
                if (obstacleGrid[i-1][j] < 0)
                    top = obstacleGrid[i-1][j];
                
                int left = 0;
                if (obstacleGrid[i][j-1] < 0)
                    left = obstacleGrid[i][j-1];
                if (obstacleGrid[i][j] == 0)
                    obstacleGrid[i][j] = top + left;
            }
        }
        if (obstacleGrid[m-1][n-1] > 0)
            return 0;
        return obstacleGrid[m-1][n-1] * -1;
    }
}