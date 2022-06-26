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
    public void flatten(TreeNode root) {
        if(root == null)                        //edge case.
            return;
        
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root);
        
        while(!stack.isEmpty()){
            
            TreeNode curr = stack.peek();       //starting with curr = root.
            
            stack.pop();
            //right left root.
            if(curr.right != null)
                stack.push(curr.right);         //right   
            
            if(curr.left != null)
                stack.push(curr.left);          //left
            
            if(!stack.isEmpty())
                curr.right = stack.peek();      //right->left, because LIFO. here, the last in was left, hence we are pointing the right to the top of the stack.
            
            curr.left = null;                   //the left will be always be null after the tree is converted to linkedlist.
            
        }
    }
}