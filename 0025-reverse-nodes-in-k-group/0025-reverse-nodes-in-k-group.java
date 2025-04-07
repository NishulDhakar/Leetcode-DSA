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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;

        ListNode crr = head, pre = null,  next = null;

        int c = k;

        while(crr != null && c > 0){
            next = crr.next;
            crr.next = pre;
            pre = crr;
            crr = next;
            c--;
        }

        if(crr == null && c > 0){
            crr = pre;
            pre = null;
            next = null;
            while(crr != null){
            next = crr.next;
            crr.next = pre;
            pre = crr;
            crr = next;
        }

        }
        if(c>0){
            return pre;
        }else{
        head.next = reverseKGroup(crr , k);
        return pre;
        }
        
    }
}