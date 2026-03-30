class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] ins = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] course : prerequisites){
            int a = course[0];
            int b = course[1];
            map.putIfAbsent(a, new ArrayList<>());
            map.get(a).add(b);
            ins[b]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (ins[i] == 0)
                queue.offer(i);
        }
        int finishedCourses = 0;
        while (!queue.isEmpty()){
            finishedCourses++;
            int node = queue.poll();
            for (int neighbor : map.getOrDefault(node, new ArrayList<>())){
                ins[neighbor]--;
                if (ins[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }
        return finishedCourses == numCourses;
    }
}
