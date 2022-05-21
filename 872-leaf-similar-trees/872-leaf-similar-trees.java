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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        String[] leavesOfTree1 = {""};
        String[] leavesOfTree2 = {""};
        
        findLeaves(root1, leavesOfTree1);
        findLeaves(root2, leavesOfTree2);
        
        return leavesOfTree1[0].equals(leavesOfTree2[0]);
    }
    
    public void findLeaves(TreeNode root, String[] allLeaves){
    
        if(root == null)
            return;
        
        if(root.left == null && root.right == null)
            allLeaves[0] = allLeaves[0] + Integer.toString(root.val) + "-";
        
        findLeaves(root.left, allLeaves);
        findLeaves(root.right, allLeaves);
        return;
    }
    
}