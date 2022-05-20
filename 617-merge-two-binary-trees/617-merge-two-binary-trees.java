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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1, root2);
    }
    
    public TreeNode merge(TreeNode t1, TreeNode t2){
        
        if(t1==null && t2==null)             //base case.
            return null;
        
        if(t1 == null)   //in order to add a node when tree t1 has null at the same point, but t2 has a node at the same point.
            return t2;
        
        if(t2 == null)   //in order to add a node when tree t2 has null at the same point, but t1 has a node at the same point.
            return t1;
        
        TreeNode root3 = new TreeNode(t1.val + t2.val);       //adding the node.
        root3.left = merge(t1.left, t2.left);                 //adding the left child.
        root3.right = merge(t1.right, t2.right);              //adding the right child.
                                                              //thus, preorder traversal.
        return root3;                                         //returning the root of the final answer(addition of root1 and root2).
    }
    
}