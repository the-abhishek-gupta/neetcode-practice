class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] each : edges){
            int a = each[0];
            int b = each[1];
            map.putIfAbsent(a, new ArrayList<>());
            map.putIfAbsent(b, new ArrayList<>());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        System.out.println(map);
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int ct = 0;
        while (!queue.isEmpty()){
            int x = queue.poll();
            ct++;
            for (int each : map.getOrDefault(x, new ArrayList<>())){
                if (visited.contains(each))
                    continue;

                visited.add(x);
                queue.offer(each);
            }
        }
        return ct == n;
    }
}
