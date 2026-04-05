class Solution {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];
        List<Integer> ans = new ArrayList<>();

        int rowStart = 0, rowEnd = m-1;
        int colStart = 0, colEnd = n-1;        

        while(rowStart <= rowEnd && colStart <= colEnd){
            for (int j = colStart; j <= colEnd; j++){
                ans.add(matrix[rowStart][j]);
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++){
                ans.add(matrix[i][colEnd]);
            }
            colEnd--;

            if (rowStart <= rowEnd){
                for (int j = colEnd; j >= colStart; j--){
                    ans.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }
            if (colStart <= colEnd){
                for (int i = rowEnd; i >=rowStart; i--){
                    ans.add(matrix[i][colStart]);
                }
                colStart++;
            }
        }
        return ans;
        
    }
}
