class Solution {
    PriorityQueue<Integer> pq, qp;
    boolean isEqual = true;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        this.pq = new PriorityQueue<>();
        this.qp = new PriorityQueue<>(Collections.reverseOrder());
        add(nums1);
        add(nums2);
        if (isEqual){
            return (pq.peek() + qp.peek())/ 2.0;
        }
        return pq.peek() / 1.0;
    }
    void add(int[] arr){
        for (int each : arr){
            if (isEqual){
                qp.offer(each);
                pq.offer(qp.poll());
            }
            else{
                pq.offer(each);
                qp.offer(pq.poll());
            }
            isEqual = !isEqual;
        }
    }
}
