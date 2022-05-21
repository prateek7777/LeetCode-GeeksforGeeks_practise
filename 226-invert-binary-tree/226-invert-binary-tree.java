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
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null)                          //if the root is null, we cannot do anything, we just return it.
            return root;
        
        TreeNode leftChild = invertTree(root.left);            //this is the left child.
        TreeNode rightChild = invertTree(root.right);          //this is the right child.
        
        root.left = rightChild;            //assigning the right child to root.left
        root.right = leftChild;            //assigning the left child to root.right
        
        return root;                       //returning the root of the modified tree(inverted tree).
    }
}