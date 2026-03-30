class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge: edges){
            map.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }
        int ct = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++){
            if (!set.contains(i)){
                ct++;
                set.add(i);
                traverse(i, set, map);
            }
        }
        return ct;
    }
    void traverse(int node, Set<Integer> set, Map<Integer, List<Integer>> map){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            int x = queue.poll();
            for (int each : map.getOrDefault(x, new ArrayList<>())){
                if (!set.contains(each)){
                    set.add(each);
                    queue.offer(each);
                }
            }
        }
    }
}
