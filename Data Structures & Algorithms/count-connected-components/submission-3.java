class Solution {
    int[] parent;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        
        for (int[] each : edges){
            union(each[0], each[1]);
        }
        Set<Integer> set = new HashSet<>();
        for (int each : parent)
            set.add(find(each));
        return set.size();
    }
    private void union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);
        if (parentX != parentY)
            parent[parentY] = parentX;
    }
    private int find(int x){
        if (parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
