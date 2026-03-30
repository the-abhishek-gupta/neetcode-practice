class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n -1;

        while (start <= end){
            int mid = start + (end-start)/2;
            int val = getVal(matrix, n, mid);
            if (val == target)
                return true;
            else if (val < target)
                start = mid +1;
            else
                end = mid-1;
        }
        return false;
    }
    private int getVal(int[][] matrix, int col, int mid){
        int i = mid / col;
        int j = mid % col;
        return matrix[i][j];
    }
}
