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
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];                 //for pass by reference.
        max[0] = Integer.MIN_VALUE;             //to avoid returning 0 as output when the input is [-3], while the output should be -3.
        maxPathSumGenerate(root, max);
        return max[0];
    }
    
    public int maxPathSumGenerate(TreeNode node, int[] max){
        
        if(node == null)     //whenever the node reaches a null, return 0.
            return 0;
        
        int leftSum = Math.max(0, maxPathSumGenerate(node.left, max));    //if there is negative sum in the left function call, replace it with 0.
        int rightSum = Math.max(0, maxPathSumGenerate(node.right, max));  //if there is negative sum in the right function call, replace it with 0. 
        max[0] = Math.max(max[0], leftSum + rightSum + node.val);         //the max value at each node is determined considering the leftSum, rightSum and the node as well.
        return node.val + Math.max(leftSum, rightSum);                    //we need to find the "max" path sum, hence, we return the maximum of the leftSum and rightSum.
  
    }
    
}