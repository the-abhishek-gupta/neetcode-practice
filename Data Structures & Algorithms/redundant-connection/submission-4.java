class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        for (int i = 0; i <= n; i++){
            parent[i] = i ;
        }
        int[] ans = new int[2];
        for (int[] e : edges){
            if (find(e[0]) == find(e[1])){
                ans = e;
            }
            else{
                union(e[0], e[1]);
            }
        }
        return ans;
    }
    private void union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);
        if (parentX != parentY)
            parent[parentY] = parentX;
    }
    private int find(int x){
        if (parent[x]!= x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
