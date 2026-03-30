class Solution {
    public void solve(char[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if ((i == 0 || j == 0 || i == m-1 || j == n-1 ) && board[i][j] == 'O')
                    queue.offer(new int[]{i, j});
            }
        }
        int[][] dirs = new int[][]{{-1,0}, {1, 0}, {0,1}, {0, -1}};
        while (!queue.isEmpty()){
            int[] pos = queue.poll();
            board[pos[0]][pos[1]] = 'T';
            for (int[] d : dirs){
                int dx = d[0] + pos[0];
                int dy = d[1] + pos[1];
                if (dx >= 0 && dy >= 0 && dx < m-1 && dy < n-1 && board[dx][dy] == 'O')
                    queue.offer(new int[]{dx, dy});
            }
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == 'T')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            
            }
        }
        
    }
}
