class Solution {
    int m , n;
    char[][] board;
    public void solve(char[][] board) {
        this.m = board.length;
        this.n = board[0].length;
        this.board = board;
        for (int i = 0; i <m; i++)
            fill(i, 0);
        for (int i = 0; i <m; i++)
            fill(i, n-1);
        for (int i = 0; i <n; i++)
            fill(0, i);
        for (int i = 0; i <n; i++)
            fill(m-1, i);
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == 'Z')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }
    private void fill(int i, int j){
        if (i < 0 || i == m || j < 0 || j == n || board[i][j] != 'O')
            return;
        board[i][j] = 'Z';
        fill(i-1, j);
        fill(i+1, j);
        fill(i, j-1);
        fill(i, j+1);
        
    }
}
