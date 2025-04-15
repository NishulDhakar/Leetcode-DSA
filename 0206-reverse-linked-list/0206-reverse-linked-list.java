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
    public ListNode reverseList(ListNode head) {

        ListNode crr = head;
        ListNode pre = null;
        ListNode next = null;

        while(crr != null){

            next = crr.next;
            crr.next = pre;
            pre = crr;
            crr = next;

        }

        return pre;
        
    }
}