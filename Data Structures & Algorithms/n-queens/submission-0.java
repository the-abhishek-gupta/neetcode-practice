class Solution {
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        ans = new ArrayList<>();

        solve(board, 0);
        
        return ans;
    }
    void solve(boolean[][] board, int row){
        if (row == board.length){
            int n = board.length;
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++){
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < n; j++){
                    temp.append(board[i][j] ? "Q" : ".");
                }
                list.add(temp.toString());
            }
            ans.add(new ArrayList<>(list));
            return;
        }
            
        for (int i = 0; i < board.length; i++){
            if (canSet(board, row, i)){
                board[row][i] = true;
                solve(board, row+1);
                board[row][i] = false;
            }

        }
    }
    boolean canSet(boolean[][] board, int row, int col){
        for (int i = 0; i < row; i++)
            if (board[i][col])
                return false;
        
        for (int i = row-1, j = col-1 ; i >=0 && j >=0; i--, j--)
            if (board[i][j])
                return false;
        for (int i = row-1, j = col+1 ; i >=0 && j <board.length; i--, j++)
            if (board[i][j])
                return false;

        return true;
        
    }
}
