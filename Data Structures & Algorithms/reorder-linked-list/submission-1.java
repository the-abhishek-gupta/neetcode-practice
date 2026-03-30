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
        ListNode second = slow.next;
        slow.next = null;
        ListNode rev = reverse(second);
        ListNode it = head;
        while (it != null && it.next != null && rev != null){
            ListNode n = it.next;
            it.next = rev;
            it = it.next;
            rev = rev.next;
            it.next = n;
            it = it.next;
        }
    }
    private ListNode reverse(ListNode node){
        if (node == null)
            return node;
        ListNode prev = null;
        ListNode current = node;
        while (current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
