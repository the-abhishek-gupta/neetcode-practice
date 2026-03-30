class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int each : stones)
            pq.offer(each);
        while (pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            int res = Math.abs(first-second);
            if (res != 0)
                pq.offer(res);
        }
        if (pq.isEmpty())
            return 0;
        return pq.peek();

    }
}
