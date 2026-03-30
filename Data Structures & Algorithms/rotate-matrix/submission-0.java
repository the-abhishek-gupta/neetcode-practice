class Solution {
    public void rotate(int[][] matrix) {
        reverse(matrix);
        transpose(matrix);
    }
    void reverse(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < (m+1)/2; i++){
            for (int j = 0; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;
            }
        }
    }
    void transpose(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i > j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }
}
