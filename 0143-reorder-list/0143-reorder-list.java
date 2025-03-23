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

        //find mid

        ListNode slow = head;
        ListNode fast = head.next; 

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;

        //2nd half reverse
       
         ListNode prev = null;
         ListNode curr = mid.next;
         mid.next= null;
         ListNode next;

         while(curr != null){

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
         }

         ListNode left = head;
         ListNode right = prev;
         ListNode nextL , nextR;

         //alte-merge -> zig-zag merge

         while(left != null && right != null){
            nextL = left.next;
            left.next = right;

            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
         }
    }

    public ListNode getMid (ListNode head){

        ListNode slow = head;
        ListNode fast = head.next; 

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverse2ndHalf (ListNode head){

         ListNode prev = null;
         ListNode curr = head;
         ListNode next;

         while(curr != null){

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
         }

         return prev;

    }


}