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
        new_head.next = head;
        
        ListNode slow = new_head;
        ListNode fast = new_head;
        
        for(int i=0; i<=n; i++){
            fast = fast.next;
        }
        
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        
        return new_head.next;
        
//start.next can be different from head.
//For Eg. In the linked list [1,2] if n = 2, we have to delete 2nd node from the end which is 1.
//In this case head would be 1. But start.next would be 2.
    }
}