class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int each : nums){
            int ct = map.getOrDefault(each, 0);
            map.put(each, ct+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for (int each: map.keySet())
            pq.offer(new int[]{each, map.get(each)});
        int[] ans = new int[k];
        for (int i = 0; i<k;i++)
            ans[i] = pq.poll()[0];
        return ans;
    }
}
