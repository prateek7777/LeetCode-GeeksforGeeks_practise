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

    public int maxSumBST(TreeNode root) {
     int[] maxSum = {0};
     maxSumBSTHelper(root, maxSum);
     return maxSum[0];
    }
    
    private int[] maxSumBSTHelper(TreeNode root, int[] maxSum){
        
        if(root == null)
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};    //(min, max, size)
        
        int[] leftSubTree = maxSumBSTHelper(root.left, maxSum);
        int[] rightSubTree = maxSumBSTHelper(root.right, maxSum);  
        
        if(!(
                leftSubTree != null &&
                rightSubTree != null &&
                root.val > leftSubTree[1] &&
                root.val < rightSubTree[0]
            ))
            return null;
        
         int sum = leftSubTree[2] + rightSubTree[2] + root.val;
         maxSum[0] = Math.max(sum, maxSum[0]);
        
         int min = Math.min(root.val, leftSubTree[0]);
         int max = Math.max(root.val, rightSubTree[1]);
        
         return new int[]{min, max, sum};
            
    }

}