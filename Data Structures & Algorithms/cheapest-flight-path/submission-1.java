class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Stop>> map = new HashMap<>();
        for (int[] each : flights)
            map.computeIfAbsent(each[0], x -> new ArrayList<>()).add(new Stop(each[1], each[2]));

        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        price[src] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src,0,0});
        while (!queue.isEmpty()){
            int[] currentStop = queue.poll();

            int city = currentStop[0], curCost = currentStop[1], stops = currentStop[2];
            if (stops > k)
                continue;
            for (Stop stop : map.getOrDefault(city, new ArrayList<>())){
                int newCost = curCost + stop.cost;
                if (newCost < price[stop.dest]) {
                    price[stop.dest] = newCost;
                    queue.offer(new int[]{stop.dest, newCost, stops + 1});
                }
            }
        }
        
        return price[dst]== Integer.MAX_VALUE ? -1 : price[dst] ;
    }
}
class Stop{
    int dest, cost;
    Stop(int d, int c){
        this.dest = d;
        this.cost = c;
    }
}
