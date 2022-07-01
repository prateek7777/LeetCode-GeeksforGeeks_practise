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
     int[] maxSum = new int[1];                  //for pass by reference.
     maxSumBSTHelper(root, maxSum);
     return maxSum[0];
    }
    
    private int[] maxSumBSTHelper(TreeNode root, int[] maxSum){
        
        if(root == null)
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0}; //Initialize {min, max, size}(0,1,2) with {Integer.MAX_VALUE, Integer.MIN_VALUE, size} for the null node.
        
        int[] leftSubTree = maxSumBSTHelper(root.left, maxSum);      //left call.
        int[] rightSubTree = maxSumBSTHelper(root.right, maxSum);    //right call.
        
        if(!(
                leftSubTree != null &&         //the leftSubTree must be BST.
                rightSubTree != null &&        //the rightSubTree must be BST.
                root.val > leftSubTree[1] &&   //the root.val should be greater than the maximum value present in the leftSubTree as per BST.
                rightSubTree[0] > root.val     //the minimum value present in the rightSubTree should be greater than the root.val as per BST.
            ))
            return null;                       //if the above conditions are not satisfied, return null.(else go ahead in the function.)
        
         int sum = leftSubTree[2] + rightSubTree[2] + root.val;    //the sum is the addition of the size of leftSubTree, rightSubTree and (root.val).
         maxSum[0] = Math.max(sum, maxSum[0]);                     //as per the problem, calculating the maximum sum.
        
         int min = Math.min(root.val, leftSubTree[0]);    //as per BST, the minimal will be present on the left of the root.
         int max = Math.max(root.val, rightSubTree[1]);   //as per BST, the maximal will be present on the right of the root.
        
         return new int[]{min, max, sum};               //as per the initialization.
            
    }

}