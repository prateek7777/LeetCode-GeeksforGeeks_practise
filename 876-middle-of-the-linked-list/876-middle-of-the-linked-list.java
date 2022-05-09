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
    public ListNode middleNode(ListNode head) {
        ListNode slow_pointer = head;
        ListNode fast_pointer = head;   //both the slow_pointer and the fast_pointer start at the head(begining) of the linked list.
        
        while(fast_pointer!= null && fast_pointer.next != null){           //while not reaching the end of the linked list.
        //(fast_pointer.next !=null) is required for the odd length linked list. (fast_pointer != null) is required for the even length linked list.
            slow_pointer = slow_pointer.next;                                       //iterating slow pointer by 1 step.  
            fast_pointer = fast_pointer.next.next;                                  //iterating fast pointer by 2 steps.
            //by the time fast_pointer reaches the end, the slow_pointer would be only halfway. because the fast_pointer is twice as fast as slow_pointer. thus, by logic,
        }   //returning the slow_pointer would be returning the halfway or the middle of the linked list.
        
        return slow_pointer;               //returning the halfway or the middle of the linked list.
        
    }
}