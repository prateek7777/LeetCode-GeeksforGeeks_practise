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
  int max = 0;
    public int maxSumBST(TreeNode root) {
        post(root);
        return max;
    }
    public int[] post(TreeNode root) {

        if (root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] leftSubTree = post(root.left);
        int[] rightSubTree = post(root.right);
        if (root.val > leftSubTree[1] && root.val < rightSubTree[0]) {
            int[] res = new int[3];
            res[0] = Math.min(leftSubTree[0], root.val);
            res[1] = Math.max(rightSubTree[1], root.val);
            res[2] = root.val + leftSubTree[2] + rightSubTree[2];
            max = Math.max(max, res[2]);
            return res;
            
        }

        return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        
    }
}