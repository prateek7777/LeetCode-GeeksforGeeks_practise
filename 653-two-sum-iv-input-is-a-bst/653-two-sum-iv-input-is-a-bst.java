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
    HashSet<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null)    //edge case.
            return false;
        //if the difference (k-root.val) exists, then the 2 required nodes exist in the BST.(1 of them, being (root.val), the other being (k-root.val)).
        if(set.contains(k - root.val))   
           return true;
           else
           set.add(root.val);      //just add the node to the set.
           
        return findTarget(root.left, k) || findTarget(root.right, k); //iterating through the left and the right subtree and returning the output.
    }
}