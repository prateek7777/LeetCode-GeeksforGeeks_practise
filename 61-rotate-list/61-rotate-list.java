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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)                  //edge cases.
            return head;
        
        ListNode curr = head;
        int len = 0;
        
        len = 1; 
        while(curr.next != null)                                  //calculating the length of LinkedList.
        {
            curr = curr.next;
            len = len + 1;
        }  
        
        curr.next = head;                                        //converting the linear LinkedList into circular LinkedList.
        k = k%len;                                               //k = 12, len = 5; k = 12%5 = 2. rotating 2 times is enough.
        //a simple dry run from starting of the code is enough.
        k = len - k;                                             
        while(k > 0){
            curr = curr.next;
            k = k - 1;
        }
        
        head = curr.next;
        curr.next = null;

        return head;
    }
}