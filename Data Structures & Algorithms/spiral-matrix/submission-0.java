class Solution {
    List<Integer> ans;
    int[][] matrix;
    boolean[][] visited;
    int m,n;
    public List<Integer> spiralOrder(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        visited = new boolean[m][n];
        int rowStart = 0, rowEnd = m-1;
        int colStart = n-1, colEnd = 0;
        ans = new ArrayList<>();
        this.matrix = matrix;
        while (rowStart <= rowEnd && colStart >= colEnd){
            traverseRow(rowStart,1);
            traverseCol(colStart,1);
            traverseRow(rowEnd,-1);
            traverseCol(colEnd,-1);
            rowStart++;
            rowEnd--;
            colStart--;
            colEnd++;
        }
        return ans;
    }
    void traverseCol(int col, int order){
        if (order == 1){
            for (int i = 0; i < m; i++){
                if (!visited[i][col]){
                    visited[i][col] = true;
                    ans.add(matrix[i][col]);
                }
            }
        }
        else{
            for (int i = m-1; i >=0; i--){
                if (!visited[i][col]){
                    visited[i][col] = true;
                    ans.add(matrix[i][col]);
                }
            }
        }
    }
    void traverseRow(int row, int order){
        if (order == 1){
            for (int i = 0; i <n; i++){
                if (!visited[row][i]){
                    visited[row][i] = true;
                    ans.add(matrix[row][i]);
                }
            }
        }
        else{
            for (int i = n-1; i >=0; i--){
                if (!visited[row][i]){
                    visited[row][i] = true;
                    ans.add(matrix[row][i]);
                }
            }
        }
    }
}
