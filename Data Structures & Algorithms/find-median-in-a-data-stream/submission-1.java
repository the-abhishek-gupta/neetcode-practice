class MedianFinder {
    PriorityQueue<Integer> minPQ, maxPQ;
    public MedianFinder() {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if (maxPQ.size() == minPQ.size()){
            maxPQ.offer(num);
            minPQ.offer(maxPQ.poll());
        }
        else{
            minPQ.offer(num);
            maxPQ.offer(minPQ.poll());
        }
    }
    
    public double findMedian() {
        if (maxPQ.size() == minPQ.size())
            return (minPQ.peek() + maxPQ.peek()) / 2.0;
        return minPQ.peek();
    }
}
