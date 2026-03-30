class Solution {
    int m, n;
    String word;
    char[][] board;
    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        this.word = word;
        this.board = board;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++)
                if (board[i][j] == word.charAt(0))
                    if(dfs(i, j, 0))
                        return true;
        }
        return false;
    }
    private boolean dfs(int i, int j, int index){
        if (index == word.length())
            return true;
        if (i<0 || i ==m || j < 0 || j == n || board[i][j] != word.charAt(index))
            return false;
        char c = board[i][j];
        board[i][j] = '-';
        boolean ans = dfs(i-1, j, index+1) ||  dfs(i+1, j, index+1) ||  dfs(i, j-1, index+1) ||  dfs(i, j+1, index+1);
        board[i][j] = c;
        return ans;
    }
}
