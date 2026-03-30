class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || j == 0 || i == m-1 || j == n-1){
                    if (board[i][j] == 'O')
                        fill(board, i, j);
                }
            }
        }
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == 'Z')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }
    void fill(char[][] board, int i, int j){
        if (i <0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == 'X' || board[i][j] == 'Z')
            return;
        // System.out.println(i+" "+j);
        board[i][j] = 'Z';
        fill(board, i-1, j);
        fill(board, i+1, j);
        fill(board, i, j-1);
        fill(board, i, j+1);
    }
}
