class Solution {
    int ct = 0;
    public int totalNQueens(int n) {
        // ct = 0;
        boolean[][] board = new boolean[n][n];
        solve(board, 0);
        return ct;
    }
    void solve(boolean[][] board, int row){
        if (row == board.length){
            ct++;
            return;
        }
        for (int i = 0; i < board[0].length;i++){
            if (check(board, row, i)){
                board[row][i] = true;
                solve(board, row+1);
                board[row][i] = false;
            }
        }
    }
    boolean check(boolean[][] board, int row, int col){
        // check same col;
        for (int i = 0; i < row; i++){
            if (board[i][col])
                return false;
        }
        // check top-left diagonal
        for (int i = row-1, j = col-1; i >=0 && j >=0; i--, j--){
            if (board[i][j])
                return false;
        }
        // check top-right diagonal
        for (int i = row-1, j = col+1; i >=0 && j <board.length; i--, j++){
            if (board[i][j])
                return false;
        }
        return true;

    }
}