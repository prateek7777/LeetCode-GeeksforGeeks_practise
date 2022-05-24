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
    public boolean hasCycle(ListNode head) {
     
        if(head == null)                       //we cannot do null.next in line 19.
            return false;
         //if there is a cycle in the Linked List, then slow pointer and fast pointer will meet each other.
        ListNode slow = head;      
        ListNode fast = head.next; //slow pointer and fast pointer don't start at the same point.             
        //the fast pointer will simply loop back into the list if there is a cycle in the Linked List.
        while(slow != fast){
            
            if(fast == null || fast.next == null){     //if fast pointer reaches this point, there is no cycle in the given Linked List.
                return false;                          //thus, we return false.
        }
            slow = slow.next;                           
            fast = fast.next.next;                     //iterating slow pointer and fast pointer according to their speeds.
            
        }
        
        return true;              //if the loop breaks, it indicates that there is a cycle in the Linked List, because of which slow and fast got equal.
                                 
    }
}