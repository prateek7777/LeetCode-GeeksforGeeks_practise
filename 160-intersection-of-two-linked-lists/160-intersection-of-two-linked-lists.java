/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode a_pointer = headA;
        ListNode b_pointer = headB;
        
        while(a_pointer != b_pointer){
            
        if(a_pointer != null){
            a_pointer = a_pointer.next;
        }
        else
            a_pointer = headB;
            
        if(b_pointer != null){
            b_pointer = b_pointer.next;
        }  
        else
            b_pointer = headA;
            
        }
        return a_pointer;
    }
}