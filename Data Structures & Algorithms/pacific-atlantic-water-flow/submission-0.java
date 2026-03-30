class Solution {
    int m, n;
    int[][] heights;
    boolean[][] atl, pac;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.m = heights.length;
        this.n = heights[0].length;
        this.heights = heights;
        this.atl = new boolean[m][n];
        this.pac = new boolean[m][n];
        for (int i = 0; i < m; i++){
            pacific(i,0, heights[i][0]);
            atlantic(i, n-1, heights[i][n-1]);
        }
        for (int j = 0; j < n; j++){
            pacific(0, j, heights[0][j]);
            atlantic(m-1, j, heights[m-1][j]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++)
                if (atl[i][j] && pac[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
        }
        return ans;
    }
    void pacific(int i, int j, int prev){
        if (i < 0 || j < 0 || i== m || j == n || heights[i][j] < prev || pac[i][j])
            return;
        pac[i][j] = true;
        pacific(i-1,j, heights[i][j]);
        pacific(i,j-1, heights[i][j]);
        pacific(i+1,j, heights[i][j]);
        pacific(i,j+1, heights[i][j]);
    }
    void atlantic(int i, int j, int prev){
        if (i < 0 || j <0 || i==m || j == n || heights[i][j] < prev || atl[i][j])
            return;
        atl[i][j] = true;
        atlantic(i-1,j, heights[i][j]);
        atlantic(i,j-1, heights[i][j]);
        atlantic(i+1,j, heights[i][j]);
        atlantic(i,j+1, heights[i][j]);
    }
}
