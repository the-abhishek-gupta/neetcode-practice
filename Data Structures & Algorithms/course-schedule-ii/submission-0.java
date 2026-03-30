class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] arr = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] each : prerequisites){
            arr[each[1]]++;
            map.putIfAbsent(each[0], new ArrayList<>());
            map.get(each[0]).add(each[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            if (arr[i] == 0)
                queue.offer(i);
        }
        int ct = 0;
        System.out.println(queue);
        while (!queue.isEmpty()){
            int course = queue.poll();
            ans.add(course);
            ct++;
            for (int each : map.getOrDefault(course, new ArrayList<>())){
                arr[each]--;
                if (arr[each] == 0)
                    queue.offer(each);
            }
            System.out.println(queue);

        }
        System.out.println(ans);

        if (ct != numCourses)
            return new int[]{};
        int[] res = new int[ans.size()];
        int i = ans.size()-1;
        for (int each : ans)
            res[i--] = each;
        return res;        
    }
}
