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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode new_head = new ListNode(0);
        new_head.next = head; //this a technique used in most of linked list questions.
        //we can just return new_head.next when we want to return the head at the end. see last for further explanation.
        ListNode slow = new_head;  //both slow and fast start at the head of the linked list.
        ListNode fast = new_head;
        
        //move the fast pointer ahead by 'n' steps. So that the gap between slow and fast is 'n'.
        for(int i=0; i<=n; i++){
            fast = fast.next;
        }
        //move both fast and slow ahead until fast becomes null.
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        //if the fast is null, the slow is obviously behind fast with a gap of 'n'. so, slow which is pointing to 'n' right now, is made to point to next node of 'n', which means effectively skipping 
        slow.next = slow.next.next; //the 'n' node in the linked list. skipping node is equivalent to deleting it.
         
        return new_head.next;  //returning the new head after the modification in the linked list.
//see last.       
//new_head.next can be different from head.
//For Eg. In the linked list [1,2] if n = 2, we have to delete 2nd node from the end which is 1.
//In this case head would be 1. But, new_head.next would be 2.
    }
}