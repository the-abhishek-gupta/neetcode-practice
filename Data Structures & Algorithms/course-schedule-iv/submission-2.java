class Solution {
    Map<Integer, List<Integer>> map;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        map = new HashMap<>();
        for (int each[] : prerequisites){
            map.computeIfAbsent(each[0], x -> new ArrayList<>()).add(each[1]);
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries){
            ans.add(find(query));
        }
        return ans;
    }
    private boolean find(int[] query){
        int from = query[0];
        int to = query[1];

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(from);
        visited.add(from);

        while (!queue.isEmpty()){
            int node = queue.poll();
            for (int next : map.getOrDefault(node, new ArrayList<>())){
                if (next == to)
                    return true;
                if (!visited.contains(next)){
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }
        return false;

    }
}