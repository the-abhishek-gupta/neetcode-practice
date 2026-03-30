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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode head = ans;
        while (list1 != null && list2 != null){
            int val = -1;
            if (list1.val < list2.val){
                val = list1.val;
                list1 = list1.next;
            }
            else{
                val = list2.val;
                list2 = list2.next;
            }
            ListNode node = new ListNode(val);
            head.next = node;
            head = head.next;
        }
        if (list1 != null)
            head.next = list1;
        if (list2 != null)
            head.next = list2;
        return ans.next;
    }
}