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
    public int sumRootToLeaf(TreeNode root) {
        int[] sum = {0};
        sRootToLeaf(root, ""+Integer.toString(root.val), sum);
        return sum[0];
    }
    
    public void sRootToLeaf(TreeNode root, String currPath, int[] sum){
        
        if(root.left == null && root.right == null)
            sum[0] = sum[0] + Integer.parseInt(currPath, 2);
        
        if(root.left != null)
            sRootToLeaf(root.left, currPath + Integer.toString(root.left.val), sum);
        
        if(root.right != null)
            sRootToLeaf(root.right, currPath + Integer.toString(root.right.val), sum);
        
        return;
        
    }
}