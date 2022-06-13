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
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode curr = root;              //initializing curr node with root.
        
        while(curr != null){               //iterating.
            
            if(val == curr.val)
                return curr;               //found the reqd. node.
            
            if(val > curr.val)             //greater values are on the right side.
                curr = curr.right;         //searching in the right side.
            else                           //lesser values are on the left side.
                curr = curr.left;          //searching in the left side.
            
        }
        
        return null;                       //iterated through the entire tree and not found the val node.
    }
}