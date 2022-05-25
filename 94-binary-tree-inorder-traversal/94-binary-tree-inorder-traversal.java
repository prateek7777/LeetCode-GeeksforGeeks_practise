/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        //inorder is LEFT to RIGHT, with root in between.
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> output = new ArrayList<>();
        
        if(root == null)                                            //base case.
            return output;
        
        TreeNode curr = root;                                       //for the iteration.
        
        while(!(curr == null) || !stack.isEmpty()){                 //for the 1st time, stack is empty, but curr is not null.
            
            while(!(curr == null)){  //LEFT.  
                stack.push(curr);    //push FIRST because if curr becomes null, the very last element won't be pushed into the stack.
                curr = curr.left;    //iterating through the left subtree.
            }
            
            curr = stack.pop();      //as soon as the iteration through the left subtree is over, we start popping the elements and put them in our output.
            output.add(curr.val);    //populating the output.
            curr = curr.right;       //RIGHT. //iterating through the right subtree.
        }                            //as soon as the stack becomes empty, we come out of the while loop.
        
        return output;               //returning the final output.
        
    }
}