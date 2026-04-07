class Solution {
    int n;
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] row : board)
            Arrays.fill(row, '.');
        dfs(0, board);
        return ans;
    }
    void dfs(int index, char[][] board){
        if (index == n){
            List<String> list = new ArrayList<>();
            for (char[] row : board){
                list.add(new String(row));
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < n; j++){
            if (canPlace(index, j, board)){
                board[index][j] = 'Q';
                dfs(index+1, board);
                board[index][j] = '.';
            }
        }
    }
    private boolean canPlace(int row, int col,char[][] board){
        for (int i = 0; i < row; i++){
            if (board[i][col] == 'Q')
                return false;
        }
        for (int i = row-1, j = col-1; i >=0 && j >=0; i--, j--)
            if (board[i][j] == 'Q')
                return false;
        
        for (int i = row-1, j = col+1; i >=0 && j < n; i-- , j++)
            if (board[i][j] == 'Q')
                return false;
        return true;

    }
}
