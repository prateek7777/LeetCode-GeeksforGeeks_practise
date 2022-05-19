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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre_traversal = new ArrayList<>();
        preTraversal(root, pre_traversal);
        return pre_traversal;
    }
    
    public void preTraversal(TreeNode root, List<Integer> pre_traversal){
        
        if(root == null)
            return;
        
        pre_traversal.add(root.val);
        preTraversal(root.left, pre_traversal);
        preTraversal(root.right, pre_traversal);
        
        return;
    }
}