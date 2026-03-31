class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] e : times){
            map.computeIfAbsent(e[0] - 1, x -> new ArrayList<>()).add(new int[]{e[1] - 1, e[2]});
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{k-1,0});
        dist[k-1] = 0;

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int currentNode = current[0];
            int currentDelay = current[1];
            for (int[] next : map.getOrDefault(currentNode, new ArrayList<>())){
                int nextNode = next[0];
                int nextDelay = next[1] + currentDelay;
                if (nextDelay < dist[nextNode]){
                    dist[nextNode] = nextDelay;
                    queue.offer(new int[]{nextNode, nextDelay});
                }
            }
        }
        int max = 0;
        for (int each : dist)
            max = Math.max(max, each);
        if (max == Integer.MAX_VALUE)
            return -1;
        return max;
    }
}
