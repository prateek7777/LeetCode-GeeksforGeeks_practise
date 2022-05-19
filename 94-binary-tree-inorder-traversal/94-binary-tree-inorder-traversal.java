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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traverse = new ArrayList<>();
        inorderTraverse(root, traverse);
        return traverse;
    }
    public void inorderTraverse(TreeNode root, List<Integer> traverse){
    //preorder = Node, LC, RC; postorder = LC, RC, Node; inorder = LC, Node, RC.(Binary Tree).    
        if(root == null)
            return;
        
        inorderTraverse(root.left, traverse);
        traverse.add(root.val);
        inorderTraverse(root.right, traverse);
    
        return;
    }
}