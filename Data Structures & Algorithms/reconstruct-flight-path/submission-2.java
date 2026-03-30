class Solution {
    Map<String, PriorityQueue<String>> map;
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        for (List<String> pair : tickets){
            String start = pair.get(0);
            String end = pair.get(1);
            map.putIfAbsent(start, new PriorityQueue<>());
            map.get(start).offer(end);
        }
        System.out.println(map);
        List<String> ans = new ArrayList<>();
        dfs(ans, "JFK");
        return ans;
    }
    void dfs(List<String> ans, String current){
        PriorityQueue<String> pq = map.get(current);
        while (pq != null && !pq.isEmpty())    
            dfs(ans, pq.poll());
        ans.add(0, current);
    }
}
