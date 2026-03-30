class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int each : stones)
            pq.offer(each);
        while (pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            int res = Math.abs(a-b);
            if (res > 0)
                pq.offer(res);
        }
        if (pq.isEmpty())
            return 0;
        return pq.poll();
    }
}
