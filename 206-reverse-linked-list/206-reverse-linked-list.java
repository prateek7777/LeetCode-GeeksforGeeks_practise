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
     
        ListNode prev = null;                                    //set the new head(prev) to null.
        
        while(head != null){                                     //to iterate through the linked list.
            ListNode nextNode = head.next;                       //actual iteration(going ahead).
            head.next = prev;                                    //check CN practise book.
            prev = head;                                         //check CN practise book.
            head = nextNode;                                     //check CN practise book.
        }
        
        return prev;                                             //always return the reference to the new head. not the entire linked list.
        
    }
}