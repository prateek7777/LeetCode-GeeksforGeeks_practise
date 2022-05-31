/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null)                                              //if root itself is null, we just return null.
            return null;
        
        if(root.val == p.val || root.val == q.val)                    //if the value at a particular node is equal to either p or q. we just don't iterate anymore. 
            return root;                                              //we return the root and don't go further into the left or right subtree. anyway, we have to return the LOWEST common ancestor.
        
        TreeNode leftAns = lowestCommonAncestor(root.left, p, q);          //searching in the left subtree.
        TreeNode rightAns = lowestCommonAncestor(root.right, p, q);        //searching in the right subtree.
        
        if(leftAns != null && rightAns != null)             //if p and q are found in both left and right subtree, not respectively, it can be either way.
            return root;                                    //we just return the root node because, it will be the LCA.
        
        if(leftAns != null)                                //if the rightAns is null.
            return leftAns;
        
        if(rightAns != null)                               //if the leftAns is null.
            return rightAns;
        
        return null;                                       //if the nodes p and q are not present in both the left subtree and the right subtree. We just return null.
            
    }
}