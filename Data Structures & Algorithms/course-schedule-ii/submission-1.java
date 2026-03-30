class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] ind = new int[numCourses];
        for (int[] each : prerequisites){
            ind[each[0]]++;
            map.computeIfAbsent(each[1], x -> new ArrayList<>()).add(each[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (ind[i] == 0)
                queue.offer(i);
        }
        int[] ans = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()){
            int course = queue.poll();
            ans[index++] = course;

            for (int next : map.getOrDefault(course, new ArrayList<>())){
                ind[next]--;
                if (ind[next] == 0)
                    queue.offer(next);
            }
        }
        return (index == numCourses) ? ans : new int[]{};
    }
}
