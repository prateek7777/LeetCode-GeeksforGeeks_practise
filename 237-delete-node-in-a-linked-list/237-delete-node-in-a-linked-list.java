/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        //1->2->3->null; node to be deleted = 2.
        node.val = node.next.val;             //2=3. 1->3->3->null
        node.next = node.next.next;           //1->3->null. the second node 3 will point to null, skipping the third node 3. Thus, indirectly deleting node 2 from the linked list.

    }
}