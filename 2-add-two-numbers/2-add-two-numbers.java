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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode head = new ListNode(0);     //create a linked list head starting with 0.
        ListNode temp = head;                //create a copy of head.
        int sum = 0;
        int carry = 0;
        
        while(l1 != null || l2 != null || carry != 0)   //condition to be checked before coming out of the loop.
        {
            sum = 0;                                    //initialize sum to 0 before every iteration(update sum).
            if(l1 != null){           //while() is not used because we have to add two nodes simultaneously. while() will lead to iteration in a single node until it reaches null.
                sum = sum + l1.val;
                l1 = l1.next;
            }
            
            if(l2 != null){           //while() is not used because we have to add two nodes simultaneously. while() will lead to iteration in a single node until it reaches null.
                sum = sum + l2.val;
                l2 = l2.next;
            }
            
            sum = sum + carry;       //update the sum with carry. Then calculate carry, not the other way round.
            carry = sum/10;          //calculating carry, to be added to sum in the NEXT iteration.
            ListNode sum_node = new ListNode(sum%10);       //the last digit of the sum is created as a node.(consider 7+5=12; sum%10=2; carry=1).
            temp.next = sum_node;    //point the temp to the sum.(not temp = sum_node; this is a linked list, not an array).
            temp = temp.next;        //iterate the temp, preparing it for the next sum_node.
        }
        
        return head.next;            //see last.
//see last       
//ListNode head = new ListNode(0);
//ListNode temp = head;
//would make the code much easier to understand.
//Basically, temp is doing all the business logic.
//In the end, we are returning head.next since the first ListNode is 0.
    }
}