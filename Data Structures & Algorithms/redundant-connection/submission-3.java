class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n];
        for (int i = 1; i <= n; i++)
            parent[i-1] = i;
        for (int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            if (find(parent, a) == find(parent, b))
                return edge;
            union(parent, a, b);
        }
        return new int[]{};
    }
    int find(int[] parent, int x){
        if (parent[x-1] != x)
            parent[x - 1] = find(parent, parent[x - 1]);
        return parent[x-1];
    }
    void union(int[] parent, int a, int b){
        int pA = find(parent, a);
        int pB = find(parent, b);
        if (pA != pB){
            parent[pA-1] = pB;
        }
    }
}
