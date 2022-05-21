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
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        sumLeftLeaves(root, false);
        return sum;
    }
    
    public void sumLeftLeaves(TreeNode root, Boolean isLeftLeaf){
        
        if(root == null)
            return;
        
        if(root.left == null && root.right == null){
            
            if(isLeftLeaf == true)
                sum = sum + root.val;
            
        }
        
        sumLeftLeaves(root.left, true);
        sumLeftLeaves(root.right, false);
      
        return;
    } 
}