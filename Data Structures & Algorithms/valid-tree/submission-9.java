class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1)
            return false;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges){
            map.computeIfAbsent(e[0], x -> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], x -> new ArrayList<>()).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int first = 0;
        queue.offer(first);

        while (!queue.isEmpty()){
            int node = queue.poll();
            if (visited[node])
                continue;
            visited[node] = true;
            for (int next : map.getOrDefault(node, new ArrayList<>())){
                if (!visited[next]){
                    queue.offer(next);
                }
            }
        }
        for (boolean flag : visited){
            if (!flag)
                return false;
        }
        return true;
    }
}
