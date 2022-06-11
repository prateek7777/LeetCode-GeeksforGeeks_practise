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
    public int findTilt(TreeNode root) {
        int[] sum = new int[1];                              //array used because of pass by reference.
        findTiltHelper(root, sum);
        return sum[0];
    }
    public int findTiltHelper(TreeNode root, int[] sum){
     
        if(root == null)                                     //edge case.
            return 0;
        
        int leftSum = findTiltHelper(root.left, sum);        //iterating through the children.
        int rightSum = findTiltHelper(root.right, sum);
        
        sum[0] = sum[0] + Math.abs(leftSum-rightSum);        //requirement.
        
        return leftSum+rightSum+root.val;                    //(root.val) is needed for its upper node.
    }
}