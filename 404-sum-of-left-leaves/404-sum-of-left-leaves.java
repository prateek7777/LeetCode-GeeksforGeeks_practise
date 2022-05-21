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
    public int sumOfLeftLeaves(TreeNode root) {
        return sumLeftLeaves(root, false);
    }
    
    public int sumLeftLeaves(TreeNode root, Boolean isLeftLeaf){
        
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null)
        {
            if(isLeftLeaf == true)
                return root.val;
            else
                return 0;
        }
        
        int leftLeavesSum = sumLeftLeaves(root.left, true);
        int rightLeavesSum = sumLeftLeaves(root.right, false);
        
        return leftLeavesSum + rightLeavesSum;        
    } 
}