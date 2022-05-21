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
    //almost same as "Same Tree"(100).
    //symmetric means, that the left child of the left node and the right child of the right node are same.
    //similarly, the right child of the left node and the left child of the right node are same.
    public boolean isSymmetricCheck(TreeNode p, TreeNode q){
        if(p == null && q == null)       //we reached the end of the two nodes without encountering any differences.
        return true;                     //thus, we return true.
        
        if(p == null || q == null)        //even if one of the nodes is null, it indicates that the two are not symmetric. 
        return false;                     //thus, we return false.
        
        if(p.val != q.val)                //if the values of p and q are not equal, it indicates that the left and right sides are not symmetric.
            return false;    //also, null.val cannot be checked here, hence it is checked in line 27 itself.
                                        
        boolean compare1 = isSymmetricCheck(p.left, q.right); //compare left side of p(left child) and right side of q(right child).
        boolean compare2 = isSymmetricCheck(p.right, q.left); //compare right side of p(left child) and left side of q(right child).
        
        return compare1 && compare2;      //returns true if symmetric or else, false is returned.
    }
}