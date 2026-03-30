class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] ind = new int[numCourses];
        Arrays.fill(ind, 0);
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] each : prerequisites){
            graph.computeIfAbsent(each[1], x -> new ArrayList<>()).add(each[0]);
            ind[each[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (ind[i] == 0)
                queue.offer(i);
        }
        int finished = 0;
        while (!queue.isEmpty()){
            int course = queue.poll();
            finished++;
            for (int next : graph.getOrDefault(course, new ArrayList<>())){
                ind[next]--;
                if (ind[next]==0)
                    queue.offer(next);
            }
        }
        return finished == numCourses;
    }
}
