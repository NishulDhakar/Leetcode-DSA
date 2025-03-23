/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

     //detect cycle
        ListNode slow = head;
        ListNode fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                cycle = true;
                break;
            }

        }

       if(cycle == false)
        return null;

        //find meeting point
           
        slow = head;

        ListNode prev = null;

        while(slow!=fast){

            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        //remove cycle -> last.next = null
         if (prev != null) {
            prev.next = null; 
        }

        return slow;
        
    } 

}