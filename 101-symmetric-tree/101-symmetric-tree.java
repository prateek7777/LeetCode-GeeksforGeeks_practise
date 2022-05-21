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
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricCheck(root, root);
    }
    
    public boolean isSymmetricCheck(TreeNode p, TreeNode q){
        if(p == null && q == null)       //we reached the end of the two trees without encountering any differences.
        return true;                     //thus, we return true.
        
        if(p == null || q == null)        //even if one of the nodes is null, it indicates that the two are not equal. 
        return false;                     //thus, we return false.
        
        if(p.val != q.val)                //if the values of p and q are not equal, it indicates that the trees are not same.
            return false;                 //also, null.val cannot be checked here, hence it is checked in line 22 itself.
                                        
        boolean compareLAndR = isSymmetricCheck(p.left, q.right);           //recursive call on the left side of the 2 trees.
        boolean compareRAndL = isSymmetricCheck(p.right, q.left);           //recursive call on the right side of the 2 trees.
        
        return compareLAndR && compareRAndL;      //returns true if equal or else, false is returned
    }
}