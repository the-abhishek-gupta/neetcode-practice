class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, PriorityQueue<Node>> map = new HashMap<>();
        for (int[] each: times){
            int start = each[0];
            int end = each[1];
            int cost = each[2];
            map.putIfAbsent(start, new PriorityQueue<>((a,b)-> a.cost - b.cost));
            map.get(start).offer(new Node(end, cost));
        }
        for (int each : map.keySet()){
            System.out.print(each +" -> ");
            for (Node p : map.get(each))
                System.out.print(p.end+">"+p.cost+"   ");
            System.out.println();
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k-1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);
        Set<Integer> set = new HashSet<>();
        while (!queue.isEmpty()){
            int currentNode = queue.poll();
            System.out.print(currentNode +" -...> ");
            int distance = dist[currentNode - 1];
            for (Node nextNode : map.getOrDefault(currentNode, new PriorityQueue<>())){
                int cell = nextNode.end;
                int cost = nextNode.cost + distance;
                dist[cell-1] = Math.min(dist[cell-1], cost);
                if (set.contains(cell))
                    continue;
                set.add(cell);
                queue.offer(cell);
            }
        }
        int max = -1;
        for (int each : dist)
            max = Math.max(max, each);
        if (max == Integer.MAX_VALUE)
            return -1;
        return max;
    }
}
class Node{
    int end, cost;
    Node(int end, int cost){
        this.end = end;
        this.cost = cost;
    }
}
