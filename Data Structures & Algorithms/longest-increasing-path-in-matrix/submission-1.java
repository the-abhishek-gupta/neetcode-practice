class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] outdegree = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] d : dirs) {
                    int x = i + d[0];
                    int y = j + d[1];
                    
                    if (x >= 0 && x < m && y >= 0 && y < n 
                        && matrix[x][y] > matrix[i][j]) {
                        outdegree[i][j]++;
                    }
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (outdegree[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int length = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            length++;

            for (int s = 0; s < size; s++) {
                int[] cell = q.poll();
                int i = cell[0], j = cell[1];

                for (int[] d : dirs) {
                    int x = i + d[0];
                    int y = j + d[1];

                    // reverse direction: smaller neighbor
                    if (x >= 0 && x < m && y >= 0 && y < n 
                        && matrix[x][y] < matrix[i][j]) {

                        outdegree[x][y]--;

                        if (outdegree[x][y] == 0) {
                            q.offer(new int[]{x, y});
                        }
                    }
                }
            }
        }

        return length;
    }
}