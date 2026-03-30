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
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode b = reverse(slow.next);
        slow.next = null;
        ListNode a = head;
        while (b != null){
            ListNode aNext = a.next;
            a.next = b;
            ListNode bNext = b.next;
            b.next = aNext;
            a = aNext;
            b = bNext;
        }
        
    }
    ListNode reverse(ListNode head){
        if (head == null)
            return head;
        ListNode prev = null;
        ListNode current = head;
        while (current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        System.out.println(prev);
        return prev;
    }
}
