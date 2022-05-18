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
    public int maxDepth(TreeNode root) {
     
        if(root == null)                    //if the root is null, the height/depth of the tree is 0.
            return 0;
        
        int leftDepth = 1 + maxDepth(root.left);     // (1+) becasue by going l node below(left or right), we have to add 1 to the depth/height. 
        int rightDepth = 1 + maxDepth(root.right);   //root.left or root.right is as same as node.next(as in, SIMILAR).
        
        return Math.max(leftDepth, rightDepth);  //we return the maximum, because, either left or right traverse the entire depth/height of the tree.
    }
}