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
    public boolean isUnivalTree(TreeNode root) {
        return isUnivalued(root, root.val);
    }
    
    public boolean isUnivalued(TreeNode root, int considerVal){
     
        if(root == null)
            return true;
        
        if(root.val != considerVal)
            return false;
        
        boolean leftConsider = isUnivalued(root.left, considerVal);
        boolean rightConsider = isUnivalued(root.right, considerVal);
        
        if(leftConsider && rightConsider == true)
            return true;
        else
            return false;
    }
}