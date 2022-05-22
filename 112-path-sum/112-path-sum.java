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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;    //traversed through the entire tree and the target sum was not reached.       //base case.
        
        else if(root.left == null && root.right == null && (targetSum-root.val) == 0)  //if the leaf node has been reached and the target sum has been reached.
            return true;   
        
        else{  //(targetSum - root.left.val) cannot be used, as in case of a leaf node, root.left = null, which throws an error( null.val cannot be computed ).
            boolean leftSubtree = hasPathSum(root.left, targetSum - root.val);     //keep searching in the left subtree for the target sum until reaching the target sum.
            boolean rightSubtree = hasPathSum(root.right, targetSum - root.val);   //keep searching in the right subtree for the target sum until reaching the target sum.
            //either the target sum is reached in the left subtree or the right subtree. until then, we keep searching. hence, the "OR" condition is used instead of "AND" condition.
            return leftSubtree || rightSubtree;
        }
    }
}