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
    public boolean isBalanced(TreeNode root) {
        int check = heightOfTree(root);
        if(check == -1)
            return false;
        else
            return true;
    }
    
    public int heightOfTree(TreeNode root){
        
        if(root == null)                       //edge case.
            return 0;
        
        int leftHeight = heightOfTree(root.left);      //left height.
        if(leftHeight == -1)
            return -1;
        int rightHeight = heightOfTree(root.right);    //right height.
        if(rightHeight == -1)
            return -1;
        
        if(Math.abs(leftHeight-rightHeight) > 1)       //condition for balanced tree.
            return -1;
        
        return  Math.max(leftHeight, rightHeight) + 1;  //the calculation of height of the tree.
 
    }
    
}