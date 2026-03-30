class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] each : prerequisites){
            map.computeIfAbsent(each[0], x->new ArrayList<>()).add(each[1]);
        }
        List<Boolean> ans = new ArrayList<>();

        for (int[] each : queries){
            ans.add(dfs(each, map));
        }
        return ans;
    }

    boolean dfs(int[] q, Map<Integer, List<Integer>> map){
        int start = q[0];
        int end = q[1];

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        set.add(start);
        queue.offer(start);
        while (!queue.isEmpty()){
            int node = queue.poll();
            if (node == end)
                return true;
            for (int each : map.getOrDefault(node, new ArrayList<>())){
                if (set.contains(each))
                    continue;
                set.add(each);
                queue.offer(each);
            }
        }
        return false;
    }
}