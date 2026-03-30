class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Arrays.asList(0); 
        int[] ind = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges){
            map.computeIfAbsent(e[0], x -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], x -> new ArrayList<>()).add(e[0]);
            ind[e[0]]++;
            ind[e[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++){
            if (ind[i] == 1){
                queue.offer(i);
                visited.add(i);
            }
        }
        while (n>2){
            int qs = queue.size();
            n -= qs;
            for (int i = 0; i < qs; i++){
                int node = queue.poll();
                for (int next : map.getOrDefault(node, new ArrayList<>())){
                    ind[next]--;
                    if (ind[next] == 1){
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
                    
        }
        return new ArrayList<>(queue);
        
    }
}