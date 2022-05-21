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
        String[] leavesOfTree1 = {""};                             //String array of size 1 for constant space.
        String[] leavesOfTree2 = {""};
        
        findLeaves(root1, leavesOfTree1);                          //all leaves of Tree 1.
        findLeaves(root2, leavesOfTree2);                          //all leaves of Tree 2.
        
        return leavesOfTree1[0].equals(leavesOfTree2[0]);          //returns true if equal.
    }
    
    public void findLeaves(TreeNode root, String[] allLeaves){
    
        if(root == null)                                                  //if reached the end.
            return;
        
        if(root.left == null && root.right == null) //if reached the leaf node.
            allLeaves[0] = allLeaves[0] + Integer.toString(root.val) + "-"; //delimiter is compulsory as not all the testcases get passed withuout it.
        //12-1-0 and 1-21-0 are not same, but 1210 and 1210 are same.
        
        findLeaves(root.left, allLeaves);              //if not reached the leaf node, find leaves from the left child.
        findLeaves(root.right, allLeaves);             //if not reached the leaf node, find leaves from the right child.
        return;
    }
}