class Solution {
    int m, n;
    int[][] heights;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.m = heights.length;
        this.n = heights[0].length;
        this.heights = heights;
        boolean[][] pacific, atlantic;
        pacific = new boolean[m][n];
        atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++){
            waterFall(i, 0, heights[i][0], pacific);
            waterFall(i, n-1, heights[i][n-1], atlantic);
        }
        for (int j = 0; j < n; j++){
            waterFall(0, j, heights[0][j], pacific);
            waterFall(m-1, j , heights[m-1][j], atlantic);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (pacific[i][j] && atlantic[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(new ArrayList<>(list));
                }
            }
        }
        return ans;
    }
    void waterFall(int i , int j, int prev, boolean[][] arr){
        if (i < 0 || i == m || j < 0 || j == n || heights[i][j] < prev || arr[i][j])
            return;
        arr[i][j] = true;
        waterFall(i-1, j, heights[i][j], arr);
        waterFall(i+1, j, heights[i][j], arr);
        waterFall(i, j-1, heights[i][j], arr);
        waterFall(i, j+1, heights[i][j], arr);
    }
}
