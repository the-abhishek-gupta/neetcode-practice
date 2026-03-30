class Solution {
    public void rotate(int[][] matrix) {
        reverse(matrix);
        transpose(matrix);
    }
    private void reverse(int[][] matrix){
        int n = matrix[0].length;
        for (int i = 0; i <(matrix.length+1)/2; i++){
            for (int j = 0; j < matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;
            }
        }
    }
    private void transpose(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = i+1; j < matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
