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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode start = new ListNode(), ans = start;
        start.next = head;
        ListNode tail = ans;
        while (right-- > 0 )
            tail = tail.next;
        ListNode third = tail.next;
        tail.next = null; 
        tail = ans;
        while (--left > 0 )
            tail = tail.next;
        tail.next = reverse(tail.next);
        while (tail.next != null)
            tail = tail.next;
        tail.next = third;
        return ans.next;
    }
    ListNode reverse(ListNode current){
        ListNode prev = null;
        while (current != null){
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}