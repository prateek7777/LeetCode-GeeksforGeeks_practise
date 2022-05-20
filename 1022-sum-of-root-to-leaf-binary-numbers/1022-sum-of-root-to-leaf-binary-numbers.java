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
    public int sumRootToLeaf(TreeNode root) {
        int[] sum = {0};   //not int sum = 0, because with each recursive call, the sum will get initialized to 0 and the final answer(sum) will also be 0.
        sRootToLeaf(root, ""+Integer.toString(root.val), sum);  //Concatenating an empty string to root.val in the recursive function call.
        return sum[0];    //returning the int(int[0]).
    }
    
    public void sRootToLeaf(TreeNode root, String currPath, int[] sum){
        //after reaching the leaf node.
        if(root.left == null && root.right == null)
            sum[0] = sum[0] + Integer.parseInt(currPath, 2);  //Integer.parseInt(currPath, 2) converts the string to a decimal number.
        
        if(root.left != null)       //until reaching the leaf(towards left)(before null) in the tree.
            sRootToLeaf(root.left, currPath + Integer.toString(root.left.val), sum);     //root.left.val, not currPath. here, currPath is getting updated in the recursive function call.
        
        if(root.right != null)     //until reaching the leaf(towards right)(before null) in the tree.
            sRootToLeaf(root.right, currPath + Integer.toString(root.right.val), sum);   //root.right.val, not currPath. here, currPath is getting updated in the recursive function call.
        
        return;            //return type is void.
        
    }
}