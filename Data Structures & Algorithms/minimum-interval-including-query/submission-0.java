class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Map<Integer, List<Integer>> pushMap = new HashMap<>();
        Map<Integer, List<Integer>> popMap = new HashMap<>();
        int max = 0;
        for (int[] each : intervals){
            max = Math.max(max, each[1]);
            pushMap.computeIfAbsent(each[0], x -> new ArrayList<>()).add(each[1]-each[0]+1);
            popMap.computeIfAbsent(each[1]+1, x -> new ArrayList<>()).add(each[1]-each[0]+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] ans = new int[max+1];
        for (int i = 0; i <= max; i++){
            for (int each : pushMap.getOrDefault(i, new ArrayList<>()))
                pq.offer(each);
            for (int each : popMap.getOrDefault(i, new ArrayList<>()))
                pq.remove(each);
            ans[i] = -1;
            if (!pq.isEmpty())
                ans[i] = pq.peek();
        }
        int[] qs = new int[queries.length];
        int index = 0;
        for (int each : queries){
            if (each > max)
                qs[index++] = -1;
            else
                qs[index++] = ans[each];
        }
        return qs;
    }
}
