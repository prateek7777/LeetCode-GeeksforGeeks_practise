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
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE); //Long is used due to constraints.
        }
    
    public boolean checkBST(TreeNode root, long minVal, long maxVal){
        
        if(root == null)  //edge case.
            return true;
        
        if(root.val >= maxVal || root.val <= minVal)   //as per BST.
            return false;
        //(root.val) keeps on changing for every call starting with the root. so do minVal and maxVal with each left and right call respectively.
        return checkBST(root.left, minVal, root.val) && checkBST(root.right, root.val, maxVal);
    }
}