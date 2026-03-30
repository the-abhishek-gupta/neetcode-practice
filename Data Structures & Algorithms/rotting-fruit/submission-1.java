class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ones = 0;
        Queue<Pos> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1)
                    ones++;
                else if (grid[i][j] == 2)
                    queue.offer(new Pos(i, j));
            }
        }

        if (ones == 0) return 0;
        int t = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (ones > 0 && !queue.isEmpty()){

            for (int i = queue.size(); i > 0; i--){
                Pos each = queue.poll();
                for (int[] d : dirs){
                    int dx = each.x + d[0];
                    int dy = each.y + d[1];

                    if (dx >= 0 && dx < m && dy >= 0 && dy < n && grid[dx][dy] == 1){
                        grid[dx][dy] = 2;
                        ones--;
                        queue.offer(new Pos(dx, dy));
                    }
                }
            }
            t++;
        }
        if (ones == 0)
            return t;
        return -1;
    }
}
class Pos{
    int x, y;
    Pos(int i, int j){
        this.x = i;
        this.y = j;
    }
}
