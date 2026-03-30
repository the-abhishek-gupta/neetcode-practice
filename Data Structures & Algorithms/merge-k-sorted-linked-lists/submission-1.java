/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val - b.val);
        for (ListNode each : lists)
            pq.offer(each);
        ListNode ans = new ListNode(0), temp = ans;
        while (!pq.isEmpty()){
            ListNode node = pq.poll();
            temp.next = node;
            temp = temp.next;
            node = node.next;
            if (node != null)
                pq.offer(node);
        }
        return ans.next;
    }
}
