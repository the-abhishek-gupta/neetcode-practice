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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ahead = new ListNode(0, head), start = ahead, dummy = ahead;
        while (ahead != null && n-- > 0)
            ahead = ahead.next;
        while (ahead.next != null){
            ahead = ahead.next;
            start = start.next;
        }
        start.next = start.next.next;
        return dummy.next;
    }
}
