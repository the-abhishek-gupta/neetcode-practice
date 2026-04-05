class MedianFinder {
    PriorityQueue<Integer> pq, qp;
    boolean isEqual;

    public MedianFinder() {
        pq = new PriorityQueue<>();
        qp = new PriorityQueue<>(Collections.reverseOrder());
        isEqual = true;
    }
    
    public void addNum(int num) {
        if (isEqual){
            qp.offer(num);
            pq.offer(qp.poll());
        }
        else{
            pq.offer(num);
            qp.offer(pq.poll());
        }
        isEqual = !isEqual;
    }
    
    public double findMedian() {
        if (pq.size() == qp.size())
            return (pq.peek() + qp.peek()) / 2.0;
        return pq.peek() / 1.0;
    }
}
