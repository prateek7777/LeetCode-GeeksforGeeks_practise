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
    public TreeNode insertIntoBST(TreeNode root, int val) {
         
        if(root == null)                          //edge case.
            return new TreeNode(val);    
        
        TreeNode curr = root;
        TreeNode prev = null;                     //keeping track of the previous node to current node.
        while(curr != null) 
        {
            
            prev = curr;              //assigning curr to prev.
            if(val > curr.val)        //iterating as per BST.
                curr = curr.right;
            else
                curr = curr.left;     //iterating as per BST.
  
        }
        //outside the while loop, the curr is null(child of the reqd. node), while the prev has the reqd. node.
        if(val > prev.val)            //for inserting the node.
            prev.right = new TreeNode(val);     //actual insertion as per BST.
        else
            prev.left = new TreeNode(val);      //actual insertion as per BST.
        
        return root;                            //returning the root of the modified BST.
    }
}