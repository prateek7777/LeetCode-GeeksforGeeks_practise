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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tempNode = new ListNode(0);                                 //see last    
        ListNode currNode = tempNode;                                        //see last
        
        while(list1 != null && list2 != null){                               //iterating through both list1 and list2.
            
            if(list1.val < list2.val){
                currNode.next = list1;                                       //not currNode = list1. (this is a linked list, not an array). assigning.
                list1 = list1.next;                                          //iterate as usual.
                currNode = currNode.next;                                    //iterate as usual.
            }
            
            else{
                currNode.next = list2;                                       //not currNode = list2. (this is a linked list, not an array). assigning.
                list2 = list2.next;                                          //iterating.
                currNode = currNode.next;                                
            }   
            
        }
        
        if(list1 != null){                                                   //in case list2 became null before list1 and the while loop got broken.
            currNode.next = list1;                                           //assigning.
            list1 = list1.next;                                              //iterating.
            currNode = currNode.next;
        }
        
        if(list2 != null){                                                   //in case list1 became null before list2 and the while loop got broken.
            currNode.next = list2;                                           //assigning.
            list2 = list2.next;                                              //iterating.
             currNode = currNode.next; 
        }
        
        return tempNode.next;                                                //see last.
        //see last.
        //When we iterate through the while loop, we lose what last node is since we can only look at one node at a time. Think about it like a long line of cars, 1st car is yellow, 2nd car is blue, 3rd car is red. We assign the variable currNode to yellow, blue and red as we iterate. When we get to red, currNode is assigned to red, and we have no way of knowing where the yellow car is anymore. However, if we put a green car in front(green, yellow, blue, red) of the yellow car, we can find out where the yellow car is again, which is just greencar.next. The green car in this case is the tempNode. the yellow car is the actual head that we have to return after merging the two sorted linked lists.
    }
}