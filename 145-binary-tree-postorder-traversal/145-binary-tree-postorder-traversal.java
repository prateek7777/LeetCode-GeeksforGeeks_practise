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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> traverse = new ArrayList<>();
        postorderTraverse(root, traverse);
        return traverse;
    }
    
    public void postorderTraverse(TreeNode root, List<Integer> traverse){
        
        if(root == null)
            return;
        
        postorderTraverse(root.left, traverse);
        postorderTraverse(root.right, traverse);
        traverse.add(root.val);
        
        return;

    }
}