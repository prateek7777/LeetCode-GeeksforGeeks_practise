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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)  // an empty LinkedList(null) or a single node LinkedList is a palindrome.
            return true;
        
        ListNode slow = head;
        ListNode fast = head;
        //finding the middle of the LinkedList.
        while(fast.next != null && fast.next.next != null){  //(fast.next) for odd length, (fast.next.next) for even length of LinkedList.  
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse the second half of the LinkedList.
        slow.next = reverseList(slow.next);
        //increment slow by 1 step.(it is required for both the even and odd length LinkedList).
        slow = slow.next;      //slow is the starting point of the second half of the LinkedList.
        //comparing the first half and the second half of the LinkedList.
        while(slow != null){
            //head is the starting point of the first half(entire LinkedList) of the LinkedList.
            if(head.val != slow.val)
                return false;
            
            head = head.next;
            slow = slow.next;
        }
        
        return true;
    }
    
    ListNode reverseList(ListNode head){
        
        ListNode prev = null;               //a prev node is set before the given head.
        
        while(head != null){                //ofcourse.
            ListNode nextNode = head.next;  //going ahead.
            head.next = prev;               //actual reversing.
            prev = head;                    //set prev to head(with each new iteration)
            head = nextNode;                //set head to nextNode(with each new iteration)
        }
        
        return prev;                        //the head of the reversed LinkedList.
        
    }

}